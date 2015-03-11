package bilou;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class dialogSetup extends JDialog implements ItemListener,ActionListener
{
	// résolution X
	private int screenX = 1024;
	
	// résolution Y
	private int screenY = 768;
	
	// fullscreen
	private boolean isFullScreen = false;
	
	private JComboBox comboResolution;
	
	private final String[] RESOLUTION = {"800 X 600","1024 X 768","1152 X 864","1280 X 720","1280 X 768","1280 X 800","1280 X 960",
			"1280 X 1024","1360 X 768","1366 X 768","1400 X 1050","1440 X 900","1600 X 900","1600 X 1024","1680 X 1050","1920 X 1080"};
	private JButton buttonLancer;
	private JLabel lblNewLabel_1;
	private JRadioButton radioOui;
	private JRadioButton radioNon;
	
	public dialogSetup(JFrame frame,String titre,boolean modal)
	{
		super(frame,titre,modal);
		
		this.setSize(640, 480);
		getContentPane().setLayout(null);
		
		comboResolution = new JComboBox();
		comboResolution.setActionCommand("RESOLUTION");
		comboResolution.addItemListener(this);
		
		comboResolution.setModel(new DefaultComboBoxModel(RESOLUTION));
		comboResolution.setBounds(173, 69, 214, 20);
		getContentPane().add(comboResolution);
		
		JLabel lblNewLabel = new JLabel("r\u00E9solution \u00E0 l'\u00E9cran :");
		lblNewLabel.setBounds(10, 72, 153, 14);
		getContentPane().add(lblNewLabel);
		
		buttonLancer = new JButton("New button");
		buttonLancer.setActionCommand("LANCER");
		buttonLancer.setBounds(535, 384, 89, 23);
		getContentPane().add(buttonLancer);
		
		lblNewLabel_1 = new JLabel("FullScreen:");
		lblNewLabel_1.setBounds(10, 118, 108, 14);
		getContentPane().add(lblNewLabel_1);
		 
		ButtonGroup group = new ButtonGroup();
		
		radioOui = new JRadioButton("Oui");
		radioOui.setBounds(173, 114, 109, 23);
		getContentPane().add(radioOui);
		
		radioNon = new JRadioButton("Non");
		radioNon.setBounds(278, 114, 109, 23);
		getContentPane().add(radioNon);
		
		radioNon.setSelected(true);
		
				
		group.add(radioOui);
		group.add(radioNon);
		
		
		buttonLancer.addActionListener(this);
		
		// 
		this.setLocationRelativeTo(null);
	
		
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		
		
		String res = (String)this.comboResolution.getSelectedItem();
		
		String[] val = res.split("X");
		
		if(val != null && val.length == 2)
		{
			this.screenX = Integer.parseInt(val[0].trim());
			this.screenY = Integer.parseInt(val[1].trim());
		}
		else
		{
			this.screenX = 1024;this.screenY = 768;
		}
	
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getActionCommand().equals("LANCER"))
		{
			this.setVisible(false);
		}
		
	}

	
	
	public boolean isFullScreen()
	{
		if(this.radioOui.isSelected())
		{
			isFullScreen = true;
		}
		else
			isFullScreen = false;
		
		return isFullScreen;
	}

	public void setFullScreen(boolean isFullScreen) {
		this.isFullScreen = isFullScreen;
	}

	public int getScreenX() {
		return screenX;
	}

	public void setScreenX(int screenX) {
		this.screenX = screenX;
	}

	public int getScreenY() {
		return screenY;
	}

	public void setScreenY(int screenY) {
		this.screenY = screenY;
	}
}
