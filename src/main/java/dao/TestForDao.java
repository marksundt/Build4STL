package dao;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestForDao {

	@Test
	public void test() {
		DaoStuff test = new DaoStuff();

		List<String> testList = new ArrayList<String>();
		testList.add("token1");
		testList.add("token2");
		testList.add("token3");
		test.createToken("https://api.orchestrate.io/v0/users/testUserAgain",testList);

//		try {
//			test.executePost("https://api.orchestrate.io/v0/users/testUserAgain", "fName=" + URLEncoder.encode("???", "UTF-8") +
//			        "&lName=" + URLEncoder.encode("???", "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//test.executePost("https://api.orchestrate.io/v0/users/testUserAgain", "Jim", "jim@email.com", "3145554367");
		//test.executePost("https://api.orchestrate.io/v0/users/testUserAgain", "iulanglianweolguhaweg");

	}

}
