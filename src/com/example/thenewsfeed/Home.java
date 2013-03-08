package com.example.thenewsfeed;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.thenewsfeed.pojo.Post;
import com.example.thenewsfeed.utils.SAXHelper;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		new TopStoriesAsync().execute("http://feeds.feedburner.com/dinamalar/Front_page_news");
	}
	
	class TopStoriesAsync extends AsyncTask<String, Void, List<Post>> {
		SAXHelper sh = null;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		@Override
		protected List<Post> doInBackground(String... params) {
			List<Post> posts = new ArrayList<Post>();
			try {
				sh = new SAXHelper(params[0]);
				posts = sh.parseContent("");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return posts;
		}
		
		@Override
		protected void onPostExecute(List<Post> posts) {
			for (Post post : posts) {
				Log.d("--->", post.getTitle());
			}
		}
		
	}

}
