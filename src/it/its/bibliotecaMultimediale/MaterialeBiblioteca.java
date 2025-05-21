package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class MaterialeBiblioteca implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int id;
    private final String titolo;
    private final int annoDiRilascio;
    private int disponibilita;

    public MaterialeBiblioteca(int id, String titolo, int annoDiRilascio, int disponibilita) {
        this.id = id;
        this.titolo = titolo;
        this.annoDiRilascio = annoDiRilascio;
        this.disponibilita = disponibilita;
    }

    public void setDisponibilita(int disponibilita){
        this.disponibilita = disponibilita;
    }

    public int getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoDiRilascio() {
        return annoDiRilascio;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

}
