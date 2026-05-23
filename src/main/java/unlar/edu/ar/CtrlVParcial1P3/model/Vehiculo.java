package unlar.edu.ar.CtrlVParcial1P3.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vehiculo {
    private String patente;
    private int porcentajeBateria; // 0 a 100
    private double tarifaFijaBase;
}