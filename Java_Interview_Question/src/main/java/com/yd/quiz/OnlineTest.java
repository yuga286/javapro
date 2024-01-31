package com.yd.quiz;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class OnlineTest extends JFrame implements ActionListener{
	private static final long serialVersionUID=1L;
	
	JLabel lable;
	JRadioButton radioButton[]=new JRadioButton[5];
	JButton btnNext,btnResult;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];
	
	//cretating the jfream using radiobutton and jbutton

	public OnlineTest(String s) {
		super(s);
		lable=new JLabel();
		add(lable);
		bg=new ButtonGroup();
		for (int i=0;i<5;i++) {
			radioButton[i]=new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext=new JButton("Next");
		btnResult=new JButton("Result");
		btnResult.setVisible(false);
		btnNext.addActionListener(this);
		btnResult.addActionListener(this);
		add(btnNext);
		add(btnResult);
		set();
		lable.setBounds(30,40,450,20);
		radioButton[0].setBounds(50,80,200,20);
		radioButton[1].setBounds(50,110,450,20);
		radioButton[2].setBounds(50,140,200,20);
		radioButton[3].setBounds(50,170,200,20);
		btnNext.setBounds(100, 240, 100, 30);
		btnResult.setBounds(270,740,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}
	//handle all actions based on event
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnNext) {
			if(check())
				count=count+1;
			current++;
			set();
			if(current==9) {
				btnNext.setEnabled(false);
				btnResult.setVisible(true);
				btnResult.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Result")) {
			if(check())
				count=count+1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers="+count);
			System.exit(0);
			
		}
	}
	//set question with options
	void set() {
		radioButton[4].setSelected(true);
		if(current==0) {
			lable.setText("Which Set class should be most popular in a multi-threading environment, considering performance constraint?");
			radioButton[0].setText("HashSet");
			radioButton[1].setText("ConcurrentSkipListSet");
			radioButton[2].setText("LinkedHashSet");
			radioButton[3].setText("CopyOnWriteArraySet");
		}
		if(current==1) {
			lable.setText("Which Map class should be most popular in a multi-threading environment, considering performance constraint?");
			radioButton[0].setText("Hashtable");
			radioButton[1].setText("CopyOnWriteMap");
			radioButton[2].setText("ConcurrentHashMap");
			radioButton[3].setText("ConcurrentMap");
		}
		if(current==2) {
			lable.setText("Which allows the removal of elements from a collection?");
			radioButton[0].setText(" Enumeration");
			radioButton[1].setText(" Iterator");
			radioButton[2].setText("Both");
			radioButton[3].setText("None of the above");
		}
		if(current==3) {
			lable.setText("The Comparator interface contains the method?");
			radioButton[0].setText(" compareWith");
			radioButton[1].setText(" compareTo()");
			radioButton[2].setText(" compare()");
			radioButton[3].setText("None");
		}
		if(current==4) {
			lable.setText("Which of those is synchronized?");
			radioButton[0].setText("TreeMap");
			radioButton[1].setText("HashMap");
			radioButton[2].setText("Hashtable");
			
		}
		if(current==5) {
		lable.setText("Which offers the best performance?");
			radioButton[0].setText("TreeMap");
			radioButton[1].setText("HashMap");
			radioButton[2].setText("LinkedHashMap");
		}
		if(current==6) {
			lable.setText("Which of these is the most popularly used class as a key in a HashMap?");
			radioButton[0].setText("String");
			radioButton[1].setText("Integer");
			radioButton[2].setText("Double");
			radioButton[3].setText("All of the above");
		}
		if(current==7) {
			lable.setText("What should we use when add and remove operations are more frequent than get operations");
			radioButton[0].setText("LinkedList");
			radioButton[1].setText("ArrayList");
			radioButton[2].setText("Vector");
			
		}if(current==8) {
			lable.setText("Which of those doesn’t have an index based structure?");
			radioButton[0].setText(" List");
			radioButton[1].setText("Set");
			radioButton[2].setText("Map");
			radioButton[3].setText("None");
		}if(current==9) {
			lable.setText("java.util.Collections is a:");
			radioButton[0].setText(" Class");
			radioButton[1].setText("Interface");
			radioButton[2].setText("Object");
			radioButton[3].setText("None of the above");
		}
		
		lable.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			radioButton[j].setBounds(50, 80+ i,200, 20);
	}
	
	
	//declare right answers
	boolean check() {
		if(current==0)
			return(radioButton[1].isSelected());
		if(current==1)
			return(radioButton[1].isSelected());
		if(current==2)
			return(radioButton[3].isSelected());
		if(current==3)
			return(radioButton[2].isSelected());
		if(current==4)
			return(radioButton[2].isSelected());
		if(current==5)
			return(radioButton[1].isSelected());
		if(current==6)
			return(radioButton[1].isSelected());
		if(current==7)
			return(radioButton[0].isSelected());
		if(current==8)
			return(radioButton[1].isSelected());
		if(current==9)
			return(radioButton[0].isSelected());
		return false;
	}
	public static void main(String s[]) {
		new OnlineTest("Simple Quiz App");
	}
}
