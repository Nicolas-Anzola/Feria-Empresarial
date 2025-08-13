package com.mycompany.feria;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona todos los elementos de la Feria Empresarial.
 * Permite manejar empresas, stands, visitantes y las visitas realizadas.
 */
public class Feria {
    private List<Empresa> empresas;
    private List<Stand> stands;
    private List<Visitante> visitantes;
    private List<Visita> visitas;

    /**
     * Constructor que inicializa las listas vacías.
     */
    public Feria() {
        empresas = new ArrayList<>();
        stands = new ArrayList<>();
        visitantes = new ArrayList<>();
        visitas = new ArrayList<>();
    }

    // -------------------- MÉTODOS PARA EMPRESAS --------------------

    public void registrarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public void eliminarEmpresa(String nombre) {
        empresas.removeIf(e -> e.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    // -------------------- MÉTODOS PARA STANDS --------------------

    public void registrarStand(Stand stand) {
        stands.add(stand);
    }

    public void asignarStand(int numeroStand, Empresa empresa) {
        for (Stand s : stands) {
            if (s.getNumero() == numeroStand && !s.estaOcupado()) {
                s.asignarEmpresa(empresa);
                break;
            }
        }
    }

    public List<Stand> getStands() {
        return stands;
    }

    // -------------------- MÉTODOS PARA VISITANTES --------------------

    public void registrarVisitante(Visitante visitante) {
        visitantes.add(visitante);
    }

    public void eliminarVisitante(String id) {
        visitantes.removeIf(v -> v.getIdentificacion().equalsIgnoreCase(id));
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }

    // -------------------- MÉTODOS PARA VISITAS --------------------

    public void registrarVisita(Visitante visitante, Stand stand, String comentario, int calificacion) {
        Visita visita = new Visita(visitante, stand, comentario, calificacion);
        visitas.add(visita);
    }

    public List<Visita> getVisitas() {
        return visitas;
    }

    // -------------------- REPORTES --------------------

    public void reporteEmpresasYStands() {
        System.out.println("\n📌 Empresas y sus stands:");
        for (Stand s : stands) {
            if (s.estaOcupado()) {
                System.out.println(s.getEmpresaAsignada().getNombre() + " → " + s.toString());
            }
        }
    }

    public void reporteVisitantesYVisitas() {
        System.out.println("\n📌 Visitantes y stands visitados:");
        for (Visita v : visitas) {
            System.out.println(v.toString());
        }
    }

    public void reportePromedioCalificacionPorStand() {
        System.out.println("\n📌 Calificación promedio por stand:");
        for (Stand s : stands) {
            int total = 0, count = 0;
            for (Visita v : visitas) {
                if (v.getStand().equals(s)) {
                    total += v.getCalificacion();
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("Stand N° " + s.getNumero() + ": " + (total / (double) count) + "★");
            }
        }
    }
}
