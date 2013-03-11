package com.example.thenewsfeed.adapter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.thenewsfeed.R;
import com.example.thenewsfeed.pojo.Post;
import com.example.urlimageviewhelper.UrlImageViewHelper;
public class TopNewsAdapter extends BaseAdapter {
	private Activity activity;
	private ArrayList<Post> data;
	private static LayoutInflater inflater = null;
	private AssetManager assetMgr;
	//public ImageLoader imageLoader;
	ViewHolder holder;

	public TopNewsAdapter(Activity a, ArrayList<Post> d, AssetManager assetMgr) {

		activity = a;
		data = d;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	//	imageLoader = new ImageLoader(activity.getApplicationContext());
		this.assetMgr = assetMgr;
	}

	
	public int getCount() {
		return data.toArray().length;

	}

	
	public Object getItem(int position) {

		return position;
	}

	
	public long getItemId(int position) {

		return position;
	}

	public static class ViewHolder {
		public TextView TopNewTitle;
		public ImageButton TopNewsImage;
	}

	
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;

		if (convertView == null) {
			vi = inflater.inflate(R.layout.data, null);
			holder = new ViewHolder();
			holder.TopNewsImage = (ImageButton) vi.findViewById(R.id.TopNewsImage);
			holder.TopNewTitle = (TextView) vi.findViewById(R.id.TopNewTitle);
			vi.setTag(holder);
		} else
			holder = (ViewHolder) vi.getTag();
		
		Typeface tf = Typeface.createFromAsset(this.assetMgr, "fonts/Bamini.ttf");    
		holder.TopNewTitle.setTypeface(tf);
		holder.TopNewTitle.setText(this.convertTamil(data.get(position).getTitle().toString()));
		String thumb_large = data.get(position).getThumbnail();
		UrlImageViewHelper.setUrlDrawable(holder.TopNewsImage, thumb_large.replaceAll("thumb", "large"));   
		/*SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
		//Log.i("DESC", data.get(position).getDescription());
		try {
			Date date = (Date) formatter.parse(data.get(position).getPubDate());
			Calendar calendar = Calendar.getInstance(); 
			calendar.setTime(date);
			holder.addr.setText(new SimpleDateFormat("MMMM").format(date)+" "+calendar.get(Calendar.DAY_OF_MONTH)+","+calendar.get(Calendar.YEAR)+","+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+" IST");
			//holder.addr.setText(date.getDate()+"/"+date.getMonth()+"/"+calendar.get(Calendar.YEAR) +"      "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

//		imageLoader.DisplayImage((data.get(position).getThumbnail()), activity,
//				holder.image, 72, 72);
	/*	URL url = null;
		try {
			url = new URL((data.get(position).getThumbnail()));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStream content = null;
		try {
			content = (InputStream)url.getContent();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Drawable d = Drawable.createFromStream(content , "src"); 
		Bitmap mIcon1 = null;
		 try {
			 mIcon1 =
			        BitmapFactory.decodeStream(url.openConnection().getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		holder.image.setImageBitmap(Bitmap.createScaledBitmap(mIcon1, 72, 72, false));
*/
		
