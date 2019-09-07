package interfaceUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.LineBorder;

public class Grid {
	private static  MouseMotionListener MouseEvent= null;
	public static JTextField txt1;
	public static JLabel lbl;
	public static void main(String[] args) {
	
		JFrame frame =new JFrame("grid");
		JPanel rightPanel = createVerticalBoxPanel();
	//	JPanel p1 = new JPanel(new GridLayout(4,7));
		JPanel dragP = new JPanel(new GridLayout(10,5));
		JPanel p3 = new JPanel();
		final Random prng = new Random();
		rightPanel.add(createPanelForComponent(dragP,"Subject"));	
	    final Color[] colors = new Color[]{Color.BLUE, Color.GREEN, Color.MAGENTA, Color.GRAY};

		int colmn=5;
	for (int row = 0; row < 5; ++row)
        for (int col = 0; col < 5; ++col) {

            //Create label for (row, col):
            txt1 = new JTextField();
            txt1.setHorizontalAlignment(JLabel.CENTER);
            txt1.setBounds(col * 50, row * 115, 50, 115); 
            txt1.setBorder(new LineBorder(colors[prng.nextInt(colors.length)], 2)); //Set a border for clarity.
            //txt1.setBackground(Color.CYAN);
           // txt1.setEditable(false);
            dragP.add(txt1);
        }
		 final int labelRows = 3,    //How many rows of labels.
                 labelColumns = 3, //How many columns of labels.
                 labelWidth = 55,  //Width for each label.
                 labelHeight = 20; //Height for each label.

       //Border colors for labels:
      // final Color[] colors = new Color[]{Color.BLUE, Color.GREEN, Color.BLACK, Color.GRAY};
        //For selecting border color for each label.
       final MouseAdapter ma = new MouseAdapter() {
       private JLabel selectedLabel = null; //Clicked label.
       private JTextField selectedTxt = null; //Clicked label.
       private Point selectedLabelLocation = null; //Location of label in panel when it was clicked.
       private Point panelClickPoint = null; //Panel's click point.
       private Point selectedTxtLocation = null; //Location of label in panel when it was clicked.
           //Selection of label occurs upon pressing on the panel:
           @Override
           public void mousePressed(final MouseEvent e) {
               //Find which label is at the press point:
               final Component pressedComp = dragP.findComponentAt(e.getX(), e.getY());
               //If a label is pressed, store it as selected:
               if (pressedComp != null && pressedComp instanceof JLabel) {
                   selectedLabel = (JLabel) pressedComp;
                  
                   selectedLabelLocation = selectedLabel.getLocation();
                   panelClickPoint = e.getPoint();
                   dragP.setComponentZOrder(selectedLabel, 0);
                   selectedLabel.repaint();
               }
               else {
                   selectedLabel = null;
                   selectedLabelLocation = null;
                   panelClickPoint = null;
               }
           }
           //Moving of selected label occurs upon dragging in the panel:
           @Override
           public void mouseDragged(final MouseEvent e) {
               if (selectedLabel != null
                       && selectedLabelLocation != null
                       && panelClickPoint != null) {
                   final Point newPanelClickPoint = e.getPoint();
                   final int newX = selectedLabelLocation.x + (newPanelClickPoint.x - panelClickPoint.x),
                             newY = selectedLabelLocation.y + (newPanelClickPoint.y - panelClickPoint.y);
                   selectedLabel.setLocation(newX, newY);
                   txt1.setLocation(newX, newY);
               }
           }
       	@Override
       	public void mouseReleased(final MouseEvent e) {
       		//txt1.setText(selectedLabel.getText());   
       		txt1.setVisible(true);
       		//txt1.setVisible(false);
       		//txt1.setHorizontalAlignment(labelWidth);
       	}   
       };
       dragP.addMouseMotionListener(ma); //For mouseDragged().
       dragP.addMouseListener(ma); //For mousePressed().
       //Filling the panel with labels:
       for (int row = 0; row < 5; ++row)
           for (int col = 0; col < labelColumns; ++col) {
        	   String digit = Character.toString((char)(row * labelColumns + col+65));       	  
               lbl = new JLabel("CS17" + String.valueOf(digit));
               lbl.setHorizontalAlignment(JLabel.CENTER);
               lbl.setVerticalAlignment(JLabel.CENTER);
              //lbl.setBorder(new LineBorder(colors[prng.nextInt(colors.length)], 2)); //Set a border for clarity.

               lbl.setBounds(col * labelWidth, row * labelHeight, labelWidth, labelHeight); //Grid-like positioning.
              // //Add label to panel:
               dragP.add(lbl);
           }
       //Creating and showing the main frame:
       //final JFrame frame = new JFrame(LabelDragger.class.getSimpleName());
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //The size of the content pane adds some extra room for moving the labels:
       final Dimension paneSize = new Dimension((int)(1.5 * labelWidth * labelColumns),
                                                (int)(1.5 * labelHeight * labelRows));
      frame.getContentPane().setPreferredSize(paneSize);
      frame.getContentPane().add(rightPanel);
		frame.getContentPane().add(rightPanel);
		frame.pack();
		frame.setVisible(true);
		frame.pack();
        frame.setLocationRelativeTo(null);
	}
	public static JPanel createVerticalBoxPanel() {
	        JPanel p = new JPanel();
	        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
	        p.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	        return p;
	    }
	public static JPanel createPanelForComponent(JComponent comp, String title) {
			JPanel panel = new JPanel(new BorderLayout());
			panel.add(comp, BorderLayout.CENTER);
			if (title != null) {
			panel.setBorder(BorderFactory.createTitledBorder(title));
			}
			return panel;
			}	
}