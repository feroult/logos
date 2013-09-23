package logos.twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterClient {

	private static final String CONSUMER_KEY = "LOGOS_CONSUMER_KEY";
	private static final String CONSUMER_SECRET = "LOGOS_CONSUMER_SECRET";
	private static final String TOKEN = "LOGOS_TOKEN";
	private static final String TOKEN_SECRET = "LOGOS_TOKEN_SECRET";

	public static void main(String[] args) {
		directTweet(args[0]);
	}
	
	public static void directTweet(String msg) {
		try {
			Twitter twitter = new TwitterFactory().getInstance();

			twitter.setOAuthConsumer(getEnv(CONSUMER_KEY), getEnv(CONSUMER_SECRET));
			twitter.setOAuthAccessToken(new AccessToken(getEnv(TOKEN),
					getEnv(TOKEN_SECRET)));

			Status status;
			status = twitter.updateStatus(msg);
			System.out.println("Successfully updated the status to [" + status.getText() + "].");

		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	private static String getEnv(String key) {
		return System.getenv().get(key);
	}
}
