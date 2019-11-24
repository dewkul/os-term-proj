import java.util.ArrayList;
class Process{
    int processID;
    int burstTime;
    int remainBurstTime;
    int waitingTime;
    int turnAroundTime;

    public Process(int processID, int burstTime, int remainBurstTime, int waitingTime, int turnAroundTime) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainBurstTime = remainBurstTime;
        this.waitingTime = waitingTime;
        this.turnAroundTime = turnAroundTime;
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
    
    
}
public class CPUScheduler 
{ 
    ArrayList<Process> readyQueue = new ArrayList<Process>();
    int timeQuantum;
    int currentTime = 0;
    int totalTime = 0;

    public CPUScheduler(ArrayList<Process> readyQueue, int timeQuantum) {
        this.readyQueue = readyQueue;
        this.timeQuantum = timeQuantum;

        for(int i = 0; i < readyQueue.size();i++){
            this.totalTime += readyQueue.get(i).burstTime;
        }
    }
    
    


} 