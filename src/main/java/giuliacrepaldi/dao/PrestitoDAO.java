package giuliacrepaldi.dao;

import jakarta.persistence.EntityManager;

public class PrestitoDAO {
    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }
}
