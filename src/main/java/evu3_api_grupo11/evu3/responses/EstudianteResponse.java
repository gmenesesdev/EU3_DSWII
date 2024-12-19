package evu3_api_grupo11.evu3.responses;

import evu3_api_grupo11.evu3.models.Estudiante;
import lombok.Data;

@Data
public class EstudianteResponse {
    private int status;
    private String message;
    private Estudiante estudiante;
}
