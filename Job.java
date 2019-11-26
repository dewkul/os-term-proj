public class Job {
    private int processID, burstTime, remainBurstTime, waitingTime, turnAroundTime, arrivalTime;
    private boolean statusDone;
    public Job(int processID, int arrival, int burstTime) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.arrivalTime = arrival;
        this.remainBurstTime = burstTime;
        this.statusDone = false; //false : working, true : Done
    }

    public void setStatusTrue(){ this.statusDone = true;}
    public void setStatusFalse(){ this.statusDone = false;}
    public boolean getStatusDone(){ return this.statusDone; }

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
        return "Process [processID=" + processID + ", burstTime=" + burstTime + ", arrivalTime=" + arrivalTime + ", turnAroundTime=" + turnAroundTime
                + ", waitingTime=" + waitingTime + "]";
    }    
}


