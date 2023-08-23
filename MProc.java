
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MProc {
    public static void main(String[] args) {
        int numProcesses = 8;

        List<Process> processes = new ArrayList<>();

        for (int i = 0; i < numProcesses; i++) {
            try {
                // Define the command to be executed as a separate process
                String[] command = {"java", "Worker", Integer.toString(i)};

                // Create a process builder for the command
                ProcessBuilder processBuilder = new ProcessBuilder(command);

                // Start the process
                Process process = processBuilder.start();
                processes.add(process);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Wait for all processes to complete (optional)
        for (Process process : processes) {
            try {
                int exitCode = process.waitFor();
                System.out.println("Process exited with code " + exitCode);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
