package 线程优先级;

public class Test {

    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            MyThread1 myThread1 = new MyThread1();
            myThread1.setPriority(10);
            myThread1.start();
            MyThread2 myThread2 = new MyThread2();
            myThread2.setPriority(1);
            myThread2.start();
        }
        /*
        我的输出如下:
2222222
1111111
1111111
2222222
1111111
1111111
2222222
1111111
2222222
2222222
2222222
1111111
1111111
2222222
1111111
2222222
1111111
1111111
2222222
1111111
2222222
2222222
可以看出,并不是1就一定比10晚执行,只是1抢到CPU资源的几率比10要低而已
*/

    }
}
