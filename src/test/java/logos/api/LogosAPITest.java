package logos.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class LogosAPITest {
	

	@Test
	public void testPickOneQuote() {
		LogosAPI logos = new LogosAPI();
		
		Quote quote = logos.pickOneQuote();
				
		assertEquals("hello", quote.getText());
	}
	
}
