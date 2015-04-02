package CarRace;
/* SimRace.java
 Version 1.0
 Autor: C. Kahraman
 Zweck: RundB
 */
public class SimRace {

	public static void main(String[] args) throws InterruptedException {
		/* 5 Car Objekte erzeugen */
		 	Car one = new Car(1);
	        Car two = new Car(2);
	        Car three = new Car(3);
	        Car four = new Car(4);
	        Car five = new Car(5);
	        /* Rennen, Unfall erzeugen*/
	        Race race = new Race();
	        Accident crash = new Accident(race.allCars);
	        /* Autos dem Rennen zufügen */
	        race.addCar(one);
	        race.addCar(two);
	        race.addCar(three);
	        race.addCar(four);
	        race.addCar(five);

	       
	        /* Starten der Cars,des Unfalls */
	        race.startRace();
	        crash.start();
	        /* Warten auf das Ablaufen der Threads */
	        one.join();
	        two.join();
	        three.join();
	        four.join();
	        five.join();
	        
	       race.sortAllCars();

	       /* Nach der Sortierung wird geguckt,ob der Crash im Rennen oder nachher war*/
	       if(crash.getRandom() > race.lastCarTime()){
	    	   race.printAllCars();
	       }else{
	    	   System.out.println("Unfall während des Rennens,daher keine Ergebnisse!");
	       }


}
}
