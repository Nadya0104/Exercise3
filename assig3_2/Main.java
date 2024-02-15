/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_2;
public class Main {
    public static void main(String[] args) {
        GamePlay game = new GamePlay();
        Gamer player0 = new Gamer(game);
        Gamer player1 = new Gamer(game);
        Judge judge = new Judge(game);
        Thread player_0 = new Thread(player0);
        Thread player_1 = new Thread(player1);
        Thread Judge = new Thread(judge);
        player_0.start();
        player_1.start();
        Judge.start();
        try{
            player_0.join();
            player_1.join();
        }catch (InterruptedException ignored){}
        if (player0.getScore() > player1.getScore()) System.out.println("player 0 wins!");
        else if (player0.getScore() == player1.getScore()) System.out.println("tie");
        else System.out.println("player 1 wins!");
    }
}