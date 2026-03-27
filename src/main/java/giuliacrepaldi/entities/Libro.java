package giuliacrepaldi.entities;

import giuliacrepaldi.enumeration.Genere;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

public class Libro extends Pubblicazione {
    @Id
    @Column(name = "id_libro")
    private UUID idLibro;

    @Column(name = "autore")
    private String autore;
    @Enumerated
    @Column(name = "genere")
    private Genere genere;

    //Costruttore
    public Libro() {
    }

    public Libro(UUID id, String isbn, String titolo, Date annoPubblicazione, int numeroPagine, UUID idLibro, String autore, Genere genere) {
        super(id, isbn, titolo, annoPubblicazione, numeroPagine);
        this.idLibro = idLibro;
        this.autore = autore;
        this.genere = genere;
    }

    //Getter & Setter
    public UUID getIdLibro() {
        return idLibro;
    }

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
}
