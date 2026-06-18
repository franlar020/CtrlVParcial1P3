package unlar.edu.ar.CtrlVParcial1P3.model;
import unlar.edu.ar.CtrlVParcial1P3.model.state.EstadoVehiculo;
import unlar.edu.ar.CtrlVParcial1P3.model.state.EstadoEnEspera;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vehiculo implements Comparable<Vehiculo> {
    private String patente;
    private int porcentajeBateria; // 0 a 100
    private double tarifaFijaBase;

    // Integración del Patrón State
    private EstadoVehiculo estado = new EstadoEnEspera(); // Estado por defecto

    // Criterio Natural de Ordenamiento: Prioridad de Carga (Menor batería primero)
    @Override
    public int compareTo(Vehiculo otro) {
        return Integer.compare(this.porcentajeBateria, otro.porcentajeBateria);
    }
}