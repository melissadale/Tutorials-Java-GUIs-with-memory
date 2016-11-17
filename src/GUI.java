import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField addName_tf;
	private JTextField addShirt_tf;
	private JTextField addRank_tf;
	private JTextField lookForName_tf;
	
	private static ArrayList<CrewMember> theCrew;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		theCrew = FileManager.initList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 11, 46, 14);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(237, 11, 46, 14);
		contentPane.add(label);
		
		JLabel lblShirt = new JLabel("Shirt");
		lblShirt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblShirt.setBounds(237, 65, 46, 14);
		contentPane.add(lblShirt);
		
		JLabel lblRank = new JLabel("Rank");
		lblRank.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRank.setBounds(237, 124, 46, 14);
		contentPane.add(lblRank);
		
		addName_tf = new JTextField();
		addName_tf.setBounds(293, 10, 120, 20);
		contentPane.add(addName_tf);
		addName_tf.setColumns(10);
		
		addShirt_tf = new JTextField();
		addShirt_tf.setColumns(10);
		addShirt_tf.setBounds(293, 59, 120, 20);
		contentPane.add(addShirt_tf);
		
		addRank_tf = new JTextField();
		addRank_tf.setColumns(10);
		addRank_tf.setBounds(293, 123, 120, 20);
		contentPane.add(addRank_tf);
		
		lookForName_tf = new JTextField();
		lookForName_tf.setColumns(10);
		lookForName_tf.setBounds(66, 10, 120, 20);
		contentPane.add(lookForName_tf);
		
		JLabel findName_tf = new JLabel("Name");
		findName_tf.setForeground(Color.BLUE);
		findName_tf.setFont(new Font("Tahoma", Font.BOLD, 14));
		findName_tf.setBounds(10, 59, 46, 14);
		contentPane.add(findName_tf);
		
		JLabel findShirt_tf = new JLabel("Shirt");
		findShirt_tf.setForeground(Color.BLUE);
		findShirt_tf.setFont(new Font("Tahoma", Font.BOLD, 14));
		findShirt_tf.setBounds(10, 98, 46, 14);
		contentPane.add(findShirt_tf);
		
		JLabel findRank_tf = new JLabel("Rank");
		findRank_tf.setForeground(Color.BLUE);
		findRank_tf.setFont(new Font("Tahoma", Font.BOLD, 14));
		findRank_tf.setBounds(10, 140, 46, 14);
		contentPane.add(findRank_tf);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 207, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel foundN_tf = new JLabel("");
		foundN_tf.setBounds(65, 60, 46, 14);
		panel.add(foundN_tf);
		
		JLabel foundS_tf = new JLabel("");
		foundS_tf.setBounds(65, 100, 46, 14);
		panel.add(foundS_tf);
		
		JLabel foundR_tf = new JLabel("");
		foundR_tf.setBounds(65, 141, 46, 14);
		panel.add(foundR_tf);
		
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = lookForName_tf.getText();
				
				String placeholder = "NA";
				CrewMember tmp = new CrewMember(placeholder, placeholder, placeholder);
				
				//Loop through our arraylist looking for given name
				for(int i = 0; i<theCrew.size(); i++){
					if(theCrew.get(i).name.equals(name))
						tmp = theCrew.get(i);
				}
				
				
				foundN_tf.setText(tmp.name);
				foundS_tf.setText(tmp.shirt);
				foundR_tf.setText(tmp.title);
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFind.setBounds(66, 211, 89, 23);
		panel.add(btnFind);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String addName = addName_tf.getText();
				String addShirt = addShirt_tf.getText();
				String addRank = addRank_tf.getText();
				
				CrewMember newCrew = new CrewMember(addName, addShirt, addRank);
				theCrew.add(newCrew);
				try {
					FileManager.saveList(theCrew);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(293, 211, 89, 23);
		contentPane.add(btnAdd);
	}
}
