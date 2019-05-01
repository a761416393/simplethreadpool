/**它继承自Thread类，专门用于执行任务队列中的待执行任务。
 * */

public class TaskThread extends Thread {
    private ThreadPoolService service;

    public TaskThread(ThreadPoolService tps){
        this.service=tps;
    }
    public void run() {
        //在线程池运行的情况下执行任务
        while (service.isRunning()){
            //获取任务队列
            TaskQueue queue = service.getTaskQueue();
            Task task = queue.getTask();
            if(task!=null){
                task.deal();
            }
            queue.finishTask(task);
        }
    }

}
