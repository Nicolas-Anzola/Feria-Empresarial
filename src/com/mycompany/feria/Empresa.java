package com.mycompany.feria;

/**
 * Clase que representa una empresa participante en la feria.
 * Cada empresa tiene un nombre, sector y correo de contacto.
 */
public class Empresa {
    private String nombre;
    private String sector;
    private String correo;

    /**
     * Constructor de la clase Empresa.
     * @param nombre Nombre de la empresa.
     * @param sector Sector al que pertenece (tecnología, salud, etc.).
     * @param correo Correo de contacto de la empresa.
     */
    public Empresa(String nombre, String sector, String correo) {
        this.nombre = nombre;
        this.sector = sector;
        this.correo = correo;
    }

    // Métodos getter y setter para cada atributo

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Empresa: " + nombre + " | Sector: " + sector + " | Correo: " + correo;
    }
}
