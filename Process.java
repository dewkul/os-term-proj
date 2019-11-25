public class Process {
    protected int processID;
    protected int burstTime;
    protected int remainBurstTime;
    protected int waitingTime;
    protected int turnAroundTime;

    public Process(final int processID, final int burstTime) {
        this.processID = processID;
        this.burstTime = burstTime;

        this.remainBurstTime = burstTime;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(final int processID) {
        this.processID = processID;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(final int burstTime) {
        this.burstTime = burstTime;
    }

    public int getRemainBurstTime() {
        return remainBurstTime;
    }

    public void setRemainBurstTime(final int remainBurstTime) {
        this.remainBurstTime = remainBurstTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(final int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(final int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    @Override
    public String toString() {
        return "Process [burstTime=" + burstTime + ", processID=" + processID + ", remainBurstTime=" + remainBurstTime
                + ", turnAroundTime=" + turnAroundTime + ", waitingTime=" + waitingTime + "]";
    }

    
}