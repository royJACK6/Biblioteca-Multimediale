package it.its.bibliotecaMultimediale;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Main.caricaBiblioteca();
        GestioneUtenti gestioneUtenti = new GestioneUtenti();
        GestioneNoleggi gestioneNoleggi = new GestioneNoleggi();
        int scelta = 0;
        do {
            System.out.println("""
                    Benvenuto in Biblioteca Multimediale\s
                    Seleziona:\s
                    0) Esci\s
                    1) Aggiungi Materiale\s
                    2) Aggiungi Utente\s
                    3) Ricerca Materiale\s
                    4) Ricerca Utente\s
                    5) Restituzione Noleggio\s
                    6) Richiedi Noleggio
                    """);
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
                    Main.restituzioneNoleggio(biblioteca, gestioneNoleggi, gestioneUtenti, scanner);
                    break;
                case 6:
                    Main.richiediNoleggio(biblioteca, gestioneNoleggi, gestioneUtenti, scanner);
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        } while (scelta != 0);
        Main.salvaBiblioteca(biblioteca);

    }

    private static void salvaBiblioteca(Biblioteca biblioteca) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("C:/Users/A872/IdeaProjects/BibliotecaMultimediale/resource/biblioteca.txt"))) {
            for (MaterialeBiblioteca materiale : biblioteca.getColleziozioneMateriale()) {
                outputStream.writeObject(materiale);
            }
        }catch (IOException ioEx){
            System.out.println("Errore salvataggio biblioteca");
        }
    }

    private static Biblioteca caricaBiblioteca() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("C:/Users/A872/IdeaProjects/BibliotecaMultimediale/resource/biblioteca.txt"))) {
            Biblioteca biblioteca = new Biblioteca();
            MaterialeBiblioteca materialeBiblioteca = null;
            while ((materialeBiblioteca = (MaterialeBiblioteca) inputStream.readObject()) != null){
            biblioteca.aggiungiMateriali(materialeBiblioteca);
            }
            return biblioteca;
        } catch (EOFException eofException) {
            System.out.println("End of file raggiunto");
        }catch (IOException | ClassCastException | ClassNotFoundException ioEx) {
            System.out.println("Errore caricamento biblioteca");
        } finally {
            System.out.println("Biblioteca caricata");
        }
        return new Biblioteca();
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
        long id = scanner.nextLong();
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
    }

    private static void restituzioneNoleggio(Biblioteca biblioteca, GestioneNoleggi gestioneNoleggi, GestioneUtenti gestioneUtenti, Scanner scanner) {
    }

    private static void ricercaUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
    }

    private static void ricercaMateriale(Biblioteca biblioteca, Scanner scanner) {
        String titolo = scanner.nextLine();
        try {
            List<MaterialeBiblioteca> risultatoTitolo = biblioteca.ricercaMateriale(titolo);
            System.out.println("Risultato della ricerca: " + titolo);
        } catch (Exception e) {
            System.out.println("Non esiste nessun materiale con questo titolo");
        }
    }

    private static void aggiungiUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
    }
}