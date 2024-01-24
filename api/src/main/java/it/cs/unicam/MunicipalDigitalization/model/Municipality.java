package it.cs.unicam.MunicipalDigitalization.model;

import it.cs.unicam.MunicipalDigitalization.util.Coordinates;
import it.cs.unicam.MunicipalDigitalization.util.ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a municipality for managing points of interest (POIs) and itineraries.
 * It provides methods to check coordinates and names, append and upload POIs and itineraries, and get lists of POIs.
 */
public class Municipality {

    /**
     * The id of the municipality.
     */
    private final ID id;

    /**
     * The territory of the municipality.
     */
    private final Coordinates territory;

    /**
     * List of POIs.
     */
    private final List<IPOI> listOfPOIs;

    /**
     * List of itineraries.
     */
    private final List<IItinerary> listOfItineraries;

    /**
     * The name of the municipality.
     */
    private final String name;
    /**
     * The manager for pending POIs and itineraries.
     */
    private final PendingManager pendingManager;
    /**
     * List of users.
     */
    private List<User> listOfUsers;

    /**
     * Constructor for the Municipality class.
     * It initializes the Municipality with the provided territory.
     *
     * @param territory The territory of the municipality.
     */
    public Municipality(Coordinates territory, String name) {
        this.name = name;
        this.listOfPOIs = new ArrayList<>();
        this.listOfItineraries = new ArrayList<>();
        this.territory = territory;
        this.id = new ID();
        this.pendingManager = new PendingManager(this);
    }

    /**
     * This method is used to check if the coordinates are valid.
     *
     * @param coordinates The coordinates to check.
     * @return True if the coordinates are valid, false otherwise.
     */
    public boolean checkCoordinates(Coordinates coordinates) {
        // TODO - implement Municipality.checkCoordinates
        throw new UnsupportedOperationException();
    }

    /**
     * This method is used to check if the name is valid.
     *
     * @param name The name to check.
     * @return True if the name is valid, false otherwise.
     */
    private boolean checkName(String name) {
        // TODO - implement Municipality.checkName
        throw new UnsupportedOperationException();
    }

    /**
     * This method is used to append a pending POI to the list of POIs.
     *
     * @param pendingPOI The pending POI to append.
     */
    public void appendPOI(PendingPOI pendingPOI) {
        this.pendingManager.addPOI(pendingPOI);
    }

    /**
     * This method is used to upload a POI to the municipality.
     *
     * @param poi The POI to upload.
     */
    private void uploadPOI(IPOI poi) {
        if (!this.listOfPOIs.contains(poi)) this.listOfPOIs.add(poi);
    }

    /**
     * This method is used to upload an itinerary to the municipality.
     *
     * @param itinerary The itinerary to upload.
     */
    private void uploadItinerary(IItinerary itinerary) {
        if (!listOfItineraries.contains(itinerary)) listOfItineraries.add(itinerary);
    }

    /**
     * This method is used to append a pending itinerary to the list of itineraries.
     *
     * @param pendingItinerary The pending itinerary to append.
     */
    public void appendItinerary(PendingItinerary pendingItinerary) {
        this.pendingManager.addPendingItinerary(pendingItinerary);
    }

    /**
     * This method is used to get the list of POIs.
     *
     * @return The list of POIs.
     */
    public List<IPOI> getPOIList() {
        return this.listOfPOIs;
    }


    /**
     * This method is used to get the list of pending POIs.
     *
     * @return The list of pending POIs.
     */
    public List<PendingPOI> getPendingPoiList() {
        return this.pendingManager.getListOfPendingPOI();
    }

    /**
     * This method is used to get the list of pending itineraries.
     *
     * @return The list of pending itineraries.
     */
    public List<PendingItinerary> getPendingItineraryList() {
        return this.pendingManager.getListOfPendingItinerary();
    }

    /**
     * This method is used to get the list of itineraries.
     *
     * @return The list of itineraries.
     */
    public List<IItinerary> getItineraryList() {
        return this.listOfItineraries;
    }

    /**
     * equals of the class based on the ID of the Municipality and the territory where is situated
     *
     * @param o the object to compare
     * @return true if they are equals.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipality municipality = (Municipality) o;
        return Objects.equals(id, municipality.id) && Objects.equals(territory, municipality.territory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, territory);
    }
}