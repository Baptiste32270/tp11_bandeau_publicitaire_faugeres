package exemple;

import java.awt.Color;
import java.awt.Font;

import bandeau.Bandeau;

public class ExempleDUtilisation {

    public static void main(String[] args) {
        //Initialisation du bandeau
        Bandeau monBandeau = new Bandeau();
        Font fontBase = new Font("SansSerif", Font.BOLD, 24);
        monBandeau.setFont(fontBase);
        monBandeau.setForeground(Color.BLACK);
        
        //Création du scénario
        Scenario s = new Scenario();
        
        
        //Le texte s'écrit comme une machine (1 fois)
        monBandeau.setMessage("Initialisation du système...");
        s.ajouterEffet(new EffetMachineAEcrire(), 1);
        
        //Le texte "Vague" ondule (2 fois)
        s.ajouterEffet(new EffetVague(), 2);
        
        //Effet d'étirement (1 fois)
        s.ajouterEffet(new EffetEtirement(), 1);
        
        //Zoom
        s.ajouterEffet(new EffetZoom(), 1);
        
        //Fondu au noir/blanc (1 fois)
        s.ajouterEffet(new EffetAssombrissement(), 1);
        
        
        
        
        monBandeau.setMessage("Mon super scénario !!"); 
        s.jouerSur(monBandeau);
        monBandeau.sleep(2000);
        monBandeau.close();
    }
}