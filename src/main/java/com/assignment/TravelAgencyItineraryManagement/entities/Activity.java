package com.assignment.TravelAgencyItineraryManagement.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents an activity available at a destination.
 * Each activity has a name, description, cost, capacity, and destination.
 *
 * @author Darshan Kothari
 */

@Getter
@Setter
public class Activity {
    String name;
    String description;
    double cost;
    int capacity;
    Destination destination;

    /**
     * Constructs a new Activity with the specified details.
     * @param name The name of the activity.
     * @param description The description of the activity.
     * @param cost The cost of the activity.
     * @param capacity The capacity of the activity.
     * @param destination The destination where the activity takes place.
     */
    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
    }

    /**
     * Checks if the activity is full and cannot accommodate more participants.
     *
     * @return True if the activity is full, false otherwise.
     */
    public boolean isFull() {
        return capacity == 0;
    }

    /**
     * Decrease the capacity of the activity by one, indicating that a participant has signed up for the activity.
     */
    public void signUp(){
        capacity--;
    }
}
