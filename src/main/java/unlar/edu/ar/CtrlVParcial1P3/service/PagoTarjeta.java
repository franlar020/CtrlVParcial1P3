package unlar.edu.ar.CtrlVParcial1P3.service;

public class PagoTarjeta implements ProcesadorPago {
    @Override
    public void procesar(double monto) {
        System.out.println("Cobro exitoso de $" + monto + " realizado con Tarjeta de Crédito.");
    }
}