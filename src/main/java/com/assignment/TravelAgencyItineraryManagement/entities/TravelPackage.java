package com.assignment.TravelAgencyItineraryManagement.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a travel package offered by a travel agency.
 * Each package includes a name, passenger capacity, itinerary (list of destinations), and list of passengers.
 *
 * @author Darshan Kothari
 */

@Getter
@Setter
public class TravelPackage{
    String name;
    int passengerCapacity;
    List<Destination> itinerary;
    List<Passenger> passengers;

    /**
     * Constructs a new TravelPackage with the specified name and passenger capacity.
     * @param name The name of the travel package.
     * @param passengerCapacity The passenger capacity of the travel package.
     * @param itinerary The list of destinations in this travel package.
     */
    public TravelPackage(String name, int passengerCapacity, List<Destination> itinerary) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = itinerary;
        this.passengers = new ArrayList<>(passengerCapacity);
    }

    /**
     * Checks if the travel package is full and cannot accommodate more participants.
     *
     * @return True if the activity is full, false otherwise.
     */
    public boolean isFull() {
        return passengerCapacity == 0;
    }

    /**
     * Decrease the capacity of the travel package by one, indicating that a passenger has signed up for it.
     */
    public void signUp(){
        passengerCapacity--;
    }

    /**
     * Prints the itinerary of the travel package including destinations and details of activities.
     */
    public void printItinerary(){
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Description: " + activity.getDescription());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
            }
        }
    }

    /**
     * Prints the list of passengers enrolled in the travel package.
     */
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger Name: " + passenger.getName());
            System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        }
    }
}