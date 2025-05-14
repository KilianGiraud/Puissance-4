import javax.swing.*;
import java.awt.*;

public class RuleWindow extends JFrame {
    public RuleWindow() {
        super("Règles du jeu");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/img.png")).getImage());

        JLabel label = new JLabel("📘 Aligner 4 jetons en ligne, colonne ou diagonale.", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton retour = new JButton("Retour au menu");
        retour.setFont(new Font("Arial", Font.BOLD, 16));
        retour.addActionListener(e -> {
            dispose();
            new Menu();
        });

        add(label, BorderLayout.CENTER);
        add(retour, BorderLayout.SOUTH);
        setVisible(true);
    }
}