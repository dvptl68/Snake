import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Height of the world: 400
 * Width of the world: 600
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int[] xValues = new int[30];
    private int[] yValues = new int[20];
    private int score = 0;
    private int direction = 4;
    private int x = 0;
    private int y = 0;
    private List<Integer> xPositions = new ArrayList<Integer>();
    private List<Integer> yPositions = new ArrayList<Integer>();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Start start = new Start();
        addObject(start,getWidth()/2,getHeight()/2);
        int location = 10;
        for (int i = 0; i < 30; i++){
            if (i < 20){
                yValues[i] = location;
            }
            xValues[i] = location;
            location+=20;
        }
    }
    public void easy(){
        List objects = getObjects(null);
        removeObjects(objects);
        SnakeBody snake = new SnakeBody();
        addObject(snake, xValues[14], yValues[9]);
        ((SnakeBody)getObjects(SnakeBody.class).get(0)).easy();
        food();
        showText(score+"", 20, 20);
    }
    public void medium(){
        List objects = getObjects(null);
        removeObjects(objects);
        SnakeBody snake = new SnakeBody();
        addObject(snake, xValues[14], yValues[9]);
        ((SnakeBody)getObjects(SnakeBody.class).get(0)).medium();
        food();
        showText(score+"", 20, 20);
    }
    public void hard(){
        List objects = getObjects(null);
        removeObjects(objects);
        SnakeBody snake = new SnakeBody();
        addObject(snake, xValues[14], yValues[9]);
        ((SnakeBody)getObjects(SnakeBody.class).get(0)).hard();
        food();
        showText(score+"", 20, 20);
    }
    public void food(){
        int xRandom = Greenfoot.getRandomNumber(30);
        int yRandom = Greenfoot.getRandomNumber(20);
        Food food = new Food();
        addObject(food, xValues[xRandom], yValues[yRandom]);
    }
    public void move(int dir, int xPos, int yPos){
        Actor snake = (Actor)getObjects(SnakeBody.class).get(0);
        x = (xPos-10)/20;
        y = (yPos-10)/20;
        xPositions.add(xPos);
        yPositions.add(yPos);
        List extra = getObjects(SnakeExtra.class);
        for (int i = 0; i < extra.size(); i++){
            if (extra.size() != 0){
                if ((xPos == ((SnakeExtra)getObjects(SnakeExtra.class).get(i)).getX())){
                    if (yPos == ((SnakeExtra)getObjects(SnakeExtra.class).get(i)).getY()){
                        dir = 0;
                        lose();
                        break;
                    }
                }
            }
        }
        if (dir == 1){
            if(y == 0){
               lose();
            }else{
                snake.setLocation(xValues[x], yValues[y-1]);
                if (extra.size() != 0){
                    for (int i = 0; i < extra.size(); i++){
                        ((SnakeExtra)getObjects(SnakeExtra.class).get(i)).follow();
                    }
                }
            }
        }else if(dir == 2){
            if(y == 19){
               lose();
            }else{
                snake.setLocation(xValues[x], yValues[y+1]);
                if (extra.size() != 0){
                    for (int i = 0; i < extra.size(); i++){
                        ((SnakeExtra)getObjects(SnakeExtra.class).get(i)).follow();
                    }
                }
            }
        }else if(dir == 3){
            if(x == 0){
               lose();
            }else{
                snake.setLocation(xValues[x-1], yValues[y]);
                if (extra.size() != 0){
                    for (int i = 0; i < extra.size(); i++){
                        ((SnakeExtra)getObjects(SnakeExtra.class).get(i)).follow();
                    }
                }
            }
        }else if(dir == 4){
            if(x == 29){
               lose();
            }else{
                snake.setLocation(xValues[x+1], yValues[y]);
                if (extra.size() != 0){
                    for (int i = 0; i < extra.size(); i++){
                        ((SnakeExtra)getObjects(SnakeExtra.class).get(i)).follow();
                    }
                }
            }
        }
        direction = dir;
    }
    public void eat(){
        score++;
        Actor food = (Actor)getObjects(Food.class).get(0);
        removeObject(food);
        food();
        SnakeExtra snake = new SnakeExtra();
        List extra = getObjects(SnakeExtra.class);
        if (score == 1){
            addObject(snake, xPositions.get(xPositions.size()-1), yPositions.get(yPositions.size()-1));
        }else{
            int place = ((SnakeExtra)getObjects(SnakeExtra.class).get(extra.size()-1)).place();
            addObject(snake, xPositions.get(xPositions.size()-place-2), yPositions.get(yPositions.size()-place-2));
        }
        showText(score+"", 20, 20);
    }
    public List<Integer> xPositions(){
        return xPositions;
    }
    public List<Integer> yPositions(){
        return yPositions;
    }
    public void lose(){
        List objects = getObjects(null);
        removeObjects(objects);
        showText("", 20, 20);
        showText("Score: " + score, getWidth()/2, getHeight()/2);
        Greenfoot.delay(250);
        Greenfoot.setWorld(new MyWorld());
    }
}