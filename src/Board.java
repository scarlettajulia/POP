import java.util.*;
import java.io.*;
/**
 * @author Friska/13514042.
 */
class Board {
	/**
	 * Atribut private Board berbentuk matriks list.
	 */ 
    private ArrayList<ArrayList<ArrayList<Integer>>> Papan;
    
    /**
     * Prosedur void startBertarung memulai bertarung jika sel penuh.
     * @param L sebuah argumen bertipe ListMakhluk.
     * @param v sebuah argumen bertipe vektor.
     */ 
    private void startBertarung(ListMakhluk L, ArrayList<Integer> v) {
        int i = 0;
        int j = 0;
        char x;
        while(i<Bwidth)
        {
            j = 0;
            while(j<Blength)
            {
                int k = 0;
               while(Papan.get(i).get(j).get(k)!=-1)
                {
                    k++;
                }
                if (k>=Bheight*Bheight)
                {
                    Bertarung(i,j,L,v);
                }
                j++;
            }
            i++;
        }
    }
    
    /**
     * Prosedur private Bertarung membunuh satu makhluk jika sel penuh.
     * @param i sebuah argumen bertipe int.
     * @param i sebuah argumen bertipe int.
     * @param L sebuah argumen bertipe ListMakhluk.
     * @param tempathapus sebuah argumen bertipe vektor.
     */ 
    private void Bertarung(int i, int j, ListMakhluk L, ArrayList<Integer> tempathapus){
        //cari minimum dari satu kotak
        int k;
        int kmin = 0;
        int KekuatanMin = L.get(Papan.get(i).get(j).get(0)).getKekuatan();
        for(k=1; k<=Bheight*Bheight; k++)
        {
            if(L.get(Papan.get(i).get(j).get(k)).getKekuatan()< KekuatanMin)
            {
                kmin = k;
                KekuatanMin = L.get(Papan.get(i).get(j).get(k)).getKekuatan();
            }
        }

        tempathapus.add(Papan.get(i).get(j).get(kmin));
        Papan.get(i).get(j).set(kmin,-1);
    }
    
    /**
     * Prosedur deleteHasilBertarung menghapus hasil bertarung dari list.
     * @param L sebuah argumen bertipe ListMakhluk.
     * @param v sebuah argumen bertipe vektor.
     */ 
    private void deleteHasilBertarung(ListMakhluk L, ArrayList <Integer> v){
        Collections.sort(v); //http://beginnersbook.com/2013/12/how-to-sort-arraylist-in-java/
        int SizeVector = v.size();
        int i;
        int indeks;
        for(i = SizeVector-1; i>=0; i--)
        {
            indeks = v.get(i); //http://stackoverflow.com/questions/3920602/get-specific-arraylist-item
            L.delete(L.search(L.get(indeks)));
        }
    }
    
    /**
     * Prosedur private SetElmtBoard untuk mengeset element board.
     * @param C sebuah argumen bertipe int.
     * @param x sebuah argumen bertipe int.
     * @param y sebuah argumen bertipe int.
     * @param z sebuah argumen bertipe int.
     */ 
    private void SetElementBoard(int C, int x, int y, int z){
        Papan.get(x).get(y).set(z,C);
    }
    
    /**
     * Prosedur AddtoBoard menambahkan isi list makhluk ke board.
     * @param L sebuah argumen bertipe ListMakhluk.
     */ 
    private void AddtoBoard(ListMakhluk L){
        for(int i=0; i<Bwidth;i++)
        {
            for(int j=0; j<Blength; j++)
            {
                for(int k=0; k<Bheight*Bheight; k++)
                {
                    Papan.get(i).get(j).set(k,-1);
                }
            }
        }
        v.clear(); //lupa dari mana
        int k = 0;
        for (int i =0; i<L.neff();i++)
        {
            k = 0;
            while(k<Bheight*Bheight && Papan.get(L.get(i).getX()).get(L.get(i).getY()).get(k)!=-1 )
            {
                k++;
            }

            if (k>=Bheight*Bheight)
            {
                Papan.get(L.get(i).getX()).get(L.get(i).getY()).set(k,i);
                Bertarung(L.get(i).getX(),L.get(i).getY(),L,v);
                k = 0;
                while(k<Bheight*Bheight && Papan.get(L.get(i).getX()).get(L.get(i).getY()).get(k)!=-1 )
                {
                    k++;
                }
                Papan.get(L.get(i).getX()).get(L.get(i).getY()).set(k,Papan.get(L.get(i).getX()).get(L.get(i).getY()).get(Bheight*Bheight));
            }
            else
            {
                Papan.get(L.get(i).getX()).get(L.get(i).getY()).set(k,i);
            }
        }
    }
    
	/**
	 * Konstruktor Board tanpa parameter.
	 * Membuat board.
	 */ 
    public Board()  {
        Bwidth = 0;
        Bheight = 0;
        Blength = 0;
        Papan = new ArrayList< ArrayList< ArrayList<Integer> > >();

    }
    
