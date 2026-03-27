package giuliacrepaldi.dao;

import giuliacrepaldi.entities.Libro;
import giuliacrepaldi.entities.Pubblicazione;
import giuliacrepaldi.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class PubblicazioneDAO {
    private final EntityManager em;

    public PubblicazioneDAO(EntityManager em) {
        this.em = em;
    }

    //metodi
    //1.save
    public void save(Pubblicazione nuovaPubblicazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(nuovaPubblicazione);
        transaction.commit();
        System.out.println("La pubblicazione: " + nuovaPubblicazione.getTitolo() + ", è stata aggiunta con successo");
    }

    //2.delete per ISBN
    public void findByIsbnAndDelete(String isbn) {
        if (isbn.isEmpty()) throw new NotFoundException(String.format("L'elemento %s non è stato trovato", isbn));
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Pubblicazione> query = em.createQuery("SELECT a FROM Pubblicazione a WHERE a.isbn = :isbn ", Pubblicazione.class);
        query.setParameter("isbn", isbn);
        Pubblicazione found = query.getSingleResult();
        em.remove(found);
        transaction.commit();
        System.out.println("L'elemento " + isbn + "è stato eliminato con successo");

    }

    //3.findby ISBN
    public Pubblicazione findByIsbn(String isbn) {
        TypedQuery<Pubblicazione> query = em.createQuery("SELECT a FROM Pubblicazione a WHERE a.isbn = :isbn ", Pubblicazione.class);
        query.setParameter("isbn", isbn);
        if (isbn.isEmpty()) throw new NotFoundException(String.format("L'elemento %s non è stato trovato", isbn));
        Pubblicazione found = query.getSingleResult();
        System.out.println("La pubblicazione con isbn: " + isbn + " è stata trovata con successo");
        return found;

    }

    //4.findby Anno di Pubblicazione
    public List<Pubblicazione> findByAnnoPubblicazione(LocalDate annoPubblicazione) {
        TypedQuery<Pubblicazione> query = em.createQuery("SELECT a FROM Pubblicazione a WHERE a.annoPubblicazione = :annoPubblicazione ", Pubblicazione.class);
        query.setParameter("annoPubblicazione", annoPubblicazione);
        List<Pubblicazione> listaPubblicazioniAnno = query.getResultList();
        System.out.println("Le pubblicazioni di " + annoPubblicazione + " sono: " + listaPubblicazioniAnno);
        return listaPubblicazioniAnno;
    }

    //5. findby Autore
    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = em.createQuery("SELECT a FROM Libro a WHERE a.autore LIKE CONCAT ('%',:autore,'%')", Libro.class);
        query.setParameter("autore", autore);
        List<Libro> listaAutori = query.getResultList();
        System.out.println("Gli autori che potrebbero interessarti sono: " + listaAutori);
        return listaAutori;
    }

    //5.findby con ilike
    public List<Pubblicazione> findPubblicazioneByTitolo(String titolo) {
        TypedQuery<Pubblicazione> query = em.createQuery("SELECT a FROM Pubblicazione a WHERE a.titolo LIKE CONCAT ('%',:titolo,'%')", Pubblicazione.class);
        query.setParameter("titolo", titolo);
        List<Pubblicazione> listaTitoli = query.getResultList();
        System.out.println("I titolo che potrebbero interessarti sono: " + listaTitoli);
        return listaTitoli;
    }
}
