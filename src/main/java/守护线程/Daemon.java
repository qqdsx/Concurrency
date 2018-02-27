package 守护线程;

import static java.lang.Thread.sleep;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try{
                sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("666666");
            }
        }
    }
}
