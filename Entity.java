//Isaac Gershon 22nd April 2023
//Entity Interface
import java.awt.Graphics;

public interface Entity {
   
   public void tick();
   public void render(Graphics g);
   
   public double getX();
   public double getY();
}