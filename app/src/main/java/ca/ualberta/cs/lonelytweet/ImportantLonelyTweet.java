package ca.ualberta.cs.lonelytweet;

import java.util.Date;

public class ImportantLonelyTweet extends LonelyTweet {

	public ImportantLonelyTweet() {
	}

	public ImportantLonelyTweet(String text) {
		this.tweetDate = new Date();
		this.tweetBody = text;
	}

	@Override
	//Simplified the if statement
	public boolean isValid() {
		return !(tweetBody.trim().length() == 0
				|| tweetBody.trim().length() > 20);
	}

	@Override
	// Got rid of redundant code string
	public String toString() {
		//Log.i("importantLonelyTweet", getTweetDate() + " | " + getTweetBody())
		return getTweetDate() + " | " + getTweetBody();
	}
	// Changed to private
	private String getTweetBody() {
        return tweetBody;
    }
}