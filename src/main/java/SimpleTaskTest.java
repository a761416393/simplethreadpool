public class SimpleTaskTest extends Task {

    public void deal() {
        System.out.println("任务:"+Thread.currentThread().getName());
    }

    public static void main(String []args) throws InterruptedException {
        ThreadPoolService service = new ThreadPoolService();
        service.start();
        for (int i=0;i<10;i++){
            service.runTask(new SimpleTaskTest());
        }
        Thread.sleep(1000);
        service.stop();
    }

}
