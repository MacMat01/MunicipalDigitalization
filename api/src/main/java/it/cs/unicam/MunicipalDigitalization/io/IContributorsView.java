package it.cs.unicam.MunicipalDigitalization.io;

import it.cs.unicam.MunicipalDigitalization.util.ItineraryController;
import it.cs.unicam.MunicipalDigitalization.util.POIController;

/**
 * This interface represents the view of a contributor.
 * It provides methods to create points of interest (POIs) and itineraries, and to get the POI and itinerary controllers.
 */
public interface IContributorsView {

    /**
     * This method is used to create a point of interest (POI).
     * The implementation should handle the creation of a new POI.
     */
    void createPOI();

    /**
     * This method is used to create an itinerary.
     * The implementation should handle the creation of a new itinerary.
     */
    void createItinerary();

    /**
     * This method is used to get the POI controller.
     * The implementation should return the POI controller.
     *
     * @return The POI controller.
     */
    POIController getPOIController();

    /**
     * This method is used to get the itinerary controller.
     * The implementation should return the itinerary controller.
     *
     * @return The itinerary controller.
     */
    ItineraryController getItineraryController();

    /**
     * This method is used to get string input from the user.
     *
     * @param message The message to be displayed to the user.
     * @return The string input from the user.
     */
    String getStringInput(String message);
}