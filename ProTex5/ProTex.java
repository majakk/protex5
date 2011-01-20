import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import java.awt.Color;
//import javax.swing.event.*;
import java.awt.event.*;

import java.io.*;

public class ProTex extends JFrame{
	/**
	 * Version 0.9.0.0 
	 */
	private static final long serialVersionUID = 1L;
	
	private workDescription wd;
	
	private JTabbedPane tp;
	private languagePanel lp;
	private headerPanel hp;
	private yarnPanel yp;
	private stitchPanel sp;
	private washPanel wp;
	private generatePdfPanel cp;
	//private symbolPanel sp;
	
	public ProTex(){
		workDescription adam = new workDescription();
		wd = adam;
		
		//private Document doccen;
		//myText = new JLabel("FAN!!!");
		//setLayout(new GridLayout(1,6));
		
		tp = new JTabbedPane(1,1);
		
		
		
		init();
		
		add(tp);		
		tp.addFocusListener(fl);
		
		pack();
		
		
	    this.setSize(800,600);
	    this.setTitle("ProTex 5");
	    
		  
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    //lp.grabFocus();
	}
	
	protected void init(){
		lp = new languagePanel(wd);
		tp.addTab("Språk", lp);
		//lp.addFocusListener(fl);
		
		hp = new headerPanel(wd);
		tp.addTab("Huvud", hp);
		//hp.addFocusListener(fl);
		
		yp = new yarnPanel(wd);
		tp.addTab("Garnåtgång", yp);
		
		sp = new stitchPanel(wd);
		tp.addTab("Stygnsymboler", sp);
		
		wp = new washPanel(wd);
		tp.addTab("Tvättråd & Text", wp);
		
		cp = new generatePdfPanel(wd);
		tp.addTab("Print", cp);
		
		
	}
	
	FocusListener fl = new FocusAdapter(){
		public void focusGained(FocusEvent e){
			Object b = e.getSource();
			if(b == tp){
				int tempindex = 0;
				
				if(wd.getClearFlag()){
					tempindex = tp.getSelectedIndex();
					tp.removeAll();
					init(); 
					//get and set the language!?					
					wd.setClearFlag(false);
				}
				//System.out.println(tp.getSelectedIndex());
				//Yes! you know the tab...  now focus on it!
				if(tempindex == 0){
					//update lp
					;
					//lp.grabFocus();
					lp.grabFocus();
				}
				else if(tempindex == 1){
					//update hp
					//tp.removeAll();
					//tp.addTab("Huvud", hp);
					//hp.update();
					hp.grabFocus();
				}
				else if(tempindex == 2){
					//update yp
					yp.grabFocus();
				}
				else if(tp.getSelectedIndex() == 3){
					//update sp
					sp.grabFocus();
				}
				else if(tp.getSelectedIndex() == 4){
					//update wp
					wp.grabFocus();
				}
				else if(tp.getSelectedIndex() == 5){
					//update cp
					cp.grabFocus();
				}			
			}
		}
	};
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//System.out.println(serialVersionUID);
		ProTex start = new ProTex();
		start.setBackground(Color.BLUE);
		start.setIconImage(Toolkit.getDefaultToolkit().getImage("proimg16.png"));
		start.setVisible(true);		

	}

}
