import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SquarePanel extends JPanel{
	// defining of a square in JPanel
	@Override
    public Dimension getPreferredSize() {
        Dimension d = super.getPreferredSize();
        Container c = getParent();
        if (c != null) {
            d = c.getSize();
        } else {
            return new Dimension(1, 1);
        }
        int w = (int) d.getWidth();
        int h = (int) d.getHeight();
        int s = (w < h ? w : h);
        return new Dimension(s, s);
    }
}
