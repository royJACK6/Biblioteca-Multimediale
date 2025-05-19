package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Autore implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String nome;
    private final String cognome;
    private final LocalDate dataDiNascita;

    public Autore(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    @Override
    public String toString() {
        return  "NOME ='" + nome + "', COGNOME ='" + cognome + "', DATA DI NASCITA ='" + dataDiNascita +"'";
    }
}
