package com.tup.programacion4;

public class DatosSolicitud {

    private final int id;
    private final Estudiante estudiante;
    private final String tipo;
    private final String prioridad;
    private final String estado;

    public DatosSolicitud(int id, Estudiante estudiante,
                          String tipo, String prioridad, String estado) {
        this.id = id;
        this.estudiante = estudiante;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.estado = estado;
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
        return estado;
    }
}
