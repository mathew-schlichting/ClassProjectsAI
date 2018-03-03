package whumpus;

public class Square {

    private boolean     breeze,
                        stench,
                        whumpus,
                        pit,
                        gold;

    public Square(boolean breeze, boolean stench, boolean whumpus, boolean pit, boolean gold) {
        this.breeze = breeze;
        this.stench = stench;
        this.whumpus = whumpus;
        this.pit = pit;
        this.gold = gold;
    }

    public boolean isBreeze() {
        return breeze;
    }

    public boolean isStench() {
        return stench;
    }

    public boolean isWhumpus() {
        return whumpus;
    }

    public boolean isPit() {
        return pit;
    }

    public boolean isGold() {
        return gold;
    }

    public Square copy(){
        return new Square(isBreeze(), isStench(), isWhumpus() ,isPit(), isGold());
    }

    public void setBreeze(boolean breeze) {
        this.breeze = breeze;
    }

    public void setStench(boolean stench) {
        this.stench = stench;
    }

    public void setWhumpus(boolean whumpus) {
        this.whumpus = whumpus;
    }

    public void setPit(boolean pit) {
        this.pit = pit;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }
}
