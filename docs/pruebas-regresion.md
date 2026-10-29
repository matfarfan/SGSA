# Pruebas de regresión — SGSA

## Etapa 5 — Verificación del comportamiento antes y después del refactoring

### 1. Objetivo

El objetivo de las pruebas de regresión es verificar que el Sistema de Gestión de Solicitudes Académicas (SGSA) conserve sus funcionalidades después de aplicar las técnicas de refactoring planificadas.

Para ello, se definió una batería de 14 pruebas automatizadas sobre la versión inicial del sistema. Esta misma batería se ejecutará nuevamente después de las modificaciones para comparar los resultados.

### 2. Entorno de pruebas

- Lenguaje: Java 21.
- Sistema de construcción: Gradle 9.3.0.
- Framework de pruebas: JUnit 6.
- Entorno de desarrollo: IntelliJ IDEA.
- Clase de pruebas: `SistemaSolicitudesTest.java`.
- Ubicación: `src/test/java/com/tup/programacion4/`.

### 3. Casos de prueba

| N.º | Caso de prueba | Comportamiento verificado |
|---|---|---|
| 1 | Registrar y buscar solicitud | Recuperación de una solicitud registrada |
| 2 | Buscar solicitud inexistente | Resultado nulo para un identificador inexistente |
| 3 | Registrar varias solicitudes | Recuperación de múltiples solicitudes |
| 4 | Verificar datos del estudiante | Conservación de legajo, nombre y apellido |
| 5 | Verificar tipo y prioridad | Conservación de los datos registrados |
| 6 | Asignar responsable | Actualización del responsable |
| 7 | Asignar responsable a solicitud inexistente | Operación sin excepciones |
| 8 | Cambiar estado | Actualización del estado |
| 9 | Cambiar estado de solicitud inexistente | Operación sin excepciones |
| 10 | Listar solicitudes | Visualización de solicitudes registradas |
| 11 | Listar sistema vacío | Respuesta ante ausencia de solicitudes |
| 12 | Filtrar solicitudes por estado | Visualización de solicitudes coincidentes |
| 13 | Filtrar estado sin coincidencias | Respuesta ante ausencia de coincidencias |
| 14 | Generar reporte | Presentación de cantidades y estados |

### 4. Resultados antes del refactoring

**Fecha de ejecución:** 29 de octubre de 2026.

**Comando utilizado:**

`.\gradlew.bat clean test`

**Resultados obtenidos:**

- Pruebas ejecutadas: 14.
- Pruebas aprobadas: 14.
- Pruebas fallidas: 0.
- Pruebas omitidas: 0.
- Porcentaje de éxito: 100 %.
- Resultado de Gradle: `BUILD SUCCESSFUL`.

La ejecución confirma que los 14 casos definidos finalizaron satisfactoriamente sobre la versión inicial del SGSA.

### 5. Evidencias

Las capturas correspondientes a la ejecución inicial se encuentran en:

`docs/evidencias/pruebas-antes/`

Archivos:

- `01-junit-14-pruebas-antes.png`
- `02-gradle-build-successful-antes.png`

### 6. Estrategia de comparación

Después de aplicar los cuatro refactorings, se volverá a ejecutar la misma batería de pruebas, sin modificar sus verificaciones originales.

Se compararán la cantidad de pruebas ejecutadas, los resultados obtenidos y la presencia de posibles regresiones.

### 7. Resultados después del refactoring

*Pendiente de completar una vez finalizadas las modificaciones.*

### 8. Conclusión preliminar

La ejecución inicial permitió establecer una línea base de regresión para el SGSA.

Los resultados obtenidos servirán como referencia para verificar que las mejoras estructurales realizadas mediante refactoring conserven el comportamiento previamente comprobado.