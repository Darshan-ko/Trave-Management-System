package com.assignment.TravelAgencyItineraryManagement.services;

import com.assignment.TravelAgencyItineraryManagement.entities.Activity;
import com.assignment.TravelAgencyItineraryManagement.entities.Destination;

import java.util.List;

/**
 * Service class for managing destinations.
 * Provides methods to add activities to destinations.
 *
 * @author Darshan Kothari
 */

public class DestinationService {

    /**
     * Adds an activity to the destination.w
     *
     * @param destination The destination to which the activity will be added.
     * @param activity    The activity to be added.
     * @throws IllegalArgumentException If either the destination or the activity is null.
     */
    public void addActivity(Destination destination, Activity activity) {
        if (destination == null || activity == null) {
            throw new IllegalArgumentException("Destination and activity must not be null.");
        }

        List<Activity> activities = destination.getActivities();
        activities.add(activity);
    }
}
