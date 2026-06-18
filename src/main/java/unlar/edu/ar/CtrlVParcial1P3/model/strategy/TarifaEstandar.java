package unlar.edu.ar.CtrlVParcial1P3.model.strategy;

public class TarifaEstandar implements EstrategiaTarifa {
    @Override
    public double calcularCosto(double tarifaBase, int minutosTranscurridos) {
        return tarifaBase * minutosTranscurridos;
    }
}