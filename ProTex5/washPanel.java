import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class washPanel extends JPanel implements ActionListener{
	/**
	 * Version 0.1
	 */
	private static final long serialVersionUID = 1L;
	private workDescription wd;
	private JPanel p1 = new JPanel();
	private JCheckBox handWash = new JCheckBox("Handtvätt");
	private JCheckBox washTemp = new JCheckBox("Temperaturtvätt");
	private JComboBox temperature = new JComboBox();
	private JCheckBox woolWash = new JCheckBox("Ylletvätt");
	private JCheckBox ironing = new JCheckBox("Strykning");
	private JCheckBox noBleach = new JCheckBox("Ej klorblekning");
	private JCheckBox noDryer = new JCheckBox("Ej torktumlare");
	private JCheckBox chemWash = new JCheckBox("Kemtvätt");
	
	private JCheckBox printText = new JCheckBox("Varningstext tryckfärg",true);
	private JCheckBox bottomText = new JCheckBox("Reklamationstext",true);
	
	public washPanel(workDescription bertil){
		wd = bertil;
		setLayout(new GridLayout(12,1));
		//this, BoxLayout.Y_AXIS));
		
		handWash.setAlignmentX(JCheckBox.LEFT_ALIGNMENT);
		
		temperature.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
		
		temperature.setMinimumSize(temperature.getPreferredSize());
		temperature.setMaximumSize(temperature.getPreferredSize());
		
		temperature.addItem("");
		temperature.addItem("30");
		temperature.addItem("40");
		temperature.addItem("60");
		
		
		//add(Box.createHorizontalGlue());
		p1.setLayout(new GridLayout(1,2));
		p1.add(washTemp);
		washTemp.addActionListener(this);
		p1.add(temperature);
		temperature.addActionListener(this);
		//p1.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		
		add(handWash);
		handWash.addActionListener(this);
		add(p1);
		add(woolWash);
		woolWash.addActionListener(this);
		add(ironing);
		ironing.addActionListener(this);
		add(noBleach);
		noBleach.addActionListener(this);
		add(noDryer);
		noDryer.addActionListener(this);
		add(chemWash);
		chemWash.addActionListener(this);
		
		add(new JLabel("",JLabel.LEFT));
		
		add(printText);
		printText.addActionListener(this);
		add(bottomText);
		bottomText.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		Object b = e.getSource();
		
		if (b == handWash){
			System.out.println("handWash:" + handWash.isSelected());
			wd.setHandWash(handWash.isSelected());
		}
		if (b == washTemp){
			System.out.println("washTemp:" + washTemp.isSelected());
			wd.setWashTemp(washTemp.isSelected());
		}
		if (b == temperature){
			System.out.println("temperature:" + temperature.getSelectedItem().toString());
			wd.setTemperature(temperature.getSelectedItem().toString());
			if(temperature.getSelectedItem().toString() == ""){
				washTemp.setSelected(false);
				wd.setWashTemp(washTemp.isSelected());
				this.updateUI();
			}
			else{
				washTemp.setSelected(true);
				wd.setWashTemp(washTemp.isSelected());
				this.updateUI();
			}
		}
		if (b == woolWash){
			System.out.println("woolWash:" + woolWash.isSelected());
			wd.setWoolWash(woolWash.isSelected());
		}
		if (b == ironing){
			System.out.println("ironing:" + ironing.isSelected());
			wd.setIroning(ironing.isSelected());
		}
		if (b == noBleach){
			System.out.println("noBleach:" + noBleach.isSelected());
			wd.setNoBleach(noBleach.isSelected());
		}
		if (b == noDryer){
			System.out.println("noDryer:" + noDryer.isSelected());
			wd.setNoDryer(noDryer.isSelected());
		}
		if (b == chemWash){
			System.out.println("chemWash:" + chemWash.isSelected());
			wd.setChemWash(chemWash.isSelected());
		}
		if (b == printText){
			System.out.println("printText:" + printText.isSelected());
			wd.setPrintText(printText.isSelected());
		}
		if (b == bottomText){
			System.out.println("bottomText:" + bottomText.isSelected());
			wd.setBottomText(bottomText.isSelected());
		}
		
		
	}

}
