package it.its.bibliotecaMultimediale;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Benvenuto in Biblioteca Multimediale\s
                Seleziona:\s
                1) Aggiungi Materiale\s
                2) Aggiungi Utente\s
                3) Ricerca Materiale\s
                4) Ricerca Utente\s
                5) Restituzione Noleggio\s
                6) Richiedi Noleggio""");
        Scanner scanner = new Scanner(System.in);
        int scelta = scanner.nextInt();
        scanner.nextLine();
        Biblioteca biblioteca = new Biblioteca();
        GestioneUtenti gestioneUtenti = new GestioneUtenti();
        GestioneNoleggi gestioneNoleggi = new GestioneNoleggi();
        switch (scelta) {
            case 1:
                Main.aggiungiMateriale(biblioteca, scanner);
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

//        registi DVD
        Autore spielberg = new Autore("Steven", "Spielberg", LocalDate.of(1946, 12, 18));
        Autore nolan = new Autore("Christopher", "Nolan", LocalDate.of(1970, 7, 30));
        Autore tarantino = new Autore("Quentin", "Tarantino", LocalDate.of(1963, 3, 27));
        Autore fellini = new Autore("Federico", "Fellini", LocalDate.of(1920, 1, 20));
        Autore leone = new Autore("Sergio", "Leone", LocalDate.of(1929, 1, 3));
        Autore sorrentino = new Autore("Paolo", "Sorrentino", LocalDate.of(1970, 5, 31));
        Autore cavani = new Autore("Liliana", "Cavani", LocalDate.of(1933, 1, 12));
        Autore comencini = new Autore("Cristina", "Comencini", LocalDate.of(1956, 5, 8));
        Autore dante = new Autore("Emma", "Dante", LocalDate.of(1967, 4, 6));
        Autore delToro = new Autore("Guillermo", "del Toro", LocalDate.of(1964, 10, 9));

//        autori libri
        Autore king = new Autore("Stephen", "King", LocalDate.of(1947, 9, 21));
        Autore rowling = new Autore("J.K.", "Rowling", LocalDate.of(1965, 7, 31));
        Autore murakami = new Autore("Haruki", "Murakami", LocalDate.of(1949, 1, 12));
        Autore atwood = new Autore("Margaret", "Atwood", LocalDate.of(1939, 11, 18));
        Autore woolf = new Autore("Virginia", "Woolf", LocalDate.of(1882, 1, 25));
        Autore eco = new Autore("Umberto", "Eco", LocalDate.of(1932, 1, 5));
        Autore orwell = new Autore("George", "Orwell", LocalDate.of(1903, 6, 25));
        Autore allende = new Autore("Isabel", "Allende", LocalDate.of(1942, 8, 2));
        Autore calvino = new Autore("Italo", "Calvino", LocalDate.of(1923, 10, 15));
        Autore morrison = new Autore("Toni", "Morrison", LocalDate.of(1931, 2, 18));

//        DVD presenti nella biblioteca
        DVD salvateIlSoldatoRyan = new DVD(
                1L,
                "Salvate il soldato Ryan",
                1998,
                5,
                spielberg,
                169,
                DVD.Genere.AZIONE
        );

        DVD ilCavaliereOscuro = new DVD(
                2L,
                "Il cavaliere oscuro",
                2008,
                5,
                nolan,
                152,
                DVD.Genere.AZIONE
        );

        DVD theHatefulEight = new DVD(
                3L,
                "The Hateful Eight",
                2015,
                4,
                tarantino,
                168,
                DVD.Genere.DRAMMATICO
        );

        DVD laStrada = new DVD(
                4L,
                "La strada",
                1954,
                3,
                fellini,
                108,
                DVD.Genere.DRAMMATICO
        );

        DVD cEraUnaVoltaIlWest = new DVD(
                5L,
                "C'era una volta il West",
                1968,
                4,
                leone,
                165,
                DVD.Genere.AZIONE
        );

        DVD eStataLaManoDiDio = new DVD(
                6L,
                "È stata la mano di Dio",
                2021,
                3,
                sorrentino,
                130,
                DVD.Genere.DRAMMATICO
        );

        DVD ilPortiereDiNotte = new DVD(
                7L,
                "Il portiere di notte",
                1974,
                2,
                cavani,
                118,
                DVD.Genere.DRAMMATICO
        );

        DVD laBestiaNelCuore = new DVD(
                8L,
                "La bestia nel cuore",
                2005,
                2,
                comencini,
                120,
                DVD.Genere.DRAMMATICO
        );

        DVD leSorelleMacaluso = new DVD(
                9L,
                "Le sorelle Macaluso",
                2020,
                1,
                dante,
                94,
                DVD.Genere.DRAMMATICO
        );

        DVD crimsonPeak = new DVD(
                10L,
                "Crimson Peak",
                2015,
                4,
                delToro,
                119,
                DVD.Genere.HORROR
        );

//        Libri presenti nella biblioteca
        Libro it = new Libro(
                11L,
                "IT",
                1986,
                5,
                "978-0450411434",
                1138,
                king
        );

        Libro harryPotterPietraFilosofale = new Libro(
                12L,
                "Harry Potter e la Pietra Filosofale",
                1997,
                4,
                "978-8831003384",
                336,
                rowling
        );

        Libro norwegianWood = new Libro(
                13L,
                "Norwegian Wood",
                1987,
                4,
                "978-0375704024",
                296,
                murakami
        );

        Libro theHandmaidsTale = new Libro(
                14L,
                "Il racconto dell'ancella",
                1985,
                5,
                "978-0385490818",
                311,
                atwood
        );

        Libro mrsDalloway = new Libro(
                15L,
                "Mrs Dalloway",
                1925,
                4,
                "978-0156628709",
                194,
                woolf
        );

        Libro ilNomeDellaRosa = new Libro(
                16L,
                "Il nome della rosa",
                1980,
                5,
                "978-0156001311",
                536,
                eco
        );

        Libro nineteenEightyFour = new Libro(
                17L,
                "1984",
                1949,
                5,
                "978-0451524935",
                328,
                orwell
        );

        Libro laCasaDegliSpiriti = new Libro(
                18L,
                "La casa degli spiriti",
                1982,
                4,
                "978-0553273913",
                433,
                allende
        );

        Libro ilBaroneRampante = new Libro(
                19L,
                "Il barone rampante",
                1957,
                4,
                "978-8807900248",
                231,
                calvino
        );

        Libro beloved = new Libro(
                20L,
                "Beloved",
                1987,
                5,
                "978-1400033416",
                324,
                morrison
        );

//        riviste presenti in biblioteca
        Rivista nationalGeographic = new Rivista(
                21L,
                "National Geographic",
                2024,
                5,
                780,
                Rivista.Periodicita.MENSILE
        );

        Rivista theEconomist = new Rivista(
                22L,
                "The Economist",
                2024,
                18,
                920,
                Rivista.Periodicita.SETTIMANALE
        );

        Rivista scientificAmerican = new Rivista(
                23L,
                "Scientific American",
                2024,
                2,
                144,
                Rivista.Periodicita.SEMESTRALE
        );

        Rivista panorama = new Rivista(
                24L,
                "Panorama",
                2024,
                21,
                72,
                Rivista.Periodicita.SETTIMANALE
        );

        Rivista focus = new Rivista(
                25L,
                "Focus",
                2024,
                10,
                359,
                Rivista.Periodicita.MENSILE
        );

        Rivista vogue = new Rivista(
                26L,
                "Vogue",
                2024,
                6,
                265,
                Rivista.Periodicita.MENSILE
        );

        Rivista archeo = new Rivista(
                27L,
                "Archeo",
                2024,
                1,
                110,
                Rivista.Periodicita.ANNUALE
        );

        Rivista colors = new Rivista(
                28L,
                "Colors",
                2024,
                1,
                130,
                Rivista.Periodicita.SEMESTRALE
        );

        Rivista mitTechnologyReview = new Rivista(
                29L,
                "MIT Technology Review",
                2024,
                2,
                188,
                Rivista.Periodicita.SEMESTRALE
        );

        Rivista slow = new Rivista(
                30L,
                "Slow",
                2024,
                1,
                98,
                Rivista.Periodicita.ANNUALE
        );


//        aggiunta dei DVD nella biblioteca
        biblioteca.aggiungiMateriali(salvateIlSoldatoRyan);
        biblioteca.aggiungiMateriali(ilCavaliereOscuro);
        biblioteca.aggiungiMateriali(theHatefulEight);
        biblioteca.aggiungiMateriali(laStrada);
        biblioteca.aggiungiMateriali(cEraUnaVoltaIlWest);
        biblioteca.aggiungiMateriali(eStataLaManoDiDio);
        biblioteca.aggiungiMateriali(ilPortiereDiNotte);
        biblioteca.aggiungiMateriali(laBestiaNelCuore);
        biblioteca.aggiungiMateriali(leSorelleMacaluso);
        biblioteca.aggiungiMateriali(crimsonPeak);

//        aggiunta dei libri nella biblioteca
        biblioteca.aggiungiMateriali(it);
        biblioteca.aggiungiMateriali(harryPotterPietraFilosofale);
        biblioteca.aggiungiMateriali(norwegianWood);
        biblioteca.aggiungiMateriali(theHandmaidsTale);
        biblioteca.aggiungiMateriali(mrsDalloway);
        biblioteca.aggiungiMateriali(ilNomeDellaRosa);
        biblioteca.aggiungiMateriali(nineteenEightyFour);
        biblioteca.aggiungiMateriali(laCasaDegliSpiriti);
        biblioteca.aggiungiMateriali(ilBaroneRampante);
        biblioteca.aggiungiMateriali(beloved);

//        aggiunta delle riviste nella biblioteca
        biblioteca.aggiungiMateriali(nationalGeographic);
        biblioteca.aggiungiMateriali(theEconomist);
        biblioteca.aggiungiMateriali(scientificAmerican);
        biblioteca.aggiungiMateriali(panorama);
        biblioteca.aggiungiMateriali(focus);
        biblioteca.aggiungiMateriali(vogue);
        biblioteca.aggiungiMateriali(archeo);
        biblioteca.aggiungiMateriali(colors);
        biblioteca.aggiungiMateriali(mitTechnologyReview);
        biblioteca.aggiungiMateriali(slow);

        System.out.println("Lista completa della biblioteca:");
        System.out.println(biblioteca.stampaCollezioneMateriale());

    }

    private static void richiediNoleggio(Biblioteca biblioteca, GestioneNoleggi gestioneNoleggi, GestioneUtenti gestioneUtenti, Scanner scanner) {
    }

    private static void restituzioneNoleggio(Biblioteca biblioteca, GestioneNoleggi gestioneNoleggi, GestioneUtenti gestioneUtenti, Scanner scanner) {
    }

    private static void ricercaUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
    }

    private static void ricercaMateriale(Biblioteca biblioteca, Scanner scanner) {
    }

    private static void aggiungiUtente(GestioneUtenti gestioneUtenti, Scanner scanner) {
    }

    private static void aggiungiMateriale(Biblioteca biblioteca, Scanner scanner) {
    }
}