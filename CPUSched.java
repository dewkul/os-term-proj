import java.util.ArrayList;

public class CPUSched { 
    ArrayList<Process> readyQueue = new ArrayList<Process>();
    int timeQuantum;
    int currentTime = 0;
    int totalTime = 0;
    int currentTimeSlot = 0;
    int pIndex = 0;

    public CPUSched(ArrayList<Process> readyQueue, int timeQuantum) {
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