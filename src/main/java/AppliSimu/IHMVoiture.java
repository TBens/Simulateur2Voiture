package AppliSimu;

import DomaineVoiture.Voiture;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class IHMVoiture extends JFrame implements Observer {

    private double paramatreConversionMetresPixels = 0.5;
    private Voiture maVoiture;
    private CommandeVoiture maCommandeVoiture;
    private Route maRoute;

    public IHMVoiture(Voiture maVoiture) {
        super();
        this.maVoiture = maVoiture;
        maVoiture.addObserver(this);
        initGraphique();
    }

    public IHMVoiture(Voiture maVoiture, Route maRoute) {
        super();
        this.maVoiture = maVoiture;
        maVoiture.addObserver(this);
        initGraphique();
        this.maRoute = maRoute;
    }

    public IHMVoiture() {
        super();
        initGraphique();
        this.maVoiture = null;
    }

    private void initGraphique() {
        this.setTitle("Simulateur de Voiture");
        this.setSize(505, 505);

        this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

        this.setVisible(true);
    }

    public int calculerPositionPixels(int xMetres) {
        return (int) (paramatreConversionMetresPixels * xMetres);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        this.repaint();
    }

    @Override
    public void paint(Graphics contexteGraphique) {
        super.paint(contexteGraphique);
        contexteGraphique.setColor(Color.blue);
        maRoute.dessinerRoute(contexteGraphique);
        contexteGraphique.setColor(Color.red);
        dessinerVoiture(contexteGraphique);

    }


    private void dessinerVoiture(Graphics contexteGraphique) {
        int xMetres = maVoiture.getX();
        int xPixel = calculerPositionPixels(xMetres);
        int yMetres = maVoiture.getY();
        int yPixel = calculerPositionPixels(yMetres);

        contexteGraphique.fillRect(xPixel, yPixel, maVoiture.getLongueur(), maVoiture.getLargeur());
    }

}
