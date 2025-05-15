package Repository;

import Model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
        boolean existsByTituloAndDirector(String titulo, String director);
}
