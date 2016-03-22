package AppliSimu;

import java.awt.*;

/**
 * Created by 21303045 on 22/03/2016.
 */
public class Route {

    int longueur;
    int largeur;
    int x;
    int y;

    public Route(int y, int x, int lon, int lar) {
        this.longueur = lon;
        this.largeur = lar;
        this.x = x;
        this.y = y;
    }

    public void dessinerRoute(Graphics contexteGraphique) {
        contexteGraphique.fillRect(y, x, longueur, largeur);
        contexteGraphique.fillRect(250, 295, largeur, 250);
    }
}
