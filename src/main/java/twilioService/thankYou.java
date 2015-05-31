package twilioService;

// You may want to be more specific in your imports
import java.util.*;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.*;
import com.twilio.sdk.resource.factory.*;
import com.twilio.sdk.resource.instance.*;
import com.twilio.sdk.resource.list.*;

public class thankYou {

	// Find your Account Sid and Token at twilio.com/user/account
	//	 public static final String ACCOUNT_SID = "AC7daeeb8449a628e01bf100be6de93efb";
	//	 public static final String AUTH_TOKEN = "[AuthToken]";

	public  String /*change back to void!!*/ thankYou(String ACCOUNT_SID, String AUTH_TOKEN, String donatorPhoneNum, String donatorName, String recipientName,  String url) throws TwilioRestException {
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

		// Build the parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("From", "+16362006384"));  //need to change from number
		params.add(new BasicNameValuePair("Body", "Hey " + donatorName + ", thank you for your generous contribution to feeding the hungry! " + recipientName + " is now enjoying a hot meal thanks to you! Please click here if you would like to donate again: " + url));
		params.add(new BasicNameValuePair("To", donatorPhoneNum));
		//params.add(new BasicNameValuePair("MediaUrl", "http://www.example.com/hearts.png"));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
		System.out.println(message.getSid());
		return message.getSid();
	}
    public void redeemCode(String ACCOUNT_SID, String AUTH_TOKEN, String recipientNmae, String reciepientPhone, String code) throws TwilioRestException{
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        // Build the parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("From", "+16362006384"));  //need to change from number
        params.add(new BasicNameValuePair("Body", "Hey " + recipientNmae + " Here is your redemption code:" + code));
        params.add(new BasicNameValuePair("To", reciepientPhone));

        MessageFactory messageFactory = client.getAccount().getMessageFactory();
        Message message = messageFactory.create(params);
        System.out.println(message.getSid());
     return;

    }

}
