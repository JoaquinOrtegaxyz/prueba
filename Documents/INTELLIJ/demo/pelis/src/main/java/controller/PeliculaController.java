package controller;

import jakarta.validation.Valid;
import model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PeliculaService;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping
    public ResponseEntity<?> crearPelicula(@Valid @RequestBody Pelicula pelicula){
        return ResponseEntity.ok(peliculaService.crearPelicula(pelicula));
    }

    @GetMapping
    public ResponseEntity<?> buscarPorId(Long id){
        return ResponseEntity.ok(peliculaService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<?> listarPeliculas(){
        return ResponseEntity.ok(peliculaService.listarPeliculas());
    }

    @GetMapping
    public ResponseEntity<?> buscarPorAnio(Integer anio){
        return ResponseEntity.ok(peliculaService.buscarPorAnio(anio));
    }
}
