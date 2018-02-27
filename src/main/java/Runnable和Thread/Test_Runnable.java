package Runnable和Thread;

public class Test_Runnable implements Runnable{

    public int count = 100;
    @Override
    public void run() {
        for (int i = 0; i <= count; count--) {
            System.out.println(count+""+Thread.currentThread().getName());
        }
    }
}
