# RandomAccessFileExampleGUI

Questo progetto Java implementa un gioco basato su un file di accesso casuale, con un'interfaccia grafica Swing.

## Introduzione

Questo progetto è un'applicazione Java che simula un gioco di dadi utilizzando un file di accesso casuale per memorizzare i dati dei giocatori. L'applicazione fornisce un'interfaccia grafica utente (GUI) che consente agli utenti di lanciare il dado, calcolare il punteggio dei giocatori, visualizzare il vincitore e cancellare i dati dell'archivio.

## Come iniziare

### Prerequisiti

- Java Development Kit (JDK) installato
- Ambiente di sviluppo Java (ad esempio, Eclipse, IntelliJ) consigliato

### Installazione

1. Clona il repository:

   ```bash
   git clone https://github.com/tuonome/RandomAccessFileExampleGUI.git
   ```

2. Apri il progetto nella tua IDE preferita.

3. Esegui il file `RandomAccessFileExampleGUI.java` per avviare l'applicazione.

## Utilizzo

L'applicazione presenta un menu "Game" con le seguenti opzioni:

- **Lancia il dado**: Permette a un giocatore di lanciare il dado e memorizza il risultato nel file.
- **Calcola il punteggio del giocatore**: Calcola il punteggio totale di un giocatore basandosi sui lanci precedenti.
- **Vincitore**: Visualizza il vincitore del gioco basato sul punteggio più alto.
- **Cancella dati**: Cancella tutti i dati memorizzati nel file.
- **Exit**: Chiude l'applicazione.

## Funzionalità

- Utilizzo di un file di accesso casuale per memorizzare i dati dei giocatori.
- Interfaccia grafica Swing per un'esperienza utente migliorata.

## Struttura del codice

Il codice sorgente è suddiviso in due classi principali:

### `RandomAccessFileExampleGUI`

Questa classe gestisce l'interfaccia utente e le interazioni con l'utente. Contiene l'inizializzazione della GUI e la configurazione del menu.

Esempio di lancio del dado:

```java
launchDiceItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            game.lanciaDado();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
});
```

**Spiegazione:**
- `launchDiceItem.addActionListener`: Aggiunge un listener di azione al menu item "Lancia il dado".
- `new ActionListener() { ... }`: Crea un nuovo ActionListener per gestire l'evento di azione.
- `game.lanciaDado()`: Chiama il metodo `lanciaDado()` dell'oggetto `game`, che simula il lancio di un dado e memorizza i dati nel file.

### `RandomAccessFileExample`

Questa classe gestisce le operazioni di accesso casuale su un file e le logiche del gioco.

Esempio di calcolo del punteggio del giocatore:

```java
calculateScoreItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            game.calcolaPunteggio();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
});
```

**Spiegazione:**
- `calculateScoreItem.addActionListener`: Aggiunge un listener di azione al menu item "Calcola il punteggio del giocatore".
- `new ActionListener() { ... }`: Crea un nuovo ActionListener per gestire l'evento di azione.
- `game.calcolaPunteggio()`: Invoca il metodo `calcolaPunteggio()` dell'oggetto `game`, che calcola il punteggio totale di un giocatore basato sui lanci precedenti e mostra il risultato tramite un JOptionPane.

## Contributi

Siamo aperti a contributi! Sentiti libero di aprire issue o pull request per migliorare il progetto.

## Licenza

Questo progetto è concesso in licenza sotto la Licenza MIT - vedi il file [LICENSE](LICENSE) per i dettagli.

## Contatti



---
