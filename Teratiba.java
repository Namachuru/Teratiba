//Isaac Gershon 23rd March 2023
//Teratiba Class
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.lang.Thread;
import java.awt.Toolkit;
public class Teratiba extends Canvas implements Runnable{
   
   public static final int WIDTH = 320;
   public static final int HEIGHT = WIDTH / 12 * 9 + 6;
   public static final int SCALE = 2; //640 X 480
   public final String TITLE = "Teratiba";
   
   private boolean running = false;
   private Thread thread;
   
   private BufferedImage image = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
   private BufferedImage image2 = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
   private BufferedImage image3 = new BufferedImage (WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
   private BufferedImage spriteSheet = null;
   private BufferedImage teriBar = null;
   private BufferedImage teriBarOpen = null;
   private BufferedImage teriFolderMid = null;
   private BufferedImage teriMusicPlayerMid = null;
   private BufferedImage teriCalculatorMid = null;
   private BufferedImage teriNotepadMid = null;
   private BufferedImage teriPaintMid = null;
   private BufferedImage teriRemoteDesktopMid = null;
   private BufferedImage teriDiskDefragmentorMid = null;
   private BufferedImage teriWordMid = null;
   private BufferedImage teriSpreadSheetMid = null;
   private BufferedImage teriPowerPointMid = null;
   private BufferedImage teriChickenFeastMid = null;
   private BufferedImage teriChompSurvivorMid = null;
   private BufferedImage teriDragonFlyMid = null;
   private BufferedImage teriForestDashMid = null;
   private BufferedImage background = null;
      
   private String [] app = new String [3];
   private String [] name = new String [3];
   private String [] name2 = new String [3];
   private String [] name3 = new String [3];
   private String line;
   private String line2;
   
   private boolean is_shooting = false;
   private Player p;
   private Ono o;
   private Controller c;
   private Textures tex;
   private SpriteSheet se;
   private int positioner = 1;
    
   public static enum STATE{
      DESKTOP,
      TERATIBAMENU
   };
   
   public static enum STATEDROP{
      ENGLISH,
      NUGAE,
      SWAHILI      
   };
   
   public static enum STATEDRIZZLE{
      DEFAULT,
      UP,
      DOWN    
   };
   
   public static enum SWITCHER{
      ONE,
      TWO,
      THREE,
      FOUR,
      FIVE,
      SIX,
      SEVEN,
      EIGHT,
      NINE,
      TEN,
      ELEVEN,
      TWELVE,
      THIRTEEN
   };
   
   public static enum PROGRAMSELECTED{
      NONE,
      ACCESSORIES,
      BARA,
      GAMES,
      MUSICPLAYER,
      CLSEACCESSORIES,
      CALCULATOR,
      NOTEPAD,
      PAINT,
      REMOTEDESKTOP,
      DISKDEFRAGMENTOR,
      CLSEBARA,
      WORD,
      SPREADSHEET,
      POWERPOINT,
      CLSEGAMES,
      CHICKENFEAST,
      CHOMPSURVIVOR,
      DRAGONFLY,
      FORESTDASH
   }
   
   public static STATE State = STATE.DESKTOP;
   public static STATEDROP StateDrop = STATEDROP.ENGLISH;
   public static STATEDRIZZLE StateDrizzle = STATEDRIZZLE.DEFAULT;
   public static SWITCHER Switcher = SWITCHER.ONE;
   public static PROGRAMSELECTED ProgramSelected = PROGRAMSELECTED.NONE;
   
   public void init(){
      requestFocus();
      BufferedImageLoader loader = new BufferedImageLoader();
      try{
         spriteSheet = loader.loadImage ("/Res/default cursors.png");
         teriBar = loader.loadImage ("/Res/TERATIBA MENU.png");
         teriBarOpen = loader.loadImage ("/Res/TERATIBA MENU OPEN.png");
         teriFolderMid = loader.loadImage ("/Res/folders mid.png");
         teriMusicPlayerMid = loader.loadImage ("/Res/music player mid.png");
         teriCalculatorMid = loader.loadImage ("/Res/calculator mid.png");
         teriNotepadMid = loader.loadImage ("/Res/notepad mid.png");
         teriPaintMid = loader.loadImage ("/Res/paint mid.png");
         teriRemoteDesktopMid = loader.loadImage ("/Res/remote desktop mid.png");
         teriDiskDefragmentorMid = loader.loadImage ("/Res/disk defragmentor mid.png");
         teriWordMid = loader.loadImage ("/Res/word mid.png");
         teriSpreadSheetMid = loader.loadImage ("/Res/spreadsheet mid.png");
         teriPowerPointMid = loader.loadImage ("/Res/powerpoint mid.png");
         teriChickenFeastMid = loader.loadImage ("/Res/chicken feast mid.png");
         teriChompSurvivorMid = loader.loadImage ("/Res/chomp survivor mid.png");
         teriDragonFlyMid = loader.loadImage ("/Res/dragon fly mid.png");
         teriForestDashMid = loader.loadImage ("/Res/forest dash mid.png");
         background = loader.loadImage ("/Res/background.png");               
      }catch (IOException e){
         e.printStackTrace();
      }
      Ono pri = new Ono();
      
      addKeyListener (new KeyInput (this));
      this.addMouseListener (new MouseInput());
      pri.init();
      
      tex = new Textures(this, pri);
      pri.setTex(tex);
      
      
      p = new Player (275, 192, tex);
      o = new Ono ();
      o.init();
      o.setTex(tex);
      
   }
   
   private synchronized void start(){
      if(running)
         return;
         
      running = true;
      thread = new Thread (this);
      thread.start();
   }
   
   private synchronized void stop(){
      if (!running)
         return;
      
      running = false;
      try {
         thread.join();
      }
      catch (InterruptedException e) {
         e.printStackTrace();
      }
      System.exit(1);
   }
   
   //Run Method
   public void run() {
      init();
      long lastTime = System.nanoTime();
      final double amountOfTicks = 60.0;
      double ns = 1000000000 / amountOfTicks;
      double delta = 0;
      int updates = 0;
      int frames = 0;
      long timer = System.currentTimeMillis();
      while(running){
         long now = System.nanoTime();
         
         delta += (now - lastTime) / ns;
         lastTime = now;
         if(delta >= 1){
            tick();
            updates++;
            delta--;
         }
         render();
         frames++;
         
         if (System.currentTimeMillis() - timer > 1000){
            timer += 1000;
            System.out.println (updates + " Ticks, Fps " + frames);
            updates = 0;
            frames = 0;
         }
      }
      stop();
   }
   
   private void tick(){
      p.tick();
      //c.tick();
   }
   
   private void render(){
      BufferStrategy bs = this.getBufferStrategy();
      
      if(bs == null){
         createBufferStrategy(3);
         return;
      }
      
      Graphics g = bs.getDrawGraphics();
      //////////////////////////////////
      
      /*g.drawImage (image, 0, 0, getWidth(), getHeight(), this);
      g.drawImage (image2, 0, 0, getWidth(), getHeight(), this);
      */
       
      g.drawImage(background, 0, 0, null);
      
      if (Teratiba.State == Teratiba.STATE.DESKTOP){
         g.drawImage (tex.teriBar, 0, 279, null);
         
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.WORD){
            o.render(g);
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.NONE){
         
         }
      }
      else if (Teratiba.State == Teratiba.STATE.TERATIBAMENU){
         g.drawImage (tex.teriBarOpen, 0, 279, null);
         //draw programs
         g.setColor (Color.black);
         switch (positioner){
            //Default Position
            case 1:
               Switcher = SWITCHER.ONE;
               try{
                  BufferedReader rd = new BufferedReader(new FileReader("Sys/Applications.txt"));
            
                  line = rd.readLine();
                  System.out.println (line.toString());
                       
                  StringTokenizer st = new StringTokenizer (line, "&");
         
                  while (st.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        name[i] = st.nextToken();
                        name2[i] = st.nextToken();
                        name3[i] = st.nextToken();
                        st.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }  
               catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }
               catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }
               catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Accessories Opened
            case 2:
               Switcher = SWITCHER.THREE;
               try{
                  BufferedReader rd = new BufferedReader(new FileReader("Sys/Applications.txt"));
                  BufferedReader rdb = new BufferedReader(new FileReader("Sys/Accessories.txt"));
                  
                  line = rd.readLine();
                  line2 = rdb.readLine();
                  System.out.println (line.toString());
                  System.out.println (line2.toString());
                       
                  StringTokenizer st = new StringTokenizer (line, "&");
                  StringTokenizer stb = new StringTokenizer (line2, "&");
                  
                  while (st.hasMoreTokens() || stb.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        name[i] = st.nextToken();
                        name2[i] = stb.nextToken();
                        name3[i] = stb.nextToken();
                        st.nextToken();
                        st.nextToken();
                        st.nextToken();
                        stb.nextToken();
                        stb.nextToken();
                        stb.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Bara
            case 3:
               Switcher = SWITCHER.TWO;
               try{
                  BufferedReader rd = new BufferedReader(new FileReader("Sys/Applications.txt"));
            
                  line = rd.readLine();
                  System.out.println (line.toString());
                       
                  StringTokenizer st = new StringTokenizer (line, "&");
         
                  while (st.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        st.nextToken();
                        name[i] = st.nextToken();
                        name2[i] = st.nextToken();
                        name3[i] = st.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }  
               catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }
               catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }
               catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Bara Opened
            case 4:
               Switcher = SWITCHER.SEVEN;
               try{
                  BufferedReader rd = new BufferedReader(new FileReader("Sys/Applications.txt"));
            
                  line = rd.readLine();
                  System.out.println (line.toString());
                       
                  StringTokenizer st = new StringTokenizer (line, "&");
         
                  while (st.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        st.nextToken();
                        name[i] = st.nextToken();
                        try{
                           BufferedReader rdb = new BufferedReader(new FileReader("Sys/Bara.txt"));
            
                           line2 = rdb.readLine();
                           System.out.println (line2.toString());
                       
                           StringTokenizer stb = new StringTokenizer (line2, "&");
         
                           while (stb.hasMoreTokens()){
                              for (int x = 0; x <= 3; x++){
                                 name2[x] = stb.nextToken();
                                 name3[x] = stb.nextToken();
                                 stb.nextToken();
                              }
                           }
                        }catch (FileNotFoundException e){
                           System.out.println ("Bahati Mbaya");
                        }catch (IOException e) {
                           System.out.println("The file cannot be read.");
                        }catch (NumberFormatException e) {
                           System.out.println("The file contains non numeric data.");
                        }catch (Exception e) {
                           System.out.println(e.getMessage());
                        }
                        st.nextToken();
                        st.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Games Opened
            case 5:
               Switcher = SWITCHER.NINE;
               try{
                  BufferedReader rd = new BufferedReader(new FileReader("Sys/Applications.txt"));
                  BufferedReader rdb = new BufferedReader(new FileReader("Sys/Games.txt"));
                  
                  line = rd.readLine();
                  line2 = rdb.readLine();
                  System.out.println (line.toString());
                  System.out.println (line2.toString());
                       
                  StringTokenizer st = new StringTokenizer (line, "&");
                  StringTokenizer stb = new StringTokenizer (line2, "&");
                  
                  while (st.hasMoreTokens() || stb.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        st.nextToken();
                        st.nextToken();
                        name[i] = st.nextToken();
                        name2[i] = stb.nextToken();
                        name3[i] = stb.nextToken();
                        st.nextToken();
                        stb.nextToken();
                        stb.nextToken();
                        stb.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Scroll Accessories
            case 6:
               Switcher = SWITCHER.FOUR;
               try{
                  BufferedReader rdb = new BufferedReader(new FileReader("Sys/Accessories.txt"));
                  
                  System.out.println ("HHIIIHH");
                  line2 = rdb.readLine();
                  System.out.println (line2.toString());
                  System.out.println ("HHIIIHH");
                  
                  StringTokenizer stb = new StringTokenizer (line2, "&");
                  
                  while (stb.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        name[i] = stb.nextToken();
                        name2[i] = stb.nextToken();
                        name3[i] = stb.nextToken();
                        stb.nextToken();
                        stb.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Scroll 2 Accessories
            case 7:
               Switcher = SWITCHER.FIVE;
               try{
                  BufferedReader rdb = new BufferedReader(new FileReader("Sys/Accessories.txt"));
                  
                  line2 = rdb.readLine();
                  System.out.println (line2.toString());
                  
                  StringTokenizer stb = new StringTokenizer (line2, "&");
                  
                  while (stb.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        stb.nextToken();
                        name[i] = stb.nextToken();
                        name2[i] = stb.nextToken();
                        name3[i] = stb.nextToken();
                        stb.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Scroll 3 Accessories
            case 8:
               Switcher = SWITCHER.SIX;
               try{
                  BufferedReader rdb = new BufferedReader(new FileReader("Sys/Accessories.txt"));
                  
                  line2 = rdb.readLine();
                  System.out.println (line2.toString());
                  
                  StringTokenizer stb = new StringTokenizer (line2, "&");
                  
                  while (stb.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        stb.nextToken();
                        stb.nextToken();
                        name[i] = stb.nextToken();
                        name2[i] = stb.nextToken();
                        name3[i] = stb.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Scroll Bara
            case 9:
               Switcher = SWITCHER.EIGHT;
               try{
                  BufferedReader rdb = new BufferedReader(new FileReader("Sys/Bara.txt"));
                  
                  line2 = rdb.readLine();
                  System.out.println (line2.toString());
                  System.out.println ("HHIIIHH");
                  
                  StringTokenizer stb = new StringTokenizer (line2, "&");
                  
                  while (stb.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        name[i] = stb.nextToken();
                        name2[i] = stb.nextToken();
                        name3[i] = stb.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Scroll Games
            case 10:
               Switcher = SWITCHER.TEN;
               try{
                  BufferedReader rdb = new BufferedReader(new FileReader("Sys/Games.txt"));
                  
                  line2 = rdb.readLine();
                  System.out.println (line2.toString());
                  System.out.println ("HHIIIHH");
                  
                  StringTokenizer stb = new StringTokenizer (line2, "&");
                  
                  while (stb.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        name[i] = stb.nextToken();
                        name2[i] = stb.nextToken();
                        name3[i] = stb.nextToken();
                        stb.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
            //Scroll 2 Games
            case 11:
               Switcher = SWITCHER.ELEVEN;
               try{
                  BufferedReader rdb = new BufferedReader(new FileReader("Sys/Games.txt"));
                  
                  line2 = rdb.readLine();
                  System.out.println (line2.toString());
                  System.out.println ("HHIIIHH");
                  
                  StringTokenizer stb = new StringTokenizer (line2, "&");
                  
                  while (stb.hasMoreTokens()){
                     for (int i = 0; i <= 3; i++){
                        stb.nextToken();
                        name[i] = stb.nextToken();
                        name2[i] = stb.nextToken();
                        name3[i] = stb.nextToken();
                     }
                  }
               }catch (FileNotFoundException e){
                  System.out.println ("Bahati Mbaya");
               }catch (IOException e) {
                  System.out.println("The file cannot be read.");
               }catch (NumberFormatException e) {
                  System.out.println("The file contains non numeric data.");
               }catch (Exception e) {
                  System.out.println(e.getMessage());
               }
            break;
         }
         if (Teratiba.StateDrop == Teratiba.STATEDROP.ENGLISH){
            switch (positioner){
               //Default Position
               case 1:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 104+36+279, null);
               break;
               //Accessories Opened
               case 2:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriCalculatorMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriNotepadMid, 130, 104+36+279, null);
               break;
               //Bara
               case 3:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriMusicPlayerMid, 130, 104+36+279, null);
               break;
               //Bara Opened
               case 4:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriWordMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriSpreadSheetMid, 130, 104+36+279, null);
               break;
               //Games Opened
               case 5:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriChickenFeastMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriChompSurvivorMid, 130, 104+36+279, null);
               break;
               //Scroll Accessories
               case 6:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriCalculatorMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriNotepadMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriPaintMid, 130, 104+36+279, null);
               break;
               //Scroll Accessories 2
               case 7:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriNotepadMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriPaintMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriRemoteDesktopMid, 130, 104+36+279, null);
               break;
               //Scroll Accessories 3
               case 8:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriPaintMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriRemoteDesktopMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriDiskDefragmentorMid, 130, 104+36+279, null);
               break;
               //Scroll Bara
               case 9:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriWordMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriSpreadSheetMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriPowerPointMid, 130, 104+36+279, null);
               break;
               //Scroll Games
               case 10:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriChickenFeastMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriChompSurvivorMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriDragonFlyMid, 130, 104+36+279, null);
               break;
               //Scroll Games 2
               case 11:
                  g.drawString (name[0], 10, 36+32+279);
                  g.drawImage (tex.teriChompSurvivorMid, 130, 36+279, null);
                  g.drawString (name2[0], 10, 52+36+32+279);
                  g.drawImage (tex.teriDragonFlyMid, 130, 52+36+279, null);
                  g.drawString (name3[0], 10, 104+36+32+279);
                  g.drawImage (tex.teriForestDashMid, 130, 104+36+279, null);
               break;
            }
            try{
               Thread.sleep(2*250);
            }catch (Exception er){
            }
            StateDrop = STATEDROP.NUGAE;
         }
         else if (Teratiba.StateDrop == Teratiba.STATEDROP.NUGAE)
         {
            switch (positioner){
               //Default Position
               case 1:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 104+36+279, null);
               break;
               //Accessories Opened
               case 2:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriCalculatorMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriNotepadMid, 130, 104+36+279, null);
               break;
               //Bara
               case 3:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriMusicPlayerMid, 130, 104+36+279, null);
               break;
               //Bara Opened
               case 4:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriWordMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriSpreadSheetMid, 130, 104+36+279, null);
               break;
               //Games Opened
               case 5:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriChickenFeastMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriChompSurvivorMid, 130, 104+36+279, null);
               break;
               //Scroll Accessories
               case 6:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriCalculatorMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriNotepadMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriPaintMid, 130, 104+36+279, null);
               break;
               //Scroll Accessories 2
               case 7:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriNotepadMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriPaintMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriRemoteDesktopMid, 130, 104+36+279, null);
               break;
               //Scroll Accessories 3
               case 8:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriPaintMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriRemoteDesktopMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriDiskDefragmentorMid, 130, 104+36+279, null);
               break;
               //Scroll Bara
               case 9:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriWordMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriSpreadSheetMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriPowerPointMid, 130, 104+36+279, null);
               break;
               //Scroll Games
               case 10:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriChickenFeastMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriChompSurvivorMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriDragonFlyMid, 130, 104+36+279, null);
               break;
               //Scroll Games 2
               case 11:
                  g.drawString (name[1], 10, 36+32+279);
                  g.drawImage (tex.teriChompSurvivorMid, 130, 36+279, null);
                  g.drawString (name2[1], 10, 52+36+32+279);
                  g.drawImage (tex.teriDragonFlyMid, 130, 52+36+279, null);
                  g.drawString (name3[1], 10, 104+36+32+279);
                  g.drawImage (tex.teriForestDashMid, 130, 104+36+279, null);
               break;
            }
            try{
               Thread.sleep(1*500);
            }
            catch (Exception er){
            }
            StateDrop = STATEDROP.SWAHILI;
         }
         else if (Teratiba.StateDrop == Teratiba.STATEDROP.SWAHILI)
         {
            switch (positioner){
               //Default Position
               case 1:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 104+36+279, null);
               break;
               //Accessories Opened
               case 2:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriCalculatorMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriNotepadMid, 130, 104+36+279, null);
               break;
               //Bara
               case 3:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriMusicPlayerMid, 130, 104+36+279, null);
               break;
               //Bara Opened
               case 4:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriWordMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriSpreadSheetMid, 130, 104+36+279, null);
               break;
               //Games Opened
               case 5:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriFolderMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriChickenFeastMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriChompSurvivorMid, 130, 104+36+279, null);
               break;
               //Scroll Accessories
               case 6:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriCalculatorMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriNotepadMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriPaintMid, 130, 104+36+279, null);
               break;
               //Scroll Accessories 2
               case 7:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriNotepadMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriPaintMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriRemoteDesktopMid, 130, 104+36+279, null);
               break;
               //Scroll Accessories 3
               case 8:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriPaintMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriRemoteDesktopMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriDiskDefragmentorMid, 130, 104+36+279, null);
               break;
               //Scroll Bara
               case 9:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriWordMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriSpreadSheetMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriPowerPointMid, 130, 104+36+279, null);
               break;
               //Scroll Games
               case 10:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriChickenFeastMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriChompSurvivorMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriDragonFlyMid, 130, 104+36+279, null);
               break;
               //Scroll Games 2
               case 11:
                  g.drawString (name[2], 10, 36+32+279);
                  g.drawImage (tex.teriChompSurvivorMid, 130, 36+279, null);
                  g.drawString (name2[2], 10, 52+36+32+279);
                  g.drawImage (tex.teriDragonFlyMid, 130, 52+36+279, null);
                  g.drawString (name3[2], 10, 104+36+32+279);
                  g.drawImage (tex.teriForestDashMid, 130, 104+36+279, null);
               break;
            }
            try{
               Thread.sleep(2*250);
            }
            catch (Exception er){
            }
            StateDrop = STATEDROP.ENGLISH;
         }
         
         if (Teratiba.StateDrizzle == Teratiba.STATEDRIZZLE.DOWN)
         {
            StateDrizzle = Teratiba.STATEDRIZZLE.DEFAULT;
            ProgramSelected = PROGRAMSELECTED.NONE;
            switch (positioner){
               case 1:
                  positioner = 3;                  
               break;
               case 2:
                  positioner = 6;
               break;
               case 3:
                  //do nothing
               break;
               case 4:
                  positioner = 9;
               break;
               case 5:
                  positioner = 10;
               break;
               case 6:
                  positioner = 7;
               break;
               case 7:
                  positioner = 8;
               break;
               case 8:
                  //do nothing
               break;
               case 9:
                  //do nothing
               break;
               case 10:
                  positioner = 11;
               break;
               case 11:
                  //do nothing
               break;
            }
         }
         if (Teratiba.StateDrizzle == Teratiba.STATEDRIZZLE.UP)
         {
            StateDrizzle = Teratiba.STATEDRIZZLE.DEFAULT;
            ProgramSelected = PROGRAMSELECTED.NONE;
            switch (positioner){
               case 1:
                  //do nothing                  
               break;
               case 2:
                  //do nothing
               break;
               case 3:
                  positioner = 1;
               break;
               case 4:
                  //do nothing
               break;
               case 5:
                  //do nothing
               break;
               case 6:
                  positioner = 2;
               break;
               case 7:
                  positioner = 6;
               break;
               case 8:
                  positioner = 7;
               break;
               case 9:
                  positioner = 4;
               break;
               case 10:
                  positioner = 5;
               break;
               case 11:
                  positioner = 10;
               break;
           }/*while (positioner != 1){
               positioner -= 1;
               
               switch (positioner){
                  case 1:
                     try{
                        BufferedReader rd = new BufferedReader(new FileReader("Sys/Applications.txt"));
            
                        line = rd.readLine();
                        System.out.println (line.toString());
                       
                        StringTokenizer st = new StringTokenizer (line, "&");
         
                        while (st.hasMoreTokens()){
                           for (int i = 0; i <= 3; i++){
                              name[i] = st.nextToken();
                              name2[i] = st.nextToken();
                              name3[i] = st.nextToken();
                              st.nextToken();
                           }
                        }
                     }catch (FileNotFoundException e){
                        System.out.println ("Bahati Mbaya");
                     }  
                     catch (IOException e) {
                        System.out.println("The file cannot be read.");
                     }
                     catch (NumberFormatException e) {
                        System.out.println("The file contains non numeric data.");
                     }
                     catch (Exception e) {
                        System.out.println(e.getMessage());
                     }  
                  break;
                  case 2:
                  
                  break;
               }
            }
            if (positioner == 1){
               //do nothing
            }*/
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.ACCESSORIES){
            positioner = 2;
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.CLSEACCESSORIES){
            positioner = 1;
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.BARA){
            positioner = 4;
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.CLSEBARA){
            positioner = 1;
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.GAMES){
            positioner = 5;
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.CLSEGAMES){
            positioner = 1;
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.MUSICPLAYER){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open music player");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.CALCULATOR){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open calculator");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.NOTEPAD){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open notepad");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.REMOTEDESKTOP){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open remote desktop");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.DISKDEFRAGMENTOR){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open disk defragmentor");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.WORD){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open word");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.SPREADSHEET){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open spreadsheet");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.POWERPOINT){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open powerpoint");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.CHICKENFEAST){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open chicken feast");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.CHOMPSURVIVOR){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open chomp survivor");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.DRAGONFLY){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open dragon fly");
         }
         if (Teratiba.ProgramSelected == Teratiba.PROGRAMSELECTED.FORESTDASH){
            State = Teratiba.STATE.DESKTOP;
            System.out.println ("open forest dash");
         }
         else{
            System.out.println ("BABUA");
         }
         
      }
      p.render(g);
     // c.render(g);
      
      //////////////////////////////////
      g.dispose();
      bs.show();
   }
   
   public void keyPressed (KeyEvent e){
      int key = e.getKeyCode();
      
      if(key == KeyEvent.VK_RIGHT){
         p.setVelX(5);
      } else if(key == KeyEvent.VK_LEFT){
         p.setVelX(-5);
      } else if(key == KeyEvent.VK_DOWN){
         p.setVelY(5);
      } else if(key == KeyEvent.VK_UP){
         p.setVelY(-5);
      } else if(key == KeyEvent.VK_SPACE && !is_shooting){
         is_shooting = true;
         c.addBullet (new Bullet(p.getX(), p.getY(), tex));
      }
   }  
   
   public void keyReleased (KeyEvent e){
      int key = e.getKeyCode();
      
      if(key == KeyEvent.VK_RIGHT){
         p.setVelX(0);
      } else if(key == KeyEvent.VK_LEFT){
         p.setVelX(0);
      } else if(key == KeyEvent.VK_DOWN){
         p.setVelY(0);
      } else if(key == KeyEvent.VK_UP){
         p.setVelY(0);
      } else if(key == KeyEvent.VK_SPACE){
         is_shooting = false;
         c.addBullet(new Bullet(p.getX(), p.getY(), tex));
      }
   }
   
   public static void main (String [] args){
      Teratiba game = new Teratiba();
      //Toolkit tk = Toolkit.getDefaultToolkit();//today
      
      //int x = (int) tk.getScreenSize().getWidth();
      //int y = (int) tk.getScreenSize().getHeight();
      //System.out.println (x + " " + y);
      game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
      game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
      game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
      
      JFrame frame = new JFrame(game.TITLE);
     // Mouse m = new Mouse();
      
      frame.add(game);
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.addMouseListener(m);
      //frame.setUndecorated(true);//today
      frame.setAlwaysOnTop(true);//today
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
      
      
      //frame.setSize(x, y);
      game.start();
   }
   
   public BufferedImage getSpriteSheet(){
      return spriteSheet;
   }
   
   public BufferedImage getTeriBar(){
      return teriBar;
   }
   
   public BufferedImage getTeriBarOpen(){
      return teriBarOpen;
   }
   
   public BufferedImage getTeriFolderMid(){
      return teriFolderMid;
   }
   
   public BufferedImage getTeriMusicPlayerMid(){
      return teriMusicPlayerMid;
   }
   
   public BufferedImage getTeriCalculatorMid(){
      return teriCalculatorMid;
   }
   
   public BufferedImage getTeriNotepadMid(){
      return teriNotepadMid;
   }
   
   public BufferedImage getTeriPaintMid(){
      return teriPaintMid;
   }
   
   public BufferedImage getTeriRemoteDesktopMid(){
      return teriRemoteDesktopMid;
   }
   
   public BufferedImage getTeriDiskDefragmentorMid(){
      return teriDiskDefragmentorMid;
   }
   
   public BufferedImage getTeriWordMid(){
      return teriWordMid;
   }
   
   public BufferedImage getTeriSpreadSheetMid(){
      return teriSpreadSheetMid;
   }
   
   public BufferedImage getTeriPowerPointMid(){
      return teriPowerPointMid;
   }
   
   public BufferedImage getTeriChickenFeastMid(){
      return teriChickenFeastMid;
   }
   
   public BufferedImage getTeriChompSurvivorMid(){
      return teriChompSurvivorMid;
   }
   
   public BufferedImage getTeriDragonFlyMid(){
      return teriDragonFlyMid;
   }
   
   public BufferedImage getTeriForestDashMid(){
      return teriForestDashMid;
   }
}