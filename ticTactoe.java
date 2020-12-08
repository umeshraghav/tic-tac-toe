//import libaries for GUI and Action Event


import java.awt.event.*;
import javax.swing.*;


public class ticTactoe extends JFrame
{
    //Create 9 buttons to make a clickable grid and 1 button to start new game
     JButton button,button1,button2,button3,button4,button5,button6,button7,button8,button9;
     int turn=0,a=0,count=0;
     
     // TextFiled to Show result of the game
     JLabel resultbox;
     
     //create a constructor to set the name of frame
     ticTactoe(String s){
         super(s);
     }
     
     //Method to place GUI Componets in Frame
     
     public void placeComponents()
	{
            resultbox=new JLabel("Result:");
            resultbox.setBounds(35,240,190,35);
            //resultbox.setEditable(false);
        
           //creating buttons
	     button=new JButton("Play New Game");
         button1=new JButton("");
         button2=new JButton("");
	     button3=new JButton("");
         button4=new JButton("");
         button5=new JButton("");
         button6=new JButton("");
         button7=new JButton("");
         button8=new JButton("");
	     button9=new JButton("");         
         
         //setting position of buttons
         button.setBounds(90,320,130,30);
         button1.setBounds(15,15,80,60);
    	 button2.setBounds(105,15,80,60);
         button3.setBounds(195,15,80,60); 
	     button4.setBounds(15,90,80,60); 
         button5.setBounds(105,90,80,60);
	     button6.setBounds(195,90,80,60); 
	     button7.setBounds(15,160,80,60);
	     button8.setBounds(105,160,80,60);
         button9.setBounds(195,160,80,60);
        
         
         //add actionListner to the buttons so that we can perform logic on click 
 
         button.addActionListener(new actionButton());
         button1.addActionListener(new actionButton1());
         button2.addActionListener(new actionButton2());
         button3.addActionListener(new actionButton3());
         button4.addActionListener(new actionButton4());
         button5.addActionListener(new actionButton5());
         button6.addActionListener(new actionButton6());
         button7.addActionListener(new actionButton7());
         button8.addActionListener(new actionButton8());
         button9.addActionListener(new actionButton9());
         
         
            add(resultbox);
            add(button);
            add(button1);
            add(button2);
            add(button3);
            add(button4);
            add(button5);
            add(button6);
            add(button7);
            add(button8);
            add(button9);
        }

//This Method disables all the buttons after game is over    
    public void disableAll()
	        {
         
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                button7.setEnabled(false);
                button8.setEnabled(false);
                button9.setEnabled(false);
	        }
     
     public int check()
	    {
	        	count++;
                //Check all the wining combinations 		
    		if(button1.getText()=="X"&&button2.getText()=="X"&&button3.getText()=="X")
	    		return 1;
	    	else if(button1.getText()=="X"&&button4.getText()=="X"&&button7.getText()=="X")
		    	return 1;
		    else if(button1.getText()=="X"&&button5.getText()=="X"&&button9.getText()=="X")
			    return 1;
			else if(button2.getText()=="X"&&button5.getText()=="X"&&button8.getText()=="X")
	    		return 1;
		    else if(button3.getText()=="X"&&button6.getText()=="X"&&button9.getText()=="X")
			    return 1;
		    else if(button3.getText()=="X"&&button5.getText()=="X"&&button7.getText()=="X")
			    return 1;
		    else if(button4.getText()=="X"&&button5.getText()=="X"&&button6.getText()=="X")
			    return 1;
		    else if(button7.getText()=="X"&&button8.getText()=="X"&&button9.getText()=="X")
			    return 1;
		    else if(button1.getText()=="0"&&button2.getText()=="0"&&button3.getText()=="0")
			    return 2;
		    else if(button1.getText()=="0"&&button4.getText()=="0"&&button7.getText()=="0")
			    return 2;
		    else if(button1.getText()=="0"&&button5.getText()=="0"&&button9.getText()=="0")
			    return 2;
		
		    else if(button2.getText()=="0"&&button5.getText()=="0"&&button8.getText()=="0")
			    return 2;
		    else if(button3.getText()=="0"&&button6.getText()=="0"&&button9.getText()=="0")
			    return 2;
		    else if(button3.getText()=="0"&&button5.getText()=="0"&&button7.getText()=="0")
			    return 2;
		
		    else if(button4.getText()=="0"&&button5.getText()=="0"&&button6.getText()=="0")
			    return 2;
	    	else if(button7.getText()=="0"&&button8.getText()=="0"&&button9.getText()=="0")
		    	return 2;
		
	    	else{
		          if(count==9)
                  resultbox.setText("Result : Game Draw");
		         return 3;
        		}			
			
		
	}
     


    //create classes and implement the methods of ActionListner  
     
    class actionButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
              turn=0;a=0;count=0;
                        
