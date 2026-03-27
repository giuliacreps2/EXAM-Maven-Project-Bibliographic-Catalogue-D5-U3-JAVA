package giuliacrepaldi.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Prestiti")

public class Prestito {
    @Id
    @Column(name = "id_prestito")
    private UUID idPrestito;

    @Column(name = "data_inizio_prestito")
    private Date dataInizioPrestito;
    @Column(name = "data_restituzione_prevista")
    private Date dataRestituzionePrevista;
    @Column(name = "data_restituzione_effettiva")
    private Date dataRestituzioneEffettiva;

    @ManyToOne
    @JoinColumn(name = "id_pubblicazione")
    private Pubblicazione pubblicazione;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;
}
