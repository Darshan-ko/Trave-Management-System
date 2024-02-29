package com.assignment.TravelAgencyItineraryManagement.servicestests;

import com.assignment.TravelAgencyItineraryManagement.entities.Activity;
import com.assignment.TravelAgencyItineraryManagement.entities.Destination;
import com.assignment.TravelAgencyItineraryManagement.entities.Passenger;
import com.assignment.TravelAgencyItineraryManagement.entities.PassengerType;
import com.assignment.TravelAgencyItineraryManagement.services.ActivityService;
import com.assignment.TravelAgencyItineraryManagement.services.PassengerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.assignment.TravelAgencyItineraryManagement.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerServiceTest {

    private PassengerService passengerService;
    private Passenger passenger;
    private Activity activity;
    private ActivityService activityService;

    @BeforeEach
    public void setUp() {
        passengerService = new PassengerService();
        passenger = new Passenger(PASSENGER_NAME, PassengerType.STANDARD);
        activity = new Activity(ACTIVITY_NAME, ACTIVITY_DESCRIPTION, ACTIVITY_COST,
                                CAPACITY, new Destination(DESTINATION_NAME));
        activityService = new ActivityService();
    }

    @Test
    public void testSignUpForActivity_SuccessfulSignUp() {
        passenger.setBalance(Optional.of(1000.0));
        passengerService.signUpForActivity(passenger, activity);

        assertTrue(passenger.getActivitiesSignedUp().contains(activity));
    }

    @Test
    public void testSignUpForActivity_InsufficientBalance() {
        passenger.setBalance(Optional.of(10.0));
        passengerService.signUpForActivity(passenger, activity);

        assertFalse(passenger.getActivitiesSignedUp().contains(activity));
    }

    @Test
    public void testSignUpForActivity_NullPassenger() {
        //Verify IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> passengerService.signUpForActivity(null, activity));
    }

    @Test
    public void testSignUpForActivity_NullActivity() {
        //Verify IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> passengerService.signUpForActivity(passenger, null));
    }
}
