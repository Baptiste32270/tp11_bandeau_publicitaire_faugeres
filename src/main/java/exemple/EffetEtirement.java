package exemple;

import java.awt.Font;

import bandeau.Bandeau;

public class EffetEtirement extends Effet {

    @Override
    public void jouerSur(Bandeau b) {
        String messageOriginal = b.getMessage();
        Font fontOriginale = b.getFont();
        
        // On réduit un peu la police au début car l'étirement prend de la place
        b.setFont(new Font(fontOriginale.getName(), Font.BOLD, 15));

        // 1. Phase d'étirement (Ajout d'espaces)
        // On va insérer de 0 à 5 espaces entre chaque lettre
        for (int i = 0; i < 10; i++) {
            String messageEtire = espacer(messageOriginal, i);
            b.setMessage(messageEtire);
            b.sleep(50);
        }

        // Pause en extension max
        b.sleep(200);

        // 2. Phase de retour (Rétraction)
        for (int i = 10; i >= 0; i--) {
            String messageEtire = espacer(messageOriginal, i);
            b.setMessage(messageEtire);
            b.sleep(50);
        }

        // Restauration de l'état initial
        b.setFont(fontOriginale);
        b.setMessage(messageOriginal);
    }

    /**
     * Méthode utilitaire pour insérer 'nbEspaces' entre chaque lettre
     */
    private String espacer(String texte, int nbEspaces) {
        StringBuilder sb = new StringBuilder();
        
        // Création de la chaine d'espaces
        String espaces = "";
        for(int k=0; k < nbEspaces; k++) espaces += " ";

        // Construction du mot
        for (int i = 0; i < texte.length(); i++) {
            sb.append(texte.charAt(i));
            // On ajoute les espaces sauf après la dernière lettre
            if (i < texte.length() - 1) {
                sb.append(espaces);
            }
        }
        return sb.toString();
    }
}