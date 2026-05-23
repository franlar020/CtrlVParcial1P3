package unlar.edu.ar.CtrlVParcial1P3.service;

public class DesacopladorPagosFactory {
    public static ProcesadorPago crearProcesador(String metodoPago) {
        if (metodoPago.equalsIgnoreCase("TARJETA")) {
            return new PagoTarjeta();
        } else if (metodoPago.equalsIgnoreCase("BILLETERA")) {
            return new PagoBilletera();
        }
        return null;
    }
}