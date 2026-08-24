import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyTask implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println("Task starts...");
        System.out.println("Working...");
        System.out.println("Task finished.");

        return 5050;
    }
}

public class Concurrent {
    public static void main(String args[]) {
        MyTask task = new MyTask();

        // Version 1: Thread
        // Thread t1 = new Thread(task);
        // t1.start();

        // Version 2: Executor (backed by a single-thread executor)
        // Executor executor = Executors.newSingleThreadExecutor();
        // executor.execute(task);
        // executor.shutdown();

        // Version 3: ExecutorService
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(task);
        try {
            Integer result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
