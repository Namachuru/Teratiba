//Isaac Gershon 24th April 2023
//TeriBar Class
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TeriFolder {
   
   private String name;
   private int x, y;
   private Textures tex;
   
   public TeriFolder (String name, int x, int y, Textures tex){
      this.name = name;
      this.x = x;
      this.y = y;
      this.tex = tex;
   }
   
   public void tick(){ 
   
   }
   
   public void render (Graphics g){
      g.drawString (name, x - 120, y + 32);
      g.drawImage (tex.teriFolderMid, x, y, null);
      
   }
   
   public int getX(){
      return x;
   }
   public int getY(){
      return y;
   }
   public void setX (int x){
      this.x = x;
   }
   public void setY (int y){
      this.y = y;
   }
}