package DomaineVoiture;

import java.util.Observable;

public class Voiture extends Observable {

    private int x;
    private int y;
    private int longueur;
    private int largeur;
    private int vitesseMetreSeconde;
    private int directionEnDegres;

    public Voiture(int x, int y, int vitesse, int lon, int lar) {
        this.x = x;
        this.y = y;
        this.longueur = lon;
        this.largeur = lar;
        this.vitesseMetreSeconde = vitesse;
        this.directionEnDegres = 0;
    }

    public void miseAJourPosition() {
        miseAJourPositionX();
        notificationObservateur();
    }

    private void miseAJourPositionX() {
        if (directionEnDegres == 0) {
            x += vitesseMetreSeconde;
        } else if (directionEnDegres == 90) {
            y += vitesseMetreSeconde;
        } else if (directionEnDegres == 180) {
            x -= vitesseMetreSeconde;
        } else if (directionEnDegres == 270) {
            y -= vitesseMetreSeconde;
        }
        if (x > 1000)
            x = 1000;
        else if (x < 0)
            x = 0;
    }

    private void notificationObservateur() {
        this.setChanged();
        this.notifyObservers();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void accelerer() {
        if (vitesseMetreSeconde < 100)
            vitesseMetreSeconde += 10;
    }

    public Object getVitesse() {
        return vitesseMetreSeconde;
    }

    public void setVitesse(int vitesse) {
        vitesseMetreSeconde = vitesse;
    }

    public void inverserDirection() {
        directionEnDegres += 180;
        directionEnDegres = directionEnDegres % 360;

    }

    public Object getDirection() {
        return directionEnDegres;
    }

    public void setDirection(int angleDirection) {
        this.directionEnDegres = angleDirection;

    }

    public void tournerDroite() {
        int lar = largeur;
        this.largeur = longueur;
        this.longueur = lar;
        directionEnDegres += 90;
        directionEnDegres = directionEnDegres % 360;
        System.out.println("Direction en degres" + directionEnDegres);
    }

    public void tournerGauche() {
        int lar = largeur;
        this.largeur = longueur;
        this.longueur = lar;
        directionEnDegres += 270;
        directionEnDegres = directionEnDegres % 360;
        System.out.println("Direction en degres" + directionEnDegres);
    }
}
