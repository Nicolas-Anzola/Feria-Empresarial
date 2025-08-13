package com.mycompany.feria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa la visita de un visitante a un stand.
 */
public class Visita {
    private Visitante visitante;
    private Stand stand;
    private LocalDateTime fechaVisita;
    private String comentario;
    private int calificacion; // 1 a 5 estrellas

    /**
     * Constructor de la clase Visita.
     * @param visitante Visitante que realiza la visita.
     * @param stand Stand visitado.
     * @param comentario Comentario sobre la experiencia.
     * @param calificacion Calificación de 1 a 5.
     */
    public Visita(Visitante visitante, Stand stand, String comentario, int calificacion) {
        this.visitante = visitante;
        this.stand = stand;
        this.fechaVisita = LocalDateTime.now();
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public Stand getStand() {
        return stand;
    }

    public LocalDateTime getFechaVisita() {
        return fechaVisita;
    }

    public String getComentario() {
        return comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Visita de " + visitante.getNombre() +
                " al Stand N° " + stand.getNumero() +
                " | Fecha: " + fechaVisita.format(formato) +
                " | Calificación: " + calificacion + "★" +
                " | Comentario: " + comentario;
    }
}
