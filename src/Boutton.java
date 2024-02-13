import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

import javax.swing.JButton;

public class Boutton extends JButton implements MouseListener {
	private String name;
	private String touche;
	GradientPaint gp;
	public Boutton(String str){
	super(str);
	this.name = str;
 gp = new GradientPaint(0, 0,Color.blue, 0, 20, Color.cyan, true);
	this.addMouseListener(this);
	touche = "premier toucher";
	
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, this.getWidth(),this.getHeight());
		Font font = new Font("Comics Sans MS", Font.BOLD,13);
		g2d.setFont(font);
		g2d.setColor(Color.white);
		g2d.drawString(this.name, this.getWidth() /4, this.getHeight()/2+5);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 touche = "je click";
		 System.out.println(touche);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		 gp = new GradientPaint(0, 0,Color.yellow, 0, 20, Color.yellow, true);
		
		 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getY()<0)
		{
			 gp = new GradientPaint(0, 0,Color.blue, 0, 20, Color.cyan, true);
		}
		{
		 gp = new GradientPaint(0, 0,Color.orange, 0, 20, Color.orange, true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		 gp = new GradientPaint(0, 0,Color.yellow, 0, 20, Color.yellow, true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		gp = new GradientPaint(0, 0,Color.green, 0, 20, Color.green, true);
	}

}
