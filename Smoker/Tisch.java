package SmokerTest;
/* Tisch.java
Version 2.0
Autor: C. Kahraman
Zweck: Ablauf der Simulation
*/


import java.util.ArrayList;

public class Tisch {

	ArrayList<Zutaten> zutatenAufTisch = new ArrayList<Zutaten>(2);

	public synchronized void getZutatenVomTisch(Zutaten zutat, String threadName) throws InterruptedException {

		while(zutatenAufTisch.isEmpty() || istEigeneZutat(zutat,zutatenAufTisch.get(0).getZutat(),zutatenAufTisch.get(1).getZutat()) == false) {
				wait();
		}

				// Zutaten werden vom Tisch genommen
				clearTisch();
					 
				// Smoker hat die passende 3. Zutat und dreht sich eine Zigarette um sie dann zu rauchen
				System.out.println("Smoker "+threadName+" hat "+zutat.getZutat()+" und dreht eine Zigarette um diese anschliessend zu rauchen");
			
				
				// Kurzer Moment in dem die Zigarette geraucht wird
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					System.out.println("Sleep interrupt");
					Thread.currentThread().interrupt();
				}   
			
		
				// Smoker ist fertig mit rauchen
			    System.out.println("Smoker "+threadName+" hat fertig geraucht!\n");
			    
		//Alle Threads aufwecken die auf dem Objektmonitor warten
		 notifyAll();   
	}
	
	
	// Zutaten auf den Tisch legen
	public synchronized void putZutatAufTisch(Zutaten rndZutat1, Zutaten rndZutat2) throws InterruptedException {
	
		while(zutatenAufTisch.size() == 2) {
			// Aktuellen Thread warten lassen bis ein andere Thread ihn wieder aufweckt
			wait();			
		}
		
		//Zutaten auf den Tisch legen
		zutatenAufTisch.add(rndZutat1);
		zutatenAufTisch.add(rndZutat2);

		//Alle Threads aufwecken die auf dem Objektmonitor warten
		notifyAll();  
	}
	
	// Checken ob eine der beiden Zutaten auf dem Tisch die gleiche ist wie die, die der jeweilige Smoker besitzt
	public boolean istEigeneZutat(Zutaten zutat,String zutatEinsAufTisch,String zutatZweiAufTisch) throws InterruptedException{
		
		if(!(zutatEinsAufTisch.equals(zutat.getZutat())) && !(zutatZweiAufTisch.equals(zutat.getZutat()))) {
			return true;
		}
		else {
			return false;
		}
	}

	
	// Zutaten vom Tisch nehmen
	public void clearTisch() {
		zutatenAufTisch.clear();
	}
}

