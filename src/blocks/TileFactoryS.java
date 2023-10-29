package blocks;

public class TileFactoryS {

	private Tile greenTile;
	private Tile redTile;

	public TileFactoryS() {
		greenTile = null;
		redTile = null;
	}

	public Tile newTile(Tile.Color color) {
		if (color == Tile.Color.GREEN) {
			if (greenTile == null) {
				greenTile = createTile(Tile.Color.GREEN);
			} return greenTile;

		} else if (color == Tile.Color.RED) {
			if (redTile == null) {
				redTile = createTile(Tile.Color.RED);
			} return redTile;

		}
		return null;
	}

	private Tile createTile(Tile.Color color) {
		return new Tile() {
			@Override
			public String getColor() {
				return color.name().toLowerCase();
			}
		};
	}

}
