package evu3_api_grupo11.evu3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import evu3_api_grupo11.evu3.models.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    // Buscar un profesor por correo (para autenticación o identificación)
    Profesor findByCorreo(String correo);
}
