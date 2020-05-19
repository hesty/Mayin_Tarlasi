package mayinTarlasi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class board extends JPanel {
	
	static int resimSayisi=13;
	static int hucreBoyutu=30; //pixel
	
	static  int kapaliHucreler=10;
	static int isaretliHucreler=10;
	static int bosHucreler=0;
	static int mayinHucreleri=9;
	
	static int kapaliIsaretlenmisMayinHucreleri=mayinHucreleri+kapaliHucreler;
	static int isaretliMayinHucreleri=kapaliIsaretlenmisMayinHucreleri+isaretliHucreler;
	
	static int mayinResimNo=9;
    static int kapaliResimNo=10;
	static int isaretlenmisHucreResimNo=11;
	static int patlakBayrakResimNo=12;
	
	static int mayinSayisi=10;
	static int satirSayisi=16;
	static int sutunSayisi=16;
	
	static int panelGenislik=sutunSayisi * hucreBoyutu +1;
	static int panelUzunluk=satirSayisi * hucreBoyutu + 1;
	
	static int [] alan;
	static boolean oyunDamý;
	static int mayinKal;
	static Image []resim;
	static Image iconSmile;
	static Image iconSad;
	
	static int tumHucreler;
	static JLabel mayinSay;
	static JMenuBar menu;
	static JLabel face;
	static JLabel timer;
	
	private static JPanel panel;
	
	
	public board(JLabel mayinSay) {
		
		
		this.mayinSay=mayinSay;
		//mayin sayýsýný yazdýran labeli düzenledim.
		mayinSay.setFont(new java.awt.Font("Digital-7", 2, 60));
		mayinSay.setForeground(Color.red);
		
		resimYukle();
	}
	//resim dizisini yükledim ve PreferredSize ayarladým ama çalýþtýrmadým :(
	private void resimYukle() {
		setPreferredSize(new Dimension(panelGenislik,panelUzunluk+85));
		
		  System.out.println(panelGenislik+" "+ panelUzunluk);
		
		resim = new Image[resimSayisi];
		
		for (int i = 0; i < resimSayisi; i++) {
			 var path="src/resim/" + i + ".png";
			 resim[i] = (new ImageIcon(path)).getImage();
			
		}
		
		addMouseListener(new mayinAdapter());
		yeniOyun();
	}
	
	
	public static   void yeniOyun() {
		
		int hucre;
		
		
		var random=new Random();
		
		oyunDamý=true;

		mayinKal=mayinSayisi;
		
		
		tumHucreler=satirSayisi*sutunSayisi;
		alan=new int [tumHucreler];
		
		
		for (int i = 0; i < tumHucreler; i++) {
			
			alan[i]=kapaliHucreler;
		
			
		}
		
		mayinSay.setText(Integer.toString(mayinKal));
		
		int i=0;
		
		while (i<mayinSayisi) {
		
			int pozisyon=(int) (tumHucreler*random.nextDouble());
			
				if ((pozisyon<tumHucreler)
					&& (alan[pozisyon] != kapaliIsaretlenmisMayinHucreleri)) {
				
				int mevcutSutun=pozisyon % sutunSayisi;
				alan[pozisyon]= kapaliIsaretlenmisMayinHucreleri;
				i++;
				
					if(mevcutSutun>0) {
						hucre=pozisyon - 1 - sutunSayisi;
							if (hucre >= 0) {
								if (alan[hucre] != kapaliIsaretlenmisMayinHucreleri) {
									alan[hucre] += 1;
								}
								
							}
							hucre=pozisyon - 1;
							if (hucre >= 0) {
								if (alan[hucre] != kapaliIsaretlenmisMayinHucreleri) {
									alan[hucre] += 1;
								
								}	
							}
							
							hucre=pozisyon+sutunSayisi-1;
							if (hucre<tumHucreler) {
								if (alan[hucre] != kapaliIsaretlenmisMayinHucreleri) {
									alan[hucre] +=1;
									
								}
							}
					}
					
					hucre = pozisyon - sutunSayisi;
					if (hucre >= 0) {
						if (alan[hucre] != kapaliIsaretlenmisMayinHucreleri) {
							alan[hucre] += 1;
							 
							
						}
						
					}
					
					hucre = pozisyon + sutunSayisi;
					if (hucre < tumHucreler) {
						if (alan[hucre] != kapaliIsaretlenmisMayinHucreleri) {
							alan[hucre] +=1;
							
						}
					}
					
					if (mevcutSutun < (sutunSayisi-1)) {
						hucre = pozisyon - sutunSayisi + 1;
						if (hucre >= 0) {
							if (alan[hucre] != kapaliIsaretlenmisMayinHucreleri) {
								alan[hucre] +=1;
								
							}
						}
						hucre = pozisyon + sutunSayisi + 1;
						if (hucre<tumHucreler) {
							if (alan[hucre] != kapaliIsaretlenmisMayinHucreleri) {
								alan[hucre] +=1;
								
							}
						}
						hucre = pozisyon + 1;
						if (hucre < tumHucreler) {
							if (alan[hucre] != kapaliIsaretlenmisMayinHucreleri) {
								alan[hucre] += 1;
								
							}
						}	
					}
				}	
			}
		
		}
				
		
	private void bosHucreBul(int j) {
		
		int varsayilanSutun = j % sutunSayisi;
		int hucre;
		
		//Burda kapalý bir hücreyi kontrol ediyoruz boþ deðilse ortaya çýkartýyorux. Boþsa tekrar fonksiyonu çaðýrýyoruz
		if (varsayilanSutun > 0) {
			hucre = j - sutunSayisi - 1;
			if (hucre>=0) {
				if (alan[hucre] > mayinHucreleri) {
					alan[hucre] -= kapaliHucreler;
					if (alan[hucre] == bosHucreler) {
						bosHucreBul(hucre);
					}
				}
			}
			
			hucre = j - 1;
			if (hucre >= 0) {
				if (alan[hucre] > mayinHucreleri) {
					alan[hucre] -= kapaliHucreler;
					if (alan[hucre] == bosHucreler) {
						bosHucreBul(hucre);
					}
					
				}
			}
			
			hucre = j + sutunSayisi - 1;
			if (hucre < tumHucreler) {
				if (alan[hucre] > mayinHucreleri) {
					alan[hucre] -= kapaliHucreler;
					if (alan[hucre] == bosHucreler) {
						bosHucreBul(hucre);
					}
				}
			}
		}
		
		hucre = j - sutunSayisi;
		if (hucre >= 0) {
			if (alan[hucre] > mayinHucreleri) {
				alan[hucre] -= kapaliHucreler;
				if (alan[hucre] == bosHucreler) {
					bosHucreBul(hucre);
				}
			}
		}
	hucre = j + sutunSayisi;
	if (hucre < tumHucreler) {
		if (alan[hucre] > mayinHucreleri) {
			alan[hucre] -= kapaliHucreler;
			if (alan[hucre] == bosHucreler) {
				bosHucreBul(hucre);
			}
		}
	}
	
	if (varsayilanSutun < (sutunSayisi - 1)) {
		hucre = j - sutunSayisi + 1;
		if (hucre >= 0 ) {
			if (alan[hucre] > mayinHucreleri) {
				alan[hucre] -= kapaliHucreler;
				if (alan[hucre]==bosHucreler) {
					bosHucreBul(hucre);
				}
			}
		}
		
		hucre = j + sutunSayisi + 1;
		if (hucre < tumHucreler) {
			if (alan[hucre] > mayinHucreleri) {
				alan[hucre] -= kapaliHucreler;
				if (alan[hucre] == bosHucreler) {
					bosHucreBul(hucre);
				}
			}
		}
		
		hucre = j + 1;
		if (hucre < tumHucreler) {
			if (alan[hucre] > mayinHucreleri) {
				alan[hucre] -= kapaliHucreler;
				if (alan[hucre] == bosHucreler) {
					bosHucreBul(hucre);
				}
			}
		}
	 }
	
	}
	@Override
	public void paintComponent(Graphics g) {
		//componentleri çizdim. if elselerle göre fotoðraf çaðýrdým.
		setBounds(0,80,5000,5000);
		
		int ortayaCikan=0;
		
		for (int i = 0; i < satirSayisi; i++) {
			
			for (int j = 0; j < sutunSayisi; j++) {
				int hucre=alan[(i * sutunSayisi) + j];
				
					
				if (oyunDamý && hucre ==mayinHucreleri) {
					
					oyunDamý=false;
					
				}
				
				if (!oyunDamý) {
					
					if (hucre == kapaliIsaretlenmisMayinHucreleri) {
						hucre=mayinResimNo;
					}else if(hucre == isaretliMayinHucreleri){
						hucre=isaretlenmisHucreResimNo;
					}else if(hucre > kapaliIsaretlenmisMayinHucreleri) {
						hucre=patlakBayrakResimNo;
					}else if(hucre > mayinHucreleri) {
						hucre=kapaliResimNo;
					}
				}else {
					if (hucre > kapaliIsaretlenmisMayinHucreleri) {
						hucre=isaretlenmisHucreResimNo;
					}else if(hucre >mayinHucreleri) {
						hucre=kapaliResimNo;
						ortayaCikan++;
						face.setIcon(new ImageIcon(getClass().getResource("/resim/smile.png")));
					}
				}
				g.drawImage(resim[hucre],(j * hucreBoyutu),
						(i * hucreBoyutu),this);
			}
			
		}
		if (ortayaCikan==0 && oyunDamý) {
			
			oyunDamý=false;
			

			mayinSay.setText("Oleyy!");
			
			
		}else if(!oyunDamý) {
			
			face.setIcon(new ImageIcon(getClass().getResource("/resim/sad.png")));
			
			mayinSay.setText("X");
			
		}
		
		
		
		
		
		
		
		
		
	}
	//Bu fonksiyonda farenin x ve y kordinatlarýný alýp nereye basýldýðýný tespit ettim.
	public class mayinAdapter extends MouseAdapter{
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			int x = e.getX();
			int y = e.getY();
			
			int cStn=x / hucreBoyutu;
			int cStr=y / hucreBoyutu;
			
			boolean yenidenCiz=false;
			System.out.println();
			
		
			
			
			
			if (!oyunDamý) {
				
				
				yeniOyun();
				repaint();
			}
			
			if ((x < sutunSayisi *hucreBoyutu) && (y < satirSayisi*hucreBoyutu)) {
				
				if (e.getButton()==MouseEvent.BUTTON3) {
					
					
					if (alan[(cStr*sutunSayisi)+cStn]>mayinHucreleri) {
						yenidenCiz=true;
						
						if (alan[(cStr * sutunSayisi)+cStn]<=kapaliIsaretlenmisMayinHucreleri) {
							
							if (mayinKal>0) {
								alan[(cStr * sutunSayisi)+cStn] +=isaretliHucreler;
								mayinKal--;
								String msg=Integer.toString(mayinKal);
								
								mayinSay.setText(msg);
								
							}else {
								
								mayinSay.setText("Mayýn Kalmadý");
								
							}
							
						
					}else {
						alan[(cStr * sutunSayisi)+cStn] +=isaretliHucreler;
						mayinKal++;
						String msg=Integer.toString(mayinKal);
				
						mayinSay.setText(msg);
			
					}
				}
			} else {
				if (alan[(cStr * sutunSayisi)+cStn]>kapaliIsaretlenmisMayinHucreleri) {
					
					return;
				}
				
				
				if ((alan[(cStr * sutunSayisi)+cStn]>mayinHucreleri)
					&& (alan[(cStr * sutunSayisi)+cStn]<isaretliMayinHucreleri)){
					
					alan[(cStr * sutunSayisi)+cStn] -= kapaliHucreler;
					yenidenCiz=true;
					
					if (alan[(cStr * sutunSayisi)+cStn] == mayinHucreleri) {
						oyunDamý=false;
					}
					
					if (alan[(cStr * sutunSayisi)+cStn]==bosHucreler) {
						bosHucreBul((cStr * sutunSayisi)+cStn);
					}
				}
					
				
			}
				if (yenidenCiz) {
					
					//timer ekledim
					if (oyunDamý == true) {
						main.state =true;
		            	Thread t = new Thread() {
		            		
		            		public void run() {
		        
		            			for(;;) {
		                			if (main.state==true) {
		    							try {
		    								sleep(1);
		    								if (main.milliseconds>1000) {
		    									main.milliseconds = 0;
		    									main.seconds++;
												
											}
		    								
		    								
		    								main.milliseconds++;
		    								timer.setText(""+main.seconds);
		    								
		    								
		    								
		    								
		    							}catch (Exception e) {
											
										}
		    						}
		                			
		                			else {
		                				break;
		                			}
		            			}
		            		}
		            		
		            	};
		            	
		            	
		            	t.start(); 
					}
					else {
						main.seconds=0;
	
						main.state =false;
						
						
						
						
					}
					
					
					
					
					
					repaint();
					
				}
				
			}
			
		}
		
	}
	
	


}
