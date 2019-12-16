import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class Creator implements Runnable {
    // AtomicInteger i;
    private final int MAX_CAP = 1;
    ArrayList<Job> jobQueue;
    Queue queue;

    Creator(final Queue q, ArrayList<Job> jQueue){
        this.jobQueue = jQueue;
        this.queue = q;
    }

    // Creator(AtomicInteger i){
    //     this.i = i;
    // }

    @Override
    public void run(){
        // System.out.println("Creator: Running...");
        try{
            Iterator<Job> itr = queue.iterator();
            while (itr.hasNext())
                addJob(itr.next());
            

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        // System.out.println("Creator: Exit...");
    }

    private void addJob(Job j) throws InterruptedException {
        synchronized (jobQueue){
            while (jobQueue.size() == MAX_CAP){
                // System.out.println("Job Queue is FULL " + Thread.currentThread().getName() + " is waiting , size: " + jobQueue.size());
                jobQueue.wait();
            }

            Thread.sleep(500);
            jobQueue.add(j);
            System.out.println("Thread " + j.getProcessID() + " is put to the job queue");
            jobQueue.notifyAll();
        }
    }
}