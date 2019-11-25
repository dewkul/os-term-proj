import java.util.ArrayList;

public class JobScheduler {
    public static ArrayList<Job> jobQueue;

    public JobScheduler(ArrayList<Job> queue){
        this.jobQueue = queue;

        while(true) {
            if(!jobQueue.isEmpty()){
                System.out.println("Thread " + jobQueue.get(0).getProcessID() + " is put to the job queue");
                CPUScheduler.readyQueue.add(new Job( jobQueue.get(0).getProcessID(), jobQueue.get(0).getArrivalTime(), jobQueue.get(0).getBurstTime() ));
                jobQueue.remove(0);
            }
        }
    }
}