import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Write a description of class SnakeExtra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeExtra extends Actor
{
    private int place = 0;
    private List<Integer> xPositions;
    private List<Integer> yPositions;
    public SnakeExtra(){
        GreenfootImage myImage = getImage();
        myImage.scale(20, 20);
    }
    /**
     * Act - do whatever the SnakeExtra wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    public void follow(){
        xPositions = ((MyWorld)getWorld()).xPositions();
        yPositions = ((MyWorld)getWorld()).yPositions();
        List extra = getWorld().getObjects(SnakeExtra.class);
        for (int i = 0; i < extra.size(); i++){
            if (extra.get(i) == this){
                place = i;
                break;
            }
        }
        setLocation(xPositions.get(xPositions.size()-place-1), yPositions.get(yPositions.size()-place-1));
    }
    public int place(){
        return place;
    }
}