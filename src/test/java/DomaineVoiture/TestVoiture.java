package DomaineVoiture;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestVoiture {
	
	private Voiture maVoiture;
	
	@Before
	public void setUp(){
		maVoiture = new Voiture (100, 0, 10, 30, 15);
	}
	
	@Test
	public void  testEvolutionXenFonctionVitesseSurUnTopSeconde() {
		
		maVoiture.miseAJourPosition();
		
		assertEquals(110, maVoiture.getX());
        assertEquals(0, maVoiture.getY());
	}
	
	@Test
	public void testAcceleration(){
		
		maVoiture.accelerer();
		
		assertEquals(20, maVoiture.getVitesse());
	}
	
	@Test
	public void testAccelerationLimite() {
		
		maVoiture.setVitesse(100);
		maVoiture.accelerer();
		assertEquals(100, maVoiture.getVitesse());
		
	}

	@Test
	public void testChangementDeSens() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		assertEquals(180, maVoiture.getDirection());
		
	}
	
	@Test
	public void testChangementDeSensEtEvolutionDeX() {
		
		maVoiture.setDirection(0);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(90, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteHaute() {
		
		maVoiture.setVitesse(1000);
		maVoiture.miseAJourPosition();
		assertEquals(1000, maVoiture.getX());
		
	}
	
	@Test
	public void testPositionLimiteBasse() {
		
		maVoiture.setVitesse(1000);
		maVoiture.inverserDirection();
		maVoiture.miseAJourPosition();
		assertEquals(0, maVoiture.getX());
		
	}

    @Test
     public void testTournerGauche() {
        maVoiture.setDirection(0);
        maVoiture.tournerGauche();
        maVoiture.miseAJourPosition();
        assertEquals(270, maVoiture.getDirection());
        assertEquals(30, maVoiture.getLargeur());
        assertEquals(15, maVoiture.getLongueur());
    }

    @Test
    public void testTournerDroite() {
        maVoiture.setDirection(0);
        maVoiture.tournerDroite();
        maVoiture.miseAJourPosition();
        assertEquals(90, maVoiture.getDirection());
        assertEquals(30, maVoiture.getLargeur());
        assertEquals(15, maVoiture.getLongueur());
    }
	
}
