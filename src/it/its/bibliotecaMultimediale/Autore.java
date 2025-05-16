package it.its.bibliotecaMultimediale;

import java.time.LocalDate;

public class Autore {
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
        return "Autore{nome='" + nome + "', cognome='" + cognome + "', dataDiNascita =" + dataDiNascita +"'}";
    }
}
