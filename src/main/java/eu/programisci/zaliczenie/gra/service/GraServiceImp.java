package eu.programisci.zaliczenie.gra.service;

import eu.programisci.zaliczenie.gra.converter.Converters;
import eu.programisci.zaliczenie.gra.dto.CritDTO;
import eu.programisci.zaliczenie.gra.dto.GraDTO;
import eu.programisci.zaliczenie.gra.enums.EGatunek;
import eu.programisci.zaliczenie.gra.model.GraOB;
import eu.programisci.zaliczenie.gra.repository.IGraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraServiceImp implements GraService {

    @Autowired
    private Converters converter;
    @Autowired
    private IGraRepository graRepository;

    @Override
    public GraDTO findOne(Long id) {
        return converter.graOBtoDTO(graRepository.findOne(id));
    }
    @Override
    public List<GraDTO> findAll() {
        return converter.graOBlisttoDTOlist(graRepository.findAll());
    }
    @Override
    public void deleteOne(Long id) {
        graRepository.delete(id);
    }
    @Override
    public GraDTO save(GraDTO in) {
        if (in.getId() == null) {
            return converter.graOBtoDTO(create(in));
        } else {
            return converter.graOBtoDTO(update(in));
        }
    }
    private GraOB create(GraDTO in) {
        GraOB ob = converter.graDTOtoOB(in);
        ob.setDataUtworzenia(new Date());
        return graRepository.saveAndFlush(ob);
    }

    private GraOB update(GraDTO dto) {
        GraOB ob = graRepository.findOne(dto.getId());
        ob.setDeveloper(dto.getDeveloper());
        Set<EGatunek> gatunki;
        if(dto.getGatunki()==null) {
            gatunki = new HashSet<>(dto.getGatunki());
        }
        else {
            gatunki = new HashSet<>();
        }
        ob.setGatunki(gatunki);
        ob.setTytul(dto.getTytul());
        ob.setWydania(new HashSet<>(
                converter.wydanieDTOlisttoOBlist(new ArrayList<>(dto.getWydania())))
        );
        return graRepository.save(ob);
    }
    @Override
    public List<GraDTO> saveBatch(List<GraDTO> inList) {
        List<GraDTO> outList = new ArrayList<>();
        for (GraDTO in : inList) {
            outList.add(save((in)));
        }
        return outList;
    }
    @Override
    public List<GraDTO> znajdzStarszeNiz(Integer rokWydania) {
        return converter.graOBlisttoDTOlist(graRepository.znajdzStarszeNiz(rokWydania));
    }
    @Override
    public List<GraDTO> znajdzWgGatunku(EGatunek gatunek) {
        return converter.graOBlisttoDTOlist(graRepository.znajdzWgGatunku(gatunek));
    }
    @Override
    public List<String> znajdzTytulyZawierajace(String partial) {
        return graRepository.znajdzTytulyZawierajace(partial);
    }
    @Override
    public List<GraDTO> znajdzWgGatunkuIRokuWydania(CritDTO critDTO) {
        return converter.graOBlisttoDTOlist(graRepository.znajdzWgGatunkuIRokuWydani(critDTO));
    }
}