package blocks;

public enum GreenAndRedTiles {
    INSTANCE;

    private Tile greenTile;
    private Tile redTile;

    private GreenAndRedTiles() {
        greenTile = new Tile() {
            @Override
            public String getColor() {
                return "green";
            }
        };
        redTile = new Tile() {
            @Override
            public String getColor() {
                return "red";
            }
        };
    }

    //used enum to implement Singleton pattern in order to guarantee
    //a single instance and provide thread safety.

    //tiles created in the enum's constructor which is defined
    //implicitly, an automatically generated private constructor
    //created by the Java compiler.

    public Tile getGreenTile() {
        return greenTile;
    }

    public Tile getRedTile () {
        return redTile;
    }

    //methods return the pre-initialized tiles.



}
