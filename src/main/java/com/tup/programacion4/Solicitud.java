package com.tup.programacion4;

public class Solicitud {
    private int id;
    private Estudiante estudiante;
    private String tipo;
    private String prioridad;
    private String estado;
    private Responsable responsable;

    public Solicitud(int id, Estudiante estudiante, String tipo,
                     String prioridad, String estado) {
        this.id = id;
        this.estudiante = estudiante;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.estado = estado;
        this.responsable = null;
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

    public Responsable getResponsable() {
        return responsable;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}
