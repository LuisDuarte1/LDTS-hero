package ldts.hero;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;

import java.io.IOException;

import org.checkerframework.checker.units.qual.h;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class CoinTest {
    @Test
    void coinRendersCorrectly(){

        Coin c = new Coin(new Position(2, 2));
        
        TextGraphics h = Mockito.mock(TextGraphics.class);

        try{
            c.draw(h);
        } catch(IOException n){
            // This shouldn't happen
            n.printStackTrace();
            fail();
        }

        Mockito.verify(h, times(1))
            .putString(new TerminalPosition(2, 2), "C");

    }
}
