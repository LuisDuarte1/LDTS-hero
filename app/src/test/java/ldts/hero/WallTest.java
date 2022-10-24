package ldts.hero;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;


public class WallTest {
    @Test
    void wallRendersCorrectly(){

        Wall w = new Wall(new Position(2, 2));

        TextGraphics g = Mockito.mock(TextGraphics.class);
        
        w.draw(g);


        verify(g, times(1))
            .fillRectangle(new TerminalPosition(2, 2), new TerminalSize(1,1), ' ');
    }

    @Test
    void wallDoesntChangePositionTest(){
        Wall w = new Wall(new Position(2, 3));
        w.setPosition(new Position(0, 0));

        Assertions.assertEquals(new Position(2, 3),w.getPosition());
    }
}
