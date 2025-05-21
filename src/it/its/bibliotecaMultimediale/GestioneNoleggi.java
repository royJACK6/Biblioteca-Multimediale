package it.its.bibliotecaMultimediale;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GestioneNoleggi {
    private final Set<Noleggio> collezioneNoleggi;

    public GestioneNoleggi() {
        this.collezioneNoleggi = new HashSet<>();
    }
    public void aggiungiNoleggio(Noleggio nuovoNoleggio) {
        collezioneNoleggi.add(nuovoNoleggio);
    }

    public String stampaCollezioneUtenti() {
        StringBuilder builder = new StringBuilder();
        for (Noleggio noleggio : collezioneNoleggi) {
            builder.append(noleggio.toString()).append("\n");
        }
        return builder.toString();
    }

    public void restituzioneNoleggio(int idUtente, long idMateriale, LocalDate dataNoleggio){
        for (Noleggio noleggio : collezioneNoleggi) {
            if (idUtente == noleggio.getRiferimentoUtente().getId()
                && idMateriale == noleggio.getRiferimentoMateriale().getId()
                && dataNoleggio.equals(noleggio.getDataNoleggio())
                && noleggio.getDataRestituzione() == null){
                noleggio.setDataRestituzione(LocalDate.now());
            } ;
        }
    }

    public List<Noleggio> ricercaNoleggi(Utente utente) {
        List<Noleggio> risultato = new ArrayList<>();
        for (Noleggio noleggio : collezioneNoleggi) {
            if (utente.equals(noleggio.getRiferimentoUtente())) {
                risultato.add(noleggio);
            }
        }
        return risultato;
    }
    public List<Noleggio> ricercaNoleggi(MaterialeBiblioteca materialeBiblioteca){
        List<Noleggio> risultato = new ArrayList<>();
        for (Noleggio noleggio : collezioneNoleggi) {
            if (materialeBiblioteca.equals(noleggio.getRiferimentoMateriale())){
                risultato.add(noleggio);
            }
        }
        return risultato;
    }
}