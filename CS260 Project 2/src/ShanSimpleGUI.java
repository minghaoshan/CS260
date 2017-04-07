import java.awt.*;
import javax.swing.*;

/**
 * @author  Minghao Shan
 * @version 04/07/2017
 *
 */
public class ShanSimpleGUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();//create a frame
		FlowLayout layout = new FlowLayout();//create a layout
		frame.setLayout(layout);//set the layout to the frame
		
		
		//create 4 buttons
		JButton circle = new JButton("Circle");
		JButton square = new JButton("Square");
		JButton blue = new JButton("Blue");
		JButton red = new JButton("Red");
		
		//add buttons to frame
		frame.add(circle);
		frame.add(square);
		frame.add(blue);
		frame.add(red);
		
		
		
		
		//set the frame to close after close the windows
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/////////////////////////////////????????
		frame.pack();
		//set size of the frame
		frame.setSize(500, 300);
		//set visible
		frame.setVisible(true);
		
	}

}
