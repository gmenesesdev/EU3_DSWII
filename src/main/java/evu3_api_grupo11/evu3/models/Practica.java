package evu3_api_grupo11.evu3.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Practica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa; // Relación con Empresa

    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante; // Relación con Estudiante

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesorSupervisor; // Relación con Profesor

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jefe_directo_id", referencedColumnName = "id")
    private JefeDirecto jefeDirecto; // Relación opcional con JefeDirecto

}
