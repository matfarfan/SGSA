package com.tup.programacion4;

public class PresentadorSolicitudes {

    public void mostrarSolicitud(Solicitud solicitud) {
        System.out.println("------------------------------");
        System.out.println("ID: " + solicitud.getId());
        System.out.println("Estudiante: "
                + solicitud.getEstudiante().getNombre() + " "
                + solicitud.getEstudiante().getApellido());
        System.out.println("Tipo: " + solicitud.getTipo());
        System.out.println("Prioridad: " + solicitud.getPrioridad());
        System.out.println("Estado: " + solicitud.getEstado());

        if (solicitud.getResponsable() != null) {
            System.out.println("Responsable: "
                    + solicitud.getResponsable().getNombre());
        } else {
            System.out.println("Responsable: Sin asignar");
        }
    }
}
