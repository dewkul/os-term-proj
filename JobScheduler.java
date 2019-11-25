import java.util.ArrayList;

public class JobScheduler {
    static ArrayList<Job> jobQueue
    ReadyQueue readyQueue;

    public JobScheduler(ArrayList<Job> jQueue, ReadyQueue rQueue){
        this.jobQueue = jQueue;
        this.readyQueue = rQueue;

        while(true) {
            if(!jobQueue.isEmpty()){
                System.out.println("Thread " + this.jobQueue.get(0).getProcessID() + " is put to the job queue");
                this.readyQueue.add(new Job( this.jobQueue.get(0).getProcessID(), this.jobQueue.get(0).getArrivalTime(), this.jobQueue.get(0).getBurstTime()));
                this.jobQueue.remove(0);
            }
        }
    }
}