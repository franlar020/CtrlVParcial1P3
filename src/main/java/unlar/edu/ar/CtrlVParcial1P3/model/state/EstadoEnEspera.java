package unlar.edu.ar.CtrlVParcial1P3.model.state;

import unlar.edu.ar.CtrlVParcial1P3.model.Vehiculo;

public class EstadoEnEspera implements EstadoVehiculo {
    @Override
    public boolean iniciarViaje(Vehiculo vehiculo) {
        vehiculo.setEstado(new EstadoEnViaje());
        return true;
    }

    @Override
    public boolean finalizarViaje(Vehiculo vehiculo) {
        return false; // Operación inválida en este estado
    }

    @Override
    public boolean enviarMantenimiento(Vehiculo vehiculo) {
        vehiculo.setEstado(new EstadoEnReparacion());
        return true;
    }

    @Override
    public String getNombreEstado() {
        return "EN_ESPERA";
    }
}