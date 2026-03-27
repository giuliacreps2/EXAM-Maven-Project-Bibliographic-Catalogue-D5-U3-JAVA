Scelte progettuali
1. Ereditarietà: Single Table Inheritance
Per la gerarchia Pubblicazione → Libro / Rivista è stata scelta la strategia Single Table Inheritance (@Inheritance(strategy = InheritanceType.SINGLE_TABLE)).
Questa strategia prevede un'unica tabella pubblicazioni nel database che contiene tutti gli attributi sia della classe padre che delle sottoclassi, con le colonne specifiche di Libro (autore, genere) e di Rivista (periodicità) che possono essere NULL a seconda del tipo di pubblicazione.
Motivazione: il numero di attributi differenti tra Libro e Rivista è ridotto (2 per Libro, 1 per Rivista), quindi l'impatto dei valori NULL è minimo. Questa strategia garantisce prestazioni migliori in lettura rispetto alla Joined Table Inheritance, evitando JOIN tra tabelle.
JPA distingue il tipo di pubblicazione tramite una colonna discriminatore (tipi_di_pubblicazione) definita con @DiscriminatorColumn sulla classe padre e @DiscriminatorValue sulle sottoclassi.

--------

2. Relazioni tra entità
Pubblicazione → Prestito (1:N)
Una pubblicazione può essere prestata più volte nel tempo a utenti diversi, ma ogni singolo prestito riguarda una sola pubblicazione. La relazione è quindi One-to-Many.
Utente → Prestito (1:N)
Un utente può avere più prestiti attivi o storici, ma ogni prestito appartiene a un solo utente. La relazione è quindi One-to-Many.
Perché non Many-to-Many
Il Prestito non è una semplice tabella di raccordo tra Utente e Pubblicazione: è un'entità a sé stante con attributi propri significativi (dataInizioPrestito, dataRestituzionePrevista, dataRestituzioneEffettiva). Una Join Table pura conterrebbe solo le due FK, mentre qui il Prestito ha una propria identità e un proprio ciclo di vita.

---------

3. Mappatura delle relazioni: solo @ManyToOne
Le relazioni sono mappate con @ManyToOne sul lato Prestito, senza il lato inverso @OneToMany su Pubblicazione e Utente.
Motivazione: tutte le operazioni richieste dalla consegna partono dall'entità Prestito (ricerca prestiti scaduti, ricerca per numero tessera). Non è necessario navigare da Pubblicazione o Utente verso i loro prestiti. <img width="962" height="712" alt="ERD for Schema" src="https://github.com/user-attachments/assets/ec874ff6-ed9d-4eb1-b678-f110a80dde99" />
<img width="990" height="647" alt="DRAWSQL Schema" src="https://github.com/user-attachments/assets/06f54517-cb29-4df1-902f-2b04d8c8da72" />
<img width="962" height="712" alt="ERD for Schema" src="https://github.com/user-attachments/assets/7a9e7f17-614e-4a60-983a-15a12fc5175e" />
