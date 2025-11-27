package exemple;

import bandeau.Bandeau;

public class EffetMachineAEcrire extends Effet {

    @Override
    public void jouerSur(Bandeau b) {
        String messageOriginal = b.getMessage();
        
        // 1. On vide le bandeau pour commencer
        b.setMessage(""); 
        
        // 2. On affiche les caractères un par un
        // On boucle sur la longueur du message
        for (int i = 0; i < messageOriginal.length(); i++) {
            // On récupère la sous-chaîne de 0 jusqu'à i+1
            String sousChaine = messageOriginal.substring(0, i + 1);
            
            b.setMessage(sousChaine);
            b.sleep(100); // Vitesse de frappe (100ms par lettre)
        }
        
        // Sécurité : On s'assure que le message final est bien le bon
        // (utile si le message contient des caractères spéciaux mal coupés, etc.)
        b.setMessage(messageOriginal);
    }
}