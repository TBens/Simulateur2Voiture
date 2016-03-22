package AppliSimu;

import DomaineVoiture.Voiture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandeVoiture extends JPanel implements ActionListener {

    private JButton boutonAccelerer;
    private JButton boutonInverserDirection;
    private JButton boutonTournerDroite;
    private JButton boutonTournerGauche;
    private Voiture maVoiture;


    public CommandeVoiture(JFrame fenetre, Voiture maVoiture) {

        super();
        this.setLayout(new FlowLayout());

        boutonAccelerer = new JButton("Accelerer");
        boutonAccelerer.addActionListener(this);
        this.add(boutonAccelerer);

        boutonInverserDirection = new JButton("Changer direction");
        boutonInverserDirection.addActionListener(this);
        this.add(boutonInverserDirection);

        boutonTournerDroite = new JButton("Tourner Droite");
        boutonTournerDroite.addActionListener(this);
        this.add(boutonTournerDroite);

        boutonTournerGauche = new JButton("Tourner Gauche");
        boutonTournerGauche.addActionListener(this);
        this.add(boutonTournerGauche);

        fenetre.add(this);
        this.maVoiture = maVoiture;
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        Object bouton = event.getSource();
        /*switch (bouton){
            case boutonAccelerer:
                maVoiture.accelerer();
                break;
            case boutonInverserDirection:
                maVoiture.inverserDirection();
                break;
            case boutonTournerDroite:
                break;
            case boutonTournerGauche:
                break;
            default:
                break;
        }*/
        if (bouton == boutonAccelerer) {
            maVoiture.accelerer();
        } else if (bouton == boutonInverserDirection) {
            maVoiture.inverserDirection();
        } else if (bouton == boutonTournerDroite) {
            maVoiture.tournerDroite();
        } else if (bouton == boutonTournerGauche) {
            maVoiture.tournerGauche();
        }

    }


}
