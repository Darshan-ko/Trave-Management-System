package com.assignment.TravelAgencyItineraryManagement.services;

import com.assignment.TravelAgencyItineraryManagement.entities.Activity;
import com.assignment.TravelAgencyItineraryManagement.entities.PassengerType;

/**
 * Service class for managing activities.
 * Provides methods for calculating prices for passengers and signing up passengers for activities.
 *
 * @author Darshan Kothari
 */

public class ActivityService {

    /**
     * Calculates the price of the activity for a specific passenger based on their passenger type.
     *
     * @param activity  The activity for which to calculate the price.
     * @param passengerType The type of passenger for whom to calculate the price.
     * @return The price of the activity for the specified passenger.
     * @throws IllegalArgumentException If either the activity or the passenger type is null.
     */
    public double getPriceForPassenger(Activity activity, PassengerType passengerType) {
        if (passengerType == null || activity == null) {
            throw new IllegalArgumentException("Passenger Type and activity must not be null.");
        }

        double cost = activity.getCost();
        return switch (passengerType) {
            case STANDARD -> cost;
            case GOLD -> cost * 0.9;
            case PREMIUM -> 0;
            default -> throw new IllegalArgumentException("Invalid passenger type");
        };
    }

    /**
     * Signs up a passenger for the activity.
     * @throws IllegalArgumentException If the activity is null or full.
     */
    public void signUpPassenger(Activity activity){
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null.");
        }
        if(activity.isFull()){
            throw new IllegalArgumentException("Activity is full.");
        }
        activity.signUp();
        System.out.println("You have been successfully signed up for activity: " + activity.getName());
    }
}