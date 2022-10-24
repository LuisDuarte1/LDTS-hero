package ldts.hero;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class HeroTest {
    @Test
    void checkHeroDraw(){
        Hero h = new Hero(new Position(0, 0));

        TextGraphics mock_Graphics = Mockito.mock(TextGraphics.class);
        try{

            h.draw(mock_Graphics);
        } catch (IOException e){
            // this shouldn't really happen so
            e.printStackTrace();
            fail();
        }
        Mockito.verify(mock_Graphics, times(1))
            .putString(new TerminalPosition(0, 0), "X");

    }
}
