package skeleton;

import java.util.LinkedList;
import java.util.List;

import android.R;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Node {
	//skeleton
	private Ball ball;
	private int color;
	private List<Connection> connections;
	
	//muscle
	int x,y;
	int radius;
	
	Paint paint;
	
	public Node(){
		//TODO set  x, y and radius based on scale
		paint.setStyle(Style.STROKE);
		switch(color){
			case 1:paint.setColor(Color.RED);break;
			case 2:paint.setColor(Color.YELLOW);break;
			case 3:paint.setColor(Color.GREEN);break;
			case 4:paint.setColor(Color.BLUE);break;
		}
	}
	
	public List<Node> getNeighboursTo(){
		List<Node> neighboursTo=new LinkedList<Node>();
		for(Connection c : connections){
			neighboursTo.add(c.getTo());
		}
		return neighboursTo;
	}

	public Node getNextNode(Node from){
		for(Connection conn:connections){
			if(conn.getFrom()==from){
				return conn.getTo();
			}
		}
		return null;
	}
	
	//skin
	public void draw(Canvas canvas,double scale){
		//drawing node
		canvas.drawCircle(x, y, radius, paint);
		
		//drawing connections
		for(Connection c : connections){
			canvas.drawLine(
					(float)(c.getTo().getX()*scale),
					(float)(c.getTo().getY()*scale),
					(float)(getX()*scale),
					(float)(getY()*scale),
					paint);
			canvas.drawLine(
					(float)(c.getFrom().getX()*scale),
					(float)(c.getFrom().getY()*scale),
					(float)(getX()*scale),
					(float)(getY()*scale),
					paint);
		}
		
		//drawing balls
		ball.draw(canvas);
	}
	
	public Ball getBall() {
		return ball;
	}
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
