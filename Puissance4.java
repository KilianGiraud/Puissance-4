import javax.swing.*;
import java.awt.*;

public class Puissance4 extends JFrame {
    public Puissance4() {
        super("Puissance 4 - Kilian Giraud");
        P4Modele modele = new P4Modele();
        P4Vue vue = new P4Vue(modele);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon("img/img.png").getImage());

        JLabel joueurLabel = new JLabel("Tour du joueur ROUGE", SwingConstants.CENTER);
        joueurLabel.setFont(new Font("Arial", Font.BOLD, 18));
        joueurLabel.setOpaque(true);
        joueurLabel.setBackground(Color.WHITE);

        vue.setJoueur(joueurLabel);

        add(joueurLabel, BorderLayout.NORTH);
        add(vue, BorderLayout.CENTER);

        setVisible(true);
    }
}