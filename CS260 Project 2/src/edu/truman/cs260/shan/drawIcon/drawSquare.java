package edu.truman.cs260.shan.drawIcon;

import javax.swing.*;
import java.awt.*;

public class drawSquare implements Icon{
	
	private int size;
	/**
	 * 
	 * @param size
	 */
	public drawSquare(int size){
		this.size = size;
	}
	
	/**
	 * 
	 * @param c
	 * @param g
	 * @param x
	 * @param y
	 */
	public void paintIcon(Component c, Graphics g, int x, int y){
		
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return 0;
	}


}
