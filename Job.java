public class Job {
    private int processID, burstTime, remainBurstTime, waitingTime, turnAroundTime, arrivalTime;

    public Job(int processID, int arrival, int burstTime) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.arrivalTime = arrival;
        this.remainBurstTime = burstTime;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public int getArrivalTime() {
        return arrivalTime;
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


