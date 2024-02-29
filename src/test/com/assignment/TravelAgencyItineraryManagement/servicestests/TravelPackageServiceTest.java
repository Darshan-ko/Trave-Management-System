package com.assignment.TravelAgencyItineraryManagement.servicestests;

import com.assignment.TravelAgencyItineraryManagement.entities.Destination;
import com.assignment.TravelAgencyItineraryManagement.entities.Passenger;
import com.assignment.TravelAgencyItineraryManagement.entities.PassengerType;
import com.assignment.TravelAgencyItineraryManagement.entities.TravelPackage;
import com.assignment.TravelAgencyItineraryManagement.services.TravelPackageService;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.assignment.TravelAgencyItineraryManagement.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TravelPackageServiceTest {

    private TravelPackageService travelPackageService;
    private TravelPackage travelPackage;

    @BeforeEach
    void setUp() {
        travelPackageService = new TravelPackageService();
        travelPackage = new TravelPackage(TRAVEL_PACKAGE, CAPACITY, new ArrayList<>());
    }

    @ParameterizedTest
    @MethodSource("provideDestinations")
    void addDestination_ValidInputs_DestinationAddedToItinerary(Destination destination) {
        travelPackageService.addDestination(travelPackage, destination);

        List<Destination> itinerary = travelPackage.getItinerary();

        assertEquals(1, itinerary.size());
        assertEquals(destination, itinerary.get(0));
    }

    private static Stream<Arguments> provideDestinations() {
        return Stream.of(
                Arguments.of(new Destination(RandomStringUtils.randomAlphabetic(10))),
                Arguments.of(new Destination(RandomStringUtils.randomAlphabetic(10))),
                Arguments.of(new Destination(RandomStringUtils.randomAlphabetic(10)))
        );
    }

    @Test
    void signUpPassenger_ValidInputs_PassengerAddedToTravelPackage() {
        Passenger passenger = new Passenger("John Doe", PassengerType.STANDARD);

        travelPackageService.signUpPassenger(travelPackage, passenger);

        List<Passenger> passengers = travelPackage.getPassengers();
        assertEquals(1, passengers.size());
        assertEquals(passenger, passengers.get(0));
    }

    @Test
    void addDestination_NullTravelPackage_ThrowsIllegalArgumentException() {
        Destination destination = new Destination(DESTINATION_NAME);

        assertThrows(IllegalArgumentException.class, ()
                        -> travelPackageService.addDestination(null, destination));
    }

    @Test
    void signUpPassenger_NullTravelPackage_ThrowsIllegalArgumentException() {
        Passenger passenger = new Passenger(PASSENGER_NAME, PassengerType.STANDARD);

        assertThrows(IllegalArgumentException.class, ()
                        -> travelPackageService.signUpPassenger(null, passenger));
    }
}
