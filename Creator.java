import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Creator implements Runnable {
    // AtomicInteger i;
    ArrayList<Job> jobQueue;

    Creator(ArrayList<Job> jQueue, final ArrayList<Job> queue){
        this.jobQueue = jQueue;
    }

    // Creator(AtomicInteger i){
    //     this.i = i;
    // }

    @Override
    public void run(){
        System.out.println("Running...");
        // while(i.intValue() < 10){
        //     System.out.print(" " + i);
        //     i.incrementAndGet();
        // }

        // for(int i = 0; i < queue.size(); i++) {
        //     jobQueue.add(queue.get(i));
        //     System.out.println("Thread " + queue.get(i).getProcessID() + " is put to the job queue");
        // }
        System.out.println("Exit...");
    }
}