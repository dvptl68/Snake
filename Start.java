import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown("1")){
            ((MyWorld)getWorld()).easy();
        }
        if (Greenfoot.isKeyDown("2")){
            ((MyWorld)getWorld()).medium();
        }
        if (Greenfoot.isKeyDown("3")){
            ((MyWorld)getWorld()).hard();
        }
    }    
}
