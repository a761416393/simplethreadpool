import java.util.ArrayList;
import java.util.List;

/**这是线程池最核心的一个类。它在被创建了时候就创建了几个线程对象，但是这些线程并没有启动运行，但调用了start()方法启动线程池服务时，
 * 它们才真正运行。stop()方法可以停止线程池服务，同时停止池中所有线程的运行。
 * 而runTask(Task task)方法是将一个新的待执行任务交与线程池来运行。
 * */

public class ThreadPoolService {
    //线程数
    public static final int THREAD_COUNT=5;

    public enum Status {
        /* 新建 */NEW, /* 提供服务中 */RUNNING, /* 停止服务 */TERMINATED,
    }

    //线程池状态
    private Status status = Status.NEW;
    //线程队列
    private TaskQueue queue = new TaskQueue();
    //线程队列
    private List<Thread> threads = new ArrayList<Thread>();

    //构造函数初始化
    public ThreadPoolService(){
        for(int i=0;i<THREAD_COUNT;i++){
            Thread t = new TaskThread(this);
            threads.add(t);
        }
    }

    //启动服务
    public void start(){
        this.status=Status.RUNNING;
        for(int i=0;i<THREAD_COUNT;i++){
            threads.get(i).start();
        }

    }

    //停止服务
    public void stop(){
        this.status=Status.TERMINATED;
    }
    //执行任务
    public void runTask(Task task){
        this.queue.addTask(task);
    }

    public boolean isRunning(){
        return status==Status.RUNNING;
    }

    public TaskQueue getTaskQueue(){
        return queue;
    }

}
