package com.assignment.TravelAgencyItineraryManagement.entitiestests;

import com.assignment.TravelAgencyItineraryManagement.entities.Destination;
import com.assignment.TravelAgencyItineraryManagement.entities.TravelPackage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.TravelAgencyItineraryManagement.TestConstants.CAPACITY;
import static com.assignment.TravelAgencyItineraryManagement.TestConstants.DESTINATION_NAME;
import static org.junit.jupiter.api.Assertions.*;

public class TravelPackageTest {

    private TravelPackage travelPackage;

    @BeforeEach
    public void setUp() {
        List<Destination> itinerary = new ArrayList<>();
        Destination destination = new Destination(DESTINATION_NAME);
        itinerary.add(destination);
        travelPackage = new TravelPackage("TravelPackageName", CAPACITY, itinerary);
    }

    @Test
    public void testTravelPackageInitialization() {
        assertEquals("TravelPackageName", travelPackage.getName());
    }

    @Test
    public void testItineraryNotEmpty() {
        assertFalse(travelPackage.getItinerary().isEmpty());
    }

    @Test
    public void testItinerarySize() {
        assertEquals(1, travelPackage.getItinerary().size());
    }

    @Test
    public void testIsFull() {
        assertFalse(travelPackage.isFull());
    }

    @Test
    public void testSignUp() {
        travelPackage.signUp();
        assertEquals(CAPACITY-1, travelPackage.getPassengerCapacity());
    }

    @Test
    public void testPrintItinerary() {
        assertDoesNotThrow(() -> travelPackage.printItinerary());
    }

    @Test
    public void testPrintPassengerList() {
        assertDoesNotThrow(() -> travelPackage.printPassengerList());
    }
}
