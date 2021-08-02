/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


//import static javafx.scene.paint.Color.color;
//import javax.swing.Timer;
/**
 *
 * @author Jeremy
 */
//1.KeyListener to class 
//
public  class RaceAnimatorJPanel extends JPanel implements KeyListener, ActionListener 
{
   private final static String IMAGE_NAME = "redkart";
   private final static String IMAGE_NAMEB = "bluekart";
   protected ImageIcon imagesred[];
   protected ImageIcon imagesblue[];
   private final int TOTAL_IMAGES = 16;
   private int[] currentimage= new int[2];
   private final int ANIMATION_DELAY = 50; // millisecond delay
   private int width; // image width
   private int height; // image height
   private Timer animationTimer;
   int blue_x,blue_y,speedf;
   int red_x,red_y;
   int distance = 3;
   int firstcarx;
   int firstcary;
   
   public RaceAnimatorJPanel()
   {

	   blue_x=376;
	   blue_y=499;
	   
	   red_x=376;
	   red_y=550;
	   
       imagesred = new ImageIcon[ TOTAL_IMAGES ];
        for ( int count = 0; count < imagesred.length; count++ ){
         imagesred[ count ] = new ImageIcon( getClass().getResource(
         "redkart\\" + IMAGE_NAME + count + ".png" ) );
         
         width = imagesred[ 0 ].getIconWidth(); // get icon width
         height = imagesred[ 0 ].getIconHeight(); // get icon height
      }
        //fixed blue kart file e.g. bluekart0
        imagesblue = new ImageIcon[ TOTAL_IMAGES ];
         for ( int count = 0; count < imagesblue.length; count++ ){
         imagesblue[ count ] = new ImageIcon( getClass().getResource(
         "bluekart\\" + IMAGE_NAMEB + count + ".png" ) );
         
         width = imagesblue[ count ].getIconWidth(); // get icon width
         height = imagesblue[ count ].getIconHeight(); // get icon height
         
      }
         
      addKeyListener(this);
      setFocusable(true);
       requestFocus();
   }
   //Three methods 
   //key types
   //Key releease
   //key press
   //two of the blank
   //Key presss needs to do somthings 
   //if key equals 
   public void keyTyped(KeyEvent ke) {
	   //                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

            @Override
            public void keyPressed(KeyEvent ke) {
                //player 1
                if(ke.getKeyCode()==KeyEvent.VK_RIGHT){
                	if(checkXBoundaryBlue("Right")){
                		blue_x += distance;
                		
                		if(currentimage[0]>10){
                			currentimage[0]--;
                  		 }
                		else if(currentimage[0] == 15){
                			currentimage[0] = 0;
                                        //blue_x += distance;
                        }
                		else if(currentimage[0]!=10)
                			currentimage[0]++;
                	}
                    
                }
                    
                 else if(ke.getKeyCode()==KeyEvent.VK_LEFT){
                	 if(checkXBoundaryBlue("Left")){
                 		blue_x -= distance;
                 		 if(currentimage[0] == 0){
                 			currentimage[0] = 15;
                         }
                 		 else if(currentimage[0]>=14){
                 			currentimage[0]=1;
                                        //blue_x -= distance;
                 		 }
                 		else if(currentimage[0]>=1 && currentimage[0]<3){
                 			currentimage[0]++;
                 		 }
                         else if(currentimage[0]!=3)
                        	 currentimage[0]--;
                 	}
                 }
                    
                else if (ke.getKeyCode()==KeyEvent.VK_UP)
                {
                    //change the current image
                	if(checkYBoundaryBlue("Up")){
                		blue_y -= distance;
                		
                		 if(currentimage[0] == 0){
                			 currentimage[0] = 15;
                         }
                		 else if(currentimage[0] >= 3 && currentimage[0]<7){
                			 currentimage[0] ++;
                         }
                         else if(currentimage[0]!=7)
                        	 currentimage[0]--;
                		}
                }
                    
                else if (ke.getKeyCode()==KeyEvent.VK_DOWN){
                	if(checkYBoundaryBlue("Down")){
                		blue_y += distance;
                		 if(currentimage[0] == 0){
                			 currentimage[0] = 15;
                         }
                		 else if(currentimage[0] <= 3){
                			 currentimage[0] --;
                         }
                         else if(currentimage[0]!=15)
                        	 currentimage[0]++;
                	}
                	
                }
                    
                //player 2
                 if(ke.getKeyCode()==KeyEvent.VK_W){
                     if(checkYBoundaryRed("Up")){
                    	red_y -= distance;
                        if(currentimage[1]==0){
                            currentimage[1]=15;
                        }
                        else if(currentimage[1]>=3 && currentimage[1]<7){
                            currentimage[1]++;
                        }
                        else if(currentimage[1]!=7)
                            currentimage[1]--;
                     }
                 }
                    
                else if(ke.getKeyCode()==KeyEvent.VK_S){
                    if(checkYBoundaryRed("Down")){
                   		red_y += distance;
                            if(currentimage[1] == 0){
                			 currentimage[1] = 15;
                         }
                		 else if(currentimage[1] <= 3){
                			 currentimage[1] --;
                         }
                         else if(currentimage[1]!=15)
                        	 currentimage[1]++;
                     
                   	 }
                }
                    
                else if(ke.getKeyCode()==KeyEvent.VK_D){
                	if(checkXBoundaryRed("Right")){
                   		red_x += distance;
                                
                		if(currentimage[1]>10){
                			currentimage[1]--;
                  		 }
                		else if(currentimage[1] == 15){
                			currentimage[1] = 0;
                        }
                		else if(currentimage[1]!=10)
                			currentimage[1]++;
                   	 }
                }
                    
                else if(ke.getKeyCode()==KeyEvent.VK_A){
               	 if(checkXBoundaryRed("Left")){
               		red_x -= distance;
                         if(currentimage[1] == 0){
                 			currentimage[1] = 15;
                         }
                 		 else if(currentimage[1]>=14){
                 			currentimage[1]=1;
                 		 }
                 		else if(currentimage[1]>=1 && currentimage[1]<3){
                 			currentimage[1]++;
                 		 }
                         else if(currentimage[1]!=3)
                        	 currentimage[1]--;
               	 }

                }
                    
            }
            
            public boolean checkYBoundaryRed(String pos){
            	if(red_y>=553 && pos.equals("Down")|| red_y<=97 && pos.equals("Up")){
            		return false;
            	}
            	return true;
            }
            
            public boolean checkXBoundaryRed(String pos){
            	if(red_x>=755 && pos.equals("Right")||red_x<=45 && pos.equals("Left")){
            		return false;
            	}
            	return true;
            }
            
            public boolean checkYBoundaryBlue(String pos){
            	if(blue_y>=553 && pos.equals("Down")|| blue_y<=97 && pos.equals("Up")){
            		return false;
            	}
            	return true;
            }
            
            public boolean checkXBoundaryBlue(String pos){
            	if(blue_x>=755 && pos.equals("Right")||blue_x<=45 && pos.equals("Left")){
            		return false;
            	}
            	return true;
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            	switch(ke.getKeyCode()){
    				case KeyEvent.VK_RIGHT:
    					break;
    				case KeyEvent.VK_LEFT:
    					break;
    				case KeyEvent.VK_DOWN:
    					break;
    				case KeyEvent.VK_UP:
        				break;

            	}
            }
            
   public void paintComponent( Graphics g )
   {
       super.paintComponent(g);
       imagesred[ currentimage[1] ].paintIcon( this, g,red_x,red_y);
       imagesblue[currentimage[0]].paintIcon(this, g, blue_x, blue_y);
       Color c1 = Color.green;
       g.setColor( c1 );
       g.fillRect( 150, 200, 550, 300 ); //grass
       
       Color c2 = Color.black;
       g.setColor( c2 );
       g.drawRect(50, 100, 750, 500); // outer edge
       g.drawRect(150, 200, 550, 300); // inner edge
       
       Color c3 = Color.yellow;
       g.setColor( c3 );
       g.drawRect( 100, 150, 650, 400 ); // mid-lane marker
       
       Color c4 = Color.white;
       g.setColor(c4);
       g.drawLine( 425, 500, 425, 600 ); // start line
        

   } // end method paintComponent

    public void startAnimation()
 {
    if ( animationTimer == null )
    {
   currentimage[0] = 10;
   currentimage[1] = 4;

    animationTimer = new Timer(ANIMATION_DELAY, this);
    animationTimer.start();
   }
 }
    //@Override
   @Override
   
    public void actionPerformed(ActionEvent ae) {
        repaint();
        System.out.println("blue x="+blue_x+" y="+blue_y+"  red x="+red_x+" y="+red_y);
    }

    

   

  
}
