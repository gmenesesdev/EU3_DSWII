package evu3_api_grupo11.evu3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import evu3_api_grupo11.evu3.models.Practica;
import evu3_api_grupo11.evu3.responses.PracticaResponse;
import evu3_api_grupo11.evu3.services.PracticaService;

@Controller
@RequestMapping("/api/estudiantes")
public class EstudianteController {

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
        response.setMessage("Práctica creada exitosamente");
        response.setPractica(nuevaPractica);

        return ResponseEntity.ok().body(response);
    }

    // Consultar prácticas propias
    @GetMapping(value = "/practicas/{idEstudiante}", produces = "application/json")
    public ResponseEntity<Object> consultarPracticas(@PathVariable Long idEstudiante) {
        PracticaResponse response = new PracticaResponse();
        response.setStatus(200);
        response.setMessage("Lista de prácticas del estudiante");
        response.setPracticas(practicaService.listarPorEstudiante(idEstudiante));

        return ResponseEntity.ok().body(response);
    }
}