package dnd;
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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ObjectInputStream.GetField;
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
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;
import javax.swing.table.DefaultTableModel;

public class Grid implements MouseMotionListener, MouseListener{
	private static  MouseMotionListener MouseEvent= null;
	public static JTextField txt1;
	public static JLabel lbl;
	public static JTable table;
	public Grid(Component... pns )
	{
		for(Component panel: pns)
		{
			panel.addMouseListener(this);
			panel.addMouseMotionListener(this);
			}
		
	}

	public static void main(String[] args) {
		//Grid g = new Grid(getC);
		Grid gr= new Grid(getComponents());
		
		JFrame frame =new JFrame("grid");
		JPanel rightPanel = createVerticalBoxPanel();
	//	JPanel p1 = new JPanel(new GridLayout(4,7));
		JPanel dragP = new JPanel();
		JPanel p3 = new JPanel();
		final Random prng = new Random();
		rightPanel.add(createPanelForComponent(dragP,"Subject"));	
	    final Color[] colors = new Color[]{Color.BLUE, Color.GREEN, Color.MAGENTA, Color.GRAY};
	    
//		int colmn=5;
//	for (int row = 0; row < 5; ++row)
//        for (int col = 0; col < 5; ++col) {
//
//            //Create label for (row, col):
//            txt1 = new JTextField();
//            txt1.setHorizontalAlignment(JLabel.CENTER);
//            txt1.setBounds(col * 50, row * 115, 50, 115); 
//            txt1.setBorder(new LineBorder(colors[prng.nextInt(colors.length)], 2)); //Set a border for clarity.
//            //txt1.setBackground(Color.CYAN);
//           // txt1.setEditable(false);
//            dragP.add(txt1);
//        }
	    table = new JTable(new DefaultTableModel(
	        	new Object[][] {
	        		{null, null, null, null, null, null, null, null},
	        		{null, null, null, null, null, null, null, null},
	        		{null, null, null, null, null, null, null, null},
	        		{null, null, null, null, null, null, null, null},
	        		{null, null, null, null, null, null, null, null},
	        		{null, null, null, null, null, null, null, null},
	        		{null, null, null, null, null, null, null, null},
	        		{null, null, null, null, null, null, null, null},
	        	},
	        	new String[] {
						"ROOM","8:00-9:30", "9:30-11:00", "11:00-12:30", "12:30-1:45", "1:45-2;05", "2:05-3:30", "3:30-5:00"
				}
	        ));
	        table.setRowHeight(70);
	        dragP.add(createPanelForComponent(table, "Table"));
	       
	        JLabel j= new JLabel("Heeer");
	        dragP.add(createPanelForComponent(j, "Table"));
                  
       
       
      frame.getContentPane().add(rightPanel);
		frame.getContentPane().add(rightPanel);
		frame.pack();
		frame.setVisible(true);
		frame.pack();
        frame.setLocationRelativeTo(null);
	}
	

	private static Component getComponents() {
		// TODO Auto-generated method stub
		return null;
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
	private int X, Y;
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		X=e.getX();
		Y=e.getY();
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(java.awt.event.MouseEvent e) {
		e.getComponent().setLocation(e.getX()+e.getComponent().getX()-X, e.getY()+e.getComponent().getY()-Y);
	}
	@Override
	public void mouseMoved(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
}