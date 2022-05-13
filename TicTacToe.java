import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class TicTacToe implements ActionListener
{
	JFrame fr;
	JPanel title_Panel,button_panel;
	JButton b[] = new JButton[9];
	boolean player1;
	JLabel text;
	Random random = new Random();
	
	TicTacToe()
	{
		fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(700,700);
		fr.setLayout(new BorderLayout());
		fr.setLocationRelativeTo(null);
		fr.setResizable(false);
		
		text = new JLabel();
		text.setBackground(new Color(25,25,25));
		text.setForeground(new Color(25,255,0));
		text.setFont(new Font("Ariel",Font.BOLD,75));
		text.setText("Tic Tac Toe");
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setOpaque(true);
		
		title_Panel = new JPanel();
		title_Panel.setLayout(new BorderLayout());
		title_Panel.setBounds(0,0,700,100);
		title_Panel.add(text);
		
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(3,3));
		
		for(int i=0; i<b.length; i++)
		{
			b[i] = new JButton();
			button_panel.add(b[i]);
			b[i].setFont(new Font("Verdana",Font.BOLD,120));
			b[i].addActionListener(this);
			b[i].setFocusable(false);
		}
		
		fr.add(title_Panel,BorderLayout.NORTH);
		fr.add(button_panel);
		fr.setVisible(true);
		
		firstTurn();
	}
	
	public static void main(String agrs[])
	{
		new TicTacToe();
	}
	
	public void firstTurn()
	{
		try{
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0)
		{
			player1 = true;
			text.setText("X Turn");
		}
		else
		{
			player1 = false;
			text.setText("O Turn");
		}
	}
	public void check()
	{
		//X winning Conditions
		if(
			(b[0].getText()=="X") &&
			(b[1].getText()=="X") &&
			(b[2].getText()=="X")
		  )
			{
				xWins(0,1,2);
			}
		if(
			(b[3].getText()=="X") &&
			(b[4].getText()=="X") &&
			(b[5].getText()=="X")
		  )
			{
				xWins(3,4,5);
			}
		if(
			(b[6].getText()=="X") &&
			(b[7].getText()=="X") &&
			(b[8].getText()=="X")
		  )
			{
				xWins(6,7,8);
			}
		if(
			(b[0].getText()=="X") &&
			(b[3].getText()=="X") &&
			(b[6].getText()=="X")
		  )
			{
				xWins(0,3,6);
			}
		if(
			(b[1].getText()=="X") &&
			(b[4].getText()=="X") &&
			(b[7].getText()=="X")
		  )
			{
				xWins(1,4,7);
			}
		if(
			(b[2].getText()=="X") &&
			(b[5].getText()=="X") &&
			(b[8].getText()=="X")
		  )
			{
				xWins(2,5,8);
			}
		if(
			(b[0].getText()=="X") &&
			(b[4].getText()=="X") &&
			(b[8].getText()=="X")
		  )
			{
				xWins(0,4,8);
			}
		if(
			(b[2].getText()=="X") &&
			(b[4].getText()=="X") &&
			(b[6].getText()=="X")
		  )
			{
				xWins(2,4,6);
			}
			
		//O Winning Conditions
		if(
			(b[0].getText()=="O") &&
			(b[1].getText()=="O") &&
			(b[2].getText()=="O")
		  )
			{
				oWins(0,1,2);
			}
		if(
			(b[3].getText()=="O") &&
			(b[4].getText()=="O") &&
			(b[5].getText()=="O")
		  )
			{
				oWins(3,4,5);
			}
		if(
			(b[6].getText()=="O") &&
			(b[7].getText()=="O") &&
			(b[8].getText()=="O")
		  )
			{
				oWins(6,7,8);
			}
		if(
			(b[0].getText()=="O") &&
			(b[3].getText()=="O") &&
			(b[6].getText()=="O")
		  )
			{
				oWins(0,3,6);
			}
		if(
			(b[1].getText()=="O") &&
			(b[4].getText()=="O") &&
			(b[7].getText()=="O")
		  )
			{
				oWins(1,4,7);
			}
		if(
			(b[2].getText()=="O") &&
			(b[5].getText()=="O") &&
			(b[8].getText()=="O")
		  )
			{
				oWins(2,5,8);
			}
		if(
			(b[0].getText()=="O") &&
			(b[4].getText()=="O") &&
			(b[8].getText()=="O")
		  )
			{
				oWins(0,4,8);
			}
		if(
			(b[2].getText()=="O") &&
			(b[4].getText()=="O") &&
			(b[6].getText()=="O")
		  )
			{
				oWins(2,4,6);
			}
	}
	public void matchDraw()
	{
		text.setText("Match Dr");
		for(int i=0; i<b.length; i++)
		{
			b[i].setEnabled(false);
		}
	}
	public void xWins(int num1, int num2, int num3)
	{
		b[num1].setBackground(Color.GREEN);
		b[num2].setBackground(Color.GREEN);
		b[num3].setBackground(Color.GREEN);
		
		for(int i=0; i<b.length;i++)
		{
			b[i].setEnabled(false);
			text.setText("X WINS");
		}
	}
	public void oWins(int num1, int num2, int num3)
	{
		b[num1].setBackground(Color.GREEN);
		b[num2].setBackground(Color.GREEN);
		b[num3].setBackground(Color.GREEN);
		
		for(int i=0; i<b.length;i++)
		{
			b[i].setEnabled(false);
			text.setText("O WINS");
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0; i<b.length; i++)
		{
			if(e.getSource()==b[i])
			{
				if(player1)
				{
					if(b[i].getText()=="")
					{
						b[i].setForeground(new Color(255,0,0));
						b[i].setText("X");
						text.setText("O Turn");
						player1 = false;
						check();
					}
				}
				else
				{
					if(b[i].getText()=="")
					{
						b[i].setForeground(new Color(0,0,255));
						b[i].setText("O");
						text.setText("X Turn");
						player1 = true;
						check();
					}
				}
			}
		}
	}
}