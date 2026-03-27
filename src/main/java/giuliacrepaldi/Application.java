package giuliacrepaldi;

import giuliacrepaldi.dao.PrestitoDAO;
import giuliacrepaldi.dao.PubblicazioneDAO;
import giuliacrepaldi.dao.UtenteDAO;
import giuliacrepaldi.entities.Libro;
import giuliacrepaldi.entities.Prestito;
import giuliacrepaldi.entities.Rivista;
import giuliacrepaldi.entities.Utente;
import giuliacrepaldi.enumeration.Genere;
import giuliacrepaldi.enumeration.Periodicità;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BIBLIOGRAPHIC-CATALOGUE");


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        PubblicazioneDAO pubblicazioneDAO = new PubblicazioneDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);


        Libro libro = new Libro(UUID.randomUUID(), "978-88-8080-123-4", "Il nome della Rosa", LocalDate.of(1980, 1, 1), 650, "Umberto Eco", Genere.GIALLO);
        Rivista rivista = new Rivista(UUID.randomUUID(), "978-88-8080-133-4", "Focus", LocalDate.of(2001, 1, 1), 45, Periodicità.SEMESTRALE);
        Utente utente = new Utente(UUID.randomUUID(), "Mario", "Rossi", LocalDate.of(1988, 1, 1), 75);
        Prestito prestito = new Prestito(UUID.randomUUID(), LocalDate.of(2026, 03, 02), null);

        pubblicazioneDAO.save(libro);
        pubblicazioneDAO.save(rivista);
        utenteDAO.saveUtente(utente);
        prestitoDAO.savePrestito(prestito);


        System.out.println("Hello World!");
        em.close();
        emf.close();
    }
}
