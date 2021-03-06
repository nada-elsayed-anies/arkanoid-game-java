/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import static Arkanoid.Menu.stage_menu;
import Arkanoid.MenuDesign.MenuItem;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Eng.Waleed
 */
public class setting 
{
   
  
    public  VBox     set =  new VBox () ;
  
    public  Scene    scene_setting = new Scene (set,1500,780);

        MenuItem  play = new MenuDesign.MenuItem("PLAY SOUND");
        public static  MenuItem  stop = new MenuDesign.MenuItem("STOP SOUND");
        MenuItem  brightness = new MenuDesign.MenuItem("BRIGHTNESS");
        MenuItem  dark = new MenuDesign.MenuItem("DARKNESS");
        MenuItem  back = new MenuDesign.MenuItem("BACK TO MENU");
       Image Imageback=new Image("Resources/Images/Background/bb.jpg",1500,780,false,true);
       BackgroundImage background = 
       new BackgroundImage(Imageback,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,null);
       double mode1 =0.1;
       double mode2 =-0.1;
      
          setting (Stage stage ) 
          {
              stage.setScene(scene_setting); 
              Intialize();
          }
           
   public     double mode_bright(double mode1){
            if(mode1<=1)
          mode1=mode1+0.2;
            
        return mode1;
        }
   
  public     double mode_dark(double mode2){
            if(mode2>=-0.8)
          mode2=mode2-0.1; 
           
        return mode2 ;
        }
          
          
    public  void Intialize()
   {
   
         play.setTranslateY(100+20);
         stop.setTranslateY(140+20);
         brightness.setTranslateY(160);
         dark.setTranslateY(210);
         back.setTranslateY(260+130);
 
         play.setOnMousePressed(e->
         { 
         
            
          //  Sound.mediaPlayer_clickMouse.play();
            Sound.mediaPlayer_background .play();
         }); 
        stop.setOnMousePressed(e->
         { 
           // Sound.mediaPlayer_clickMouse.play();
            Sound.mediaPlayer_background .stop();
         }); 
        set.getChildren().addAll(play,stop,back, brightness,dark );
     
        
         back.setOnMousePressed(e->
         { 
              // Sound.mediaPlayer_clickMouse.play();
             stage_menu.setScene(Menu.sceneButtons);
         }); 
         brightness.setOnMousePressed(e->
         { 
              // Sound.mediaPlayer_clickMouse.play();
             ColorAdjust colorAdjust = new ColorAdjust();
             colorAdjust.setBrightness(mode1);
               Arkanoid_main.group.setEffect(colorAdjust);
            mode_bright(mode1);
         }); 
         dark.setOnMousePressed(e->
         { 
              // Sound.mediaPlayer_clickMouse.play();
             ColorAdjust colorAdjust = new ColorAdjust();
             colorAdjust.setBrightness(mode2);
                Arkanoid_main.group.setEffect(colorAdjust);
             mode_dark(mode2);
         }); 
      set.setBackground(new Background(background));
    
      
   }
  
}
