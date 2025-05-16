package it.its.bibliotecaMultimediale;

import java.util.Objects;

public class Noleggio {
    private final MaterialeBiblioteca riferimentoMateriale;
    private final Utente riferimentoUtente;
    private final int dataNoleggio;
    private final int dataRestituzione;

    public Noleggio(MaterialeBiblioteca riferimentoMateriale, Utente riferimentoUtente, int dataNoleggio, int dataRestituzione) {
        this.riferimentoMateriale = riferimentoMateriale;
        this.riferimentoUtente = riferimentoUtente;
        this.dataNoleggio = dataNoleggio;
        this.dataRestituzione = dataRestituzione;
    }

    public MaterialeBiblioteca getRiferimentoMateriale() {
        return riferimentoMateriale;
    }

    public Utente getRiferimentoUtente() {
        return riferimentoUtente;
    }

    public int getDataNoleggio() {
        return dataNoleggio;
    }

    public int getDataRestituzione() {
        return dataRestituzione;
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
        result = 31 * result + dataNoleggio;
        result = 31 * result + dataRestituzione;
        return result;
    }

    @Override
    public String toString() {
        return "Noleggio{riferimentoMateriale ='" + riferimentoMateriale + "', riferimentoUtente ='" + riferimentoUtente +"', dataNoleggio ='" + dataNoleggio + "', dataRestituzione ='" + dataRestituzione +"'}";
    }
}
