/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klassen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.SplitPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Christian
 */
public class MainGUI extends JFrame
{
  private JPanel stuff=new JPanel(new GridLayout());
  private JPanel sponsors=new JPanel(new GridLayout());
  
  private JPanel game1;
  private JLabel platz;
  
  private JLabel team1;
  private JLabel team2;
  
  private JLabel score1;
  private JLabel score2;
  
  private JLabel satz1;
  private JLabel satz2;
  
  private JPanel game2;
  
  private JLabel platz2;
  
  private JLabel team3;
  private JLabel team4;
  
  private JLabel score3;
  private JLabel score4;
  
  private JLabel satz3;
  private JLabel satz4;
  
  private Font font;
  
  public MainGUI()
  {
    setResizable(false);
    setSize(1024,768);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setUndecorated(true);
    setLocationRelativeTo(null);
    setLayout(new GridLayout());
    
    initComponents();
    
    
    
    addKeyListener(new KeyAdapter()
    {
      @Override
      public void keyPressed(KeyEvent e)
      {
        switch(e.getKeyCode())
        {
          //Punkte verändern
          case KeyEvent.VK_Q:
            int help = Integer.parseInt(score1.getText());
            if(help>0)score1.setText(String.format("%d", help-1));
            break;
          case KeyEvent.VK_W:
            score1.setText(String.format("%d", Integer.parseInt(score1.getText())+1));
            break;
          case KeyEvent.VK_E:
            help = Integer.parseInt(score2.getText());
            if(help>0)score2.setText(String.format("%d", help-1));
            break;
          case KeyEvent.VK_R:
            score2.setText(String.format("%d", Integer.parseInt(score2.getText())+1));
            break;
            
          //Satz verändern
          case KeyEvent.VK_A:
            help = Integer.parseInt(satz1.getText().trim());
            if(help>0)satz1.setText(String.format("   %d", help-1));
            break;
          case KeyEvent.VK_S:
            satz1.setText(String.format("   %d", Integer.parseInt(satz1.getText().trim())+1));
            break;
          case KeyEvent.VK_D:
            help = Integer.parseInt(satz2.getText().trim());
            if(help>0)satz2.setText(String.format("   %d", help-1));
            break;
          case KeyEvent.VK_F:
            satz2.setText(String.format("   %d", Integer.parseInt(satz2.getText().trim())+1));
            break;
            
          //Punkte verändern
          case KeyEvent.VK_Z:
            help = Integer.parseInt(score3.getText());
            if(help>0)score3.setText(String.format("%d", help-1));
            break;
          case KeyEvent.VK_U:
            score3.setText(String.format("%d", Integer.parseInt(score3.getText())+1));
            break;
          case KeyEvent.VK_I:
            help = Integer.parseInt(score4.getText());
            if(help>0)score4.setText(String.format("%d", help-1));
            break;
          case KeyEvent.VK_O:
            score4.setText(String.format("%d", Integer.parseInt(score4.getText())+1));
            break;
            
          //Satz verändern
          case KeyEvent.VK_H:
            help = Integer.parseInt(satz3.getText().trim());
            if(help>0)satz3.setText(String.format("   %d", help-1));
            break;
          case KeyEvent.VK_J:
            satz3.setText(String.format("   %d", Integer.parseInt(satz3.getText().trim())+1));
            break;
          case KeyEvent.VK_K:
            help = Integer.parseInt(satz4.getText().trim());
            if(help>0)satz4.setText(String.format("   %d", help-1));
            break;
          case KeyEvent.VK_L:
            satz4.setText(String.format("   %d", Integer.parseInt(satz4.getText().trim())+1));
            break;
            
          //Neues Spiel
          case KeyEvent.VK_SPACE:
            String teamNames[]={team1.getText(),team2.getText(),team3.getText(),team4.getText()};
            DialogNewTeams dnt=new DialogNewTeams(null, true,teamNames);
            dnt.setLocationRelativeTo(null);
            dnt.setVisible(true);
            if(dnt.isOk())
            {
              String str[]=dnt.getTeamNames();
              team1.setText(str[0]);
              team2.setText(str[1]);
              team3.setText(str[2]);
              team4.setText(str[3]);
            }
            break;
          case KeyEvent.VK_N:
            showGame();
            break;
          case KeyEvent.VK_M:
            showSponsores();
            break;
        }
      }
    });
  }
  private void initComponents()
  {
//    try {
//      font=Font.createFont(Font.TRUETYPE_FONT, new File("batmfa__.ttf"));
//    } catch (FontFormatException ex) {
//      Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
//    } catch (IOException ex) {
//      Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
//    }
    
    stuff.setLayout(new GridLayout(2, 1));
    
    JPanel upperStuff=new JPanel(new BorderLayout());
    
    game1=new JPanel(new GridLayout(3, 2));
    
    Font platz=new Font("Tahoma", Font.BOLD, 64);
    Font team=new Font("Tahoma", Font.BOLD, 30);
    Font score=new Font("Tahoma", Font.BOLD, 40);
    Font satz=new Font("Tahoma", Font.BOLD, 20);
    
    this.platz=new JLabel("Platz 1");
    this.platz.setHorizontalAlignment(SwingConstants.CENTER);
    this.platz.setVerticalAlignment(SwingConstants.BOTTOM);
    this.platz.setFont(platz);
    
    team1=new JLabel("Team 1");
    team1.setFont(team);
    this.team1.setHorizontalAlignment(SwingConstants.CENTER);
    this.team1.setVerticalAlignment(SwingConstants.BOTTOM);
    team2=new JLabel("Team 2");
    team2.setFont(team);
    this.team2.setHorizontalAlignment(SwingConstants.CENTER);
    this.team2.setVerticalAlignment(SwingConstants.BOTTOM);
    
    score1=new JLabel("0");
    score1.setFont(score);
    this.score1.setHorizontalAlignment(SwingConstants.CENTER);
    this.score1.setVerticalAlignment(SwingConstants.BOTTOM);
    score2=new JLabel("0");
    score2.setFont(score);
    this.score2.setVerticalAlignment(SwingConstants.BOTTOM);
    this.score2.setHorizontalAlignment(SwingConstants.CENTER);
    
    satz1=new JLabel("  0");
    satz1.setFont(satz);
    this.satz1.setHorizontalAlignment(SwingConstants.CENTER);
    this.satz1.setVerticalAlignment(SwingConstants.TOP);
    satz2=new JLabel("  0");
    satz2.setFont(satz);
    this.satz2.setHorizontalAlignment(SwingConstants.CENTER);
    this.satz2.setVerticalAlignment(SwingConstants.TOP);
    
    game1.add(this.team1);
    game1.add(this.team2);
    game1.add(this.score1);
    game1.add(this.score2);
    game1.add(this.satz1);
    game1.add(this.satz2);
    
    
    
    upperStuff.add(this.platz,BorderLayout.PAGE_START);
    upperStuff.add(game1,BorderLayout.CENTER);
    
    stuff.add(upperStuff);
    
    JPanel lowerstuff=new JPanel(new BorderLayout());
    
    game2=new JPanel(new GridLayout(3, 2));
    
    this.platz2=new JLabel("Platz 2");
    this.platz2.setHorizontalAlignment(SwingConstants.CENTER);
    this.platz2.setVerticalAlignment(SwingConstants.BOTTOM);
    this.platz2.setFont(platz);
    
    team3=new JLabel("Team 1");
    team3.setFont(team);
    this.team3.setHorizontalAlignment(SwingConstants.CENTER);
    this.team3.setVerticalAlignment(SwingConstants.BOTTOM);
    team4=new JLabel("Team 2");
    team4.setFont(team);
    this.team4.setHorizontalAlignment(SwingConstants.CENTER);
    this.team4.setVerticalAlignment(SwingConstants.BOTTOM);
    
    score3=new JLabel("0");
    score3.setFont(score);
    this.score3.setHorizontalAlignment(SwingConstants.CENTER);
    this.score3.setVerticalAlignment(SwingConstants.BOTTOM);
    score4=new JLabel("0");
    score4.setFont(score);
    this.score4.setVerticalAlignment(SwingConstants.BOTTOM);
    this.score4.setHorizontalAlignment(SwingConstants.CENTER);
    
    satz3=new JLabel("  0");
    satz3.setFont(satz);
    this.satz3.setHorizontalAlignment(SwingConstants.CENTER);
    this.satz3.setVerticalAlignment(SwingConstants.TOP);
    satz4=new JLabel("  0");
    satz4.setFont(satz);
    this.satz4.setHorizontalAlignment(SwingConstants.CENTER);
    this.satz4.setVerticalAlignment(SwingConstants.TOP);
    
    game2.add(this.team3);
    game2.add(this.team4);
    game2.add(this.score3);
    game2.add(this.score4);
    game2.add(this.satz3);
    game2.add(this.satz4);
    
    
    
    lowerstuff.add(this.platz2,BorderLayout.PAGE_START);
    lowerstuff.add(game2,BorderLayout.CENTER);
    
    stuff.add(lowerstuff);
    
    
    this.add(stuff);
  }
  private void showGame()
  {
    this.repaint();
    Graphics g=this.getGraphics();
    BufferedImage volleyBallLogo=ImageFactory.getIF().getLook("VolleyBallLogo");
    g.drawImage(volleyBallLogo,getWidth()-volleyBallLogo.getWidth(),
                getHeight()-volleyBallLogo.getHeight(), null);
  }
  private void showSponsores()
  {
    Graphics g=this.getGraphics();
    g.setColor(Color.DARK_GRAY);
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(Color.WHITE);
    g.setFont(new Font("Tahoma", Font.BOLD, 64));
    g.drawString("Sponsoren", 40, 100);
    g.drawImage(ImageFactory.getIF().getLook("spar_logo"), 10, 200, null);
    g.drawImage(ImageFactory.getIF().getLook("soccer_room"),
                (this.getWidth()-ImageFactory.getIF().getLook("soccer_room").getWidth())/2,
                getHeight()-ImageFactory.getIF().getLook("soccer_room").getHeight()-50, null);
    addKeyListener(new KeyAdapter()
    {
      @Override
      public void keyPressed(KeyEvent e)
      {
        switch(e.getKeyCode())
        {
          case KeyEvent.VK_C:
          g.setColor(Color.DARK_GRAY);
          g.fillRect(0, 0, getWidth(), getHeight());
          g.setColor(Color.WHITE);
          g.setFont(new Font("Tahoma", Font.BOLD, 64));
          g.drawString("S", 40, 120);
          g.drawString("P", 40, 200);
          g.drawString("O", 40, 280);
          g.drawString("N", 40, 360);
          g.drawString("S", 40, 440);
          g.drawString("O", 40, 520);
          g.drawString("R", 40, 600);
          g.drawString("S", 40, 680);
          g.drawImage(ImageFactory.getIF().getLook("logoMueller"),140, 0, null);
          System.out.println("blablasdf");
          break;
        }
      }
    });
  }
  
  public static void main(String args[])
  {
    java.awt.EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        MainGUI mg=new MainGUI();
        mg.setVisible(true);
      }
    });
  }
}
