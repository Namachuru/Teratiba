//Isaac Gershon 23rd Feb 2023
//Bullet Class
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet {
   
   private double x;
   private double y;
   
   private Textures tex;
   
   public Bullet(double x, double y, Textures tex){
      this.x = x;
      this.y = y;
      this.tex = tex;
   }
   
   public void tick(){
      y -= 10;
   }
   
   public void render (Graphics g){
      if (Teratiba.State == Teratiba.STATE.DESKTOP){
         g.drawImage(tex.teriBar, 279, 0, null);
      }
      else if (Teratiba.State == Teratiba.STATE.TERATIBAMENU){
         g.drawImage(tex.teriBarOpen, 279, 0, null);
      }
      else{
         System.out.println ("BABUA");
      }

   }
   
   public double getY(){
      return y;
   }
}