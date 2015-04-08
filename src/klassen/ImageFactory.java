/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassen;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author Christian
 */
public class ImageFactory
{
  private static ImageFactory imageFactory;

  private HashMap<String,BufferedImage> looks=new HashMap<String, BufferedImage>();
  
  private ImageFactory(){
    try 
    {
      looks.put("spar_logo", ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/spar_logo.jpg")));
    }
    catch(Exception ex)
    {
      System.out.println("False path to image!!!");
    }
  }
  public static ImageFactory getIF()
  {
      if(imageFactory==null)imageFactory=new ImageFactory();
      return imageFactory;
  }
  public BufferedImage getLook(String str)
  {
      return looks.get(str);
  }
}
