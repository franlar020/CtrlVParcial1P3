package unlar.edu.ar.CtrlVParcial1P3.util;

import unlar.edu.ar.CtrlVParcial1P3.model.Vehiculo;
import java.util.Comparator;

public class ComparadorTarifaBase implements Comparator<Vehiculo> {
    @Override
    public int compare(Vehiculo v1, Vehiculo v2) {
        // Ordenamiento descendente: se invierte el orden lógico (v2 contra v1)
        return Double.compare(v2.getTarifaFijaBase(), v1.getTarifaFijaBase());
    }
}