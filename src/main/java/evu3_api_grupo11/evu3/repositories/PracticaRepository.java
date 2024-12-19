package evu3_api_grupo11.evu3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import evu3_api_grupo11.evu3.models.Estudiante;
import evu3_api_grupo11.evu3.models.Practica;
import evu3_api_grupo11.evu3.models.Profesor;

@Repository
public interface PracticaRepository extends JpaRepository<Practica, Long> {
    // Consultar prácticas asociadas a un estudiante específico
    List<Practica> findByEstudiante(Estudiante estudiante);

    // Consultar todas las prácticas supervisadas por un profesor específico
    List<Practica> findByProfesorSupervisor(Profesor profesor);

    // Consultar prácticas por descripción parcial (útil para búsquedas)
    List<Practica> findByDescripcionIgnoreCaseContaining(String descripcion);

    // Método para buscar prácticas por estudiante
    List<Practica> findByEstudianteId(Long estudianteId);
}
