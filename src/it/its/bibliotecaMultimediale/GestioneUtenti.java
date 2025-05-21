package it.its.bibliotecaMultimediale;

import java.util.*;

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

    public void rimozioneUtente(int id) {
        for (Utente utente : collezioneUtenti) {
            if (utente.getId() == id) {
                collezioneUtenti.remove(utente);
                return;
            }
        }
    }

    public Utente ricercaUtente(int id){
        for (Utente utente : collezioneUtenti) {
            if (utente.getId() == id) {
                return utente;
            }
        }
        return null;
    }

    public List<Utente> ricercaUtente(String nome, String cognome) {
        List<Utente> listaUtente = new ArrayList<>();
        for (Utente utente : collezioneUtenti) {
            if (utente.getNome().equals(nome) && utente.getCognome().equals(cognome)) {
                listaUtente.add(utente);
            }
        }
        return listaUtente;
    }

    public List<Utente> ricercaUtente(String ricerca) {
        List<Utente> listaUtente = new ArrayList<>();
        for (Utente utente : collezioneUtenti) {
            if (utente.getNome().equals(ricerca) || utente.getCognome().equals(ricerca)) {
                listaUtente.add(utente);
            }
        }
        return listaUtente;
    }

    public Set<Utente> getCollezioneUtente() {
        return this.collezioneUtenti;
    }
}

