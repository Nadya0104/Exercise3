/**
 * Nadezda Ambartzumove 207267113
 * Noe Mignolet 209709260
 */
package assig3_1;
public class Main {
    private static boolean t1_done = false;
    private static boolean t2_done = false;
    private static final Object lock = new Object();
    public static void main (String[] args){
        Thread t1 = new Thread(() -> {
            while (true){
                synchronized (lock){
                    System.out.println("Block A"); //doing A block
                    t1_done = true; //change t1 state to done (after one running)
                    lock.notifyAll(); //notify other threads
                    while (t1_done) {
                        try {
                            lock.wait(); //waiting until C block end
                        } catch (InterruptedException ignored) {
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true){
                synchronized (lock){
                    while (!t1_done){
                        try {
                            lock.wait(); //waiting until A block end
                        }catch (InterruptedException ignored){}
                    }
                    System.out.println("Block B"); //doing B block
                    t2_done = true; //change t2 state to done (after one running)
                    lock.notifyAll(); //notify other threads but doing B block until CPU time is taken
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (true){
                synchronized (lock){
                    while (!t1_done || !t2_done){
                        try {
                            lock.wait(); //waiting until A and B block both done
                        }catch (InterruptedException ignored){}
                    }
                    System.out.println("Block C"); //doing C block
                    t1_done = false; //change t1 state to false
                    t2_done = false; //change t2 state to false
                    lock.notifyAll(); //notify other threads and waiting
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
