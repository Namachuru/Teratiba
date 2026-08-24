//Isaac Gershon 31st Mar 2023
//Key Input Class
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
   
   Teratiba game;
   
   public KeyInput (Teratiba game){
      this.game = game;
   }
   
   public void keyPressed (KeyEvent e){
      game.keyPressed(e);
   }
   
   public void keyReleased (KeyEvent e){
      game.keyReleased(e);
   }
}