# Pruebas de regresión — SGSA

## Etapa 5 — Verificación del comportamiento antes y después del refactoring

### 1. Objetivo

El objetivo de las pruebas de regresión es verificar que el Sistema de Gestión de Solicitudes Académicas (SGSA) conserve sus funcionalidades después de aplicar las técnicas de refactoring planificadas.

Para ello, se definió una batería de 14 pruebas automatizadas sobre la versión inicial del sistema. Esta misma batería se ejecutó nuevamente después de las modificaciones para comparar los resultados.

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

Después de aplicar los cuatro refactorings, se volvió a ejecutar la misma batería de pruebas, sin modificar sus verificaciones originales.

Se compaparon la cantidad de pruebas ejecutadas, los resultados obtenidos y la presencia de posibles regresiones.

### 7. Resultados después del refactoring

**Fecha de ejecución:** 31 de octubre de 2026.

Una vez implementados los cuatro refactorings —Extract Method, Move Method, Introduce Parameter Object y Replace String with Enum— se ejecutó nuevamente la batería original de pruebas automatizadas.

**Comando utilizado:**

`.\gradlew.bat clean test`

**Resultados obtenidos:**

- Pruebas ejecutadas: 14.
- Pruebas aprobadas: 14.
- Pruebas fallidas: 0.
- Pruebas omitidas: 0.
- Porcentaje de éxito: 100 %.
- Resultado de Gradle: `BUILD SUCCESSFUL`.

Se mantuvo la misma clase `SistemaSolicitudesTest.java`, sin modificar los casos de prueba originales.

#### 7.1. Comparación de resultados

| Indicador | Antes del refactoring | Después del refactoring |
|---|---|---|
| Pruebas ejecutadas | 14 | 14 |
| Pruebas aprobadas | 14 | 14 |
| Pruebas fallidas | 0 | 0 |
| Pruebas omitidas | 0 | 0 |
| Porcentaje de éxito | 100 % | 100 % |
| Resultado de Gradle | BUILD SUCCESSFUL | BUILD SUCCESSFUL |

La comparación muestra que los 14 casos de prueba conservaron sus resultados satisfactorios después de aplicar las modificaciones.

#### 7.2. Prueba funcional complementaria

Además de las pruebas automatizadas, se realizó una verificación manual del manejo de estados incorrectos.

Se registró una solicitud con ID `100` y posteriormente se intentó cambiar su estado al valor no permitido `cancelada`.

El sistema mostró el mensaje:

`Estado no válido. Ingrese Pendiente, En proceso o Finalizada.`

Después de informar el error, el menú volvió a mostrarse y el programa continuó funcionando.

Esta verificación permitió comprobar el manejo de errores incorporado durante el cuarto refactoring.

#### 7.3. Evidencias posteriores

Las capturas de las pruebas realizadas después de las modificaciones se encuentran en:

- `docs/evidencias/refactoring-4/04-gradle-build-successful.png`
- `docs/evidencias/refactoring-4/05-junit-14-pruebas-despues.png`
- `docs/evidencias/refactoring-4/08-validacion-estado-invalido.png`

Estas evidencias complementan las capturas iniciales y permiten documentar la comparación antes y después del refactoring.

### 8. Conclusión final

Las pruebas de regresión permitieron comparar el comportamiento del SGSA antes y después de aplicar cuatro técnicas de refactoring.

En ambas versiones se ejecutaron los mismos 14 casos de prueba automatizados, obteniéndose un porcentaje de aprobación del 100 %, sin fallos ni pruebas omitidas.

Estos resultados indican que las modificaciones estructurales conservaron el comportamiento esperado de las funcionalidades cubiertas por las pruebas.

Adicionalmente, la verificación manual del ingreso de un estado incorrecto permitió comprobar que el sistema informa el error y continúa funcionando.

Si bien las pruebas realizadas no garantizan la ausencia absoluta de defectos, proporcionan evidencia de que las mejoras de organización, separación de responsabilidades y validación de estados no introdujeron regresiones detectables en los escenarios evaluados.

Por lo tanto, se considera satisfactorio el resultado de la etapa de pruebas de regresión del SGSA.