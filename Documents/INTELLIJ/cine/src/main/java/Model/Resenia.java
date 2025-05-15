package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "resenia")
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String comentario;

    @Min(1)
    @Max(5)
    private int puntuacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;


    public Resenia(Long id, String comentario, int puntuacion, Pelicula pelicula) {
        this.id = id;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.pelicula = pelicula;
    }

    public Resenia() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Reseña{" +
                "id=" + id +
                ", comentario='" + comentario + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
