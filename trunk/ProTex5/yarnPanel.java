//import javax.comm.CommPortIdentifier;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

public class yarnPanel extends JPanel implements ActionListener{
	/**
	 * Version 0.1
	 */
	private static final long serialVersionUID = 1L;
	//TODO: Fixa så man kan adda rutor en och en ist för alla på en gång.
	//Dessutom kan det va kul att minska typsnitt(?) så att mer får plats enl tidigare.
	
	
	private workDescription wd;
	
	
	private JCheckBox numbers = new JCheckBox("Numrerat",true);
	private JTextField trLength = new JTextField("1");
	
	static LinkedList<JComboBox> yarnList = new LinkedList<JComboBox>();
	static LinkedList<JTextField> yarnAnchor = new LinkedList<JTextField>();
	static LinkedList<JTextField> yarnContent = new LinkedList<JTextField>();
	
	static int YARN_NUM = 36;
	static int MAX_YARN_NUM = 36;
	
	public yarnPanel(workDescription bertil){
		wd = bertil;
		setLayout(new GridLayout(YARN_NUM + 3,3));
		
		add(numbers);
		numbers.addActionListener(this);
		add(new JLabel("1 TR = ? Meter ",JLabel.RIGHT));
		add(trLength);
		trLength.addKeyListener(kl);
		
		add(new JLabel("",JLabel.LEFT));
		add(new JLabel("",JLabel.LEFT));
		add(new JLabel("",JLabel.LEFT));
		
		add(new JLabel("Färg",JLabel.LEFT));
		add(new JLabel("Anchor",JLabel.LEFT));
		add(new JLabel("Trådar",JLabel.LEFT));
		
		try{
			yarnList.clear();
			Scanner sc;
			String filen = "";
			for(int a = 0; a < YARN_NUM; a++){
				yarnList.add(new JComboBox());
				(yarnList.get(a)).addItem("");
				//Open the yarn-file and read some content
				if(wd.getLanguage() == workDescription.SV_EN_TY_FI)
					filen = "Lang/farg_SETF.txt";
				else if(wd.getLanguage() == workDescription.NO_DA)
					filen = "Lang/farg_ND.txt";
				sc = new Scanner(new File(filen));
				while(sc.hasNextLine())
					(yarnList.get(a)).addItem(sc.nextLine());
				
				(yarnList.get(a)).setEditable(true);
				(yarnList.get(a)).setSelectedItem("");
				add(yarnList.get(a));
				(yarnList.get(a)).addActionListener(this);
				
				yarnAnchor.add(new JTextField());
				(yarnAnchor.get(a)).setText("");
				add(yarnAnchor.get(a));
				(yarnAnchor.get(a)).addKeyListener(kl);
				
				yarnContent.add(new JTextField());
				(yarnContent.get(a)).setText("");
				add(yarnContent.get(a));
				(yarnContent.get(a)).addKeyListener(kl);
			}
		}
		catch (Exception ex){
			System.out.println(ex.getCause().toString());
		}
		/*cb[0].addItem("");
		cb[0].addItem("Banjo");
		cb[0].setEditable(true);
		
		add(cb[0]);
		cb[0].addActionListener(this);*/
	}
	
	public void actionPerformed(ActionEvent e){
		Object b = e.getSource();
		//System.out.println(b.toString());
		if(b == numbers)
			wd.setNumbers(numbers.isSelected());
		for(int a = 0; a < YARN_NUM; a++){
			if (b == yarnList.get(a)){
				wd.addToYarnList(a, (yarnList.get(a)).getSelectedItem().toString());
				//System.out.println("COMBO EVENT " + a);
			}
		}
	}
	
	KeyListener kl = new KeyAdapter() {
		public void keyReleased(KeyEvent e){
			Object b = e.getSource();
			//System.out.println(b.toString());
			if(b == trLength)
				wd.setTrLength(trLength.getText());
			for(int a = 0; a < YARN_NUM; a++){
				if (b == yarnAnchor.get(a)){
					wd.addToYarnAnchor(a, (yarnAnchor.get(a)).getText());
					//System.out.println("KEY EVENT A " + a);
				}
			}
			
			for(int a = 0; a < YARN_NUM; a++){
				if (b == yarnContent.get(a)){
					wd.addToYarnContent(a, (yarnContent.get(a)).getText());
					//System.out.println("KEY EVENT A " + a);
				}
			}
			
		}
	};
	
}
