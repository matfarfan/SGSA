package com.tup.programacion4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SistemaSolicitudes sistema = new SistemaSolicitudes();

        // Datos ficticios para probar el sistema
        Estudiante estudiante1 = new Estudiante(1001, "Ana", "Garcia");
        Estudiante estudiante2 = new Estudiante(1002, "Lucas", "Perez");

        Responsable responsable1 =
                new Responsable(1, "Maria Lopez", "Secretaria Academica");
        Responsable responsable2 =
                new Responsable(2, "Carlos Ruiz", "Departamento de Alumnos");

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n====================================");
            System.out.println(" SISTEMA DE SOLICITUDES ACADEMICAS");
            System.out.println("====================================");
            System.out.println("1. Registrar solicitud");
            System.out.println("2. Listar solicitudes");
            System.out.println("3. Buscar solicitud por ID");
            System.out.println("4. Filtrar solicitudes por estado");
            System.out.println("5. Asignar responsable");
            System.out.println("6. Cambiar estado");
            System.out.println("7. Generar reporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar un numero.");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese ID de solicitud: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Seleccione estudiante:");
                    System.out.println("1. Ana Garcia");
                    System.out.println("2. Lucas Perez");
                    int estudianteElegido = scanner.nextInt();
                    scanner.nextLine();

                    Estudiante estudiante =
                            estudianteElegido == 1 ? estudiante1 : estudiante2;

                    System.out.print("Ingrese tipo de solicitud: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Ingrese prioridad (Alta/Media/Baja): ");
                    String prioridad = scanner.nextLine();

                    Solicitud nuevaSolicitud = new Solicitud(
                            id, estudiante, tipo, prioridad, "Pendiente"
                    );

                    sistema.registrarSolicitud(nuevaSolicitud);
                    break;

                case 2:
                    sistema.listarSolicitudes();
                    break;

                case 3:
                    System.out.print("Ingrese ID de solicitud: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();

                    Solicitud encontrada =
                            sistema.buscarSolicitudPorId(idBuscar);

                    if (encontrada != null) {
                        sistema.mostrarSolicitud(encontrada);
                    } else {
                        System.out.println("Solicitud no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese estado a buscar: ");
                    String estadoBuscar = scanner.nextLine();
                    sistema.listarPorEstado(estadoBuscar);
                    break;

                case 5:
                    System.out.print("Ingrese ID de solicitud: ");
                    int idAsignar = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Seleccione responsable:");
                    System.out.println("1. Maria Lopez");
                    System.out.println("2. Carlos Ruiz");
                    int responsableElegido = scanner.nextInt();
                    scanner.nextLine();

                    Responsable responsable =
                            responsableElegido == 1
                                    ? responsable1 : responsable2;

                    sistema.asignarResponsable(idAsignar, responsable);
                    break;

                case 6:
                    System.out.print("Ingrese ID de solicitud: ");
                    int idEstado = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print(
                            "Ingrese nuevo estado (Pendiente/En proceso/Finalizada): "
                    );
                    String nuevoEstado = scanner.nextLine();

                    sistema.cambiarEstado(idEstado, nuevoEstado);
                    break;

                case 7:
                    sistema.generarReporte();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }

        scanner.close();
    }
}