		return vi;
	}
	
	private String convertTamil(String t) {
		// TODO Auto-generated method stub
		String eelam = t;
		eelam = eelam.replace(",", ">");



		eelam = eelam.replace("ஜௌ", "n[s");
		eelam = eelam.replace("ஜோ", "N[h");
		eelam = eelam.replace("ஜொ", "n[h");
		eelam = eelam.replace("ஜா", "[h");
		eelam = eelam.replace("ஜி", "[p");
		eelam = eelam.replace("ஜீ", "[P");
		eelam = eelam.replace("ஜு", "[{");
		eelam = eelam.replace("ஜூ", "[_");
		eelam = eelam.replace("ஜெ", "n[");
		eelam = eelam.replace("ஜே", "N[");
		eelam = eelam.replace("ஜை", "i[");
		eelam = eelam.replace("ஜ்", "[;");
		eelam = eelam.replace("ஜ", "[");


		eelam = eelam.replace("கௌ", "nfs");
		eelam = eelam.replace("கோ", "Nfh");
		eelam = eelam.replace("கொ", "nfh");
		eelam = eelam.replace("கா", "fh");
		eelam = eelam.replace("கி", "fp");
		eelam = eelam.replace("கீ", "fP");
		eelam = eelam.replace("கு", "F");
		eelam = eelam.replace("கூ", "$");
		eelam = eelam.replace("கெ", "nf");
		eelam = eelam.replace("கே", "Nf");
		eelam = eelam.replace("கை", "if");

		eelam = eelam.replace("க்", "f;");
		eelam = eelam.replace("க", "f");
		eelam = eelam.replace("ஙௌ", "nqs");
		eelam = eelam.replace("ஙோ", "Nqh");
		eelam = eelam.replace("ஙொ", "nqh");
		eelam = eelam.replace("ஙா", "qh");
		eelam = eelam.replace("ஙி", "qp");
		eelam = eelam.replace("ஙீ", "qP");
		eelam = eelam.replace("ஙு", "*");
		eelam = eelam.replace("ஙூ", "*");
		eelam = eelam.replace("ஙெ", "nq");
		eelam = eelam.replace("ஙே", "Nq");
		eelam = eelam.replace("ஙை", "iq");
		eelam = eelam.replace("ங்", "q;");
		eelam = eelam.replace("ங", "q");







		eelam = eelam.replace("சௌ", "nrs");
		eelam = eelam.replace("சோ", "Nrh");
		eelam = eelam.replace("சொ", "nrh");
		eelam = eelam.replace("சா", "rh");
		eelam = eelam.replace("சி", "rp");
		eelam = eelam.replace("சீ", "rP");
		eelam = eelam.replace("சு", "R");
		eelam = eelam.replace("சூ", "R+");
		eelam = eelam.replace("செ", "nr");
		eelam = eelam.replace("சே", "Nr");
		eelam = eelam.replace("சை", "ir");
		eelam = eelam.replace("ச்", "r;");
		eelam = eelam.replace("ச", "r");




		eelam = eelam.replace("ஞௌ", "nQs");
		eelam = eelam.replace("ஞோ", "NQh");
		eelam = eelam.replace("ஞொ", "nQh");
		eelam = eelam.replace("ஞா", "Qh");
		eelam = eelam.replace("ஞி", "Qp");
		eelam = eelam.replace("ஞீ", "QP");
		eelam = eelam.replace("ஞு", "*");
		eelam = eelam.replace("ஞூ", "*");
		eelam = eelam.replace("ஞெ", "nQ");
		eelam = eelam.replace("ஞே", "NQ");
		eelam = eelam.replace("ஞை", "iQ");
		eelam = eelam.replace("ஞ்", "Q;");
		eelam = eelam.replace("ஞ", "Q");






		eelam = eelam.replace("டௌ", "nls");
		eelam = eelam.replace("டோ", "Nlh");
		eelam = eelam.replace("டொ", "nlh");
		eelam = eelam.replace("டா", "lh");
		eelam = eelam.replace("டி", "b");
		eelam = eelam.replace("டீ", "B");
		eelam = eelam.replace("டு", "L");
		eelam = eelam.replace("டூ", "^");
		eelam = eelam.replace("டெ", "nl");
		eelam = eelam.replace("டே", "Nl");
		eelam = eelam.replace("டை", "il");
		eelam = eelam.replace("ட்", "l;");
		eelam = eelam.replace("ட", "l");




		eelam = eelam.replace("ணௌ", "nzs");
		eelam = eelam.replace("ணோ", "Nzh");
		eelam = eelam.replace("ணொ", "nzh");
		eelam = eelam.replace("ணா", "zh");
		eelam = eelam.replace("ணி", "zp");
		eelam = eelam.replace("ணீ", "zP");
		eelam = eelam.replace("ணு", "Z");
		eelam = eelam.replace("ணூ", "Z}");
		eelam = eelam.replace("ணெ", "nz");
		eelam = eelam.replace("ணே", "Nz");
		eelam = eelam.replace("ணை", "iz");
		eelam = eelam.replace("ண்", "z;");
		eelam = eelam.replace("ண", "z");


		eelam = eelam.replace("தௌ", "njs");
		eelam = eelam.replace("தோ", "Njh");
		eelam = eelam.replace("தொ", "njh");
		eelam = eelam.replace("தா", "jh");
		eelam = eelam.replace("தி", "jp");
		eelam = eelam.replace("தீ", "jP");
		eelam = eelam.replace("து", "J");
		eelam = eelam.replace("தூ", "J}");
		eelam = eelam.replace("தெ", "nj");
		eelam = eelam.replace("தே", "Nj");
		eelam = eelam.replace("தை", "ij");
		eelam = eelam.replace("த்", "j;");
		eelam = eelam.replace("த", "j");






		eelam = eelam.replace("நௌ", "nes");
		eelam = eelam.replace("நோ", "Neh");
		eelam = eelam.replace("நொ", "neh");
		eelam = eelam.replace("நா", "eh");
		eelam = eelam.replace("நி", "ep");
		eelam = eelam.replace("நீ", "eP");
		eelam = eelam.replace("நு", "E");
		eelam = eelam.replace("நூ", "E}");
		eelam = eelam.replace("நெ", "ne");
		eelam = eelam.replace("நே", "Ne");
		eelam = eelam.replace("நை", "ie");
		eelam = eelam.replace("ந்", "e;");
    	eelam = eelam.replace("ந", "e");



		eelam = eelam.replace("னௌ", "nds");
		eelam = eelam.replace("னோ", "Ndh");
		eelam = eelam.replace("னொ", "ndh");
		eelam = eelam.replace("னா", "dh");
		eelam = eelam.replace("னி", "dp");
		eelam = eelam.replace("னீ", "dP");
		eelam = eelam.replace("னு", "D");
		eelam = eelam.replace("னூ", "D}");
		eelam = eelam.replace("னெ", "nd");
		eelam = eelam.replace("னே", "Nd");
		eelam = eelam.replace("னை", "id");
		eelam = eelam.replace("ன்", "d;");
		eelam = eelam.replace("ன", "d");




		eelam = eelam.replace("பௌ", "ngs");
		eelam = eelam.replace("போ", "Ngh");
		eelam = eelam.replace("பொ", "ngh");
		eelam = eelam.replace("பா", "gh");
		eelam = eelam.replace("பி", "gp");
		eelam = eelam.replace("பீ", "gP");
		eelam = eelam.replace("பு", "G");
		eelam = eelam.replace("பூ", "G+");
		eelam = eelam.replace("பெ", "ng");
		eelam = eelam.replace("பே", "Ng");
		eelam = eelam.replace("பை", "ig");
		eelam = eelam.replace("ப்", "g;");
		eelam = eelam.replace("ப", "g");





		eelam = eelam.replace("மௌ", "nks");
		eelam = eelam.replace("மோ", "Nkh");
		eelam = eelam.replace("மொ", "nkh");
		eelam = eelam.replace("மா", "kh");
		eelam = eelam.replace("மி", "kp");
		eelam = eelam.replace("மீ", "kP");
		eelam = eelam.replace("மு", "K");
		eelam = eelam.replace("மூ", "%");
		eelam = eelam.replace("மெ", "nk");
		eelam = eelam.replace("மே", "Nk");
		eelam = eelam.replace("மை", "ik");
		eelam = eelam.replace("ம்", "k;");
		eelam = eelam.replace("ம", "k");




		eelam = eelam.replace("யௌ", "nas");
		eelam = eelam.replace("யோ", "Nah");
		eelam = eelam.replace("யொ", "nah");
		eelam = eelam.replace("யா", "ah");
		eelam = eelam.replace("யி", "ap");
		eelam = eelam.replace("யீ", "aP");
		eelam = eelam.replace("யு", "A");
		eelam = eelam.replace("யூ", "A+");
		eelam = eelam.replace("யெ", "na");
		eelam = eelam.replace("யே", "Na");
		eelam = eelam.replace("யை", "ia");
		eelam = eelam.replace("ய்", "a;");
		eelam = eelam.replace("ய", "a");


		eelam = eelam.replace("ரௌ", "nus");
		eelam = eelam.replace("ரோ", "Nuh");
		eelam = eelam.replace("ரொ", "nuh");
		eelam = eelam.replace("ரா", "uh");
		eelam = eelam.replace("ரி", "up");
		eelam = eelam.replace("ரீ", "uP");
		eelam = eelam.replace("ரு", "U");
		eelam = eelam.replace("ரூ", "&");
		eelam = eelam.replace("ரெ", "nu");
		eelam = eelam.replace("ரே", "Nu");
		eelam = eelam.replace("ரை", "iu");
		eelam = eelam.replace("ர்", "u;");
		eelam = eelam.replace("ர", "u");




		eelam = eelam.replace("லௌ", "nys");
		eelam = eelam.replace("லோ", "Nyh");
		eelam = eelam.replace("லொ", "nyh");
		eelam = eelam.replace("லா", "yh");
		eelam = eelam.replace("லி", "yp");
		eelam = eelam.replace("லீ", "yP");
		eelam = eelam.replace("லு", "Y");
		eelam = eelam.replace("லூ", "Y}");
		eelam = eelam.replace("லெ", "ny");
		eelam = eelam.replace("லே", "Ny");
		eelam = eelam.replace("லை", "iy");
		eelam = eelam.replace("ல்", "y;");
		eelam = eelam.replace("ல", "y");




		eelam = eelam.replace("ளௌ", "nss");
		eelam = eelam.replace("ளோ", "Nsh");
		eelam = eelam.replace("ளொ", "nsh");
		eelam = eelam.replace("ளா", "sh");
		eelam = eelam.replace("ளி", "sp");
		eelam = eelam.replace("ளீ", "sP");
		eelam = eelam.replace("ளு", "S");
		eelam = eelam.replace("ளூ", "Sh");
		eelam = eelam.replace("ளெ", "ns");
		eelam = eelam.replace("ளே", "Ns");
		eelam = eelam.replace("ளை", "is");
		eelam = eelam.replace("ள்", "s;");
		eelam = eelam.replace("ள", "s");


		eelam = eelam.replace("வௌ", "nts");
		eelam = eelam.replace("வோ", "Nth");
		eelam = eelam.replace("வொ", "nth");
		eelam = eelam.replace("வா", "th");
		eelam = eelam.replace("வி", "tp");
		eelam = eelam.replace("வீ", "tP");
		eelam = eelam.replace("வு", "T");
		eelam = eelam.replace("வூ", "T+");
		eelam = eelam.replace("வெ", "nt");
		eelam = eelam.replace("வே", "Nt");
		eelam = eelam.replace("வை", "it");
		eelam = eelam.replace("வ்", "t;");
		eelam = eelam.replace("வ", "t");




		eelam = eelam.replace("ழௌ", "nos");
		eelam = eelam.replace("ழோ", "Noh");
		eelam = eelam.replace("ழொ", "noh");
		eelam = eelam.replace("ழா", "oh");
		eelam = eelam.replace("ழி", "op");
		eelam = eelam.replace("ழீ", "oP");
		eelam = eelam.replace("ழு", "O");
		eelam = eelam.replace("ழூ", "*");
		eelam = eelam.replace("ழெ", "no");
		eelam = eelam.replace("ழே", "No");
		eelam = eelam.replace("ழை", "io");
		eelam = eelam.replace("ழ்", "o;");
		eelam = eelam.replace("ழ", "o");

		eelam = eelam.replace("றௌ", "nws");
		eelam = eelam.replace("றோ", "Nwh");
		eelam = eelam.replace("றொ", "nwh");
		eelam = eelam.replace("றா", "wh");
		eelam = eelam.replace("றி", "wp");
		eelam = eelam.replace("றீ", "wP");
		eelam = eelam.replace("று", "W");
		eelam = eelam.replace("றூ", "W}");
		eelam = eelam.replace("றெ", "nw");
		eelam = eelam.replace("றே", "Nw");
		eelam = eelam.replace("றை", "iw");
		eelam = eelam.replace("ற்", "w;");
		eelam = eelam.replace("ற", "w");


		eelam = eelam.replace("ஹௌ", "n`s");
		eelam = eelam.replace("ஹோ", "N`h");
		eelam = eelam.replace("ஹொ", "n`h");
		eelam = eelam.replace("ஹா", "`h");
		eelam = eelam.replace("ஹி", "`p");
		eelam = eelam.replace("ஹீ", "`P");
		eelam = eelam.replace("ஹு", "{`");
		eelam = eelam.replace("ஹூ", "`_");
		eelam = eelam.replace("ஹெ", "n`");
		eelam = eelam.replace("ஹே", "N`");
		eelam = eelam.replace("ஹை", "i`");
		eelam = eelam.replace("ஹ்", "`;");
		eelam = eelam.replace("ஹ", "`");


		eelam = eelam.replace("ஷௌ", "n\\s");
		eelam = eelam.replace("ஷோ", "N\\h");
		eelam = eelam.replace("ஷொ", "n\\h");
		eelam = eelam.replace("ஷா", "\\h");
		eelam = eelam.replace("ஷி", "\\p");
		eelam = eelam.replace("ஷீ", "\\P");
		eelam = eelam.replace("ஷு", "{");
		//eelam = eelam.replace("ஷூ", "\_");
		eelam = eelam.replace("ஷெ", "n\\");
		eelam = eelam.replace("ஷே", "N\\");
		eelam = eelam.replace("ஷை", "i\\");

		eelam = eelam.replace("ஷ்", "\\;");
		eelam = eelam.replace("ஷ", "\\");
		eelam = eelam.replace("ஸௌ", "n]s");
		eelam = eelam.replace("ஸோ", "N]h");
		eelam = eelam.replace("ஸொ", "n]h");
		eelam = eelam.replace("ஸா", "]h");
		eelam = eelam.replace("ஸி", "]p");
		eelam = eelam.replace("ஸீ", "]P");
		eelam = eelam.replace("ஸு", "]{");
		eelam = eelam.replace("ஸூ", "]_");
		eelam = eelam.replace("ஸெ", "n]");
		eelam = eelam.replace("ஸே", "N]");
		eelam = eelam.replace("ஸை", "i]");
		eelam = eelam.replace("ஸ்", "];");
		eelam = eelam.replace("ஸ", "]");




		eelam = eelam.replace("அ", "m");
		eelam = eelam.replace("ஆ", "M");
		eelam = eelam.replace("இ", ",");
		eelam = eelam.replace("ஈ", "<");
    	eelam = eelam.replace("உ", "c");
		eelam = eelam.replace("ஊ", "C");
		eelam = eelam.replace("எ", "v");
		eelam = eelam.replace("ஏ", "V");
		eelam = eelam.replace("ஐ", "I");
		eelam = eelam.replace("ஒ", "x");
		eelam = eelam.replace("ஓ", "X");
		eelam = eelam.replace("ஔ", "xs");
		eelam = eelam.replace("ஃ", "/");
		eelam = eelam.replace("ஸ்ரீ", "=");


		eelam = eelam.replace("வூ", "t+");
		eelam = eelam.replace("பூ", "G+");
		eelam = eelam.replace("யூ", "A+");
		eelam = eelam.replace("ஹு", "`{");
		eelam = eelam.replace("ஜு", "[{");
		eelam = eelam.replace("ஸு", "]{");
		eelam = eelam.replace("ஷு", "{");
		eelam = eelam.replace("யூ", "A+");
		eelam = eelam.replace("ா", "h");
		eelam = eelam.replace("ெ", "n");
		eelam = eelam.replace("ே", "N");
		eelam = eelam.replace("ை", "i");
		eelam = eelam.replace("ு", "{");
		eelam = eelam.replace("ூ", "_");
		eelam = eelam.replace("ி", "p");
		eelam = eelam.replace("ீ", "P");
		
		return eelam;
	}


}
