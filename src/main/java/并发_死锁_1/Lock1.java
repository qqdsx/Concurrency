package 并发_死锁_1;

class Lock1 implements Runnable{
    @Override
    public void run(){
        try{
            System.out.println("Lock1 running");
//            while(true){
            synchronized(Test1.obj1){
                System.out.println("Lock1 lock obj1");
                Thread.sleep(3000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                synchronized(Test1.obj2){
                    System.out.println("Lock1 lock obj2");
                }
            }
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
