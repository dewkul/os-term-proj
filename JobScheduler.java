import java.util.ArrayList;

public class JobScheduler implements Runnable {
    ArrayList<Job> jobQueue;
    ReadyQueue readyQueue;

    public JobScheduler(ArrayList<Job> jQueue, ReadyQueue rQueue){
        this.jobQueue = jQueue;
        this.readyQueue = rQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                addReady(removeJob());
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    private Job removeJob() throws InterruptedException {
        synchronized (jobQueue) {
            while (jobQueue.isEmpty()){
                // System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting , size: " + jobQueue.size());
                jobQueue.wait();
            }
            // Thread.sleep(500);
            Job j = jobQueue.remove(0);
            // System.out.println("Sched: remove " + j.getProcessID());
        
            jobQueue.notifyAll();
            return j;
        }
        

    }

    private void addReady(Job j) throws InterruptedException {
        synchronized (readyQueue) {
            // Thread.sleep(500);
            readyQueue.add(j);
            System.out.println("Thread " + j.getProcessID() + " is moved to the ready queue");
            // if (jobQueue.isEmpty())
                // System.out.println("!!!!! Notify CPU");
            readyQueue.notifyAll();
        }
    }

}