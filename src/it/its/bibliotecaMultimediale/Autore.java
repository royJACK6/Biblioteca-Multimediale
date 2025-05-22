package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

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
    public final boolean equals(Object o) {
        if (!(o instanceof Autore autore)) return false;

        return Objects.equals(nome, autore.nome) && Objects.equals(cognome, autore.cognome) && Objects.equals(dataDiNascita, autore.dataDiNascita);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(nome);
        result = 31 * result + Objects.hashCode(cognome);
        result = 31 * result + Objects.hashCode(dataDiNascita);
        return result;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoItaliano = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            String dataItaliana = formatoItaliano.format(dataDiNascita);

            return """
                    NOME =%s\s
                    COGNOME =%s\s
                    DATA DI NASCITA =%s
                    """.formatted(nome, cognome, dataItaliana);
        }catch (DateTimeException ex) {
            System.out.println("Data non valida!");
        }
        return null;
    }
}
