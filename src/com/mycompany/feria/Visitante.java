package com.mycompany.feria;

/**
 * Clase que representa a un visitante de la feria.
 */
public class Visitante {
    private String nombre;
    private String identificacion;
    private String correo;

    /**
     * Constructor de la clase Visitante.
     * @param nombre Nombre del visitante.
     * @param identificacion Número de identificación (cédula, pasaporte, etc.).
     * @param correo Correo electrónico del visitante.
     */
    public Visitante(String nombre, String identificacion, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Visitante: " + nombre + " | ID: " + identificacion + " | Correo: " + correo;
    }
}
