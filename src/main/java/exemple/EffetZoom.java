package exemple;

import java.awt.Font;

import bandeau.Bandeau;

public class EffetZoom extends Effet {
    @Override
    public void jouerSur(Bandeau b) {
        String message = b.getMessage();
        for (int i = 5; i < 60; i += 5) {
            b.setFont(new Font("SansSerif", Font.BOLD, 5 + i));
            b.sleep(100);
        }
        // Retour à la taille normale
        b.setFont(new Font("SansSerif", Font.BOLD, 20));
    }
}