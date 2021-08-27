import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Interfata extends JFrame implements ActionListener {

	JPanel mainPanel;
	JTabbedPane tabbedPane;
	JComponent panelComponent1;
	JComponent panelComponent2;
	JComponent panelComponent3;
	JComponent panelComponent4;
	JComponent panelComponent5;
	
	//LOGIN
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JLabel labelNume;
	JLabel labelParola;
	
	JPasswordField textInserare2;
	JTextField textInserare1;
//	JTextField textInserare2;
	ButonLogin butonLogin ;
	//END LOGIN PANEL -------------
	
	//PANEL REGISTER
	JPanel panel4;
	JPanel panel5;
	JPanel panel6;
	JPanel panel7;
	JLabel labelNumeReg;
	JLabel labelParolaReg;
	JLabel labelRepetaParolaReg;
	
	JTextField textInserare3;
	JPasswordField textInserare4;
	JPasswordField textInserare5;
	ButonInregistrare butonInregistrare;
	
	//END PANEL REGISTER
	
	//PANEL CREARE JURNAL
	JPanel panel8;
	JPanel panel9;
	JPanel panel10;
	JLabel labelNumeJurnal;
	JLabel continutJurnal;
	
	JTextField textInserare6;
	JTextArea textInserare7;
	ButonCreareJurnal butonCreareJurnal;
	
	//END PANEL JURNAL
	
	//PANEL MODIFICARE JURNAL
	JPanel panel11;
	JPanel panel12;
	JPanel panel13;
	JPanel panel14;
	JLabel labelSelectJurnale;
	JLabel labelContinut;
	
	ComboJurnale comboJurnale;
	//Continut continut;
	JTextArea textInserare8;
	
	ButonModificareJurnal butonModificareJurnal;
	//END PANEL MODFICARE JURNAL
	
	//PANEL DELETE JURNAL
	
	//END PANEL DELETE JURNAL
	
	
	public Interfata(){
		mainPanel=new JPanel();
		tabbedPane=new JTabbedPane();
		//panel login 
		panelComponent1=new JPanel();
		tabbedPane.addTab("Login",null,panelComponent1,"Login");
		panel1=new JPanel();
		panel2=new JPanel();
		panel3=new JPanel();
		
		
		labelNume=new JLabel("Username:");
		textInserare1=new JTextField(10);
		textInserare1.setEditable(true);
		panel1.add(labelNume);
		panel1.add(textInserare1);
		
		labelParola=new JLabel("Parola:");
		textInserare2=new JPasswordField(10);
		textInserare2.setEditable(true);
		panel2.add(labelParola);
		panel2.add(textInserare2);
		
		butonLogin=new ButonLogin(textInserare1,textInserare2);
		butonLogin.setText("Login");
		panel3.add(butonLogin);
		butonLogin.addActionListener(this);
		
		panelComponent1.add(panel1);
		panelComponent1.add(panel2);
		panelComponent1.add(panel3);
		panelComponent1.add(butonLogin);
		panelComponent1.setLayout(new BoxLayout(panelComponent1,BoxLayout.Y_AXIS));
		//end panel login
		
		//panel register
		panelComponent2=new JPanel();
		tabbedPane.addTab("Register",null,panelComponent2,"Register");
		panel4=new JPanel();
		panel5=new JPanel();
		panel6=new JPanel();
		panel7=new JPanel();
		
		
		labelNumeReg=new JLabel("Username:");
		textInserare3=new JTextField(10);
		textInserare3.setEditable(true);
		panel4.add(labelNumeReg);
		panel4.add(textInserare3);
		
		labelParolaReg=new JLabel("Parola:");
		textInserare4=new JPasswordField(10);
		textInserare4.setEditable(true);
		panel5.add(labelParolaReg);
		panel5.add(textInserare4);
		
		labelRepetaParolaReg=new JLabel("Repeta parola:");
		textInserare5=new JPasswordField(10);
		textInserare5.setEditable(true);
		panel6.add(labelRepetaParolaReg);
		panel6.add(textInserare5);
		
		butonInregistrare=new ButonInregistrare(textInserare3,textInserare4,textInserare5);
		butonInregistrare.setText("Register");
		panel7.add(butonInregistrare);
		butonInregistrare.addActionListener(this);
		
		panelComponent2.add(panel4);
		panelComponent2.add(panel5);
		panelComponent2.add(panel6);
		panelComponent2.add(panel7);
		panelComponent2.add(butonInregistrare);
		panelComponent2.setLayout(new BoxLayout(panelComponent2,BoxLayout.Y_AXIS));
		
		//end panel register
		
		//strat panel creare jurnal
		
		
		panelComponent3=new JPanel();
		tabbedPane.addTab("Creare Jurnal",null,panelComponent3,"Creare Jurnal");
		panel8=new JPanel();
		panel9=new JPanel();
		panel10=new JPanel();
		
		
		labelNumeJurnal=new JLabel("Titlu jurnal:");
		textInserare6=new JTextField(10);
		textInserare6.setEditable(true);
		panel8.add(labelNumeJurnal);
		panel8.add(textInserare6);
		
		continutJurnal=new JLabel("Continut:");
		textInserare7=new JTextArea(50,50);
	
		textInserare7.setEditable(true);
		panel9.add(continutJurnal);
		panel9.add(textInserare7);

		
		butonCreareJurnal=new ButonCreareJurnal(textInserare6,textInserare7);
		butonCreareJurnal.setText("Create");
		panel10.add(butonCreareJurnal);
		butonCreareJurnal.addActionListener(this);
		
		panelComponent3.add(panel8);
		panelComponent3.add(panel9);
		panelComponent3.add(panel10);
		panelComponent3.add(butonCreareJurnal);
		panelComponent3.setLayout(new BoxLayout(panelComponent3,BoxLayout.Y_AXIS));
		
		//end panel creare jurnal
		
		//panel modificare jurnal
		panelComponent4=new JPanel();
		tabbedPane.addTab("Modificare Jurnal",null,panelComponent4,"Modificare jurnal");
		panel11=new JPanel();
		panel12=new JPanel();
		panel13=new JPanel();
		panel14=new JPanel();
		
		labelSelectJurnale=new JLabel("MODIFICARE JURNAL");
		panel11.add(labelSelectJurnale);
		
		
	/**	labelContinut=new JLabel("descriere");
		continut=new Continut(comboJurnale);
		panel12.add(labelContinut);
		panel12.add(continut);**/
		
		
		labelContinut=new JLabel("descriere");
		textInserare8=new JTextArea(50,50);
		panel12.add(labelContinut);
		panel12.add(textInserare8);
		
		
		comboJurnale=new ComboJurnale(textInserare8);
		panel13.add(comboJurnale);
		comboJurnale.addActionListener(this);
		
		butonModificareJurnal= new ButonModificareJurnal(comboJurnale,textInserare8);
		panel14.add(butonModificareJurnal);
		butonModificareJurnal.addActionListener(this);
	
		

	
		panelComponent4.add(panel11);
		panelComponent4.add(panel13);
		panelComponent4.add(panel12);
		panelComponent4.add(panel14);
		panelComponent4.setLayout(new BoxLayout(panelComponent4,BoxLayout.Y_AXIS));
		//end panel modificare jurnal
		
	mainPanel.add(tabbedPane);	
	this.add(mainPanel);
	mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
	this.setSize(1300,600);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		((Command)e.getSource()).execute();
		
	}
}
