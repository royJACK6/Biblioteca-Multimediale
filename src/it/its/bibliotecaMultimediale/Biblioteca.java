package it.its.bibliotecaMultimediale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {
    private final Set<MaterialeBiblioteca> collezioneMateriale;
    private final Set<Utente> collezioneUtenti;
    private final Set<Noleggio> collezioneNoleggi;

    public Biblioteca() {
        this.collezioneMateriale = new HashSet<>();
        this.collezioneUtenti = new HashSet<>();
        this.collezioneNoleggi = new HashSet<>();
    }

    public void aggiungiMateriali(MaterialeBiblioteca nuovoMateriale) {
        collezioneMateriale.add(nuovoMateriale);
    }

    public void aggiungiUtente(Utente nuovoUtente) {
        collezioneUtenti.add(nuovoUtente);
    }

    public void aggiungiNoleggio(Noleggio nuovoNoleggio) {
        collezioneNoleggi.add(nuovoNoleggio);
    }

    public String stampaCollezioneMateriale() {
        StringBuilder biulder = new StringBuilder();
        for (MaterialeBiblioteca materialeBiblioteca : collezioneMateriale) {
            biulder.append(materialeBiblioteca.toString()).append("\n");
        }
        return biulder.toString();
    }

    public String stampaCollezioneUtenti() {
        StringBuilder biulder = new StringBuilder();
        for (Utente utente : collezioneUtenti) {
            biulder.append(utente.toString()).append("\n");
        }
        return biulder.toString();
    }

    public String stampaCollezioneNoleggi() {
        StringBuilder biulder = new StringBuilder();
        for (Noleggio noleggio : collezioneNoleggi) {
            biulder.append(noleggio.toString()).append("\n");
        }
        return biulder.toString();
    }

//    modificatore d'accesso, tipo ritorno, nome metodo, parametri
    public List<MaterialeBiblioteca> ricercaMateriale (String titolo) {
        List<MaterialeBiblioteca> ricercaTitolo = new ArrayList<>();
        for (MaterialeBiblioteca materialeBiblioteca : collezioneMateriale) {
            if (materialeBiblioteca.getTitolo().equals(titolo)) {
                ricercaTitolo.add(materialeBiblioteca);
            }
        }
        return ricercaTitolo;
    }

    public List<MaterialeBiblioteca> ricercaMateriale (Autore autore) {
        List<MaterialeBiblioteca> ricercaAutore = new ArrayList<>();
        for (MaterialeBiblioteca materialebiblioteca : collezioneMateriale) {
            if (materialebiblioteca instanceof Libro libro){
                if (libro.getRiferimentoAutore().equals(autore)) {
                    ricercaAutore.add(libro);
                }
            }
            else if (materialebiblioteca instanceof DVD dvd) {
                if (dvd.getRegista().equals(autore)) {
                    ricercaAutore.add(dvd);
                }
            }
        }
        return ricercaAutore;
    }

    public List<MaterialeBiblioteca> ricercaMateriale (Class<? extends MaterialeBiblioteca >clazz) {
        List<MaterialeBiblioteca> ricercaTipo = new ArrayList<>();
        for (MaterialeBiblioteca materialeBiblioteca : collezioneMateriale) {
            if (materialeBiblioteca.getClass().equals(clazz)){
                ricercaTipo.add(materialeBiblioteca);
            }
        }
        return ricercaTipo;
    }
}
