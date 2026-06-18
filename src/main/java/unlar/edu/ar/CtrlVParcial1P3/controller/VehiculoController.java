package unlar.edu.ar.CtrlVParcial1P3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unlar.edu.ar.CtrlVParcial1P3.dto.VehiculoResponseDTO;
import unlar.edu.ar.CtrlVParcial1P3.service.AlquilerService;
import unlar.edu.ar.CtrlVParcial1P3.service.FlotaService;
import unlar.edu.ar.CtrlVParcial1P3.model.Vehiculo;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private FlotaService flotaService;

    @Autowired
    private AlquilerService alquilerService;

    // Aplica ordenamiento natural O(N log N)
    @GetMapping("/prioridad-carga")
    public ResponseEntity<List<VehiculoResponseDTO>> listarPorPrioridadDeCarga() {
        List<Vehiculo> inventarioActual = alquilerService.obtenerTodos();
        List<VehiculoResponseDTO> respuesta = flotaService.obtenerFlotaOrdenadaPorCarga(inventarioActual);
        return ResponseEntity.ok(respuesta);
    }

    // Aplica ordenamiento por comparador externo O(N log N)
    @GetMapping("/tarifa-descendente")
    public ResponseEntity<List<VehiculoResponseDTO>> listarPorTarifaDescendente() {
        List<Vehiculo> inventarioActual = alquilerService.obtenerTodos();
        List<VehiculoResponseDTO> respuesta = flotaService.obtenerFlotaOrdenadaPorTarifa(inventarioActual);
        return ResponseEntity.ok(respuesta);
    }
}