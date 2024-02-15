/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_3;
public class SlicerThread extends Thread {
    private final int numOfSalads;
    private final SlicerMachine machine;
    public SlicerThread(int numOfSalads, SlicerMachine machine){
        this.numOfSalads = numOfSalads;
        this.machine = machine;
    }
    public void run(){
        while (!isInterrupted()) {
            if (machine.getNumOfPreparedSalads() == numOfSalads) {
                machine.setEnd(true);
                Thread.currentThread().interrupt(); //stop slicer when there are enough prepared salads (by the user's request)
            }
            else machine.sliceVegetables(); //make another salad
        }
    }
}
