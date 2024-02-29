package com.assignment.TravelAgencyItineraryManagement.servicestests;

import com.assignment.TravelAgencyItineraryManagement.entities.Activity;
import com.assignment.TravelAgencyItineraryManagement.entities.Destination;
import com.assignment.TravelAgencyItineraryManagement.services.DestinationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.assignment.TravelAgencyItineraryManagement.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DestinationServiceTest {

    private DestinationService destinationService;

    @BeforeEach
    void setUp() {
        destinationService = new DestinationService();
    }

    @Test
    void testAddActivity_ValidInputs_ActivitiesAdded() {
        Destination destination = new Destination(DESTINATION_NAME);
        Activity activity1 = new Activity(ACTIVITY_NAME, ACTIVITY_DESCRIPTION, ACTIVITY_COST, CAPACITY, destination);
        Activity activity2 = activity1;

        destinationService.addActivity(destination, activity1);
        destinationService.addActivity(destination, activity2);

        List<Activity> activities = destination.getActivities();
        assertEquals(2, activities.size(), "Activity should be added to destination 1");
    }

    @Test
    void testAddActivity_ValidInputs_ActivityMatchesInput() {
        Destination destination = new Destination(DESTINATION_NAME);
        Activity activity1 = new Activity(ACTIVITY_NAME, ACTIVITY_DESCRIPTION, ACTIVITY_COST, CAPACITY, destination);
        Activity activity2 = activity1;

        destinationService.addActivity(destination, activity1);
        destinationService.addActivity(destination, activity2);

        List<Activity> activities = destination.getActivities();
        assertEquals(activity1, activities.get(0), "Added activity should match the input activity for destination 1");
        assertEquals(activity2, activities.get(1), "Added activity should match the input activity for destination 2");
    }

    @Test
    void testAddActivity_NullDestination() {
        Activity activity = new Activity(ACTIVITY_NAME, ACTIVITY_DESCRIPTION, ACTIVITY_COST, CAPACITY, null);

        assertThrows(IllegalArgumentException.class, () -> destinationService.addActivity(null, activity));
    }

    @Test
    void testAddActivity_NullActivity() {
        Destination destination = new Destination(DESTINATION_NAME);

        assertThrows(IllegalArgumentException.class, () -> destinationService.addActivity(destination, null));
    }
}
