package eu.programisci.zaliczenie.gra.dto;


public class WydanieDTO {
    Long id;
    String wydawca;
    String platforma;
    Integer rokWydania;

    public WydanieDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWydawca() {
        return wydawca;
    }

    public void setWydawca(String wydawca) {
        this.wydawca = wydawca;
    }

    public String getPlatforma() {
        return platforma;
    }

    public void setPlatforma(String platforma) {
        this.platforma = platforma;
    }

    public Integer getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(Integer rokWydania) {
        this.rokWydania = rokWydania;
    }
}
