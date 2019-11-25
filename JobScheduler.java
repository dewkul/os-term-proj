import java.util.ArrayList;

public class JobScheduler {
    ArrayList<Job> jobQueue
    ReadyQueue readyQueue;

    public JobScheduler(ArrayList<Job> jQueue, ReadyQueue rQueue){
        this.jobQueue = jQueue;
        this.readyQueue = rQueue;
    }

    @Override
    public void run() {
        while(true) {
            if(!jobQueue.isEmpty()){
                System.out.println("Thread " + jobQueue.get(0).getProcessID() + " is moved to the ready queue");
                CPUScheduler.readyQueue.add(new Job( jobQueue.get(0).getProcessID(), jobQueue.get(0).getArrivalTime(), jobQueue.get(0).getBurstTime() ));
                jobQueue.remove(0);
            }
        }
    }

}