package evu3_api_grupo11.evu3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import evu3_api_grupo11.evu3.models.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    // Buscar un estudiante por correo (para autenticación o consultas específicas)
    Estudiante findByCorreo(String correo);

    // Buscar estudiantes por nombre parcial (usado para búsquedas flexibles)
    List<Estudiante> findByNombreCompletoIgnoreCaseContaining(String nombre);
}
