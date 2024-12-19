package evu3_api_grupo11.evu3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import evu3_api_grupo11.evu3.models.Practica;
import evu3_api_grupo11.evu3.responses.PracticaResponse;
import evu3_api_grupo11.evu3.services.PracticaService;

@Controller
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private PracticaService practicaService;

    // Agregar una nueva práctica
    @PostMapping(value = "/practicas/crear", produces = "application/json")
    public ResponseEntity<Object> agregarPractica(@RequestBody Practica practica) {
        if (practica.getDescripcion() == null || practica.getDescripcion().isEmpty()) {
            throw new RuntimeException("La descripción de la práctica es obligatoria");
        }

        Practica nuevaPractica = practicaService.crear(practica);

        PracticaResponse response = new PracticaResponse();
        response.setStatus(200);
        response.setMessage("Práctica creada exitosamente por el profesor");
        response.setPractica(nuevaPractica);

        return ResponseEntity.ok().body(response);
    }

    // Consultar todas las prácticas
    @GetMapping(value = "/practicas", produces = "application/json")
    public ResponseEntity<Object> consultarPracticas() {
        PracticaResponse response = new PracticaResponse();
        response.setStatus(200);
        response.setMessage("Lista de todas las prácticas");
        response.setPracticas(practicaService.listar());

        return ResponseEntity.ok().body(response);
    }

    // Actualizar una práctica
    @PutMapping(value = "/practicas/actualizar/{id}", produces = "application/json")
    public ResponseEntity<Object> actualizarPractica(@PathVariable Long id, @RequestBody Practica practicaActualizada) {
        Practica practicaExistente = practicaService.buscar(id);

        if (practicaExistente == null) {
            throw new RuntimeException("Práctica no encontrada");
        }

        practicaExistente.setDescripcion(practicaActualizada.getDescripcion());
        practicaExistente.setFechaInicio(practicaActualizada.getFechaInicio());
        practicaExistente.setFechaTermino(practicaActualizada.getFechaTermino());
        practicaExistente.setEmpresa(practicaActualizada.getEmpresa());
        practicaExistente.setJefeDirecto(practicaActualizada.getJefeDirecto());
        practicaExistente.setProfesorSupervisor(practicaActualizada.getProfesorSupervisor());

        Practica practicaActualizadaFinal = practicaService.crear(practicaExistente);

        PracticaResponse response = new PracticaResponse();
        response.setStatus(200);
        response.setMessage("Práctica actualizada exitosamente");
        response.setPractica(practicaActualizadaFinal);

        return ResponseEntity.ok().body(response);
    }

    // Eliminar una práctica
    @DeleteMapping(value = "/practicas/eliminar/{id}", produces = "application/json")
    public ResponseEntity<Object> eliminarPractica(@PathVariable Long id) {
        practicaService.eliminar(id);

        PracticaResponse response = new PracticaResponse();
        response.setStatus(200);
        response.setMessage("Práctica eliminada exitosamente");

        return ResponseEntity.ok().body(response);
    }
}