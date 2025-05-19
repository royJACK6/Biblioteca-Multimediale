package it.its.bibliotecaMultimediale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {
    private final Set<MaterialeBiblioteca> collezioneMateriale;

    public Biblioteca() {
        this.collezioneMateriale = new HashSet<>();
    }

    public void aggiungiMateriali(MaterialeBiblioteca nuovoMateriale) {
        collezioneMateriale.add(nuovoMateriale);
    }

    public String stampaCollezioneMateriale() {
        StringBuilder biulder = new StringBuilder();
        for (MaterialeBiblioteca materialeBiblioteca : collezioneMateriale) {
            biulder.append(materialeBiblioteca.toString()).append("\n");
        }
        return biulder.toString();
    }

//    modificatore d'accesso, tipo ritorno, nome metodo, parametri
    public List<MaterialeBiblioteca> ricercaMateriale (String titolo) throws Exception{
        List<MaterialeBiblioteca> ricercaTitolo = new ArrayList<>();
        for (MaterialeBiblioteca materialeBiblioteca : collezioneMateriale) {
            if (materialeBiblioteca.getTitolo().equals(titolo)) {
                ricercaTitolo.add(materialeBiblioteca);
            }
        }
        if (ricercaTitolo.isEmpty()) {
            throw new NoItemExeption("Libro/DVD non trovato");
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

    public void dettaglio(long id) {
        for (MaterialeBiblioteca materiale : collezioneMateriale) {
            if (materiale.getId() == id) {
                System.out.println("Oggetto/i trovato/i: " + materiale);
            }
        }
    }

    public Set<MaterialeBiblioteca> getColleziozioneMateriale() {
        return null;
    }
}
