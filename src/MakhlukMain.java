import java.util.*;
import java.io.*;
public class MakhlukMain {

	private static ListMakhluk L;
	private static Board B;
	private static Random rand;
	private static int rx,ry;

	private static void AddMakhluk(ListMakhluk L){
		int jenis = rand.nextInt(11) + 1;
		Makhluk M;

		int y = rand.nextInt(B.Bwidth);
		int x = rand.nextInt(B.Blength);
		rx = x;
		ry = y;
		if(jenis == 1){

	        M = new Predator(y,x);
	        L.insert(M);
	    }
	    else if(jenis == 2){
	        M = new Ghost(y,x);
	        L.insert(M);
	    }
	    else if(jenis == 3){
	        M = new Alien(y,x);
	        L.insert(M);
	    }
	    else if(jenis == 4 || jenis == 5){
	        M = new Military(y,x);
	        L.insert(M);
	    }
	    else if(jenis == 6 || jenis == 7){
	        M = new Knight(y,x);
	        L.insert(M);
	    }
	    else if(jenis == 8 || jenis == 9){
	        M = new Artist(y,x);
	        L.insert(M);
	    }
	    else if(jenis == 10 || jenis==11){
	        M = new GhostBuster(y,x);
	        L.insert(M);
	    }
	}

	private static void Init(ListMakhluk L){

		int jumlah = 1;


		for(int it = 1; it <= jumlah; it++){
			AddMakhluk(L);
		}
	}

	private static void moveL(int it){
	  	if(L.get(it).getX() + L.get(it).getdeltaX() < 0)
			L.get(it).setX(L.get(it).getX() + L.get(it).getdeltaX() + B.Bwidth);
		else
			L.get(it).setX((L.get(it).getX() + L.get(it).getdeltaX()) % B.Bwidth);


		if((L.get(it).getY() + L.get(it).getdeltaY()) < 0)
			L.get(it).setY(L.get(it).getY() + L.get(it).getdeltaY() + B.Blength);
		else
			L.get(it).setY((L.get(it).getY() + L.get(it).getdeltaY()) % B.Blength);
	}

	public static void main(String argc[]) throws InterruptedException{
		B = new Board(3,3,1);
		boolean stop = false;
		boolean step = false;
		int key;
		KeyListeners T = new KeyListeners("Control Board");
		ArrayList <Integer>  TempatHapus = new ArrayList <Integer>();
		Scanner in = new Scanner(System.in);
		L = new ListMakhluk();
		rand = new Random();
		

		Init(L);

		do{
			do{
				for(int it=0; it < L.neff(); it++ ){
					moveL(it);
					if( L.get(it) instanceof Military) {
						if( ( (Military) L.get(it) ).getTurn() >= Makhluk.TM ){
							if( ((Military) L.get(it) ).getShape() == Makhluk.SM  ){
								((Military) L.get(it)).camouflage();
							}
							else{
								((Military) L.get(it)).uncamouflage();
							}
							((Military) L.get(it)).setTurn(0);
						}
						else{
							((Military) L.get(it)).setTurn( ((Military)L.get(it)).getTurn() + 1 );
						}

					}
				}
				System.out.print("\033[H\033[2J");  
				//System.out.flush();  
				
				//System.out.println(rx+" "+ry);
				B.PrintBoard(L,"System.out");
				for(int it = 0; it < L.neff(); it++){
					System.out.print(L.get(it).getShape()+" ");
				}
				System.out.println("");

				for(int it = 0; it < L.neff(); it++){
					if(L.get(it) instanceof Ghost){
						System.out.print("Ghost at (" + L.get(it).getY() + " , " + L.get(it).getX() + " ) says : ");
						((Ghost) L.get(it)).spook();
					}
					else if(L.get(it) instanceof Artist){
						System.out.print("Artist at (" + L.get(it).getY() + " , " + L.get(it).getX() + " ) says : ");	
						((Artist) L.get(it)).sing();
					}

					if(L.get(it) instanceof Human){
						if ( ((Human) L.get(it)).getUmur() >= Makhluk.OH ){
							TempatHapus.add(it);
							System.out.println("Unable to reach immortality, Human at ( " + L.get(it).getY() + " , " + L.get(it).getX() + " ) going  to heaven disgracefully");

						}
						else{
							((Human) L.get(it)).addUmur();
						}
					}
				}

				if(TempatHapus.isEmpty()==false){
					for(int idx = TempatHapus.size()-1; idx >= 0; idx--){
						L.delete(L.search(L.get(TempatHapus.get(idx))));
					}
				}

				TempatHapus.clear();
				System.out.println("");

				Thread.sleep(300);

				if(L.isListEmpty()){
					stop = true;
				}
				else if(step == true){
					key = 0;
					while(step == true && key != KeyListeners.KS && key != KeyListeners.KA && key != KeyListeners.KK && stop == false){
						key = T.getKunci();

						if(key == KeyListeners.KP){
							String path;
							System.out.print("Simpan kemana : ");
							path = in.next();
							B.PrintBoard(L,path);

						}
						else if(key == KeyListeners.KA){
							AddMakhluk(L);
						}
						else if(key == KeyListeners.KC){
							step = false;
						}
						else if(key == KeyListeners.KQ){
							stop = true;
						}
						else if(key == KeyListeners.KK){
							int victim = rand.nextInt(L.neff());
							System.out.print("God has decided that ");
							if(L.get(victim) instanceof Human){
								System.out.print(" Human at ");
							}
							else{
								System.out.print(" InHuman at ");	
							}
							System.out.println("( " + L.get(victim).getY() + " " + L.get(victim).getX() + " ) will come to his side" );
							L.delete(L.search(L.get(victim)));
						}
					}
				}
				key = T.getKunci();
			}
			while( key == 0 && stop == false );

			if(key == KeyListeners.KP){
				String path;
				System.out.print("Simpan kemana : ");
				path = in.next();
				B.PrintBoard(L,path);

			}
			else if(key == KeyListeners.KA){
				AddMakhluk(L);
			}
			else if(key == KeyListeners.KC){
				step = false;
			}
			else if(key == KeyListeners.KS){
				step = true;
			}
			else if(key == KeyListeners.KQ){
				stop = true;
			}
			else if(key == KeyListeners.KK){
				int victim = rand.nextInt(L.neff());
				System.out.print("God has decided that ");
				if(L.get(victim) instanceof Human){
					System.out.print(" Human at ");
				}
				else{
					System.out.print(" InHuman at ");	
				}
				System.out.println("( " + L.get(victim).getY() + " " + L.get(victim).getX() + " ) will come to his side" );
				L.delete(L.search(L.get(victim)));
			}

			if(L.isListEmpty() ){
				stop = true;
			}
		}
		while(stop == false);
	}


}