# Diagnóstico de Code Smells y Deuda Técnica — SGSA

## Etapa 3 — Análisis del código original

Este documento identifica problemas de diseño y mantenimiento en la versión inicial del Sistema de Gestión de Solicitudes Académicas (SGSA).

Cada *code smell* se analiza considerando su ubicación, evidencia, impacto, riesgo y prioridad de mejora.

## 1. Método extenso (Long Method)

- **Ubicación:** `Main.java`, método `main()`.
- **Evidencia:** concentra el menú, la lectura de datos y la ejecución de las distintas operaciones.
- **Impacto:** dificulta la lectura, el mantenimiento y las modificaciones.
- **Riesgo:** medio.
- **Prioridad:** alta.
- **Mejora propuesta:** aplicar *Extract Method* para dividir las operaciones en métodos más pequeños.

## 2. Clase con múltiples responsabilidades

- **Ubicación:** `Main.java`.
- **Evidencia:** administra la interacción con el usuario, crea objetos y coordina las operaciones del sistema.
- **Impacto:** los cambios en diferentes funcionalidades pueden afectar una misma clase.
- **Riesgo:** alto.
- **Prioridad:** alta.
- **Mejora propuesta:** separar la interacción de consola de la coordinación de operaciones, respetando el principio de responsabilidad única (SRP).

## 3. Mezcla de lógica y presentación

- **Ubicación:** `SistemaSolicitudes.java`.
- **Evidencia:** métodos como `registrarSolicitud()`, `listarSolicitudes()` y `generarReporte()` combinan operaciones del sistema con mensajes mediante `System.out.println()`.
- **Impacto:** genera acoplamiento con la consola y dificulta las pruebas automatizadas.
- **Riesgo:** alto.
- **Prioridad:** alta.
- **Mejora propuesta:** separar la lógica de gestión de la presentación de resultados.

## 4. Uso de cadenas de texto para estados

- **Ubicación:** `Solicitud.java` y `SistemaSolicitudes.java`.
- **Evidencia:** el estado se representa mediante `String` y se compara con valores como `"Pendiente"`, `"En proceso"` y `"Finalizada"`.
- **Impacto:** permite valores inconsistentes y dificulta controlar los estados válidos.
- **Riesgo:** medio.
- **Prioridad:** media.
- **Mejora propuesta:** utilizar un tipo enumerado (`enum`) para representar los estados permitidos.

## 5. Validaciones de entrada incompletas

- **Ubicación:** `Main.java`.
- **Evidencia:** algunas entradas utilizan `Scanner.nextInt()` sin comprobar previamente que el usuario ingrese un número válido.
- **Impacto:** una entrada incorrecta puede interrumpir la ejecución del programa.
- **Riesgo:** alto.
- **Prioridad:** alta.
- **Mejora propuesta:** centralizar la lectura y validación de datos mediante métodos reutilizables.

## 6. Números mágicos (Magic Numbers)

- **Ubicación:** `Main.java`.
- **Evidencia:** se utilizan valores numéricos directamente para las opciones del menú y la selección de estudiantes y responsables.
- **Impacto:** dificulta comprender el significado de ciertos valores y modificar las opciones disponibles.
- **Riesgo:** bajo.
- **Prioridad:** media.
- **Mejora propuesta:** reemplazar los valores significativos por constantes con nombres descriptivos.

## 7. Falta de control de identificadores duplicados

- **Ubicación:** `SistemaSolicitudes.java`, método `registrarSolicitud()`.
- **Evidencia:** las solicitudes se agregan directamente al `ArrayList` sin verificar si existe otra con el mismo identificador.
- **Impacto:** pueden registrarse solicitudes duplicadas y producirse resultados ambiguos en las búsquedas.
- **Riesgo:** alto.
- **Prioridad:** alta.
- **Mejora propuesta:** verificar la existencia del identificador antes de registrar una nueva solicitud.

## 8. Exposición directa del estado interno

- **Ubicación:** `Solicitud.java`.
- **Evidencia:** los métodos públicos `setEstado()` y `setResponsable()` permiten modificar los atributos sin comprobar reglas de negocio.
- **Impacto:** pueden generarse estados inconsistentes o asignaciones no controladas.
- **Riesgo:** medio.
- **Prioridad:** media.
- **Mejora propuesta:** incorporar validaciones y controlar las modificaciones mediante operaciones específicas.

## 9. Matriz de priorización de deuda técnica

La priorización se establece considerando el impacto de cada problema sobre el funcionamiento, la mantenibilidad y la facilidad para realizar pruebas.

| N.º | Problema identificado | Riesgo | Prioridad |
|---|---|---|---|
| 1 | Método extenso | Medio | Alta |
| 2 | Múltiples responsabilidades | Alto | Alta |
| 3 | Mezcla de lógica y presentación | Alto | Alta |
| 4 | Estados representados con String | Medio | Media |
| 5 | Validaciones incompletas | Alto | Alta |
| 6 | Números mágicos | Bajo | Media |
| 7 | Identificadores duplicados | Alto | Alta |
| 8 | Modificación directa del estado interno | Medio | Media |

### Criterios de priorización

- **Prioridad alta:** problemas que pueden provocar errores, inconsistencias o dificultades importantes de mantenimiento.
- **Prioridad media:** problemas que afectan la claridad, la organización o la evolución del código, pero presentan menor riesgo inmediato.

## 10. Conclusión del diagnóstico

El análisis permitió identificar ocho problemas de calidad en el código original del SGSA.

Las principales oportunidades de mejora se relacionan con la separación de responsabilidades, las validaciones de datos y la organización de la lógica del sistema.

Este diagnóstico servirá como fundamento para evaluar los principios SOLID y Clean Code, planificar los refactorings y comprobar posteriormente que las funcionalidades originales se mantienen.