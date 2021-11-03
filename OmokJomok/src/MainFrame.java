import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	@SuppressWarnings("unused")
	private GUI GUI;
   private JPanel contentPane;
   private OnePlayerGUI oGui;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MainFrame frame = new MainFrame();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public MainFrame() {
      setResizable(false);
      setTitle("OmokJomok");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(200, 20, 650, 700);
      setVisible(true);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(new BorderLayout(0, 0));
      
      JPanel panel = new JPanel();
      panel.setBackground(Color.WHITE);
      contentPane.add(panel);
      panel.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uC624\uBAA9\uC870\uBAA9 OmokJomok");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 30));
      lblNewLabel.setBounds(53, 35, 558, 114);
      panel.add(lblNewLabel);
      
      JButton btnNewButton = new JButton("1 vs 1");
      btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 30));
      btnNewButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            GUI = new GUI(null);
            setVisible(false);
         }
      });
      btnNewButton.setBounds(135, 292, 420, 82);
      panel.add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("vs com");
      btnNewButton_1.setFont(new Font("±¼¸²", Font.PLAIN, 30));
      btnNewButton_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            //¸¶¿ì½º Å¬¸¯½Ã
        	 oGui = new OnePlayerGUI();
        	 setVisible(false);

         }
      });
      btnNewButton_1.setBounds(135, 374, 420, 82);
      panel.add(btnNewButton_1);
      
      JLabel lblNewLabel_1 = new JLabel("Menu");
      lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 50));
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setBounds(135, 176, 424, 106);
      panel.add(lblNewLabel_1);
      
      JButton btnNewButton_3 = new JButton("\uC885\uB8CC");
      btnNewButton_3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      btnNewButton_3.setFont(new Font("±¼¸²", Font.PLAIN, 30));
      btnNewButton_3.setBounds(135, 536, 420, 82);
      panel.add(btnNewButton_3);
      
      JButton btnNewButton_2 = new JButton("\uC7A5\uC560\uBB3C \uBC84\uC804");
      btnNewButton_2.setFont(new Font("±¼¸²", Font.PLAIN, 30));
      btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GUI(null);
	            setVisible(false);
	            GUI.obstacle=true;
	            Map.obstacle=true;
	            Map.checkobstacle();
			}
		});

      btnNewButton_2.setBounds(135, 455, 420, 82);
      panel.add(btnNewButton_2);
   }
}
