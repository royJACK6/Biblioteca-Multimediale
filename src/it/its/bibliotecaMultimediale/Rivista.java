package it.its.bibliotecaMultimediale;

import java.util.Objects;

public class Rivista extends MaterialeBiblioteca{
    private final int numeroUscita;
    public enum Periodicita{
        SETTIMANALE, MENSILE, SEMESTRALE, ANNUALE
    }
    private final Periodicita periodicita;

    public Rivista(long id, String titolo, int annoDiRilascio, int disponibilita, int numeroUscita, Periodicita periodicita) {
        super(id, titolo, annoDiRilascio, disponibilita);
        this.numeroUscita = numeroUscita;
        this.periodicita = periodicita;
    }

    public int getNumeroUscita() {
        return numeroUscita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rivista rivista)) return false;
        if (!super.equals(o)) return false;

        return numeroUscita == rivista.numeroUscita && periodicita == rivista.periodicita;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numeroUscita;
        result = 31 * result + Objects.hashCode(periodicita);
        return result;
    }

    @Override
    public String toString() {
        return "Rivista {ID ='" + getId() + "', TITOLO ='" + getTitolo() + "', ANNO DI RILASCIO ='" + getAnnoDiRilascio() +"', DISPONIBILITÀ ='" + getDisponibilita() + "', NUMERO USCITA ='" + numeroUscita + "', PERIODICITÀ [" + periodicita + "]}";
    }
}
