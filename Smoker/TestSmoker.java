package SmokerTest;
/* TestSmoker.java
Version 1.0
Autor: C. Kahraman
Zweck: 
*/


public class TestSmoker {

	
	public static void main(String[] args) {
	
		
		// Erzeuge neues Tisch Object
		Tisch tisch = new Tisch();
		
		// Neuen Agent erzeugen
		Agent agent = new Agent(tisch);
		
		
		// Drei Smoker die am Tisch sitzen mit jeweils 1 Zutat
		Smoker tabak = new Smoker(new Zutaten("Tabak"),tisch,agent);
		Smoker papier = new Smoker(new Zutaten("Papier"),tisch,agent);
	    Smoker streichholz = new Smoker(new Zutaten("Streichholz"),tisch,agent);

	    // Alle Threads Starten
		agent.start();
		tabak.start();
		papier.start();
		streichholz.start();
		
		
		// Mindestlaufzeit von 30 Sekunden
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			return;
		}
		
		// Unterbrechen der jeweiligen Threads
		agent.interrupt();
		tabak.interrupt();
		papier.interrupt();
		streichholz.interrupt();
		
		// Warten bis die Threads beendet sind
	
			try {
				agent.join();
				tabak.join();
				papier.join();
				streichholz.join();
			
			} catch (InterruptedException e) {
				return;
			}

		System.out.println("\n---Ende der Simulation---");
		
		
	}
	
}
