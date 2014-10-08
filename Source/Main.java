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
	private static int height =100;
	private static int width = 100;

	public static void main(String[] args) {
		// fixes bugs in JDK.
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		
        Runnable r = new Runnable() {
            public void run() {
                JPanel gui = new JPanel(new GridLayout(height, width));
                
                // iterates through all the numbers in the grid and checks if prime
                // if a number is prime its associated square becomes Blue.
                // if a number is not prime its square becomes Dark Gray.
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

                JFrame f = new JFrame("Grid");
                // exits program when the window is closed.
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(gui);
                // sets the location of the frame in the middle of the screen.
                f.setLocationRelativeTo(null);
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
        SwingUtilities.invokeLater(r);
    }

	// Detects if x is Prime.
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
