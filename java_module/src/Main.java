import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task1 = new FutureTask<Integer>(new MyCallable());
        FutureTask<Integer> task2 = new FutureTask<Integer>(new MyCallable());
        FutureTask<Integer> task3 = new FutureTask<Integer>(new MyCallable());

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();

        Integer integer1 = task1.get();
        Integer integer2 = task2.get();
        Integer integer3 = task3.get();

        System.out.println(integer1);
        System.out.println(integer2);
        System.out.println(integer3);

        System.out.println(integer1 + integer2 + integer3);
    }

}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random r = new Random();
        return r.nextInt(100);
    }
}