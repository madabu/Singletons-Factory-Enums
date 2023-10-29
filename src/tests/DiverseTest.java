package tests;

import static org.junit.Assert.*;

import blocks.*;
import org.junit.Test;


public class DiverseTest {

	@Test
	public void testCreation() {
		assertEquals(InitBlocks.counter, 1);
		
		InitBlocks b = new InitBlocks();
		
		assertTrue(b != null);
		assertEquals(InitBlocks.counter, 4);
	}
		
	@Test
	public void testAutoClose() {
		boolean failed = false;
		try (CloseableResource res = new CloseableResource(2)) {
			assertTrue(res != null);
			res.use();
		} catch (Exception e) {
			assertTrue(CloseableResource.isClosed());		
			failed = true;
		}
		assertTrue(failed == true);
		
		failed = false;
		try (CloseableResource res = new CloseableResource(3)) {
			assertTrue(res != null);
			res.use();
		} catch (Exception e) {
			fail("this code should not be reached");
			failed = true;
		} finally {
			assertTrue(CloseableResource.isClosed());
		}
		assertTrue(failed == false);
	}
	
	@Test
	public void testSingletons() {
		// the constructor call throws an error
		//Singleton1 s1 = new Singleton1();
		Singleton1 s11 = Singleton1.getInstance();
		Singleton1 s12 = Singleton1.getInstance();
		assertTrue(s11 == s12);
		
		Singleton2 s21 = Singleton2.getInstance();
		Singleton2 s22 = Singleton2.getInstance();
		assertTrue(s21 == s22);
		
		Singleton3 s31 = Singleton3.getInstance();
		Singleton3 s32 = Singleton3.getInstance();
		assertTrue(s31 == s32);
	}
	
	@Test
	public void testTiles() {
		// you cannot directly call these constructors
		//Tile t = new Tile();
		//Tile t = new TileFactory.TileImpl();
		
		TileFactory tf = new TileFactory();
		
		Tile tg = tf.newTile(Tile.Color.GREEN);
		assertEquals(tg.getColor(), "green");
		
		Tile tr = tf.newTile(Tile.Color.RED);
		assertEquals(tr.getColor(), "red");
		
		assert(tr.getColor() != "green"); // how can this be true ?!
		
		// TODO: create two factory classes for the Tile, one for green tiles
		// and another for the red tiles. Implement the two classes as singleton
		// classes, that inherit a common interface, this interface containing only
		// one method:		
		//
		// interface TileFactory {
		//		public Tile newTile();
		// }
		//
		// Construct also the unit test that tests the creation of the two classes,
		// that construct red and green tiles. Check that these two factory
		// classes are of singleton type but that the created tiles are different
		// among them (different objects).
		//DONE
	}
	
	// TODO: create a factory class for the Tile, for green and red tiles. The 
	// factory class will return just two objects, either green tile or red tile.
	// For example, first time you create a green tile. On a second call for creating
	// a green tile, the factory will return the first object just created earlier
	// (and not a new object).
	//DONE
	@Test
	public void testSingletonTiles() {		
		TileFactoryS tf = new TileFactoryS();
		
		Tile tg1 = tf.newTile(Tile.Color.GREEN);
		assertEquals(tg1.getColor(), "green");
		
		Tile tg2 = tf.newTile(Tile.Color.GREEN);
		assertEquals(tg2.getColor(), "green");
		
		assertTrue(tg1 == tg2);
		
		Tile tr1 = tf.newTile(Tile.Color.RED);
		assertEquals(tr1.getColor(), "red");
		
		Tile tr2 = tf.newTile(Tile.Color.RED);
		assertEquals(tr2.getColor(), "red");
		
		assertTrue(tr1 == tr2);
		
		assertTrue(tg1 != tr1);

		//DONE
	}
	
