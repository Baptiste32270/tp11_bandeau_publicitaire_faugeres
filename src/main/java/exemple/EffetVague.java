package exemple;

import java.awt.Font;

import bandeau.Bandeau;

public class EffetVague extends Effet {

    @Override
    public void jouerSur(Bandeau b) {
        // On récupère la police actuelle pour ne pas perdre le style (Gras, Italique...)
        Font fontActuelle = b.getFont();
        int tailleDeBase = fontActuelle.getSize();
        
        // On va faire 2 cycles de vague complets
        for (double i = 0; i < 4 * Math.PI; i += 0.1) {
            
            // 1. Calcul de l'angle (oscillation douce)
            // On reste sur une petite inclinaison (environ 25 degrés max)
            double angle = Math.cos(i) * (Math.PI / 8); 
            b.setRotation(angle);

            // 2. Calcul de la taille (Effet de profondeur)
            // Le texte grossit quand il est "en haut" de la vague et rapetisse "en bas"
            // On ajoute une variation de + ou - 10 pixels
            int nouvelleTaille = (int) (tailleDeBase + (Math.sin(i) * 10));
            
            // On applique la nouvelle police
            // On s'assure que la taille ne tombe jamais à 0 ou moins
            if (nouvelleTaille < 5) nouvelleTaille = 5;
            
            b.setFont(new Font(fontActuelle.getName(), fontActuelle.getStyle(), nouvelleTaille));

            b.sleep(40); // Délai pour fluidifier l'animation
        }
        
        // Remise à l'état initial (très important pour le scénario suivant)
        b.setRotation(0.0);
        b.setFont(fontActuelle);
    }
}