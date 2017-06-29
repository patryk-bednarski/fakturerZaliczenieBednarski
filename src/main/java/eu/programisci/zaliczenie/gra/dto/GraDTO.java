package eu.programisci.zaliczenie.gra.dto;

import eu.programisci.zaliczenie.gra.enums.EGatunek;

import java.util.List;
import java.util.Set;

public class GraDTO {
    Long id;
    String tytul;
    List<EGatunek> gatunki;
    String developer;
    Set<WydanieDTO> wydania;

    public GraDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public List<EGatunek> getGatunki() {
        return gatunki;
    }

    public void setGatunki(List<EGatunek> gatunki) {
        this.gatunki = gatunki;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Set<WydanieDTO> getWydania() {
        return wydania;
    }

    public void setWydania(Set<WydanieDTO> wydania) {
        this.wydania = wydania;
    }
}
