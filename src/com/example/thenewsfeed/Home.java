package com.example.thenewsfeed;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView.FindListener;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.thenewsfeed.adapter.TopNewsAdapter;
import com.example.thenewsfeed.pojo.Post;
import com.example.thenewsfeed.utils.SAXHelper;
import com.example.urlimageviewhelper.UrlImageViewHelper;

public class Home extends Activity {

	GridView topNewsGrid = null;
	public static ArrayList<Post> posts = new ArrayList<Post>();
	TopNewsAdapter adpt = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		setUpUI();
		new TopStoriesAsync().execute("http://feeds.feedburner.com/dinamalar/Front_page_news");		
	}
	
	class TopStoriesAsync extends AsyncTask<String, Void, ArrayList<Post>> {
		SAXHelper sh = null;
		public List<Post> posts = new ArrayList<Post>();
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}
		
		@Override
		protected ArrayList<Post> doInBackground(String... params) {
			ArrayList<Post> posts = new ArrayList<Post>();
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
		protected void onPostExecute(ArrayList<Post> posts) {
			initializeData(posts);
		}		
	}
	
	
	private  void setUpUI(){
		topNewsGrid = (GridView) findViewById(R.id.TopNewsGridView);		
	}
	
	private  void initializeData(ArrayList<Post> posts){
		ImageButton headImage = (ImageButton) findViewById(R.id.HeadNewsImage);
		String thumb_large = posts.get(0).getThumbnail();
		UrlImageViewHelper.setUrlDrawable(headImage, thumb_large.replaceAll("thumb", "large"));   
		
		TextView headTitle = (TextView) findViewById(R.id.HeadNewTitle);
		headTitle.setText(posts.get(0).getTitle());
		
		posts.remove(0);posts.remove(1);
		
		/*Home.posts = posts;
		Log.d("-->","initialzie data"+Home.posts.size());
		adpt = new TopNewsAdapter(this, Home.posts, getAssets());
		topNewsGrid.setAdapter(adpt);
		*/
	}

}
