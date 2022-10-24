package ldts.hero;

import java.io.IOException;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Game {

    private static int X_SIZE = 40;
    private static int Y_SIZE = 20;


    private Terminal terminal;
    private static Screen screen;
    private static TerminalSize terminalSize;

    private TextGraphics graphics;
    private Arena arena;
    

    Game() throws IOException{
        terminalSize = new TerminalSize(X_SIZE,Y_SIZE);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminal = defaultTerminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        arena = new Arena(X_SIZE, Y_SIZE);
        graphics = screen.newTextGraphics();
    }

    private void processKey(KeyStroke key) throws IOException{
        if(key == null) return; 
        if((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') || 
            (key.getKeyType() == KeyType.EOF)){
                screen.close();
                screen = null;
                return;
        }
        arena.processKey(key);
    }

    private void draw() throws IOException{
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public void run() throws IOException, InterruptedException{
        while(!arena.reachedWinCondition()){
            //TODO: get delta time
            processKey(screen.pollInput());
            if(screen == null) break;
            draw();
            Thread.sleep(16);
        }
        screen.close();
    }

    
}
