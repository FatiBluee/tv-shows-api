package api_rest.tv_shows.repositories;

import api_rest.tv_shows.models.Actors;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actors, Integer> {
    //Métod creado para encontrar un actor por nombre
    List<Actors> findByNameContaining(String name);

    //Creados para eliminar por atributos
    @Transactional
    int deleteByName(String name);

    @Transactional
    int deleteByResidenceCountry(String residenceCountry);

    //Query personalizada
    @Query("SELECT COUNT(a) FROM Actors a WHERE a.residenceCountry = :country")
    int countByResidenceCountry(String country);
}
