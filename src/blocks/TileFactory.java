package blocks;

public class TileFactory {
	class TileImpl implements Tile {
		private String _color;
		
		private TileImpl(String color) {
			_color = color;
		}

		@Override
		public String getColor() {
			return _color;
		}		
	}

	public Tile newTile(Tile.Color color) {
		if (color == Tile.Color.GREEN)
			return new TileImpl("green");
		else if (color == Tile.Color.RED)
			return new TileImpl("red");
		
		System.err.println("invalid color given as parameter");
		return null;
	}

}
