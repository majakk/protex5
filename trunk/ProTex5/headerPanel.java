import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class headerPanel extends JPanel implements ActionListener {
	/**
	 * Version 0.1
	 */
	private static final long serialVersionUID = 1L;
	private workDescription wd;
	
	private JComboBox article = new JComboBox();
	private JTextField artnr = new JTextField();
	private JTextField artother = new JTextField();
	private JTextField size = new JTextField();
	private JComboBox fabric = new JComboBox();
	private JComboBox yarn = new JComboBox();
	private JComboBox design = new JComboBox();
		
	public headerPanel(workDescription bertil){
		wd = bertil;
		setLayout(new GridLayout(12,2));
		//this.addFocusListener(fl);
		//TODO: Load predefined items according to lp (or decide language on beforehand?)
		
		try{
			Scanner sc;
			if(wd.getLanguage() == workDescription.SV_EN_TY_FI){
				article.addItem("");
				sc = new Scanner(new File("Lang/article_SETF.txt"));
				while(sc.hasNextLine())
					article.addItem(sc.nextLine());
				
				fabric.addItem("");
				sc = new Scanner(new File("Lang/fabric_SETF.txt"));
				while(sc.hasNextLine())
					fabric.addItem(sc.nextLine());
				
				yarn.addItem("");
				sc = new Scanner(new File("Lang/yarn_SETF.txt"));
				while(sc.hasNextLine())
					yarn.addItem(sc.nextLine());
			}
			else if(wd.getLanguage() == workDescription.NO_DA){
				article.addItem("");
				sc = new Scanner(new File("Lang/article_ND.txt"));
				while(sc.hasNextLine())
					article.addItem(sc.nextLine());
				
				fabric.addItem("");
				sc = new Scanner(new File("Lang/fabric_ND.txt"));
				while(sc.hasNextLine())
					fabric.addItem(sc.nextLine());
				
				yarn.addItem("");
				sc = new Scanner(new File("Lang/yarn_ND.txt"));
				while(sc.hasNextLine())
					yarn.addItem(sc.nextLine());
			}
			
			design.addItem("");
			sc = new Scanner(new File("Lang/design.txt"));
			while(sc.hasNextLine())
				design.addItem(sc.nextLine());
		}
		catch (Exception ex){
			System.out.println(ex.getCause().toString());
		}
		
		add(new JLabel("Artikel ",JLabel.RIGHT));
		article.setAlignmentX(JComboBox.RIGHT_ALIGNMENT);
		add(article);
		article.addActionListener(this);
		article.setEditable(true);
		
		add(new JLabel("Artikel Nr ",JLabel.RIGHT));
		artnr.setAlignmentX(JTextField.RIGHT_ALIGNMENT);
		add(artnr);
		artnr.addKeyListener(kl);
		
		add(new JLabel("Artikel underrubrik ",JLabel.RIGHT));
		artother.setAlignmentX(JTextField.RIGHT_ALIGNMENT);
		add(artother);
		artother.addKeyListener(kl);
		
		add(new JLabel("Storlek ",JLabel.RIGHT));
		size.setAlignmentX(JTextField.RIGHT_ALIGNMENT);
		add(size);
		size.addKeyListener(kl);
		
		add(new JLabel("Väv ",JLabel.RIGHT));
		fabric.setAlignmentX(JComboBox.RIGHT_ALIGNMENT);
		add(fabric);
		fabric.addActionListener(this);
		fabric.setEditable(true);
		
		add(new JLabel("Garn ",JLabel.RIGHT));
		yarn.setAlignmentX(JComboBox.RIGHT_ALIGNMENT);
		add(yarn);
		yarn.addActionListener(this);
		yarn.setEditable(true);
		
		add(new JLabel("Design ",JLabel.RIGHT));
		design.setAlignmentX(JComboBox.RIGHT_ALIGNMENT);
		add(design);
		design.addActionListener(this);
		design.setEditable(true);
		
		
	}
	
	protected void update(){
		//brumbrum;
		article.setSelectedItem(wd.getArticle());
		artnr.setText(wd.getArtNr());
		artother.setText(wd.getArtOther());
		size.setText(wd.getSize());
		fabric.setSelectedItem(wd.getFabric());
		yarn.setSelectedItem(wd.getYarn());
		design.setSelectedItem(wd.getDesign());		
	}
	
	protected void updateLanguage(){
		;
	}
	
	public void actionPerformed(ActionEvent e){
		int count = 0;
		Object b = e.getSource();

		if (b == article){
			try{
				System.out.println(article.getSelectedItem().toString());
				wd.setArticle(article.getSelectedItem().toString());
				String filen = "";
				if(wd.getLanguage() == workDescription.SV_EN_TY_FI)
					filen = "Lang/articleOther_SETF.txt";
				else if(wd.getLanguage() == workDescription.NO_DA)
					filen = "Lang/articleOther_ND.txt";
				Scanner sc = new Scanner(new File(filen));
				while(sc.hasNextLine()){
					String adam = new String(sc.nextLine());
					count++;
					if(count == article.getSelectedIndex()){
						wd.setArtOther(adam);
						artother.setText(adam);
						this.updateUI();
						this.invalidate();
					}
				}
				System.out.println(article.getSelectedIndex());
				
				
				this.updateUI();
			}
			catch (Exception ed){
				//System.out.println(ed.getCause().toString());
			}
		}
		else if (b == fabric){
			System.out.println(fabric.getSelectedItem().toString());
			wd.setFabric(fabric.getSelectedItem().toString());			
		}
		else if (b == yarn){
			System.out.println(yarn.getSelectedItem().toString());
			wd.setYarn(yarn.getSelectedItem().toString());
		}
		else if (b == design){
			System.out.println(design.getSelectedItem().toString());
			wd.setDesign(design.getSelectedItem().toString());
		}
	};
	
	KeyListener kl = new KeyAdapter() {
		public void keyReleased(KeyEvent e){
			Object b = e.getSource();
			//System.out.println(b.toString());
			if (b == artnr){
				System.out.println(artnr.getText());
				wd.setArtNr(artnr.getText());			
			}
			else if (b == artother){
				System.out.println(artother.getText());
				wd.setArtOther(artother.getText());
			}
			else if (b == size){
				System.out.println(size.getText());
				wd.setSize(size.getText());
			}
		}
	};
}
