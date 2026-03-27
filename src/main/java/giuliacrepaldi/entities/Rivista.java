package giuliacrepaldi.entities;

import giuliacrepaldi.enumeration.Periodicità;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

public class Rivista extends Pubblicazione {
    @Id
    @Column(name = "id_rivista")
    private UUID idRivista;

    @Column(name = "periodicità")
    private Periodicità periodicità;

    //Costruttore
    public Rivista() {
    }

    public Rivista(UUID id, String isbn, String titolo, Date annoPubblicazione, int numeroPagine, UUID idLibro, Periodicità periodicità) {
        super(id, isbn, titolo, annoPubblicazione, numeroPagine);
        this.idRivista = id;
        this.periodicità = periodicità;
    }

    //Getter & Setter
    public UUID getIdRivista() {
        return idRivista;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }
}
