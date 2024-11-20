
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Menu extends JFrame implements ActionListener {

    JButton play;
    JButton rule;
    JButton credits;
    JFrame menu;

    Menu() {
        menu = new JFrame("Menu");
        play = new JButton("Jouer");
        rule = new JButton("Règles");
        credits = new JButton("Crédits");

        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(1000, 800);
        menu.setLayout(null);
        menu.setLocationRelativeTo(null);

        menu.setIconImage(new ImageIcon(getClass().getResource("/img/img.png")).getImage());

        play.setBounds(420, 100, 160, 60);
        play.addActionListener(this);

        rule.setBounds(420, 300, 160, 60);
        rule.addActionListener(this);

        credits.setBounds(420, 500, 160, 60);
        credits.addActionListener(this);

        menu.add(play);
        menu.add(rule);
        menu.add(credits);

        menu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {
            menu.dispose();
            new Puissance4().setVisible(true);
        }

        if (e.getSource() == rule) {
            menu.dispose();
            new Rule();
        }

        if (e.getSource() == credits) {
            menu.dispose();
            new Credits();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu();
            }
        });
    }

}

class Rule extends JFrame implements ActionListener {
    JButton retour;
    JFrame rule;

    Rule() {
        rule = new JFrame("Règles");
        retour = new JButton("Retour au menu");
        rule.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rule.setSize(800, 200);
        rule.setLayout(new FlowLayout());
        rule.setIconImage(new ImageIcon(getClass().getResource("/img/img.png")).getImage());
        rule.setLocationRelativeTo(null);

        retour.setBounds(420, 700, 160, 60);
        retour.addActionListener(this);

        JLabel regle = new JLabel("Aligner 4 jetons en ligne, colonne, ou diagonale");

        rule.add(regle);
        rule.add(retour);

        rule.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retour) {
            rule.dispose();
            new Menu();
        }
    }
}

class Credits extends JFrame implements ActionListener {

    JButton retour;
    JFrame credits;
    JLabel hyperlink = new JLabel("Credits");

    Credits() {
        credits = new JFrame("Crédits");
        retour = new JButton("Retour au menu");

        credits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        credits.setSize(500, 200);
        credits.setLayout(new FlowLayout());
        credits.setIconImage(new ImageIcon(getClass().getResource("/img/img.png")).getImage());
        credits.setLocationRelativeTo(null);

        hyperlink.setForeground(Color.BLUE.darker());
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        hyperlink.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://youtu.be/CD59ZC57wPU"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText("Credits");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>" + "Credits" + "</a></html>");
            }

        });

        retour.setBounds(420, 700, 160, 60);
        retour.addActionListener(this);

        credits.add(retour);
        credits.add(hyperlink);

        credits.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == retour) {
            credits.dispose();
            new Menu();
        }
    }
}

class Puissance4 extends JFrame {
    P4Modele modele;
    P4Vue vue;

    public Puissance4() {
        super("Puissance 4 par Kilian Giraud");

        modele = new P4Modele();
        vue = new P4Vue(modele);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon(getClass().getResource("/img/img.png")).getImage());

        getContentPane().setBackground(Color.BLACK);

        EmptyBorder border = new EmptyBorder(2, 5, 5, 5);
        vue.setBorder(border);

        add(vue);

        JLabel Joueur = new JLabel("Tour du Joueur ROUGE");
        Joueur.setBackground(Color.WHITE);
        Joueur.setHorizontalAlignment(JLabel.CENTER);

        add(Joueur, BorderLayout.NORTH);

        vue.setJoueur(Joueur);
    }

}

class P4Modele {
    private static final int JOUEUR_1 = 1;
    private static final int JOUEUR_2 = 2;

    private int[][] plateau;
    private int joueur;

    public P4Modele() {
        plateau = new int[6][7];
        joueur = JOUEUR_1;
    }

    public int getJoueur() {
        return joueur;
    }

    public boolean ColonnePossible(int col) {
        int count = 0;
        for (int i = 5; i >= 0; i--) {
            if (plateau[i][col] == 1 || plateau[i][col] == 2) {
                count++;
            }
        }
        if (count == 6) {
            return false;
        } else {
            return true;
        }
    }

    public void jouer(int col) {
        for (int i = 5; i >= 0; i--) {
            if (plateau[i][col] == 1 || plateau[i][col] == 2) {
                if (plateau[i - 1][col] == 0) {
                    plateau[i - 1][col] = joueur;
                    break;
                }
            }
            if (plateau[i][col] == 0) {
                plateau[i][col] = joueur;
                break;
            }
        }
    }

    public void changerPlayer() {
        joueur = (joueur == JOUEUR_1) ? JOUEUR_2 : JOUEUR_1;
    }

    public boolean win() {
        return winLigne() || winColonne() || winDiagonaleHautGBasD() || winDiagonaleBasGHautD();
    }

