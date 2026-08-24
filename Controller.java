//Isaac Gershon 17th Feb 2023
//Key Controler Class
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class Controller {
   
   private LinkedList<Bullet> b = new LinkedList<Bullet>();
   private LinkedList<Enemy> e = new LinkedList<Enemy>();
   
   Random r = new Random();
   
   Bullet TempBullet;
   Enemy TempEnemy;
   
   Teratiba game;
   Textures tex;
   
   public Controller (Teratiba game, Textures tex){
      this.game = game;
      this.tex = tex;
      
      addEnemy (new Enemy (r.nextInt(Teratiba.WIDTH * Teratiba.SCALE), 0, tex));
   }
   
  /* public void tick(){
      for(int i = 0; i < b.size(); i ++){
         TempBullet = b.get(i);
         
         if (TempBullet.getY() < 0)
            removeBullet(TempBullet);
         
         TempBullet.tick(); 
      }
      for(int i = 0; i < e.size(); i ++){
         TempEnemy = e.get(i);
         
         if (TempEnemy.getY() > (Teratiba.HEIGHT * Teratiba.SCALE)){
            TempEnemy.setY(0);
         }
         
         TempEnemy.tick(); 
      }
   }*/

   
   public void render (Graphics g){
      for(int i = 0; i < b.size(); i++){
         TempBullet = b.get(i);
         
         TempBullet.render(g);
      }
      for(int i = 0; i < e.size(); i++){
         TempEnemy = e.get(i);
         
         TempEnemy.render(g);
      }
   }
   
   public void addBullet (Bullet block){
      b.add(block);
   }
   public void removeBullet (Bullet block){
      b.remove(block);
   }
   
   public void addEnemy (Enemy block){
      e.add(block);
   }
   public void removeEnemy (Enemy block){
      e.remove(block);
   }
}