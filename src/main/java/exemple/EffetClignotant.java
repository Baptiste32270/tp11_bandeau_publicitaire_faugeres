package exemple;

import java.awt.Color;

import bandeau.Bandeau;

public class EffetClignotant extends Effet {
    @Override
    public void jouerSur(Bandeau b) {
        Color originalColor = b.getForeground();
        
        for (int i = 0; i < 10; i++) {
            // Texte rouge
            b.setForeground(Color.RED);
            b.sleep(100);
            // Texte original (ou noir)
            b.setForeground(Color.BLACK);
            b.sleep(100);
        }
        b.setForeground(originalColor);
    }
}