package interfaceUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

//field.setDragEnabled(true);
//field=new JTextField("Room Name");
//dragP.add(field);
//field=new JTextField("8:00 9:30");
//dragP.add(field);
//field=new JTextField("9:30 11:00");
//dragP.add(field);
//field=new JTextField("11:00 12:30");
//dragP.add(field);
//field=new JTextField("12:30 2:00");
//dragP.add(field);
//field=new JTextField("2:00 3:30");
//dragP.add(field);
//field=new JTextField("3:30 5:00");
//dragP.add(field);
// field=new JTextField("Room 5");
//dragP.add(field);
//field=new JTextField("		");
// field.setTransferHandler(new TransferHandler("text"));
//dragP.add(field);
//field=new JTextField("	");
// field.setTransferHandler(new TransferHandler("text"));
//dragP.add(field);
//field=new JTextField(" 	");
// field.setTransferHandler(new TransferHandler("text"));
//dragP.add(field);
//field=new JTextField("	");
// field.setTransferHandler(new TransferHandler("text"));
//dragP.add(field);
//field=new JTextField("	");
// field.setTransferHandler(new TransferHandler("text"));
//dragP.add(field);
//field=new JTextField("	");
// field.setTransferHandler(new TransferHandler("text"));
//dragP.add(field);
// field=new JTextField("Room 6");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("Room 7");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
//field=new JTextField("	");
//dragP.add(field);
////field.setDropMode(DropMode.ON_OR_INSERT);
//JButton bt1=new JButton("Add Room");
//p3.add(bt1);
//JButton bt2=new JButton("Add New Slot");
//p3.add(bt2);

public class Ui extends JFrame {
	private JTable table;
	private JTextField txt1;
	private JTextField txtCb;
	private JTextField txtCb_1;
	private JTextField txtCsa;
	private JTextField txtCa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui frame = new Ui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 969, 513);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 728, 474);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
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
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(21);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setRowHeight(100);
		scrollPane.setViewportView(table);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setText("C17-A");
		txt1.setBounds(768, 11, 129, 20);
		getContentPane().add(txt1);
		txt1.setColumns(10);
		
		txtCb = new JTextField();
		txtCb.setEditable(false);
		txtCb.setText("C17-B");
		txtCb.setColumns(10);
		txtCb.setBounds(768, 42, 129, 20);
		getContentPane().add(txtCb);
		
		txtCb_1 = new JTextField();
		txtCb_1.setEditable(false);
		txtCb_1.setText("C18-B");
		txtCb_1.setColumns(10);
		txtCb_1.setBounds(768, 77, 129, 20);
		getContentPane().add(txtCb_1);
		
		txtCsa = new JTextField();
		txtCsa.setEditable(false);
		txtCsa.setText("CS-18A");
		txtCsa.setColumns(10);
		txtCsa.setBounds(768, 108, 129, 20);
		getContentPane().add(txtCsa);
		
		txtCa = new JTextField();
		txtCa.setEditable(false);
		txtCa.setText("C16-A");
		txtCa.setBounds(11, 11, 333, 333);
		txtCa.setColumns(10);
		txtCa.setBounds(768, 145, 129, 20);
		getContentPane().add(txtCa);
	}
}
