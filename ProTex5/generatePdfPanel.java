import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JPanel;


public class generatePdfPanel extends JPanel implements ActionListener{
	/**
	 * Version 0.1
	 */
	private static final long serialVersionUID = 1L;
	
	private workDescription wd;
	
	//TODO Edit Filename
	
	private JButton genbutt = new JButton("Skapa PDF");
	private JButton debbutt = new JButton("Debug");
	private JButton clearbutt = new JButton("Rensa Allt");
	
	
	private JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
	
	public generatePdfPanel(workDescription bertil){
		wd = bertil;
		
		add(genbutt);
		genbutt.addActionListener(this);
		
		//add(debbutt);
		//debbutt.addActionListener(this);
		
		add(clearbutt);
		clearbutt.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Object b = e.getSource();
		if(b == genbutt){
			NameFilter pdf = new NameFilter(".pdf");
			fc.addChoosableFileFilter(pdf);
			fc.setFileFilter(pdf);
			fc.setSelectedFile(new File(wd.getArtNr() + ".pdf"));
			int result = fc.showSaveDialog(null);
			if(result == JFileChooser.APPROVE_OPTION){
				//System.out.println(fc.getSelectedFile());
				if(fc.getSelectedFile().exists()){
					//System.out.println("Finns!");
					if(JOptionPane.showConfirmDialog(this, 
							"Skriva över '" + fc.getSelectedFile().getName() + "' ?",
							"", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
						//Set filename!
						wd.generatePDF(fc.getSelectedFile().getAbsolutePath());
					}
				}
				else{
					//Set Filename
					wd.generatePDF(fc.getSelectedFile().getAbsolutePath());
				}
			}
			//Otherwise go back!
		}
		if(b == debbutt){
			//wd.printHeader();
			//wd.printWash();
			//wd.printYarn();
			wd.printStitch();
		}		
		if(b == clearbutt){
			if(JOptionPane.showConfirmDialog(this, 
					"Återställa Allt?",
					"", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
				//Clear All and Reload Interface, setting all to Default!
				wd.setDefaults();
				wd.setClearFlag(true);
			}
			wd.printHeader();
			wd.printWash();
			wd.printYarn();
			wd.printStitch();
		}		
	}	
}
