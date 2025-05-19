package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class MaterialeBiblioteca implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final long id;
    private final String titolo;
    private final int annoDiRilascio;
    private final int disponibilita;

    public MaterialeBiblioteca(long id, String titolo, int annoDiRilascio, int disponibilita) {
        this.id = id;
        this.titolo = titolo;
        this.annoDiRilascio = annoDiRilascio;
        this.disponibilita = disponibilita;
    }

    public long getId() {
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
