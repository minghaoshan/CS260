package edu.truman.cs260.shan.Shape;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
/**
 * This class create square shapes.
 * @author Minghao Shan
 *
 */
class SquareShape implements MovableShape{
	private int xCoor = 0;
	private int dx;
	private int dy;
	private int yCoor = 0;
	private int size;
	private int shapeSize;
	private Random r = new Random();
	private Color c = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
	/**
	 * Constructor of SquareShape. It initialize the shape size and the background
	 * size, as well as randomly generate the movement speed of the shape.
	 * @param size	The size of the background
	 * @param shapeSize	The size of the shape
	 */
	public SquareShape(int size, int shapeSize){
		//assign random dx & dy
		this.size = size;
		this.shapeSize = shapeSize;
		dx = r.nextInt(5) + 1;
		dy = r.nextInt(5) + 1;

	}
	/**
	 * Moves the square shape and reverse the movement of square if it touches the 
	 * boarder of the background.
	 */
    public void move(){
    	//move the coordinate
		xCoor = xCoor + dx;
		yCoor = yCoor + dy;
		
		//inverse the dx move
		if((0 > xCoor) || (xCoor + shapeSize > size)){
			dx = -dx;
		}
		//inverse the dy move
		if((0 > yCoor) || (yCoor + shapeSize > size)){
			dy = -dy;
		}
    }
	/**
	 * Draw the square shape.
	 * @param g2 the 2D graphics context.
	 */
    public void draw(Graphics2D g2){
    	Rectangle2D square = new Rectangle2D.Double(xCoor, yCoor, shapeSize, shapeSize);
    	g2.setColor(c);
    	g2.fill(square);
    }
}