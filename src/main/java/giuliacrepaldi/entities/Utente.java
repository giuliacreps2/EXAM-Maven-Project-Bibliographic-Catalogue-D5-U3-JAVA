package giuliacrepaldi.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Utenti")

public class Utente {
    @Id
    @Column(name = "id_utente")
    private UUID id;

    private String nome;
    private String cognome;
    private String email;
    @Column(name = "data_di_nascita")
    private Date dataDiNascita;
    @Column(name = "numero_tessera")
    @GeneratedValue
    private int numeroTessera;

    //Costruttore
    public Utente() {

    }

    public Utente(UUID id, String nome, String cognome, String email, Date dataDiNascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
