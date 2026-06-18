package unlar.edu.ar.CtrlVParcial1P3.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class GpsService {

    public List<String> deduplicarAlertas(List<String> reportesConDuplicados) {
        HashSet<String> setUnicos = new HashSet<>();
        List<String> reportesLimpios = new ArrayList<>();

        for (int i = 0; i < reportesConDuplicados.size(); i++) {
            String reporte = reportesConDuplicados.get(i);
            // El método add() en HashSet retorna true solo si el elemento no existía previamente
            if (setUnicos.add(reporte)) {
                reportesLimpios.add(reporte);
            }
        }
        
        return reportesLimpios;
    }
}