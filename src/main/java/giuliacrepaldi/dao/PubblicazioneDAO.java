package giuliacrepaldi.dao;

import jakarta.persistence.EntityManager;

public class PubblicazioneDAO {
    private final EntityManager em;

    public PubblicazioneDAO(EntityManager em) {
        this.em = em;
    }
}
