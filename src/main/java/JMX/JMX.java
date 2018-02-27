package JMX;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**JMX的全称为Java Management Extensions.
 顾名思义，是管理Java的一种扩展。
 这种机制可以方便的管理、监控正在运行中的Java程序。
 常用于管理线程，内存，日志Level，服务重启，系统环境等。*/

public class JMX {
    public static void main(String[] args) {

        //获取java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取monitor和synchronizer信息,仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //遍历线程信息,仅打印线程ID和线程名称信息
        for (ThreadInfo t :
                threadInfos) {
            //注意debug和run启动,线程数量不一样.debug的线程数要比run多.
            System.out.println(t.getThreadId()+t.getThreadName());
        }
    }
}
