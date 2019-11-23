import java.util.List;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        GanttChart g = new GanttChart();

        
        List<Integer> proc_id = Arrays.asList(0, 1, 2, 0, 1, 2);
        List<Integer> exec_time = Arrays.asList(3, 3, 3, 2, 3, 1);
        g.addAllProc(proc_id, exec_time);
        g.display();
     }
}