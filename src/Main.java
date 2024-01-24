import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class RandomAccessFileExampleGUI extends JFrame {
    private RandomAccessFileExample game;

    public RandomAccessFileExampleGUI(String fileName) throws FileNotFoundException {
        this.game = new RandomAccessFileExample(fileName);
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Random Access File Game");

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);

        JMenuItem launchDiceItem = new JMenuItem("Lancia il dado");
        JMenuItem calculateScoreItem = new JMenuItem("Calcola il punteggio del giocatore");
        JMenuItem displayWinnerItem = new JMenuItem("Vincitore");
        JMenuItem clearDataItem = new JMenuItem("Cancella dati");
        JMenuItem exitItem = new JMenuItem("Exit");

        gameMenu.add(launchDiceItem);
        gameMenu.add(calculateScoreItem);
        gameMenu.add(displayWinnerItem);
        gameMenu.add(clearDataItem);
        gameMenu.add(exitItem);

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

        displayWinnerItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.visualizzaVincitore();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        clearDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    game.cancellaArchivio();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new RandomAccessFileExampleGUI("giocoDado.dat");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

class RandomAccessFileExample {
    private RandomAccessFile file;

    public RandomAccessFileExample(String fileName) throws FileNotFoundException {
        this.file = new RandomAccessFile(fileName, "rw");
    }

    public void lanciaDado() throws IOException {
        String nomeGiocatore = JOptionPane.showInputDialog("Inserisci il nome del giocatore:");

        int dado = (int) (Math.random() * 6) + 1;

        file.seek(file.length());
        file.writeUTF(nomeGiocatore);
        file.writeInt(dado);

        JOptionPane.showMessageDialog(null, nomeGiocatore + " ha lanciato il dado e ottenuto: " + dado);
    }

    public void calcolaPunteggio() throws IOException {
        String nomeGiocatore = JOptionPane.showInputDialog("Inserisci il nome del giocatore:");

        file.seek(0);
        int punteggio = 0;

        while (file.getFilePointer() < file.length()) {
            String nome = file.readUTF();
            int dado = file.readInt();

            if (nome.equals(nomeGiocatore)) {
                punteggio += dado;
            }
        }

        JOptionPane.showMessageDialog(null, "Il punteggio totale di " + nomeGiocatore + " è: " + punteggio);
    }

    public void visualizzaVincitore() throws IOException {
        file.seek(0);
        String vincitore = "";
        int maxPunteggio = 0;

        while (file.getFilePointer() < file.length()) {
            String nome = file.readUTF();
            int dado = file.readInt();

            int punteggio = dado;
            if (punteggio > maxPunteggio) {
                maxPunteggio = punteggio;
                vincitore = nome;
            }
        }

        JOptionPane.showMessageDialog(null, "Il vincitore è: " + vincitore + " con un punteggio di: " + maxPunteggio);
    }

    public void cancellaArchivio() throws IOException {
        file.setLength(0);
        JOptionPane.showMessageDialog(null, "Archivio dei dati cancellato.");
    }
}
