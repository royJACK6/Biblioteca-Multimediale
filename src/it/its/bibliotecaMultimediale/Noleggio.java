package it.its.bibliotecaMultimediale;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Noleggio implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final MaterialeBiblioteca riferimentoMateriale;
    private final Utente riferimentoUtente;
    private final LocalDate dataNoleggio;
    private LocalDate dataRestituzione;

    public Noleggio(MaterialeBiblioteca riferimentoMateriale, Utente riferimentoUtente, LocalDate dataNoleggio) {
        this.riferimentoMateriale = riferimentoMateriale;
        this.riferimentoUtente = riferimentoUtente;
        this.dataNoleggio = dataNoleggio;
    }

    public MaterialeBiblioteca getRiferimentoMateriale() {
        return riferimentoMateriale;
    }

    public Utente getRiferimentoUtente() {
        return riferimentoUtente;
    }

    public LocalDate getDataNoleggio() {
        return dataNoleggio;
    }

    public LocalDate getDataRestituzione() {
        return dataRestituzione;
    }

    public void setDataRestituzione(LocalDate dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Noleggio noleggio)) return false;

        return dataNoleggio == noleggio.dataNoleggio && dataRestituzione == noleggio.dataRestituzione && Objects.equals(riferimentoMateriale, noleggio.riferimentoMateriale) && Objects.equals(riferimentoUtente, noleggio.riferimentoUtente);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(riferimentoMateriale);
        result = 31 * result + Objects.hashCode(riferimentoUtente);
        result = 31 * result + Objects.hashCode(dataNoleggio);
        result = 31 * result + Objects.hashCode(dataRestituzione);
        return result;
    }

    @Override
    public String toString() {
        return """
                Noleggio:\s
                riferimento Materiale = %s\s
                riferimento Utente =%s \s
                data Noleggio =%s \s
                data Restituzione =%s \s
                """.formatted(riferimentoMateriale, riferimentoUtente, dataNoleggio, dataRestituzione);
    }


}
