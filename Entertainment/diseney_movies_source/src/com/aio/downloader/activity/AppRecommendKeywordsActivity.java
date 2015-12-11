// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.adapter.AppListviewAdapter;
import com.aio.downloader.adapter.ApprecommendkeywordAdapter;
import com.aio.downloader.adapter.AppsearchpromitAdapter;
import com.aio.downloader.model.SearcherPromitModel;
import com.aio.downloader.model.SearchkeywordModel;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.refresh.PullToRefreshLayout;
import com.aio.downloader.refresh.PullableListView_load;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.DeletableEditText;
import com.aio.downloader.views.LImageButton;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity, GameActivity1, MusthaveActivity, PaidforFreeActivity1, 
//            AppDetailsActivity

public class AppRecommendKeywordsActivity extends Activity
    implements android.view.View.OnClickListener, com.aio.downloader.refresh.PullableListView_load.OnLoadListener, OnDismissCallback, AdListener
{
    class Mya1 extends AsyncTask
    {

        private String jsonData;
        final AppRecommendKeywordsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            try
            {
                appkeywords = URLEncoder.encode(appkeywords);
                jsonData = publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword=")).append(appkeywords).append("&page=").append(page).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            return jsonData;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (s == null)
            {
                return;
            }
            try
            {
                ShowResult(s);
                ((RelativeLayout)listView.findViewById(0x7f0701db)).setVisibility(0);
                listView.setVisibility(0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pomitlv.setVisibility(8);
            serchgridview.setVisibility(8);
            ll_serch_refresh.setVisibility(8);
            pulltoresult.setVisibility(0);
            progressheel.setVisibility(0);
        }

        Mya1()
        {
            this$0 = AppRecommendKeywordsActivity.this;
            super();
        }
    }

    class loadingSearchKeywords extends AsyncTask
    {

        final AppRecommendKeywordsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            list = new ArrayList();
            if (publicTools.isNetworkAvailable(AppRecommendKeywordsActivity.this))
            {
                return publicTools.getUrl("http://android.downloadatoz.com/_201409/market/top_keywords.php");
            } else
            {
                return null;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (s != null)
            {
                try
                {
                    list.addAll(Myutils.parseSearchKeywords(s));
                    adapter = new ApprecommendkeywordAdapter(getApplicationContext(), list);
                    serchgridview.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    progressheel.setVisibility(8);
                    if (myjpush == 0)
                    {
                        search_view.setHint(((SearchkeywordModel)list.get(0)).getKeyword());
                        pomitlv.setVisibility(8);
                        serchgridview.setVisibility(0);
                        ll_serch_refresh.setVisibility(0);
                        Myutils.getInstance();
                        Myutils.hint = ((SearchkeywordModel)list.get(0)).getKeyword();
                        Myutils.getInstance();
                        Myutils.hintid = ((SearchkeywordModel)list.get(0)).getId();
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return;
                }
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressheel.setVisibility(0);
        }

        loadingSearchKeywords()
        {
            this$0 = AppRecommendKeywordsActivity.this;
            super();
        }
    }

    class loadpromittv extends AsyncTask
    {

        final AppRecommendKeywordsActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            if (publicTools.isNetworkAvailable(AppRecommendKeywordsActivity.this))
            {
                return publicTools.getUrl((new StringBuilder("https://market.android.com/suggest/SuggRequest?json=1&c=0&query=")).append(URLEncoder.encode(search_view.getText().toString())).append("&hl=en").toString());
            } else
            {
                return null;
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (s == null)
            {
                return;
            } else
            {
                list2.clear();
                list2.addAll(Myutils.parsearchpromitlist(s));
                adapterpromit = new AppsearchpromitAdapter(getApplicationContext(), list2);
                pomitlv.setAdapter(adapterpromit);
                adapterpromit.notifyDataSetChanged();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        loadpromittv()
        {
            this$0 = AppRecommendKeywordsActivity.this;
            super();
        }
    }


    public static int search1 = 0;
    private ApprecommendkeywordAdapter adapter;
    private AppsearchpromitAdapter adapterpromit;
    private AppListviewAdapter adapterresult;
    private String appkeywords;
    private int biaoshi;
    private BroadcastReceiver hideappsearch;
    private boolean isfa;
    private TextView lib_refresh;
    private List list;
    private List list2;
    private PullableListView_load listView;
    private ArrayList listresult;
    private LinearLayout ll_serch_refresh;
    private int myjpush;
    private NativeAd nativeAd;
    private int next;
    private int page;
    private ListView pomitlv;
    private ProgressWheel progressheel;
    private PullToRefreshLayout pulltoresult;
    private DeletableEditText search_view;
    private LImageButton searchfan;
    private String searchid;
    private LImageButton searchimg;
    private GridView serchgridview;
    private BroadcastReceiver showappsearch;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

    public AppRecommendKeywordsActivity()
    {
        showappsearch = new BroadcastReceiver() {

            final AppRecommendKeywordsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressheel.setVisibility(0);
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        };
        hideappsearch = new BroadcastReceiver() {

            final AppRecommendKeywordsActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressheel.setVisibility(8);
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        };
        appkeywords = "";
        listresult = new ArrayList();
        page = 1;
        next = 1;
        isfa = false;
        biaoshi = 1;
    }

    private void ShowResult(String s)
    {
        listresult.addAll(Myutils.parseApplist(s));
        if (page == 1)
        {
            adapterresult = new AppListviewAdapter(this, listresult, "appsearch", nativeAd);
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapterresult);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        adapterresult.notifyDataSetChanged();
        progressheel.setVisibility(8);
    }

    private void buildListener()
    {
        searchfan.setOnClickListener(this);
        serchgridview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppRecommendKeywordsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                try
                {
                    listresult.clear();
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview) { }
                try
                {
                    ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview) { }
                appkeywords = ((SearchkeywordModel)list.get(i)).getKeyword();
                search_view.setText(appkeywords.toString());
                Log.e("qwa", (new StringBuilder("appkeywords=")).append(appkeywords).toString());
                ((RelativeLayout)listView.findViewById(0x7f0701db)).setVisibility(8);
                (new Mya1()).execute(new Void[0]);
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        pomitlv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppRecommendKeywordsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                try
                {
                    listresult.clear();
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview) { }
                try
                {
                    ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
                    appkeywords = ((SearcherPromitModel)list2.get(i)).getS();
                    search_view.setText(appkeywords.toString());
                    ((RelativeLayout)listView.findViewById(0x7f0701db)).setVisibility(8);
                    (new Mya1()).execute(new Void[0]);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    return;
                }
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        search_view.setOnKeyListener(new android.view.View.OnKeyListener() {

            final AppRecommendKeywordsActivity this$0;

            public boolean onKey(View view, int i, KeyEvent keyevent)
            {
                try
                {
                    listresult.clear();
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                if (keyevent.getAction() == 0 && i == 66)
                {
                    try
                    {
                        ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view) { }
                    try
                    {
                        appkeywords = search_view.getText().toString();
                        ((RelativeLayout)listView.findViewById(0x7f0701db)).setVisibility(8);
                        (new Mya1()).execute(new Void[0]);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view) { }
                    try
                    {
                        (new Thread(new Runnable() {

                            final _cls8 this$1;

                            public void run()
                            {
                                String s = URLEncoder.encode(search_view.getText().toString());
                                publicTools.getUrl((new StringBuilder(String.valueOf("http://android.downloadatoz.com/_201409/market/hits.php?type=search&id=app&title="))).append(s).toString());
                            }

            
            {
                this$1 = _cls8.this;
                super();
            }
                        })).start();
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return false;
                    }
                }
                return false;
            }


            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        searchimg.setOnClickListener(new android.view.View.OnClickListener() {

            final AppRecommendKeywordsActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    listresult.clear();
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                try
                {
                    ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                if (!TextUtils.isEmpty(search_view.getText()))
                {
                    break MISSING_BLOCK_LABEL_125;
                }
                appkeywords = ((SearchkeywordModel)list.get(0)).getKeyword();
_L1:
                ((RelativeLayout)listView.findViewById(0x7f0701db)).setVisibility(8);
                (new Mya1()).execute(new Void[0]);
                return;
                try
                {
                    appkeywords = search_view.getText().toString();
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    return;
                }
                  goto _L1
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        search_view.addTextChangedListener(new TextWatcher() {

            final AppRecommendKeywordsActivity this$0;

            public void afterTextChanged(Editable editable)
            {
                Log.v("changetv", "333");
                if (TextUtils.isEmpty(search_view.getText()))
                {
                    serchgridview.setVisibility(0);
                    ll_serch_refresh.setVisibility(0);
                    pomitlv.setVisibility(8);
                    pulltoresult.setVisibility(8);
                }
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                Log.v("changetv", "111");
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                Log.e("changetv", "222");
                serchgridview.setVisibility(8);
                ll_serch_refresh.setVisibility(8);
                pulltoresult.setVisibility(8);
                (new loadpromittv()).execute(new Void[0]);
                pomitlv.setVisibility(0);
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
    }

    private void facebookad()
    {
        Object obj = View.inflate(getApplicationContext(), 0x7f03003e, null);
        listView.addHeaderView(((View) (obj)), null, false);
        obj = (ImageView)((View) (obj)).findViewById(0x7f0701a6);
        NativeAd.downloadAndDisplayImage(nativeAd.getAdCoverImage(), ((ImageView) (obj)));
        nativeAd.registerViewForInteraction(((View) (obj)));
    }

    private void init()
    {
        pomitlv = (ListView)findViewById(0x7f0703bd);
        searchfan = (LImageButton)findViewById(0x7f0702db);
        serchgridview = (GridView)findViewById(0x7f0702dd);
        progressheel = (ProgressWheel)findViewById(0x7f070072);
        search_view = (DeletableEditText)findViewById(0x7f0702dc);
        searchimg = (LImageButton)findViewById(0x7f07015c);
        pulltoresult = (PullToRefreshLayout)findViewById(0x7f070052);
        listView = (PullableListView_load)findViewById(0x7f07006f);
        lib_refresh = (TextView)findViewById(0x7f0703bc);
        lib_refresh.setOnClickListener(new android.view.View.OnClickListener() {

            final AppRecommendKeywordsActivity this$0;

            public void onClick(View view)
            {
                if (biaoshi == 5)
                {
                    biaoshi = 0;
                }
                AppRecommendKeywordsActivity.search1 = biaoshi * 10;
                (new loadingSearchKeywords()).execute(new Void[0]);
                view = AppRecommendKeywordsActivity.this;
                view.biaoshi = ((AppRecommendKeywordsActivity) (view)).biaoshi + 1;
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        ll_serch_refresh = (LinearLayout)findViewById(0x7f0703b8);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        list2 = new ArrayList();
        findViewById(0x7f0703b9).setOnClickListener(this);
        findViewById(0x7f0703ba).setOnClickListener(this);
        findViewById(0x7f0703bb).setOnClickListener(this);
        if (myjpush != 1)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        Log.e("jjj", (new StringBuilder("searchid=")).append(searchid).toString());
        search_view.setText(searchid.toString());
        pomitlv.setVisibility(0);
        serchgridview.setVisibility(8);
        ll_serch_refresh.setVisibility(8);
        Exception exception;
        try
        {
            listresult.clear();
        }
        catch (Exception exception1) { }
        (new Handler()).postDelayed(new Runnable() {

            final AppRecommendKeywordsActivity this$0;

            public void run()
            {
                ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        }, 500L);
        if (!TextUtils.isEmpty(search_view.getText()))
        {
            break MISSING_BLOCK_LABEL_387;
        }
        appkeywords = ((SearchkeywordModel)list.get(0)).getKeyword();
_L1:
        ((RelativeLayout)listView.findViewById(0x7f0701db)).setVisibility(8);
        (new Mya1()).execute(new Void[0]);
        return;
        try
        {
            appkeywords = search_view.getText().toString();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            return;
        }
          goto _L1
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAd == null || nativeAd != ad)
        {
            return;
        } else
        {
            nativeAd.unregisterView();
            facebookad();
            isfa = true;
            return;
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131165915: 
            try
            {
                ((InputMethodManager)search_view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(search_view.getWindowToken(), 0);
            }
            // Misplaced declaration of an exception variable
            catch (View view) { }
            if (pulltoresult.getVisibility() == 0)
            {
                pulltoresult.setVisibility(8);
                pomitlv.setVisibility(8);
                search_view.setText("");
                return;
            }
            if (myjpush == 0)
            {
                finish();
                return;
            } else
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                view.putExtra("acquire_url_start", "");
                startActivity(view);
                finish();
                return;
            }

        case 2131166137: 
            startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/GameActivity1));
            return;

        case 2131166138: 
            startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/MusthaveActivity));
            return;

        case 2131166139: 
            startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/PaidforFreeActivity1));
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300ae);
        myjpush = getIntent().getIntExtra("searchint", 0);
        try
        {
            searchid = getIntent().getStringExtra("searchid");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        init();
        buildListener();
        (new loadingSearchKeywords()).execute(new Void[0]);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppRecommendKeywordsActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(AppRecommendKeywordsActivity.this, com/aio/downloader/activity/AppDetailsActivity);
                if (!isfa)
                {
                    break MISSING_BLOCK_LABEL_59;
                }
                adapterview.putExtra("myid", ((DownloadMovieItem)listresult.get(i - 1)).getId());
_L1:
                startActivity(adapterview);
                return;
                try
                {
                    adapterview.putExtra("myid", ((DownloadMovieItem)listresult.get(i)).getId());
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    return;
                }
                  goto _L1
            }

            
            {
                this$0 = AppRecommendKeywordsActivity.this;
                super();
            }
        });
        nativeAd = new NativeAd(this, "340186902832477_418871114964055");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        bundle = new IntentFilter();
        bundle.addAction("showappsearch");
        registerReceiver(showappsearch, bundle);
        bundle = new IntentFilter();
        bundle.addAction("hideappsearch");
        registerReceiver(hideappsearch, bundle);
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (pulltoresult.getVisibility() == 0)
            {
                pulltoresult.setVisibility(8);
                pomitlv.setVisibility(8);
                search_view.setText("");
                return true;
            }
            finish();
        }
        return super.onKeyDown(i, keyevent);
    }

    public void onLoad(PullableListView_load pullablelistview_load)
    {
        if (listresult.size() > 0)
        {
            next = ((DownloadMovieItem)listresult.get(listresult.size() - 1)).getHas_next_page();
        }
        if (next == 1)
        {
            page = page + 1;
            (new Mya1()).execute(new Void[0]);
            return;
        } else
        {
            listView.setHasMoreData(false);
            return;
        }
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }
























}
