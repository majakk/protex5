import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
//import java.util.*;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class stitchPanel extends JPanel implements ActionListener{
	/**
	 * Version 0.1
	 */
	private static final long serialVersionUID = 1L;
	
	private workDescription wd;
	
	static LinkedList<JCheckBox> stitchList = new LinkedList<JCheckBox>();
	static LinkedList<String> stitchLabels = new LinkedList<String>();
	
	static int STITCH_NUM = 15;
	
	public stitchPanel(workDescription bertil){
		wd = bertil;
		setLayout(new GridLayout(12,2));
		
		stitchLabels.add("6/6 Tråd");
		stitchLabels.add("3/6 Tråd");
		stitchLabels.add("2/6 Tråd");
		stitchLabels.add("1/6 Tråd");
		stitchLabels.add("Efterstygn");
		stitchLabels.add("Hålsöm");
		stitchLabels.add("Kedjesöm");
		stitchLabels.add("Knutar");
		stitchLabels.add("Korsstygn");
		stitchLabels.add("Langette");
		stitchLabels.add("Plattsöm");
		stitchLabels.add("Schattérsöm");
		stitchLabels.add("Stjälkstygn");
		stitchLabels.add("Öglestygn");
		stitchLabels.add("Öppna Öglestygn");		
		
		for(int a = 0; a < STITCH_NUM; a++){
			stitchList.add(new JCheckBox(stitchLabels.get(a)));
			add(stitchList.get(a));
			(stitchList.get(a)).setSelected(false);
			(stitchList.get(a)).addActionListener(this);
		}
		
	}
	
	public void actionPerformed(ActionEvent e){
		Object b = e.getSource();
		//System.out.println(b.toString());
		for(int a = 0; a < STITCH_NUM; a++){
			if (b == stitchList.get(a)){
				wd.addToStitchList(a, (stitchList.get(a)).isSelected());
				System.out.println("CHECKBOX EVENT " + a);
			}
		}
		
	}
	

}
