package giuliacrepaldi.entities;

import giuliacrepaldi.enumeration.Periodicità;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;
import java.util.UUID;

@Entity
@DiscriminatorValue("rivista")


public class Rivista extends Pubblicazione {

    @Column(name = "periodicità")
    private Periodicità periodicità;

    //Costruttore
    public Rivista() {
    }

    public Rivista(UUID id, String isbn, String titolo, Date annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(id, isbn, titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    //Getter & Setter

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }
}
