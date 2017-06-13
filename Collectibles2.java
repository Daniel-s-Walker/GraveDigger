import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;


public class Collectibles2 extends Collectibles
{
  private Image collectibles;
  private boolean isKey = false;
  private boolean pickedUp = false;
  
  public Collectibles2(int x, int y,Game game, boolean isKey, String collectiblestxt) {
    super(x,y,game,collectiblestxt);
    if (isKey) collectibles = Toolkit.getDefaultToolkit().getImage("key.png");
    else collectibles = Toolkit.getDefaultToolkit().getImage("coinbag.png");
    this.isKey = isKey;
  }
  
  
  public void paint(Graphics g){
    Graphics2D g2 = (Graphics2D) g; 
    if (pickedUp == false) g2.drawImage(collectibles, x,y-height,width,height, null); 
    
    
  }
  
  public boolean getPickedUp() {
    return pickedUp;
  }
  
  public void setPickedUp() {
    pickedUp = true;
  }
  
  public boolean getIsKey() {
    return isKey;
  }
}