package com.tup.programacion4;

public class Estudiante {
    private int legajo;
    private String nombre;
    private String apellido;

    public Estudiante(int legajo, String nombre, String apellido) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