    public boolean winLigne() {
        for (int col = 0; col <= 3; col++) {
            for (int row = 0; row <= 5; row++) {
                if (plateau[row][col] == 1 && plateau[row][col + 1] == 1 && plateau[row][col + 2] == 1
                        && plateau[row][col + 3] == 1
                        || plateau[row][col] == 2 && plateau[row][col + 1] == 2
                                && plateau[row][col + 2] == 2
                                && plateau[row][col + 3] == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean winColonne() {
        for (int col = 0; col <= 6; col++) {
            for (int row = 0; row <= 2; row++) {
                if ((plateau[row][col] == 1 && plateau[row + 1][col] == 1 && plateau[row + 2][col] == 1
                        && plateau[row + 3][col] == 1)
                        || (plateau[row][col] == 2 && plateau[row + 1][col] == 2 && plateau[row + 2][col] == 2
                                && plateau[row + 3][col] == 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean winDiagonaleHautGBasD() {
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 3; row++) {
                if ((plateau[row][col] == 1 && plateau[row + 1][col + 1] == 1 && plateau[row + 2][col + 2] == 1
                        && plateau[row + 3][col + 3] == 1)
                        || (plateau[row][col] == 2 && plateau[row + 1][col + 1] == 2 && plateau[row + 2][col + 2] == 2
                                && plateau[row + 3][col + 3] == 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean winDiagonaleBasGHautD() {
        for (int col = 6; col > 2; col--) {
            for (int row = 0; row < 3; row++) {
                if ((plateau[row][col] == 1 && plateau[row + 1][col - 1] == 1 && plateau[row + 2][col - 2] == 1
                        && plateau[row + 3][col - 3] == 1)
                        || (plateau[row][col] == 2 && plateau[row + 1][col - 1] == 2 && plateau[row + 2][col - 2] == 2
                                && plateau[row + 3][col - 3] == 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Tie() {
        int count = 0;
        for (int col = 0; col <= 6; col++) {
            for (int row = 0; row <= 5; row++) {
                if (plateau[row][col] == 1 || plateau[row][col] == 2) {
                    count++;
                }
            }
        }
        if (count == 42) {
            return true;
        } else {
            return false;
        }
    }
}

class P4Vue extends JPanel {
    private final P4Modele modele;
    private final JButton[][] cases;

    private JLabel Joueur;

    public P4Vue(P4Modele leModele) {
        this.modele = leModele;

        cases = new JButton[6][7];

        setLayout(new GridLayout(6, 7, 5, 5));

        setBackground(Color.decode("#386BC3"));
        setPlateau();
    }

    private void setPlateau() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                JButton button = new JButton();

                button.addActionListener(new ClickListener(j));

                cases[i][j] = button;
                cases[i][j].setBackground(Color.decode("#4B4C4D"));

                add(button);
            }
        }
    }

    private void trouverLowCase(int col) {
        for (int i = 5; i >= 0; i--) {
            if (cases[i][col].getBackground().equals(Color.decode("#A60B0B"))
                    || cases[i][col].getBackground().equals(Color.decode("#DEC80D"))) {
                if (cases[i - 1][col].getBackground().equals(Color.decode("#4B4C4D"))) {
                    Color couleurPlayer = modele.getJoueur() == 1 ? Color.decode("#A60B0B") : Color.decode("#DEC80D");
                    cases[i - 1][col].setBackground(couleurPlayer);
                    break;
                }
            }
            if (cases[i][col].getBackground().equals(Color.decode("#4B4C4D"))) {
                Color couleurPlayer = modele.getJoueur() == 1 ? Color.decode("#A60B0B") : Color.decode("#DEC80D");
                cases[i][col].setBackground(couleurPlayer);
                break;
            }
        }
    }

    public void setJoueur(JLabel labelJoueur) {
        this.Joueur = labelJoueur;
        if (modele.getJoueur() == 1) {
            Joueur.setForeground(Color.decode("#A60B0B"));
            Joueur.setText("Tour du joueur ROUGE");
        } else if (modele.getJoueur() == 2) {
            Joueur.setForeground(Color.decode("#DEC80D"));
            Joueur.setText("Tour du joueur JAUNE");
        }
    }

    private class ClickListener implements ActionListener {
        private final int col;

        public ClickListener(int j) {
            this.col = j;
        }

        public void actionPerformed(ActionEvent e) {
            if (modele.ColonnePossible(col)) {
                trouverLowCase(col);
                modele.jouer(col);
                if (modele.win()) {
                    if (modele.getJoueur() == 1) {
                        JOptionPane.showMessageDialog(P4Vue.this, "Joueur ROUGE a gagné !");
                        System.exit(0);
                    } else if (modele.getJoueur() == 2) {
                        JOptionPane.showMessageDialog(P4Vue.this, "Joueur JAUNE a gagné !");
                        System.exit(0);
                    }
                } else {
                    if (modele.Tie()) {
                        JOptionPane.showMessageDialog(P4Vue.this, "Egalité !");
                        System.exit(0);
                    } else {
                        modele.changerPlayer();
                        if (modele.getJoueur() == 1) {
                            Joueur.setForeground(Color.decode("#A60B0B"));
                            Joueur.setText("Tour du joueur ROUGE");
                        } else if (modele.getJoueur() == 2) {
                            Joueur.setForeground(Color.decode("#DEC80D"));
                            Joueur.setText("Tour du joueur JAUNE");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(P4Vue.this, "La colonne est pleine, impossible d'y rentrer un jeton !");
            }
        }
    }

}
