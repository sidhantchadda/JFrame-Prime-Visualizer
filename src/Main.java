import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Runnable r = new Runnable() {
            public void run() {
                // the GUI as seen by the user (without frame)
                // A single component added to a GBL with no constraint
                // will be centered.
            	int height =100;
            	int width = 100;
                JPanel gui = new JPanel(new GridLayout(height, width));

                //gui.setBackground(Color.WHITE);

                SquarePanel p = new SquarePanel();
                p.setBackground(Color.RED);

                for(int x = 0; x<height*width; x++)	{
                	SquarePanel sp = new SquarePanel();
                	sp.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                	if(isPrime(x))	{
                		sp.setBackground(Color.BLUE);
                	}
                	else	{
                		sp.setBackground(Color.DARK_GRAY);
                	}
                	gui.add(sp);
                }
               // gui.add(p);

                JFrame f = new JFrame("Demo");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                f.setSize(1000,1000);
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(r);
    }

	private static boolean isPrime(int x) {
		if(x <= 1)	{
			return false;
		}
		if(x <= 3)	{
			return true;
		}
		for(int i = 2; i<=Math.sqrt(x);i++){
			if(x % i == 0)	{
				return false;
			}
		}
		return true;
	}

}
