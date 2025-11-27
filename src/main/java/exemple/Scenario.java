package exemple;

import java.util.ArrayList;
import java.util.List;

import bandeau.Bandeau;


public class Scenario {

    private static class Etape {
        Effet effet;
        int repetitions;

        public Etape(Effet effet, int repetitions) {
            this.effet = effet;
            this.repetitions = repetitions;
        }
    }

    // Liste ordonnée des étapes à jouer
    private final List<Etape> sequence = new ArrayList<>();

    public void ajouterEffet(Effet effet, int repetitions) {
        if (effet != null && repetitions > 0) {
            sequence.add(new Etape(effet, repetitions));
        }
    }

    public void jouerSur(Bandeau b) {
        // On parcourt chaque étape ajoutée au scénario
        for (Etape etape : sequence) {
            // Pour chaque étape, on répète l'effet le nombre de fois demandé
            for (int i = 0; i < etape.repetitions; i++) {
                etape.effet.jouerSur(b);
            }
        }
    }
}