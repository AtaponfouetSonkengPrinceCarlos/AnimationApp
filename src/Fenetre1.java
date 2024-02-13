import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Fenetre1 extends JFrame {
	 private Panneau pan = new Panneau();
	   Boutton bouton = new Boutton("Bouton");
	 private JPanel container = new JPanel(); 
	 JLabel label = new JLabel("mon premier label");
	Fenetre1()
	{
		this.setTitle("Animation");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground (Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		container.add(bouton, BorderLayout.SOUTH);
		Font police = new Font("Tahoma", Font.BOLD, 16 );
		label.setFont(police);
		label.setForeground (Color.blue);
		label.setHorizontalAlignment(JLabel.CENTER);
		container.add(label, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);
		go();
	}
	private void go()
	{
		int x = pan.getPosX(), y = pan.getPosY();
		boolean backX = false;
		boolean backY = false;
		while(true)
		{
			if(x < 1)backX = false;
			if(x > pan.getWidth()-50)backX = true;
			if(y < 1)backY = false;
			if(y > pan.getHeight()-50)backY = true;
			if(!backX)
				pan.setPosX(++x);
			else
				pan.setPosX(--x);
			pan.repaint();
			try {
				Thread.sleep(0,00001);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}
