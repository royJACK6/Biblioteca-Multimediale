package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Rivista extends MaterialeBiblioteca implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final int numeroUscita;
    public enum Periodicita{
        SETTIMANALE, MENSILE, SEMESTRALE, ANNUALE;
        public static Map<String, Periodicita> PERIODICITA_MAP = new HashMap<>();
        static {
            PERIODICITA_MAP.put("settimanale", SETTIMANALE);
            PERIODICITA_MAP.put("mensile", MENSILE);
            PERIODICITA_MAP.put("semestrale", SEMESTRALE);
            PERIODICITA_MAP.put("annuale", ANNUALE);
        }
        public static Periodicita lookUp(String value){
            if (value == null) throw new IllegalArgumentException("Non Presente");
            value = value.toLowerCase();
            Periodicita periodicita = PERIODICITA_MAP.get(value);
            if (periodicita != null){
                return periodicita;
            }else{
                throw new IllegalArgumentException("Periodicità non valida");
            }
        }
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
