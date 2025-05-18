package Service;

import Model.Actor;
import Repository.ActorRepository;
import Repository.ActorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import Exception.*;

@Service
public class ActorService {
    @Autowired
    ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ActorService() {
    }

    public ActorRepository getActorRepository() {
        return actorRepository;
    }

    public void setActorRepository(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor guardarActor(@Valid Actor actor){
        return actorRepository.save(actor);
    }

    public void eliminarActor(Long id){
        if(!actorRepository.existsById(id)){
            throw new NotFoundEntity("No se encontró la Actor");
        }
        actorRepository.deleteById(id);
    }

    public List<Actor> listarActors(){
        return actorRepository.findAll();
    }

    public Optional<Actor> actualizarActor(Long id, Actor actor){
        return actorRepository.findById(id).map(existing -> {
                    existing.setNacionalidad(actor.getNacionalidad());
                    existing.setNombre(actor.getNombre());
                    return actorRepository.save(existing);
                }
        );
    }
}
