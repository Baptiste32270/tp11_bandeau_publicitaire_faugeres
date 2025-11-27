package exemple;

import java.awt.Color;

import bandeau.Bandeau;

public class EffetAssombrissement extends Effet {

    @Override
    public void jouerSur(Bandeau b) {
        // On sauvegarde la couleur actuelle pour la restaurer à la fin
        Color couleurOriginale = b.getBackground();
        
        // 1. Assombrissement progressif vers le NOIR (Fade to Black)
        // On part de 255 (blanc/clair) vers 0 (noir)
        for (int i = 255; i >= 0; i -= 5) {
            b.setBackground(new Color(i, i, i));
            b.sleep(20); // Petite pause pour voir l'animation
        }
        
        // Pause une fois noir
        b.sleep(500);

        // 2. Éclaircissement progressif vers le BLANC (Fade to White)
        for (int i = 0; i <= 255; i += 5) {
            b.setBackground(new Color(i, i, i));
            b.sleep(20);
        }

        // On restaure la couleur d'origine du bandeau
        b.setBackground(couleurOriginale);
    }
}