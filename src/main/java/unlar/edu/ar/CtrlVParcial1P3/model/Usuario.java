package unlar.edu.ar.CtrlVParcial1P3.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String idUsuario;
    private String nombreCompleto;
    private String tipoUsuario; // "REGULAR" o "PREMIUM"
}