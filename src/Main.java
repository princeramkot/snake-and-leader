import modules.Bridge;
import modules.Player;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        System.out.println("enter number of snakes");
        int snakes;
        int ledger;
        int totalPlayer;
        int boardSize = 100;
        snakes = enter.nextInt();
        Queue<Player> queue = new LinkedList<Player>();
        HashMap<Integer, Integer> bridges = new HashMap<Integer, Integer>();

        System.out.println("enter start and end points of snakes");
        for(int i = 0 ; i < snakes;i++){
            int startPoint = enter.nextInt();
            int endPoint = enter.nextInt();
            bridges.put(startPoint, endPoint);
        }

        System.out.println("enter number of leader");
        ledger = enter.nextInt();
        System.out.println("enter start and end points of leader");
        for(int i = 0 ; i < ledger;i++){
            int startPoint = enter.nextInt();
            int endPoint = enter.nextInt();
            bridges.put(startPoint, endPoint);
        }

        System.out.println("enter total player");
        totalPlayer =  enter.nextInt();
        enter.nextLine();
        System.out.println("enter name of each player");
        for(int i = 0 ; i < totalPlayer;i++){
            String name = enter.nextLine().trim();
            Player p = new Player(name, 0);
            queue.add(p);
        }
        Game game = new Game(bridges, queue, 100);
        String winnerName = game.startGame();
        System.out.println(winnerName);

    }
}