package mayinTarlasi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class custom extends JFrame {
	
	  static int yuk;
	 static int gen;
	 static int myn;
	 static boolean cikis=false;
	
	private JPanel contentPane;
	private JTextField yukseklik;
	private JTextField genislik;
	private JTextField mayinSys;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					custom frame = new custom();
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
	public custom() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u00D6zel");
		setBounds(100, 100, 249, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Y\u00FCkseklik:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblNewLabel.setBounds(34, 53, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGenilik = new JLabel("Geni\u015Flik:");
		lblGenilik.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblGenilik.setBounds(44, 5, 63, 27);
		contentPane.add(lblGenilik);
		
		JLabel lblMaynSays = new JLabel("May\u0131n Say\u0131s\u0131:");
		lblMaynSays.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblMaynSays.setBounds(17, 85, 95, 19);
		contentPane.add(lblMaynSays);
		
		yukseklik = new JTextField();
		yukseklik.setBounds(117, 10, 86, 20);
		contentPane.add(yukseklik);
		yukseklik.setColumns(10);
		
		genislik = new JTextField();
		genislik.setColumns(10);
		genislik.setBounds(117, 52, 86, 20);
		contentPane.add(genislik);
		
		mayinSys = new JTextField();
		mayinSys.setColumns(10);
		mayinSys.setBounds(117, 86, 86, 20);
		contentPane.add(mayinSys);
		
		JButton tamam = new JButton("Tamam");
		tamam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yuk = Integer.parseInt(yukseklik.getText());
				gen=Integer.parseInt(genislik.getText());
				myn=Integer.parseInt(mayinSys.getText());
				
				System.out.println(cikis); 
				cikis=true;
				if (cikis==true) {
		            
		            	
		            	board.satirSayisi=gen;
		            	board.sutunSayisi=yuk;
		            	board.mayinSayisi=myn;
		            	
		            	//board.panelGenislik=board.sutunSayisi * board.hucreBoyutu +1;
		            	//board.panelUzunluk=board.satirSayisi * board.hucreBoyutu + 1;
		            	
		            	board.yeniOyun();
		            	
		            	
		            	
		               // main.ex.setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-50), (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-150));
		               int x=(int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
		               int y=(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		            	main.ex.setBounds(0,0,x,y);
		            	
		        		main.mayinSay.setBounds(0,y/-10,300,300);
		        		
		        		board.face.setBounds(x/2-20,10,60,60);
		        		
		        
		        		board.timer.setBounds(x-60,5,200,60);
		            	
		                repaint();		
					
				}
				
				setVisible(false);
				repaint();
				
				
				
				
				
			}
		});
		tamam.setBounds(17, 141, 89, 23);
		contentPane.add(tamam);
		
		JButton btnk = new JButton("\u00C7\u0131k\u0131\u015F");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnk.setBounds(119, 141, 89, 23);
		contentPane.add(btnk);
	}
}
