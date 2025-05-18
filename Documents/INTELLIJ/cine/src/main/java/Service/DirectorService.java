package Service;

import Model.Director;
import Repository.DirectorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.*;
import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;

    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public DirectorService() {
    }

    public DirectorRepository getDirectorRepository() {
        return directorRepository;
    }

    public void setDirectorRepository(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Director guardarDirector(@Valid Director director){
        return directorRepository.save(director);
    }

    public void eliminarDirector(Long id){
        if(!directorRepository.existsById(id)){
            throw new NotFoundEntity("No se encontró la Director");
        }
        directorRepository.deleteById(id);
    }

    public List<Director> listarDirectors(){
        return directorRepository.findAll();
    }

    public Optional<Director> actualizarDirector(Long id, Director director){
        return directorRepository.findById(id).map(existing -> {
                    existing.setNombre(director.getNombre());
                    return directorRepository.save(existing);
                }
        );
    }
}
