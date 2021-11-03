import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;

@SuppressWarnings("serial")
public class GUI extends JFrame{

	MapSize size=new MapSize();
		public GUI(String title) {
		Map map=new Map(size);
		DrawBorad d=new DrawBorad(size, map);
		setTitle("OmokJomok");
		getContentPane().add(d);
		this.setBounds(200,20,650,700);
		this.setBackground(new Color(206,167,61));
		addMouseListener(new MouseEventHandler(map, size,d,this));
		setVisible(true);
		setResizable(false);
		setTitle("OmokJomok");
		// TODO Auto-generated constructor stub

		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uD30C\uC77C");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\uBA54\uB274\uD654\uBA74\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrame();
				setVisible(false);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uC885\uB8CC");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("\uB418\uB3CC\uB9AC\uAE30");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\uD55C \uC218 \uBB34\uB974\uAE30");
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void showPopUp(String message) {
		JOptionPane.showMessageDialog(this, message,"축하합니다",JOptionPane.INFORMATION_MESSAGE);
		   new MainFrame();
		   setVisible(false);
	}
}
