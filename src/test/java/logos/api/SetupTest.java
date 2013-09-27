package logos.api;

import static logos.api.Setup.CONSUMER_KEY;
import static logos.api.Setup.CONSUMER_SECRET;
import static logos.api.Setup.TOKEN;
import static logos.api.Setup.TOKEN_SECRET;
import static logos.api.Setup.logosProperty;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SetupTest {

	@Test
	public void testInvalidProperty() {
		assertNull(logosProperty("x"));
	}

	@Test
	public void testTwitterProperties() {
		assertNotNull(logosProperty(CONSUMER_KEY));
		assertNotNull(logosProperty(CONSUMER_SECRET));
		assertNotNull(logosProperty(TOKEN));
		assertNotNull(logosProperty(TOKEN_SECRET));
	}
}
