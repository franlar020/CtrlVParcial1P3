package unlar.edu.ar.CtrlVParcial1P3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlquilerResponseDTO {
    private String patente;
    private int tiempoTranscurrido;
    private double costoFinal;
    private String faseActual;
}