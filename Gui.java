
package sdmcet.cse.oops;


import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

class calculator extends JFrame implements ActionListener {
	int r,res,x;
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton b2,b1;
	JTextField t1,t2,t3,t4,t5;
	Container contentPane;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9;
	calculator(){
		setTitle("Students Grading System");
		l=new JLabel("Grade Calculator");
		l2=new JLabel("Enter IA-1 Marks: ");
		l3=new JLabel("Enter IA-2 Marks: ");
		l4=new JLabel("Enter IA-3 Marks: ");
		l5=new JLabel("Enter CTA Marks: ");
		l6=new JLabel("Enter SEE Marks: "); 
		l7=new JLabel();
		l7.setText("");
		l8=new JLabel();
		l8.setText("");
		l10=new JLabel("   ");
		b2= new JButton("Check Eligibilty");
		b1=new JButton("     calculate    ");
		b1.addActionListener(this);
		b2.addActionListener(this);
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JTextField(10);
		t5=new JTextField(10);
		

		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p9=new JPanel();

		p1.add(l);
		p2.add(l2);
		p2.add(t1);
		p3.add(l3);
		p3.add(t2);
		p4.add(l4);
		p4.add(t3);
		p5.add(l5);
		p5.add(t4);
		p9.add(b1);
		p6.add(l6);
		p6.add(t5);
		p7.add(b2);
		p8.add(l7);
		p8.add(l10);
		p8.add(l8);

		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p7);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int a,b,c,d;
		double f = 0;
		if(e.getSource()==b2) {

			if(t1.getText().isEmpty()) a=0;
			else a=Integer.parseInt(t1.getText());

			if((t2.getText()).isEmpty()) b=0;
			else b=Integer.parseInt(t2.getText());

			if(t3.getText().isEmpty()) c=0;
			else c=Integer.parseInt(t3.getText());

			if(t4.getText().isEmpty()) d=0;
			else d=Integer.parseInt(t4.getText());

			if(a>20 || a<0 ) {
				JOptionPane.showMessageDialog(this, "entered invalid IA-1 marks","error", JOptionPane.ERROR_MESSAGE);
				t1.setText("");
				return;
			}

			if(b>20 || b<0) {
				JOptionPane.showMessageDialog(this, "entered invalid IA-2 marks","error", JOptionPane.ERROR_MESSAGE);
				t2.setText("");
				return;
			}

			if(c>20 || c<0 ){
				JOptionPane.showMessageDialog(this, "entered invalid IA-3 marks","error", JOptionPane.ERROR_MESSAGE);
				t3.setText("");
				return;
			}
			if(d>10 || d<0) {
				JOptionPane.showMessageDialog(this, "entered invalid CTA marks","error", JOptionPane.ERROR_MESSAGE);
				t4.setText("");
				return;
			}
			if(b>=a && c>=a ) {
				r=b+c+d;
			}
			else if(a>=b && c>=b) {
				r=a+c+d;
			}
			else {
				r=a+b+d;
			}
						
			try {
				if(r<20) {
					throw new Exception();
				}
			}
			catch(Exception ae) {
				JOptionPane.showMessageDialog(this, "Student is Detained from taking SEE","message", JOptionPane.PLAIN_MESSAGE);
				return;	
			}
		}

		setBounds(0, 0, 599, 499);

		add(p6);
		add(p9);
		add(p8);
       
		if(e.getSource()==b1) {
           
			if(t5.getText().isEmpty()) f=0;
			else f=Integer.parseInt(t5.getText());

			if(f>100 || f<0) {
				JOptionPane.showMessageDialog(this, "entered invalid SEE marks","error", JOptionPane.ERROR_MESSAGE);
				t5.setText("");
				l8.setText("");
				l7.setText("");
				return;
			}
			String g;
			
				if(f<38) {
				l8.setText("Grade: F");
				l7.setText("");
				//add(p8);
				setBounds(0, 0, 597, 497);
				return ;
			}
			if(f==38 || f==39) {
				f=40;
				}

			f=(f/2);
			x=(int) Math.ceil(f);
				res=r+x;
			if(res<=100 && res>=90)
				g="S";

			else if(res<90 && res>=80)
				g="A";

			else if(res<80 && res>=70)
				g="B";

			else if(res<70 && res<=60)
				g="C";
			else if(res<60 && res<=50)
				g="D";
			else if(res<50 && res<=40)
				g="E";
			else
				g="F";

			l7.setText("Total Marks: "+res);;
			l8.setText("Grade: "+g);
			setBounds(0, 0, 598, 498);
			}
	}
}
public class Gui {

	public static void main(String[] args) {
		JFrame c1 = new calculator();

	
		
		c1.setVisible(true);
		c1.setBounds(0, 0, 500, 400);
		
		c1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		c1.setLayout(new GridLayout(10,0));
		return;
	}
}


