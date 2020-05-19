package mayinTarlasi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class main extends JFrame {
	
	static JLabel mayinSay;
	static int milliseconds =  0;
	static int seconds =0;
	static boolean state=true;
	static JFrame ex;
	  
	
	public main() {
		
		calistir();
		
		
		
	}
	
	private void calistir() {
		
		
		//oyun menusunu ekledim istenenler doðrultusunda eklemer yaptým

		 JMenuBar menu = new JMenuBar();
        
        JMenu oyun= new JMenu("Oyun");
        menu.add(oyun);
        	JMenuItem yeniOyun=new JMenuItem("Yeni Oyun");
        	oyun.add(yeniOyun);
        	yeniOyun.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	
	                board.yeniOyun();
	                
					repaint();
	                
	            }
	        });
        	
        	
        	yeniOyun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
       JPopupMenu.Separator s1=new JPopupMenu.Separator();
       oyun.add(s1);
		    JMenuItem kolay=new JMenuItem("Kolay");
		   	oyun.add(kolay);
		   	
		       kolay.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	board.satirSayisi=9;
		            	board.sutunSayisi=9;
		            	board.mayinSayisi=10;
		            	
		               
		            	board.panelGenislik=board.sutunSayisi * board.hucreBoyutu +1;
		            	board.panelUzunluk=board.satirSayisi * board.hucreBoyutu + 1;
		               
		                
		                board.yeniOyun();
		                
		                ex.setSize(board.panelGenislik+15,board.panelUzunluk+150);
		                board.timer.setBounds(board.panelGenislik-60,5,60,60);
		                board.face.setBounds(board.panelGenislik-160,5,60,60);
		        		mayinSay.setBounds(10,board.panelUzunluk-390,300,300);
		                
		                
		                
						repaint();
						 System.out.println(board.panelGenislik+" "+ board.panelUzunluk);
		            }
		        });
		   	
		   	
		   	
		   	JMenuItem orta=new JMenuItem("Orta");
		   	oyun.add(orta);
		   	
		   	
		       orta.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	board.satirSayisi=16;
		            	board.sutunSayisi=16;
		            	board.mayinSayisi=40;
		                
		            	board.panelGenislik=board.sutunSayisi * board.hucreBoyutu +1;
		            	board.panelUzunluk=board.satirSayisi * board.hucreBoyutu + 1;
		                
		            	board. yeniOyun();
		            	
		                ex.setSize(board.panelGenislik+20,board.panelUzunluk+145);
		        		mayinSay.setBounds(10,board.panelUzunluk/2-350,300,300);
		        		
		        		board.face.setBounds(board.panelGenislik/2-50,10,60,60);
		        		
		        
		        		board.timer.setBounds(board.panelGenislik-70,5,200,60);
		                
		            	
		            	
						repaint();
		                
		            }
		        });
		   	
		   	
		   	JMenuItem zor=new JMenuItem("Zor");
		   	oyun.add(zor);
		   	
		       zor.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		            	board.satirSayisi=16;
		            	board.sutunSayisi=30;
		            	board.mayinSayisi=90;
		                
		            	board.panelGenislik=board.sutunSayisi * board.hucreBoyutu +1;
		            	board.panelUzunluk=board.satirSayisi * board.hucreBoyutu + 1;
		                
		            	board.yeniOyun();
		            	
		                ex.setSize(board.panelGenislik+15,board.panelUzunluk+150);
		        		mayinSay.setBounds(10,board.panelUzunluk/2-350,300,300);
		        		
		        		board.face.setBounds(board.panelGenislik/2-50,10,60,60);
		        		
		        
		        		board.timer.setBounds(board.panelGenislik-70,5,200,60);
		            	
		            	
		            	
						repaint();
		                
		            }
		        });
		   	
		   	
		   	
		   	
		   	
		   	JMenuItem ozel=new JMenuItem("Özel");
		   	oyun.add(ozel);
		   	
		   	 custom ozel1 =new custom();
		   	 
		       ozel.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                
		                ozel1.setVisible(true);
		                
		                
		                

		        		
		                System.out.println(ozel1.gen);
		                System.out.println(ozel1.cikis);
		                
		               
	               
			                }
		            
		        });
		   	

		   	
		 JPopupMenu.Separator s2=new JPopupMenu.Separator();
		 oyun.add(s2); 
			 JMenuItem cikis=new JMenuItem("Çýkýþ");
	     	 oyun.add(cikis);
		 
        JMenu yardim= new JMenu("Yardým");
        JMenu soon= new JMenu("	Çok Yakýnda");
        yardim.add(soon);
	       
        
        

        menu.add(yardim);
        
       cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        
        setJMenuBar(menu);
        
        
        //gülen yüzü ekleyip basýldýðýnda yeni oyuna baþlatmasýný saðladým
        board.face =new JLabel();
        board.face.setIcon(new ImageIcon(getClass().getResource("/resim/smile.png")));
        board.face.setOpaque(true);
		
		
		
        board.face.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	board.yeniOyun();
              repaint();
            }
        });
        
        
        
      
        //timer labelini ekleyip ayarladým
        board.timer =new JLabel("0");
        board.timer.setFont(new java.awt.Font("Digital-7", 2, 60));
        board.timer.setForeground(Color.red);
        
        
		
		
	
		mayinSay=new JLabel("");
	
		
		add(mayinSay);
		mayinSay.setBounds(10,board.panelUzunluk/2-350,300,300);
		
		
		
		add( board.face);
		board.face.setBounds(board.panelGenislik/2-50,10,60,60);
		
		
		add(board.timer);
		board.timer.setBounds(board.panelGenislik-70,5,200,60);
		
		
		
		add(new board(mayinSay));
		

		setResizable(false);
		pack();
		 
        setTitle("Mayýn Tarlasý");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resim/icons8_naval_mine_50px_1.png")));
    	repaint();
		
	}
	
	public static void main(String[] args) {
		
        EventQueue.invokeLater(() -> {

           ex = new main();
            ex.setVisible(true);
        
         
            
            
        });

	}

}
