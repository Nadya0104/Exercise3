/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_2;
import java.util.Random;
public class GamePlay {
    private boolean coin_available_;
    private int rounds_counter_;
    public GamePlay(){
        rounds_counter_ = 0;
        coin_available_ = true;
    }
    public synchronized void makeCoinAvail(boolean val){
        coin_available_ = val;
        notifyAll();
    }
    public synchronized boolean flipCoin(){
        Random random = new Random();
        while (!coin_available_){ //player wait until the coin will be available
            try{
                System.out.println(Thread.currentThread().getName() + " is waiting for coin");
                this.wait();
            }catch (InterruptedException ignored){}
        }
        synchronized (this) {
            if (rounds_counter_ == 10) Thread.currentThread().interrupt(); //stop play if finish 10 games
            else {
                System.out.println(Thread.currentThread().getName() + " is flipping coin");
                makeCoinAvail(false);
                rounds_counter_++;
                makeCoinAvail(true);
            }
        }
        return random.nextInt(2) == 1; //0 means failure and 1 means success
    }
    public synchronized int getNumOfRounds(){
        return rounds_counter_;
    }
}
