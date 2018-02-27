package 等待_通知机制;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        new Thread() { // 断点0
            @Override
            public void run() {
                System.out.println("1"); // 断点1
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2"); // 断点2
            }
        }.start();
        new Thread() { // 断点0
            @Override
            public void run() {
                System.out.println("11111"); // 断点1

                System.out.println("222222"); // 断点2
            }
        }.start();
    }
}
