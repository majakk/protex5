/*
* This is a panel that keeps track of the current language setting.
*/
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class languagePanel extends JPanel implements ActionListener{
	/**
	 * Version 0.1
	 */
	private static final long serialVersionUID = 1L;
	private workDescription wd;
		
	private JRadioButton r1 = new JRadioButton("Svenska / Engelska / Tyska / Finska"),
		r2 = new JRadioButton("Norska / Danska");
	public languagePanel(workDescription bertil){
		wd = bertil;
		//wd.setLanguage(workDescription.SV_EN_TY_FI);
		
		
		setLayout(new GridLayout(20,3));
		add(new JLabel("",JLabel.CENTER));
		add(r1); add(r2);
		ButtonGroup sprak = new ButtonGroup();
		sprak.add(r1); sprak.add(r2);
		r1.addActionListener(this);
		r2.addActionListener(this);
		if(wd.getLanguage() == workDescription.SV_EN_TY_FI){
			r1.setSelected(true);
			//r2.setSelected(true);
		}
		else
			r2.setSelected(true);
	}
	
	public void actionPerformed(ActionEvent e){
		Object b = e.getSource();
		if (b == r1){
			wd.setLanguage(workDescription.SV_EN_TY_FI);
			System.out.println(wd.getLanguage());
			wd.setClearFlag(true);
		}
		else if (b == r2){
			wd.setLanguage(workDescription.NO_DA);
			System.out.println(wd.getLanguage());
			wd.setClearFlag(true);
		}
	}	
}
