package exemple;

import bandeau.Bandeau;

public class EffetRotation extends Effet {
    @Override
    public void jouerSur(Bandeau b) {
        for (int i = 0; i <= 360; i += 10) {
            b.setRotation(Math.toRadians(i));
            b.sleep(50);
        }
        b.setRotation(0.0);
    }
}