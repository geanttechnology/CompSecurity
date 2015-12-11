// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.search.SavedSearch;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.EbayCountry;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseListActivity

public class RtmThemedSearchActivity extends BaseListActivity
    implements android.widget.AbsListView.OnScrollListener
{
    private class DownloadImageTask extends AsyncTask
    {

        final RtmThemedSearchActivity this$0;

        protected transient Bitmap doInBackground(URL aurl[])
        {
            aurl = BitmapFactory.decodeStream((InputStream)aurl[0].getContent());
            return aurl;
            aurl;
            Log.e("RtmThemedSearchActivity", (new StringBuilder()).append("MalformedURLException = ").append(aurl.toString()).toString());
_L2:
            return null;
            aurl;
            Log.e("RtmThemedSearchActivity", (new StringBuilder()).append("IOException = ").append(aurl.toString()).toString());
            if (true) goto _L2; else goto _L1
_L1:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((URL[])aobj);
        }

        protected void onPostExecute(Bitmap bitmap)
        {
            if (bitmap != null)
            {
                int i = (bitmap.getHeight() * displayWidth) / bitmap.getWidth();
                bitmap = Bitmap.createScaledBitmap(bitmap, displayWidth, i, true);
                ImageView imageview = (ImageView)findViewById(0x7f100557);
                imageview.setAdjustViewBounds(false);
                imageview.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
                imageview.setImageBitmap(bitmap);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Bitmap)obj);
        }

        private DownloadImageTask()
        {
            this$0 = RtmThemedSearchActivity.this;
            super();
        }

    }

    private class ThemeListAdapter extends ArrayAdapter
    {

        final RtmThemedSearchActivity this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            view = super.getView(i, view, viewgroup);
            viewgroup = (TextView)view.findViewById(0x1020014);
            viewgroup.setTypeface(Typeface.DEFAULT_BOLD);
            viewgroup.setText((CharSequence)searchDescriptions.get(i));
            return view;
        }

        public ThemeListAdapter(Context context, int i, int j, List list)
        {
            this$0 = RtmThemedSearchActivity.this;
            super(context, i, j, list);
        }
    }


    private static final String TAG = "RtmThemedSearchActivity";
    private final EbayCountry country = MyApp.getPrefs().getCurrentCountry();
    private int displayHeight;
    private int displayMax;
    private int displayWidth;
    private ArrayList itemSearchURLs;
    private final int maxCountPerPage = 25;
    private ArrayList searchDescriptions;
    private String title;

    public RtmThemedSearchActivity()
    {
        title = "";
        searchDescriptions = null;
        itemSearchURLs = null;
        displayWidth = 0;
        displayHeight = 0;
        displayMax = 0;
    }

    public String getTrackingEventName()
    {
        return "RtmThemedSearch";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = getIntent().getExtras();
        bundle = new String();
        if (bundle1 != null)
        {
            bundle1.getString("android.intent.extra.TEXT");
            title = bundle1.getString("android.intent.extra.TITLE");
            bundle = bundle1.getString("url");
            searchDescriptions = bundle1.getStringArrayList("searchDescriptions");
            itemSearchURLs = bundle1.getStringArrayList("itemSearchURLs");
        }
        setContentView(0x7f0301c4);
        getListView().setOnScrollListener(this);
        getListView().setHeaderDividersEnabled(true);
        setTitle(title);
        if (!TextUtils.isEmpty(bundle))
        {
            try
            {
                (new DownloadImageTask()).execute(new URL[] {
                    new URL(bundle)
                });
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                Log.e("RtmThemedSearchActivity", (new StringBuilder()).append("MalformedURLException = ").append(bundle.toString()).toString());
            }
        }
        setListAdapter(new ThemeListAdapter(this, 0x7f03007a, 0x1020014, searchDescriptions));
        bundle = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        displayWidth = bundle.getWidth();
        displayHeight = bundle.getHeight();
        if (displayHeight > displayWidth)
        {
            displayMax = displayHeight;
        } else
        {
            displayMax = displayWidth;
        }
        bundle = findViewById(0x7f1003ab);
        if (bundle != null)
        {
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final RtmThemedSearchActivity this$0;

                public void onClick(View view)
                {
                    finish();
                }

            
            {
                this$0 = RtmThemedSearchActivity.this;
                super();
            }
            });
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
        if (itemSearchURLs != null && i < itemSearchURLs.size())
        {
            listview = new SavedSearch(country, 25);
            listview.name = title;
            listview.query = (String)itemSearchURLs.get(i);
            new com.ebay.mobile.search.SavedSearchListActivity.SearchQueryParser(listview, MyApp.getPrefs().getAuthentication());
            ActivityStarter.startSearchResultList(this, ((SavedSearch) (listview)).searchParameters, "browse_categories");
            return;
        } else
        {
            Log.e("RtmThemedSearchActivity", "Selected position outside range of backing array. This indicates bad response and/or parsing.");
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onRestart()
    {
        super.onRestart();
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        abslistview = ((ListView)abslistview).getChildAt(i);
        if (abslistview instanceof LinearLayout)
        {
            abslistview = ((LinearLayout)abslistview).getChildAt(0);
            if (abslistview instanceof TextView)
            {
                ((TextView)abslistview).setTypeface(Typeface.DEFAULT_BOLD);
            }
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }

    protected void recoverFromSavedInstanceState(Bundle bundle)
    {
        if (bundle != null);
    }


}
