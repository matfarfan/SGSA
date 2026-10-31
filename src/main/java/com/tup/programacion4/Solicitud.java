package com.tup.programacion4;

public class Solicitud {
    private int id;
    private Estudiante estudiante;
    private String tipo;
    private String prioridad;
    private EstadoSolicitud estado;
    private Responsable responsable;


    public Solicitud(DatosSolicitud datos) {
        this.id = datos.getId();
        this.estudiante = datos.getEstudiante();
        this.tipo = datos.getTipo();
        this.prioridad = datos.getPrioridad();
        this.setEstado(datos.getEstado());
        this.responsable = null;
    }

    // Constructor original conservado por compatibilidad
    public Solicitud(int id, Estudiante estudiante, String tipo,
                     String prioridad, String estado) {
        this(new DatosSolicitud(id, estudiante, tipo, prioridad, estado));
    }


    public int getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado.getDescripcion();
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setEstado(String estado) {
        for (EstadoSolicitud valor : EstadoSolicitud.values()) {
            if (valor.getDescripcion().equalsIgnoreCase(estado)) {
                this.estado = valor;
                return;
            }
        }
        throw new IllegalArgumentException("Estado no válido: " + estado);
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}
