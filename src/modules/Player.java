package modules;

public class Player {
    String name;
    int currentPosition = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Player(String name, int position) {
        this.name = name;
        this.currentPosition = position;
    }
}
