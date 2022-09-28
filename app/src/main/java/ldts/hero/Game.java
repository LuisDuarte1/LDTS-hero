package ldts.hero;

import java.io.IOException;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Game {

    private Terminal terminal = null;
    private static Screen screen = null;
    private static TerminalSize terminalSize = new TerminalSize(20,20);
    
    private int row = 1;

    Game() throws IOException{
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminal = defaultTerminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
    }

    private void draw() throws IOException{
        screen.setCharacter(1,row, TextCharacter.DEFAULT_CHARACTER);
        row += 1;
        row = row % (terminalSize.getRows() + 1); 
        screen.setCharacter(1,row, TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }

    public void run() throws IOException, InterruptedException{
        while(true){
            //TODO: get delta time
            draw();
            Thread.sleep(16);
        }
    }

    
}
