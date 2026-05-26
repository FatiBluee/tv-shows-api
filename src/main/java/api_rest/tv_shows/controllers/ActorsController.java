package api_rest.tv_shows.controllers;

import api_rest.tv_shows.dtos.ActorUpdateNameDTO;
import api_rest.tv_shows.models.Actors;
import api_rest.tv_shows.services.ActorServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorsController {

    @Autowired
    ActorServiceImpl actorService;

    //GET CON PARAMETRO DE NOMBRE DE ACTOR
    @GetMapping("")
    public List<Actors> getAllActors(@RequestParam(required = false ) String name){
        return actorService.getAllActors(name);
    }

    //GET PARA CONSEGUIR ACTOR POR ID
    @GetMapping("/{actorId}")
    @ResponseStatus(HttpStatus.OK)
    public Actors getActorById(@PathVariable Integer actorId){
        return actorService.getActorById(actorId);
    }

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Actors createActor(@Valid @RequestBody Actors actor){
        return actorService.createActor(actor);
    }

    //PUT
    @PutMapping("/{actorId}")
    @ResponseStatus(HttpStatus.OK)
    public Actors updateActor(@Valid @RequestBody Actors actor, @PathVariable Integer actorId){
        return actorService.updateActor(actorId, actor );
    }

    //PATCH NAME
    @PatchMapping("/{actorId}/name")
    @ResponseStatus(HttpStatus.OK)
    public Actors updateActorName(@Valid @RequestBody ActorUpdateNameDTO actor, @PathVariable Integer actorId) {
        return actorService.updateActorName(actorId, actor);
    }

    //DELETE
    @DeleteMapping("/{actorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActor(@PathVariable Integer actorId){
        actorService.deleteActor(actorId);
    }
}
