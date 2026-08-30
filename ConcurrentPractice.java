import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Future;

class MyTask implements Runnable {

    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(
            name + " is running on "
            + Thread.currentThread().getName()
        );
    }
}

class SumTask implements Callable<Integer> {

    @Override
    public Integer call() {

        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
        }

        return sum;
    }
}

public class ConcurrentPractice {

    public static void main(String[] args) {

        MyTask task = new MyTask("Task A");

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // executorService.execute(new MyTask("Task A"));
        // executorService.execute(new MyTask("Task B"));
        // executorService.execute(new MyTask("Task C"));

        SumTask sumTask = new SumTask();
        // FutureTask
        // FutureTask<Integer> futureTask = new FutureTask<>(sumTask);
        // executorService.execute(futureTask);

        // try {
        //     Integer result = futureTask.get();
        //     System.out.println("Result: " + result);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        // Future
        Future<Integer> future = executorService.submit(sumTask);
        try {
            Integer result = future.get();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        executorService.shutdown();
    }
}
