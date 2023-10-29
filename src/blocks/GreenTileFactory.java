package blocks;

public class GreenTileFactory implements HWTileFactory {
    private static GreenTileFactory instance;

    private GreenTileFactory () {

    }

    public static GreenTileFactory getInstance() {
        if (instance == null) {
            instance = new GreenTileFactory();
        }
        return instance;
    }

    @Override
    public Tile newTile() {
        return new Tile() {
            @Override
            public String getColor() {
                return "green";
            }
        };
    }

}
