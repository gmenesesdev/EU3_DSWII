package evu3_api_grupo11.evu3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import evu3_api_grupo11.evu3.models.Profesor;
import evu3_api_grupo11.evu3.repositories.ProfesorRepository;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    // Crear o actualizar un profesor
    public Profesor crear(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    // Listar todos los profesores
    public List<Profesor> listarTodos() {
        return profesorRepository.findAll();
    }

    // Buscar un profesor por ID
    public Profesor buscar(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    // Buscar un profesor por correo
    public Profesor buscarPorCorreo(String correo) {
        return profesorRepository.findByCorreo(correo);
    }

    // Eliminar un profesor por ID
    public void eliminar(Long id) {
        profesorRepository.deleteById(id);
    }
}
