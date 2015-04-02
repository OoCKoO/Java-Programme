package CarRace;

/* Car.java
 Version 1.0
 Autor: C. Kahraman
 Zweck: Erzeugt ein Auto für das Rennen
 */
class Car extends Thread {
	private int carId;
	private int time;
	private int lap;
	private int random = (int) (Math.random() * 100);
	

	Car(int i ) {
		
		this.setCarId(i);
		this.setTime(0);
		this.lap=1;
	}



	public void run() {
		while(this.getLap() <= Race.rounds) {
			// „ausgewürfelt“ (0 <= Rundenzeit < 100 ms) und der Auto‐Thread
			// muss solange anhalten
			try {
				sleep(random);

			} catch (InterruptedException e) {
				System.out.println("Unfall während des Rennens :" + this.getCarId());
			}
				this.setTime(time + random);
				this.setLap();
		}

	}
	 public int getLap(){
	        return this.lap;
	    }

	 public void setLap() {
			this.lap++;
			
		}
	public void setCarId(int i) {
		this.carId= i;
		
	}
	public int getCarId() {
		return carId;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}