package dao;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;

public class TestForDao {

	@Test
	public void test() {
		DaoStuff test = new DaoStuff();
		
//		try {
//			test.executePost("https://api.orchestrate.io/v0/users/testUserAgain", "fName=" + URLEncoder.encode("???", "UTF-8") +
//			        "&lName=" + URLEncoder.encode("???", "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//test.executePost("https://api.orchestrate.io/v0/users/testUserAgain", "Jim", "jim@email.com", "3145554367");
		test.executePost("https://api.orchestrate.io/v0/users/testUserAgain", "iulanglianweolguhaweg");
	
	}

}
