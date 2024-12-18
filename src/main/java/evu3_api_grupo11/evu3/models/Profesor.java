package evu3_api_grupo11.evu3.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String correo;

    @OneToMany(mappedBy = "profesorSupervisor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Practica> practicasSupervisadas; // Relación bidireccional con Practica

}
