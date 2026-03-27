package giuliacrepaldi.dao;

import jakarta.persistence.EntityManager;

public class UtenteDAO {
    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }


}
