package com.mycompany.feria;

/**
 * Clase que representa un stand dentro de la feria.
 * Un stand puede estar ocupado por una empresa o libre.
 */
public class Stand {
    private int numero;
    private String ubicacion;
    private String tamaño;
    private Empresa empresaAsignada; // null si está libre

    /**
     * Constructor de la clase Stand.
     * @param numero Número único del stand.
     * @param ubicacion Ubicación dentro de la feria.
     * @param tamaño Tamaño del stand (pequeño, mediano, grande).
     */
    public Stand(int numero, String ubicacion, String tamaño) {
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
        this.empresaAsignada = null; // Al inicio está libre
    }

    // Getters y Setters

    public int getNumero() {
        return numero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTamaño() {
        return tamaño;
    }

    public Empresa getEmpresaAsignada() {
        return empresaAsignada;
    }

    public void asignarEmpresa(Empresa empresa) {
        this.empresaAsignada = empresa;
    }

    public void liberarStand() {
        this.empresaAsignada = null;
    }

    public boolean estaOcupado() {
        return empresaAsignada != null;
    }

    @Override
    public String toString() {
        String estado = (empresaAsignada != null) ? "Ocupado por " + empresaAsignada.getNombre() : "Libre";
        return "Stand N° " + numero + " | Ubicación: " + ubicacion + " | Tamaño: " + tamaño + " | " + estado;
    }
}
