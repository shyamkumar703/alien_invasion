public class Starter
{
    public static void main(String[] args)
    {
        GameEngine g = new GameEngine();
        //g.animate();
    }
}

//HELLO ALL. NOTE THAT THE WINDOW IS NOT BIG ENOUGH TO PLAY
//WE CAN MAKE THE WINDOW BIGGER, BUT IT WILL AFFECT VALUES, AND WE WILL HAVE TO
//CHANGE THEM. FOR NOW, WE MUST CHANGE THE BOUNDS TO REMOVE THE BULLET.
//IF UDK WHAT THIS MEANS CALL NAREN AT 408-892-2648. THIS IS IMPORTANT
//AND IF NOT KNOWN, IT COULD MAKE THE PROGRAM NOT WORK WHEN WE MAKE THE WINDOW BIGGER,
//AND THIS WILL CAUSE UNNECESSARY FRUSTRATION.

//work on infinity problem with bullets
/**
 * Write a description of class asdhseadasd here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameEngine implements ActionListener
{
    // instance variables - replace the example below with your own
    //BulletComponent bC = new BulletComponent(5,5,10,10);
    int count;
    ArrayList <BulletComponent> bCList = new ArrayList<BulletComponent>();;
    HelicopterComponent hC = new HelicopterComponent();
    ArrayList <HelicopterComponent> hCList = new ArrayList <HelicopterComponent>();
    ArrayList <ExplosionComponent> eCList = new ArrayList <ExplosionComponent>();
    ArrayList <TrooperComponent> tCList = new ArrayList <TrooperComponent>();
    JFrame iFrame;
    JFrame f;//testing frame
    //BulletComponent tempB;
    //HelicopterComponent tempH;
    //ArrayList<BulletComponent> bL = new ArrayList<BulletComponent>(); haven't figured out how to use this yet
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        //BulletComponent bC = new BulletComponent(0,0,5,5);
        iFrame = new JFrame("Paratroooper DOS");
        iFrame.setBackground(Color.BLACK);
        iFrame.setSize(800,450);
        iFrame.getContentPane().setBackground(Color.BLACK);
        iFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f = new JFrame("Test Frame");
        f.setSize(800,450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tempB = new BulletComponent(-1000,-1000, 250, 250);
        //tempH = new HelicopterComponent();
        iFrame.setVisible(true);
        count=0;
        //bC initialB = new
        //set JFrame size
        GunComponent gC = new GunComponent();
        iFrame.add(gC);
        Timer t = new Timer(18,gC);//Timer for gun
        t.start();
        /*class ShootListener implements KeyListener
        //use an "inner class" so that the rC variable local to the main method
        //can be accessed by the ColorListener class
        {
            public void keyPressed (KeyEvent e)
            {
                //instructions for what happens when key is pressed
                //if Q is pressed invoke increaseR on rC
                //BulletComponent[] bCList = new BulletComponent[10];
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_SPACE : //System.out.println("Space Entered");
                                             //bCList[count] = new BulletComponent((int) gC.getFirst().getX() +400,
                                             bCList.add(count, new BulletComponent((int) gC.getFirst().getX() +400,
                                                                      (int) gC.getFirst().getY() +350,
                                                                      (int) gC.getSecond().getX() +400,
                                                                      (int) gC.getSecond().getY() +350));
                                             /*System.out.println       (//"" + gC.getFirst().getX() +
                                                                       "" + ((int) gC.getFirst().getY() + 350) +
                                                                       //"" + gC.getSecond().getX() +
                                                                       "" + ((int) gC.getSecond().getY() + 350));
                                             //iFrame.add(bCList[count]);
                                             iFrame.add(bCList.get(count));
                                             iFrame.setVisible(true);
                                            // Timer t2 = new Timer(200,bCList[count]);
                                             Timer t2 = new Timer(200, bCList.get(count));
                                             t2.start();
                                             count++;
                                             break;
                }
            }
            public void keyReleased (KeyEvent e) {}
            public void keyTyped (KeyEvent e) {}
        }
        iFrame.addKeyListener(new ShootListener());*/
        //Timer t2 = new Timer(25,bC);
        //t2.start();
        class ShootListener implements KeyListener
        //use an "inner class" so that the rC variable local to the main method
        //can be accessed by the ColorListener class
        {
            public void keyPressed (KeyEvent e)
            {
                //instructions for what happens when key is pressed
                //if Q is pressed invoke increaseR on rC
                //BulletComponent[] bCList = new BulletComponent[10];
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_SPACE : //System.out.println("Space Entered");
                                             //bCList[count] = new BulletComponent((int) gC.getFirst().getX() +400,
                                             bCList.add(count, new BulletComponent((int) gC.getFirst().getX(),
                                                                      (int) gC.getFirst().getY(),
                                                                      (int) gC.getSecond().getX(),
                                                                      (int) gC.getSecond().getY()));
                                             //gC.addBullet();
                                             //iFrame.add(bCList[count]);
                                             iFrame.add(bCList.get(count));
                                             iFrame.setVisible(true);
                                             //Timer t2 = new Timer(200,bCList[count]);
                                             //Timer t2 = new Timer(200, bCList.get(count));
                                             //t2.start();
                                             //count++;
                                             //System.out.println("BulletComponentList size = " + bCList.size());
                                             break;
                    case KeyEvent.VK_K : //System.out.println("BULL " +bCList.get(bCList.size()-1).getXPos());
                                         break;

                    case KeyEvent.VK_L : //System.out.println("HELI " +hCList.get(hCList.size()-1).getXPos());
                                         break;
                    case KeyEvent.VK_H : //System.out.println("HELI " +hCList.get(hCList.size()-1).getXPos() + " BULL " +bCList.get(bCList.size()-1).getXPos());
                                         //System.out.println(hCList.get(0).geetHeight());
                                         break;
                    case KeyEvent.VK_RIGHT : gC.setRight();
                                             break;
                    case KeyEvent.VK_LEFT  : gC.setLeft();
                                             break;


                    /*case KeyEvent.VK_T :
                    {
                        TrooperComponent tr = new TrooperComponent (hCList.get(0).getXPos(),10);
                        //tr = new TrooperComponent (hCList.get(0).getXPos(),10);
                        iFrame.add(tr);
                        iFrame.setVisible(true);
                        tCList.add(tr);
                    }*/
                }
            }
            public void keyReleased (KeyEvent e) {
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_RIGHT : gC.resetChange();
                                             break;
                    case KeyEvent.VK_LEFT  : gC.resetChange();
                                             break;
                }
            }
            public void keyTyped (KeyEvent e) {}
        }
        iFrame.addKeyListener(new ShootListener());

        Timer g1 = new Timer(30,this);
        g1.start();
        iFrame.setVisible(true);
    }

    public void nextThrough()
    {
        HelicopterComponent hC = new HelicopterComponent();
        iFrame.add(hC);
        iFrame.setVisible(true);
        hCList.add(hC);
        //System.out.println("HelicopterComponentList size = " + hCList.size());
    }

    public void addExplosion(int xVal, int yVal)
    {
        ExplosionComponent eC = new ExplosionComponent(xVal, 10);
        iFrame.add(eC);
        iFrame.setVisible(true);
        eCList.add(eC);
    }

    public void addTrooper()
    {
        TrooperComponent tr;
        boolean sent = false;
        int index = 0;
        /*tr = new TrooperComponent(50,10);
                iFrame.add(tr);
                iFrame.setVisible(true);
                tCList.add(tr);*/
        while (!sent && index < hCList.size())
        {
            if (!hCList.get(index).trooperSent())
            {
                sent = true;//should exit the loop
                //System.out.println("Trooper creation conditional entered");
                hCList.get(index).changeSentStatus();
                //change the status of the HelicopterComponent trooper sent
                //instance field, which means that that helicopter
                //SHOULD not be able to send new Troopers because
                //the !hCList.get(index).trooperSent()) should evaluate to false
                //System.out.println("heli entered" + index);
                //System.out.println(hCList.get(index).trooperSent() + "");
                //System.out.println(hCList.get(index).getXPos());
                //System.out.println("if statement in addTrooper method entered for "
                //+ "helicopter number" + index);
                //System.out.println(hCList.get(index).getXPos() + "");
                tr = new TrooperComponent(hCList.get(index).getXPos(),20);
                //tr = new TrooperComponent(300,20);
                iFrame.add(tr);
                iFrame.setVisible(true);
                tCList.add(tr);
            }
            index++;
        }
    }

    /*public boolean setIndex(BulletComponent b, HelicopterComponent h)
    {
        if(b==tempB) return false;
        else if(h==tempH) return false;
        else
        {
            tempB = b;
            tempH = h;
            return true;
        }
    }*/

    //public void explode (int xP, int yP)
    {

    }
    public void actionPerformed(ActionEvent e)
    {
        int rand = (int) (Math.random() * 1000);
        if (rand < 25)
        {
            nextThrough();
        }

        if (rand < 13)
        {
            addTrooper();
        }
        animateComponents();

        int index = 0;

        //if(hCList.size()>0) System.out.println(hCList.get(0).getXPos());
        int bIndex=-5;
        int hIndex=-5;
        //attempting to interact the bullets with the ships
        //if(bCList.size()>0)
        //{
        if (rand < 30)
        {

        }

        for (BulletComponent b : bCList)
        {
             //if(hCList.size()>0)
             //{
             //for (HelicopterComponent h : hCList)
             for(int i=0;i<hCList.size();i++)
             {
                    HelicopterComponent h = hCList.get(i);
                    //h height is 362
                    //h heeight is 62 or 68
                    //System.out.println(h.geetHeight());
                    //EVERYTHING HERE AFFECTED BY FRAME ENLARGEMENT
                    //(b.getYPos()<=10+h.geetHeight())&&(b.getYPos()>0)
                    if((b.getXPos()>=(h.getXPos()))&&
                        (b.getXPos()<=(h.getXPos()+h.geetWidth()))&&
                        (b.getYPos()<=10+h.geetHeight()))
                    {
                        //System.out.println(bCList.indexOf(b));
                        //iFrame.remove(b);// ITS REMOVING MORE THAN ONE OOOHHHHHHHH
                        iFrame.remove(h);
                        //bCList.remove(b);
                        hCList.remove(h);
                        //System.out.println(hCList.size());
                        //iFrame.remove(b);// ITS REMOVING MORE THAN ONE OOOHHHHHHHH
                        //iFrame.remove(h);
                        //iFrame.setVisible(true); //IT IS ONLY DISAPPEARING HELICOPTERS FROM THE RIGHT!`
                        /*if(setIndex(b,h))
                        {
                            System.out.println("They touched!");
                            //bCList.remove(b);
                            //hCList.remove(h);
                            iFrame.remove(b);// ITS REMOVING MORE THAN ONE OOOHHHHHHHH
                            iFrame.remove(h);
                            //iFrame.setVisible(true);
                        }*/
                        //bIndex=bCList.indexOf(b);
                        //hIndex=hCList.indexOf(h);
                        //System.out.println("They touched!");
                        //System.out.println("They Touched");
                        addExplosion(h.getXPos(),10);
                        //ystem.out.println(hCList.size());
                        //i--;
                        //if(hCList.size()==0) i=hCList.size(); //the only way this can end is when hCList is 0, but we don't need that
                    }
                                    //if((b.x>=600)&&(b.x<=799)&&(b.y<=100)) System.out.println("They touched!");

                    //if((b.x>=h.x)&&(b.x<=h.x+100)&&(b.y>=h.y)&&(b.y<=h.y+100)) System.out.println("They touched!");
                    //if((b.x>=50)&&(b.x<=150)&&(b.y<=225)&&(b.y>=0)) System.out.println("Getting there");
             }

             for(int i=0;i<tCList.size();i++)
             {
                    TrooperComponent t = tCList.get(i);
                    //h height is 362
                    //h heeight is 62 or 68
                    //System.out.println(h.geetHeight());
                    //EVERYTHING HERE AFFECTED BY FRAME ENLARGEMENT
                    //(b.getYPos()<=10+h.geetHeight())&&(b.getYPos()>0)
                    if((b.getXPos()>=(t.getXPos()-t.geetWidth())&&
                        (b.getXPos()<=(t.getXPos()+2*t.geetWidth()))&&
                        (b.getYPos()<=t.getYPos()+2*t.geetHeight())&&
                        (b.getYPos()>=t.getYPos()-t.geetHeight())))
                    {
                        //System.out.println(bCList.indexOf(b));
                        //iFrame.remove(b);// ITS REMOVING MORE THAN ONE OOOHHHHHHHH
                        iFrame.remove(t);
                        //bCList.remove(b);
                        tCList.remove(t);
                        //System.out.println(tCList.size());
                        //iFrame.remove(b);// ITS REMOVING MORE THAN ONE OOOHHHHHHHH
                        //iFrame.remove(h);
                        //iFrame.setVisible(true); //IT IS ONLY DISAPPEARING HELICOPTERS FROM THE RIGHT!`
                        /*if(setIndex(b,h))
                        {
                            System.out.println("They touched!");
                            //bCList.remove(b);
                            //hCList.remove(h);
                            iFrame.remove(b);// ITS REMOVING MORE THAN ONE OOOHHHHHHHH
                            iFrame.remove(h);
                            //iFrame.setVisible(true);
                        }*/
                        //bIndex=bCList.indexOf(b);
                        //hIndex=hCList.indexOf(h);
                        //System.out.println("They touched!");
                        //System.out.println("Bullet and trooper touched");
                        addExplosion(t.getXPos(),t.getYPos());
                        //ystem.out.println(hCList.size());
                        //i--;
                        //if(hCList.size()==0) i=hCList.size(); //the only way this can end is when hCList is 0, but we don't need that
                    }
                                    //if((b.x>=600)&&(b.x<=799)&&(b.y<=100)) System.out.println("They touched!");

                    //if((b.x>=h.x)&&(b.x<=h.x+100)&&(b.y>=h.y)&&(b.y<=h.y+100)) System.out.println("They touched!");
                    //if((b.x>=50)&&(b.x<=150)&&(b.y<=225)&&(b.y>=0)) System.out.println("Getting there");
             }

             //}
        }
        //}
        //for (ExplosionComponent c : eCList)
        //{
          //  c.move();
            //System.out.println(hCList.get(0).getXPos());
        //    c.repaint(); //THIS MIGHT BE THE LAG/FREEZE CAUSE
            /*if(c.geetWidth()>200)
            {
                iFrame.remove(c);
                eCList.remove(c);
                iFrame.setVisible(true);
            }*/
        //}
        /* if((bIndex!=-5)&&(hIndex!=-5))
        {
            bCList.remove(bCList.get(bIndex));
            hCList.remove(hCList.get(hIndex));
            iFrame.remove(bCList.get(bIndex));
            iFrame.remove(hCList.get(hIndex));
        }*/

            //YAAAAAAS IT REMOVES THE BULLETS
        removeExtraneousComponents();
    }

    public void animateComponents()
    {
        for (BulletComponent b : bCList)
        {
            b.move();
            b.repaint();
        }

        for (HelicopterComponent h : hCList)
        {
            h.move();
            //System.out.println(hCList.get(0).getXPos());
            h.repaint(); //THIS MIGHT BE THE LAG/FREEZE CAUSE
        }

        for (TrooperComponent tr : tCList)
        {
            tr.move();
            tr.repaint();
        }

        for (ExplosionComponent c : eCList)
        {
            c.move();
            //System.out.println(hCList.get(0).getXPos());
            c.repaint(); //THIS MIGHT BE THE LAG/FREEZE CAUSE
            /*if(c.geetWidth()>200)
            {
                iFrame.remove(c);
                eCList.remove(c);
                iFrame.setVisible(true);
            }*/
        }
    }

    public void removeExtraneousComponents()
    {
        //VERY minor efficieny issue,
        //below for loops should be restrucured into
        //while loops, but these will work for now
        for(int g=0;g < hCList.size(); g++)
        {
            if (hCList.get(g).getXPos()>800 || hCList.get(g).getXPos()<-50)
            {
                iFrame.remove(hCList.get(g));
                hCList.remove(g);
                //System.out.println("HeliComponentList size = " + hCList.size());
            }
        }

        for(int i=0;i < bCList.size();i++)
        {
            if (bCList.get(i).getYPos() < 0|| bCList.get(i).getXPos() > 765 || bCList.get(i).getXPos() < 0)
            {
                bCList.remove(i);
                //System.out.println("BulletComponentList size = " + bCList.size());
            }
        }

        for(int f=0;f < eCList.size();f++)
        {
            if (eCList.get(f).geetWidth() > 225)
            {
                iFrame.remove(eCList.get(f));
                eCList.remove(eCList.get(f));
                iFrame.setVisible(true);
                //System.out.println("BulletComponentList size = " + bCList.size());
                //f--;
            }
        }

        for(int p=0;p < tCList.size(); p++)
        {
            if (tCList.get(p).getYPos()>800)
            {
                iFrame.remove(tCList.get(p));
                tCList.remove(p);
                //System.out.println("TroopComponentList size = " + tCList.size());
            }
        }
    }

    public void runLevel1()
    {

    }
}


