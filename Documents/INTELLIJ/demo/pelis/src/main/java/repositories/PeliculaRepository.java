package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findByAnioLanzamiento(Integer anio);

    boolean existsByTituloAndDirector(String titulo, String director);
}
