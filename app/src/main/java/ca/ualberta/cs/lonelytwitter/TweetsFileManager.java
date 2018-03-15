package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import ca.ualberta.cs.lonelytweet.NormalLonelyTweet;
// made package private
class TweetsFileManager {
	// Made Private and static
	private static final String FILE_SAV = "file.sav";
	private final Context ctx;
	// Made Private
	TweetsFileManager(Context ctx) {
		this.ctx = ctx;
	}

	@SuppressWarnings("unchecked")
	// Made Private
	List<NormalLonelyTweet> loadTweets() {
		List<NormalLonelyTweet> tweets = new ArrayList<NormalLonelyTweet>();

		try {
			FileInputStream fis = ctx.openFileInput(FILE_SAV);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = ois.readObject();

			if (o instanceof ArrayList) {
				tweets = (ArrayList<NormalLonelyTweet>) o;
			} else {
				Log.i("LonelyTwitter", "Error casting");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return tweets;
	}

	public void saveTweets(List<NormalLonelyTweet> tweets) {
		try {
			FileOutputStream fos = ctx.openFileOutput("file.sav", 0);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(tweets);

			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}