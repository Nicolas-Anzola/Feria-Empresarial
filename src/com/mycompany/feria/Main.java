package com.mycompany.feria;

import java.util.Scanner;

/**
 * Clase principal que muestra un menú para interactuar con la Feria Empresarial.
 */
public class Main {
    public static void main(String[] args) {
        Feria feria = new Feria();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== FERIA EMPRESARIAL ===");
            System.out.println("1. Registrar empresa");
            System.out.println("2. Registrar stand");
            System.out.println("3. Asignar stand a empresa");
            System.out.println("4. Registrar visitante");
            System.out.println("5. Registrar visita");
            System.out.println("6. Reporte empresas y stands");
            System.out.println("7. Reporte visitantes y visitas");
            System.out.println("8. Reporte calificación promedio por stand");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre empresa: ");
                    String nombreE = sc.nextLine();
                    System.out.print("Sector: ");
                    String sector = sc.nextLine();
                    System.out.print("Correo: ");
                    String correoE = sc.nextLine();
                    feria.registrarEmpresa(new Empresa(nombreE, sector, correoE));
                    break;

                case 2:
                    System.out.print("Número de stand: ");
                    int numStand = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ubicación: ");
                    String ubicacion = sc.nextLine();
                    System.out.print("Tamaño: ");
                    String tamaño = sc.nextLine();
                    feria.registrarStand(new Stand(numStand, ubicacion, tamaño));
                    break;

                case 3:
                    System.out.print("Número de stand: ");
                    int standAsignar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre empresa: ");
                    String nombreEmp = sc.nextLine();
                    Empresa empAsignar = feria.getEmpresas().stream()
                            .filter(e -> e.getNombre().equalsIgnoreCase(nombreEmp))
                            .findFirst().orElse(null);
                    if (empAsignar != null) {
                        feria.asignarStand(standAsignar, empAsignar);
                    } else {
                        System.out.println("❌ Empresa no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Nombre visitante: ");
                    String nombreV = sc.nextLine();
                    System.out.print("Identificación: ");
                    String idV = sc.nextLine();
                    System.out.print("Correo: ");
                    String correoV = sc.nextLine();
                    feria.registrarVisitante(new Visitante(nombreV, idV, correoV));
                    break;

                case 5:
                    System.out.print("ID visitante: ");
                    String idVisit = sc.nextLine();
                    Visitante visitante = feria.getVisitantes().stream()
                            .filter(v -> v.getIdentificacion().equalsIgnoreCase(idVisit))
                            .findFirst().orElse(null);
                    if (visitante == null) {
                        System.out.println("❌ Visitante no encontrado.");
                        break;
                    }
                    System.out.print("Número stand: ");
                    int numVisita = sc.nextInt();
                    sc.nextLine();
                    Stand standVisita = feria.getStands().stream()
                            .filter(s -> s.getNumero() == numVisita)
                            .findFirst().orElse(null);
                    if (standVisita == null) {
                        System.out.println("❌ Stand no encontrado.");
                        break;
                    }
                    System.out.print("Comentario: ");
                    String comentario = sc.nextLine();
                    System.out.print("Calificación (1-5): ");
                    int calif = sc.nextInt();
                    feria.registrarVisita(visitante, standVisita, comentario, calif);
                    break;

                case 6:
                    feria.reporteEmpresasYStands();
                    break;

                case 7:
                    feria.reporteVisitantesYVisitas();
                    break;

                case 8:
                    feria.reportePromedioCalificacionPorStand();
                    break;

                case 0:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}
