import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.Random;




public class Main2 {

    static Random random = new Random();

        public static void main(String[] args) throws Exception {
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
            Terminal terminal = terminalFactory.createTerminal();
            Screen screen = new TerminalScreen(terminal);
            TerminalSize terminalSize = screen.getTerminalSize();
            ArrayList<Food> foodList = new ArrayList<Food>();
            int x = 5;
            int y = 5;
            char player = '0';
            char fridge = 'F';

            int fridgeX = 20;
            int fridgeY = 20;
            boolean [] [] foodPosition = new boolean[79][23];

            System.out.println(foodPosition [0][1]);

            terminal.setCursorPosition(fridgeX, fridgeY);
            terminal.putCharacter(fridge);
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(player);

            foodPosition = placeFood(terminal,foodPosition);
            terminal.setCursorVisible(false);


            // Task 8, 9, 10
            boolean continueReadingInput = true;
            while (continueReadingInput) {

                KeyStroke keyStroke = null;
                do {
                    Thread.sleep(5); // might throw InterruptedException
                    keyStroke = terminal.pollInput();
                } while (keyStroke == null);


                KeyType type = keyStroke.getKeyType();
                Character c = keyStroke.getCharacter(); // used Character instead of char because it might be null

                System.out.println("keyStroke.getKeyType(): " + type
                        + " keyStroke.getCharacter(): " + c);

             /*   if (c == Character.valueOf('q')) {
                    continueReadingInput = false;
                    terminal.close();
                    System.out.println("quit");
                }

              */

                int oldX = x;
                int oldY = y;
                switch (keyStroke.getKeyType()) {
                    case ArrowDown:
                        y += 1;
                        break;
                    case ArrowUp:
                        y -= 1;
                        break;
                    case ArrowRight:
                        x += 1;
                        break;
                    case ArrowLeft:
                        x -= 1;
                        break;
                }

                System.out.println(x+" " + y);

                if (x<0) {
                    x=0;
                }
                else if (x>terminalSize.getColumns()) {
                    x=terminalSize.getColumns();
                }
                if (y<0) {
                    y=0;
                }
                else if (y>terminalSize.getRows()) {
                    y=terminalSize.getRows();
                }

                if(x == fridgeX && y == fridgeY) {
                    player = '0';

                }

                if (foodPosition[x][y]==true) {
                    int originalNumber =Character.getNumericValue(player);
                    createPretzel(terminal, foodPosition);

                   switch (player) {

                       case '0': player = '1';

                       break;

                       case '1': player = '2';

                           break;

                       case '2': player = '3';

                           break;

                       case '3': player = '4';

                           break;

                       case '4': player = '5';

                           break;

                       case '5': player = '6';

                           break;

                       case '6': player = '7';

                           break;

                       case '7': player = '8';

                           break;

                       case '8': player = '9';

                           break;

                       default:
                           System.out.println("LEVEL 2");

                   }


                }



                terminal.setCursorPosition(oldX, oldY);
                terminal.putCharacter(' ');
                terminal.setCursorPosition(x, y);
                terminal.putCharacter(player);

                terminal.flush();


            }


        }


        static boolean [] [] placeFood (Terminal terminal, boolean[][] foodPosition) throws Exception{

            createPizza(terminal, foodPosition);
            createBagel(terminal, foodPosition);
            createBuns(terminal, foodPosition);
            createDonuts(terminal, foodPosition);
            createPretzel(terminal, foodPosition);
/*            Food pizza = new Food (random.nextInt(79),random.nextInt(24),'P');
            terminal.setCursorPosition(pizza.getX(),pizza.getY());
            foodPosition[pizza.getX()][pizza.getY()] = true;
            terminal.putCharacter(pizza.getC());
            Food donuts = new Food (random.nextInt(79),random.nextInt(24),'D');
            terminal.setCursorPosition(donuts.getX(),donuts.getY());
            foodPosition[donuts.getX()][donuts.getY()] = true;
            terminal.putCharacter(donuts.getC());
            Food bagel = new Food (random.nextInt(79),random.nextInt(24),'B');
            terminal.setCursorPosition(bagel.getX(),bagel.getY());
            foodPosition[bagel.getX()][bagel.getY()] = true;
            terminal.putCharacter(bagel.getC());
            Food buns = new Food (random.nextInt(79),random.nextInt(24),'@');
            terminal.setCursorPosition(buns.getX(),buns.getY());
            foodPosition[buns.getX()][buns.getY()] = true;
            terminal.putCharacter(buns.getC());
            Food pretzel = new Food (random.nextInt(79),random.nextInt(24),'$');
            terminal.setCursorPosition(pretzel.getX(),pretzel.getY());
            foodPosition[pretzel.getX()][pretzel.getY()] = true;
            terminal.putCharacter(pretzel.getC());*/

            terminal.flush();

            return foodPosition;
        }

static boolean[][] createPizza(Terminal terminal, boolean[][] foodPosition)  throws Exception{
    Food pizza = new Food (random.nextInt(78),random.nextInt(23),'P');
    terminal.setCursorPosition(pizza.getX(),pizza.getY());
    foodPosition[pizza.getX()][pizza.getY()] = true;
    terminal.putCharacter(pizza.getC());

 return foodPosition;
}

static boolean[][] createDonuts(Terminal terminal, boolean[][] foodPosition)  throws Exception{
    Food donuts = new Food (random.nextInt(78),random.nextInt(23),'D');
    terminal.setCursorPosition(donuts.getX(),donuts.getY());
    foodPosition[donuts.getX()][donuts.getY()] = true;
    terminal.putCharacter(donuts.getC());


    return foodPosition;

}static boolean[][] createBagel(Terminal terminal, boolean[][] foodPosition)  throws Exception{
        Food bagel = new Food (random.nextInt(79),random.nextInt(24),'B');
        terminal.setCursorPosition(bagel.getX(),bagel.getY());
        foodPosition[bagel.getX()][bagel.getY()] = true;
        terminal.putCharacter(bagel.getC());


        return foodPosition;

}static boolean[][] createBuns(Terminal terminal, boolean[][] foodPosition) throws Exception {
        Food buns = new Food (random.nextInt(79),random.nextInt(24),'@');
        terminal.setCursorPosition(buns.getX(),buns.getY());
        foodPosition[buns.getX()][buns.getY()] = true;
        terminal.putCharacter(buns.getC());


        return foodPosition;

}static boolean[][] createPretzel(Terminal terminal, boolean[][] foodPosition)  throws Exception {
        Food pretzel = new Food (random.nextInt(79),random.nextInt(24),'$');
        terminal.setCursorPosition(pretzel.getX(),pretzel.getY());
        foodPosition[pretzel.getX()][pretzel.getY()] = true;
        terminal.putCharacter(pretzel.getC());


        return foodPosition;
}


    }

