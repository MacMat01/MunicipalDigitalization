package it.cs.unicam.MunicipalDigitalization.db.controllers.dto.mappers;

import it.cs.unicam.MunicipalDigitalization.api.model.elements.AbstractContent;
import it.cs.unicam.MunicipalDigitalization.api.util.ContentType;
import it.cs.unicam.MunicipalDigitalization.db.controllers.dto.output.ContentOutputDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ContentDTOMapper implements Function<AbstractContent, ContentOutputDTO> {
    @Override
    public ContentOutputDTO apply(AbstractContent abstractContent) {
        String content;
        if (abstractContent.getType().equals(ContentType.LINK)) {
            content = "Link: " + abstractContent.getContent();
        } else if (abstractContent.getType().equals(ContentType.PHOTO)) {
            content = "Photo: " + abstractContent.getContent();
        } else {
            content = "Description: " + abstractContent.getContent();
        }
        return new ContentOutputDTO(
                abstractContent.getId(),
                abstractContent.getName(),
                abstractContent.getType(),
                content,
                abstractContent.getAuthor().getName()
        );
    }
}
