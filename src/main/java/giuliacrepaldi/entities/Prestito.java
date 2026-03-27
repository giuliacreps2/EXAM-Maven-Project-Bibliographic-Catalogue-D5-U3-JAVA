package giuliacrepaldi.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "prestiti")

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

    //Costruttore
    public Prestito() {
    }

    public Prestito(UUID idPrestito, Date dataInizioPrestito, Date dataRestituzionePrevista, Date dataRestituzioneEffettiva) {
        this.idPrestito = idPrestito;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    //Getter & Setter
    public UUID getIdPrestito() {
        return idPrestito;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
}
