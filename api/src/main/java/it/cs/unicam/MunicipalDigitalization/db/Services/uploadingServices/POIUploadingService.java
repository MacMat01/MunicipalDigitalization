package it.cs.unicam.MunicipalDigitalization.db.Services.uploadingServices;

import it.cs.unicam.MunicipalDigitalization.api.util.DesignPattern.Builder.POIBuilder;
import it.cs.unicam.MunicipalDigitalization.api.util.DesignPattern.FactoryMethod.POIBuilderFactory;
import it.cs.unicam.MunicipalDigitalization.db.Services.Mediators.POIMediator;
import it.cs.unicam.MunicipalDigitalization.db.Services.MunicipalService;
import it.cs.unicam.MunicipalDigitalization.db.Services.UserService;
import it.cs.unicam.MunicipalDigitalization.db.controllers.dto.POIDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for uploading POIs to the database
 */
@Service
public class POIUploadingService {
    private final MunicipalService municipalService;
    private final UserService userService;
    private final POIMediator poiMediator;
    private final POIBuilderFactory poiBuilderFactory;

    @Autowired
    public POIUploadingService(MunicipalService municipalService, UserService userService, POIMediator poiMediator,
                               POIBuilderFactory poiBuilderFactory) {
        this.municipalService = municipalService;
        this.userService = userService;
        this.poiMediator = poiMediator;
        this.poiBuilderFactory = poiBuilderFactory;
    }

    /**
     * Uploads a POI to the database
     *
     * @param poiDTO the POI to be uploaded
     */

    public void uploadPOI(POIDTO poiDTO){
        checkPOI(poiDTO);
        POIBuilder builder = poiBuilderFactory.createBuilderForUser(userService.getUserById(poiDTO.author()));
        buildPOI(builder, poiDTO);
        poiMediator.savePOI(builder.build());
    }

    /**
     * Builds a POI from a DTO using the right builder
     *
     * @param poiBuilder the builder to be used
     * @param poidto the DTO to be used
     */
    private void buildPOI(POIBuilder poiBuilder, POIDTO poidto){
        poiBuilder.setPOIAuthor(userService.getUserById(poidto.author()));
        poiBuilder.setPOICoordinates(poidto.coordinate());
        poiBuilder.setPOIName(poidto.name());
        poiBuilder.setPOIType(poidto.poiType());
        poiBuilder.setPOIStatus();
        municipalService.findMunicipalByID(poidto.municipalityID()).ifPresent(poiBuilder::setPOIMunicipality);
    }

    /**
     * Checks if the POI is valid
     *
     * @param poiDTO the POI to be checked
     */
    private void checkPOI(POIDTO poiDTO) {
        //TODO
    }
}
