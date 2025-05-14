package repository;

import model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Métodos personalizados se pueden agregar aquí si se necesitan
}
