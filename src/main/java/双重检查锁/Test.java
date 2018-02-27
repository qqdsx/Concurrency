package 双重检查锁;

public class Test {
    private static Demo demo = null;
    private static volatile Demo demo2 = null;

    //比较糟糕的设计,每次都用synchronized,强烈不推荐
    public synchronized static Demo getInstance_worse(){
                if(demo == null) {
                    demo = new Demo();
                }
        return demo;
    }

    //比较好的设计,但是因为重排序而让别的线程取得未初始化的空值
    public static Demo getInstance_better(){
        if (demo == null){
            synchronized (Test.class){
                if(demo == null) {
                    demo = new Demo();
                }
            }
        }
    return demo;
    }

    //最好的设计,用volatile解决重排序问题(volatile禁止多线程重排序)
    public static Demo getInstance_best(){
        if (demo2 == null){
            synchronized (Test.class){
                if(demo2 == null) {
                    demo2 = new Demo();
                }
            }
        }
        return demo2;
    }
}
