package evu3_api_grupo11.evu3.responses;

import java.util.List;

import evu3_api_grupo11.evu3.models.Practica;
import lombok.Data;

@Data
public class PracticaResponse {

    private int status;
    private String message;
    private Practica practica;
    private List<Practica> practicas;  // Se añadió este atributo para la lista de prácticas

    // Método setter para la lista de prácticas
    public void setPracticas(List<Practica> practicas) {
        this.practicas = practicas;
    }
    
}
