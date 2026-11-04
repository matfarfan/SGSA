# Diagrama UML de clases — Estado refactorizado del SGSA

Este diagrama representa la estructura final del Sistema de Gestión de Solicitudes Académicas (SGSA), después de aplicar los cuatro refactorings.

Se incluyen las ocho clases Java, sus atributos, métodos y relaciones, reflejando las mejoras realizadas en la organización y mantenibilidad del código.

```mermaid
classDiagram
direction TB

class Main {
    +main(String[] args)$ void
    -mostrarMenu()$ void
    -registarSolicitud(Scanner scanner, Estudiante estudiante1, Estudiante estudiante2, SistemaSolicitudes sistema)$ void
    -buscarSolicitud(Scanner scanner, SistemaSolicitudes sistema)$ void
    -filtrarSolicitudesPorEstado(Scanner scanner, SistemaSolicitudes sistema)$ void
    -asignarResponsable(Scanner scanner, Responsable responsable1, Responsable responsable2, SistemaSolicitudes sistema)$ void
    -cambiarEstado(Scanner scanner, SistemaSolicitudes sistema)$ void
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
    -EstadoSolicitud estado
    -Responsable responsable
    +Solicitud(DatosSolicitud datos)
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

class DatosSolicitud {
    -int id
    -Estudiante estudiante
    -String tipo
    -String prioridad
    -String estado
    +DatosSolicitud(int id, Estudiante estudiante, String tipo, String prioridad, String estado)
    +getId() int
    +getEstudiante() Estudiante
    +getTipo() String
    +getPrioridad() String
    +getEstado() String
}

class EstadoSolicitud {
    <<enumeration>>
    PENDIENTE
    EN_PROCESO
    FINALIZADA
    -String descripcion
    +getDescripcion() String
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

class PresentadorSolicitudes {
    +mostrarSolicitud(Solicitud solicitud) void
}

Main ..> SistemaSolicitudes : utiliza
Main ..> DatosSolicitud : crea
Main ..> Estudiante : crea
Main ..> Responsable : crea

SistemaSolicitudes "1" --> "0..*" Solicitud : administra
SistemaSolicitudes ..> PresentadorSolicitudes : delega

Solicitud --> "1" Estudiante : pertenece a
Solicitud --> "0..1" Responsable : asignado a
Solicitud --> EstadoSolicitud : utiliza
Solicitud ..> DatosSolicitud : recibe

DatosSolicitud --> Estudiante : contiene
PresentadorSolicitudes ..> Solicitud : muestra
```