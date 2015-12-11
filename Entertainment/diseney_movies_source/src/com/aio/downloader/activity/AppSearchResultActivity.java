// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.adapter.AppListviewAdapter;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.refresh.PullableListView_load;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.BadgeView;
import com.aio.downloader.views.LImageButton;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            AppRecommendKeywordsActivity, AppDetailsActivity, DownloadAppManager

public class AppSearchResultActivity extends Activity
    implements com.aio.downloader.refresh.PullableListView_load.OnLoadListener, OnDismissCallback, android.view.View.OnClickListener, ContentValue, AdListener
{
    class Mya1 extends AsyncTask
    {

        final AppSearchResultActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            try
            {
                searchkeywords = URLEncoder.encode(searchkeywords);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[]) { }
            return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword=")).append(searchkeywords).append("&page=").append(page).toString());
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
                ShowResult(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya1()
        {
            this$0 = AppSearchResultActivity.this;
            super();
        }
    }


    private File AIOBATTERY;
    private File AIOBATTERYAPK;
    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private AppListviewAdapter adapter;
    private RelativeLayout appsearchtop;
    private BadgeView badgedownimg;
    private FinalDBChen db;
    private List ds;
    private BroadcastReceiver hideappsearch;
    private String imbdownurl;
    private boolean isfbshow;
    private boolean isshowinmobi;
    private ArrayList list;
    private PullableListView_load listView;
    private ImageView mAnimImageView;
    private Animation mAnimation;
    private int mRandom;
    private NativeAd nativeAdfb;
    private int next;
    PackageInfo packageInfo;
    private int page;
    private ProgressWheel progressWheel;
    private LImageButton resultsearchimg;
    private LImageButton resulttodown;
    private ImageView resulttopgift;
    private ImageView searchfan;
    private String searchkeywords;
    private TextView searchtitle;
    private BroadcastReceiver showappsearch;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

    public AppSearchResultActivity()
    {
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
        AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
        AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
        mRandom = 0;
        packageInfo = null;
        showappsearch = new BroadcastReceiver() {

            final AppSearchResultActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
        };
        hideappsearch = new BroadcastReceiver() {

            final AppSearchResultActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
                try
                {
                    db = new FinalDBChen(AppSearchResultActivity.this, getDatabasePath("download2.db").getAbsolutePath());
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
                    (new AsyncTask() {

                        final _cls2 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient String doInBackground(Void avoid[])
                        {
                            return String.valueOf(ds.size());
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((String)obj);
                        }

                        protected void onPostExecute(String s)
                        {
                            super.onPostExecute(s);
                            mAnimImageView.setVisibility(0);
                            mAnimImageView.startAnimation(mAnimation);
                            badgedownimg.setText(s);
                            badgedownimg.show();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return;
                }
            }


            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
        };
        list = new ArrayList();
        progressWheel = null;
        page = 1;
        next = 1;
        searchkeywords = "";
        isfbshow = false;
        isshowinmobi = false;
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parseApplist(s));
        if (page == 1)
        {
            adapter = new AppListviewAdapter(this, list, "appsearch", nativeAdfb);
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void buildListener()
    {
        searchfan.setOnClickListener(this);
        resultsearchimg.setOnClickListener(this);
        resulttopgift.setOnClickListener(this);
        resulttodown.setOnClickListener(this);
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(resulttopgift);
    }

    private void init()
    {
        mAnimImageView = (ImageView)findViewById(0x7f070073);
        resulttodown = (LImageButton)findViewById(0x7f0703c1);
        mAnimation = AnimationUtils.loadAnimation(this, 0x7f040007);
        badgedownimg = new BadgeView(getApplicationContext(), resulttodown);
        searchtitle = (TextView)findViewById(0x7f0703b7);
        searchfan = (ImageView)findViewById(0x7f0702db);
        resultsearchimg = (LImageButton)findViewById(0x7f0703bf);
        resulttopgift = (ImageView)findViewById(0x7f0703c0);
        searchkeywords = getIntent().getStringExtra("searchkeywords");
        searchtitle.setText(searchkeywords);
        progressWheel = (ProgressWheel)findViewById(0x7f070072);
        listView = (PullableListView_load)findViewById(0x7f07006f);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final AppSearchResultActivity this$0;

            public void onAnimationEnd(Animation animation)
            {
                mAnimImageView.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
        });
        (new Mya1()).execute(new Void[0]);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final AppSearchResultActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(AppSearchResultActivity.this, com/aio/downloader/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)list.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
        });
        appsearchtop = (RelativeLayout)findViewById(0x7f0701d9);
    }

    public long getFileSizes(File file)
        throws Exception
    {
        if (file.exists())
        {
            return (long)(new FileInputStream(file)).available();
        } else
        {
            file.createNewFile();
            return 0L;
        }
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAdfb == null || nativeAdfb != ad)
        {
            return;
        } else
        {
            nativeAdfb.unregisterView();
            facebookad();
            isfbshow = true;
            return;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131165915: 49
    //                   2131166143: 54
    //                   2131166144: 70
    //                   2131166145: 987;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        finish();
        return;
_L3:
        startActivity(new Intent(this, com/aio/downloader/activity/AppRecommendKeywordsActivity));
        return;
_L4:
        if (isfbshow)
        {
            Toast.makeText(getApplicationContext(), "facebook", 1).show();
            return;
        }
        mRandom = (int)(Math.random() * 4D) + 1;
        if (mRandom == 1)
        {
            try
            {
                packageInfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            if (packageInfo == null)
            {
                if (PRO_DIR_FOME.exists())
                {
                    view = new Intent("android.intent.action.VIEW");
                    view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                    view.addFlags(0x10000000);
                    startActivity(view);
                    return;
                }
                if (PRO_DIR_TO.exists())
                {
                    (new AsyncTask() {

                        final AppSearchResultActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(PRO_DIR_TO, PRO_DIR_FOME, Boolean.valueOf(false));
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            void1 = new Intent("android.intent.action.VIEW");
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            startActivity(void1);
                        }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                } else
                {
                    view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                    view.putExtra("myid", "com.evzapp.cleanmaster");
                    view.addFlags(0x10000000);
                    startActivity(view);
                    return;
                }
            } else
            {
                view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }
        }
        if (mRandom != 2) goto _L7; else goto _L6
_L6:
        try
        {
            packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo != null) goto _L9; else goto _L8
_L8:
        try
        {
            if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                startActivity(view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
        {
            (new AsyncTask() {

                final AppSearchResultActivity this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    void1 = new Intent("android.intent.action.VIEW");
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                    startActivity(void1);
                }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.freepezzle.hexcrush");
        startActivity(view);
        return;
_L9:
        startActivity(getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush"));
        return;
_L7:
        if (mRandom != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.allinone.callerid", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo != null) goto _L11; else goto _L10
_L10:
        try
        {
            if (AIOCALLERAPK.exists() && getFileSizes(AIOCALLERAPK) >= 0x357458L)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x357458L)
        {
            (new AsyncTask() {

                final AppSearchResultActivity this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOCALLERDOWN, AIOCALLERAPK, Boolean.valueOf(false));
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    void1 = new Intent("android.intent.action.VIEW");
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    startActivity(void1);
                }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.allinone.callerid");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L11:
        view = getPackageManager().getLaunchIntentForPackage("com.allinone.callerid");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
        if (mRandom != 4) goto _L1; else goto _L12
_L12:
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo != null) goto _L14; else goto _L13
_L13:
        try
        {
            if (AIOBATTERYAPK.exists() && getFileSizes(AIOBATTERYAPK) >= 0x377effL)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        if (AIOBATTERY.exists() && getFileSizes(AIOBATTERY) >= 0x377effL)
        {
            (new AsyncTask() {

                final AppSearchResultActivity this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOBATTERY, AIOBATTERYAPK, Boolean.valueOf(false));
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    void1 = new Intent("android.intent.action.VIEW");
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    startActivity(void1);
                }

            
            {
                this$0 = AppSearchResultActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.aioapp.battery");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L14:
        view = getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L5:
        startActivity(new Intent(this, com/aio/downloader/activity/DownloadAppManager));
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300af);
        init();
        buildListener();
        bundle = new IntentFilter();
        bundle.addAction("showappsearch");
        registerReceiver(showappsearch, bundle);
        bundle = new IntentFilter();
        bundle.addAction("hideappsearch");
        registerReceiver(hideappsearch, bundle);
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    public void onLoad(PullableListView_load pullablelistview_load)
    {
        if (list.size() > 0)
        {
            next = ((DownloadMovieItem)list.get(list.size() - 1)).getHas_next_page();
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

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
        MobclickAgent.onResume(this);
        db = new FinalDBChen(this, getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
        int i = ds.size();
        if (i != 0)
        {
            badgedownimg.setText(String.valueOf(i));
            badgedownimg.show();
        } else
        if (i == 0)
        {
            badgedownimg.hide();
            return;
        }
    }






















}
