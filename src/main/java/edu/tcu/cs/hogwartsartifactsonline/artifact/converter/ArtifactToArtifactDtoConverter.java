package edu.tcu.cs.hogwartsartifactsonline.artifact.converter;

import edu.tcu.cs.hogwartsartifactsonline.artifact.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.artifact.dto.ArtifactDto;
import edu.tcu.cs.hogwartsartifactsonline.wizard.converter.WizardtoWizardDtoConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArtifactToArtifactDtoConverter implements Converter<Artifact, ArtifactDto> {

    private final WizardtoWizardDtoConverter wizardtoWizardDtoConverter;

    public ArtifactToArtifactDtoConverter(WizardtoWizardDtoConverter wizardtoWizardDtoConverter) {
        this.wizardtoWizardDtoConverter = wizardtoWizardDtoConverter;
    }

    @Override
    public ArtifactDto convert(Artifact source) {
        ArtifactDto artifactDto = new ArtifactDto(source.getId(),
                                                    source.getName(),
                                                    source.getDescription(),
                                                    source.getImageUrl(),
                                                    source.getOwner() != null
                                                            ? this.wizardtoWizardDtoConverter.convert(source.getOwner())
                                                            : null);
        return artifactDto;
    }
}
