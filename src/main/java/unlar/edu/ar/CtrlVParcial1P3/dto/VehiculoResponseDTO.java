package unlar.edu.ar.CtrlVParcial1P3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoResponseDTO {
    private String patente;
    private int porcentajeBateria;
    private double tarifaFijaBase;
    private String estadoActual;
}