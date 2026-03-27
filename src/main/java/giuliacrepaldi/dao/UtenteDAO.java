package giuliacrepaldi.dao;

import giuliacrepaldi.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    //1.save
    public void saveUtente(Utente nuovoUtente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(nuovoUtente);
        transaction.commit();
        System.out.println(nuovoUtente.getNome() + " " + nuovoUtente.getCognome() + ", è un nuovo utente della biblioteca");
    }

}
