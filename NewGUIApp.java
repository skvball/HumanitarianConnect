import java.awt.*;
import javax.swing.JButton;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class NewGUIApp extends JPanel{
  public JFrame enterInfo;
  public static void main(String args[]){
      new UserInputPanels();
   }
}

class UserInputPanels extends JPanel {
   Database database = new Database();
   organization organ = null;
   donator donor = null;
   String name;
   String state;
   boolean organYes = false;

   UserInputPanels()
   {
      JPanel one = new JPanel();
      JFrame frame = new JFrame("Welcome");
      frame.setSize(600, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(one);
      frame.setVisible(true);
   

      JTextField textName = new JTextField(400);  
      textName.setText("Enter your or your organizations name:");
      textName.setBounds(20, 310, 400, 30);
      one.add(textName);
      name = textName.getText();  
      

      JTextField textState = new JTextField(400); 
      textState.setText("Enter your or your organization's state's initials:"); 
      textState.setBounds(20,350, 400,30);  
      one.add(textState);
      state = textState.getText().toUpperCase(); 

      JButton org = new JButton("organization");
      org.setBounds(0,0,300,300);    
      org.setBackground(new Color(255, 86, 87));  
      one.add(org);
      org.addActionListener(new OrganizationFlow());
   
      JButton don = new JButton("donator");
      don.setBounds(300,0,300,300);    
      don.setBackground(new Color(55, 108, 138));
      one.add(don);
      don.addActionListener(new DonatorFlow());

     
   }

   private class OrganizationFlow implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JPanel one = new JPanel();
         JFrame enterInfo = new JFrame("Organization");
         enterInfo.setSize(600, 430);
         enterInfo.setLocation(20, 20);
         enterInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         enterInfo.setContentPane(one);
         enterInfo.setVisible(true);
      
         JTextField d = new JTextField("Enter your organization's description:");  
      d.setBounds(50,100, 200,30);  
      one.add(d);
      String description = d.getText();
      

      JTextField type = new JTextField("Enter your organization's mission: blood drives or shelter");  
      type.setBounds(50,100, 200,30);  
      String typer = type.getText();
      one.add(type);

      JButton submit = new JButton("Submit");
         submit.setBounds(50,100,150,30);    
         submit.setBackground(new Color(250, 129, 130));  
         one.add(submit);
         submit.addActionListener(new LastPanel());
      

      organ = new organization(name, state, description, typer);

      }
   
   }
   private class DonatorFlow implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
               JPanel one = new JPanel();
        donor = new donator(name, state, "");
         JFrame enterInfo = new JFrame("Donator");
         enterInfo.setSize(600, 430);
         enterInfo.setLocation(20, 20);
         enterInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         enterInfo.setContentPane(one);
         enterInfo.setVisible(true);
      
         JButton blood = new JButton("blood");
         blood.setBounds(50,100,150,30);    
         blood.setBackground(new Color(80, 149, 188));  
         one.add(blood);
         blood.addActionListener(new BloodFlow());
      
         JButton shelter = new JButton("shelter");
         shelter.setBounds(320,100,150,30);    
         shelter.setBackground(new Color(80, 137, 188));
         one.add(shelter);
         shelter.addActionListener(new ShelterFlow());

         //JTextField type = new JTextField("Enter your organization's mission: blood drives or shelter");  
      //type.setBounds(50,100, 200,30);  
     // String typer = type.getText();
      //one.add(type);
      
      }
   }
  
   private class BloodFlow implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
               JPanel one = new JPanel();
         JFrame enterInfo = new JFrame("Blood");
         enterInfo.setSize(600, 430);
         enterInfo.setLocation(20, 20);
         enterInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         enterInfo.setContentPane(one);
         enterInfo.setVisible(true);
      
         JTextField b = new JTextField("Enter the blood type: A, AB, or B");  
         b.setBounds(50,100, 200,30); 
         one.add(b); 
         String blood = b.getText();
         
         JButton submit = new JButton("Submit");
         submit.setBounds(50,100,150,30);    
         submit.setBackground(Color.pink);  
         one.add(submit);
         submit.addActionListener(new LastPanel());

         if(organYes)
         {
           organ.setType("blood");
           organ.addFocus(blood);
           database.add(organ);
         }
         else{
            donor.setType("blood");
            donor.addFocus(blood);
         }

         
        }
    }
    

   private class ShelterFlow implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
          JPanel one = new JPanel();
         JFrame enterInfo = new JFrame("Shelter");
         enterInfo.setSize(600, 430);
         enterInfo.setLocation(20, 20);
         enterInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         enterInfo.setContentPane(one);
         enterInfo.setVisible(true);
      
      JTextField b = new JTextField("Enter shelter item: clothes or food");  
         b.setBounds(50,100, 200,30);  
         one.add(b);
         String item = b.getText();
         

         JButton submit = new JButton("Submit");
         submit.setBounds(50,100,150,30);    
         submit.setBackground(Color.pink);  
         one.add(submit);
         submit.addActionListener(new LastPanel());
         
         if(organYes)
         {
           organ.setType("shelter");
           organ.addFocus(item);
           database.add(organ);
         }
         else{
            donor.setType("shelter");
            donor.addFocus(item);
         }

         
      }
   }
   
   private class LastPanel implements ActionListener
   {
    public void actionPerformed(ActionEvent e)
    {
      JPanel one = new JPanel();
         JFrame enterInfo = new JFrame("");
         enterInfo.setSize(600, 430);
         enterInfo.setLocation(20, 20);
         enterInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         enterInfo.setContentPane(one);
         enterInfo.setVisible(true);


    if(organYes)
      {
        JTextField b = new JTextField("Enter another organization? Yes or No");  
         b.setBounds(50,100, 200,30);  
         one.add(b);
         String item = b.getText().toLowerCase();
         
         while(item.equals("yes"))
         {
           new UserInputPanels();
         }
      }
      else
      {
         
         JTextField lb = new JTextField(donor.getState());
         lb.setBounds(50,100,150,30);    
         lb.setBackground(Color.pink);  
         one.add(lb);
        ArrayList<String> disp = database.display(donor.getState(), donor.getType());
        //JLabel lb = new JLabel(disp.get(0));
          //one.add(lb);
        for(String d: disp)
        {
           JTextField lab = new JTextField(d);
         lab.setBounds(50,100,150,30);    
         lab.setBackground(Color.pink);  
         one.add(lab);
         //  JLabel lab = new JLabel(d);         
         //  lab.setBounds(50,100, 100,30); 

         //  one.add(lab);
        } 
      }
    }
   }
  }

  