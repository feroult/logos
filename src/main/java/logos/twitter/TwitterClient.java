package logos.twitter;

import static logos.api.Setup.CONSUMER_KEY;
import static logos.api.Setup.CONSUMER_SECRET;
import static logos.api.Setup.TOKEN;
import static logos.api.Setup.TOKEN_SECRET;
import static logos.api.Setup.logosProperty;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterClient {

	public static void main(String[] args) {
		directTweet(args[0]);
	}
	
	public static void directTweet(String msg) {
		try {
			Twitter twitter = new TwitterFactory().getInstance();

			twitter.setOAuthConsumer(logosProperty(CONSUMER_KEY), logosProperty(CONSUMER_SECRET));
			twitter.setOAuthAccessToken(new AccessToken(logosProperty(TOKEN),
					logosProperty(TOKEN_SECRET)));

			Status status;
			status = twitter.updateStatus(msg);
			System.out.println("Successfully updated the status to [" + status.getText() + "].");

		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
}
