package 并发_死锁_1;


import java.util.HashMap;

public class Test1 {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";


    static class  sss {

    }

    public static sss getsss(){
        return new sss();
    }
    public static void main(String[] args) {
        HashMap hashMap = new HashMap(2,2);
        new sss();
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }
}
