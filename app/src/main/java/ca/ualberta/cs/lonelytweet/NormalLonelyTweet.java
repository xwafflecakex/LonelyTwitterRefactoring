package ca.ualberta.cs.lonelytweet;

import java.util.Date;

import ca.ualberta.cs.lonelytweet.LonelyTweet;

public class NormalLonelyTweet extends LonelyTweet {

	public NormalLonelyTweet() {
	}

	public NormalLonelyTweet(String text) {
		this.tweetDate = new Date();
		this.tweetBody = text;
	}

	@Override
	// Simplified the if statement
	public boolean isValid() {
		return !(tweetBody.trim().length() == 0
				|| tweetBody.trim().length() > 10);
	}

	@Override
	public String toString() {
		return getTweetDate() + " | " + getTweetBody() ;
	}

	// Made private
	private String getTweetBody() {
        return tweetBody;
    }
}