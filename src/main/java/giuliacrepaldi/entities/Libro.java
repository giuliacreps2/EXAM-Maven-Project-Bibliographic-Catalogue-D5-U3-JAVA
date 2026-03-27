package giuliacrepaldi.entities;

import giuliacrepaldi.enumeration.Genere;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@DiscriminatorValue("libro")

public class Libro extends Pubblicazione {

    @Column(name = "autore")
    private String autore;
    @Enumerated
    @Column(name = "genere")
    private Genere genere;

    //Costruttore
    public Libro() {
    }

    public Libro(UUID id, String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore, Genere genere) {
        super(id, isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    //Getter & Setter

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                "} " + super.toString();
    }
}
