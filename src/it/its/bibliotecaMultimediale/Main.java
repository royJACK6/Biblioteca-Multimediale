package it.its.bibliotecaMultimediale;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Main.caricaBiblioteca();
        GestioneUtenti gestioneUtenti = Main.caricaUtenti();
        GestioneNoleggi gestioneNoleggi = new GestioneNoleggi();
        int scelta = 0;
        do {
            System.out.println("""
                    Benvenuto in Biblioteca Multimediale
                    Seleziona:
                    0) Esci
                    1) Aggiungi Materiale
                    2) Aggiungi Utente
                    3) Ricerca Materiale
                    4) Ricerca Utente
                    5) Richiedi Noleggio
                    6) Restituzione Noleggio""");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 0:
                    System.out.println("Grazie per aver utilizzato la nostra applicazione.");
                    break;
                case 1:
                    aggiungiMateriale(scanner, biblioteca);
                    break;
                case 2:
                    Main.aggiungiUtente(gestioneUtenti, scanner);
                    break;
                case 3:
                    Main.ricercaMateriale(biblioteca, scanner);
                    break;
                case 4:
                    Main.ricercaUtente(gestioneUtenti, scanner);
                    break;
                case 5:
                    Main.richiediNoleggio(biblioteca, gestioneNoleggi, gestioneUtenti, scanner);
                    break;
                case 6:
                    Main.restituzioneNoleggio(biblioteca, gestioneNoleggi, gestioneUtenti, scanner);
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);
        Main.salvaBiblioteca(biblioteca);
        Main.salvaUtente(gestioneUtenti);

    }

    private static void salvaBiblioteca(Biblioteca biblioteca) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:/Users/A872/IdeaProjects/BibliotecaMultimediale/resource/biblioteca.txt"))) {
            for (MaterialeBiblioteca materiale : biblioteca.getColleziozioneMateriale()) {
                outputStream.writeObject(materiale);
            }
        }catch (IOException ioEx){
            System.out.println("Errore salvataggio biblioteca");
            ioEx.printStackTrace();
        }
    }

    private static Biblioteca caricaBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:/Users/A872/IdeaProjects/BibliotecaMultimediale/resource/biblioteca.txt"))) {
            MaterialeBiblioteca materialeBiblioteca = null;
            while ((materialeBiblioteca = (MaterialeBiblioteca) inputStream.readObject()) != null){
            biblioteca.aggiungiMateriali(materialeBiblioteca);
            }
            System.out.println("Biblioteca caricata" + biblioteca.getColleziozioneMateriale().size());
            return biblioteca;
        } catch (EOFException eofException) {
            System.out.println("End of file raggiunto");
        }catch (IOException | ClassCastException | ClassNotFoundException ioEx) {
            System.out.println("Errore caricamento biblioteca");
            ioEx.printStackTrace();
        } finally {
            System.out.println("Biblioteca caricata");
        }
        return biblioteca;
    }

    private static void aggiungiMateriale(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("""
                Seleziona:\s
                1) DVD\s
                2) Libro\s
                3) Rivista\s
                """);
        int sceltaMateriale = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci titolo:");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci anno di rilascio:");
        int rilasciato = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci disponibilità:");
        int disponibilita = scanner.nextInt();
        scanner.nextLine();
        switch (sceltaMateriale) {
            case 1:
                System.out.println("Durata(minuti) DVD: ");
                int durata = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Genere DVD: ");
                String genere = scanner.nextLine();
                DVD.Genere genereEnum = DVD.Genere.lookUp(genere);
                Autore regista = Main.acquisisciAutore(scanner);
                DVD dvd = new DVD(id, titolo, rilasciato, disponibilita, regista, durata, genereEnum);
                biblioteca.aggiungiMateriali(dvd);
                System.out.println("DVD Aggiunto ");
                break;
            case 2:
                System.out.println("ISBN Libro: ");
                String isbn = scanner.nextLine();
                System.out.println("Numero pagine: ");
                int Pagine = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Autore: ");
                Autore autore = Main.acquisisciAutore(scanner);
                Libro libro = new Libro(id, titolo, rilasciato, disponibilita, isbn, Pagine, autore);
                biblioteca.aggiungiMateriali(libro);
                System.out.println("Libro Aggiunto");
                break;
            case 3:
                System.out.println("Uscita numero: ");
                int Uscita = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Periodicità: ");
                String periodicita = scanner.nextLine();
                Rivista.Periodicita periodicitaEnum = Rivista.Periodicita.lookUp(periodicita);
                Rivista rivista = new Rivista(id, titolo, rilasciato, disponibilita, Uscita, periodicitaEnum);
                biblioteca.aggiungiMateriali(rivista);
                System.out.println("Rivista Aggiunta");
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }

        System.out.println("Aggiunta Materiale completata");
    }

    private static Autore acquisisciAutore(Scanner scanner) {
        System.out.println("Nome Autore: ");
        String nome = scanner.nextLine();
        System.out.println("Cognome Autore: ");
        String cognome = scanner.nextLine();
        System.out.println("Data di nascita(GG/MM/AAAA): ");
        String dataDiNascita = scanner.nextLine();
        DateTimeFormatter formatoItaliano = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate dataItaliana = LocalDate.parse(dataDiNascita, formatoItaliano);
            return new Autore(nome, cognome, dataItaliana);
        } catch (DateTimeException ex) {
            System.out.println("Data non valida!");
            return new Autore(nome, cognome, null);
        }

    }

    private static void richiediNoleggio(Biblioteca biblioteca, GestioneNoleggi gestioneNoleggi, GestioneUtenti gestioneUtenti, Scanner scanner) {
        System.out.println("ID Materiale: ");
        int id;
        id = scanner.nextInt();
        scanner.nextLine();
        MaterialeBiblioteca materialeBiblioteca = biblioteca.ricercaMateriale((int) id);
        System.out.println("Inserisci ID Utente: ");
        id = scanner.nextInt();
        scanner.nextLine();
        Utente riferimentoUtente = gestioneUtenti.ricercaUtente((int) id);
        LocalDate dataPrestito = LocalDate.now();
        if (riferimentoUtente != null && materialeBiblioteca != null && materialeBiblioteca.getDisponibilita() > 0) {
            materialeBiblioteca.setDisponibilita(materialeBiblioteca.getDisponibilita() - 1);
            Noleggio noleggio = new Noleggio(materialeBiblioteca, riferimentoUtente, dataPrestito);
            gestioneNoleggi.aggiungiNoleggio(noleggio);
            System.out.println("Richiesta di noleggio effettuata");
        }
    }

    private static void restituzioneNoleggio(Biblioteca biblioteca, GestioneNoleggi gestioneNoleggi, GestioneUtenti gestioneUtenti, Scanner scanner) {
        System.out.println("ID materiale");
        int id;
        id = scanner.nextInt();
        scanner.nextLine();
        MaterialeBiblioteca materialeBiblioteca = biblioteca.ricercaMateriale((int) id);
        System.out.println("ID Utente: ");
        id = scanner.nextInt();
        scanner.nextLine();
        Utente riferimentoUtente = gestioneUtenti.ricercaUtente((int) id);
        System.out.println("Data Noleggio(dd/mm/aaaa):");
        String dataNoleggio = scanner.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNoleggioItalia = null;
        try {
            dataNoleggioItalia = LocalDate.parse(dataNoleggio, format);
            if (riferimentoUtente != null && materialeBiblioteca != null) {
                materialeBiblioteca.setDisponibilita(materialeBiblioteca.getDisponibilita() + 1);
                gestioneNoleggi.restituzioneNoleggio(riferimentoUtente.getId(), materialeBiblioteca.getId(), dataNoleggioItalia);
            }
        } catch (DateTimeException ex) {
            System.out.println("Data non valida!");
        }
    }

    private static void ricercaUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
        System.out.println("""
                Ricerca per:
                0)ESCI
                1) ID
                2) NOME E COGNOME
                3) NOME O COGNOME
                """);
        int scelta = scanner.nextInt();
        scanner.nextLine();
        switch (scelta){
            case 0:
                System.out.println("Esci");
                break;
            case 1:
                System.out.println("Inserisci ID: ");
                int id = scanner.nextInt();
                try{
                    Utente risultato = gestioneUtenti.ricercaUtente(id);
                    System.out.println("Risultato della ricerca: " + risultato);
                } catch (Exception e){
                    System.out.println("Nessun utente con questo ID");
                }
                break;
            case 2:
                System.out.println("Inserisci NOME: ");
                String nome = scanner.nextLine();
                System.out.println("Inserisci COGNOME: ");
                String cognome = scanner.nextLine();
                try {
                    List<Utente> risultato = gestioneUtenti.ricercaUtente(nome, cognome);
                    System.out.println("Risultato della ricerca: " + risultato);
                } catch (Exception e) {
                    System.out.println("Nessun utente con questo NOME e COGNOME");
                }
                break;
            case 3:
                System.out.println("Inserisci NOME O COGNOME: ");
                String ricerca = scanner.nextLine();
                try {
                    List<Utente> risultato = gestioneUtenti.ricercaUtente(ricerca);
                    System.out.println("Risultato della ricerca: " + risultato);
                } catch (Exception e){
                    System.out.println("Nessun utente con questo NOME/COGNOME");
                }

        }

    }

    private static void ricercaMateriale(Biblioteca biblioteca, Scanner scanner) {
        System.out.println("""
                Ricerca per:
                1) Titolo
                2) Autore
                3) Tipologia
                """);
        int scelta = scanner.nextInt();
        scanner.nextLine();
        switch (scelta) {
            case 1:
                System.out.println("Inserisci Titolo: ");
                String titolo = scanner.nextLine();
                try {
                    List<MaterialeBiblioteca> risultato = biblioteca.ricercaMateriale(titolo);
                    System.out.println("Risultato della ricerca: " + risultato);
                } catch (Exception e) {
                    System.out.println("Non esiste nessun materiale con questo Titolo");
                }
            case 2:
                System.out.println("Inserisci Autore/Regista");
                Autore autore = Main.acquisisciAutore(scanner);
                try {
                    List<MaterialeBiblioteca> risultato = biblioteca.ricercaMateriale(autore);
                    System.out.println("Risultato della ricerca: " + risultato);
                } catch (Exception e) {
                    System.out.println("Non esiste nessun materiale con questo Autore/Regista");
                }
            case 3:
                System.out.println("Inserisci Tipologia: ");
                Map<String, Class<? extends MaterialeBiblioteca >> tipologiaMap = new HashMap<>();
                tipologiaMap.put("dvd", DVD.class);
                tipologiaMap.put("libro", Libro.class);
                tipologiaMap.put("rivista", Rivista.class);
                String tipologia = scanner.nextLine();
                if (tipologia == null) throw new IllegalArgumentException("Non Presente");
                tipologia = tipologia.toLowerCase();
                Class<? extends MaterialeBiblioteca> tipologiaClass = tipologiaMap.get(tipologia);
                if (tipologiaClass == null) throw new IllegalArgumentException("Tipologia non valida");
                List<MaterialeBiblioteca> risultato = biblioteca.ricercaMateriale(tipologiaClass);
                System.out.println("Risultato della ricerca: " + risultato);
        }
    }
    private static void aggiungiUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
        System.out.println("ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("NOME:");
        String nome = scanner.nextLine();
        System.out.println("COGNOME:");
        String cognome = scanner.nextLine();
        Utente nuovoUtente = new Utente(id, nome, cognome);
                gestioneUtenti.aggiungiUtente(nuovoUtente);
        System.out.println("Utente aggiunto" + nuovoUtente);
    }
    private static void salvaUtente(GestioneUtenti gestioneUtenti) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:/Users/A872/IdeaProjects/BibliotecaMultimediale/resource/utenti.txt"))) {
            for (Utente utente : gestioneUtenti.getCollezioneUtente()) {
                outputStream.writeObject(utente);
            }
        }catch (IOException ioEx){
            System.out.println("Errore salvataggio biblioteca");
            ioEx.printStackTrace();
        }
    }

    private static GestioneUtenti caricaUtenti() {
        GestioneUtenti gestioneUtenti = new GestioneUtenti();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:/Users/A872/IdeaProjects/BibliotecaMultimediale/resource/utenti.txt"))) {
            Utente utente = null;
            while ((utente = (Utente) inputStream.readObject()) != null){
                gestioneUtenti.aggiungiUtente(utente);
            }
            System.out.println("Biblioteca caricata" + gestioneUtenti.getCollezioneUtente().size());
            return gestioneUtenti;
        } catch (EOFException eofException) {
            System.out.println("End of file raggiunto");
        }catch (IOException | ClassCastException | ClassNotFoundException ioEx) {
            System.out.println("Errore caricamento biblioteca");
            ioEx.printStackTrace();
        } finally {
            System.out.println("Biblioteca caricata");
        }
        return gestioneUtenti;
    }

}