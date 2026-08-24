//Isaac Gershon 13th Feb 2023
//Buffered Image Loader Class
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BufferedImageLoader {
   private BufferedImage image;
   
   public BufferedImage loadImage(String path) throws IOException{
      image = ImageIO.read(getClass().getResource(path));
      return image;
   }
} 