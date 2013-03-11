package com.example.thenewsfeed.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.thenewsfeed.pojo.Post;


public class SAXHelper {
		public HashMap<String, String> userList = new HashMap<String, String>();
		private URL url2;

		public SAXHelper(String url1) throws MalformedURLException {
			this.url2 = new URL(url1);
		}

		public ArrayList<Post> parseContent(String parseContent) {
			RSSHandler df = new RSSHandler();
			try {

				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
				XMLReader xr = sp.getXMLReader();
				xr.setContentHandler(df);
				xr.parse(new InputSource(url2.openStream()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return df.PostList;
		}
	}

	class RSSHandler extends DefaultHandler {
		public Boolean isItem = false;
		private Post currentPost = new Post();
		StringBuffer chars = new StringBuffer();
		public ArrayList<Post> PostList = new ArrayList<Post>();
		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes atts) {

			chars = new StringBuffer();
			if (localName.equalsIgnoreCase("item")) {

			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {

			if (localName.equalsIgnoreCase("item")) {
				PostList.add(currentPost);
				currentPost = new Post();
			}
			
			else if (localName.equalsIgnoreCase("title")
					&& currentPost.getTitle() == null) {
				currentPost.setTitle(chars.toString());

			}
			else if (localName.equalsIgnoreCase("pubDate")
					&& currentPost.getPubDate() == null) {
				currentPost.setPubDate(chars.toString());

			}
			else if (localName.equalsIgnoreCase("description")
					&& currentPost.getThumbnail() == null) {
				String str = chars.toString();
				currentPost.setDescription(str);
				Pattern p = Pattern
						.compile("<img[^>]*src=[\"|']([^(\"|')]+)[\"|'][^>]*>");
				Matcher m = p.matcher(str);
				if (m.find()) {
					String url = m.group(1);
					// Log.i("Title", data.get(position).getTitle().toString());
					Log.i("URL", url);
					// UrlImageViewHelper.setUrlDrawable(holder.image, url);
					currentPost.setThumbnail(url.trim());
				}
			}
			else if (localName.equalsIgnoreCase("link")
					&& currentPost.getUrl() == null) {
				currentPost.setUrl(chars.toString());
			}

			

		}

		@Override
		public void characters(char ch[], int start, int length) {
			chars.append(new String(ch, start, length));
		}

	}
