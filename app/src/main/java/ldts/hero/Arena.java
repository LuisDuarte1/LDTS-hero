package ldts.hero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;


public class Arena {

    private int width;
    private int height;
    private Hero hero = null;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;



    Arena(int _width, int _height){
        width = _width;
        height = _height;
        hero = new Hero(new Position(5, 5));
        createWalls();
        createCoins();
        createMonsters();
    }
    
    public boolean reachedWinCondition(){
        if (coins.size() == 0){
            return true;
        }
        return false;
    }

    private void createMonsters(){
        Random random = new Random();
        monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        monsters.add(new Monster(new Position(random.nextInt(width - 2) + 1,
        random.nextInt(height - 2) + 1)));       
    }

    private void createCoins() {
        Random random = new Random();
        coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        coins.add(new Coin(new Position(random.nextInt(width - 2) + 1,
        random.nextInt(height - 2) + 1)));
        }
    
    private void createWalls(){
        walls = new ArrayList<Wall>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(new Position(c, 0)));
            walls.add(new Wall(new Position(c, height - 1)));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(new Position(0, r)));
            walls.add(new Wall(new Position(width - 1, r)));
        }
    }

    private boolean canMoveHero(Position new_pos){
        for (Wall wall : walls) {
            if(wall.getPosition().equals(new_pos)) return false;
        }
        return true;
    }


    private void moveHero(Position new_pos){
        if(canMoveHero(new_pos)) {
            hero.setPosition(new_pos);
            for (Coin coin : coins) {
                if(coin.getPosition().equals(new_pos)){
                    coins.remove(coin);
                    break;
                }
            }   
        }
    }

    private void checkMonsterCollisions(){
        for (Monster monster : monsters) {
            if(monster.getPosition().equals(hero.getPosition())){
                System.out.println("An monster hit you :( you lost.");
                coins = new ArrayList<Coin>();
            }
        }
    }
    
    private void moveMonsters(){
        for (Monster monster : monsters) {
            monster.setPosition(monster.move(hero.getPosition()));
            checkMonsterCollisions();
        }
    }

    public void processKey(KeyStroke key){
        if(key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.getPosition().moveUp());
            moveMonsters();
        }
        if(key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.getPosition().moveDown());
            moveMonsters();
        }
        if(key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.getPosition().moveLeft());
            moveMonsters();
        }
        if(key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.getPosition().moveRight());
            moveMonsters();
        }
    }

    public void draw(TextGraphics graphics) throws IOException{
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        for (Wall wall : walls) {
            wall.draw(graphics);
        }
        for (Coin coin : coins) {
            coin.draw(graphics);
        }
        for (Monster monster : monsters) {
            monster.draw(graphics);
        }
        hero.draw(graphics);
    }
    
}
