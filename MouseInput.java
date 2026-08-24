//Isaac Gershon 8th April 2023
//Mouse Input Class
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MouseInput implements MouseListener {
   
   Ono word = new Ono();
   
   //Toolkit tools = getToolkit();
   //Image cursorImg = tools.getImage("/Res/default cursors/magnifier_pnt_5.png");
   public void mouseEntered (MouseEvent e){
   
   }
   
   public void mouseExited (MouseEvent e){
   
   }
   
   public void mousePressed (MouseEvent e){
      int mx = e.getX();
      int my = e.getY();
      
      //Sellect Teratiba Bar
      if (mx >= 0 && mx <= 22)
      {
         if (Teratiba.State == Teratiba.STATE.DESKTOP){
            if(my >= 280 && my <= 312)
            {
               Teratiba.State = Teratiba.STATE.TERATIBAMENU;
            }
         }
      }
      
      //Back to Teratiba Bar
      if (mx >= 221 && mx <= 243)
      {
         if (Teratiba.State == Teratiba.STATE.TERATIBAMENU){
            if(my >= 280 && my <= 312)
            {
               Teratiba.State = Teratiba.STATE.DESKTOP;
            }
         }
      }
      
      //Scroll Down
      if (mx >= 203 && mx <= 220)
      {
         if (Teratiba.State == Teratiba.STATE.TERATIBAMENU){
            if (my >= 456 && my <= 480)
            {
               Teratiba.StateDrizzle = Teratiba.STATEDRIZZLE.DOWN;
            }
         }
      }
      
      //Scroll Up
      if (mx >= 203 && mx <= 220)
      {
         if (Teratiba.State == Teratiba.STATE.TERATIBAMENU){
            if (my >= 313 && my <= 337)
            {
               Teratiba.StateDrizzle = Teratiba.STATEDRIZZLE.UP;
            }
         }
      }
      
      //Select Programs
      if (mx >= 0 && mx <= 199)
      {
         if (Teratiba.State == Teratiba.STATE.TERATIBAMENU){
            //Program One
            if (my >= 313 && my <= 368)
            {
               if (Teratiba.Switcher == Teratiba.SWITCHER.ONE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.ACCESSORIES;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.TWO){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.BARA;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.THREE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CLSEACCESSORIES;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.FOUR){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CALCULATOR;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.FIVE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.NOTEPAD;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.SIX){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.PAINT;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.SEVEN){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CLSEBARA;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.EIGHT){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.WORD;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.NINE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CLSEGAMES;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.TEN){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CHICKENFEAST;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.ELEVEN){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CHOMPSURVIVOR;
               }
            }
            //Program Two
            else if (my >= 369 && my <= 420)
            {
               if (Teratiba.Switcher == Teratiba.SWITCHER.ONE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.BARA;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.TWO){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.GAMES;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.THREE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CALCULATOR;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.FOUR){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.NOTEPAD;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.FIVE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.PAINT;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.SIX){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.REMOTEDESKTOP;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.SEVEN){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.WORD;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.EIGHT){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.SPREADSHEET;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.NINE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CHICKENFEAST;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.TEN){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CHOMPSURVIVOR;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.ELEVEN){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.DRAGONFLY;
               }
            }
            //Program Three
            else if (my >= 421 && my <= 480)
            {
               if (Teratiba.Switcher == Teratiba.SWITCHER.ONE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.GAMES;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.TWO){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.MUSICPLAYER;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.THREE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.NOTEPAD;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.FOUR){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.PAINT;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.FIVE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.REMOTEDESKTOP;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.SIX){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.DISKDEFRAGMENTOR;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.SEVEN){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.SPREADSHEET;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.EIGHT){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.POWERPOINT;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.NINE){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.CHOMPSURVIVOR;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.TEN){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.DRAGONFLY;
               }
               else if (Teratiba.Switcher == Teratiba.SWITCHER.ELEVEN){
                  Teratiba.ProgramSelected = Teratiba.PROGRAMSELECTED.FORESTDASH;
               }
            }
         }
      }
      
      //Word 
      //48 x 27 103 x 25
      //46 x 27 154 x 25
      if (mx >= 0 && mx <= 22){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Default Close Options
         //Exit
            if (my >= 0 && my <= 22){
               Ono.Running = Ono.RUNNING.NO;
            }
         
         //Restore Down
            if (my >= 23 && my <= 44){
               Ono.State = Ono.STATE.QUARTERSCREEN;
               System.out.println ("Restored Down");
            }
         
         //Minimize
            if (my >= 45 && my <= 66){
               Ono.State = Ono.STATE.MINIMIZED;
               System.out.println ("Minimized");
            }
         }
         if (Ono.State == Ono.STATE.MINIMIZED){
         //Maximize
            if (my >= 0 && my <= 22){
               Ono.State = Ono.STATE.FULLSCREEN;
            }
         }
      }
      if (mx >= 125 && mx <= 173){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Home Button         
            if (my >= 25 && my <= 52){
               if (Ono.Menu != Ono.MENU.HOME){
                  Ono.Menu = Ono.MENU.HOME;
               }
            }
         }
      }
      if (mx >= 176 && mx <= 222){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Insert Button
            if (my >= 25 && my <= 52){
               if (Ono.Menu != Ono.MENU.INSERT){
                  Ono.Menu = Ono.MENU.INSERT;
               }
            }
         }
      }
      if (mx >= 225 && mx <= 277){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Layout Button
            if (my >= 25 && my <= 52){
               if (Ono.Menu != Ono.MENU.LAYOUT){
                  Ono.Menu = Ono.MENU.LAYOUT;
               }
            }
         }
      }
      if (mx >= 281 && mx <= 361){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //References Button
            if (my >= 25 && my <= 52){
               if (Ono.Menu != Ono.MENU.REFERENCES){
                  Ono.Menu = Ono.MENU.REFERENCES;
               }
            }
         }
      }
      if (mx >= 365 && mx <= 417){
         if (Ono.State == Ono.STATE.FULLSCREEN){   
         //Review Button
            if (my >= 25 && my <= 52){
               if (Ono.Menu != Ono.MENU.REVIEW){
                  Ono.Menu = Ono.MENU.REVIEW;
               }
            }
         }
      }
      if (mx >= 608 && mx <= 625){
         if (Ono.State == Ono.STATE.FULLSCREEN){   
         //Review2 Button
            if (my >= 78 && my <= 107){
               if (Ono.Menu != Ono.MENU.REVIEW2 && Ono.Menu == Ono.MENU.REVIEW){
                  Ono.Menu = Ono.MENU.REVIEW2;
               }
            }
         }
      }
      if (mx >= 40 && mx <= 57){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Review Button2
            if (my >= 78 && my <= 107){
               if (Ono.Menu != Ono.MENU.REVIEW && Ono.Menu == Ono.MENU.REVIEW2){
                  Ono.Menu = Ono.MENU.REVIEW;
               }
            }
         }
      }
      if (mx >= 421 && mx <= 462){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //View Button
            if (my >= 25 && my <= 52){
               if (Ono.Menu != Ono.MENU.VIEW){
                  Ono.Menu = Ono.MENU.VIEW;
               }
            }
         }
      }
      if (mx >= 466 && mx <= 510){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Help Button
            if (my >= 25 && my <= 52){
               if (Ono.Menu != Ono.MENU.HELP){
                  Ono.Menu = Ono.MENU.HELP;
               }
            }
         }
      }
      if (mx >= 90 && mx <= 121){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //File Button
            if (my >= 25 && my <= 52){
               if (Ono.Menu != Ono.MENU.FILE){
                  Ono.Menu = Ono.MENU.FILE;
               }
            }
         }
      }
      if (mx >= 586 && mx <= 610){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Scroll Right Button
            if (my >= 456 && my <= 474){
               if (Ono.Drag == Ono.DRAG.FIVE){
                  Ono.Drag = Ono.DRAG.SIX;
               }
               if (Ono.Drag == Ono.DRAG.FOUR){
                  Ono.Drag = Ono.DRAG.FIVE;
               }
               if (Ono.Drag == Ono.DRAG.THREE){
                  Ono.Drag = Ono.DRAG.FOUR;
               }
               if (Ono.Drag == Ono.DRAG.TWO){
                  Ono.Drag = Ono.DRAG.THREE;
               }
               if (Ono.Drag == Ono.DRAG.START){
                  Ono.Drag = Ono.DRAG.TWO;
               }
            }
         }
      }
      if (mx >= 28 && mx <= 52){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Scroll Left Button
            if (my >= 456 && my <= 474){
               if (Ono.Drag == Ono.DRAG.TWO){
                  Ono.Drag = Ono.DRAG.START;
               }
               if (Ono.Drag == Ono.DRAG.THREE){
                  Ono.Drag = Ono.DRAG.TWO;
               }
               if (Ono.Drag == Ono.DRAG.FOUR){
                  Ono.Drag = Ono.DRAG.THREE;
               }
               if (Ono.Drag == Ono.DRAG.FIVE){
                  Ono.Drag = Ono.DRAG.FOUR;
               }
               if (Ono.Drag == Ono.DRAG.SIX){
                  Ono.Drag = Ono.DRAG.FIVE;
               }
            }
         }
      }
      if (mx >= 616 && mx <= 633){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Scroll Up Button
            if (my >= 137 && my <= 161){
               if (Ono.Dragy == Ono.DRAGY.TWO){
                  Ono.Dragy = Ono.DRAGY.START;
               }
               if (Ono.Dragy == Ono.DRAGY.THREE){
                  Ono.Dragy = Ono.DRAGY.TWO;
               }
               if (Ono.Dragy == Ono.DRAGY.FOUR){
                  Ono.Dragy = Ono.DRAGY.THREE;
               }
               if (Ono.Dragy == Ono.DRAGY.FIVE){
                  Ono.Dragy = Ono.DRAGY.FOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.SIX){
                  Ono.Dragy = Ono.DRAGY.FIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVEN){
                  Ono.Dragy = Ono.DRAGY.SIX;
               }
               if (Ono.Dragy == Ono.DRAGY.EIGHT){
                  Ono.Dragy = Ono.DRAGY.SEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.NINE){
                  Ono.Dragy = Ono.DRAGY.EIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.TEN){
                  Ono.Dragy = Ono.DRAGY.NINE;
               }
               if (Ono.Dragy == Ono.DRAGY.ELEVEN){
                  Ono.Dragy = Ono.DRAGY.TEN;
               }
               if (Ono.Dragy == Ono.DRAGY.TWELVE){
                  Ono.Dragy = Ono.DRAGY.ELEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTEEN){
                  Ono.Dragy = Ono.DRAGY.TWELVE;
               }
               if (Ono.Dragy == Ono.DRAGY.FOURTEEN){
                  Ono.Dragy = Ono.DRAGY.THIRTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTEEN){
                  Ono.Dragy = Ono.DRAGY.FOURTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTEEN){
                  Ono.Dragy = Ono.DRAGY.FIFTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTEEN){
                  Ono.Dragy = Ono.DRAGY.SIXTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.EIGHTEEN){
                  Ono.Dragy = Ono.DRAGY.SEVENTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.NINETEEN){
                  Ono.Dragy = Ono.DRAGY.EIGHTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTY){
                  Ono.Dragy = Ono.DRAGY.NINETEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYONE){
                  Ono.Dragy = Ono.DRAGY.TWENTY;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYTWO){
                  Ono.Dragy = Ono.DRAGY.TWENTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYTHREE){
                  Ono.Dragy = Ono.DRAGY.TWENTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYFOUR){
                  Ono.Dragy = Ono.DRAGY.TWENTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYFIVE){
                  Ono.Dragy = Ono.DRAGY.TWENTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYSIX){
                  Ono.Dragy = Ono.DRAGY.TWENTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.TWENTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.TWENTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYNINE){
                  Ono.Dragy = Ono.DRAGY.TWENTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTY){
                  Ono.Dragy = Ono.DRAGY.TWENTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYONE){
                  Ono.Dragy = Ono.DRAGY.THIRTY;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYTWO){
                  Ono.Dragy = Ono.DRAGY.THIRTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYTHREE){
                  Ono.Dragy = Ono.DRAGY.THIRTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYFOUR){
                  Ono.Dragy = Ono.DRAGY.THIRTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYFIVE){
                  Ono.Dragy = Ono.DRAGY.THIRTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYSIX){
                  Ono.Dragy = Ono.DRAGY.THIRTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.THIRTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.THIRTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYNINE){
                  Ono.Dragy = Ono.DRAGY.THIRTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTY){
                  Ono.Dragy = Ono.DRAGY.THIRTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYONE){
                  Ono.Dragy = Ono.DRAGY.FORTY;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYTWO){
                  Ono.Dragy = Ono.DRAGY.FORTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYTHREE){
                  Ono.Dragy = Ono.DRAGY.FORTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYFOUR){
                  Ono.Dragy = Ono.DRAGY.FORTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYFIVE){
                  Ono.Dragy = Ono.DRAGY.FORTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYSIX){
                  Ono.Dragy = Ono.DRAGY.FORTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.FORTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.FORTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYNINE){
                  Ono.Dragy = Ono.DRAGY.FORTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTY){
                  Ono.Dragy = Ono.DRAGY.FORTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYONE){
                  Ono.Dragy = Ono.DRAGY.FIFTY;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYTWO){
                  Ono.Dragy = Ono.DRAGY.FIFTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYTHREE){
                  Ono.Dragy = Ono.DRAGY.FIFTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYFOUR){
                  Ono.Dragy = Ono.DRAGY.FIFTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYFIVE){
                  Ono.Dragy = Ono.DRAGY.FIFTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYSIX){
                  Ono.Dragy = Ono.DRAGY.FIFTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.FIFTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.FIFTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYNINE){
                  Ono.Dragy = Ono.DRAGY.FIFTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTY){
                  Ono.Dragy = Ono.DRAGY.FIFTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYONE){
                  Ono.Dragy = Ono.DRAGY.SIXTY;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYTWO){
                  Ono.Dragy = Ono.DRAGY.SIXTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYTHREE){
                  Ono.Dragy = Ono.DRAGY.SIXTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYFOUR){
                  Ono.Dragy = Ono.DRAGY.SIXTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYFIVE){
                  Ono.Dragy = Ono.DRAGY.SIXTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYSIX){
                  Ono.Dragy = Ono.DRAGY.SIXTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.SIXTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.SIXTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYNINE){
                  Ono.Dragy = Ono.DRAGY.SIXTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTY){
                  Ono.Dragy = Ono.DRAGY.SIXTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYONE){
                  Ono.Dragy = Ono.DRAGY.SEVENTY;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYTWO){
                  Ono.Dragy = Ono.DRAGY.SEVENTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYTHREE){
                  Ono.Dragy = Ono.DRAGY.SEVENTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYFOUR){
                  Ono.Dragy = Ono.DRAGY.SEVENTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYFIVE){
                  Ono.Dragy = Ono.DRAGY.SEVENTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYSIX){
                  Ono.Dragy = Ono.DRAGY.SEVENTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.SEVENTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.SEVENTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYNINE){
                  Ono.Dragy = Ono.DRAGY.SEVENTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.EIGHTY){
                  Ono.Dragy = Ono.DRAGY.SEVENTYNINE;
               }
            }
         }
      }
      if (mx >= 616 && mx <= 633){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Scroll Down Button
            if (my >= 426 && my <= 449){
               if (Ono.Dragy == Ono.DRAGY.SEVENTYNINE){
                  Ono.Dragy = Ono.DRAGY.EIGHTY;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.SEVENTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.SEVENTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYSIX){
                  Ono.Dragy = Ono.DRAGY.SEVENTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYFIVE){
                  Ono.Dragy = Ono.DRAGY.SEVENTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYFOUR){
                  Ono.Dragy = Ono.DRAGY.SEVENTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYTHREE){
                  Ono.Dragy = Ono.DRAGY.SEVENTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYTWO){
                  Ono.Dragy = Ono.DRAGY.SEVENTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTYONE){
                  Ono.Dragy = Ono.DRAGY.SEVENTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTY){
                  Ono.Dragy = Ono.DRAGY.SEVENTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYNINE){
                  Ono.Dragy = Ono.DRAGY.SEVENTY;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.SIXTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.SIXTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYSIX){
                  Ono.Dragy = Ono.DRAGY.SIXTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYFIVE){
                  Ono.Dragy = Ono.DRAGY.SIXTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYFOUR){
                  Ono.Dragy = Ono.DRAGY.SIXTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYTHREE){
                  Ono.Dragy = Ono.DRAGY.SIXTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYTWO){
                  Ono.Dragy = Ono.DRAGY.SIXTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTYONE){
                  Ono.Dragy = Ono.DRAGY.SIXTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTY){
                  Ono.Dragy = Ono.DRAGY.SIXTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYNINE){
                  Ono.Dragy = Ono.DRAGY.SIXTY;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.FIFTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.FIFTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYSIX){
                  Ono.Dragy = Ono.DRAGY.FIFTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYFIVE){
                  Ono.Dragy = Ono.DRAGY.FIFTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYFOUR){
                  Ono.Dragy = Ono.DRAGY.FIFTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYTHREE){
                  Ono.Dragy = Ono.DRAGY.FIFTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYTWO){
                  Ono.Dragy = Ono.DRAGY.FIFTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTYONE){
                  Ono.Dragy = Ono.DRAGY.FIFTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTY){
                  Ono.Dragy = Ono.DRAGY.FIFTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYNINE){
                  Ono.Dragy = Ono.DRAGY.FIFTY;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.FORTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.FORTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYSIX){
                  Ono.Dragy = Ono.DRAGY.FORTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYFIVE){
                  Ono.Dragy = Ono.DRAGY.FORTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYFOUR){
                  Ono.Dragy = Ono.DRAGY.FORTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYTHREE){
                  Ono.Dragy = Ono.DRAGY.FORTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYTWO){
                  Ono.Dragy = Ono.DRAGY.FORTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTYONE){
                  Ono.Dragy = Ono.DRAGY.FORTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.FORTY){
                  Ono.Dragy = Ono.DRAGY.FORTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYNINE){
                  Ono.Dragy = Ono.DRAGY.FORTY;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.THIRTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.THIRTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYSIX){
                  Ono.Dragy = Ono.DRAGY.THIRTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYFIVE){
                  Ono.Dragy = Ono.DRAGY.THIRTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYFOUR){
                  Ono.Dragy = Ono.DRAGY.THIRTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYTHREE){
                  Ono.Dragy = Ono.DRAGY.THIRTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYTWO){
                  Ono.Dragy = Ono.DRAGY.THIRTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTYONE){
                  Ono.Dragy = Ono.DRAGY.THIRTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTY){
                  Ono.Dragy = Ono.DRAGY.THIRTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYNINE){
                  Ono.Dragy = Ono.DRAGY.THIRTY;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYEIGHT){
                  Ono.Dragy = Ono.DRAGY.TWENTYNINE;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYSEVEN){
                  Ono.Dragy = Ono.DRAGY.TWENTYEIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYSIX){
                  Ono.Dragy = Ono.DRAGY.TWENTYSEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYFIVE){
                  Ono.Dragy = Ono.DRAGY.TWENTYSIX;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYFOUR){
                  Ono.Dragy = Ono.DRAGY.TWENTYFIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYTHREE){
                  Ono.Dragy = Ono.DRAGY.TWENTYFOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYTWO){
                  Ono.Dragy = Ono.DRAGY.TWENTYTHREE;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTYONE){
                  Ono.Dragy = Ono.DRAGY.TWENTYTWO;
               }
               if (Ono.Dragy == Ono.DRAGY.TWENTY){
                  Ono.Dragy = Ono.DRAGY.TWENTYONE;
               }
               if (Ono.Dragy == Ono.DRAGY.NINETEEN){
                  Ono.Dragy = Ono.DRAGY.TWENTY;
               }
               if (Ono.Dragy == Ono.DRAGY.EIGHTEEN){
                  Ono.Dragy = Ono.DRAGY.NINETEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVENTEEN){
                  Ono.Dragy = Ono.DRAGY.EIGHTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.SIXTEEN){
                  Ono.Dragy = Ono.DRAGY.SEVENTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.FIFTEEN){
                  Ono.Dragy = Ono.DRAGY.SIXTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.FOURTEEN){
                  Ono.Dragy = Ono.DRAGY.FIFTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.THIRTEEN){
                  Ono.Dragy = Ono.DRAGY.FOURTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.TWELVE){
                  Ono.Dragy = Ono.DRAGY.THIRTEEN;
               }
               if (Ono.Dragy == Ono.DRAGY.ELEVEN){
                  Ono.Dragy = Ono.DRAGY.TWELVE;
               }
               if (Ono.Dragy == Ono.DRAGY.TEN){
                  Ono.Dragy = Ono.DRAGY.ELEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.NINE){
                  Ono.Dragy = Ono.DRAGY.TEN;
               }
               if (Ono.Dragy == Ono.DRAGY.EIGHT){
                  Ono.Dragy = Ono.DRAGY.NINE;
               }
               if (Ono.Dragy == Ono.DRAGY.SEVEN){
                  Ono.Dragy = Ono.DRAGY.EIGHT;
               }
               if (Ono.Dragy == Ono.DRAGY.SIX){
                  Ono.Dragy = Ono.DRAGY.SEVEN;
               }
               if (Ono.Dragy == Ono.DRAGY.FIVE){
                  Ono.Dragy = Ono.DRAGY.SIX;
               }
               if (Ono.Dragy == Ono.DRAGY.FOUR){
                  Ono.Dragy = Ono.DRAGY.FIVE;
               }
               if (Ono.Dragy == Ono.DRAGY.THREE){
                  Ono.Dragy = Ono.DRAGY.FOUR;
               }
               if (Ono.Dragy == Ono.DRAGY.TWO){
                  Ono.Dragy = Ono.DRAGY.THREE;
               }
               if (Ono.Dragy == Ono.DRAGY.START){
                  Ono.Dragy = Ono.DRAGY.TWO;
               }
            }
         }
      }
      if (mx >= 171 && mx <= 189){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Font Button         
            if (my >= 71 && my <= 85){
               if (Ono.Menu == Ono.MENU.HOME){
                  boolean boldState = word.getBold();
                  if (boldState){
                     word.setBold (false);
                  }
                  else{
                     word.setBold (true);
                  }
               }
            }
         }
      }
      if (mx >= 95 && mx <= 117){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Bold Button         
            if (my >= 92 && my <= 114){
               if (Ono.Menu == Ono.MENU.HOME){
                  boolean boldState = word.getBold();
                  if (boldState){
                     word.setBold (false);
                  }
                  else{
                     word.setBold (true);
                  }
               }
            }
         }
      }
      if (mx >= 95 && mx <= 117){
         if (Ono.State == Ono.STATE.FULLSCREEN){
         //Bold Button         
            if (my >= 92 && my <= 114){
               if (Ono.Menu == Ono.MENU.HOME){
                  boolean boldState = word.getBold();
                  if (boldState){
                     word.setBold (false);
                  }
                  else{
                     word.setBold (true);
                  }
               }
            }
         }
      }
   }
   public void mouseClicked (MouseEvent e){
   }
   public void mouseReleased (MouseEvent e){
   }
}