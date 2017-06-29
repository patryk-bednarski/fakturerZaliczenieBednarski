package eu.programisci.zaliczenie.gra.dto;

import eu.programisci.zaliczenie.gra.enums.EGatunek;

public class CritDTO {
    EGatunek gatunek;
    Integer rokWydania;

    public EGatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(EGatunek gatunek) {
        this.gatunek = gatunek;
    }

    public Integer getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(Integer rokWydania) {
        this.rokWydania = rokWydania;
    }
}
