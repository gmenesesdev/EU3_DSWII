package evu3_api_grupo11.evu3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import evu3_api_grupo11.evu3.models.Estudiante;
import evu3_api_grupo11.evu3.repositories.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    // Crear o actualizar un estudiante
    public Estudiante crear(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    // Listar todos los estudiantes
    public List<Estudiante> listarTodos() {
        return estudianteRepository.findAll();
    }

    // Buscar un estudiante por ID
    public Estudiante buscar(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    // Buscar un estudiante por correo
    public Estudiante buscarPorCorreo(String correo) {
        return estudianteRepository.findByCorreo(correo);
    }

    // Eliminar un estudiante por ID
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}
