

package xxx;
/*Sandy has edit the code*/
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class Main extends JFrame{

	private JFrame main;
	private JPanel panel;
	private JLabel drawlinelbl;
	private JLabel drawpolylbl;
	private JLabel drawcirclelbl;
	private JLabel draweclipselbl;
	private JLabel linestyle;
	private JComboBox ComboAttr;
	private JButton btnDDA;
	private JButton btnBLA;
	private JButton btnregular;
	private JButton btnirregular;
	private JButton btncircle;
	private JButton btnellipse;
	private JTextField scalex;
	private JTextField scaley;
	private JButton btnscale;
	private JLabel bres;
	private JLabel bres2;
	public int thickness=1; //default thickness
	public int side=3;  //default number of sides
	public int x=1;  //default x axis scale
	public int y=1;  //default y axis scale



	public Main(){

		main = new JFrame("Main Menu");

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		main.add(panel,BorderLayout.CENTER);

		//Combo box for different line styles
		ComboAttr = new JComboBox();
		ComboAttr.addItem("Solid");
		ComboAttr.addItem("Dotted");
		ComboAttr.addItem("Dashed");
		ComboAttr.setMaximumRowCount(3);

		//defining all controls(button,labels,text field) used in the panel
		drawlinelbl = new JLabel("Draw line");
		drawlinelbl.setFont(new Font("Arial",Font.PLAIN,20));
		linestyle = new JLabel("Line Style");
		btnDDA = new JButton("DDA");
		btnBLA = new JButton("BRESENHAM");
		drawpolylbl = new JLabel("Draw polygon");
		drawpolylbl.setFont(new Font("Arial",Font.PLAIN,20));
		drawcirclelbl = new JLabel("Draw circle");
		drawcirclelbl.setFont(new Font("Arial",Font.PLAIN,20));
		draweclipselbl = new JLabel("Draw ecllipse");
		draweclipselbl.setFont(new Font("Arial",Font.PLAIN,20));
		btnregular = new JButton("Regular");
		btnirregular = new JButton("Irregular");
		btncircle = new JButton("Draw circle");
		btnellipse = new JButton("Draw ellipse");
		scalex = new JTextField("Scale x");
		scaley = new JTextField("Scale y");
		btnscale = new JButton("Set Scale");
		bres = new JLabel("[using bresenham mid-point circle algo]");
		bres2 = new JLabel("[using bresenham mid-point circle algo]");


		//setting position of controls
		drawlinelbl.setBounds(50, 100,800, 30);
		linestyle.setBounds(300, 100, 200, 30);
		ComboAttr.setBounds(400, 100, 100,30);
		btnDDA.setBounds(300, 140, 200, 30);
		btnBLA.setBounds(300, 180, 200, 30);
		drawpolylbl.setBounds(50,260 , 200, 30);
		drawcirclelbl.setBounds(50,380 , 800, 30);
		draweclipselbl.setBounds(50,460 , 800, 30);
		btnregular.setBounds(300, 260, 200, 30);
		btnirregular.setBounds(300, 300, 200, 30);
		btncircle.setBounds(300, 380, 200, 30);
		btnellipse.setBounds(300, 460, 200, 30);
		scalex.setBounds(150,30,50,30);
		scaley.setBounds(200, 30, 50, 30);
		btnscale.setBounds(270, 30, 120, 30);
		bres.setBounds(50,400,800,30);
		bres2.setBounds(50,480,800,30);

		//adding controls to panel
		panel.setLayout(null);
		panel.add(drawlinelbl);
		panel.add(ComboAttr);
		panel.add(btnDDA);
		panel.add(btnBLA);
		panel.add(linestyle);
		panel.add(drawpolylbl);
		panel.add(drawcirclelbl);
		panel.add(draweclipselbl);
		panel.add(btnregular);
		panel.add(btnirregular);
		panel.add(btncircle);
		panel.add(btnellipse);
		panel.add(scalex);
		panel.add(scaley);
		panel.add(btnscale);
		panel.add(bres);
		panel.add(bres2);

		//adding buttons to method action listener
		ComboAttr.addActionListener(new Action());
		btnBLA.addActionListener(new Action());
		btnDDA.addActionListener(new Action());
		btnregular.addActionListener(new Action());
		btnirregular.addActionListener(new Action());
		btncircle.addActionListener(new Action());
		btnellipse.addActionListener(new Action());
		btnscale.addActionListener(new Action());



		//
		main.setVisible(true);
		main.setSize(600, 600);
		main.setResizable(false);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	}

	private class Action implements ActionListener,ItemListener{

		public void actionPerformed (ActionEvent e){


			if((e.getSource()==btnDDA) && (ComboAttr.getSelectedItem()=="Solid")){

				//Using JOptionPane to get values for thickness of line
				//Using try catch to catch exceptions
				try{
					
					String thk = JOptionPane.showInputDialog("Enter thickness");
					int number = Integer.parseInt(thk);    //converts String thk to int number 
					if(number>0 &&  number<100){
						thickness=number;
					}
					else{
						thickness=1;
					}
				}
				catch(NumberFormatException e1){};


				/*SolidDDA frameDDA = new SolidDDA(thickness,x,y);
				frameDDA.setSize(1200,700);
				frameDDA.setResizable(false);
				frameDDA.setVisible(true);*/
			}

			
			else if((e.getSource()==btnDDA) && (ComboAttr.getSelectedItem()=="Dotted")){

				//Using JOptionPane to get values for thickness of line
				//Using try catch to catch exceptions
				try{
					String thk = JOptionPane.showInputDialog("Enter thickness");
					int number = Integer.parseInt(thk);
					if(number>0 &&  number<100){
						thickness=number;
					}
					else{
						thickness=1;
					}
				}
				catch(NumberFormatException e1){};


			/*	DottedDDA frameDDA = new DottedDDA(thickness,x,y);
				//frameDDA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameDDA.setSize(1200,700);
				frameDDA.setResizable(false);
				frameDDA.setVisible(true);*/
			}
			

			else if((e.getSource()==btnDDA) && (ComboAttr.getSelectedItem()=="Dashed")){

				//Using JOptionPane to get values for thickness of line
				//Using try catch to catch exceptions
				try{
					String thk = JOptionPane.showInputDialog("Enter thickness");
					int number = Integer.parseInt(thk);
					if(number>0 &&  number<100){
						thickness=number;
					}
					else{
						thickness=1;
					}
				}
				catch(NumberFormatException e1){};


		/*		DashedDDA frameDDA = new DashedDDA(thickness,x,y);
				//frameDDA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameDDA.setSize(1200,700);
				frameDDA.setResizable(false);
				frameDDA.setVisible(true);*/
			}

			else if((e.getSource()==btnBLA) && (ComboAttr.getSelectedItem()=="Solid")){

				//Using JOptionPane to get values for thickness of line
				//Using try catch to catch exceptions
				try{
					String thk = JOptionPane.showInputDialog("Enter thickness");
					int number = Integer.parseInt(thk);
					if(number>0 &&  number<100){
						thickness=number;
					}
					else{
						thickness=1;
					}
				}
				catch(NumberFormatException e1){};


			/*	SolidBLA frameBLA = new SolidBLA(thickness,x,y);
				//frameBLA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameBLA.setSize(1220, 700);
				frameBLA.setResizable(false);
				frameBLA.setVisible(true);*/
			}

			else if((e.getSource()==btnBLA) && (ComboAttr.getSelectedItem()=="Dashed")){

				//Using JOptionPane to get values for thickness of line
				//Using try catch to catch exceptions
				try{
					String thk = JOptionPane.showInputDialog("Enter thickness");
					int number = Integer.parseInt(thk);
					if(number>0 &&  number<100){
						thickness=number;
					}
					else{
						thickness=1;
					}
				}
				catch(NumberFormatException e1){};


			/*	DashedBLA frameBLA = new DashedBLA(thickness,x,y);
				//frameBLA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameBLA.setSize(1220, 700);
				frameBLA.setResizable(false);
				frameBLA.setVisible(true);*/
			}

			else if((e.getSource()==btnBLA) && (ComboAttr.getSelectedItem()=="Dotted")){

				//Using JOptionPane to get values for thickness of line
				//Using try catch to catch exceptions
				try{
					String thk = JOptionPane.showInputDialog("Enter thickness");
					int number = Integer.parseInt(thk);
					if(number>0 &&  number<100){
						thickness=number;
					}
					else{
						thickness=1;
					}
				}
				catch(NumberFormatException e1){};


				/*DottedBLA frameBLA = new DottedBLA(thickness,x,y);
				//frameBLA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameBLA.setSize(1220, 700);
				frameBLA.setResizable(false);
				frameBLA.setVisible(true);*/
			}

			else if(e.getSource()==btnregular){

				//Using JOptionPane to get values for thickness of line
				//Using try catch to catch exceptions
				try{
					String sde = JOptionPane.showInputDialog("Enter number of sides");
					int sides = Integer.parseInt(sde);
					side=sides;
				}
				catch(NumberFormatException e1){};

			/*	Regular frame = new Regular(side,x,y);
				frame.setSize(1200, 700);
				frame.setResizable(false);
				frame.setVisible(true);*/
			}

			else if(e.getSource()==btnirregular){
			/*	Irregular irrframe = new Irregular(x,y);
				irrframe.setSize(1200, 700);
				irrframe.setResizable(false);
				irrframe.setVisible(true);	*/
			}

			else if(e.getSource()==btncircle){
				/*BCA frame = new BCA(x,y);
				frame.setSize(1200, 700);
				frame.setResizable(false);
				frame.setVisible(true);*/
			}

			else if(e.getSource()==btnellipse){
				/*BEA frame1 = new BEA(x,y);
				frame1.setSize(1200, 700);
				frame1.setResizable(false);
				frame1.setVisible(true);*/
			}

			else if(e.getSource()==btnscale){
				/*x=Integer.parseInt(scalex.getText());
				y=Integer.parseInt(scaley.getText());*/
			}
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			// TODO Auto-generated method stub

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main();  //instatiating main

	}
	
}


