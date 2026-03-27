package giuliacrepaldi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pubblicazioni")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipi_di_pubblicazione", discriminatorType = DiscriminatorType.STRING)

public abstract class Pubblicazione {
    @Id
    @Column(name = "id_pubblicazione")
    private UUID id;

    @Column(name = "codice_ISBN", nullable = false)
    private String isbn;
    @Column(name = "titolo")
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private LocalDate annoPubblicazione;
    @Column(name = "numero_pagine")
    private int numeroPagine;

    //Costruttore
    public Pubblicazione() {
    }

    Pubblicazione(UUID id, String isbn, String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        this.id = id;
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    //Getter & Setter
    public UUID getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Pubblicazione{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
