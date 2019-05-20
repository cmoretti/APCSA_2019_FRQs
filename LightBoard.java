public class LightBoard {

    private boolean[][] lights;

    // part a
    // 22:44 - 22:46
    public LightBoard(int numRows, int numCols) {
        lights = new boolean[numRows][numCols];
        for(int i = 0; i < numRows; i++)
            for(int j = 0; j < numCols; j++)
                lights[i][j] = (Math.random() < 0.4);
    }

    // part b
    // 22:47 - 22:51
    public boolean evaluateLight(int row, int col) {
        int numLightsOnInCol = 0;
        for(int r = 0; r < lights.length; r++)
            if(lights[r][col]) numLightsOnInCol++;
        
        if(lights[row][col] && (numLightsOnInCol % 2 == 0))
            return false;
        else if(!lights[row][col] && (numLightsOnInCol % 3 == 0))
            return true;
        // else
        return lights[row][col];
    }

    public LightBoard() {
        boolean[][] board = { {true, true, false, true, true},
                              {true, false, false, true, false},
                              {true, false, false, true, true},
                              {true, false, false, false, true},
                              {true, false, false, false, true},
                              {true, true, false, true, true},
                              {false, false, false, false, false} };
        lights = board;
    }

    public static void main(String[] args) {
        LightBoard sim = new LightBoard();

        System.out.println(sim.evaluateLight(0,3) + " should be false");
        System.out.println(sim.evaluateLight(6,0) + " should be true");
        System.out.println(sim.evaluateLight(4,1) + " should be false");
        System.out.println(sim.evaluateLight(5,4) + " should be true");
        
    }
}

/* plausible rubric

part a - 4 points:
* instantiate new array with correct bounds
* access all elements of array
* generate random number corresponding to 40% chance
* on-exit, all items in array should have been assigned (ok to leave false if that is chosen)

 part b - 5 points:
 * accesses all elements of column col
 * conditions on value of lights[row][col] (if statement or return logic)
 * correctly assesses even-ness
 * correctly assesses divisible by 3
 * returns computed boolean based on 3 cases (even if points above were lost for the mechanics of those cases)

 */
