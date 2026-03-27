package giuliacrepaldi.dao;

import giuliacrepaldi.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    //Metodi
    //Prestiti scaduti e ancora non restituiti

    public List<Prestito> findAllPrestitiScaduti() {
        Date oggi = new Date();
        TypedQuery<Prestito> query = em.createQuery("SELECT a FROM Prestito a WHERE a.dataRestituzionePrevista < :oggi AND a.dataRestituzioneEffettiva IS NULL", Prestito.class);
        query.setParameter("oggi", oggi);
        List<Prestito> listaPrestiti = query.getResultList();
        System.out.println("I prestiti non restituiti: " + listaPrestiti);
        return listaPrestiti;
    }

    public List<Prestito> findUtentiConPrestito(int numeroTessera) {
        TypedQuery<Prestito> query = em.createQuery("SELECT a FROM Prestito a WHERE a.utente.numeroTessera = :numeroTessera AND a.dataRestituzioneEffettiva IS NULL", Prestito.class);
        query.setParameter("numeroTessera", numeroTessera);
        List<Prestito> listaPrestitiUtente = query.getResultList();
        System.out.println("I libri in prestito per " + numeroTessera + " sono: " + listaPrestitiUtente);
        return listaPrestitiUtente;
    }
}
