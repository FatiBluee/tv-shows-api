package api_rest.tv_shows.services;

import api_rest.tv_shows.dtos.ActorUpdateNameDTO;
import api_rest.tv_shows.models.Actors;

import java.util.List;

public interface ActorService {
    List<Actors> getAllActors(String name);
    Actors getActorById(Integer actorId);
    Actors createActor(Actors actor);
    Actors updateActor(Integer actorId, Actors actor);
    Actors updateActorName(Integer actorId, ActorUpdateNameDTO actorUpdateNameDTO);
    void deleteActor(Integer actorId);
}
