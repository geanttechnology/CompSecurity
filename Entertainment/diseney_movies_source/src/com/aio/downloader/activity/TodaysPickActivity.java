// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

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
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.aio.downloader.adapter.TodaypickListviewAdapter;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.refresh.PullableListView_load;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.SharedPreferencesConfig;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity, AppDetailsActivity, DownloadAppManager, AppRecommendKeywordsActivity

public class TodaysPickActivity extends BaseActivity
    implements android.view.View.OnClickListener, OnDismissCallback, ContentValue, AdListener, com.aio.downloader.refresh.PullableListView_load.OnLoadListener
{
    class Mya1 extends AsyncTask
    {

        final TodaysPickActivity this$0;
        private String url;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            if (todayid != null)
            {
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=rs&id=")).append(todayid).append("&page=").append(page).toString();
            } else
            {
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=")).append(page).toString();
            }
            return publicTools.getUrl(url);
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
            this$0 = TodaysPickActivity.this;
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
    private TodaypickListviewAdapter adapter;
    private ImageView adulttopgift;
    private LImageButton adulttopsearch;
    private LImageButton apptodown;
    private BadgeView badgedownimg;
    private FinalDBChen db;
    private List ds;
    private Handler handler;
    private BroadcastReceiver hidetodayapp;
    private boolean isfa;
    private boolean isfbshow;
    private boolean isshow;
    private ArrayList list;
    private int mRandom;
    private int myjpush;
    private NativeAd nativeAd;
    private NativeAd nativeAdfb;
    private int next;
    PackageInfo packageInfo;
    private int page;
    private ProgressWheel progressWheel;
    private BroadcastReceiver showtodayapp;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
    private Boolean todayboolean;
    private LImageButton todayfan;
    private String todayid;
    private PullableListView_load todaypicklv;

    public TodaysPickActivity()
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
        progressWheel = null;
        page = 1;
        next = 1;
        list = new ArrayList();
        todayboolean = Boolean.valueOf(false);
        isfbshow = false;
        isfa = false;
        isshow = false;
        handler = new Handler() {

            final TodaysPickActivity this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                if (message.what == 30000 && System.currentTimeMillis() > SharedPreferencesConfig.GetClickTime(getApplicationContext()))
                {
                    adulttopgift.setImageResource(0x7f0200d8);
                    message = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f04001e);
                    adulttopgift.startAnimation(message);
                }
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        };
        showtodayapp = new BroadcastReceiver() {

            final TodaysPickActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        };
        hidetodayapp = new BroadcastReceiver() {

            final TodaysPickActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        };
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parsetodaypick(s));
        if (page == 1)
        {
            adapter = new TodaypickListviewAdapter(this, list, "todaypick");
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(todaypicklv);
            todaypicklv.setAdapter(swingBottomInAnimationAdapter);
        }
        todaypicklv.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void buildListener()
    {
        todayfan.setOnClickListener(this);
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(adulttopgift);
    }

    private void facebookad_today()
    {
        Object obj = View.inflate(getApplicationContext(), 0x7f03003e, null);
        todaypicklv.addHeaderView(((View) (obj)), null, false);
        obj = (ImageView)((View) (obj)).findViewById(0x7f0701a6);
        NativeAd.downloadAndDisplayImage(nativeAd.getAdCoverImage(), ((ImageView) (obj)));
        nativeAd.registerViewForInteraction(((View) (obj)));
    }

    private void init()
    {
        adulttopsearch = (LImageButton)findViewById(0x7f070102);
        adulttopgift = (ImageView)findViewById(0x7f07006a);
        apptodown = (LImageButton)findViewById(0x7f070104);
        badgedownimg = new BadgeView(getApplicationContext(), apptodown);
        apptodown.setOnClickListener(new android.view.View.OnClickListener() {

            final TodaysPickActivity this$0;

            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager));
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        });
        adulttopsearch.setOnClickListener(new android.view.View.OnClickListener() {

            final TodaysPickActivity this$0;

            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/AppRecommendKeywordsActivity));
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        });
        adulttopgift.setOnClickListener(new android.view.View.OnClickListener() {

            final TodaysPickActivity this$0;

            public void onClick(View view)
            {
                SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
                adulttopgift.setImageResource(0x7f0200d7);
                if (isfbshow) goto _L2; else goto _L1
_L1:
                mRandom = (int)(Math.random() * 4D) + 1;
                if (mRandom != 1) goto _L4; else goto _L3
_L3:
                try
                {
                    packageInfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (packageInfo != null) goto _L6; else goto _L5
_L5:
                if (!PRO_DIR_FOME.exists()) goto _L8; else goto _L7
_L7:
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
_L2:
                return;
_L8:
                if (PRO_DIR_TO.exists())
                {
                    (new AsyncTask() {

                        final _cls7 this$1;

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
                this$1 = _cls7.this;
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
_L6:
                view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
_L4:
                if (mRandom != 2)
                {
                    break MISSING_BLOCK_LABEL_539;
                }
                try
                {
                    packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (packageInfo != null)
                {
                    break MISSING_BLOCK_LABEL_517;
                }
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

                        final _cls7 this$1;

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
                this$1 = _cls7.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.freepezzle.hexcrush");
                startActivity(view);
                return;
                view = getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush");
                startActivity(view);
                return;
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
                if (packageInfo != null)
                {
                    break MISSING_BLOCK_LABEL_779;
                }
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

                        final _cls7 this$1;

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
                this$1 = _cls7.this;
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
                view = getPackageManager().getLaunchIntentForPackage("com.allinone.callerid");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
                if (mRandom != 4) goto _L2; else goto _L9
_L9:
                try
                {
                    packageInfo = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (packageInfo != null)
                {
                    break MISSING_BLOCK_LABEL_1048;
                }
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

                        final _cls7 this$1;

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
                this$1 = _cls7.this;
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
                view = getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }


            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        });
        todayfan = (LImageButton)findViewById(0x7f0703cd);
        todaypicklv = (PullableListView_load)findViewById(0x7f0703ce);
        progressWheel = (ProgressWheel)findViewById(0x7f070072);
        todaypicklv.setOnLoadListener(this);
        todaypicklv.setHasMoreData(false);
        (new Mya1()).execute(new Void[0]);
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
        SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
        adulttopgift.setImageResource(0x7f0200d7);
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAdfb != ad) goto _L2; else goto _L1
_L1:
        if (nativeAdfb != null && nativeAdfb == ad) goto _L4; else goto _L3
_L3:
        return;
_L4:
        nativeAdfb.unregisterView();
        facebookad();
        isfbshow = true;
        return;
_L2:
        if (nativeAd == ad && nativeAd != null && nativeAd == ad)
        {
            nativeAd.unregisterView();
            try
            {
                facebookad_today();
            }
            // Misplaced declaration of an exception variable
            catch (Ad ad) { }
            isfa = true;
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131166157: 
            break;
        }
        if (todayboolean.booleanValue() || myjpush == 1)
        {
            view = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
            view.putExtra("acquire_url_start", "");
            startActivity(view);
            finish();
            return;
        } else
        {
            finish();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b3);
        try
        {
            todayid = getIntent().getStringExtra("todayid");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        try
        {
            todayboolean = Boolean.valueOf(getIntent().getBooleanExtra("todayboolean", false));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        myjpush = getIntent().getIntExtra("myjpush", 0);
        init();
        buildListener();
        nativeAdfb = new NativeAd(getApplicationContext(), "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        nativeAd = new NativeAd(getApplicationContext(), "340186902832477_388101491374351");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        bundle = new IntentFilter();
        bundle.addAction("showtodayapp");
        registerReceiver(showtodayapp, bundle);
        bundle = new IntentFilter();
        bundle.addAction("hidetodayapp");
        registerReceiver(hidetodayapp, bundle);
        todaypicklv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final TodaysPickActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = new Intent(TodaysPickActivity.this, com/aio/downloader/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)list.get(i)).getId());
                startActivity(adapterview);
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        });
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
            if (myjpush == 1)
            {
                Intent intent = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                intent.putExtra("acquire_url_start", "");
                startActivity(intent);
                finish();
            } else
            {
                finish();
            }
        }
        return super.onKeyDown(i, keyevent);
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
            todaypicklv.setHasMoreData(false);
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
        int i;
        try
        {
            db = new FinalDBChen(getApplicationContext(), getDatabasePath("download2.db").getAbsolutePath());
            ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
        }
        catch (Exception exception) { }
        i = ds.size();
        if (i == 0) goto _L2; else goto _L1
_L1:
        badgedownimg.setText(String.valueOf(i));
        badgedownimg.show();
_L4:
        (new Timer()).schedule(new TimerTask() {

            final TodaysPickActivity this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 30000;
                handler.sendMessage(message);
            }

            
            {
                this$0 = TodaysPickActivity.this;
                super();
            }
        }, 3000L, 10000L);
        return;
_L2:
        if (i == 0)
        {
            badgedownimg.hide();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }



















}
