package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Libro extends MaterialeBiblioteca implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final String isbn;
    private final int pagine;
    private final Autore riferimentoAutore;

    public Libro(int id, String titolo, int annoDiRilascio, int disponibilita, String isbn, int pagine, Autore riferimentoAutore) {
        super(id, titolo, annoDiRilascio, disponibilita);
        this.isbn = isbn;
        this.pagine = pagine;
        this.riferimentoAutore = riferimentoAutore;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPagine() {
        return pagine;
    }

    public Autore getRiferimentoAutore() {
        return riferimentoAutore;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Libro libro)) return false;

        return pagine == libro.pagine && Objects.equals(isbn, libro.isbn) && Objects.equals(riferimentoAutore, libro.riferimentoAutore);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(isbn);
        result = 31 * result + pagine;
        result = 31 * result + Objects.hashCode(riferimentoAutore);
        return result;
    }

    @Override
    public String toString() {
        return """
    Libro:\s
    ID =%s \s
    TITOLO =%s \s
    ANNO DI RILASCIO =%s \s
    DISPONIBILITÀ =%s\s
    ISBN =%s\s
    PAGINE =%s\s
    RIFERIMENTO AUTORE [%s]%s\s
    """.formatted(getId(), getTitolo(), getAnnoDiRilascio(), getDisponibilita(), isbn, pagine, riferimentoAutore, "\n");
    }
}
