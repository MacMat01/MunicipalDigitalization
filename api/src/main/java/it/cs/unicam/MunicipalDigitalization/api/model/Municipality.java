package it.cs.unicam.MunicipalDigitalization.api.model;

import it.cs.unicam.MunicipalDigitalization.api.model.actors.IUser;
import it.cs.unicam.MunicipalDigitalization.api.model.elements.*;
import it.cs.unicam.MunicipalDigitalization.api.util.Coordinate;
import it.cs.unicam.MunicipalDigitalization.api.util.ID;
import it.cs.unicam.MunicipalDigitalization.api.util.PendingManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a municipality for managing points of interest (POIs) and itineraries.
 * It provides methods to contains coordinates and names, append and upload POIs and itineraries, and get lists of POIs.
 */
public class Municipality {

    /**
     * The id of the municipality.
     */
    private final ID id;

    /**
     * The territory of the municipality.
     */
    private final Coordinate territory;

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
    private List<IUser> listOfIUsers;

    /**
     * Constructor for the Municipality class.
     * It initializes the Municipality with the provided territory.
     *
     * @param territory The territory of the municipality.
     */
    public Municipality(Coordinate territory, String name) {
        this.name = name;
        this.listOfPOIs = new ArrayList<>();
        this.listOfItineraries = new ArrayList<>();
        this.territory = territory;
        this.id = new ID();
        this.pendingManager = new PendingManager(this);
    }

    /**
     * This method is used to contains if the coordinate are valid.
     *
     * @param coordinate The coordinate to contains.
     * @return True if the coordinate are valid, false otherwise.
     */
    public boolean checkCoordinates(Coordinate coordinate) {
        // TODO - implement Municipality.checkCoordinates
        throw new UnsupportedOperationException();
    }

    /**
     * This method is used to contains if the name is valid.
     *
     * @param name The name to contains.
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
        this.pendingManager.addPendingPOI(pendingPOI);
    }

    /**
     * This method is used to upload a POI to the municipality.
     *
     * @param poi The POI to upload.
     */
    public void uploadPOI(IPOI poi) {
        if (!this.listOfPOIs.contains(poi)) this.listOfPOIs.add(poi);
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
     * This method is used to upload an itinerary to the municipality.
     *
     * @param itinerary The itinerary to upload.
     */
    public void uploadItinerary(IItinerary itinerary) {
        if (!listOfItineraries.contains(itinerary)) listOfItineraries.add(itinerary);
    }

    /**
     * This method is used to append a pending content to the list of contents.
     *
     * @param pendingContent The pending content to append.
     */
    public void appendContent(PendingContent pendingContent) {
        this.pendingManager.addPendingContent(pendingContent);
    }

    /**
     * This method is used to upload a content to the municipality.
     *
     * @param content The content to upload.
     */
    public void uploadContent(IContent content) {
        if (!content.getReferredMunicipalElement().listOfContents().contains(content)) {
            content.getReferredMunicipalElement().listOfContents().add(content);
        }
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
     * This method is used to get the list of itineraries.
     *
     * @return The list of itineraries.
     */
    public List<IItinerary> getItineraryList() {
        return this.listOfItineraries;
    }

    /**
     * This method is used to get the specific details of a POI present in the Municipality
     *
     * @return a String with the specific Details of the POI
     */
    public String getPOIFullInfo(String id) {
        // TODO - implement Municipality.getPOIFullInfo
        throw new UnsupportedOperationException();
    }

    /**
     * This method is used to get the specific Details of an Itinerary present in the Municipality
     *
     * @return a String with the specific Details of the POI.
     */
    public String getItineraryFullInfo(String id) {
        // TODO - implement Municipality.getItineraryFullInfo
        throw new UnsupportedOperationException();
    }

    /**
     * This method is used to get the specific Details of a Content present in the Municipality
     *
     * @return a String with the specific Details of the Content.
     */
    public String getContentInformation(String id) {
        // TODO - implement Municipality.getContentInformation
        throw new UnsupportedOperationException();
    }

    /**
     * This method is used to get the general information of the POIs present in the Municipality
     *
     * @return a String with the Name, Coordinate and ID of every POI.
     */
    public String getPOIs() {
        StringBuilder element = new StringBuilder();
        for (IPOI p : this.listOfPOIs) {
            element.append("Name: ").append(p.getName()).append("\nID: ").append(p.getId()).append("\n\n");
        }

        return element.toString();
    }

    /**
     * This method is used to get the information of the Itineraries present in the Municipality
     *
     * @return a String with the Name and ID of every itinerary-
     */
    public String getItineraries() {
        StringBuilder element = new StringBuilder();
        for (IItinerary i : this.listOfItineraries) {
            element.append("Name: ").append(i.getName()).append("\nID: ").append(i.getId()).append("\n\n");
        }
        return element.toString();
    }

    /**
     * Getter fot the PendingManager of the Municipality
     *
     * @return the PendingManager of the Municipality
     */
    public PendingManager getPendingManager() {
        return pendingManager;
    }

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