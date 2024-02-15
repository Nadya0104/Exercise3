/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_3;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");
		SlicerMachine machine = new SlicerMachine();
		CucumbersThread cucumbersThread = new CucumbersThread(machine);
		TomatoesThread tomatoesThread = new TomatoesThread(machine);
		SlicerThread slicerThread = new SlicerThread(numOfSaladsToPrepare, machine);
		cucumbersThread.start();
		tomatoesThread.start();
		slicerThread.start();
		try{
			cucumbersThread.join();
			tomatoesThread.join();
			slicerThread.join();
		}catch (InterruptedException ignored){}
		System.out.println("Done");
		scan.close();
	}
}
