package nqueen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ozzy
 */
public class Queen extends JPanel {
        
     private static int dimension, dim;
     private static char[][] t;
     private static int size = 35; // size of the cell
     private static int margin = 80;   // margin of the board
    
     
      public void paint(Graphics g){
        int d = dimension;
        Image img1 = Toolkit.getDefaultToolkit().getImage("src/pic_queen.png");
        g.setColor(new Color(255, 189, 35));
        g.fillRect(margin, margin, dim, dim);
        if(d == 1)
             g.drawImage(img1, margin, margin, size, size , null , this);
        else{
            for(int i = margin; i < dim + margin; i+=2*size){
                for(int j = margin; j < dim + margin; j+=2*size){
                    g.clearRect(i, j, size, size);
                }
            }

            for(int i = margin+size; i < dim + margin; i+=2*size){
                for(int j = margin + size; j < dim + margin; j+=2*size){
                    g.clearRect(i, j, size, size);
                }
            }
        }
        
        
        for(int i = 0; i < d; i++)
            for(int j = 0; j < d; j++)
                if(t[i][j] == 'Q')
                g.drawImage(img1, margin + i*size, margin + j * size, size, size , null , this);
        
        
    }
    public Queen() {
        initComponents();
    }
    
    public static void main(String[] args){
   
    dimension = Integer.parseInt(args[0]);
    size = Integer.parseInt(args[1]);
    dim = dimension * size;
    JFrame frame = new JFrame();
    frame.setSize(dim+2* + margin, dim+2* + margin + size / 2);
    frame.getContentPane().add(new Queen());
    frame.setLocationRelativeTo(null);
    frame.setBackground(Color.LIGHT_GRAY);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    t = new char[dimension][dimension];
        enumerate(dimension);
    }
    
	public static boolean isConsistent(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;   
            if ((q[i] - q[n]) == (n - i)) return false;   
            if ((q[n] - q[i]) == (n - i)) return false;   
        }
        return true;
    }

   public static void printTable(int[] q) {
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j) t[i][j] = 'Q';
                else t[i][j] = '*';
            }
        }  
    }

   public static void enumerate(int n) {
        int[] a = new int[n];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int k) {
        int n = q.length;
        if (k == n) printTable(q);
        else {
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (isConsistent(q, k)) enumerate(q, k+1);
            }
        }
    }  

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
