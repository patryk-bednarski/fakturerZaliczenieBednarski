package eu.programisci.zaliczenie.gra.service;

import eu.programisci.zaliczenie.gra.dto.CritDTO;
import eu.programisci.zaliczenie.gra.dto.GraDTO;
import eu.programisci.zaliczenie.gra.enums.EGatunek;

import java.util.List;

public interface GraService {

    GraDTO findOne(Long id);

    List<GraDTO> findAll();

    void deleteOne(Long id);

    GraDTO save(GraDTO graDTO);

    List<GraDTO> saveBatch(List<GraDTO> graDTO);

    List<GraDTO> znajdzStarszeNiz(Integer rokWydania);

    List<GraDTO> znajdzWgGatunku(EGatunek gatunek);

    List<String> znajdzTytulyZawierajace(String partial);

    List<GraDTO> znajdzWgGatunkuIRokuWydania(CritDTO critDTO);
}
