package eu.programisci.zaliczenie.gra.converter;

import eu.programisci.zaliczenie.gra.dto.GraDTO;
import eu.programisci.zaliczenie.gra.dto.WydanieDTO;
import eu.programisci.zaliczenie.gra.model.GraOB;
import eu.programisci.zaliczenie.gra.model.WydanieOB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class Converters {

    public GraDTO graOBtoDTO(GraOB in) {
        GraDTO out = new GraDTO();
        out.setId(in.getId());
        out.setTytul(in.getTytul());
        out.setGatunki(new ArrayList<>(in.getGatunki()));
        out.setDeveloper(in.getDeveloper());
        out.setWydania(new HashSet<>(
                wydanieOBlisttoDTOlist(new ArrayList<>(in.getWydania()))
        ));
        return out;
    }
    public GraOB graDTOtoOB(GraDTO in) {
        GraOB out = new GraOB();
        out.setId(in.getId());
        out.setTytul(in.getTytul());
        out.setGatunki(new HashSet<>(in.getGatunki()));
        out.setDeveloper(in.getDeveloper());
        out.setWydania(new HashSet<>(
                wydanieDTOlisttoOBlist(new ArrayList<>(in.getWydania()))));
        return out;
    }

    public WydanieDTO wydanieOBtoDTO(WydanieOB in) {
        WydanieDTO out = new WydanieDTO();
        out.setId(in.getId());
        out.setWydawca(in.getWydawca());
        out.setPlatforma(in.getPlatforma());
        out.setRokWydania(in.getRokWydania());
        return out;
    }

    public WydanieOB wydanieDTOtoOB(WydanieDTO in) {
        WydanieOB out = new WydanieOB();
        out.setId(in.getId());
        out.setWydawca(in.getWydawca());
        out.setPlatforma(in.getPlatforma());
        out.setRokWydania(in.getRokWydania());
        return out;
    }

    public List<WydanieDTO> wydanieOBlisttoDTOlist(List<WydanieOB> inList) {
        if (inList == null) {
            return null;
        }
        List<WydanieDTO> outList = new ArrayList<>();
        for (WydanieOB in : inList) {
            outList.add(wydanieOBtoDTO(in));
        }
        return outList;
    }

    public List<WydanieOB> wydanieDTOlisttoOBlist(List<WydanieDTO> inList) {
        if (inList == null) {
            return null;
        }
        List<WydanieOB> outList = new ArrayList<>();
        for (WydanieDTO in : inList) {
            outList.add(wydanieDTOtoOB(in));
        }
        return outList;
    }

    public List<GraDTO> graOBlisttoDTOlist(List<GraOB> inList) {
        if (inList == null) {
            return null;
        }
        List<GraDTO> outList = new ArrayList<>();
        for (GraOB in : inList) {
            outList.add(graOBtoDTO(in));
        }
        return outList;
    }
    public List<GraOB> graDTOlisttoOBlist(List<GraDTO> inList) {
        if (inList == null) {
            return null;
        }
        List<GraOB> outList = new ArrayList<>();
        for (GraDTO in : inList) {
            outList.add(graDTOtoOB(in));
        }
        return outList;
    }
}