            //Enable all the buttons after "New Game" Button is Clicked
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);
                    button5.setEnabled(true);
                    button6.setEnabled(true);
                    button7.setEnabled(true);
                    button8.setEnabled(true);
                    button9.setEnabled(true);
                            
                //Set text of all buttons to ""
                    button1.setText("");
                    button2.setText("");
                    button3.setText("");
                    button4.setText("");
                    button5.setText("");
                    button6.setText("");
                    button7.setText("");
                    button8.setText("");
                    button9.setText("");
                    resultbox.setText("Result:");
            
    }
         
     }
    
    class actionButton1 implements ActionListener{

        
        public void actionPerformed(ActionEvent e) {
            if(turn==0)
            {
                button1.setText("X");
                button1.setEnabled(false);
                turn=1;
                a=check();
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }
                else ;
            }
            else{
                button1.setText("0");
                 button1.setEnabled(false);
                turn=0;
                a=check();
                
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }else;
            }
        }
         
     }
    
      class actionButton2 implements ActionListener{

 public void actionPerformed(ActionEvent e) {
            if(turn==0)
            {
                button2.setText("X");
                button2.setEnabled(false);
                turn=1;
                a=check();
                
                // check value returned by check method if it is 1 then Player 1 is Won the Game 
                // if value returned is 2 then player two has won the game .

                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                    disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                   disableAll();
                }
                else ;
            }
            else{
                button2.setText("0");
                 button2.setEnabled(false);
                turn=0;
                a=check();
                
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                    
                }else;
            }
        }
         
     }
        class actionButton3 implements ActionListener{
 public void actionPerformed(ActionEvent e) {
            if(turn==0)
            {
                button3.setText("X");
                button3.setEnabled(false);
                turn=1;
                a=check();
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }
                else ;
            }
            else{
                button3.setText("0");
                 button3.setEnabled(false);
                turn=0;
                a=check();
                
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                    
                }else;
            }
        }
         
     }
          class actionButton4 implements ActionListener{

  public void actionPerformed(ActionEvent e) {
            if(turn==0)
            {
                button4.setText("X");
               
                button4.setEnabled(false);
                turn=1;
                a=check();
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }
                else ;
            }
            else{
                button4.setText("0");
                button4.setEnabled(false);
                turn=0;
                a=check();
                
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                    
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }else;
            }
        }
         
     }
            class actionButton5 implements ActionListener{
 public void actionPerformed(ActionEvent e) {
            if(turn==0)
            {
                button5.setText("X");
                
                button5.setEnabled(false);
                turn=1;
                a=check();
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }
                else ;
            }
            else{
                button5.setText("0");
                 button5.setEnabled(false);
                turn=0;
                a=check();
                
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                    
                }else;
            }
        }
         
     }
              class actionButton6 implements ActionListener{
                     public void actionPerformed(ActionEvent e) {
            if(turn==0)
            {
                button6.setText("X");
              
                button6.setEnabled(false);
                turn=1;
                a=check();
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }
                else ;
            }
            else{
                button6.setText("0");
                 button6.setEnabled(false);
                turn=0;
                a=check();
                
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                    
                }else;
            }
        }
         
     }
                class actionButton7 implements ActionListener{

  public void actionPerformed(ActionEvent e) {
            if(turn==0)
            {
                button7.setText("X");
               button7.setEnabled(false);
                turn=1;
                a=check();
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }
                else ;
            }
            else{
                button7.setText("0");
                 button7.setEnabled(false);
                turn=0;
                a=check();
                
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                    
                }else;
            }
        }
         
     }
                  class actionButton8 implements ActionListener{

  public void actionPerformed(ActionEvent e) {
            if(turn==0)
            {
                button8.setText("X");
               
                button8.setEnabled(false);
                turn=1;
                a=check();
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();              
                }
                else ;
            }
            else{
                button8.setText("0");
                button8.setEnabled(false);
                turn=0;
                a=check();
                
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }else;
            }
        }
         
     }
                    class actionButton9 implements ActionListener{

  public void actionPerformed(ActionEvent e) {
            if(turn==0)
            {
                button9.setText("X");
                
                button9.setEnabled(false);
                turn=1;
                a=check();
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                 disableAll();
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                 disableAll();
                }
                else ;
            }
            else{
                button9.setText("0");
                button9.setEnabled(false);
                turn=0;
                a=check();
                
                if(a==1){
                    resultbox.setText("Result : Player 1 Won");
                }
                else if(a==2){
                    resultbox.setText("Result : Player 2 Won");
                    
                }else;
            }
        }
         
     }
     
     
     public static void main(String[] args) {
        
        //create the object
         ticTactoe tc=new ticTactoe("Tic Tac Toe");
         
         //call PlaceComponents method to add componets to frame
	 tc.placeComponents();
	 tc.setSize(325,450);
	 tc.setLocation(600,100);
	 tc.setLayout(null);
   	 tc.setVisible(true);
	 tc.setResizable(false);
	 tc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
