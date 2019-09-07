/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package dnd;

/*
 * BasicDnD.java requires no other files.
 */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.awt.datatransfer.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import javax.swing.tree.*;
import javax.swing.table.*;

public class BasicDnD extends JPanel implements ActionListener {
    private static JFrame frame;
	private static  MouseMotionListener MouseEvent= null;
	public static JLabel lbl;

    private JTextArea textArea;
    private JTextField textField;
   // private JList list;
    private JTable table;
    //private JTree tree;
    //private JColorChooser colorChooser;
    private JCheckBox toggleDnD;
    
    public BasicDnD() {
        super(new BorderLayout());
        JPanel leftPanel = createVerticalBoxPanel();
        JPanel rightPanel = createVerticalBoxPanel();
       

        //Create a table model.
//        DefaultTableModel tm = new DefaultTableModel();
//        tm.addColumn("Column 0");
//        tm.addColumn("Column 1");
//        tm.addColumn("Column 2");
//        tm.addColumn("Column 3");
//        tm.addRow(new String[]{"Table 00", "Table 01", "Table 02", "Table 03"});
//        tm.addRow(new String[]{"Table 10", "Table 11", "Table 12", "Table 13"});
//        tm.addRow(new String[]{"Table 20", "Table 21", "Table 22", "Table 23"});
//        tm.addRow(new String[]{"Table 30", "Table 31", "Table 32", "Table 33"});

        //LEFT COLUMN 
        //Use the table model to create a table.
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
        table.setRowHeight(100);
        JScrollPane tView = new JScrollPane(table);
        tView.setPreferredSize(new Dimension(300, 100));
        leftPanel.add(createPanelForComponent(tView, "JList"));
       

        //Create a color chooser.
//        colorChooser = new JColorChooser();
//        leftPanel.add(createPanelForComponent(colorChooser, "JColorChooser"));

        //RIGHT COLUMN
        //Create a textfield.
//        textField = new JTextField(30);
//        textField.setText("Favorite foods:\nPizza, Moussaka, Pot roast");
//        rightPanel.add(createPanelForComponent(textField, "JTextField"));

        //Create a scrolled text area.
//        textArea = new JTextArea(5, 30);
//        textArea.setText("Favorite shows:\nBuffy, Alias, Angel");
//        JScrollPane scrollPane = new JScrollPane(textArea);
//        rightPanel.add(createPanelForComponent(scrollPane, "JTextArea"));

        //Create a list model and a list.
      
        final int labelRows = 3,    //How many rows of labels.
                labelColumns = 5, //How many columns of labels.
                labelWidth = 55,  //Width for each label.
                labelHeight = 20; //Height for each label.

      //Border colors for labels:
     final Color[] colors = new Color[]{Color.BLUE, Color.GREEN, Color.BLACK, Color.GRAY};
       //For selecting border color for each label.
      final MouseAdapter ma = new MouseAdapter() {
      private JLabel selectedLabel = null; //Clicked label.
      private Point selectedLabelLocation = null; //Location of label in panel when it was clicked.
      private Point panelClickPoint = null; //Panel's click point.
          //Selection of label occurs upon pressing on the panel:
          @Override
          public void mousePressed(final MouseEvent e) {
              //Find which label is at the press point:
              final Component pressedComp = rightPanel.findComponentAt(e.getX(), e.getY());
              //If a label is pressed, store it as selected:
              if (pressedComp != null && pressedComp instanceof JLabel) {
                  selectedLabel = (JLabel) pressedComp;
                 
                  selectedLabelLocation = selectedLabel.getLocation();
                  panelClickPoint = e.getPoint();
                  rightPanel.setComponentZOrder(selectedLabel, 0);
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
                 // txt1.setLocation(newX, newY);
              }
          }
      	@Override
      	public void mouseReleased(final MouseEvent e) {
      		//txt1.setText(selectedLabel.getText());    		
      		//txt1.setVisible(false);
      		//txt1.setHorizontalAlignment(labelWidth);
      		table.getDropLocation();
      	}   
      };
      rightPanel.addMouseMotionListener(ma); //For mouseDragged().
      rightPanel.addMouseListener(ma); //For mousePressed().
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
              rightPanel.add(lbl);
          }
     
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                              leftPanel, rightPanel);
        splitPane.setOneTouchExpandable(true);

        add(splitPane, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(5,10,5,5));
    }

    protected JPanel createVerticalBoxPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        return p;
    }

    public JPanel createPanelForComponent(JComponent comp,
                                          String title) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(comp, BorderLayout.CENTER);
        if (title != null) {
            panel.setBorder(BorderFactory.createTitledBorder(title));
        }
        return panel;
    }

    private void displayDropLocation(final String string) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, string);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if ("toggleDnD".equals(e.getActionCommand())) {
            boolean toggle = toggleDnD.isSelected();
        }
    }

   
    private static void createAndShowGUI() {
        frame = new JFrame("BasicDnD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new BasicDnD();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
	        UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
}