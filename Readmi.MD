-------------------
NOMBRES DE ALUMNOS.
-------------------

FRANCISCO ANTONIO GONZALEZ
VIRGINIA DEL VALLE VERA HERRERA
ISMAEL ALEJANDRO FLORES
VALENTINO LEMOR

--------------------------------------------------------------------------------
CASOS DE PRUEBA REST: ECORIDE PRO (UNIDADES 3 Y 4)
--------------------------------------------------------------------------------

CASO DE PRUEBA 1: Flujo Exitoso y Transición de Estado (Patrón State)
--------------------------------------------------------------------------------
* Validar que el sistema localiza el vehículo en O(1) y efectúa la transición de 
  fases ("EN_ESPERA" a "EN_VIAJE") bloqueando los accesos inválidos subsecuentes.

* Endpoint: POST /api/alquileres/desbloquear
* Parámetros (Query Params): 
  - patente: "AAA111"

* Verificar la sección 'Responses':
  - Code (Código HTTP): 200 OK
  - Response body: "Desbloqueo exitoso. Patente: AAA111"

CASO DE PRUEBA 2: Cálculo Adaptativo de Tarifa (Patrón Strategy)
--------------------------------------------------------------------------------
* Validar que el motor de cálculo inyecte la estrategia correcta en tiempo de 
  ejecución y procese el recargo por horario pico o temporal climático.

* Endpoint: POST /api/alquileres/finalizar
* Parámetros (Query Params):
  - patente: "AAA111"
  - minutos: "30"
  - condicionTarifa: "PICO"

* Verificar la sección 'Responses':
  - Code (Código HTTP): 200 OK
  - Response body (JSON): 
    {
      "patente": "AAA111",
      "tiempoTranscurrido": 30,
      "costoFinal": 21000.0,
      "faseActual": "EN_ESPERA"
    }

CASO DE PRUEBA 3: Alerta de Vehículo No Encontrado (Manejo Profesional de Errores)
--------------------------------------------------------------------------------
* Validar que la búsqueda optimizada en el mapa rechace identificadores inexistentes
  y dispare el manejador global de excepciones estandarizado.

* Endpoint: POST /api/alquileres/desbloquear
* Parámetros (Query Params):
  - patente: "XYZ999"

* Verificar la sección 'Responses':
  - Code (Código HTTP): 404 Not Found
  - Response body (JSON): Objeto de error estructurado con 'timestamp', 'status' y 
    el mensaje "Alarma del Sistema: Vehículo No Encontrado. Patente: XYZ999".

--------------------------------------------------------------------------------
ARQUITECTURA DEL SISTEMA (PATRONES DE DISEÑO Y EXPOSICIÓN DE DATOS)
--------------------------------------------------------------------------------

* Capa de Dominio (Model) - Patrones de Comportamiento Dinámico:
  Implementación estricta de patrones de diseño de la Unidad 3. El Patrón STATE gobierna 
  el ciclo de vida del vehículo mediante las implementaciones de la interfaz 
  'EstadoVehiculo' ('EstadoEnEspera', 'EstadoEnViaje', 'EstadoEnReparacion'), eliminando 
  las estructuras de control masivas. El Patrón STRATEGY inyecta los algoritmos 
  adaptativos de cálculo de tarifa ('TarifaEstandar', 'TarifaHoraPico', 
  'TarifaTemporalClimatico') desacoplando la lógica financiera del servicio principal.

* Capa de Servicios - Lógica Imperativa y Memoria Dinámica:
  'AlquilerService' centraliza el control de negocio gestionando el diccionario en memoria 
  (HashMap). 'FlotaService' y 'GpsService' aíslan la complejidad algorítmica de ordenamiento 
  y deduplicación utilizando colecciones óptimas, estrictamente bajo paradigmas 
  imperativos tradicionales sin inyección de expresiones Lambda.

* Controladores REST y Transferencia de Datos (DTO):
  Aislamiento bidireccional total. Los Controladores ('AlquilerController' y 
  'VehiculoController') exponen puntos de acceso seguros que delegan la lógica a los 
  servicios e intersecan las salidas a través de los objetos 'AlquilerResponseDTO' y 
  'VehiculoResponseDTO'. Esto previene fugas de metadatos de las entidades internas 
  y asegura una exposición profesional hacia la red.

* Infraestructura de Excepciones:
  Manejo estandarizado a través de 'GlobalExceptionHandler' (@RestControllerAdvice) 
  que intercepta fallos de negocio puros ('ResourceNotFoundException', 
  'InvalidVehicleStateException') mapeándolos a códigos de estado HTTP precisos (404, 409) 
  en payloads JSON inmutables.