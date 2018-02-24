package 并发_死锁_1;

public class Test1 {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args) {
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
}
