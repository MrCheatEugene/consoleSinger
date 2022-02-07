import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class consoleSinger extends PApplet {


ControlP5 cp5;
String[] lyrics;
Textlabel currLine;

public void setup(){
 
     cp5 = new ControlP5(this);

  lyrics= loadStrings("lyrics.txt");
  PFont font = createFont("arial",20);
    currLine =  cp5.addTextlabel("label")
                    .setPosition(20,50)
                    .setColorValue(255)
                    .setFont(font)
                      ;
    
    cp5.addTextfield("Enter text")
       .setPosition(20,100)
       .setSize(200,40)
       .setFont(font)
       .setFocus(true)
       .setColor(color(255,0,0))
       ;
  }
  
  public void draw(){ 
  background(0);
  currLine.draw(this); 
  }
  
  
  public void controlEvent(ControlEvent theEvent) {
    if(theEvent.isAssignableFrom(Textfield.class)) {
  for (int i = 0 ; i < lyrics.length; i++) {
    if(lyrics[i].contains(theEvent.getStringValue()) == true){
    println("Found at "+i);
    if(i+1<lyrics.length){   
    currLine.setValueLabel(lyrics[i+1]);
  }else{
      currLine.setValueLabel(lyrics[i]+"(the end)");
  }
  }
  }
    }}  
  public void settings() {  size(700,200); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "consoleSinger" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
