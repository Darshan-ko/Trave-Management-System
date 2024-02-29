package com.assignment.TravelAgencyItineraryManagement.services;

import com.assignment.TravelAgencyItineraryManagement.entities.Destination;
import com.assignment.TravelAgencyItineraryManagement.entities.Passenger;
import com.assignment.TravelAgencyItineraryManagement.entities.TravelPackage;

import java.util.List;

/**
 * Service class for managing travel packages.
 * Provides methods for adding destinations to the itinerary and signing up passengers for a travel package.
 *
 * @author Darshan Kothari
 */
public class TravelPackageService {

    /**
     * Adds a destination to the itinerary of the travel package.
     *
     * @param travelPackage The travel package to which the destination will be added.
     * @param destination   The destination to be added.
     * @throws IllegalArgumentException If the travel package or destination is null.
     */
    public void addDestination(TravelPackage travelPackage, Destination destination) throws IllegalArgumentException {
        if (travelPackage == null || destination == null) {
            throw new IllegalArgumentException("Travel package and destination must not be null.");
        }

        List<Destination> itinerary = travelPackage.getItinerary();
        itinerary.add(destination);
        travelPackage.setItinerary(itinerary);
    }

    /**
     * Signs up a passenger for the travel package.
     *
     * @param travelPackage The travel package to which the passenger will be signed up.
     * @param passenger     The passenger to be added.
     * @throws IllegalArgumentException If the travel package or passenger is null.
     */
    public void signUpPassenger(TravelPackage travelPackage, Passenger passenger) throws IllegalArgumentException {
        if (travelPackage == null || passenger == null) {
            throw new IllegalArgumentException("Travel package and passenger must not be null.");
        }

        List<Passenger> passengers = travelPackage.getPassengers();
        travelPackage.signUp();
        passengers.add(passenger);
        travelPackage.setPassengers(passengers);
    }
}
