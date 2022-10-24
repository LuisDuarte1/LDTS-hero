package ldts.hero;

import java.io.IOException;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    
    protected Position pos;

    public abstract void draw(TextGraphics graphics) throws IOException;

    public Position getPosition(){return pos;}

    public void setPosition(Position _pos){
        pos =_pos;
    }
}
