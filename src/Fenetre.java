import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
public class Fenetre extends JFrame {
	private JPopupMenu jpm = new JPopupMenu();
	private JMenu background = new JMenu("Couleur de fond");
	private JMenu couleur = new JMenu("Couleur de la forme");
	private JMenuItem launch = new JMenuItem("Lancerl'animation");
	private JMenuItem Stop = new JMenuItem("Arrêter l'animation");
	private JMenuItem rouge = new JMenuItem("Rouge"),
	bleu = new JMenuItem("Bleu"),
	vert = new JMenuItem("Vert"),
	rougeBack = new JMenuItem("Rouge"),
	bleuBack = new JMenuItem("Bleu"),
	vertBack = new JMenuItem("Vert");
	private JPanel container = new JPanel();
	private boolean stop = true;
	private Panneau pan = new Panneau();
	 private int compteur = 0;
	 private boolean backX, backY;
	 private int x,y ;
	 private Thread t;
	 private JMenuBar menuBar = new JMenuBar();
	 private JMenu animation = new JMenu("Animation"),
			 forme = new JMenu("Forme"),
			 typeForme = new JMenu("Type de forme"),
			 aPropos = new JMenu("À propos");
			 private JMenuItem lancer = new JMenuItem("Lancer l'animation"),
			 arreter = new JMenuItem("Arrêter l'animation"),
			 quitter = new JMenuItem("Quitter"),
			 aProposItem = new JMenuItem("?");
			 private JCheckBoxMenuItem morph = new JCheckBoxMenuItem("Morphing");
			 private JRadioButtonMenuItem carre = new JRadioButtonMenuItem("Carré"),
			 rond = new JRadioButtonMenuItem("Rond"),
			 triangle = new JRadioButtonMenuItem("Triangle"),
			 etoile = new JRadioButtonMenuItem("Etoile");
			 private ButtonGroup bg = new ButtonGroup();
			//Création de notre barre d'outils
			 private JToolBar toolBar = new JToolBar();
			 //Les boutons
			 private JButton play = new JButton(new ImageIcon("images/play.jpg")),
			 cancel = new JButton(new ImageIcon("images/stop.jpg")),
			 square = new JButton(new ImageIcon("images/carré.jpg")),
			 tri = new JButton(new ImageIcon("images/triangle.jpg")),
			 circle = new JButton(new ImageIcon("images/rond.jpg")),
			 star = new JButton(new ImageIcon("images/étoile.jpg"));
			 private Color fondBouton = Color.white;
	 public void setstop(boolean bool)
	 {
		 this.stop = bool;
	 }
	 public boolean getstop()
	 {
		 return this.stop;
	 }
	Fenetre()
	{
		this.setTitle("Animation");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		pan.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent event){
			if(event.isPopupTrigger())
			{
			background.add(rougeBack);
			background.add(bleuBack);
			background.add(vertBack);
			couleur.add(rouge);
			couleur.add(bleu);
			couleur.add(vert);
			jpm.add(launch);
			jpm.add(Stop);
			jpm.add(couleur);
			jpm.add(background);
			//La méthode qui va afficher le menu
			jpm.show(pan, event.getX(), event.getY());
			}
			}
			});
		container.add(pan, BorderLayout.CENTER);
		this.setContentPane(container);
		this.initMenu();
		this.initToolBar();
		this.setVisible(true);
	}
	private void initToolBar(){
		this.cancel.setEnabled(false);
		this.cancel.addActionListener(new ArreterListener());
		this.cancel.setBackground(fondBouton);
		this.play.addActionListener(new LancerListener());
		this.play.setBackground(fondBouton);
		this.toolBar.add(play);
		this.toolBar.add(cancel);
		this.toolBar.addSeparator();
		//Ajout des Listeners
		this.circle.addActionListener(new FormeListener());
		this.circle.setBackground(fondBouton);
		this.toolBar.add(circle);
		this.square.addActionListener(new FormeListener());
		this.square.setBackground(fondBouton);
		this.toolBar.add(square);
		this.tri.setBackground(fondBouton);
		this.tri.addActionListener(new FormeListener());
		this.toolBar.add(tri);
		this.star.setBackground(fondBouton);
		this.star.addActionListener(new FormeListener());
		this.toolBar.add(star);
		this.add(toolBar, BorderLayout.NORTH);
	}
	private void initMenu() {
		lancer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_MASK));
		aProposItem.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent arg0) {
			JOptionPane jop = new JOptionPane();
			ImageIcon img = new ImageIcon("images/icone.png");
			String mess = "Merci ! \n J'espère que vous vous amusez bien !\n";
			mess += "Je crois qu'il est temps d'ajouter des accélérateurs etdes mnémoniques dans tout ça...\n";
			mess += "\n Allez, GO les ZérOs !";
			jop.showMessageDialog(null, mess, "À propos",JOptionPane.INFORMATION_MESSAGE, img);
			}
			});
		//Menu animation
		morph.addActionListener(new MorphListener());
		lancer.addActionListener(new LancerListener());
		arreter.addActionListener(new ArreterListener());
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent event){
				System.exit(0);
				}
		});
		animation.add(lancer);
		arreter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
		arreter.setEnabled(false);
		animation.add(arreter);
		animation.addSeparator();
		//Pour quitter l'application
		quitter.addActionListener(new ActionListener(){
		public void actionPerformed (ActionEvent event){
		System.exit(0);
		}
		});
		animation.add(quitter);
		//Menu forme
		bg.add(carre);
		bg.add(triangle);
		bg.add(rond);
		bg.add(etoile);
		typeForme.add(rond);
		typeForme.add(carre);
		typeForme.add(triangle);
		typeForme.add(etoile);
		CouleurFormeListener frmColor = new CouleurFormeListener();
		rouge.addActionListener(frmColor);
		bleu.addActionListener(frmColor);
		vert.addActionListener(frmColor);
		CouleurFondListener bgColor = new CouleurFondListener();
		rougeBack.addActionListener(bgColor);
		bleuBack.addActionListener(bgColor);
		vertBack.addActionListener(bgColor);
		carre.addActionListener(new FormeListener());
		rond.addActionListener(new FormeListener());
		triangle.addActionListener(new FormeListener());
		etoile.addActionListener(new FormeListener());
		//typeForme.add(new FormeListener());
		rond.setSelected(true);
		forme.add(typeForme);
		forme.add(morph);
		//menu à propos
		aPropos.add(aProposItem);
		//Ajout des menus dans la 
		animation.setMnemonic('A');
		menuBar.add(animation);
		forme.setMnemonic('F');
		menuBar.add(forme);
		aPropos.setMnemonic('P');
		menuBar.add(aPropos);
		
		//Ajout de la barre de menus sur la fenêtre
		this.setJMenuBar(menuBar);
	}
	private void go()
	{
		x = pan.getPosX();
		y = pan.getPosY();
			while(this.stop)
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
					Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
	}
class LancerListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane jop = new JOptionPane();
		int option = jop.showConfirmDialog(null, "Voulez-vous lancerl'animation ?", "Lancement de l'animation",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		if(option ==JOptionPane.OK_OPTION)
		{
		stop = true;
		Stop.setEnabled(true);
		t = new Thread(new Playanimation());
		t.start();
		play.setEnabled(false);
		cancel.setEnabled(true);
		lancer.setEnabled(false);
		launch.setEnabled(false);
		arreter.setEnabled(true);
		}
		
	}
}
class CouleurFondListener implements ActionListener{
public void actionPerformed (ActionEvent e) {
if(e.getSource() == vertBack)
pan.setCouleurFond (Color.green);
else if (e.getSource() == bleuBack)
pan.setCouleurFond (Color.blue);
else if(e.getSource() == rougeBack)
pan.setCouleurFond (Color.red);
else
pan.setCouleurFond (Color.white);
}
}
	class ArreterListener implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			JOptionPane jopStop = new JOptionPane();
			int optionStop = jopStop.showConfirmDialog(null, "Voulez-vous arreter l'animation ?", "Lancement de l'animation",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(optionStop == JOptionPane.OK_OPTION)
			{
			System.out.println(t.getState());
			stop = false;
			launch.setEnabled(true);
			Stop.setEnabled(false);
			play.setEnabled(true);
			cancel.setEnabled(false);
			arreter.setEnabled(false);
			lancer.setEnabled(true);
			}
		}
	}
	class Playanimation implements Runnable
	{
		public void run()
		{
			go();
		}
	}
	class CouleurFormeListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			if(e.getSource() == vert)
			pan.setCouleurForme(Color.green);
			else if (e.getSource() == bleu)
			pan.setCouleurForme(Color.blue);
			else if(e.getSource() == rouge)
			pan.setCouleurForme(Color.red);
			else
			pan.setCouleurForme(Color.white);
			}
			}
	class FormeListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			//Si l'action vient d'un bouton radio du menu
			if(e.getSource().getClass().getName().equals("javax.swing.JRadioButtonMenuItem"))
			pan.setForme(((JRadioButtonMenuItem)e.getSource()).getText());
			else{
			if(e.getSource() == square){
			carre.doClick();
			}
			else if(e.getSource() == tri){
			triangle.doClick();
			}
			else if(e.getSource() == star){
			etoile.doClick();
			}
			else{
			rond.doClick();
			}
			}
		}
	}
	class MorphListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
		//Si la case est cochée, activation du mode morphing
		if(morph.isSelected())pan.setMorph(true);
		//Sinon rien !
		else pan.setMorph(false);
		}
		}
	}