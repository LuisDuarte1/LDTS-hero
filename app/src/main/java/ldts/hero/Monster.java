package ldts.hero;

import java.io.IOException;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element{
    

    Monster(Position _pos){
        pos = _pos;
    }

    public void draw(TextGraphics graphics) throws IOException{
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "M"); 
    }

    public Position move(Position player_pos){
        if(Math.abs(player_pos.getX()-pos.getX()) > Math.abs(player_pos.getY() - pos.getY())){
            if(player_pos.getX() > pos.getX()){
                return new Position(pos.getX()+1, pos.getY());
            } 
            return new Position(pos.getX()-1, pos.getY());
                
            
        }
        if(player_pos.getY() > pos.getY()){
            return new Position(pos.getX(), pos.getY()+1);
        } 
        return new Position(pos.getX(), pos.getY()-1);
    }
}
