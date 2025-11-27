package exemple;

import java.awt.Color;
import java.awt.Font;

import bandeau.Bandeau;

public class ExempleDUtilisation {

    public static void main(String[] args) {
        // 1. Initialisation du bandeau
        Bandeau monBandeau = new Bandeau();
        Font fontBase = new Font("SansSerif", Font.BOLD, 24);
        monBandeau.setFont(fontBase);
        monBandeau.setForeground(Color.BLACK);
        
        // 2. Création du scénario
        Scenario s = new Scenario();
        
        // --- Construction du Scénario ---
        
        // Étape 1 : Le texte s'écrit comme une machine (1 fois)
        monBandeau.setMessage("Initialisation du système...");
        s.ajouterEffet(new EffetMachineAEcrire(), 1);
        
        // Étape 2 : Le texte "Vague" ondule (2 fois pour bien voir le mouvement)
        // Note : On change le message juste avant, le scénario applique l'effet sur le texte courant
        // Idéalement, si on veut changer le texte PENDANT le scénario, il faudrait créer un "EffetChangerTexte"
        // Mais pour l'instant, on fait simple.
        s.ajouterEffet(new EffetVague(), 2);
        
        // Étape 3 : Effet d'étirement (1 fois)
        s.ajouterEffet(new EffetEtirement(), 1);
        
        // Étape 4 : Zoom pour attirer l'attention (3 petits zooms ou 1 gros selon votre implémentation de Zoom)
        // Supposons ici qu'on utilise votre EffetZoom standard
        s.ajouterEffet(new EffetZoom(), 1);
        
        // Étape 5 : Fondu au noir/blanc à la fin (1 fois)
        s.ajouterEffet(new EffetAssombrissement(), 1);
        
        
        // --- Exécution ---
        
        System.out.println("Lancement du scénario...");
        
        // On lance le scénario. Notez que le texte affiché sera le dernier défini ("Initialisation...")
        // Sauf si vous créez un effet qui change le texte.
        monBandeau.setMessage("Scenario Demo"); 
        s.jouerSur(monBandeau);
        
        System.out.println("Scénario terminé.");
        monBandeau.sleep(2000);
        monBandeau.close();
    }
}