    /**
     * Konstruktor Board dengan parameter.
     * Membuat board berdasarkan parameter.
     * @param x sebuah argumen bertipe int.
     * @param y sebuah argumen bertipe int.
     * @param n sebuah argumen bertipe int.
     */ 
    public Board(int x , int y , int n ){
        Bwidth = x;
        Blength = y;
        Bheight = n;
        Papan = new ArrayList< ArrayList< ArrayList<Integer> > >();
        v = new ArrayList <Integer>();
        for (int i = 0; i < Bwidth; i++) {
            Papan.add(new ArrayList < ArrayList <Integer> >());
            for(int j = 0; j < Blength; j++) {
                Papan.get(i).add(new ArrayList <Integer>());
                for(int k = 0; k < Bheight*Bheight+1 ; k++) {
                    Papan.get(i).get(j).add(-1);
                }
            }
        }
    }
    
    /**
     * Prosedur PrintBoard untuk mencetak board pada layar.
     * @param L sebuah argumen bertipe ListMakhluk.
     * @param S sebuah argumen bertipe String.
     */ 
    public void PrintBoard(ListMakhluk L, String S) {
        AddtoBoard(L);
         int i;
         int a;
         PrintWriter fout;
         try{


             if(S == "System.out"){
             fout = new PrintWriter(System.out);
             }
             else
                fout = new PrintWriter(S);

             fout.print(" ");
             for (a=1;a<=Blength*Bheight+Blength/2;a++)
             {
                 fout.print("--");
             }

             fout.println("");
             for (i=0; i<Bwidth; i++)
             {

                 for (int l=0;l<Bheight;l++)
                 {
                     for (int j=0; j<Blength ; j++)
                     {
                         fout.print("|");
                         for (int k=0; k<Bheight; k++)
                         {
                             
                                 if(Papan.get(i).get(j).get(k+Bheight*l)!=-1)
                                 {
                                     fout.print( L.get(Papan.get(i).get(j).get(k+Bheight*l)).getShape() + " ");
                                 }
                                 else
                                 {
                                     fout.print("  ");
                                 }
                             

                         }
                     }
                     fout.println("|");
                 }
                 fout.print(" ");
                 for (a=1;a<=Blength*Bheight+Blength/2;a++)
                 {
                     fout.print( "--");
                 }
                 fout.println("");
             }
             GhostBusterMeetGhost(v,L);
             deleteHasilBertarung(L,v);
             fout.flush();
             if(S != "System.out")
                fout.close();
         }
         catch(IOException e){

         }
    }
    
    /**
     * Atribut v menyatakan vektor.
     */ 
    public ArrayList<Integer> v;
    
    /**
     * Atribut BLength menyatakan ukuran panjang Board.
     */ 
    public  int Blength;
    
    /**
     * Atribut BLength menyatakan ukuran tinggi Board.
     */
    public  int Bheight;
    
    /**
     * Atribut BLength menyatakan ukuran lebar Board.
     */
    public  int Bwidth;
    
    /**
     * Fungsi getElementPapan untuk mengembalikan elemen papan.
     * @param i sebuah argumen bertipe int.
     * @param j sebuah argumen bertipe int.
     * @param k sebuah argumen bertipe int.
     */
    public int getElementPapan(int i, int j, int k){
        return (Papan.get(i).get(j).get(k));
    }
    
    /**
     * Prosedur GhostBusterMeetGhost.
     * Membunuh semua ghost yang satu sel dengan ghostbuster.
     * @param A sebuah argumen bertipe ArrayList.
     * @param L sebuah argumen bertipe L.
     */ 
    public void GhostBusterMeetGhost (ArrayList<Integer> A ,ListMakhluk L ){
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int i,j,k, toPush;
        boolean alert1, alert2;
        for(i=0; i<Bwidth; i++){
            for(j=0; j<Blength; j++){
                alert1 = false;
                alert2 = false;
                temp.clear();
                for(k=0; k<Bheight*Bheight; k++){
                    if(getElementPapan(i,j,k)!=-1)
                    {
                        if(L.get(getElementPapan(i,j,k)).getShape()=='G'){
                            temp.add(getElementPapan(i,j,k));
                            alert1 = true;
                        }
                        else if(L.get(getElementPapan(i,j,k)).getShape()=='B'){
                            alert2 = true;
                        }

                        if(alert1 && alert2){
                            System.out.println("There is/are ghost and ghostbuster in the same cell. Ghost(s) must die");
                            for(int idxtemp = 0; idxtemp<temp.size(); idxtemp++){
                                A.add(temp.get(idxtemp));
                            }
                            alert1 = false;
                        }
                    }

                }
            }
        }
    }
    
    /**
     * Fungsi isInVector.
     * Mengembalikan apakah suatu elemen ada d vektor.
     * @param x sebuah argumen bertipe int.
     * @param v sebuah argumen bertipe vektor.
     * @return hasil boolean yang menyatakan ada pada vektor atau tidak.
     */ 
    public boolean isInVector (int x, ArrayList<Integer> v){
         boolean hasil = false;
        for(int i = 0; i<v.size(); i++)
        {
            if(x==v.get(i)){hasil = true;}
        }
        return hasil;
    } 
}
