package CarRace;
import java.util.ArrayList;
import java.util.List;
/* Accident.java
Version 1.0
Autor: C. Kahraman
Zweck: Erzeugt einen Unfall durch eine Zufallszahl
*/




class Accident extends Thread {
	public int random = (int) (Math.random() * 1000);
	List<Car> allCars = new ArrayList<>();

	Accident(List<Car> a) {
		allCars = a;
	
	}
	public void run() {

		try {
			/* Für Random Zeit warten */
			Thread.sleep(random);

		} catch (InterruptedException e) {

		}
		 for(Car car : allCars){
	            car.interrupt();
	        }
	}

	public int getRandom() {
		return random;
	}
}
