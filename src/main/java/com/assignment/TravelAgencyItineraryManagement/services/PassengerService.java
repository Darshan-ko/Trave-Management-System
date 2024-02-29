package com.assignment.TravelAgencyItineraryManagement.services;

import com.assignment.TravelAgencyItineraryManagement.entities.Activity;
import com.assignment.TravelAgencyItineraryManagement.entities.Passenger;
import com.assignment.TravelAgencyItineraryManagement.entities.PassengerType;

import java.util.Optional;

/**
 * Service class for managing passengers.
 * Provides methods for printing passenger details and signing up passengers for activities.
 */

public class PassengerService {
    private ActivityService activityService;

    public PassengerService() {
        this.activityService = new ActivityService();
    }

    /**
     * Prints the details of the specified passenger and details of all the activities he/she signed up for.
     *
     */
    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if(passenger.isPremiumPassenger()) {
            System.out.println("You are a premium passenger! You have unlimited balance");
        }
        else {
            System.out.println("Balance: " + passenger.getBalance());
        }
        System.out.println("Activities Signed Up:");
        for (Activity activity : passenger.getActivitiesSignedUp()) {
            System.out.println("Destination: " + activity.getDestination().getName());
            System.out.println("Activity: " + activity.getName());
            System.out.println("Price Paid: " + activityService.getPriceForPassenger(activity, passenger.getPassengerType()));
        }
    }

    /**
     * Signs up the passenger for an activity if there is sufficient capacity.
     *
     * @param passenger The passenger to sign up for the activity.
     * @param activity  The activity to be signed up for.
     * @throws IllegalArgumentException If the passenger or activity is null, or if the passenger has insufficient balance.
     */
    public void signUpForActivity(Passenger passenger, Activity activity) {
        if (passenger == null || activity == null) {
            throw new IllegalArgumentException("Passenger and activity must not be null.");
        }

        double price = activityService.getPriceForPassenger(activity, passenger.getPassengerType());
        Optional<Double> balance = passenger.getBalance();
        if (balance.isPresent() && balance.get() < price) {
            System.out.println("Oops! You have insufficient balance.");
            return;
        }

        try {
            activityService.signUpPassenger(activity);
            balance.ifPresent(currentBalance -> {
                double newBalance = currentBalance - price;
                passenger.setBalance(Optional.of(newBalance));
            });
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }

        passenger.getActivitiesSignedUp().add(activity);
    }
}
