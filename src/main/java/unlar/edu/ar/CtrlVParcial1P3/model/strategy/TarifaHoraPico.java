package unlar.edu.ar.CtrlVParcial1P3.model.strategy;

public class TarifaHoraPico implements EstrategiaTarifa {
    @Override
    public double calcularCosto(double tarifaBase, int minutosTranscurridos) {
        double costoBase = tarifaBase * minutosTranscurridos;
        return costoBase + (costoBase * 0.40); // Recargo del 40%
    }
}