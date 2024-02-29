package com.assignment.TravelAgencyItineraryManagement.entitiestests.PassengerTest;

import com.assignment.TravelAgencyItineraryManagement.entities.Passenger;
import com.assignment.TravelAgencyItineraryManagement.entities.PassengerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.assignment.TravelAgencyItineraryManagement.TestConstants.INITIAL_BALANCE;
import static com.assignment.TravelAgencyItineraryManagement.TestConstants.PASSENGER_NAME;
import static org.junit.jupiter.api.Assertions.*;

public class GoldPassengerTest {

    private Passenger passenger;

    @BeforeEach
    public void setUp() {
        passenger = new Passenger(PASSENGER_NAME, PassengerType.GOLD);
    }

    @Test
    public void testPassengerNameInitialization() {
        assertEquals(PASSENGER_NAME, passenger.getName());
    }

    @Test
    public void testPassengerTypeInitialization() {
        assertEquals(PassengerType.GOLD, passenger.getPassengerType());
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