/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author Jeremy
 */
public class RaceAnimator {
    public static void main(String args[])
    {

    	RaceAnimatorJPanel animation = new RaceAnimatorJPanel();
    	
      //find the syntax for height and width of panel
      //animation.setWidth(300);
      //animation.setHeight(300);

        JFrame window = new JFrame( "Racing game" ); // set up window
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.add( animation ); // add panel to frame
       
        window.setVisible( true ); // display window
        window.setSize(1000,1000);

        animation.startAnimation(); // begin animation
    }
}