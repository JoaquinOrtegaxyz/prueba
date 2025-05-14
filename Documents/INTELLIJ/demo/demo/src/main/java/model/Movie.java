package model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String director;

    private int year;

    public Movie() {}

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    // Getters y setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}