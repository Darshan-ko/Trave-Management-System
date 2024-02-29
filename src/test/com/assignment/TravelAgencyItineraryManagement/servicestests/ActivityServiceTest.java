package com.assignment.TravelAgencyItineraryManagement.servicestests;

import com.assignment.TravelAgencyItineraryManagement.entities.Activity;
import com.assignment.TravelAgencyItineraryManagement.entities.Passenger;
import com.assignment.TravelAgencyItineraryManagement.entities.PassengerType;
import com.assignment.TravelAgencyItineraryManagement.services.ActivityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.assignment.TravelAgencyItineraryManagement.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ActivityServiceTest {

    private ActivityService activityService;
    private Activity activity;

    @BeforeEach
    void setUp() {
        activityService = new ActivityService();
        activity = new Activity(ACTIVITY_NAME, ACTIVITY_DESCRIPTION, ACTIVITY_COST, CAPACITY, null);
    }

    @Test
    void testGetPriceForPassenger_Standard() {
        Passenger passenger = new Passenger(PASSENGER_NAME, PassengerType.STANDARD);

        assertEquals(ACTIVITY_COST, activityService.getPriceForPassenger(activity, PassengerType.STANDARD),
                "Price for standard passenger should be equal to activity cost");
    }

    @Test
    void testGetPriceForPassenger_Gold() {
        Passenger passenger = new Passenger(PASSENGER_NAME, PassengerType.GOLD);

        assertEquals(0.9*ACTIVITY_COST, activityService.getPriceForPassenger(activity, PassengerType.GOLD),
                "Price for gold passenger should be 10% less than activity cost");
    }

    @Test
    void testGetPriceForPassenger_Premium() {
        Passenger passenger = new Passenger(PASSENGER_NAME, PassengerType.PREMIUM);
        assertEquals(0.0,  activityService.getPriceForPassenger(activity, PassengerType.PREMIUM),
                "Price for premium passenger should be 0");
    }

    @Test
    void testGetPriceForPassenger_NullPassenger() {
        //Verify IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> activityService.getPriceForPassenger(activity, null));
    }

    @Test
    void testGetPriceForPassenger_NullActivity() {
        Passenger passenger = new Passenger(PASSENGER_NAME, PassengerType.STANDARD);
        //Verify IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> activityService.getPriceForPassenger(null, PassengerType.STANDARD));
    }

    @Test
    void testSignUpPassenger_NullActivity() {
        Passenger passenger = new Passenger(PASSENGER_NAME, PassengerType.STANDARD);
        //Verify IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> activityService.signUpPassenger(null));
    }
}

