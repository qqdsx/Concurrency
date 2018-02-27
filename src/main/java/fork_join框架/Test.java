package fork_join框架;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Test extends RecursiveTask<Integer>{

    private static final int THRESHOLD = 2; //阈值
    private int start;
    private int end;
    public Test(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end-start) <= THRESHOLD;
        if(canCompute){
            for (int i = start;i <= end; i++) {
                sum += i;
            }
        }
        else {
            //如果任务大于阈值,就分裂成两个子任务进行计算
            int middle = (end + start) / 2;
            Test left = new Test(start, middle);
            Test right = new Test(middle+1, end);
            //执行子任务
            left.fork();
            right.fork();
            //获取结果
            int leftResult = left.join();
            int rightResult = right.join();
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Test test = new Test(1,10);
        Future<Integer> result = forkJoinPool.submit(test);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
