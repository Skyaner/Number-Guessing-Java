import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JFrame implements ActionListener{

    
    int i = 0;
    int min = 0;
    int max = 1;
    int uinput = 0;
    int result = 0;

    Random rand = new Random();

    JButton range = new JButton();
    JButton submit = new JButton();
    JButton delete = new JButton();

    JLabel mini = new JLabel();
    JLabel maxi = new JLabel();
    JLabel note = new JLabel();
    JLabel space = new JLabel();

    JTextField minimum = new JTextField();
    JTextField maximum = new JTextField(); 
    JTextField input = new JTextField();


        Game(){

            this.setTitle("Number-Guessing");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setLayout(new GridLayout(4, 3));
            

            range = new JButton("Range");
            range.addActionListener(this);
           
            

            mini = new JLabel("Minimum");
                             

            maxi = new JLabel("Maximum"); 
           

            minimum = new JTextField();
          

            maximum = new JTextField();
             

            input = new JTextField();

            space = new JLabel("Guess");            


            note = new JLabel("Have fun");
            

            delete = new JButton("Delete");
            delete.addActionListener(this);
            

            submit = new JButton("Submit");
            submit.addActionListener(this);
            

            this.add(mini);
            this.add(minimum);
            this.add(range);
            this.add(maxi);  
            this.add(maximum);
            this.add(delete);
            this.add(space);
            this.add(input);
            this.add(submit);
            this.add(note);
            
            
            this.pack();     

            this.setVisible(true);  
                


        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==range){
                                  
                        String gmin = minimum.getText();
                        

                        String gmax =maximum.getText();
                                                

                        try {
                            min = Integer.parseInt(gmin);
                            max = Integer.parseInt(gmax);
                            if (min < max){
                                minimum.setEditable(false);
                                maximum.setEditable(false);
                                result = rand.nextInt(max - min + 1) + min;                                
                                i = 1;                                                 
                            }  
    
                            if (min >= max){
                                minimum.setEditable(false);
                                maximum.setEditable(false);
                                note.setText("Your minimum is greater than or equal to your maximum");                            
                            }  
                        } catch (NumberFormatException ex) {
                            minimum.setEditable(false);
                            maximum.setEditable(false);
                            note.setText("Not a valid entry! Only Integer for min and max!");                                                 
                        }

                    }                  
            

                if (e.getSource()==submit){
                    
                    String ginput = input.getText();    
                    i++; 


                    try {
                        uinput = Integer.parseInt(ginput);
                        note.setText(""); 
                        if (uinput == result){
                            input.setEditable(false);
                            note.setText("You did it in "+i+" attempts");
                        }
    
                        else if ((uinput < min || uinput>max)) {
                            note.setText("Out of range");                        
                        }
    
                        else if (uinput >= result+10 || uinput <= result-10) {
                            note.setText("far away");                        
                        }
    
                        else if (uinput <= result+10 || uinput >= result-10) {
                            note.setText("close");                        
                        }                     
                        
                    } catch (NumberFormatException ex) {
                        note.setText("Not a valid entry! Only Integer in the range of min and max!");
                        } 

                                    
                                           
                    
                }            
        
            
            if (e.getSource()==delete){

                minimum.setText("");
                minimum.setEditable(true);

                maximum.setText("");
                maximum.setEditable(true);

                input.setText("");

                note.setText("");
                
                i = 0;
            }
        }  
    }