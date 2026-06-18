package unlar.edu.ar.CtrlVParcial1P3.model.state;

import unlar.edu.ar.CtrlVParcial1P3.model.Vehiculo;

public interface EstadoVehiculo {
    // Retorna true si la transición fue exitosa, false si viola las reglas
    boolean iniciarViaje(Vehiculo vehiculo);
    boolean finalizarViaje(Vehiculo vehiculo);
    boolean enviarMantenimiento(Vehiculo vehiculo);
    String getNombreEstado();
}