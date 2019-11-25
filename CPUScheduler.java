import java.util.ArrayList;

public class CPUScheduler implements Runnable {
    int timeQuantum;
    int currentTime = 0;
    int currentTimeSlot = 0;
    int pIndex = 0;

    int nProcess;
    int totalBurstTime = 0;
    int totalWaitingTime = 0;
    int totalTurnaround = 0;
    static ReadyQueue readyQueue;

    public CPUScheduler(final ReadyQueue readyQueue,final int timeQuantum) {
        this.readyQueue = readyQueue;
        this.timeQuantum = timeQuantum;
    }
    @Override
    public void run() {
        this.nProcess = readyQueue.size();
        for (final Job x : this.readyQueue) {
            this.totalBurstTime += x.getBurstTime();
        }
        //System.out.println(readyQueue.toString());
        while (!readyQueue.isEmpty()) {

            System.out.println("Current Time: " + this.currentTime + " CPU is running processID:"
                    + this.readyQueue.get(pIndex).getProcessID());
            // reduce remain burst time of the process by 1 and add time
            readyQueue.get(pIndex).setRemainBurstTime(readyQueue.get(pIndex).getRemainBurstTime() - 1);

            currentTime++;
            currentTimeSlot++;

            // the process is completed
            if (this.readyQueue.get(pIndex).getRemainBurstTime() == 0) {
                this.currentTimeSlot = 0;

                this.readyQueue.get(pIndex).setTurnAroundTime(currentTime- readyQueue.get(pIndex).getArrivalTime());
                this.readyQueue.get(pIndex).setWaitingTime(
                        readyQueue.get(pIndex).getTurnAroundTime() - readyQueue.get(pIndex).getBurstTime());
                System.out.println(readyQueue.get(pIndex).toString());

                totalWaitingTime += readyQueue.get(pIndex).getTurnAroundTime() - readyQueue.get(pIndex).getBurstTime();
                totalTurnaround += currentTime;

                this.readyQueue.remove(pIndex);

                if (this.readyQueue.size() == 1) {
                    this.pIndex = 0;
                }
            }
            // exceed limit of time quantum
            if (this.currentTimeSlot >= this.timeQuantum) {
                this.currentTimeSlot = 0;

                //finding the next process to run that aready arrived
                for(int i = 0; i< this.readyQueue.size(); i++){
                    pIndex = (pIndex + 1) % this.readyQueue.size();

                    if(readyQueue.get(pIndex).getArrivalTime() <= currentTime){
                        break;
                    }
                }

                //there is no process already arrived add current time until any process arrived

                if(readyQueue.get(pIndex).getArrivalTime() > currentTime){
                    //find the most almost arrive process
                    pIndex = 0;
                    for(int i = 0; i< this.readyQueue.size(); i++){
                        if(readyQueue.get(i).getArrivalTime() <= readyQueue.get(pIndex).getArrivalTime()){
                            pIndex = i;
                        }
                    }
                    while( readyQueue.get(pIndex).getArrivalTime() > currentTime){
                        currentTime++;
                    }
                }
            }
        }

        System.out.println("Average waiting time = " + (float) totalWaitingTime / (float) nProcess);
        System.out.println("Average turn around time = " + (float) totalTurnaround / (float) nProcess);
        System.out.println("Total burst time = " + totalBurstTime);
    }
}






// import java.util.ArrayList;

// public class CPUScheduler implements Runnable {
//     int timeQuantum;
//     int currentTime = 0;
//     int currentTimeSlot = 0;
//     int pIndex = 0;

//     int nProcess;
//     int totalBurstTime = 0;
//     int totalWaitingTime = 0;
//     int totalTurnaround = 0;
//     static ArrayList<Job> readyQueue;
//     // static ReadyQueue readyQueue;

//     public CPUScheduler(int timeQuantum) {
//         CPUScheduler.readyQueue = new ArrayList<Job>();
//         this.timeQuantum = timeQuantum;
//     }
//     @Override
//     public void run() {
//         this.nProcess = readyQueue.size();
//         for (final Job x : this.readyQueue) {
//             this.totalBurstTime += x.getBurstTime();
//         }

//         while (!readyQueue.isEmpty()) {
//             System.out.println("Current Time: " + this.currentTime + " CPU is running processID:"
//                     + this.readyQueue.get(pIndex).getProcessID());
//             // reduce remain burst time of the process by 1 and add time
//             readyQueue.get(pIndex).setRemainBurstTime(readyQueue.get(pIndex).getRemainBurstTime() - 1);

//             currentTime++;
//             currentTimeSlot++;

//             // the process is completed
//             if (this.readyQueue.get(pIndex).getRemainBurstTime() == 0) {
//                 this.currentTimeSlot = 0;
//                 // pIndex = (pIndex + 1) % this.readyQueue.size();

//                 this.readyQueue.get(pIndex).setTurnAroundTime(currentTime- readyQueue.get(pIndex).getArrivalTime());
//                 this.readyQueue.get(pIndex).setWaitingTime(
//                         readyQueue.get(pIndex).getTurnAroundTime() - readyQueue.get(pIndex).getBurstTime());
//                 System.out.println(readyQueue.get(pIndex).toString());

//                 totalWaitingTime += readyQueue.get(pIndex).getTurnAroundTime() - readyQueue.get(pIndex).getBurstTime();
//                 totalTurnaround += currentTime;

//                 this.readyQueue.remove(pIndex);

//                 if (this.readyQueue.size() == 1) {
//                     this.pIndex = 0;
//                 }
//             }
//             // exceed limit of time quantum
//             if (this.currentTimeSlot >= this.timeQuantum) {
//                 this.currentTimeSlot = 0;
//                 pIndex = (pIndex + 1) % this.readyQueue.size();
//             }
//         }

//         System.out.println("Average waiting time = " + (float) totalWaitingTime / (float) nProcess);
//         System.out.println("Average turn around time = " + (float) totalTurnaround / (float) nProcess);
//         System.out.println("Total burst time = " + totalBurstTime);
//     }
// }