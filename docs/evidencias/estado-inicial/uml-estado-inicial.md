# Diagrama UML de clases — Estado inicial del SGSA

Este diagrama representa la estructura original del Sistema de Gestión
de Solicitudes Académicas (SGSA), antes de aplicar refactoring.

Se incluyen las cinco clases Java, sus atributos, métodos y relaciones.

```mermaid
classDiagram
direction TB

    class Main {
        +main(String[] args) void
    }

    class SistemaSolicitudes {
        -ArrayList~Solicitud~ solicitudes
        +SistemaSolicitudes()
        +registrarSolicitud(Solicitud solicitud) void
        +listarSolicitudes() void
        +buscarSolicitudPorId(int id) Solicitud
        +listarPorEstado(String estado) void
        +asignarResponsable(int idSolicitud, Responsable responsable) void
        +cambiarEstado(int idSolicitud, String nuevoEstado) void
        +generarReporte() void
        +mostrarSolicitud(Solicitud solicitud) void
    }

    class Solicitud {
        -int id
        -Estudiante estudiante
        -String tipo
        -String prioridad
        -String estado
        -Responsable responsable
        +Solicitud(int id, Estudiante estudiante, String tipo, String prioridad, String estado)
        +getId() int
        +getEstudiante() Estudiante
        +getTipo() String
        +getPrioridad() String
        +getEstado() String
        +getResponsable() Responsable
        +setEstado(String estado) void
        +setResponsable(Responsable responsable) void
    }

    class Estudiante {
        -int legajo
        -String nombre
        -String apellido
        +Estudiante(int legajo, String nombre, String apellido)
        +getLegajo() int
        +getNombre() String
        +getApellido() String
    }

    class Responsable {
        -int id
        -String nombre
        -String area
        +Responsable(int id, String nombre, String area)
        +getId() int
        +getNombre() String
        +getArea() String
    }

    Main ..> SistemaSolicitudes : utiliza
    Main ..> Estudiante : crea
    Main ..> Responsable : crea
    Main ..> Solicitud : crea

    SistemaSolicitudes "1" o-- "0..*" Solicitud : administra
    SistemaSolicitudes ..> Responsable : asigna

    Solicitud "0..*" --> "1" Estudiante : pertenece a
    Solicitud "0..*" --> "0..1" Responsable : asignada a
```