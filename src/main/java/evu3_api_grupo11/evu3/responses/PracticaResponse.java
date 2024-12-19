package evu3_api_grupo11.evu3.responses;

import evu3_api_grupo11.evu3.models.Practica;
import lombok.Data;

@Data
public class PracticaResponse {
    private int status;
    private String message;
    private Practica practica;
}
