package api_rest.tv_shows.services;

import api_rest.tv_shows.dtos.ActorUpdateNameDTO;
import api_rest.tv_shows.models.Actors;
import api_rest.tv_shows.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService{
    @Autowired
    ActorRepository actorRepository;

    @Override
    public List<Actors> getAllActors(String name) {
        if (name != null){
            return actorRepository.findByNameContaining(name);
        }
        return actorRepository.findAll();
    }

    @Override
    public Actors getActorById(Integer actorId) {
        return actorRepository.findById(actorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso no encontrado"));
    }

    @Override
    public Actors createActor(Actors actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actors updateActor(Integer actorId, Actors actor) {
        Actors foundActor = actorRepository.findById(actorId)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso no encontrado"));

        foundActor.setRole(actor.getRole());
        foundActor.setName(actor.getName());
        foundActor.setResidenceCountry(actor.getResidenceCountry());

        return actorRepository.save(foundActor);
    }

    @Override
    public Actors updateActorName(Integer actorId, ActorUpdateNameDTO actorUpdateNameDTO) {
        Actors foundActor = actorRepository.findById(actorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Recurso no encontrado"));

        foundActor.setName(actorUpdateNameDTO.getName());

        return actorRepository.save(foundActor);
    }

    @Override
    public void deleteActor(Integer actorId) {
        if (!actorRepository.existsById(actorId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor no encontrado");
        }
        actorRepository.deleteById(actorId);
    }
}
