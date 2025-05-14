package service;

import exception.AlreadyExistsMovie;
import exception.EntityNotFound;
import exception.NotDocumentallyAndBelow1920;
import jakarta.persistence.Entity;
import model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.PeliculaRepository;

import java.util.List;

@Entity
public class PeliculaService {
    @Autowired
    private PeliculaRepository peliculaRepository;

    public Pelicula crearPelicula(Pelicula pelicula){
        if(peliculaRepository.existsByTituloAndDirector(pelicula.getTitulo(), pelicula.getDirector())){
            throw new AlreadyExistsMovie("Ya existe la pelicula");
        }

        if("documental".equalsIgnoreCase(pelicula.getGenero()) && pelicula.getAnio_lanzamiento() < 1920){
            throw new NotDocumentallyAndBelow1920("La pelicula no puede ser documental ni ser de antes de 1920");
        }

        return peliculaRepository.save(pelicula);
    }

    public Pelicula buscarPorId(Long id){
        return peliculaRepository.findById(id).orElseThrow(() -> new EntityNotFound("Pelicula no encontrada"));
    }

    public List<Pelicula> listarPeliculas(){
        return peliculaRepository.findAll();
    }

    public List<Pelicula> buscarPorAnio(Integer anio){
        return  peliculaRepository.findByAnioLanzamiento(anio);
    }
}
