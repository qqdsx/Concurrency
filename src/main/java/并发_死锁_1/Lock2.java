package 并发_死锁_1;

class Lock2 implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("Lock2 running");
//            while(true){
            synchronized(Test1.obj2){
                System.out.println("Lock2 lock obj2");
                Thread.sleep(3000);
                synchronized(Test1.obj1){
                    System.out.println("Lock2 lock obj1");
                }
            }
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}