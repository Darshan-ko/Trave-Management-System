package com.assignment.TravelAgencyItineraryManagement.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a destination included in a travel package.
 * Each destination has a name and a list of activities available at that destination.
 *
 * @author Darshan Kothari
 */

@Getter
@Setter
public class Destination {
    String name;
    List<Activity> activities;

    /**
     * Constructs a new Destination with the specified name.
     * @param name The name of the destination.
     */
    public Destination(String name) {
        this.name = name;
        activities = new ArrayList<>();
    }
}
