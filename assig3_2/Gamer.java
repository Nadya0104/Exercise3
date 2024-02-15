/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_2;
public class Gamer implements Runnable{
    private int goodFlipsCounter;
    private final GamePlay play;
    public Gamer(GamePlay play){
        this.play = play;
        goodFlipsCounter = 0;
    }
    public void run() {
        play();
    }
    public void play(){
        while (!Thread.interrupted() && play.getNumOfRounds() <= 10){
            if (play.getNumOfRounds() == 10) Thread.currentThread().interrupt();
            else {
                if (play.flipCoin()) goodFlipsCounter++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        }
    }
    public int getScore(){
        return goodFlipsCounter;
    }
}
