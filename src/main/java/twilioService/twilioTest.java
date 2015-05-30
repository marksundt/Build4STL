package twilioService;

import static org.junit.Assert.*;

import org.junit.Test;

import com.twilio.sdk.TwilioRestException;

public class twilioTest {

	@Test
	public void test() throws TwilioRestException {
		thankYou test = new thankYou();
		String test2 = test.thankYou("fake account numer", "fake authorization token", "+13148050537", "Jim", "Randy", "http://www.example.com");
		System.out.println(test2);
	}

}