/**
 * Write a description of class adsfhasdgasdf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.*;
public class HelicopterComponent extends JComponent
{
    int x, y, dx;
    Rectangle2D.Double helicopter;
    BufferedImage copter;
    boolean trooperSent;
    int direction;//0 for facing right, 1 for facing left
    public HelicopterComponent()
    {
        trooperSent = false;
        direction = (int) (Math.random() * 2);
        //direction = 0;
        switch (direction)
        {
            case 0 : x = -50;
                     y = 10;
                     dx = 3;
                     copter = null;
                     try {
                         copter = ImageIO.read(new File("Helicopter Picture1.png"));
                        } catch (IOException e) {
                        }
                     break;

            case 1 : x = 800;
                     y = 10;
                     dx = -3;
                     copter = null;
                     try {
                         copter = ImageIO.read(new File("Helicopter Picture2.png"));
                        } catch (IOException e) {
                        }
                     break;
        }
        //helicopter = new Rectangle2D.Double(x, y, 10, 10);
    }

    public void paintComponent(Graphics g)
    {
        //helicopter = new Rectangle2D.Double(x,y,10,10);
        Graphics2D g2 = (Graphics2D) g;
        g.drawImage(copter,x,y,null);
        //g2.draw(helicopter);
        //g2.setColor(Color.RED);
        //g2.fill(helicopter);
    }

    public void move()
    {
        x+=dx;
        //System.out.println(x);
        //System.out.println("HelicopterComponent move method entered");
    }

    public void actionPerformed(ActionEvent e)
    {
        //System.out.println("HelicopterComponent actionPerformed method entered");
        move();
        repaint();
    }

    public int getXPos()
    {
        switch (direction)
        {
            case 0 : return x + 100;
            case 1 : return x;
        }
        return x;
    }

    public int geetWidth()
    {
        return copter.getWidth();
    }

    public int geetHeight()
    {
        return copter.getHeight();
    }

    public boolean trooperSent()
    {
        return trooperSent;
    }

    public void changeSentStatus()
    {
        trooperSent = true;
        //System.out.println("" + trooperSent);
    }


}


/**
 * Write a description of class asdf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

/**
 * Write a description of class GunComponent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.*;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.Random;
public class GunComponent extends JComponent implements ActionListener
{
    // instance variables - replace the example below with your own
    Ellipse2D.Double head;
    Rectangle2D.Double rectBody;
    Line2D.Double gun;
    int w,h;
    int x1,y1,x2,y2;
    int r1 = 25;
    int r2 = 50;
    int theta = 360;
    int change;

    public GunComponent()
    {
        h = 400;
        w = 800;
        //rectBody = new Rectangle2D.Double(350,730,100,70);
        rectBody = new Rectangle2D.Double(375,350,50,50);
        head = new Ellipse2D.Double(375,325,50,50);
        gun = new Line2D.Double(425,350,450,350);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        drawBody(g2);
        drawGun(g2);
    }

    public void drawBody(Graphics2D g2)
    {
        g2.setColor(Color.BLUE);
        g2.draw(rectBody);
        g2.fill(rectBody);
        g2.draw(head);
        g2.fill(head);
        g2.setColor(Color.GREEN);
    }

    public void drawGun(Graphics2D g2)
    {
       //g2.translate(400,350);
        /*
        for (int theta = 180; theta < 360; theta += 6)//theta is the counter for 60 minutes (360/60=6)
        {
            double thetaRadians = Math.toRadians(theta);//static method toRadians converts the degree
            //value to a Radian measure, which is easier for the cos and sin functions to use for our
            //purposes
            double x1 = r1 * Math.cos(thetaRadians);//static method cos invoked with explicit parameter
            //radian value of angle returns the radian value of an angle taken in degrees
            double y1 = r1 * Math.sin(thetaRadians);
            double x2 = r2 * Math.cos(thetaRadians);
            double y2 = r2 * Math.sin(thetaRadians);
            //trigonometry, where given a set hypotenuse lenght, one can find the lengths of both
            //the height and the width given one angle
            //x1,y2,x2,y2
            gun = new Line2D.Double(x1,y1,x2,y2);
            g2.draw(gun);
        }
        */
       double thetaRadians = Math.toRadians(theta);//static method toRadians converts the degree
       //value to a Radian measure, which is easier for the cos and sin functions to use for our
       //purposes
       double x1 = r1 * Math.cos(thetaRadians)+400;//static method cos invoked with explicit parameter
       //radian value of angle returns the radian value of an angle taken in degrees
       double y1 = r1 * Math.sin(thetaRadians)+350;
       double x2 = r2 * Math.cos(thetaRadians)+400;
       double y2 = r2 * Math.sin(thetaRadians)+350;
       //trigonometry, where given a set hypotenuse lenght, one can find the lengths of both
       //the height and the width given one angle
       //x1,y2,x2,y2
       gun = new Line2D.Double(x1,y1,x2,y2);
       //g2.setColor(Color.BLACK);
       g2.setStroke(new BasicStroke(4));
       g2.draw(gun);
       //g2.translate(-400,-350);
       /*Rectangle2D.Double x = new Rectangle2D.Double(0,0,50,50);
       g2.draw(x);
       g2.setColor(Color.WHITE);
       g2.fill(x);*/
    }

    public void actionPerformed(ActionEvent e)
    {
        if (theta < 180)
        {
            change = 0;
            theta = 180;
        }
        if (theta > 360)
        {
            change = -0;
            theta = 360;
        }
        theta+=change;
        //System.out.println("x1 = " + gun.getX1() + " x2 = " + gun.getX2());
        repaint();
    }

    public Point2D.Double getFirst()
    {
        //System.out.println("" + x1 + "," + y1);
        return new Point2D.Double(gun.getX1(),gun.getY1());
    }

    public Point2D.Double getSecond()
    {
        //System.out.println("" + x2 + "," + y2);
        return new Point2D.Double(gun.getX2(),gun.getY2());
    }

    public void setLeft()
    {
        change = -3;
    }

    public void setRight()
    {
        change = 3;
    }

    public void resetChange()
    {
        change = 0;
    }
}

