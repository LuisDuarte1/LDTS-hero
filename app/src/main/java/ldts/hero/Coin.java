package ldts.hero;

import java.io.IOException;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{
    
    Coin(Position _pos){
        pos = _pos;
    }

    public void draw(TextGraphics graphics) throws IOException{
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "C"); 
    }
    
}
