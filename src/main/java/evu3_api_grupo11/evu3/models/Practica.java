package evu3_api_grupo11.evu3.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Practica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Date fechaInicio;
    private Date fechaTermino;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonIgnore // Evita que la relación con la empresa se serialice
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    @JsonIgnore // Evita que la relación con el estudiante se serialice
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "jefe_directo_id")
    @JsonIgnore // Evita que la relación con el jefe directo se serialice
    private JefeDirecto jefeDirecto;

    @ManyToOne
    @JoinColumn(name = "profesor_supervisor_id")
    @JsonIgnore // Evita que la relación con el profesor supervisor se serialice
    private Profesor profesorSupervisor;

    // Getters y setters
}