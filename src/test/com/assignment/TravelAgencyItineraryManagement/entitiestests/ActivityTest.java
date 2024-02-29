package com.assignment.TravelAgencyItineraryManagement.entitiestests;

import com.assignment.TravelAgencyItineraryManagement.entities.Activity;
import com.assignment.TravelAgencyItineraryManagement.entities.Destination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.assignment.TravelAgencyItineraryManagement.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class ActivityTest {

    private Activity activity;

    @BeforeEach
    public void setUp() {
        Destination destination = new Destination(DESTINATION_NAME);
        activity = new Activity(ACTIVITY_NAME, ACTIVITY_DESCRIPTION, ACTIVITY_COST, CAPACITY, destination);
    }

    @Test
    public void testActivityInitialization() {
        assertEquals(ACTIVITY_NAME, activity.getName());
    }

    @Test
    public void testActivityDescription() {
        assertEquals(ACTIVITY_DESCRIPTION, activity.getDescription());
    }

    @Test
    public void testActivityCost() {
        assertEquals(ACTIVITY_COST, activity.getCost());
    }

    @Test
    public void testActivityCapacity() {
        assertEquals(CAPACITY, activity.getCapacity());
    }

    @Test
    public void testActivityDestination() {
        assertNotNull(activity.getDestination());
    }

    @Test
    public void testActivityIsFull() {
        assertFalse(activity.isFull());
    }

    @Test
    public void testIsFull() {
        for (int i = 0; i < CAPACITY; i++) {
            activity.signUp();
        }

        assertTrue(activity.isFull());
    }
}

