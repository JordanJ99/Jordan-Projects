/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jocelyn_assignment5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.net.URL;

        
public class Jocelyn_Assignment5 {
    public static void main(String[] args)
    {

       
       // String[] myString = {"21#www.google.png#blah",
        // "22#www.yahoo.png#blh",
        //"23#www.palomar.png#bl"};
   //     for(int j=0; j < myString.length; j++)
    //    {
     //   String [] myStrArray;
     ///   myStrArray = myString[j].split("#");
      //  for(int i=0; i < myStrArray.length; i++)
       // {
       //     System.out.println(myStrArray[i]);
       ///     stringList1.add(myStrArray[0]);
       //     stringList2.add(myStrArray[1]);
        //    stringList2.add(myStrArray[2]);
           
       // }
      //  }
        
       

        //System.out.println(stringList2.size());
        //System.out.println(stringList2.getItem(1));
                
        
        
        JFrame pictureFrame = new ImageSliderFrame();
        pictureFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pictureFrame.setVisible(true);
    }
}    
class ImageSliderFrame extends JFrame 
{
    private JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 1900;
    private static final int DEFAULT_LENGTH = 1000;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel imagePanel;
    private String fileString;
    String[][] myString = new String[4][3]; 
    String[] myStrArray = new String[3];
    int imageCounter = 0;
    
    Timer timer = new Timer(400, null);
    String imageURL = "";
    
