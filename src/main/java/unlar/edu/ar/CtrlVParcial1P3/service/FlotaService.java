package unlar.edu.ar.CtrlVParcial1P3.service;

import org.springframework.stereotype.Service;
import unlar.edu.ar.CtrlVParcial1P3.dto.VehiculoResponseDTO;
import unlar.edu.ar.CtrlVParcial1P3.model.Vehiculo;
import unlar.edu.ar.CtrlVParcial1P3.util.ComparadorTarifaBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FlotaService {

    public List<VehiculoResponseDTO> obtenerFlotaOrdenadaPorCarga(List<Vehiculo> vehiculos) {
        List<Vehiculo> copia = new ArrayList<>(vehiculos);
        // Aplica el criterio interno de la interfaz Comparable (compareTo) implementado en Vehiculo
        Collections.sort(copia); 
        return mapearADTO(copia);
    }

    public List<VehiculoResponseDTO> obtenerFlotaOrdenadaPorTarifa(List<Vehiculo> vehiculos) {
        List<Vehiculo> copia = new ArrayList<>(vehiculos);
        // Aplica el criterio externo mediante el patrón Comparator inyectado
        Collections.sort(copia, new ComparadorTarifaBase());
        return mapearADTO(copia);
    }

    // Mapeo imperativo tradicional, estrictamente sin uso de API Stream
    private List<VehiculoResponseDTO> mapearADTO(List<Vehiculo> vehiculos) {
        List<VehiculoResponseDTO> dtos = new ArrayList<>();
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            dtos.add(new VehiculoResponseDTO(
                    v.getPatente(),
                    v.getPorcentajeBateria(),
                    v.getTarifaFijaBase(),
                    v.getEstado().getNombreEstado()
            ));
        }
        return dtos;
    }
}