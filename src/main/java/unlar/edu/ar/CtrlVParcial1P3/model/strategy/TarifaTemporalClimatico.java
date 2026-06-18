package unlar.edu.ar.CtrlVParcial1P3.model.strategy;

public class TarifaTemporalClimatico implements EstrategiaTarifa {
    @Override
    public double calcularCosto(double tarifaBase, int minutosTranscurridos) {
        double costoBase = tarifaBase * minutosTranscurridos;
        return costoBase + 150.0; // Recargo plano de seguridad
    }
}