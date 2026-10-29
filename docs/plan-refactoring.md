# Plan de Refactoring — SGSA

## Etapa 5 — Planificación de mejoras

El objetivo de esta etapa es mejorar la calidad interna del Sistema de Gestión de Solicitudes Académicas (SGSA), aplicando cuatro refactorings controlados y documentados.

Las modificaciones se basarán en los code smells identificados y en el análisis de los principios SOLID y Clean Code.

## 1. Refactorings planificados

### Refactoring 1 — Extract Method

- **Clase:** `Main.java`.
- **Problema:** el método `main()` concentra múltiples operaciones.
- **Solución:** extraer métodos para organizar las opciones del menú.
- **Beneficio:** mejorar la legibilidad y el mantenimiento.

### Refactoring 2 — Reubicación de responsabilidades

- **Clase:** `SistemaSolicitudes.java`.
- **Problema:** combina lógica de gestión con mensajes por consola.
- **Solución:** trasladar la presentación a una clase específica.
- **Beneficio:** favorecer el principio de responsabilidad única (SRP).

### Refactoring 3 — Introduce Parameter Object

- **Clases:** `Solicitud.java` y componentes de registro.
- **Problema:** el constructor recibe varios datos individuales.
- **Solución:** crear un objeto que agrupe los parámetros necesarios para registrar una solicitud.
- **Beneficio:** simplificar el paso de datos y facilitar futuras modificaciones.

### Refactoring 4 — Reemplazo de cadenas por Enum

- **Clases:** `Solicitud.java` y `SistemaSolicitudes.java`.
- **Problema:** los estados se representan mediante cadenas de texto.
- **Solución:** definir un `enum` con los estados permitidos.
- **Beneficio:** mejorar la consistencia de los datos y reducir errores.

## 2. Estrategia de implementación

Los cambios se realizarán progresivamente, verificando el funcionamiento después de cada refactoring.

Antes de modificar el código se prepararán pruebas sobre el comportamiento original del sistema. Posteriormente, se ejecutarán nuevamente para detectar posibles regresiones.

## 3. Evidencias

Se documentarán los cambios mediante comparaciones del código antes y después, resultados de pruebas y commits en GitHub.

La versión original se conservará mediante el tag `estado-inicial`.

## 4. Resultado esperado

Se espera obtener un sistema más organizado, legible y mantenible, conservando las funcionalidades principales de la versión inicial.