package com.example.thenewsfeed;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.example.android.animation.AnimationFactory;
import com.example.android.animation.AnimationFactory.FlipDirection;
import com.example.rssfeed.RSSFeed;
import com.example.rssfeed.RSSItem;
import com.example.rssfeed.RSSReader;
import com.example.rssfeed.RSSReaderException;
import com.example.thenewsfeed.adapter.TopNewsAdapter;
import com.example.thenewsfeed.pojo.Post;
import com.example.thenewsfeed.utils.SAXHelper;
import com.example.urlimageviewhelper.UrlImageViewHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.PauseOnScrollListener;
public class Home extends Activity {

	GridView topNewsGrid = null;
	protected ImageLoader imageLoader = ImageLoader.getInstance();
	public static ArrayList<Post> posts = new ArrayList<Post>();
	TopNewsAdapter adpt = null;
	DisplayImageOptions options;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		setUpUI();
		
		options = new DisplayImageOptions.Builder()
		.showStubImage(R.drawable.ic_stub)
		.showImageForEmptyUri(R.drawable.ic_empty)
		.showImageOnFail(R.drawable.ic_error)
		.cacheInMemory()
		.cacheOnDisc()
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();

		
		//new TopStoriesAsync().execute("http://feeds.feedburner.com/dinamalar/Front_page_news",
		//							  "http://tamil.oneindia.in/rss/tamil-news-fb.xml");		
		List<RSSItem> items = new ArrayList<RSSItem>();
		  RSSReader reader = new RSSReader();
		  String uri = "";
		  try {
			  
			  uri = "http://tamil.oneindia.in/rss/tamil-news-fb.xml";
				items.addAll(reader.load(uri).getItems());
				
				
				/*  uri = "http://feeds.bbci.co.uk/news/world/rss.xml";
			 items.addAll(reader.load(uri).getItems());
			  
			uri = "http://feeds.feedburner.com/dinamalar/Front_page_news";
			items.addAll(reader.load(uri).getItems());
			
			
				
				uri = "http://www.dinakaran.com/rss_Latest.asp";
				items.addAll(reader.load(uri).getItems());
				
				uri = "http://www.nakkheeran.in/rss/Top_rss.xml";
				items.addAll(reader.load(uri).getItems());
				*/
				//uri = "http://www.dailythanthi.com/rss.xml";
				//items.addAll(reader.load(uri).getItems());
			
			Home.posts = posts;
		//	Log.d("-->","initialzie data"+Home.posts.size());
			adpt = new TopNewsAdapter(this, items, imageLoader, options, getAssets());
			topNewsGrid.setAdapter(adpt);
			topNewsGrid.setOnScrollListener(new PauseOnScrollListener(imageLoader, true, true));
			// uri = "http://feeds.feedburner.com/dinamalar/Front_page_news";
			// items.addAll(reader.load(uri).getItems());
			
				Log.d("--->",""+items.size());
		} catch (RSSReaderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				for(int i =0; i< params.length; i++){
				sh = new SAXHelper(params[i]);
				posts.addAll(sh.parseContent(""));
				}
				
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
		
		//posts.remove(0);//posts.remove(1);
		
		Home.posts = posts;
		Log.d("-->","initialzie data"+Home.posts.size());
	//	adpt = new TopNewsAdapter(this, Home.posts, getAssets());
		//topNewsGrid.setAdapter(adpt);
		
	}

	
}
