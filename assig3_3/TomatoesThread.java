/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_3;
public class TomatoesThread extends Thread {
    private final SlicerMachine machine;
    public TomatoesThread (SlicerMachine machine){
        this.machine = machine;
    }
    public void run(){
        while (!isInterrupted() && machine.numOfTomatoes < machine.tomatoesNeededForOneSalad){
            machine.addOneTomato();
        }
    }
}
