package com.assignment.TravelAgencyItineraryManagement.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents a passenger enrolled in a travel package.
 * Each passenger has a name, passenger number, passenger type, balance (if applicable), and activities signed up for.
 *
 * @author Darshan Kothari
 */

@Getter
@Setter
public class Passenger {
    String name;
    UUID passengerNumber;
    PassengerType passengerType;
    Optional<Double> balance;
    List<Activity> activitiesSignedUp;

    final static double INITIAL_BALANCE = 0.0;

    /**
     * Constructs a new Passenger with the specified name and passenger type.
     * Optionally initializes the balance, if the passenger type is not PREMIUM.
     *
     * @param name The name of the passenger.
     * @param passengerType The type of the passenger (STANDARD, GOLD, or PREMIUM).
     */
    public Passenger(String name, PassengerType passengerType) {
        this.name = name;
        this.passengerType = passengerType;
        this.passengerNumber = UUID.randomUUID();
        this.activitiesSignedUp = new ArrayList<>();
        if(!isPremiumPassenger()) this.balance = Optional.of(INITIAL_BALANCE);
    }

    public boolean isPremiumPassenger() {
        return passengerType.equals(PassengerType.PREMIUM);
    }
}