	@Test
	public void testSemaphoreEnum() {
	// TODO: uncomment these lines !
//		assertEquals(SemaphoreEnum.values().length, 3);
//		assertEquals(SemaphoreEnum.values()[0], SemaphoreEnum.RED); 
//		assertEquals(SemaphoreEnum.values()[1], SemaphoreEnum.YELLOW);
//		assertEquals(SemaphoreEnum.values()[2], SemaphoreEnum.GREEN);
//		
//		assertEquals(SemaphoreEnum.RED.getValue(), 3);
//		assertEquals(SemaphoreEnum.YELLOW.getValue(), 2);
//		assertEquals(SemaphoreEnum.GREEN.getValue(), 1);
//		
//		assertEquals(SemaphoreEnum.RED.isSafeToEnterCrossing(), false);
//		assertEquals(SemaphoreEnum.YELLOW.isSafeToEnterCrossing(), true);
//		assertEquals(SemaphoreEnum.GREEN.isSafeToEnterCrossing(), true);
	}
	
	@Test
	public void testException() {

		int s = 0;
		ExceptionThrowerClass etc = new ExceptionThrowerClass();
		try {
			etc.method(3);
		} catch (IllegalArgumentException e) {
			s += 1;
		} catch (RuntimeException e) {
			s += 2;
		} catch(Exception e) {
			s += 4;
		}
		assertTrue(s == 0);
		
		s = 0;
		try {
			etc.method(2);
		} catch (IllegalArgumentException e) {
			s += 1;
		} catch (RuntimeException e) {
			s += 2;
		} catch(Exception e) {
			s += 4;
		}
		assertTrue(s == 1);
		
		s = 0;
		try {
			etc.method(1);
		} catch (IllegalArgumentException e) {
			s += 1;
		} catch (RuntimeException e) {
			s += 2;
		} catch(Exception e) {
			s += 4;
		}
		assertTrue(s == 2);
		
		s = 0;
		try {
			etc.method(0);
		} catch (IllegalArgumentException e) {
			s += 1;
		} catch (RuntimeException e) {
			s += 2;
		} catch(Exception e) {
			s += 4;
		}
		assertTrue(s == 4);
	}
	
	// (1) Implement this factory using this tme an anonymous ineer class to
	// implement the Tile interface.
	// (2) Realise a new test testSingletonTileFactoryA() using the model of
	// testSingletonTiles() and write that factory (*)
	// (3) Extend the Tile.Color enumeration to 9 colors (White, Red, Orange,
	// Yellow, Green, Blue, Indigo, Violet and Black), and create
	// the factory such that it returns just one object instance for each
	// of the 9 colors (9 instances in total). Use a HashMap to avoid
	// writing duplicate code (**)
	@Test
	public void testTileFactoryA() {
		TileFactoryA tf = new TileFactoryA();
		
		Tile tg = tf.newTile(Tile.Color.GREEN);
		assertEquals(tg.getColor(), "green");
		
		Tile tr = tf.newTile(Tile.Color.RED);
		assertEquals(tr.getColor(), "red");
	}

	@Test
	public void testGreenTileFactorySingleton() {
		HWTileFactory greenFactory1 = GreenTileFactory.getInstance();
		HWTileFactory greenFactory2 = GreenTileFactory.getInstance();

		assertSame(greenFactory1, greenFactory2);
	}

	@Test
	public void testRedFactorySingleton() {
		HWTileFactory redFactory1 = RedTileFactory.getInstance();
		HWTileFactory redFactory2 = RedTileFactory.getInstance();

		assertSame(redFactory1, redFactory2);
	}

	@Test
	public void testDoesGreenTileExist() {
		HWTileFactory greenFactory = GreenTileFactory.getInstance();

		Tile greenTile = greenFactory.newTile();

		assertEquals("green", greenTile.getColor());
	}

	@Test
	public void testDoesRedTileExist() {
		HWTileFactory redFactory = RedTileFactory.getInstance();

		Tile redTile = redFactory.newTile();

		assertEquals("red", redTile.getColor());
	}



}
