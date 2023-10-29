package blocks;

public class CloseableResource implements AutoCloseable {
	private static boolean _closed = false; 
	int _n;
	
	public CloseableResource(int n) {
		// ...
	}
	
	public void use () {
		// ...
	}

	@Override
	public void close() throws Exception {
		_closed = true;
	}
	
	public static boolean isClosed() {
		return _closed;
	}

}
