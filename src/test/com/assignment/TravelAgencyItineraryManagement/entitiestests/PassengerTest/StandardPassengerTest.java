package com.assignment.TravelAgencyItineraryManagement.entitiestests.PassengerTest;

import com.assignment.TravelAgencyItineraryManagement.entities.Passenger;
import com.assignment.TravelAgencyItineraryManagement.entities.PassengerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.assignment.TravelAgencyItineraryManagement.TestConstants.INITIAL_BALANCE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StandardPassengerTest {

    private Passenger passenger;

    @BeforeEach
    public void setUp() {
        passenger = new Passenger("Darshan Kothari", PassengerType.STANDARD);
    }

    @Test
    public void testPassengerNameInitialization() {
        assertEquals("Darshan Kothari", passenger.getName());
    }

    @Test
    public void testPassengerTypeInitialization() {
         assertEquals(PassengerType.STANDARD, passenger.getPassengerType());
    }

    @Test
    public void testPassengerNumberInitialization() {
        assertNotNull(passenger.getPassengerNumber());
    }

    @Test
    public void testPassengerBalanceInitialization() {
        assertEquals(Optional.of(INITIAL_BALANCE), passenger.getBalance());
    }
}
