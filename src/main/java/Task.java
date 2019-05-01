/**这是个代表任务的抽象类，其中定义了一个deal()方法，继承Task抽象类的子类需要实现这个方法，
 * 并把这个任务需要完成的具体工作在deal()方法编码实现。线程池中的线程之所以被创建，就是为了执行各种各样数量繁多的任务的，
 * 为了方便线程对任务的处理，我们需要用Task抽象类来保证任务的具体工作统一放在deal()方法里来完成，这样也使代码更加规范
 */

public abstract class Task {
    public enum State{
        NEW,RUNNING,FINISHED
    }

    private State state = State.NEW;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public abstract void deal();
}
