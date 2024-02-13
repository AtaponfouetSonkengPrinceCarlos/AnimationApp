import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Panneau extends JPanel {
	public static int i;
	private int posX =0;
	private  int posY = 300;
	private int drawSize = 50;
	private boolean morph =false,reduce=false;
	private String forme = "ROND";
	private int increment = 0;
	private Color couleurForme = Color.red;
	private Color couleurFond = Color.black;
	public void paintComponent(Graphics g)
	{
		g.setColor(couleurFond);
		g.fillRect(0, 0, this.getWidth(), this.getWidth());
		g.setColor(couleurForme);
			if(this.morph)
			{
				drawMorph(g);
			}else {
				draw(g);
			}
	}
	public void setCouleurFond (Color color){
		this.couleurFond = color;
		}
		/**
		* Méthode qui redéfinit la couleur de la forme
		* @param color
		*/
		public void setCouleurForme(Color color){
		this.couleurForme = color;
		}
	private void draw(Graphics g)
	{
		if(this.forme.equals("ROND"))
		{
			g.fillOval(posX, posY, 50, 50);
		}
		if(this.forme.equals("CARRE"))
		{
			g.fillRect(posX, posY, 50, 50);
		}
		if(this.forme.equals("TRIANGLE")){
			int s1X = posX + drawSize/2;
			int s1Y = posY;
			int s2X = posX + drawSize;
			int s2Y = posY + drawSize;
			int s3X = posX;
			int s3Y = posY + drawSize;
			int[] ptsX = {s1X, s2X, s3X};
			int[] ptsY = {s1Y, s2Y, s3Y};
			g.fillPolygon(ptsX, ptsY, 3);
			}
			if(this.forme.equals("ETOILE")){
			int s1X = posX + drawSize/2;
			int s1Y = posY;
			int s2X = posX + drawSize;
			int s2Y = posY + drawSize;
			g.drawLine(s1X, s1Y, s2X, s2Y);
			int s3X = posX;
			int s3Y = posY + drawSize/3;
			g.drawLine(s2X, s2Y, s3X, s3Y);
			int s4X = posX + drawSize;
			int s4Y = posY + drawSize/3;
			g.drawLine(s3X, s3Y, s4X, s4Y);
			int s5X = posX;
			int s5Y = posY + drawSize;
			g.drawLine(s4X, s4Y, s5X, s5Y);
			g.drawLine(s5X, s5Y, s1X, s1Y);
			}
	}
	private void drawMorph(Graphics g){
		//On incrémente le tour
		increment++;
		//On regarde si on doit réduire ou non
		if(drawSize >= 50)reduce = true;
		if(drawSize <= 30)reduce = false;
		if(reduce)
		drawSize = drawSize - getUsedSize();
		else
		drawSize = drawSize + getUsedSize();
		if(this.forme.equals("ROND")){
		g.fillOval(posX, posY, drawSize, drawSize);
		}
		if(this.forme.equals("CARRE")){
		g.fillRect(posX, posY, drawSize, drawSize);
		}
		if(this.forme.equals("TRIANGLE")){
		int s1X = posX + drawSize/2;
		int s1Y = posY;
		int s2X = posX + drawSize;
		int s2Y = posY + drawSize;
		int s3X = posX;
		int s3Y = posY + drawSize;
		int[] ptsX = {s1X, s2X, s3X};
		int[] ptsY = {s1Y, s2Y, s3Y};
		g.fillPolygon(ptsX, ptsY, 3);
		}
		if(this.forme.equals("ETOILE")){
		int s1X = posX + drawSize/2;
		int s1Y = posY;
		int s2X = posX + drawSize;
		int s2Y = posY + drawSize;
		g.drawLine(s1X, s1Y, s2X, s2Y);
		int s3X = posX;
		int s3Y = posY + drawSize/3;
		g.drawLine(s2X, s2Y, s3X, s3Y);
		int s4X = posX + drawSize;
		int s4Y = posY + drawSize/3;
		g.drawLine(s3X, s3Y, s4X, s4Y);
		int s5X = posX;
		int s5Y = posY + drawSize;
		g.drawLine(s4X, s4Y, s5X, s5Y);
		g.drawLine(s5X, s5Y, s1X, s1Y);
		}
		}
	private int getUsedSize(){
		int res = 0;
		if(increment / 10 == 1){
			System.out.println(increment);
		increment = 0;
		res = 1;
		}
		return res;
	}
	public int getDrawSize(){
		return drawSize;
		}
	public int getPosX() {
		return posX;
		}
	public boolean isMorph(){
		return morph;
		}
	public void setMorph(boolean bool){
		this.morph = bool;
		//On réinitialise la taille
		drawSize = 50;
		}
	public void setForme(String form){
		this.forme = form.toUpperCase();
		}
	
		public void setPosX(int posX) {
		this.posX = posX;
		}
		public int getPosY() {
		return posY;
		}
		public void setPosY(int posY) {
		this.posY = posY;
		}

}
