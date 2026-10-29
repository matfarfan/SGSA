# Sistema de Gestión de Solicitudes Académicas (SGSA)

## 1. Descripción general

El Sistema de Gestión de Solicitudes Académicas (SGSA) es una aplicación de consola desarrollada en Java que permite administrar solicitudes realizadas por estudiantes de una institución educativa.

El sistema fue construido como prototipo inicial para el Trabajo Práctico Integrador de Metodología de Sistemas II, con el propósito de analizar su calidad interna y externa e implementar posteriormente mejoras mediante principios SOLID, Clean Code y técnicas de refactoring.

## 2. Dominio del sistema

El sistema pertenece al ámbito de la gestión administrativa académica.

Su finalidad es facilitar el registro, la consulta y el seguimiento de solicitudes estudiantiles, como constancias de alumno regular, certificados y otros trámites académicos.

## 3. Objetivo

Desarrollar un sistema básico que permita gestionar solicitudes académicas y utilizarlo como punto de partida para identificar problemas de diseño, deuda técnica y oportunidades de mejora de la mantenibilidad del código.

## 4. Alcance funcional

La versión inicial permite:

1. Registrar solicitudes académicas.
2. Listar las solicitudes registradas.
3. Buscar una solicitud mediante su identificador.
4. Filtrar solicitudes según su estado.
5. Asignar un responsable a una solicitud.
6. Modificar el estado de una solicitud.
7. Generar un reporte con la cantidad de solicitudes por estado.

También permite finalizar la ejecución mediante una opción del menú principal.

## 5. Actores

**Personal administrativo:** usuario principal del sistema. Registra solicitudes, consulta información, asigna responsables y actualiza estados.

**Estudiante:** persona que realiza la solicitud académica. En esta versión inicial, sus datos son utilizados por el personal administrativo y no interactúa directamente con la aplicación.

**Responsable:** persona o integrante de un área institucional encargada de gestionar una solicitud.

## 6. Entidades principales

**Estudiante:** representa a un estudiante mediante su legajo, nombre y apellido.

**Responsable:** representa a una persona encargada de gestionar solicitudes. Contiene identificador, nombre y área.

**Solicitud:** representa un trámite académico. Contiene identificador, estudiante, tipo, prioridad, estado y responsable asignado.

## 7. Estructura inicial del sistema

El proyecto está organizado en cinco clases Java:

- `Main.java`: contiene el punto de entrada, el menú y la interacción con el usuario.
- `Estudiante.java`: representa los datos de los estudiantes.
- `Responsable.java`: representa los datos de los responsables.
- `Solicitud.java`: representa las solicitudes académicas.
- `SistemaSolicitudes.java`: administra las solicitudes y sus operaciones principales.

## 8. Tecnologías utilizadas

- Lenguaje de programación: Java 21.
- Entorno de desarrollo: IntelliJ IDEA.
- Sistema de construcción: Gradle.
- Interfaz de usuario: consola.
- Almacenamiento: colección `ArrayList` en memoria.

## 9. Funcionamiento y verificaciones iniciales

Se realizaron pruebas manuales sobre las funcionalidades principales del sistema.

Se verificó el registro de una solicitud, su listado, la búsqueda por identificador, la búsqueda de un identificador inexistente, el filtrado por estado, la asignación de un responsable, el cambio de estado y la generación de un reporte.

También se comprobó que el programa finaliza correctamente.

Las capturas de estas pruebas se encuentran en:

`docs/evidencias/estado-inicial/`

## 10. Limitaciones del sistema inicial

La información se almacena temporalmente en memoria, por lo que se pierde cuando finaliza la ejecución.

El sistema utiliza una interfaz de consola y no dispone de base de datos ni autenticación de usuarios.

La versión inicial se conservará sin refactorizar para realizar posteriormente un diagnóstico de calidad interna, identificar code smells y aplicar mejoras controladas sin alterar negativamente su comportamiento externo.

## 11. Propósito dentro del TPI

El SGSA será utilizado como sistema base para desarrollar las ocho etapas obligatorias del Trabajo Práctico Integrador.

Se conservará una versión inicial y se generará una versión refactorizada, documentando los problemas identificados, las decisiones técnicas, los cambios realizados y las pruebas de verificación correspondientes.