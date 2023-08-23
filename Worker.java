
import java.util.ArrayList;
import java.util.List;

public class Worker {
	public static void main(String[] args) {
		int processNumber = Integer.parseInt(args[0]);
		System.out.println("Worker " + processNumber + " is running.");
		// Perform the desired task for this subprocess
		cpuHeavy();
	}

	// actual task - CPU heavy
	public static void cpuHeavy() {
		long count = 0;
		for (int i = 0; i < 1_00_00_000; i++) {
			count += i;
		}
	}
}
