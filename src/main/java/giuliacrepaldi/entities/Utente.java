package giuliacrepaldi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "utenti")

public class Utente {
    @Id
    @Column(name = "id_utente")
    private UUID id;

    private String nome;
    private String cognome;
    @Column(name = "data_di_nascita")
    private Date dataDiNascita;
    @Column(name = "numero_tessera")
    private int numeroTessera;

    //Costruttore
    public Utente() {

    }

    public Utente(UUID id, String nome, String cognome, Date dataDiNascita, int numeroTessera) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.numeroTessera = numeroTessera;
    }

    //Getter & Setter
    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(int numeroTessera) {
        this.numeroTessera = numeroTessera;
    }
}
