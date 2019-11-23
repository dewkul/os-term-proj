import java.util.concurrent.*;
public class Main{
    private static final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(15);
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    queue.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
            }
        });
        t.start();
        queue.add(() -> {
            Job j1 = new Job();
        });
        queue.add(() -> {
            Job j2 = new Job();
        });
        queue.add(() -> {
            Job j3 = new Job();
        });


        GanttChart g = new GanttChart();
        g.display();
     }
}