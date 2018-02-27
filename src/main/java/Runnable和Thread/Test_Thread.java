package Runnable和Thread;

public class Test_Thread extends Thread {
    public int count = 10;
    @Override
    public void run() {
        for (int i = 0; i <= count; count--) {
            System.out.println(count+""+Thread.currentThread().getName());
        }
    }
}
