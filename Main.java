import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Queue;


public class Main{
    public static void main(String[] args) {
        
        List<Integer> proc_id =  new ArrayList<Integer>();
        List<Integer> exec_time =  new ArrayList<Integer>();

        ArrayList<Job> jobQueue = new ArrayList<Job>();
        ReadyQueue readyQueue = new ReadyQueue();
        Queue<Job> queue = new LinkedList<Job>();
         
        // TO DO: Add Job Here!!
        // queue.add(new Job(0, 0, 3));   
        // queue.add(new Job(1, 5, 8));
        // queue.add(new Job(2, 0, 4));
       
        queue.add(new Job(0, 0, 15));   //id, arrival time, brust time
        queue.add(new Job(1, 1, 9));
        queue.add(new Job(2, 10, 4));

        // TO DO: Set time quantum Here!!
        int timeQuantum = 2;
        
        Thread creator = new Thread(new Creator(queue, jobQueue));
        Thread jobSched = new Thread(new JobScheduler(jobQueue, readyQueue));
        Thread cpuSched = new Thread(new CPUScheduler(readyQueue, timeQuantum, proc_id, exec_time));
        creator.start();
        jobSched.start();
        cpuSched.start();

     }
}