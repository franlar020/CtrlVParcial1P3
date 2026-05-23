package unlar.edu.ar.CtrlVParcial1P3.model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BicicletaElectrica extends Vehiculo {
    private int capacidadCanastoCarga; // cm³
}