package unlar.edu.ar.CtrlVParcial1P3.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import unlar.edu.ar.CtrlVParcial1P3.dto.AlquilerResponseDTO;
import unlar.edu.ar.CtrlVParcial1P3.service.AlquilerService;
import unlar.edu.ar.CtrlVParcial1P3.model.strategy.*;

@RestController
@RequestMapping("/api/alquileres")
@RequiredArgsConstructor
public class AlquilerController {

    private final AlquilerService alquilerService;

    @PostMapping("/desbloquear")
    public ResponseEntity<String> desbloquear(@RequestParam String patente) {
        String resultado = alquilerService.desbloquearVehiculo(patente);
        return ResponseEntity.ok(resultado);
    }

    @PostMapping("/finalizar")
    public ResponseEntity<AlquilerResponseDTO> finalizar(
            @RequestParam String patente,
            @RequestParam int minutos,
            @RequestParam String condicionTarifa) {

        // Selección dinámica de la estrategia en tiempo de ejecución
        EstrategiaTarifa estrategia;
        if (condicionTarifa.equalsIgnoreCase("PICO")) {
            estrategia = new TarifaHoraPico();
        } else if (condicionTarifa.equalsIgnoreCase("CLIMA")) {
            estrategia = new TarifaTemporalClimatico();
        } else {
            estrategia = new TarifaEstandar();
        }

        AlquilerResponseDTO response = alquilerService.finalizarAlquiler(patente, minutos, estrategia);
        return ResponseEntity.ok(response);
    }
}