package it.cs.unicam.MunicipalDigitalization.db.mappers;

import it.cs.unicam.MunicipalDigitalization.api.model.elements.AbstractItinerary;
import it.cs.unicam.MunicipalDigitalization.api.model.elements.AbstractMunicipalElement;
import it.cs.unicam.MunicipalDigitalization.db.controllers.dto.output.ItineraryOutputDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ItineraryDTOMapper implements Function<AbstractItinerary, ItineraryOutputDTO> {
    @Override
    public ItineraryOutputDTO apply(AbstractItinerary abstractItinerary) {
        return new ItineraryOutputDTO(
                abstractItinerary.getId(),
                abstractItinerary.getName(),
                abstractItinerary.getMunicipality().getName(),
                abstractItinerary.getTypes(),
                abstractItinerary.getDescription(),
                abstractItinerary.getCoordinate(),
                abstractItinerary.getCreationDate(),
                abstractItinerary.getPOIs().stream().map(AbstractMunicipalElement::getName).toList().toString()
        );
    }
}