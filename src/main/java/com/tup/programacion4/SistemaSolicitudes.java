
package com.tup.programacion4;

import java.util.ArrayList;

public class SistemaSolicitudes {

    private ArrayList<Solicitud> solicitudes;

    public SistemaSolicitudes() {
        solicitudes = new ArrayList<>();
    }

    // Registrar una nueva solicitud
    public void registrarSolicitud(Solicitud solicitud) {
        solicitudes.add(solicitud);
        System.out.println("Solicitud registrada correctamente.");
    }

    // Listar todas las solicitudes
    public void listarSolicitudes() {
        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes registradas.");
        } else {
            for (Solicitud solicitud : solicitudes) {
                mostrarSolicitud(solicitud);
            }
        }
    }

    // Buscar una solicitud por ID
    public Solicitud buscarSolicitudPorId(int id) {
        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getId() == id) {
                return solicitud;
            }
        }
        return null;
    }

    // Filtrar solicitudes por estado
    public void listarPorEstado(String estado) {
        boolean encontrada = false;

        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getEstado().equalsIgnoreCase(estado)) {
                mostrarSolicitud(solicitud);
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No se encontraron solicitudes con ese estado.");
        }
    }

    // Asignar un responsable a una solicitud
    public void asignarResponsable(int idSolicitud, Responsable responsable) {
        Solicitud solicitud = buscarSolicitudPorId(idSolicitud);

        if (solicitud != null) {
            solicitud.setResponsable(responsable);
            System.out.println("Responsable asignado correctamente.");
        } else {
            System.out.println("Solicitud no encontrada.");
        }
    }

    // Cambiar el estado de una solicitud
    public void cambiarEstado(int idSolicitud, String nuevoEstado) {
        Solicitud solicitud = buscarSolicitudPorId(idSolicitud);

        if (solicitud != null) {
            solicitud.setEstado(nuevoEstado);
            System.out.println("Estado actualizado correctamente.");
        } else {
            System.out.println("Solicitud no encontrada.");
        }
    }

    // Generar un reporte simple
    public void generarReporte() {
        int pendientes = 0;
        int enProceso = 0;
        int finalizadas = 0;

        for (Solicitud solicitud : solicitudes) {
            if (solicitud.getEstado().equalsIgnoreCase("Pendiente")) {
                pendientes++;
            } else if (solicitud.getEstado().equalsIgnoreCase("En proceso")) {
                enProceso++;
            } else if (solicitud.getEstado().equalsIgnoreCase("Finalizada")) {
                finalizadas++;
            }
        }

        System.out.println("===== REPORTE DE SOLICITUDES =====");
        System.out.println("Total: " + solicitudes.size());
        System.out.println("Pendientes: " + pendientes);
        System.out.println("En proceso: " + enProceso);
        System.out.println("Finalizadas: " + finalizadas);
    }

    // Mostrar los datos de una solicitud
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