/**
 * Write a description of class BulletComponent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.geom.*;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.Random;
public class BulletComponent extends JComponent
{
    // instance variables - replace the example below with your own
    Line2D.Double bullet;
    double x,y,x2,y2;
    double slope;
    /**
     * Constructor for objects of class BulletComponent
     */
    public BulletComponent(int xF, int yF, int xS, int yS)
    {
        x = xF;
        y = yF;
        //x2 = (xS + xF)/2;
        //y2 = (yS + yF)/2;
        x2 = xF - (xF-xS)/2;
        y2 = yF - (yF-yS)/2;
        slope = ((double)yF-yS)/(xF-xS);
        //slope = 0.1;
        //System.out.println("" + slope);
        //System.out.println("x,y,x2,y2" + x + "" + y + "" + x2 + "" + y2);
        bullet = new Line2D.Double(x,y,x2,y2);
    }

    public void actionPerformed(ActionEvent e)
    {
        //move();
        repaint();
    }

    public void paintComponent(Graphics g)
    {
        move();
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        bullet = new Line2D.Double(x,y,x2,y2);
        g2.draw(bullet);
        //g2.draw(test);
        //g2.fill(test);
    }

    public void move()
    {
        if (slope == 0)
        {
            if (x > 400) {
                x++;
                x2++;
            }
            else {
                x--;
                x2--;
            }
        }
        else if (slope > 0)
        {
            x--;
            x2--;
        }
        else {
            x++;
            x2++;
        }
        //System.out.println("" + slope);
        y -= Math.abs(slope);
        y2 -= Math.abs(slope);
        //System.out.println("" + slope);
    }

    public int getYPos()
    {
        return (int) y;
    }

    public int getXPos()
    {
        return (int) x;
    }



}


