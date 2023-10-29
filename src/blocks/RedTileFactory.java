package blocks;

public class RedTileFactory implements HWTileFactory{
    private static RedTileFactory instance;

    private RedTileFactory(){

    }

    public static RedTileFactory getInstance() {
        if (instance == null) {
            instance = new RedTileFactory();
        }
        return instance;
    }

    @Override
    public Tile newTile(){
        return new Tile() {
            @Override
            public String getColor() {
                return "red";
            }
        };
    }

}
