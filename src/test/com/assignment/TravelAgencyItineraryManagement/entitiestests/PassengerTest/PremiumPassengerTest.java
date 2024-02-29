package com.assignment.TravelAgencyItineraryManagement.entitiestests.PassengerTest;

import com.assignment.TravelAgencyItineraryManagement.entities.Passenger;
import com.assignment.TravelAgencyItineraryManagement.entities.PassengerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.assignment.TravelAgencyItineraryManagement.TestConstants.PASSENGER_NAME;
import static org.junit.jupiter.api.Assertions.*;

public class PremiumPassengerTest {

    private Passenger passenger;

    @BeforeEach
    public void setUp() {
        passenger = new Passenger(PASSENGER_NAME, PassengerType.PREMIUM);
    }

    @Test
    public void testPassengerNameInitialization() {
        assertEquals(PASSENGER_NAME, passenger.getName());
    }

    @Test
    public void testPassengerTypeInitialization() {
        assertEquals(PassengerType.PREMIUM, passenger.getPassengerType());
    }

    @Test
    public void testPassengerNumberInitialization() {
        assertNotNull(passenger.getPassengerNumber());
    }

    @Test
    public void testPassengerBalanceInitialization() {
        assertNull(passenger.getBalance());
    }
}
