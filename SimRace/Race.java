package CarRace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* Race.java
 Version 1.0
 Autor: C. Kahraman
 Zweck: Liste aller Teilnehmer im Rennen
 */


public class Race {
	/* Die Konstanten*/
    public static final int rounds = 8;
    public static final int cars = 5;
   
    List<Car> allCars = new ArrayList<>();
   
    public Race(){
               
    }
    /* Startet alle in der Liste enthaltenen Objekte(Car) */
    public void startRace(){
        for(Car car : allCars){
            car.start();
        }
    }
    /* Fügt der Liste ein Car Objekt zu */
    public void addCar(Car car){
        allCars.add(car);
    }
    /* Gibt die Zeit des letzten Autos aus */
    public int lastCarTime(){
    	Car last= allCars.get(allCars.size() -1);
        return last.getTime();
    }
    /* Vergleich ob das Rennen zu Ende ist */
    private boolean endOfRace(){
        for(Car car : allCars){
            if(car.getLap() < Race.rounds){
                return false;
            }
        }
        return true;
    }
    /* Sortiert alle Cars nachdem das Rennen zu Ende ist */
    public void sortAllCars(){
     if (endOfRace()) {
        /* Wird mit Collections sortiert */
        Collections.sort(allCars, new Comparator<Car>() {
            public int compare(Car o1, Car o2) {return Integer.compare(o1.getTime(), o2.getTime());}
        });
        
     }
    }
    /* Ausgabe der Cars  */
    public void printAllCars(){
    int i = 1;
    System.out.println("**** Endstand ****");
    for (Car car : allCars)
        System.out.println(i++ + ". Platz: Wagen " + car.getCarId() + " Zeit: " + car.getTime());
    }
   
}
