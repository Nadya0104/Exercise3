/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_3;
public class CucumbersThread extends Thread {
    private final SlicerMachine machine;
    public CucumbersThread(SlicerMachine machine){
        this.machine = machine;
    }
    public void run(){
        while (!isInterrupted() && machine.numOfCucumbers < machine.cucumbersNeededForOneSalad){
            machine.addOneCucumber();
        }
    }

}
