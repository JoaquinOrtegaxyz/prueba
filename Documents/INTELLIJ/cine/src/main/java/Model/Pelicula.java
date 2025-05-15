package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String titulo;

    @NotNull
    private Integer anioEstreno;

    private int duracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "pelicula_actor",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    Set<Actor> actores = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private Director director;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resenia> resenias;

    public Pelicula(Long id, String titulo, Integer anioEstreno, int duracion, Genero genero, Set<Actor> actores, Director director, List<Resenia> resenias) {
        this.id = id;
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracion = duracion;
        this.genero = genero;
        this.actores = actores;
        this.director = director;
        this.resenias = resenias;
    }

    public Pelicula() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(Integer anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Set<Actor> getActores() {
        return actores;
    }

    public void setActores(Set<Actor> actores) {
        this.actores = actores;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Resenia> getResenias() {
        return resenias;
    }

    public void setResenias(List<Resenia> resenias) {
        this.resenias = resenias;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anioEstreno=" + anioEstreno +
                ", duracion=" + duracion +
                ", genero=" + genero +
                ", actores=" + actores +
                ", director=" + director +
                ", reseñas=" + resenias +
                '}';
    }
}
