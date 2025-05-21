package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Utente implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int id;
    private final String nome;
    private final String cognome;

    public Utente(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Utente utente)) return false;

        return id == utente.id && Objects.equals(nome, utente.nome) && Objects.equals(cognome, utente.cognome);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(nome);
        result = 31 * result + Objects.hashCode(cognome);
        return result;
    }

    @Override
    public String toString() {
        return """
                Utente:\s
                ID =%s\s
                NOME =%s\s
                COGNOME =%s\s
                """.formatted(id, nome, cognome);
    }
}
