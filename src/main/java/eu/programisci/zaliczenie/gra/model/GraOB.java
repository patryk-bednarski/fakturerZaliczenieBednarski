package eu.programisci.zaliczenie.gra.model;

import eu.programisci.zaliczenie.gra.enums.EGatunek;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "GRA")
@SequenceGenerator(allocationSize = 1, name = "SEKWENCJA", sequenceName = "gen_gra_id")
public class GraOB {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tytul;
    @ElementCollection(targetClass = EGatunek.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @Column
    private Set<EGatunek> gatunki = new HashSet<>();
    @Column
    private String developer;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable
    private Set<WydanieOB> wydania;
    @Column(columnDefinition = "TIMESTAMP")
    private Date dataUtworzenia;

    public GraOB() {
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

    public Set<EGatunek> getGatunki() {
        return gatunki;
    }

    public void setGatunki(Set<EGatunek> gatunki) {
        this.gatunki = gatunki;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Set<WydanieOB> getWydania() {
        return wydania;
    }

    public void setWydania(Set<WydanieOB> wydania) {
        this.wydania = wydania;
    }

    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }
}



