package whumpus;

public class WhumpusWorld {


    private int x;
    private int y;
    private KnowledgeSquare[][] knowledge;
    private Square[][] map;
    private static WhumpusWorld instance;


    public static void main(String[] args){
        Square[][] testMap = new Square[3][3];
        testMap[0][0] = new Square(true, false, true, false, false);
        testMap[1][0] = new Square(true, true, false, false, true);
        testMap[2][0] = new Square(false, false, false, true, false);
        testMap[0][1] = new Square(false, true, false, false, false);
        testMap[1][1] = new Square(false, false, false, false, false);
        testMap[2][1] = new Square(true, false, false, false, false);
        testMap[0][2] = new Square(false, false, false, false, false);
        testMap[1][2] = new Square(true, false, false, false, false);
        testMap[2][2] = new Square(false, false, false, true, false);

        instance = new WhumpusWorld(testMap);


        for(int i=0;i<2;i++){

        }
    }




    public WhumpusWorld(Square[][] map){
        if(map.length == 0 | map[0].length == 0){
            throw new IllegalArgumentException("Map must have a valid size!");
        }
        knowledge = new KnowledgeSquare[map.length][map[0].length];
        for(int i=0;i<knowledge.length;i++){
            for(int j=0;j<knowledge[i].length;j++){
                //we don't know anything
                knowledge[i][j] = new KnowledgeSquare(false, false, false, false, false, false, -1, -1);
            }
        }
        setMap(map);
    }

    // passing null will generate a new map
    public void setMap(Square[][] map){
        if(map != null) {
            this.map = map;
        }
        else{
            //generate map
            //todo
        }
    }




    private void moveLeft(){
        x--;
    }
    private void moveUp(){
        y--;
    }
    private void moveDown(){
        y++;
    }
    private void moveRight(){
        x++;
    }
    private boolean canMoveRight(){
        return x+1 < map.length;
    }
    private boolean canMoveLeft(){
        return x > 0;
    }
    private boolean canMoveUp(){
        return y > 0;
    }
    private boolean canMoveDown(){
        return y + 1 < map[x].length;
    }

    public void updateKnowledge(){
        knowledge[x][y].travel(map[x][y]);

        //update maybe whumpus and maybe pit
        for(int x=0;x<knowledge.length;x++){
            for(int y=0;y<knowledge[x].length;y++){
                //up
                if(y > 0){
                    if(knowledge[x][y].isBreeze() && knowledge[x][y-1].getMaybePit() != 0){
                        knowledge[x][y].setMaybePit(1);
                    }
                    if(knowledge[x][y].isStench() && knowledge[x][y-1].getMaybeWhumpus() != 0){
                        knowledge[x][y].setMaybeWhumpus(1);
                    }

                }
                //down
                if(y < knowledge[x].length-1){
                    if(knowledge[x][y].isBreeze() && knowledge[x][y+1].getMaybePit() != 0){
                        knowledge[x][y].setMaybePit(1);
                    }
                    if(knowledge[x][y].isStench() && knowledge[x][y+1].getMaybeWhumpus() != 0){
                        knowledge[x][y].setMaybeWhumpus(1);
                    }
                }
                //left
                if(x > 0){
                    if(knowledge[x][y].isBreeze() && knowledge[x-1][y].getMaybePit() != 0){
                        knowledge[x][y].setMaybePit(1);
                    }
                    if(knowledge[x][y].isStench() && knowledge[x-1][y].getMaybeWhumpus() != 0){
                        knowledge[x][y].setMaybeWhumpus(1);
                    }
                }
                //right
                if(x < knowledge.length - 1){
                    if(knowledge[x][y].isBreeze() && knowledge[x+1][y].getMaybePit() != 0){
                        knowledge[x][y].setMaybePit(1);
                    }
                    if(knowledge[x][y].isStench() && knowledge[x+1][y].getMaybeWhumpus() != 0){
                        knowledge[x][y].setMaybeWhumpus(1);
                    }
                }
            }
        }


        for(int x=0;x<knowledge.length;x++) {
            for (int y = 0; y < knowledge[x].length; y++) {

            }
        }
    }

    public void makeMove(){
        //if need more knowledge
        if (canMoveRight() && knowledge[x+1][y].isSafe() && !knowledge[x+1][y].isTraveled()) {
            System.out.println("Safe right and not traveled, moving right");
            moveRight();
            updateKnowledge();
        }




        updateKnowledge();
    }
}
