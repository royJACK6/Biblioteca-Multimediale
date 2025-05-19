package it.its.bibliotecaMultimediale;

import java.util.HashSet;
import java.util.Set;

public class GestioneUtenti {
    private final Set<Utente> collezioneUtenti;

    public GestioneUtenti() {
        this.collezioneUtenti = new HashSet<>();
    }
    public void aggiungiUtente(Utente nuovoUtente) {
        collezioneUtenti.add(nuovoUtente);
    }

    public String stampaCollezioneUtenti() {
        StringBuilder biulder = new StringBuilder();
        for (Utente utente : collezioneUtenti) {
            biulder.append(utente.toString()).append("\n");
        }
        return biulder.toString();
    }

    public void rimozioneUtente(long id) {
        for (Utente utente : collezioneUtenti) {
            if (utente.getId() == id) {
                collezioneUtenti.remove(utente);
                return;
            }
        }
        }
}

