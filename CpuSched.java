import java.util.ArrayList;
class Process{
    int processID;
    int burstTime;
    int remainBurstTime;
    int waitingTime;
    int turnAroundTime;

    public Process(int processID, int burstTime) {
        this.processID = processID;
        this.burstTime = burstTime;

        this.remainBurstTime = burstTime;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getRemainBurstTime() {
        return remainBurstTime;
    }

    public void setRemainBurstTime(int remainBurstTime) {
        this.remainBurstTime = remainBurstTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    @Override
    public String toString() {
        return "Process [burstTime=" + burstTime + ", processID=" + processID + ", turnAroundTime=" + turnAroundTime
                + ", waitingTime=" + waitingTime + "]";
    }

    
    
    
}
public class CPUScheduler 
{ 
    ArrayList<Process> readyQueue = new ArrayList<Process>();
    int timeQuantum;
    int currentTime = 0;
    int totalTime = 0;
    int currentTimeSlot = 0;
    int pIndex = 0;

    public CPUScheduler(ArrayList<Process> readyQueue, int timeQuantum) {
        this.readyQueue = readyQueue;
        this.timeQuantum = timeQuantum;

        for(int i = 0; i < readyQueue.size();i++){
            this.totalTime += readyQueue.get(i).burstTime;
        }

        while(!readyQueue.isEmpty()){
            this.readyQueue.get(pIndex).setRemainBurstTime(this.readyQueue.get(pIndex).getRemainBurstTime()-1);
            System.out.println("Current Time: "+ this.currentTime + " CPU is running processID:" + this.readyQueue.get(pIndex).getProcessID());
            if(this.readyQueue.get(pIndex).getRemainBurstTime()==0){
                this.currentTimeSlot = 0;
                this.readyQueue.get(pIndex).setTurnAroundTime(this.currentTime);
                this.readyQueue.get(pIndex).setWaitingTime(this.readyQueue.get(pIndex).getTurnAroundTime()-this.readyQueue.get(pIndex).getBurstTime());
                System.out.println(this.readyQueue.get(pIndex).toString());
            }
            this.currentTimeSlot++;
            if(this.currentTimeSlot >= this.timeQuantum){
                this.currentTimeSlot = 0;
                pIndex = (pIndex+1)%this.readyQueue.size();
            }

            this.currentTime++;
        }
    }
    

    


} 