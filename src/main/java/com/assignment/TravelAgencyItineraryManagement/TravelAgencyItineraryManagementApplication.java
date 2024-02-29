package com.assignment.TravelAgencyItineraryManagement;

import com.assignment.TravelAgencyItineraryManagement.services.ActivityService;
import com.assignment.TravelAgencyItineraryManagement.services.DestinationService;
import com.assignment.TravelAgencyItineraryManagement.services.PassengerService;
import com.assignment.TravelAgencyItineraryManagement.services.TravelPackageService;

/**

 The main application class for a travel agency.
 It allows travel agencies to maintain their travel packages' itinerary and passengers.
 This class initializes and manages various services for passengers, activities, destinations, and travel packages.

 @author Darshan Kothari
 */
public class TravelAgencyItineraryManagementApplication {
    PassengerService passengerService;
    ActivityService activityService;
    DestinationService destinationService;
    TravelPackageService travelPackageService;

    /*
    This constructor should be dependency injected as per good coding principles
    In order to keep 3rd party dependencies to a minimum for this simple project,
    this step has been simplified and a no args constructor is created
    */
    public TravelAgencyItineraryManagementApplication() {
        this.passengerService = new PassengerService();
        this.activityService = new ActivityService();
        this.destinationService = new DestinationService();
        this.travelPackageService = new TravelPackageService();
    }

    public static void main(){
        /*
        Code to start up application
        Different services which have been initialised can be used to perform various actions
        like create passenger, create travel package, print itineraries, etc.
        */
    }
}
