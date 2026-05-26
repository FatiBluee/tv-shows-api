package api_rest.tv_shows.repositories;

import api_rest.tv_shows.models.Actors;
import api_rest.tv_shows.models.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ActorRepositoryTest {
    @Autowired
    private ActorRepository actorRepository;

    //CREATE
    @Test
    @DisplayName("Método para crear un actor")
    public void createActor(){
        Actors actor1 = new Actors();

        actor1.setName("Kristen Bell");
        actor1.setResidenceCountry("USA");

        Actors result = actorRepository.save(actor1);

        System.out.println("Este es el resultado: " + result);

        assertNotNull(result);
        assertEquals("Kristen Bell", result.getName());
    }

    //READ ONE
    @Test
    @DisplayName("Método para leer un actor")
    public void readActor(){
        Optional<Actors> actorsOptional = actorRepository.findById(1);

        if(actorsOptional.isPresent()){
            Actors receivedActor = actorsOptional.get();

            System.out.println("Recibido: " + receivedActor);

            assertEquals("Kristen Bell", receivedActor.getName());
            assertEquals("USA", receivedActor.getResidenceCountry());
        }
        assertTrue(actorsOptional.isPresent());
    }

    //READ ALL
    @Test
    @DisplayName("Método para leer todos los actores")
    public void readAllActors(){
        List<Actors> actorsList = actorRepository.findAll();
        System.out.println(actorsList);
        assertFalse(actorsList.isEmpty());
    }

    //UPDATE
    @Test
    @DisplayName("Método para actualizar datos de un actor")
    public void updateActor(){
        Optional<Actors> optionalKristen = actorRepository.findById(1);
        Optional<Actors> optionalTed = actorRepository.findById(2);

        if (optionalKristen.isPresent() && optionalTed.isPresent()){
            Actors kristen = optionalKristen.get();
            Actors ted = optionalTed.get();

            kristen.setRole(Role.MAIN);
            ted.setRole(Role.MAIN);

            List<Actors> savedActors = actorRepository.saveAll(List.of(kristen,ted));

            assertEquals(Role.MAIN, savedActors.get(0).getRole());
        }
    }

    //DELETE
    @Test
    @DisplayName("Método para eliminar todos los actores")
    public void deleteActors(){
        actorRepository.deleteAll();
        //Verificar que esta vacia
        List<Actors> actorsList = actorRepository.findAll();
        assertTrue(actorsList.isEmpty());
    }

    //FIND
    @Test
    @DisplayName("Método para encontrar actriz por nombre")
    public void getByName(){
        List<Actors> actor1 = actorRepository.findByNameContaining("Kristen");
        System.out.println(actor1);
    }

    //COUNT
    @Test
    @DisplayName("Método creado para contar por país")
    public void countByCountry(){

        System.out.println(actorRepository.countByResidenceCountry("USA"));
    }
}
