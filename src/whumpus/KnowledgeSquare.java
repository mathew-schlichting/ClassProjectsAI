package whumpus;

public class KnowledgeSquare extends Square{

    private boolean traveled;
    private int maybePit, maybeWhumpus;


    /*
        -1   = unknown
         0   = definitely not a pit
         1   = maybe a pit
         2   = definitely a pit
     */

    public KnowledgeSquare(boolean breeze, boolean stench, boolean whumpus, boolean pit, boolean gold, boolean traveled, int maybePit, int maybeWhumpus) {
        super(breeze, stench, whumpus, pit, gold);
        this.traveled = traveled;
        this.maybePit = maybePit;
        this.maybeWhumpus = maybeWhumpus;
    }

    public boolean isTraveled() {
        return traveled;
    }

    public void travel(Square square){
        setTraveled(true);
        if(square.isPit()){
            maybePit = 2;
        }
        else{
            maybePit = 0;
        }
        if(square.isWhumpus()){
            maybeWhumpus = 2;
        }
        else{
            maybeWhumpus = 0;
        }

        setBreeze(square.isBreeze());
        setStench(square.isStench());
        setWhumpus(square.isWhumpus());
        setPit(square.isPit());
        setGold(square.isGold());
    }

    public void setTraveled(boolean traveled) {
        this.traveled = traveled;
    }

    public int getMaybePit() {
        return maybePit;
    }

    public void setMaybePit(int maybePit) {
        this.maybePit = maybePit;
    }

    public int getMaybeWhumpus() {
        return maybeWhumpus;
    }

    public void setMaybeWhumpus(int maybeWhumpus) {
        this.maybeWhumpus = maybeWhumpus;
    }

    public boolean isSafe(){
        return getMaybePit() == 0 && !isPit() && getMaybePit() == 0 && !isWhumpus();
    }
}
