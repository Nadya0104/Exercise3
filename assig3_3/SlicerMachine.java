/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_3;
public class SlicerMachine {
	
	int numOfCucumbers = 0;
	int numOfTomatoes = 0;
	int numOfPreparedSalads = 0;
	
	final int cucumbersNeededForOneSalad = 3;
	final int tomatoesNeededForOneSalad = 2;
	private boolean end = false; //boolean variable that check if the slicer finish prepare all the salads
	public synchronized void setEnd(boolean val){ //setter for the end variable
		end = val;
	}
	
	// add one cucumber into the slicer chamber
	synchronized void addOneCucumber() {
		if (numOfCucumbers < cucumbersNeededForOneSalad) {
			if (end) Thread.currentThread().interrupt(); //if slicer finish his work then stop adding cucumbers
			else {
				System.out.println("adding one cucumber to the machine");
				numOfCucumbers++;
			}
		}
		while (numOfCucumbers >= cucumbersNeededForOneSalad){ //while there are enough cucumbers wait until the stock will emptied
			try {
				this.wait();
			} catch (InterruptedException ignored) {}
		}
	}

	// add one tomato into the slicer chamber
	synchronized void addOneTomato() {
		if (numOfTomatoes < tomatoesNeededForOneSalad) {
			if (end) Thread.currentThread().interrupt(); //if slicer finish his work then stop adding tomatoes
			else {
				System.out.println("adding one tomato to the machine");
				numOfTomatoes++;
			}
		}
		while (numOfTomatoes >= tomatoesNeededForOneSalad){//while there are enough tomatoes wait until the stock will emptied
			try {
				this.wait();
			} catch (InterruptedException ignored) {}
		}
	}
	
	// if there are enough vegetables in the slicer
	// chamber, make another salad
	void sliceVegetables() {
		if ((numOfCucumbers >= cucumbersNeededForOneSalad) && (numOfTomatoes >= tomatoesNeededForOneSalad)) {
			makeNewSalad();
		}
	}

	synchronized private void makeNewSalad() {
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++; 
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
		this.notifyAll(); //notify to cucumber Thread and tomato Thread continue with adding vegetables
	}	
	
	int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}

}
