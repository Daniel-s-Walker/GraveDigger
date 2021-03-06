import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Level{
  private int width=32;
  private int height=32;
  private int x;
  private int y;
  private int xL = 42;
  private int yL = 31;
  private int[][] levelLayout;
  
  private String leveltxt;
  
  
  public Level(String leveltxt){
    levelLayout = new int[xL][yL];
    this.leveltxt = leveltxt;
    try
    {
      //Create a new instance of the FileReader and pass it the
      //file that needs to be read
      FileReader fr = new FileReader(leveltxt);
      //Create a new instance of the BufferedReader and
      //add the FileReader to it
      BufferedReader br = new BufferedReader(fr);
      //A string variable that will temporarily what you�re reading
      String line;
      //A dual purpose line! First it reads the next line and then
      //it checks to see if that line was null. If it�s null, then
      //that means you�re at the end of the file.
      int yPos = 0;
      int xPos = 0;
      while ((line=br.readLine()) != null)
      {
        for(int i = 0; i < line.length(); i++){
          levelLayout[xPos][yPos] = line.charAt(i);
          xPos++;
        }
        yPos++;
        xPos = 0;
      }
      //close the file when you�re done
      br.close();
    }
    catch(IOException e)
    {
      //Error message
    }
  }
  
  public void paint(Graphics g){
    Graphics2D g2d = (Graphics2D) g;
    x = -32;
    //sky ends after y value
    y = 64;
    g2d.setColor(Color.BLACK);
    g2d.fillRect(0,0,1280,960);
    g2d.setColor(Color.BLUE);
    g2d.fillRect(0,0,1280,64);
    for(int i = 0; i < xL; i++){
      for(int z = 0; z < yL; z++){
        if(levelLayout[i][z] == 'g'){
          g2d.setColor(Color.GREEN);
          g2d.fillRect(x,y,width,height);
        }
        if(levelLayout[i][z] == 'd'){
          g2d.setColor(new Color(61,28,0));
          g2d.fillRect(x,y,width,height);
        }
        if(levelLayout[i][z] == 'r'){
          g2d.setColor(Color.GRAY);
          g2d.fillRect(x,y,width,height);
        }
        if(levelLayout[i][z] == 't'){
          g2d.setColor(Color.BLACK);
          g2d.fillRect(x,y,width,height);
        }
        y = y + height;
      }
      x = x + width;
      y = 64;
    }
  }
  
  public int getTile(int x,int y){
    return levelLayout[x][y]; 
  }
  
  public void setTile(int x, int y, char p){
    levelLayout[x][y] = p; 
  }
  
  public int getRockCount(){
    int rockCounter = 0;
    
    for(int i = 0; i < xL; i++){
      for(int z = 0; z < yL; z++){
        if(levelLayout[i][z] == 'r'){
          rockCounter++; 
        }
      }
    }
    
    return rockCounter; 
  }
  
}