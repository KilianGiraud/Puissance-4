import javax.swing.*;
import java.awt.*;

public class P4Vue extends JPanel {
    private final P4Modele modele;
    private final Cellule[][] cellules = new Cellule[6][7];
    private JLabel joueurLabel;

    public P4Vue(P4Modele modele) {
        this.modele = modele;
        setLayout(new GridLayout(6, 7, 5, 5));
        setBackground(new Color(20, 20, 100));
        initGrille();
    }

    public void setJoueur(JLabel label) {
        this.joueurLabel = label;
        updateJoueur();
    }

    private void initGrille() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                Cellule cellule = new Cellule(row, col);
                cellules[row][col] = cellule;
                add(cellule);
            }
        }
    }

    private void jouerCoup(int col) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        if (!modele.colonnePossible(col)) {
            VictoryDialog.showInfoOnly(frame, "Colonne pleine !", Color.ORANGE);
            return;
        }

        modele.jouer(col);
        updateGrille();

        if (modele.win()) {
            String gagnant = (modele.getJoueur() == 1) ? "Joueur ROUGE a gagné !" : "Joueur JAUNE a gagné !";
            Color couleur = (modele.getJoueur() == 1) ? Color.RED : Color.YELLOW;
            new VictoryDialog(frame, gagnant, couleur);
        } else if (modele.isFull()) {
            new VictoryDialog(frame, "Égalité !", Color.LIGHT_GRAY);
        } else {
            modele.changerPlayer();
            updateJoueur();
        }
    }

    private void updateGrille() {
        int[][] plateau = modele.getPlateau();
        for (int row = 0; row < 6; row++)
            for (int col = 0; col < 7; col++)
                cellules[row][col].setJeton(plateau[row][col]);
        repaint();
    }

    private void updateJoueur() {
        joueurLabel.setText("Tour du joueur " + (modele.getJoueur() == 1 ? "ROUGE" : "JAUNE"));
        joueurLabel.setForeground(modele.getJoueur() == 1 ? Color.RED : Color.YELLOW);
    }

    private class Cellule extends JPanel {
        private int jeton = 0;

        public Cellule(int row, int col) {
            setPreferredSize(new Dimension(80, 80));
            setOpaque(false);
            addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    jouerCoup(col);
                }
            });
        }

        public void setJeton(int val) {
            this.jeton = val;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(Color.DARK_GRAY);
            g2.fillOval(5, 5, getWidth() - 10, getHeight() - 10);

            if (jeton == 1) {
                g2.setColor(Color.RED);
                g2.fillOval(10, 10, getWidth() - 20, getHeight() - 20);
            } else if (jeton == 2) {
                g2.setColor(Color.YELLOW);
                g2.fillOval(10, 10, getWidth() - 20, getHeight() - 20);
            }

            g2.dispose();
        }
    }
}