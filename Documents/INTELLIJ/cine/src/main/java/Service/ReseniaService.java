package Service;

import Model.Pelicula;
import Model.Resenia;
import Repository.PeliculaRepository;
import Repository.ReseniaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Exception.*;
import java.util.List;
import java.util.Optional;

@Service
public class ReseniaService {
    @Autowired
    ReseniaRepository reseniaRepository;

    public ReseniaService(ReseniaRepository reseniaRepository) {
        this.reseniaRepository = reseniaRepository;
    }

    public ReseniaService() {
    }

    public ReseniaRepository getReseniaRepository() {
        return reseniaRepository;
    }

    public void setReseniaRepository(ReseniaRepository reseniaRepository) {
        this.reseniaRepository = reseniaRepository;
    }

    public Resenia guardarResenia(@Valid Resenia resenia){
        return reseniaRepository.save(resenia);
    }

    public void eliminarResenia(Long id){
        if(!reseniaRepository.existsById(id)){
            throw new NotFoundEntity("No se encontró la pelicula");
        }
        reseniaRepository.deleteById(id);
    }

    public List<Resenia> listarResenias(){
        return reseniaRepository.findAll();
    }

    public Optional<Resenia> actualizarResenia(Long id, Resenia resenia){
        return reseniaRepository.findById(id).map(existing -> {
                    existing.setComentario(resenia.getComentario());
                    existing.setPuntuacion(resenia.getPuntuacion());
                    return reseniaRepository.save(existing);
                }
        );
    }
}
