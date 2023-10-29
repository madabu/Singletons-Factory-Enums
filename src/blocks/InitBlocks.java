package blocks;

public class InitBlocks {
    public static int counter;
    
    // static initialization block
    static {
    	counter = 1;
    }

    // initialization block
    {
        counter += 1;
    }

    public InitBlocks() {
        counter *= 2;
    }
    
}
