package skeleton;

import java.util.List;

import android.graphics.Canvas;

public class Grid {
	//skeleton
	private List<Node> nodes;
	//}
	
	//{muscle
	private double ALIGNMENT_THRESHOLD=0.8;
	private double gridwidth,gridheight;
	private double scale;
	//}

	//{internal functions
	public double alignment(int x, int y, int x1, int y1, int x2, int y2) {
		double a1 = x1 - x;
		double b1 = y1 - y;
		double a2 = x2 - x;
		double b2 = y2 - y;
		double mag1 = Math.sqrt(a1 * a1 + b1 * b1);
		double mag2 = Math.sqrt(a2 * a2 + b2 * b2);
		a1 = a1 / mag1;
		a2 = a2 / mag2;
		b1 = b1 / mag1;
		b2 = b2 / mag2;
		double sp = a1 * a2 + b1 * b2;
		return sp;
	}

	public Node getNode(int x, int y) {
		int min = -1, calc;
		Node retnode = null;
		for (Node n : nodes) {
			if (min == -1) {
				min = (n.getX() - x) * (n.getX() - x) + (n.getY() - y) * (n.getY() - y);
			} else {
				calc = (n.getX() - x) * (n.getX() - x) + (n.getY() - y) * (n.getY());
				if (calc < min) {
					min = calc;
					retnode = n;
				}
			}
		}
		return retnode;
	}

	//}

	//{Interactions skeleton
	public void slide(Node from, Node to) {
		Ball temp, temp1;
		Node current = from;
		Node next = to;
		Node tempNode;
		temp = current.getBall();
		do {
			temp1 = next.getBall();
			next.setBall(temp);
			tempNode = next;
			next = next.getNextNode(current);
			current = tempNode;
		} while (next != from);
	}

	//}

	//{interractions muscle
	public void slide(int x1, int y1, int x2, int y2) {
		Node from, to;
		from = getNode(x1, y1);
		List<Node> neighbours = from.getNeighboursTo();
		to = null;
		double alignment = -2;
		for (Node n : neighbours) {
			if (alignment(x1, y1, x2, y2, n.getX(), n.getY()) > alignment) {
				alignment = alignment(x1, y1, x2, y2, n.getX(), n.getY());
				to = n;
			}
		}
		if(alignment>ALIGNMENT_THRESHOLD){
			slide(from, to);
		}
	}
	
	public void draw(Canvas canvas){
		//{drawing nodes
		for(Node n: nodes){
			n.draw(canvas, scale);
		}
		//}
	}
	//}
}
