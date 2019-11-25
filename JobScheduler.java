import java.util.ArrayList;

public class JobScheduler implements Runnable{
    public static ArrayList<Job> jobQueue;

    public JobScheduler(final ArrayList<Job> queue) {
        
        for(int i = 0; i < queue.size(); i++) {
            jobQueue.add(queue.get(i));
            System.out.println("Thread " + queue.get(i).getProcessID() + " is put to the job queue");
        }

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