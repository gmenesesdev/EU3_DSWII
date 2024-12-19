package evu3_api_grupo11.evu3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import evu3_api_grupo11.evu3.models.Practica;
import evu3_api_grupo11.evu3.repositories.PracticaRepository;

@Service
public class PracticaService {
    @Autowired
    private PracticaRepository practicaRepository;

    // Crear o actualizar una práctica
    public Practica crear(Practica practica) {
        return practicaRepository.save(practica);
    }

    // Listar todas las prácticas
    public List<Practica> listarTodas() {
        return practicaRepository.findAll();
    }

    // Buscar una práctica por ID
    public Practica buscar(Long id) {
        return practicaRepository.findById(id).orElse(null);
    }

    // Listar prácticas por un estudiante
    public List<Practica> listarPorEstudiante(Long estudianteId) {
        return practicaRepository.findAll().stream()
                .filter(practica -> practica.getEstudiante().getId().equals(estudianteId))
                .toList();
    }

    // Eliminar una práctica por ID
    public void eliminar(Long id) {
        practicaRepository.deleteById(id);
    }
}
