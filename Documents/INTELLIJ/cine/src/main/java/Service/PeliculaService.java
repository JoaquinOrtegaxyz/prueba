package Service;

import Model.Pelicula;
import Repository.PeliculaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import Exception.*;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {
    @Autowired
    PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public PeliculaService() {
    }

    public PeliculaRepository getPeliculaRepository() {
        return peliculaRepository;
    }

    public void setPeliculaRepository(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public Pelicula guardarPelicula(@Valid Pelicula pelicula){
        if(peliculaRepository.existsByTituloAndDirector(pelicula.getTitulo(), pelicula.getDirector().getNombre())){
            throw new ExistedEntity("Ya existe la pelicula");
        }
        return peliculaRepository.save(pelicula);
    }

    public void eliminarPelicula(Long id){
        if(!peliculaRepository.existsById(id)){
            throw new NotFoundEntity("No se encontró la pelicula");
        }
        peliculaRepository.deleteById(id);
    }

    public List<Pelicula> listarPeliculas(){
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> actualizarPelicula(Long id, Pelicula pelicula){
        return peliculaRepository.findById(id).map(existing -> {
                    existing.setTitulo(pelicula.getTitulo());
                    existing.setGenero(pelicula.getGenero());
                    return peliculaRepository.save(existing);
                }
        );
    }
}
