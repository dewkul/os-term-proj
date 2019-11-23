import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class GanttChart extends JPanel {
   private static final int RECT_X = 20;
   private static final int RECT_Y = RECT_X;
   private static final int RECT_WIDTH = 50;
   private static final int RECT_HEIGHT = RECT_WIDTH;

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      // draw the rectangle here
      g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
      g.drawString("0", RECT_X, RECT_Y + RECT_HEIGHT + 15);
      g.drawRect(RECT_X + RECT_WIDTH, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
      g.drawString("4", RECT_X + RECT_WIDTH, RECT_Y + RECT_HEIGHT + 15);
   }

   @Override
   public Dimension getPreferredSize() {
      // so that our GUI is big enough
      return new Dimension(RECT_WIDTH + 2 * RECT_X, RECT_HEIGHT + 2 * RECT_Y);
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