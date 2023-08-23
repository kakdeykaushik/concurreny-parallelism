import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ThreadMain {
    public static void main(String[] args) throws Exception {
        int numThreads = 8;
        ExecutorService threadPool = Executors.newFixedThreadPool(numThreads);

        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            int taskId = i;
            Callable<Void> task = () -> {
                cpuHeavy(taskId);
                return null;
            };
            tasks.add(task);
        }

        List<Future<Void>> results = threadPool.invokeAll(tasks);

        // Optionally, you can wait for all tasks to complete.
        for (Future<Void> result : results) {
            result.get();
        }

        threadPool.shutdown();
    }

    // actual task
    public static void cpuHeavy(int x) {
        System.out.println("I am " + x);
        long count = 0;
        for (int i = 0; i < 1_00_00_000; i++) {
            count += i;
        }
    }
}
