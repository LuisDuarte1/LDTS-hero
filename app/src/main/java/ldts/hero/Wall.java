package ldts.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element{
    

    Wall (Position _pos){
        pos = _pos;
    }

    @Override
    public void setPosition(Position _pos){}

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#0000FF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.fillRectangle(new TerminalPosition(pos.getX(), pos.getY()), new TerminalSize(1,1), ' ');
    }
}
