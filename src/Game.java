import modules.Dice;
import modules.Player;

import java.util.HashMap;
import java.util.Queue;

public class Game {
    HashMap<Integer, Integer> bridges;
    Queue<Player> q;
    int bordSize;
    Dice dice;

    public Game(HashMap<Integer, Integer> bridges, Queue<Player> q, int bordSize) {
        this.bridges = bridges;
        this.q = q;
        this.bordSize = bordSize;
        dice = new Dice(1,6);
    }

    public String startGame(){
        while(true){
           Player currentPlayer =  q.poll();
           int randomNumber = dice.rollDice();
            int nextPosition = currentPlayer.getCurrentPosition()+randomNumber;

            if(nextPosition == bordSize){
                return currentPlayer.getName();
            }
            else if(nextPosition> bordSize) continue;
            else if(bridges.containsKey(nextPosition)){
                int startPoint = nextPosition;
                int endPoint = bridges.get(nextPosition);

                if(startPoint>=endPoint){ //snake
                    handleSnakeBite(currentPlayer, nextPosition);
                    q.add(currentPlayer);
                }
                else { //leader
                    handleLeadgerClime(currentPlayer, nextPosition);
                    q.add(currentPlayer);
                }
            }
            else{
                currentPlayer.setCurrentPosition(nextPosition);
                q.add(currentPlayer);
            }

        }
    }

    public void handleSnakeBite(Player currentPlayer, int currentPosition){
        int startPoint = currentPosition;
        int endPoint = bridges.get(currentPosition);

        while(!bridges.containsKey(currentPosition)){
            currentPlayer.setCurrentPosition(currentPosition + endPoint);
            if(bridges.containsKey(currentPosition+endPoint)){
                currentPosition = currentPosition+endPoint;
            }
        }
    }

    public void handleLeadgerClime(Player currentPlayer, int currentPosition){
        int startPoint = currentPosition;
        int endPoint = bridges.get(currentPosition);

        while(!bridges.containsKey(currentPosition)){
            currentPlayer.setCurrentPosition(currentPosition + endPoint);
            if(bridges.containsKey(currentPosition+endPoint)){
                currentPosition = currentPosition+endPoint;
            }
        }
    }
}
