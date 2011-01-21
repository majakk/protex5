import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPCell;

public class workDescription {
	/**
	 * Version 0.9.0.1
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Language Panel
	public static int SV_EN_TY_FI = 1;
	public static int NO_DA = 2;
	private int language;
	
	//Header Panel
	private String article;
	private String artnr;
	private String artother;
	private String size;
	private String fabric;
	private String yarn;
	private String design;
	
	//Yarn Panel
	private Boolean numbers;
	private String trLength;
	private LinkedList<String> yarnList = new LinkedList<String>();
	private LinkedList<String> yarnAnchor = new LinkedList<String>();
	private LinkedList<String> yarnContent = new LinkedList<String>();
	
	//Stitch Panel
	private LinkedList<Boolean> stitchList = new LinkedList<Boolean>();
	private LinkedList<String> stitchPath = new LinkedList<String>();
	private LinkedList<Boolean> stitchHoriz = new LinkedList<Boolean>();	
	
	//Wash Panel
	private LinkedList<Boolean> washData = new LinkedList<Boolean>();
	private LinkedList<String> washPath = new LinkedList<String>();
	private Boolean handWash;
	private Boolean washTemp;
	private String temperature;
	private Boolean woolWash;
	private Boolean ironing;
	private Boolean noBleach;
	private Boolean noDryer;
	private Boolean chemWash;
	private Boolean printText;
	private Boolean bottomText;
	
	private Boolean clearFlag;
	
	public workDescription(){
		clearFlag = false;
		setLanguage(SV_EN_TY_FI);
		setDefaults();		
	}
	
	void setDefaults(){
		//Header Panel
		article = "";
		artnr = "";
		artother = "";
		size = "";
		fabric = "";
		yarn = "";
		design = "";
		
		//Yarn Panel
		numbers = true;
		trLength = "1";
		yarnList.clear();
		yarnAnchor.clear();
		yarnContent.clear();
		
		//Stitch Panel
		stitchList.clear();
		stitchPath.clear(); //Don't clear Paths!?
		stitchHoriz.clear();
		
		//WashPanel
		washData.clear();
		washPath.clear(); //Don't clear Paths!?
		handWash = false;
		washTemp = false;
		temperature = "";
		woolWash = false;
		ironing = false;
		noBleach = false;
		noDryer = false;
		chemWash = false;
		printText = true;
		bottomText = true;		
	}
	
	int getLanguage(){
		return language;
	}
	
	void setLanguage(int v){
		language = v;
	}
	
	//Header methods
	void setArticle(String input){
		article = input;
	}
	
	String getArticle(){
		return article;
	}
	
	void setArtNr(String input){
		artnr = input;
	}
	
	String getArtNr(){
		return artnr;
	}
	
	void setArtOther(String input){
		artother = input;
	}
	
	String getArtOther(){
		return artother;
	}
	
	void setSize(String input){
		size = input;
	}
	
	String getSize(){
		return size;
	}
	
	void setFabric(String input){
		fabric = input;
	}
	
	String getFabric(){
		return fabric;
	}
	
	void setYarn(String input){
		yarn = input;
	}
	
	String getYarn(){
		return yarn;
	}
	
	void setDesign(String input){
		design = input;
	}
	
	String getDesign(){
		return design;
	}
		
	void printHeader(){
		System.out.println(article + ":" + artnr + ":" + artother + ":" + size + ":" + fabric + ":" + yarn + ":" + design);
	}
	
	//Yarn methods
	void setNumbers(Boolean input){
		numbers = input;
	}
	
	Boolean getNumbers(){
		return numbers;
	}
	
	void setTrLength(String input){
		trLength = input;
	}
	
	String getTrLength(){
		return trLength;
	}
	
	void addToYarnList(int index, String input){
		while(yarnList.size() <= index){
			yarnList.add("");
			yarnAnchor.add("");
			yarnContent.add("");
		}
		yarnList.set(index, input);
		/*for(int i = 0; i < yarnList.size(); i++){
			System.out.println(yarnList.get(i));
		}*/
	}
	void addToYarnAnchor(int index, String input){
		while(yarnAnchor.size() <= index){
			yarnList.add("");
			yarnAnchor.add("");
			yarnContent.add("");
		}
		yarnAnchor.set(index, input);
		/*for(int i = 0; i < yarnList.size(); i++){
			System.out.println(yarnList.get(i));
		}*/
	}
	void addToYarnContent(int index, String input){
		while(yarnContent.size() <= index){
			yarnList.add("");
			yarnAnchor.add("");
			yarnContent.add("");
		}
		yarnContent.set(index, input);
		/*for(int i = 0; i < yarnList.size(); i++){
			System.out.println(yarnList.get(i));
		}*/
	}
	
	void clearYarnList(){
		yarnList.clear();
	}
	
	void printYarn(){
		for(int i = 0; i < yarnList.size(); i++){
			System.out.println(yarnList.get(i).toString() + ":" + yarnAnchor.get(i).toString() + ":" + yarnContent.get(i).toString());
		}
	}
	
	//Stitch methods
	void addToStitchList(int index, Boolean input){
		while(stitchList.size() <= index){
			stitchList.add(false);
		}
		stitchList.set(index, input);
		/*for(int i = 0; i < yarnList.size(); i++){
			System.out.println(yarnList.get(i));
		}*/
	}
	
	void clearStitchList(){
		stitchList.clear();
	}
	
	void printStitch(){
		for(int i = 0; i < stitchList.size(); i++){
			System.out.println(stitchList.get(i).toString());
		}
	}
	
	//Wash methods
	void setHandWash(Boolean input){
		handWash = input;
	}
	
	void setWashTemp(Boolean input){
		washTemp = input;
	}
	
	void setTemperature(String input){
		temperature = input;
	}
	
	void setWoolWash(Boolean input){
		woolWash = input;
	}
	
	void setIroning(Boolean input){
		ironing = input;
	}
	
	void setNoBleach(Boolean input){
		noBleach = input;
	}
	
	void setNoDryer(Boolean input){
		noDryer = input;
	}
	
	void setChemWash(Boolean input){
		chemWash = input;
	}
	
	void setPrintText(Boolean input){
		printText = input;
	}
	
	void setBottomText(Boolean input){
		bottomText = input;
	}	
	
	void printWash(){
		System.out.println(handWash + ":" + washTemp + ":" + temperature + ":" + woolWash + ":" + ironing + ":" + noBleach + ":" + noDryer + ":" + chemWash);
	}
	
	void setWashData(){
		washData.add(handWash);
		
		if(washTemp == true && temperature.toString() == "30"){
			washData.add(true);
			washData.add(false);
			washData.add(false);
		}
		else if(washTemp == true && temperature == "40"){
			washData.add(false);
			washData.add(true);
			washData.add(false);
		}
		else if(washTemp == true && temperature == "60"){
			washData.add(false);
			washData.add(false);
			washData.add(true);
		}
		else{
			washData.add(false);
			washData.add(false);
			washData.add(false);
		}
		
		washData.add(woolWash);
		washData.add(ironing);
		washData.add(noBleach);
		washData.add(noDryer);
		washData.add(chemWash);
		
		washPath.add("Symb/thand.wmf");
		washPath.add("Symb/t30.wmf");
		washPath.add("Symb/t40.wmf");
		washPath.add("Symb/t60.wmf");
		washPath.add("Symb/bomull.wmf");
		washPath.add("Symb/tbom.wmf");
		washPath.add("Symb/tklor.wmf");
		washPath.add("Symb/ttork.wmf");
		washPath.add("Symb/tp.wmf");
		
	}
	
	void setStitchData(){
		stitchPath.add("Symb/6tr.wmf");
		stitchPath.add("Symb/3tr.wmf");
		stitchPath.add("Symb/2tr.wmf");
		stitchPath.add("Symb/1tr.wmf");
		stitchPath.add("Symb/efterst.wmf");
		stitchPath.add("Symb/halsom.wmf");
		stitchPath.add("Symb/kedjesom.wmf");
		stitchPath.add("Symb/knutar.wmf");
		stitchPath.add("Symb/korsst.wmf");
		stitchPath.add("Symb/langett.wmf");
		stitchPath.add("Symb/plattsom.wmf");
		stitchPath.add("Symb/schatter.wmf");
		stitchPath.add("Symb/stjalkst.wmf");
		stitchPath.add("Symb/oglest.wmf");
		stitchPath.add("Symb/aoglest.wmf");
		
		stitchHoriz.add(true);
		stitchHoriz.add(true);
		stitchHoriz.add(true);
		stitchHoriz.add(true);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
		stitchHoriz.add(false);
	}
	
	void clearWashData(){
		washData.clear();
	}
	
	void setClearFlag(Boolean input){
		clearFlag = input;
	}
	
	Boolean getClearFlag(){
		return clearFlag;
	}
	
	
	void generatePDF(String filename){
		System.out.println("Creating PDF...");
		
		setWashData();
		setStitchData();
		
		Font font8n = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);
		//Font font8b = FontFactory.getFont(FontFactory.TIMES_BOLD, 8);
		Font font11n = FontFactory.getFont(FontFactory.HELVETICA, 11);
		Font font24b = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24);
		Font font11b = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11);
		
		Document document = new Document(PageSize.A4, 0, 0, 20, 0);
		try {
		      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
		      writer.flush();
		      document.open();
		   
		     		     
		      
		      //HEADER TABLE
		      String artcat = new String(article + " " + artnr);
		      
		      Phrase boomcat = new Phrase(artcat, font24b);
		      if(artother == null){
		    	  artother = " ";
		      }
		      Phrase boomfil = new Phrase(artother, font11n);
		      
		      PdfPTable table = new PdfPTable(2);
		      table.setWidthPercentage(92.0f);
		      table.setSpacingBefore(0.0f);
		      float[] widths = {0.7f, 0.3f};
		      table.setWidths(widths);
		      table.getDefaultCell().setBorderColor(new Color(255, 255, 255));
		      
		      PdfPTable table2 = new PdfPTable(1);
		      PdfPCell cell = new PdfPCell();		      
		      cell = new PdfPCell(boomcat);
		      cell.setBorder(0);
		      table2.addCell(cell);
		    		      
		      cell = new PdfPCell(boomfil);
		      cell.setBorder(0);
		      table2.addCell(cell);		      
		      table.addCell(table2); 
		      
		      table2 = new PdfPTable(1);
		      Image img = Image.getInstance("Symb/iltex.wmf");
		      img.scalePercent(86);
		      cell = new PdfPCell(img);
		      cell.setBorder(0);
		      table2.addCell(cell);
		      cell = new PdfPCell(new Phrase("www.iltex.com",font11b));
		      cell.setBorder(0);
		      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		      cell.setLeading(0.0f,0.6f);
		      table2.addCell(cell);		      
		      table.addCell(table2);
		      
		      document.add(table);
		      
		      //DESCRIPTION TABLE
		      String artapp = new String("");
		      String artext = new String("");
		      if(size != ""){
		    		  artapp += "Storlek\\Size\\Grösse\\Koko:\n";
		    		  artext += size + "\n";
		      }
		      if(fabric != ""){
		    		  artapp += "Väv\\Fabric\\Gewebe\\Kangas:\n";
		    		  artext += fabric + "\n";
		      }
		      if(yarn != ""){			  
		    		  artapp += "Garn\\Yarn\\Garn\\Lanka:\n";
		    		  artext += yarn + "\n";
		      }
		      if(design != ""){
		    		  artapp += "Design:\n";
		    		  artext += design + "\n";
		      }
		      		      
		      Phrase boomapp = new Phrase(artapp, font11b);
		      Phrase boomext = new Phrase(artext, font11n);
		    
		      table = new PdfPTable(2);
		      table.setWidthPercentage(92.0f);
		      table.setSpacingBefore(0.0f);
		      float[] widths2 = {0.30f, 0.70f};
		      table.setWidths(widths2);
		      //table.getDefaultCell().setBorderColor(new Color(255, 255, 255));
		      
		      cell = new PdfPCell(boomapp);
		      cell.setBorder(0);
		      table.addCell(cell);
		      
		      cell = new PdfPCell(boomext);
		      cell.setBorder(0);
		      table.addCell(cell);
		      
		      document.add(table);
		        
		     
		      //THE YARN CONSUMPTION TABLE
		      Phrase aphrase1 = new Phrase("Garnåtgång\\Yarnconsumption\\Garnferbrauch\\Langankulutus: 1 TR = " + trLength + " Meter", font11n);
		      //Phrase aphrase2 = new Phrase("Right Space", font11n);
		      		      
		      table = new PdfPTable(2);
		      table.setWidthPercentage(92.0f);
		      table.setSpacingBefore(10.0f);
		      float[] widths3 = {0.8f, 0.2f};
		      table.setWidths(widths3);
		      table.getDefaultCell().setBorderColor(new Color(255, 255, 255));
		      //table.getDefaultCell().setBorderColor(new Color(0, 0, 0));
		      
		      table2 = new PdfPTable(4);
		      table2.setSpacingBefore(0.0f);
		      float[] widths4 = {0.05f, 0.73f,0.11f,0.11f};
		      table2.setWidths(widths4);
		      table2.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);
		      table2.getDefaultCell().setPadding(3);
		      table2.getDefaultCell().setLeading(0.0f,0.7f);
		      		      
		      cell = new PdfPCell(aphrase1);
		      cell.setBorder(0);
		      cell.setColspan(4);
		      cell.setPadding(4);
		      table2.addCell(cell);
		      
		      table2.addCell("");
		      table2.addCell("Färg\\Colour\\Farbe\\Väri");
		      table2.addCell("Anchor");
		      table2.addCell("Trådar");
		      for(int i = 0; i < yarnList.size(); i++){
		    	  //Makes a choice here about numbering
		    	  if(numbers)
		    		  table2.addCell(new Phrase(String.format("%d", i+1) ,font11n));
		    	  else
		    		  table2.addCell(new Phrase("" ,font11n));
		    	  
		    	  table2.addCell(new Phrase((yarnList.get(i)).toString(),font11n));
		    	  table2.addCell(new Phrase((yarnAnchor.get(i)).toString(),font11n));
		    	  table2.addCell(new Phrase((yarnContent.get(i)).toString(),font11n));
		      }		      
		      		      
		      table.addCell(table2); 
		      
		      //Stitch Part
		      //TODO This is the Right part (reserve), only applicable when yarnRows > 6 (?)
		      cell = new PdfPCell(new Phrase(""));
		      cell.setBorder(0);
		      table.addCell(cell);
		      
		      //This is the bottom part
		      table2 = new PdfPTable(4);
		      table2.setSpacingBefore(0.0f);
		      float[] widths8 = {0.25f, 0.25f,0.25f,0.25f};
		      table2.setWidths(widths8);
		      
		      int counter = 0;
		      String bertil;
		      PdfPTable table3 = new PdfPTable(1);
		      String filen = "";
		      int rows = 0;
			  if(getLanguage() == workDescription.SV_EN_TY_FI){
				  filen = "Lang/stit_SETF.txt";
				  rows = 4;
			  }
			  else if(getLanguage() == workDescription.NO_DA){
				  filen = "Lang/stit_ND.txt";
				  rows = 2;
			  }
		      Scanner sa = new Scanner(new File(filen));
		      for(int a = 0; a < stitchList.size(); a++){
		    	  bertil = "";
		    	  for(int b = 0; b < rows; b++){
					  bertil += sa.nextLine() + "\n";
		    	  }
		    	  //System.out.println(bertil);
		    	  if(stitchList.get(a) == true){
		    		  img = Image.getInstance(stitchPath.get(a));
		    		  img.scalePercent(90);
		    		  
		    		  //Orientation of texts and the symbols individual tables
		    		  //TODO Does not do the trick for now!
		    		  //
		    		  /*if(stitchHoriz.get(a))
		    			  table3 = new PdfPTable(2);
		    		  else
		    			  table3 = new PdfPTable(1);*/
		    		  table3 = new PdfPTable(1);
		    		  
		    		  cell = new PdfPCell(img);
		    		  cell.setVerticalAlignment(1);
		    		  cell.setBorder(0);
		    		  table3.addCell(cell);
		    		  
		    		  cell = new PdfPCell(new Phrase(bertil,font8n));
				      cell.setBorder(0);				      
				      cell.setLeading(0.0f, 0.9f);
		    		  
		    		  table3.addCell(cell);
		    		  
		    		  cell = new PdfPCell(table3);
				      cell.setBorder(0);
				   
		    		  
		    		  table2.addCell(cell);
		    		  counter++;
		    	  }		    	  
		      }
		      sa.close();
		      //System.out.println(counter);
		      //System.out.println(counter % 4);
		      for(int a = 0; a < 4 - (counter % 4);a++){
		    	  cell = new PdfPCell(new Phrase(""));
			      cell.setBorder(0);
			      table2.addCell(cell);
		      }
		      
		      cell = new PdfPCell(table2);
		      cell.setBorder(0);
		      cell.setColspan(2);
		      
		      table.addCell(cell);
		      
		      document.add(table);
		      
		      
		      //BOTTOM TABLE		      
		      table = new PdfPTable(2);
		      table.setWidthPercentage(92.0f);
		      table.setSpacingBefore(10.0f);
		      float[] widths5 = {0.45f, 0.55f};
		      table.setWidths(widths5);
		      table.getDefaultCell().setBorderColor(new Color(255, 255, 255));
		      
		      int boris = 0;
		      for(int a = 0; a < washData.size(); a++){
		    	  if(washData.get(a) == true){
		    		  boris++;
		    	  }
		      }
		      //System.out.println(boris);
		      float[] widths6 = new float[boris + 1];
		      
		      for(int a = 0; a < boris; a++){
		    	  widths6[a] = 0.12f;
		      }
		      widths6[boris] = 1.00f - (float)(boris) * 0.12f; 
		    	  
		      table2 = new PdfPTable(boris + 1);
		      table2.setSpacingBefore(0.0f);
		      table2.setHorizontalAlignment(0);
		      
		      //table2.getDefaultCell().setBorderColor(new Color(0, 0, 0));
		      
		      table2.setWidths(widths6);
		      
		      for(int a = 0; a < washData.size(); a++){
		    	  if(washData.get(a) == true){
		    		  img = Image.getInstance(washPath.get(a));
		    		  img.scalePercent(85);
		    		  cell = new PdfPCell(img);
		    		  cell.setVerticalAlignment(1);
		    		  
		    		  if(washData.size() > 1)
		    			  cell.setBorder(3); //Sets the upper & lower lines
		    		  
		    		  cell.setUseAscender(true);		    		  
		    		  table2.addCell(cell);		
		    	  }		    	  
		      }
		      cell = new PdfPCell(new Phrase(""));
		      cell.setBorder(0);
		      table2.addCell(cell);
		   
		      table.addCell(table2); 
		      
		      if(printText){
			      table2 = new PdfPTable(2);
			      table2.setSpacingBefore(0.0f);
			      float[] widths7 = {0.11f, 0.89f};
			      table2.setWidths(widths7);
			      
			      img = Image.getInstance("Symb/varnt.wmf");
			      img.scalePercent(85);
			      cell = new PdfPCell(img);
			      cell.setBorder(0);
			      table2.addCell(cell);		
			      
			      cell = new PdfPCell();
			      cell.setBorder(0);
			      cell.setLeading(0.0f, 0.9f);
			      String adam = new String("");
			      //table2.getDefaultCell().setLeading(0.0f, 0.0f);
			      filen = new String("");
				  if(getLanguage() == workDescription.SV_EN_TY_FI)
					  filen = "Lang/advice_SETF.txt";
				  else if(getLanguage() == workDescription.NO_DA)
					  filen = "Lang/advice_ND.txt";
			      Scanner sc = new Scanner(new File(filen));
				  while(sc.hasNextLine()){
					  adam += sc.nextLine() + "\n";
					  //cell.addElement(new Phrase(sc.nextLine() + "\n", font7n));
					  //System.out.println("Lang/advice_SETF.txt");
				  }		      
				  sc.close();
				  cell.setPhrase(new Phrase(adam, font8n));
			      table2.addCell(cell);
			      
			      table.addCell(table2);
		      }
		      else{
		    	  cell = new PdfPCell();
			      cell.setBorder(0);
		    	  table.addCell(cell);
		      }
		    	  
		      if(bottomText){
			      cell = new PdfPCell();
			      cell.setBorder(0);
			      cell.setColspan(2);
			      cell.setLeading(0.0f, 0.9f);
			      String adam = new String("");
			      filen = new String("");
				  if(getLanguage() == workDescription.SV_EN_TY_FI)
					  filen = "Lang/complaints_SETF.txt";
				  else if(getLanguage() == workDescription.NO_DA)
					  filen = "Lang/complaints_ND.txt";
			      Scanner sc = new Scanner(new File(filen));
				  while(sc.hasNextLine()){
					  adam += sc.nextLine() + "\n";
					  //System.out.println(adam);
				  }		      
				  sc.close();
				  cell.setPhrase(new Phrase(adam, font8n));
			      table.addCell(cell);
		      }
			  else{
				  cell = new PdfPCell();
			      cell.setBorder(0);
			      cell.setColspan(2);
			      table.addCell(cell);
			  }
		      
		      table.setHorizontalAlignment(0);
			  table.setTotalWidth((document.getPageSize().width() / 100) * 92);
			  table.setLockedWidth(true);
		      table.writeSelectedRows(0, -1, (document.getPageSize().width() / 100) * 4, (document.getPageSize().height() / 100) * 11, writer.getDirectContent());
		      		      
		      document.close();
		      
		      System.out.println("PDF Successfully Created!");
		      clearWashData();
		}
	    catch (Exception de) {
	      de.printStackTrace();
	    }
	}
	
	
}