/**
 * Write a description of class TrooperComponent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.*;
public class TrooperComponent extends JComponent
{
    BufferedImage img;
    private int x;
    private int y;
    public TrooperComponent(int x, int y)
    {
        img = null;
        try {
            img = ImageIO.read(new File("Trooper.png"));
            } catch (IOException e) {
            }
        this.x = x;
        this.y = y;
        //System.out.println("Trooper Coordinates: x = " + this.x + " y = " + this.y);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g.drawImage(img,x,y,null);
    }

    public void actionPerformed(ActionEvent e)
    {
        move();
        repaint();
    }

    public void move()
    {
        y+=2;
    }

    public int getXPos()
    {
        return x;
    }

    public int getYPos()
    {
        return y;
    }

    public int geetWidth()
    {
        return img.getWidth();
    }

    public int geetHeight()
    {
        return img.getHeight();
    }
}

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.geom.*;
public class ExplosionComponent extends JComponent
{
    int x, y;
    int w, h;
    BufferedImage explodePic;
    public ExplosionComponent(int xP, int yP)
    {
        x=xP;
        y=yP;
        w=62;
        h=31;
        explodePic = null;
        try {
            explodePic = ImageIO.read(new File("Explosion1.png"));
            } catch (IOException e) {
            }
    }

    public void paintComponent(Graphics g)
    {
        //move();
        Graphics2D g2 = (Graphics2D) g;
        g.drawImage(explodePic,x,y,w,h,null);
    }

    public void actionPerformed(ActionEvent e)
    {
        explodePic = null;
        repaint();
    }

    public void move()
    {
        w+=10;
        h+=5;
    }

    public int geetWidth()
    {
        return w;
    }
}
