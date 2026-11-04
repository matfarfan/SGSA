# Sistema de Gestión de Solicitudes Académicas (SGSA)

**Trabajo Práctico Integrador — Metodología de Sistemas II**

**Carrera:** Tecnicatura Universitaria en Programación  
**Institución:** Universidad Tecnológica Nacional (UTN)  
**Estudiante:** Matías Farfán  
**Año:** 2026

## 1. Descripción del proyecto

El Sistema de Gestión de Solicitudes Académicas (SGSA) es una aplicación de consola desarrollada en Java 21 que permite registrar, consultar y administrar solicitudes estudiantiles.

El proyecto se utilizó para analizar la calidad del software, identificar problemas de diseño y aplicar mejoras mediante principios SOLID, Clean Code y técnicas de refactoring.

## 2. Funcionalidades

- Registrar solicitudes académicas.
- Listar y buscar solicitudes por identificador.
- Filtrar solicitudes por estado.
- Asignar responsables.
- Modificar el estado de las solicitudes.
- Generar reportes.

Los datos se almacenan temporalmente en memoria mediante `ArrayList`.

## 3. Tecnologías utilizadas

- Java 21.
- IntelliJ IDEA.
- Gradle.
- JUnit.
- Git y GitHub.
- Mermaid para los diagramas UML.

## 4. Mejoras implementadas

Se aplicaron cuatro técnicas de refactoring:

1. **Extract Method:** reorganización de las operaciones de `Main`.
2. **Move Method:** incorporación de `PresentadorSolicitudes`.
3. **Introduce Parameter Object:** creación de `DatosSolicitud`.
4. **Replace String with Enum:** creación de `EstadoSolicitud`.

Estas modificaciones mejoraron la organización y mantenibilidad del código, conservando las funcionalidades verificadas.

## 5. Pruebas de regresión

Se ejecutaron 14 pruebas automatizadas con JUnit antes y después del refactoring.

| Resultado | Antes | Después |
|---|---|---|
| Pruebas ejecutadas | 14 | 14 |
| Pruebas aprobadas | 14 | 14 |
| Pruebas fallidas | 0 | 0 |

También se realizó una prueba manual para verificar el rechazo de estados no válidos.

## 6. Ejecución del proyecto

**Requisitos:** Java 21 instalado.

Para ejecutar las pruebas automatizadas desde la carpeta principal del proyecto:

```bash
./gradlew test
```

En Windows:

```powershell
.\gradlew.bat clean test
```

Para ejecutar la aplicación, abrir el proyecto en IntelliJ IDEA y ejecutar el método `main()` de la clase `Main`, ubicada en:

`src/main/java/com/tup/programacion4/Main.java`

## 7. Documentación y evidencias

La carpeta `docs/` contiene los análisis de calidad, el diagnóstico de code smells, el análisis SOLID y Clean Code, los refactorings, las pruebas de regresión, el Code Review y las conclusiones.

La carpeta `docs/evidencias/` incluye capturas de las pruebas, comparaciones de código y diagramas UML del estado inicial y refactorizado.

El informe final se encuentra en `docs/informe-final/`.

## 8. Control de versiones

Se utilizaron commits y etiquetas Git para documentar las etapas del proyecto.

**Etiquetas principales:**

- `estado-inicial`
- `estado-refactorizado`
- `etapa-diagnostico`
- `etapa-refactoring`
- `etapa-pruebas`
- `etapa-docs`

## 9. Conclusión

El TPI permitió aplicar un proceso de mejora de calidad del software mediante diagnóstico, refactoring controlado, pruebas automatizadas y revisión de código.

Las modificaciones mejoraron la legibilidad y mantenibilidad del SGSA sin introducir regresiones detectables en los escenarios evaluados.