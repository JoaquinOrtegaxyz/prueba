package Service;

import Model.Pelicula;
import Repository.PeliculaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import Exception.*;

@Service
public class PeliculaService {
    @Autowired
    PeliculaRepository peliculaRepository;

    public Pelicula guardarPelicula(@Valid Pelicula pelicula){
        if(peliculaRepository.existsByTituloAndDirector(pelicula.getTitulo(), pelicula.getDirector().getNombre())){
            throw new PeliculaExisteException("Ya existe la pelicula");
        }
        return peliculaRepository.save(pelicula);
    }

    public void eliminarPelicula(Long id){
        if(!peliculaRepository.existsById(id)){
            throw new PeliculaNoEncontradException("No se encontró la pelicula");
        }
        peliculaRepository.deleteById(id);
    }
    
}
