import java.util.*;
import java.util.concurrent.*;

public class CallableTest implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println("some thing");
        return null;
    }

    public static void main(String[] args) {

        FutureTask<Object> task = new FutureTask<Object>(new CallableTest());
Executors.newCachedThreadPool();
        Thread thread = new Thread(task);

        thread.start();

        try {
            task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
