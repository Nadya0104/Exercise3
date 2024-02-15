/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_2;
public class Judge implements Runnable {
    private final GamePlay game;
    public Judge(GamePlay game){
        this.game = game;
    }
    public void run(){
        while (!Thread.interrupted()){
            if(game.getNumOfRounds() == 10) Thread.currentThread().interrupt(); //interrupt when finish 10 games
            else {
                game.makeCoinAvail(false); //make coin not available for 1 second
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
                game.makeCoinAvail(true); //make coin available for 0.5 second
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
        }
    }
}
