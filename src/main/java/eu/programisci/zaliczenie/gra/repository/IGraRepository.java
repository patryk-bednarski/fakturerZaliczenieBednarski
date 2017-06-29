package eu.programisci.zaliczenie.gra.repository;

import eu.programisci.zaliczenie.gra.dto.CritDTO;
import eu.programisci.zaliczenie.gra.enums.EGatunek;
import eu.programisci.zaliczenie.gra.model.GraOB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGraRepository extends JpaRepository<GraOB, Long> {

    @Query("SELECT g FROM GraOB g LEFT JOIN FETCH g.wydania w WHERE :#{#crit.gatunek} MEMBER OF g.gatunki AND w.rokWydania = :#{#crit.rokWydania}")
    List<GraOB> znajdzWgGatunkuIRokuWydani(@Param("crit")CritDTO critDTO);
    @Query("SELECT g.tytul FROM GraOB g WHERE upper(g.tytul) LIKE upper(concat('%',:partial,'%')) ")
    List<String> znajdzTytulyZawierajace(@Param("partial") String partial);
    @Query("SELECT DISTINCT g FROM GraOB g LEFT JOIN FETCH g.wydania w  WHERE w.rokWydania < :rokWydania ")
    List<GraOB> znajdzStarszeNiz(@Param("rokWydania") Integer rokWydania);
    @Query("SELECT g FROM GraOB g WHERE :gatunek MEMBER OF g.gatunki")
    List<GraOB> znajdzWgGatunku(@Param("gatunek") EGatunek gatunek);
}
