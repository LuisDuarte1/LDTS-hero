package ldts.hero;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class MonsterTest {
    
    @Test
    void monsterDrawCorrectlyTest(){
        
        Monster m = new Monster(new Position(1, 1));

        TextGraphics graphics = Mockito.mock(TextGraphics.class);

        try{
            m.draw(graphics);
        }catch(IOException e){
            e.printStackTrace();
            fail();
        }
        //graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "M"); 
        verify(graphics, times(1))
            .putString(new TerminalPosition(1, 1), "M");
    }

    @Test
    void monsterMoveTowardsPlayerX(){
        Monster m = new Monster(new Position(3,1));
        
    
        Assertions.assertEquals(new Position(2, 1),m.move(new Position(1, 1)));   
        Assertions.assertEquals(new Position(4, 1),m.move(new Position(5, 2)));
        Assertions.assertEquals(new Position(4, 1),m.move(new Position(5, 1)));   


    }

    @Test
    void monsterMoveTowardsPlayerY(){
        Monster m = new Monster(new Position(0,3));
        
        Assertions.assertEquals(new Position(0, 4),m.move(new Position(0, 6)));   
        Assertions.assertEquals(new Position(0, 4),m.move(new Position(1, 6)));
        Assertions.assertEquals(new Position(0, 2),m.move(new Position(0, 1)));   
    }
}
