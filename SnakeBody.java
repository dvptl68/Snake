import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeBody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeBody extends Actor
{
    private int move = 1;
    private int direction = 4;
    private int speed = 0;
    private boolean turned = false;
    public SnakeBody(){
        GreenfootImage myImage = getImage();
        myImage.scale(20, 20);
    }
    /**
     * Act - do whatever the SnakeBody wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor food = (Actor)getWorld().getObjects(Food.class).get(0);
        if ((getX() == food.getX()) && (getY() == food.getY())){
            ((MyWorld)getWorld()).eat();
        }
        if (Greenfoot.isKeyDown("up") && (direction != 2) && (turned == false)){
            direction = 1;
            turned = true;
        }
        if (Greenfoot.isKeyDown("down") && (direction != 1) && (turned == false)){
            direction = 2;
            turned = true;
        }
        if (Greenfoot.isKeyDown("left") && (direction != 4) && (turned == false)){
            direction = 3;
            turned = true;
        }
        if (Greenfoot.isKeyDown("right") && (direction != 3) && (turned == false)){
            direction = 4;
            turned = true;
        }
        if (move%speed == 0){
            ((MyWorld)getWorld()).move(direction, getX(), getY());
            move = 0;
            turned = false;
        }
        move++;
    }
    public void easy(){
        speed = 15;
    }
    public void medium(){
        speed = 5;
    }
    public void hard(){
        speed = 3;
    }
}