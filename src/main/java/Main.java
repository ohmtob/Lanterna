import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Main {
    public static void main(String[] args) throws Exception {

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();

        //Uppgift 4

        terminal.setCursorPosition(9, 9);
        terminal.putCharacter('X');

        terminal.setCursorPosition (terminal.getCursorPosition().withRelativeColumn(5).withRelativeRow(5));

        terminal.putCharacter('Y');

        //Uppgift 5 horisontel

        for (int column = 4; column < 10; column++) {
            terminal.setCursorPosition(column, 4)  ;  terminal.putCharacter('Y');
        }

        //Uppgift 5 vertikal

        for (int row = 4; row < 10; row++) {
            terminal.setCursorPosition(4,row )  ;  terminal.putCharacter('Y');
        }

        terminal.flush();

        //Uppgift 6

        String s1 = "This is a String printed out in Lanterna by iterating over the characters";

        for (int i=0; i<s1.length(); i++ ) {
            terminal.setCursorPosition(i+2, 9);
            char c = s1.charAt(i);
            terminal.putCharacter(c);

            // varför skrivs det inte över när vi har terminal.set.CursorPosition är sist i for loopet

        }

        terminal.flush();

        //Uppgift 7

        KeyStroke keyStroke = null;
        do {
            Thread.sleep(5); // might throw InterruptedException
            keyStroke = terminal.pollInput();
        } while (keyStroke == null);

        KeyType type = keyStroke.getKeyType();
        Character d = keyStroke.getCharacter(); // used Character, not char because it might be null

        terminal.setCursorPosition(17, 15);
        terminal.putCharacter(d);

        //System.out.println("keyStroke.getKeyType(): " + type
        //        + " keyStroke.getCharacter(): " + d);

        terminal.flush();

    }
}
