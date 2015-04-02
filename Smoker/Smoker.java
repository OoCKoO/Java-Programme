package SmokerTest;
/*Smoker.java
Version 1.0
Autor: C. Kahraman
Zweck: Raucht die Zutaten vom Tisch
*/


public class Smoker extends Thread{

	Zutaten zutat;
	Agent agent;
	Tisch tisch; 
	
	
	public Smoker(Zutaten zutat, Tisch tisch,Agent agent) {
		this.zutat = zutat;
		this.tisch = tisch;
		this.agent = agent;
	}
		
	@Override
	public void run() {
		while(!this.isInterrupted()) {
			
		
					try {
						// Zutaten vom Tisch nehmen sofern im besitz der passenden 3. Zutat
						tisch.getZutatenVomTisch(zutat,this.getName());
						
					} catch (InterruptedException e) {
						this.interrupt();
					}
			
			
		}
	}

}
