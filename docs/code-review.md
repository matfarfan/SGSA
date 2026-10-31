# Code Review — SGSA

## 1. Objetivo

Revisar la calidad del código del Sistema de Gestión de Solicitudes Académicas (SGSA) después de aplicar los cuatro refactorings, identificando mejoras implementadas y oportunidades de mantenimiento.

## 2. Clases revisadas

Se analizaron las ocho clases de producción: `Main`, `SistemaSolicitudes`, `Solicitud`, `DatosSolicitud`, `EstadoSolicitud`, `PresentadorSolicitudes`, `Estudiante` y `Responsable`.

## 3. Resultados de la revisión

**Aspectos positivos:**

- **Extract Method:** `Main` presenta métodos más pequeños y organizados.
- **Move Method:** `PresentadorSolicitudes` concentra la visualización detallada de solicitudes.
- **Introduce Parameter Object:** `DatosSolicitud` agrupa los parámetros de construcción.
- **Replace String with Enum:** `EstadoSolicitud` restringe los estados permitidos.
- Se mantuvo la compatibilidad con las funcionalidades existentes.

**Oportunidades de mejora:**

| Prioridad | Observación | Recomendación |
|---|---|---|
| Alta | Entradas numéricas y opciones sin validación completa en `Main`. | Validar las entradas antes de procesarlas. |
| Alta | No se controlan IDs duplicados al registrar solicitudes. | Verificar la unicidad del identificador. |
| Media | `SistemaSolicitudes` conserva lógica de presentación. | Completar la separación de responsabilidades. |
| Media | Faltan validaciones de datos nulos, vacíos o inválidos. | Incorporar controles en los constructores. |
| Baja | Existen cadenas de estado en reportes y objetos de parámetros. | Centralizar su tratamiento mediante `EstadoSolicitud`. |
| Baja | Algunos atributos podrían ser `final` y existe un error tipográfico en `registarSolicitud`. | Mejorar la inmutabilidad y los nombres. |

## 4. Verificación

La versión refactorizada superó las **14 pruebas automatizadas de regresión**, sin fallos, al igual que la versión inicial.

También se comprobó manualmente que el sistema rechaza un estado no válido sin finalizar la ejecución.

Las evidencias se encuentran en `docs/evidencias/` y los resultados en `docs/pruebas-regresion.md`.

## 5. Conclusión

Los cuatro refactorings mejoraron la legibilidad, organización y mantenibilidad del SGSA sin alterar su comportamiento esperado.

Las observaciones pendientes se registran como deuda técnica para futuras mejoras. No se realizaron nuevas modificaciones durante el Code Review, preservando la versión validada mediante pruebas y registrada en GitHub con el tag `estado-refactorizado`.