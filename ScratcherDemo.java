/*
 * The background colors can be the imageIcon/layers of the scratchers.
 * Each time the label is clicked we can set a new imageIcon/layer on it.
 * The last click can be the random generated number.
 */

package scratcherdemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;
import javax.swing.*;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author Tony
 */
public class ScratcherDemo extends JPanel
{
    private static int width = 800, height = 500;
    private JLayeredPane layerPane = new JLayeredPane();
    private static JLabel label1 = new JLabel();
    private static JLabel label2 = new JLabel();
    private static JLabel label3 = new JLabel();
    private static JLabel label4 = new JLabel();
    private JLabel backgroundLabel = new JLabel();
    private JLabel targetLabel = new JLabel();
    private int clickedLabel1xTimes = 0;
    private int clickedLabel2xTimes = 0;
    private int clickedLabel3xTimes = 0;
    private int clickedLabel4xTimes = 0;
    private int targetNum;
    private static ImageIcon layer1 = new ImageIcon("ScratchLayer1.png");
    
    Random number = new Random();
    
    public ScratcherDemo()
    {
        /*Random*/ number = new Random();
        int max = 5, min = 0;
        int rNum = number.nextInt(max - min + 1) + min;
        String tarNumStr = Integer.toString(rNum);
        targetNum = rNum; 
        
        ImageIcon backgroundImage = new ImageIcon("Scratch off.png");
        backgroundLabel.setIcon(backgroundImage);
        backgroundLabel.setBounds(0, 0, width, height);
        
        layerPane.setPreferredSize(new Dimension(width, height));
        //layerPane.setBorder(BorderFactory.createTitledBorder("LayerPane"));
        layerPane.add(backgroundLabel);
        layerPane.setOpaque(true);
        
        //targetLabel.setBorder(BorderFactory.createLineBorder(Color.cyan));
        targetLabel.setBounds(255, 260, 40, 50);
        targetLabel.setText(tarNumStr);
        //targetLabel.setHorizontalTextPosition(CENTER);
        //targetLabel.setVerticalTextPosition(CENTER);
        targetLabel.setFont(new Font("Cambria", Font.BOLD, 40));
        
        //ImageIcon layer1 = new ImageIcon("ScratchLayer1.png");
        
        label1.setIcon(layer1);
        label1.setToolTipText("click me to \"scratch\" me");
        label1.setBounds(308, 208, 134, 77);
        label1.setOpaque(true);
        label1.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                clickedLabel1xTimes++;
                
                Random number = new Random();
                int max = 5, min = 0;
                int rNum = number.nextInt(max - min + 1) + min;
                String sNum = Integer.toString(rNum);
                
                ImageIcon layer2 = new ImageIcon("ScratchLayer2.png");
                ImageIcon layer3 = new ImageIcon("ScratchLayer3.png");
                ImageIcon layer4 = new ImageIcon("ScratchLayer4.png");
                
                if(clickedLabel1xTimes == 1)
                {
                    label1.setIcon(layer2);
                }
                if(clickedLabel1xTimes == 2)
                {
                    label1.setIcon(layer3);
                }
                if(clickedLabel1xTimes == 3)
                {
                    label1.setText(sNum);
                    label1.setHorizontalTextPosition(CENTER);
                    label1.setVerticalTextPosition(CENTER);
                    label1.setFont(new Font("Cambria", Font.BOLD, 40));
                    label1.setIcon(layer4);
                    compare(rNum);                 
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseReleased(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseEntered(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseExited(MouseEvent e) {/*blank on purpose*/}
        });

        label2.setIcon(layer1);
        label2.setToolTipText("click me to \"scratch\" me");
        label2.setBounds(308, 288, 134, 77);
        label2.setOpaque(true);
        label2.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                clickedLabel2xTimes++;
                
                Random number = new Random();
                int max = 5, min = 0;
                int rNum = number.nextInt(max - min + 1) + min;
                String sNum = Integer.toString(rNum);
                
                ImageIcon layer2 = new ImageIcon("ScratchLayer2.png");
                ImageIcon layer3 = new ImageIcon("ScratchLayer3.png");
                ImageIcon layer4 = new ImageIcon("ScratchLayer4.png");
                
                if(clickedLabel2xTimes == 1)
                {
                    label2.setIcon(layer2);
                }
                if(clickedLabel2xTimes == 2)
                {
                    label2.setIcon(layer3);
                }
                if(clickedLabel2xTimes == 3)
                {
                    label2.setText(sNum);
                    label2.setHorizontalTextPosition(CENTER);
                    label2.setVerticalTextPosition(CENTER);
                    label2.setFont(new Font("Cambria", Font.BOLD, 40));
                    label2.setIcon(layer4);
                    compare(rNum);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseReleased(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseEntered(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseExited(MouseEvent e) {/*blank on purpose*/}
        });
        
        label3.setIcon(layer1);
        label3.setToolTipText("click me to \"scratch\" me");
        label3.setBounds(445, 208, 134, 77);
        label3.setOpaque(true);
        label3.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                clickedLabel3xTimes++;
                
                Random number = new Random();
                int max = 5, min = 0;
                int rNum = number.nextInt(max - min + 1) + min;
                String sNum = Integer.toString(rNum);
                
                ImageIcon layer2 = new ImageIcon("ScratchLayer2.png");
                ImageIcon layer3 = new ImageIcon("ScratchLayer3.png");
                ImageIcon layer4 = new ImageIcon("ScratchLayer4.png");
                
                if(clickedLabel3xTimes == 1)
                {
                    label3.setIcon(layer2);
                }
                if(clickedLabel3xTimes == 2)
                {
                    label3.setIcon(layer3);
                }
                if(clickedLabel3xTimes == 3)
                {
                    label3.setText(sNum);
                    label3.setHorizontalTextPosition(CENTER);
                    label3.setVerticalTextPosition(CENTER);
                    label3.setFont(new Font("Cambria", Font.BOLD, 40));
                    label3.setIcon(layer4);
                    compare(rNum);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseReleased(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseEntered(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseExited(MouseEvent e) {/*blank on purpose*/}
        });
        
        label4.setIcon(layer1);
        label4.setToolTipText("click me to \"scratch\" me");
        label4.setBounds(445, 288, 134, 77);
        label4.setOpaque(true);
        label4.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                
                clickedLabel4xTimes++;
                
                Random number = new Random();
                int max = 5, min = 0;
                int rNum = number.nextInt(max - min + 1) + min;
                String sNum = Integer.toString(rNum);
                
                ImageIcon layer2 = new ImageIcon("ScratchLayer2.png");
                ImageIcon layer3 = new ImageIcon("ScratchLayer3.png");
                ImageIcon layer4 = new ImageIcon("ScratchLayer4.png");
                 
                if(clickedLabel4xTimes == 1)
                {
                   label4.setIcon(layer2);
                }
                if(clickedLabel4xTimes == 2)
                {
                    label4.setIcon(layer3);
                }
                if(clickedLabel4xTimes == 3)
                {
                    label4.setText(sNum);
                    label4.setHorizontalTextPosition(CENTER);
                    label4.setVerticalTextPosition(CENTER);
                    label4.setFont(new Font("Cambria", Font.BOLD, 40));
                    label4.setIcon(layer4);
                    compare(rNum);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseReleased(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseEntered(MouseEvent e) {/*blank on purpose*/}

            @Override
            public void mouseExited(MouseEvent e) {/*blank on purpose*/}
        });
        
        layerPane.add(label1, new Integer(1));
        layerPane.add(label2, new Integer(2));
        layerPane.add(label3, new Integer(3));
        layerPane.add(label4, new Integer(4));
        layerPane.add(targetLabel, new Integer(5));
        
        add(layerPane);
    }
    
    private void compare(int num)
    {
        
        if(num == targetNum)
        {
            System.out.println("YAY");
        }
    }
    
    private static void createAndShowGui()
    {
        JFrame frame = new JFrame("Scratchers Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JComponent newContentPane = new ScratcherDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
        frame.setSize(new Dimension(width, height));
        frame.setVisible(true);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu menuMap = new JMenu("Menu");
        menuBar.add(menuMap);
        
        JMenuItem playItem = new JMenuItem("Play Again");
        JMenuItem exitItem    = new JMenuItem("Exit");
                
        menuMap.add(playItem);
        menuMap.addSeparator();
        menuMap.add(exitItem);
        
        playItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                label1.setText("");
                label2.setText("");
                label3.setText("");
                label4.setText("");
                
                frame.setVisible(false);
                newContentPane.removeAll();
                createAndShowGui();
               
               
               
            }
        });
                
        exitItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                System.exit(0);
            }
        });
    }
    
    
    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            
            public void run()
            {
                createAndShowGui();
            }
        });
    }
}
