import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Main{
    // Job Queue will be in JobSched
    private static final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(15);
    public static void main(String[] args) {
        // Thread t = new Thread(() -> {
        //     while (true) {
        //         try {
        //             queue.take().run();
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
    
        //     }
        // });
        // t.start();
        // queue.add(() -> {
        //     Job j1 = new Job(1, 0, 8);  // processId, arrivalTime, cpuTime(burst)
        // });
        // queue.add(() -> {
        //     Job j2 = new Job(2, 0, 10);
        // });
        // queue.add(() -> {
        //     Job j3 = new Job(3, 4, 8);
        // });

        ArrayList<Job> jobQueue = new ArrayList<Job>();
        ReadyQueue readyQueue = new ReadyQueue();
        // AtomicInteger time = new AtomicInteger();
        
        Runnable c = new Creator(jobQueue);
        Thread creator = new Thread(c);
        creator.start();

        try {
            System.out.println("Waiting for threads to finish.");
            creator.join();
          } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
          }


        GanttChart g = new GanttChart();

        // Required data for Gantt Chart
        List<Integer> proc_id =     Arrays.asList(0, 1, 2, 0, 1, 2, 1, 2, 2);
        List<Integer> exec_time =   Arrays.asList(3, 3, 3, 2, 3, 3, 1, 3, 1);
        g.addAllProc(proc_id, exec_time);
        g.display();
     }
}