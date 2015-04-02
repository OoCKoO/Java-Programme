package SmokerTest;
/* Agent.java
Version 1.0
Autor: C. Kahraman
Zweck:  Legt eine zufaellige Zutat auf den Tisch
*/

import java.util.ArrayList;
import java.util.Random;

public class Agent extends Thread {
	
	ArrayList<Zutaten> zutatenListe = new ArrayList<Zutaten>(3); // Liste aller Zutaten die es gibt
	ArrayList<Zutaten> zutatenAufTisch = new ArrayList<Zutaten>(2); // Liste der Zutaten die auf den Tisch gelegt werden
	Tisch tisch;  
	Random random = new Random();  // Generiert eine Zahl groesser 0 und kleiner 1
	
	public Agent(Tisch t) {
		this.tisch = t;
		zutatenListe.add(new Zutaten("Tabak"));  // Pakt bei der erstellung die 3 Zutaten in eine Liste
		zutatenListe.add(new Zutaten("Papier"));
		zutatenListe.add(new Zutaten("Streichholz"));	
	}

	@Override
	public void run() {
		while(!this.isInterrupted()) {
	
			int rndZutat1 = random.nextInt(3); //Zufaellige Zutat zwischen 1-3
			int rndZutat2 = random.nextInt(3); //Zufaellige Zutat zwischen 1-3 (ohne rndZutat1)	
			if(rndZutat1 == rndZutat2) {           //Damit nicht zwei Zutaten doppel gewaehlt werden
				while(rndZutat1 == rndZutat2) {
					rndZutat2 = random.nextInt(3);
				}
			}

			Zutaten zutat1 = new Zutaten(zutatenListe.get(rndZutat1).getZutat()); // Erstes ZutatenObjekt erstellen
			Zutaten zutat2 = new Zutaten(zutatenListe.get(rndZutat2).getZutat()); // Zweites Zutatenobjekt erstellen
			
				
				try {
					
					tisch.putZutatAufTisch(zutat1,zutat2); // Zufaellige Zutaten auf den Tisch legen
				
				} catch (InterruptedException e) {
					this.interrupt();
				}
	
				System.out.println("Agent legt "+zutatenListe.get(rndZutat1).getZutat()+" und "+zutatenListe.get(rndZutat2).getZutat()+" auf den Tisch");	
		}
		
	}

}
