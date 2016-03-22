package AppliSimu;

import DomaineVoiture.Voiture;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProtoSimu {

    public static final int dureeUneSecondeEnMilliSecondes = 1000;

    public static void main(String[] args) {

        final Voiture maVoiture = new Voiture(100, 600, 10, 30, 15);
        final Route maRoute = new Route(0, 295, 505, 35);
        new IHMVoiture(maVoiture, maRoute);

        Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                maVoiture.miseAJourPosition();
            }
        });

        timerAvancer.start();

        while (true) {
        }

    }

}
