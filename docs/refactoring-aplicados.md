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

## 2. Refactoring 2 — Reubicación de responsabilidades

### 2.1. Situación inicial

La clase `SistemaSolicitudes.java` concentraba las operaciones de gestión de solicitudes académicas y la presentación de sus datos por consola.

En particular, el método `mostrarSolicitud(Solicitud solicitud)` incluía múltiples instrucciones `System.out.println()` para mostrar el ID, los datos del estudiante, el tipo, la prioridad, el estado y el responsable de cada solicitud.

Esta organización mezclaba responsabilidades y dificultaba el mantenimiento del código.

### 2.2. Técnica aplicada

Se aplicó la técnica **Move Method (reubicación de responsabilidades)**, trasladando la lógica de presentación del método `mostrarSolicitud()` a una nueva clase denominada `PresentadorSolicitudes.java`.

Se mantuvo el método original en `SistemaSolicitudes.java`, pero su implementación pasó a delegar la presentación en la nueva clase.

### 2.3. Resultado de la modificación

Se realizaron los siguientes cambios:

- Se creó la clase `PresentadorSolicitudes.java` dentro del paquete `com.tup.programacion4`.
- Se trasladaron las instrucciones de presentación del detalle de una solicitud a dicha clase.
- Se modificó `SistemaSolicitudes.mostrarSolicitud()` para delegar la ejecución a `PresentadorSolicitudes.mostrarSolicitud()`.
- Se conservó la firma pública del método original para mantener la compatibilidad con las llamadas existentes.

La modificación permitió separar parcialmente la lógica de gestión de solicitudes de su presentación por consola.

### 2.4. Relación con SOLID y Clean Code

El refactoring se relaciona con el **Principio de Responsabilidad Única (SRP)** de SOLID, ya que permite asignar la presentación detallada de solicitudes a una clase específica.

También favorece los principios de Clean Code al mejorar la organización, la legibilidad y la mantenibilidad.

La separación es parcial, dado que otros métodos de `SistemaSolicitudes.java` todavía contienen instrucciones de salida por consola.

### 2.5. Verificación

Después de aplicar el refactoring se ejecutó el comando:

`.\gradlew.bat clean test`

**Resultados obtenidos:**

- Pruebas ejecutadas: 14.
- Pruebas aprobadas: 14.
- Pruebas fallidas: 0.
- Pruebas omitidas: 0.
- Porcentaje de éxito: 100 %.
- Resultado de Gradle: `BUILD SUCCESSFUL`.

Se ejecutaron las mismas pruebas de regresión utilizadas antes de aplicar las modificaciones, sin alterar sus casos de prueba.

Los resultados permiten comprobar que las funcionalidades cubiertas por las pruebas conservaron su comportamiento esperado.

### 2.6. Evidencias

Las evidencias se encuentran en:

`docs/evidencias/refactoring-2/`

Se incluyen las siguientes capturas:

- `01-sistema-solicitudes-antes.png`: implementación original de la clase.
- `02-sistema-solicitudes-despues.png`: método modificado que delega la presentación.
- `03-presentador-solicitudes-despues.png`: nueva clase encargada de mostrar los datos.
- `04-pruebas-regresion-despues.png`: informe JUnit con 14 pruebas aprobadas.
- `05-gradle-build-successful.png`: ejecución exitosa de las pruebas mediante Gradle.

### 2.7. Conclusión

La aplicación de **Move Method (reubicación de responsabilidades)** permitió mejorar la distribución de responsabilidades del SGSA y reducir la concentración de tareas en `SistemaSolicitudes.java`.

El cambio mejoró la estructura interna del código sin modificar intencionalmente su comportamiento funcional, obteniéndose resultados satisfactorios en las pruebas de regresión.