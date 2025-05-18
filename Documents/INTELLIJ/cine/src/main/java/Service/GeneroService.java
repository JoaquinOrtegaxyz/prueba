package Service;

import Model.Genero;
import Repository.GeneroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.*;
import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public GeneroService() {
    }

    public GeneroRepository getGeneroRepository() {
        return generoRepository;
    }

    public void setGeneroRepository(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public Genero guardarGenero(@Valid Genero genero){
        return generoRepository.save(genero);
    }

    public void eliminarGenero(Long id){
        if(!generoRepository.existsById(id)){
            throw new NotFoundEntity("No se encontró la Genero");
        }
        generoRepository.deleteById(id);
    }

    public List<Genero> listarGeneros(){
        return generoRepository.findAll();
    }

    public Optional<Genero> actualizarGenero(Long id, Genero genero){
        return generoRepository.findById(id).map(existing -> {
                    existing.setNombre(genero.getNombre());
                    return generoRepository.save(existing);
                }
        );
    }
}
