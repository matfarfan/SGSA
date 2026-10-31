# Refactorings aplicados — SGSA

## Etapa 5 — Implementación de mejoras

Este documento registra las técnicas de refactoring aplicadas al Sistema de Gestión de Solicitudes Académicas (SGSA), sus objetivos, las modificaciones realizadas y las verificaciones efectuadas para comprobar la conservación del comportamiento funcional.

## 1. Refactoring 1 — Extract Method

### 1.1. Situación inicial

La clase `Main.java` contenía un método `main()` extenso que concentraba la inicialización del sistema, la presentación del menú, la lectura de datos y las operaciones correspondientes a las distintas opciones del `switch`.

Esta organización dificultaba la lectura del código y la identificación de las responsabilidades de cada bloque.

### 1.2. Técnica aplicada

Se utilizó la técnica **Extract Method**, que consiste en trasladar bloques de instrucciones a métodos independientes con nombres descriptivos.

Se extrajeron los siguientes métodos:

- `mostrarMenu()`
- `registrarSolicitud()`
- `buscarSolicitud()`
- `filtrarSolicitudesPorEstado()`
- `asignarResponsable()`
- `cambiarEstado()`

El método `main()` conserva la inicialización, el ciclo de ejecución y la selección de opciones, pero delega las operaciones a los métodos extraídos.

### 1.3. Resultado de la modificación

La estructura del `switch` quedó simplificada, permitiendo reconocer las operaciones del sistema mediante llamadas a métodos con nombres descriptivos.

El cambio mejoró la organización y legibilidad de `Main.java` sin modificar intencionalmente las funcionalidades existentes.

### 1.4. Verificación

Después de aplicar el refactoring se ejecutó el comando:

`.\gradlew.bat clean test`

**Resultado:** `BUILD SUCCESSFUL`.

También se realizó una verificación manual desde la consola, comprobando el registro, la consulta, el filtrado, el cambio de estado y la finalización del sistema.

### 1.5. Evidencias

Las evidencias se encuentran en:

`docs/evidencias/refactoring-1/`

Incluyen la comparación de la estructura del `switch` antes y después, los métodos extraídos y la verificación funcional por consola.

### 1.6. Conclusión

La aplicación de **Extract Method** permitió reducir la complejidad del método principal, mejorar la separación de operaciones y facilitar futuras modificaciones.

La estructura interna del código fue reorganizada, manteniendo el comportamiento verificado del SGSA.