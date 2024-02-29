package com.assignment.TravelAgencyItineraryManagement.entitiestests;

import com.assignment.TravelAgencyItineraryManagement.entities.Destination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DestinationTest {

    private Destination destination;

    @BeforeEach
    public void setUp() {
        // Initialize the Destination object before each test
        destination = new Destination("DestinationName");
    }

    @Test
    public void testDestinationInitialization() {
        // Verify destination name after initialization
        assertEquals("DestinationName", destination.getName());
    }

    @Test
    public void testActivitiesListInitialization() {
        // Verify activities list is initialized and empty after initialization
        assertTrue(destination.getActivities().isEmpty());
    }
}