    public ImageSliderFrame()
    {
        
        super("Layout Manager Demo");
        
        
        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        panel2 = new JPanel();
        setTitle("ImageSlider");
        setSize(DEFAULT_WIDTH, DEFAULT_LENGTH);
        
        label = new JLabel();
        final Container contentPane = getContentPane();
        
        
        //contentPane.add(label, BorderLayout.CENTER);
        
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        
        JMenuBar menuBar = new JMenuBar();
        contentPane.add(menuBar, BorderLayout.NORTH);
      
        
        JMenu menu1 = new JMenu("File");
        menuBar.add(menu1);
        
         
        JMenuItem openItem = new JMenuItem("Open");
      menu1.add(openItem);
      openItem.addActionListener(new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent evt)
            {
               // show file chooser dialog
               int r = chooser.showOpenDialog(null);

               // if file selected, set it as icon of the label
               if(r == JFileChooser.APPROVE_OPTION)
               {
                   int lineCount = 0;

                   //Image[] images = chooser.getSelectedFile()
                   //for(lineCount; lineCount < 1; lineCount++)
                   //{
                    //String name
                    // = chooser.getSelectedFile();
                    
                   //}
                 String name
                    = chooser.getSelectedFile().getPath();
                   try {
                       Scanner input = new Scanner(new File(name));
                       String myLine;

                       fileString = "";
                       int i =0;
                      while(input.hasNextLine())
                      {
                        String tempString = input.nextLine().trim();
                        myStrArray = tempString.split("#");
                        if(myStrArray.length == 3)
                        {
  
                        myString[i] = myStrArray;
                        i++;
                        }
                       }
                      System.out.println(fileString);
                      //myString = fileString.split("\\r?\\n");
                      for(int j=0; j < 10; j++)
                     {
                       //String tempString = myString[j];
                       
                       String[] myImage = myString[j % 3]; 
                      // System.out.printf("j=%d idx=%d\n\t%s\n\t%s\n\t%s\n", j, j%3,
                     //                                  myImage[0],
                       //                                myImage[1],
                       //                                myImage[2]);
                      
                       
                     // System.out.println(myString[j].getItem(0));


                     }
                      
                      
                      imageURL = myString[0][1];
                    
                      
                     try{
                     URL url = new URL(imageURL);
                      //image = ImageIO.read(url);
                      ImageIcon img = new ImageIcon(url);
                      
                      
                      //BufferedImage image = ImageIO.read(new URL(myString[0][1]));
                      //System.out.println(imageURL);
                      
                      label.setIcon(img);
                      label.setHorizontalAlignment(JLabel.CENTER);
                      contentPane.add(label, BorderLayout.CENTER);
                      revalidate();
                      
                      }
                      catch(IOException ex) {
                      System.out.println("file not found");
                      System.exit(0);
                       }
                        
                       
                       //label.setIcon(new ImageIcon(name));
                   } catch (FileNotFoundException ex) {
                       Logger.getLogger(ImageSliderFrame.class.getName()).log
                        (Level.SEVERE, null, ex);
                   }
               }
            }
         });
      
      JMenuItem exitItem = new JMenuItem("Exit");
      menu1.addSeparator();
      menu1.add(exitItem);
      exitItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });
      
      JMenu menu2 = new JMenu("Help");
      JMenuItem aboutItem = new JMenuItem("About");
      menu2.add(aboutItem);
      
      aboutItem.addActionListener(new 
      ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent event)
          {
              JOptionPane.showMessageDialog(null, "Palomar Image Slider,Jordan "
                      + "Jocelyn v1.0");
          }
      });
      JMenuItem manualItem = new JMenuItem("Help/User Manual");
      menu2.add(manualItem);
      manualItem.addActionListener(new 
      ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent event)
          {
              JLabel label1 = new JLabel("<html> 1. System Requirements - Image Slider"
                      + " requires user to have 64 bit Mac OSx or Windows 7 or"
                      + " newer operating System."
                      +"<br> <br>" + "2. Slider File - file must follow "
                      + "format number#url#description" + "<br> <br>" 
                      + "3. Button functionality- Pressing "
                      + "the buttons allow the user to go back, forward or "
                      + "go to the first or last pictures of the file. </html>");
              contentPane.add(label1, BorderLayout.CENTER);
              label1.setHorizontalAlignment(JLabel.CENTER);
              contentPane.remove(label);
          }
      });
      menuBar.add(menu2);
      
      timer.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               
                
                if(imageCounter == 4)
                {
                    imageCounter = 0;
                }
                     

                     //imageURL = myString[0][1];
                     imageURL = myString[imageCounter][1];
                     
                     
                    
                    // for(imageCounter = 0; imageCounter < myString.length-1; 
                     //        imageCounter++)
                     //{
                       //  imageURL = myString[imageCounter][1]; 
                     try{
                     URL url = new URL(imageURL);
                      //image = ImageIO.read(url);
                      ImageIcon img = new ImageIcon(url);
                      
                      
                      //BufferedImage image = ImageIO.read(new URL(myString[0][1]));
                      //System.out.println(imageURL);
                      
                      label.setIcon(img);
                      label.setHorizontalAlignment(JLabel.CENTER);
                      contentPane.add(label, BorderLayout.CENTER);
                      imageCounter++;
                      }
                      catch(IOException ex) {
                      System.out.println("file not found");
                      System.exit(0);
                       }
                     //}
            }
         });
      
      //add(panel1);
      
      //panel2.setBounds(600, 1800, 500,100);
      //FlowLayout layout = new FlowLayout();
      //panel2.setLayout(layout);
      ImageIcon image1 = new ImageIcon("home.png");//35 by 10
      ImageIcon image2 = new ImageIcon("back.png");
      ImageIcon image3 = new ImageIcon("next.png");
      ImageIcon image4 = new ImageIcon("last.png");
      ImageIcon image5 = new ImageIcon("start.png");
      ImageIcon image6 = new ImageIcon("list.png");
      
      
      
      JButton homeButton = new JButton(image1);
      JButton backButton = new JButton(image2);
      JButton nextButton = new JButton(image3);
      JButton lastButton = new JButton(image4);
      JButton startButton = new JButton(image5);
      JButton listButton = new JButton(image6);
      
      panel2.add(startButton);
      panel2.add(homeButton);
      panel2.add(backButton);
      panel2.add(nextButton);
      panel2.add(lastButton);
      panel2.add(listButton);
      contentPane.add(panel2, BorderLayout.SOUTH);
      startButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                
                timer.start();
                
                     //}
            }
         });
      homeButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                     String imageURL = myString[0][1];
                     //imageURL = myString[0][1];
                     
                                              try{
                     URL url = new URL(imageURL);
                      //image = ImageIO.read(url);
                      ImageIcon img = new ImageIcon(url);
                      
                      
                      //BufferedImage image = ImageIO.read(new URL(myString[0][1]));
                      //System.out.println(imageURL);
                      
                      label.setIcon(img);
                      label.setHorizontalAlignment(JLabel.CENTER);
                      contentPane.add(label, BorderLayout.CENTER);
                      }
                      catch(IOException ex) {
                      System.out.println("file not found");
                      System.exit(0);
                     }
                    
                      

                       
            }
         });
      
          backButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                String imageURL;
                   if (imageCounter == 0)
                   {
                       
                        imageURL = myString[myString.length-1][1];
                   }
                   else
                   {
                       imageCounter--;
                        imageURL = myString[imageCounter][1];
                               
                   }
                                        try{
                     URL url = new URL(imageURL);
                      //image = ImageIO.read(url);
                      ImageIcon img = new ImageIcon(url);
                      
                      
                      //BufferedImage image = ImageIO.read(new URL(myString[0][1]));
                      //System.out.println(imageURL);
                      
                      label.setIcon(img);
                      label.setHorizontalAlignment(JLabel.CENTER);
                      contentPane.add(label, BorderLayout.CENTER);
                      }
                      catch(IOException ex) {
                      System.out.println("file not found");
                      System.exit(0);
                       }
                   
            }
         });
         nextButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {

                imageCounter ++;
                if (imageCounter == 4)
                {
                    imageCounter = 0;
                }
                String imageURL = myString[imageCounter][1];

                                        try{
                     URL url = new URL(imageURL);
                      //image = ImageIO.read(url);
                      ImageIcon img = new ImageIcon(url);
                      
                      
                      //BufferedImage image = ImageIO.read(new URL(myString[0][1]));
                      //System.out.println(imageURL);
                      
                      label.setIcon(img);
                      label.setHorizontalAlignment(JLabel.CENTER);
                      contentPane.add(label, BorderLayout.CENTER);
                      }
                      catch(IOException ex) {
                      System.out.println("file not found");
                      System.exit(0);
                       }
                   
            }
         });
         lastButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {

                imageCounter = myString.length-1;
                String imageURL = myString[imageCounter][1];

                                        try{
                     URL url = new URL(imageURL);
                      //image = ImageIO.read(url);
                      ImageIcon img = new ImageIcon(url);
                      
                      
                      //BufferedImage image = ImageIO.read(new URL(myString[0][1]));
                      //System.out.println(imageURL);
                      
                      label.setIcon(img);
                      label.setHorizontalAlignment(JLabel.CENTER);
                      contentPane.add(label, BorderLayout.CENTER);
                      }
                      catch(IOException ex) {
                      System.out.println("file not found");
                      System.exit(0);
                       }
                   
            }
         });
         
         listButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
                
                imagePanel = new JPanel(new GridLayout(2,3,10,20));
                //imagePanel.setLayout(layout2);
                //imageCounter = myString.length-1;
                String imageURL = myString[0][1];
                String imageURL2 = myString[1][1];
                String imageURL3 = myString[2][1];
                String imageURL4 = myString[3][1];
                                        try{
                     URL url = new URL(imageURL);
                      //image = ImageIO.read(url);
                      ImageIcon img = new ImageIcon(url);
                      
                      URL url2 = new URL(imageURL2);
                      //image = ImageIO.read(url);
                      ImageIcon img2 = new ImageIcon(url2);
                      
                      URL url3 = new URL(imageURL3);
                      //image = ImageIO.read(url);
                      ImageIcon img3 = new ImageIcon(url3);
                      
                      URL url4 = new URL(imageURL4);
                      //image = ImageIO.read(url);
                      ImageIcon img4 = new ImageIcon(url4);
                      
                      Image rImg = img.getImage();
                      Image newimg = rImg.getScaledInstance(270, 200,  java.awt.Image.SCALE_SMOOTH);
                      ImageIcon resizeImg = new ImageIcon(newimg);
                      
                      Image rImg2 = img2.getImage();
                      Image newimg2 = rImg2.getScaledInstance(270, 200,  java.awt.Image.SCALE_SMOOTH);
                      ImageIcon resizeImg2 = new ImageIcon(newimg2);
                      
                      Image rImg3 = img3.getImage();
                      Image newimg3 = rImg3.getScaledInstance(270, 200,  java.awt.Image.SCALE_SMOOTH);
                      ImageIcon resizeImg3 = new ImageIcon(newimg3);
                      
                      Image rImg4 = img4.getImage();
                      Image newimg4 = rImg4.getScaledInstance(270, 200,  java.awt.Image.SCALE_SMOOTH);
                      ImageIcon resizeImg4 = new ImageIcon(newimg4);
                      
                      
                      //BufferedImage image = ImageIO.read(new URL(myString[0][1]));
                      //System.out.println(imageURL);
                      label2 = new JLabel();
                      label3 = new JLabel();
                      label4 = new JLabel();
                      
                      label.setIcon(resizeImg);
                      label2.setIcon(resizeImg2);
                      label3.setIcon(resizeImg3);
                      label4.setIcon(resizeImg4);
                      
                      imagePanel.add(label);
                      imagePanel.add(label2);
                      imagePanel.add(label3);
                      imagePanel.add(label4);
                      contentPane.add(imagePanel, BorderLayout.CENTER);
                      

                      label.setHorizontalAlignment(JLabel.CENTER);
                      label2.setHorizontalAlignment(JLabel.CENTER);
                      label3.setHorizontalAlignment(JLabel.CENTER);
                      label4.setHorizontalAlignment(JLabel.CENTER) ;               
                      //contentPane.add(label, BorderLayout.CENTER);
                      
                      }
                      catch(IOException ex) {
                      System.out.println("file not found");
                      System.exit(0);
                       }
                   
            }
         });
         
  }
    
}
	   



