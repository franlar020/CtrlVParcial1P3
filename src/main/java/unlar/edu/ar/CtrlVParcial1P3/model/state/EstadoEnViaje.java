package unlar.edu.ar.CtrlVParcial1P3.model.state;

import unlar.edu.ar.CtrlVParcial1P3.model.Vehiculo;

public class EstadoEnViaje implements EstadoVehiculo {
    @Override
    public boolean iniciarViaje(Vehiculo vehiculo) {
        return false; // Ya está en viaje
    }

    @Override
    public boolean finalizarViaje(Vehiculo vehiculo) {
        vehiculo.setEstado(new EstadoEnEspera());
        return true;
    }

    @Override
    public boolean enviarMantenimiento(Vehiculo vehiculo) {
        return false; // Bloqueado por regla de negocio: no puede ir a taller en viaje
    }

    @Override
    public String getNombreEstado() {
        return "EN_VIAJE";
    }
}