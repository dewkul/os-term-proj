import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Creator implements Runnable {
    // AtomicInteger i;
    ArrayList<Job> jobQueue;

    Creator(ArrayList<Job> jQueue, AtomicInteger){
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
        System.out.println("Exit...");
    }
}