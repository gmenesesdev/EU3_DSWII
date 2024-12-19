package evu3_api_grupo11.evu3.responses;

import evu3_api_grupo11.evu3.models.Profesor;
import lombok.Data;

@Data
public class ProfesorResponse {
    private int status;
    private String message;
    private Profesor profesor;
}
