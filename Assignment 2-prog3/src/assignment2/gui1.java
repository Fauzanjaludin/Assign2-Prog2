package assignment2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class gui1 {

	private JFrame frame;
	private JTextField txtname1;
	private JTextField txtname2;
	private JComboBox cbgen;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui1 window = new gui1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		outdoorsportdemo ods=new outdoorsportdemo();
		frame = new JFrame();
		frame.setBounds(100, 100, 1010, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Outdoor Sports Club");
		lblNewLabel.setBounds(10, 11, 308, 70);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 76, 974, 455);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tabbedPane.addTab("Register", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Info On Sport");
		lblNewLabel_1.setBounds(10, 102, 118, 14);
		panel.add(lblNewLabel_1);
		
		JTextPane infotxt = new JTextPane();
		infotxt.setBounds(10, 139, 949, 277);
		panel.add(infotxt);
		
		txtname1 = new JTextField();
		txtname1.setBounds(290, 11, 280, 20);
		panel.add(txtname1);
		txtname1.setColumns(10);
		
		txtname2 = new JTextField();
		txtname2.setColumns(10);
		txtname2.setBounds(290, 42, 280, 20);
		panel.add(txtname2);
		
		cbgen = new JComboBox();
		cbgen.setModel(new DefaultComboBoxModel(new String[] {"Choose a Gender", "Male", "Female"}));
		cbgen.setBounds(290, 73, 280, 20);
		panel.add(cbgen);
		
		JComboBox cbsport = new JComboBox();
		cbsport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=String.valueOf(cbsport.getSelectedItem());
					infotxt.setText(ods.print1(a));
				
			}
		});
		cbsport.setMaximumRowCount(5);
		cbsport.setModel(new DefaultComboBoxModel(new String[] {"Choose a Sport", "Hiking", "Cycling", "Surfing"}));
		cbsport.setBounds(10, 41, 155, 22);
		panel.add(cbsport);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Outdoor Sport name");
		lblNewLabel_2.setBounds(10, 14, 155, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setBounds(204, 14, 76, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Last Name");
		lblNewLabel_3_1.setBounds(204, 45, 76, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Gender");
		lblNewLabel_3_2.setBounds(204, 76, 76, 14);
		panel.add(lblNewLabel_3_2);
		
		JComboBox cbrace = new JComboBox();
		cbrace.setModel(new DefaultComboBoxModel(new String[] {"Choose a Race", "Melayu", "Cina", "India"}));
		cbrace.setBounds(290, 101, 280, 20);
		panel.add(cbrace);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Race");
		lblNewLabel_3_2_1.setBounds(204, 104, 76, 14);
		panel.add(lblNewLabel_3_2_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("table", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 11, 806, 405);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"sport", "firstname", "lastname", "gender", "race"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int row=table.getSelectedRow();
				int col=table.getSelectedColumn();
				if(table.getSelectedRow()==-1) {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "No data available","Proton registry",
								JOptionPane.OK_OPTION);}
					else {
						JOptionPane.showMessageDialog(null, "Select a row to delete","Proton registry",
								JOptionPane.OK_OPTION);}
				}
				
					else {
						model.removeRow(table.getSelectedRow());
						
					
				}
				
			
			}
		});
		btnNewButton.setBounds(10, 14, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton butreg = new JButton("Register");
		butreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{
						cbsport.getSelectedItem(),
						txtname1.getText(),
						txtname2.getText(),
						cbgen.getSelectedItem(),
						cbrace.getSelectedItem(),
						
				
				});
			}
		});
		butreg.setBounds(580, 98, 89, 23);
		panel.add(butreg);
	}
}
