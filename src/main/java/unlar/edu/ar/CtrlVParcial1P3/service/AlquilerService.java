package unlar.edu.ar.CtrlVParcial1P3.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.CtrlVParcial1P3.dto.AlquilerResponseDTO;
import unlar.edu.ar.CtrlVParcial1P3.model.Vehiculo;
import unlar.edu.ar.CtrlVParcial1P3.model.BicicletaElectrica;
import unlar.edu.ar.CtrlVParcial1P3.model.Monopatin;
import unlar.edu.ar.CtrlVParcial1P3.model.strategy.EstrategiaTarifa;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Service
public class AlquilerService {

    // Optimización algorítmica: Estructura clave-valor para acceso O(1)
    private Map<String, Vehiculo> inventarioGlobal = new HashMap<>();

    public AlquilerService() {
        // Inicialización de la memoria estática exigida
        Monopatin m1 = new Monopatin(true);
        m1.setPatente("AAA111");
        m1.setPorcentajeBateria(80);
        m1.setTarifaFijaBase(500.0);

        BicicletaElectrica b1 = new BicicletaElectrica(1500);
        b1.setPatente("BBB222");
        b1.setPorcentajeBateria(10);
        b1.setTarifaFijaBase(600.0);

        inventarioGlobal.put(m1.getPatente(), m1);
        inventarioGlobal.put(b1.getPatente(), b1);
    }

    public String desbloquearVehiculo(String patente) {
        Vehiculo vehiculo = inventarioGlobal.get(patente);
        
        if (vehiculo == null) {
            throw new RuntimeException("Vehículo No Encontrado"); // Será capturado por el GlobalExceptionHandler
        }

        // Transición gestionada por el Patrón State
        boolean transicionValida = vehiculo.getEstado().iniciarViaje(vehiculo);
        
        if (!transicionValida) {
            throw new RuntimeException("Operación inválida. Estado actual: " + vehiculo.getEstado().getNombreEstado());
        }

        return "Desbloqueo exitoso. Patente: " + vehiculo.getPatente();
    }

    public AlquilerResponseDTO finalizarAlquiler(String patente, int minutos, EstrategiaTarifa estrategia) {
        Vehiculo vehiculo = inventarioGlobal.get(patente);

        if (vehiculo == null) {
            throw new RuntimeException("Vehículo No Encontrado");
        }

        // Validación de transición de estado
        boolean transicionValida = vehiculo.getEstado().finalizarViaje(vehiculo);
        if (!transicionValida) {
            throw new RuntimeException("No se puede finalizar. El vehículo no se encuentra en viaje.");
        }

        // Aplicación del Patrón Strategy para el cálculo económico
        double costoFinal = estrategia.calcularCosto(vehiculo.getTarifaFijaBase(), minutos);

        return new AlquilerResponseDTO(
                vehiculo.getPatente(),
                minutos,
                costoFinal,
                vehiculo.getEstado().getNombreEstado()
        );
    }

    // Método auxiliar para el servicio de ordenamiento
    public List<Vehiculo> obtenerTodos() {
        return new ArrayList<>(inventarioGlobal.values());
    }
}