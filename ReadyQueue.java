import java.util.ArrayList;
    
public class ReadyQueue extends ArrayList<Job> {

    public ReadyQueue() {
        super();
    }
    @Override
    public boolean add(Job e) {
        int i;

        if(super.size() == 0 || super.get(0).getArrivalTime() >= e.getArrivalTime()){
            super.add(0 ,e);
        }
        else if(super.get(super.size() - 1).getArrivalTime() <= e.getArrivalTime()){
            super.add(super.size(), e);
        }
		else{
            for(i = 0; i < super.size() -1 ; i++){
                if(super.get(i).getArrivalTime() < e.getArrivalTime() && e.getArrivalTime() <= super.get(i+1).getArrivalTime()){
                    super.add(i+1,e);
                    break;
                }
            }
        }
        return true;
    }
    
}