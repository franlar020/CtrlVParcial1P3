package unlar.edu.ar.CtrlVParcial1P3.model.state;

import unlar.edu.ar.CtrlVParcial1P3.model.Vehiculo;

public class EstadoEnReparacion implements EstadoVehiculo {
    @Override
    public boolean iniciarViaje(Vehiculo vehiculo) {
        return false; // Bloqueado: en taller
    }

    @Override
    public boolean finalizarViaje(Vehiculo vehiculo) {
        return false; 
    }

    @Override
    public boolean enviarMantenimiento(Vehiculo vehiculo) {
        return false; // Ya está en taller
    }

    @Override
    public String getNombreEstado() {
        return "EN_REPARACION";
    }
}