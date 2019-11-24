import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.util.List;
import java.util.ArrayList;

public class GanttChart extends JPanel {
   private static int X = 20;
   public static int MARGIN_X = 20;
   private static List<ProcBox> proc = new ArrayList<>();
   
   public void addAllProc(List<Integer> id, List<Integer> sec) {
      if (id.size() != sec.size()){
         System.out.println("Error: len(proc_id) != len(exec_time)");
         return;
      }
      for (int i=0; i < id.size(); i++){
         proc.add(new ProcBox(id.get(i), sec.get(i), X));
         X = X + ProcBox.SEC_WIDTH * sec.get(i);
         // System.out.println("GanttChart: X = " + X);
      }
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawString("0", MARGIN_X, ProcBox.LABEL_Y);

      for (ProcBox p: proc){
         p.draw(g);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      // so that our GUI is big enough
      return new Dimension(X + MARGIN_X, ProcBox.RECT_HEIGHT + 2 * ProcBox.START_Y);
   }

   // create the GUI explicitly on the Swing event thread
   private static void createAndShowGui() {
      GanttChart mainPanel = new GanttChart();
      JFrame frame = new JFrame("Gantt Chart");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public void display() {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

class ProcBox {
   private int id, sec, START_X, END_X, LABEL_X;
   public static int SEC_WIDTH = 30;
   public static int RECT_HEIGHT = 50;
   public static int START_Y = 20;
   public static int LABEL_Y = START_Y + RECT_HEIGHT + 15;

   public ProcBox(int proc_id, int sec, int x){
      this.id = proc_id;
      this.sec = sec;
      this.START_X = x;
      this.END_X = START_X + sec * SEC_WIDTH;
      this.LABEL_X = this.END_X - 5;
   }

   public void draw(Graphics g){
      g.drawRect(START_X, START_Y, SEC_WIDTH * sec, RECT_HEIGHT);
      // System.out.println("ProcBox: x = " + START_X + " " + END_X);
      g.drawString(Integer.toString(id), (START_X + END_X)/2, LABEL_Y - (RECT_HEIGHT*2/3));
      g.drawString(Integer.toString((END_X - GanttChart.MARGIN_X)/SEC_WIDTH), LABEL_X, LABEL_Y);
   }
}