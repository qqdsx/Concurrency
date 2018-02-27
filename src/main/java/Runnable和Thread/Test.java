package Runnable和Thread;

public class Test {
    public static void main(String[] args) {
        Test_Runnable test_runnable = new Test_Runnable();
        Test_Runnable test_runnable2 = new Test_Runnable();
        new Thread(test_runnable,"1").start();
        new Thread(test_runnable2,"2").start();
//        Test_Thread test_thread1 = new Test_Thread();
//        Test_Thread test_thread2 = new Test_Thread();
//        test_thread1.start();
//        test_thread2.start();
    }
}
