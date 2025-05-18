package Controller;

import Model.Pelicula;
import Service.PeliculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    private PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    public PeliculaController() {
    }

    public PeliculaService getPeliculaService() {
        return peliculaService;
    }

    public void setPeliculaService(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping
    public ResponseEntity<?> guardarPelicula(Pelicula pelicula){
        return ResponseEntity.ok(peliculaService.guardarPelicula(pelicula));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPelicula(Long id){
        peliculaService.eliminarPelicula(id);
        return ResponseEntity.ok("Pelicula eliminada correctamente");
    }

    @GetMapping
    public ResponseEntity<?> listarPelicula(){
        return ResponseEntity.ok(peliculaService.listarPeliculas());
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarPelicula(Long id, Pelicula pelicula){
        return ResponseEntity.ok(peliculaService.actualizarPelicula(id, pelicula));
    }
}
