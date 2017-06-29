package eu.programisci.zaliczenie.gra.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WYDANIE")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_wydanie_id")
public class WydanieOB {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEKWENCJA")
    private Long id;
    @Column
    private String wydawca;
    @Column
    private String platforma;
    @Column
    private Integer rokWydania;
    @Column(columnDefinition = "TIMESTAMP")
    private Date dataUtworzenia;

    public WydanieOB() {
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

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }
}
