
package com.tup.programacion4;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class SistemaSolicitudesTest {

    private Solicitud crearSolicitud(int id, String estado) {
        Estudiante estudiante =
                new Estudiante(1001, "Ana", "Garcia");

        return new Solicitud(
                id, estudiante, "Certificado",
                "Alta", estado
        );
    }

    private String capturarSalida(Runnable accion) {
        PrintStream salidaOriginal = System.out;
        ByteArrayOutputStream buffer =
                new ByteArrayOutputStream();

        try (PrintStream salida = new PrintStream(
                buffer, true, StandardCharsets.UTF_8)) {
            System.setOut(salida);
            accion.run();
        } finally {
            System.setOut(salidaOriginal);
        }

        return buffer.toString(StandardCharsets.UTF_8);
    }

    @Test
    void registrarYBuscarSolicitudPorId() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();
        Solicitud solicitud = crearSolicitud(101, "Pendiente");

        sistema.registrarSolicitud(solicitud);
        Solicitud resultado = sistema.buscarSolicitudPorId(101);

        assertNotNull(resultado);
        assertEquals(101, resultado.getId());
        assertEquals("Pendiente", resultado.getEstado());
    }

    @Test
    void buscarSolicitudInexistente() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        assertNull(sistema.buscarSolicitudPorId(999));
    }

    @Test
    void registrarVariasSolicitudes() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        sistema.registrarSolicitud(crearSolicitud(101, "Pendiente"));
        sistema.registrarSolicitud(crearSolicitud(102, "En proceso"));
        sistema.registrarSolicitud(crearSolicitud(103, "Finalizada"));

        assertNotNull(sistema.buscarSolicitudPorId(101));
        assertNotNull(sistema.buscarSolicitudPorId(102));
        assertNotNull(sistema.buscarSolicitudPorId(103));
    }

    @Test
    void verificarDatosDelEstudiante() {
        Solicitud solicitud = crearSolicitud(101, "Pendiente");
        Estudiante estudiante = solicitud.getEstudiante();

        assertNotNull(estudiante);
        assertEquals(1001, estudiante.getLegajo());
        assertEquals("Ana", estudiante.getNombre());
        assertEquals("Garcia", estudiante.getApellido());
    }

    @Test
    void verificarTipoYPrioridad() {
        Solicitud solicitud = crearSolicitud(101, "Pendiente");

        assertEquals("Certificado", solicitud.getTipo());
        assertEquals("Alta", solicitud.getPrioridad());
    }

    @Test
    void asignarResponsable() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();
        Responsable responsable =
                new Responsable(1, "Maria Lopez", "Secretaria");

        sistema.registrarSolicitud(crearSolicitud(101, "Pendiente"));
        sistema.asignarResponsable(101, responsable);

        Solicitud resultado = sistema.buscarSolicitudPorId(101);

        assertNotNull(resultado);
        assertNotNull(resultado.getResponsable());
        assertEquals(1, resultado.getResponsable().getId());
        assertEquals("Maria Lopez",
                resultado.getResponsable().getNombre());
    }

    @Test
    void asignarResponsableASolicitudInexistente() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();
        Responsable responsable =
                new Responsable(2, "Carlos", "Administracion");

        assertDoesNotThrow(() ->
                sistema.asignarResponsable(999, responsable));

        assertNull(sistema.buscarSolicitudPorId(999));
    }

    @Test
    void cambiarEstado() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        sistema.registrarSolicitud(crearSolicitud(101, "Pendiente"));
        sistema.cambiarEstado(101, "En proceso");

        Solicitud resultado = sistema.buscarSolicitudPorId(101);

        assertNotNull(resultado);
        assertEquals("En proceso", resultado.getEstado());
    }

    @Test
    void cambiarEstadoDeSolicitudInexistente() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        assertDoesNotThrow(() ->
                sistema.cambiarEstado(999, "Finalizada"));

        assertNull(sistema.buscarSolicitudPorId(999));
    }

    @Test
    void listarSolicitudes() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        sistema.registrarSolicitud(crearSolicitud(101, "Pendiente"));
        sistema.registrarSolicitud(crearSolicitud(102, "Finalizada"));

        String salida = capturarSalida(sistema::listarSolicitudes);

        assertTrue(salida.contains("101"));
        assertTrue(salida.contains("102"));
        assertTrue(salida.contains("Certificado"));
    }

    @Test
    void listarSistemaVacio() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        String salida = capturarSalida(sistema::listarSolicitudes);

        assertFalse(salida.isBlank());
        assertFalse(salida.contains("101"));
    }

    @Test
    void filtrarSolicitudesPorEstado() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        sistema.registrarSolicitud(crearSolicitud(101, "Pendiente"));
        sistema.registrarSolicitud(crearSolicitud(102, "Finalizada"));

        String salida = capturarSalida(
                () -> sistema.listarPorEstado("Pendiente"));

        assertTrue(salida.contains("101"));
        assertFalse(salida.contains("102"));
    }

    @Test
    void filtrarEstadoSinCoincidencias() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        sistema.registrarSolicitud(crearSolicitud(101, "Pendiente"));

        String salida = capturarSalida(
                () -> sistema.listarPorEstado("Finalizada"));

        assertFalse(salida.isBlank());
        assertFalse(salida.contains("101"));
    }

    @Test
    void generarReporte() {
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        sistema.registrarSolicitud(crearSolicitud(101, "Pendiente"));
        sistema.registrarSolicitud(crearSolicitud(102, "Pendiente"));
        sistema.registrarSolicitud(crearSolicitud(103, "En proceso"));
        sistema.registrarSolicitud(crearSolicitud(104, "Finalizada"));

        String salida = capturarSalida(sistema::generarReporte);

        assertTrue(salida.contains("4"));
        assertTrue(salida.contains("2"));
        assertTrue(salida.contains("1"));
        assertTrue(salida.contains("Pendiente"));
        assertTrue(salida.contains("En proceso"));
        assertTrue(salida.contains("Finalizada"));
    }
}
