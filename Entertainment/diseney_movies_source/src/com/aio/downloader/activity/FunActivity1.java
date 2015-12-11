// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aio.downloader.fragments.FunTrendingFragment;
import com.aio.downloader.fragments.FunadultFragment;
import com.aio.downloader.fragments.FunallFragment;
import com.aio.downloader.fragments.FungagFragment;
import com.aio.downloader.fragments.FungifFragment;
import com.aio.downloader.fragments.FunpopularFragment;
import com.aio.downloader.fragments.FunvideoFragment;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.SharedPreferencesConfig;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.BadgeView;
import com.aio.downloader.views.LImageButton;
import com.aio.downloader.views.PagerSlidingTabStrip;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            DownloadAppManager, AppRecommendKeywordsActivity, AppDetailsActivity

public class FunActivity1 extends FragmentActivity
    implements android.view.View.OnClickListener, ContentValue, AdListener
{
    public class MyPagerAdapter extends FragmentPagerAdapter
    {

        private final String TITLES[] = {
            "new", "Trending", "Popular", "Adult", "Gag", "Gif", "Video"
        };
        final FunActivity1 this$0;

        public int getCount()
        {
            return TITLES.length;
        }

        public Fragment getItem(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 0: // '\0'
                return new FunallFragment();

            case 1: // '\001'
                return new FunTrendingFragment();

            case 2: // '\002'
                return new FunpopularFragment();

            case 3: // '\003'
                return new FunadultFragment();

            case 4: // '\004'
                return new FungagFragment();

            case 5: // '\005'
                return new FungifFragment();

            case 6: // '\006'
                return new FunvideoFragment();
            }
        }

        public CharSequence getPageTitle(int i)
        {
            return TITLES[i];
        }

        public MyPagerAdapter(FragmentManager fragmentmanager)
        {
            this$0 = FunActivity1.this;
            super(fragmentmanager);
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
    private AdView adView;
    private MyPagerAdapter adapter;
    private ImageView adulttopgift;
    private LImageButton adulttopsearch;
    private BroadcastReceiver app;
    private LinearLayout appbanner;
    private LImageButton appfan;
    private LImageButton apptodown;
    private BadgeView badgedownimg;
    private String banner_type_name;
    private FinalDBChen db;
    private List ds;
    private Handler handler;
    private boolean isfbshow;
    private TextView listtitle;
    private ImageView mAnimImageView;
    private Animation mAnimation;
    private int mRandom;
    private NativeAd nativeAdfb;
    PackageInfo packageInfo;
    private ViewPager pager;
    private publicTools pubTools;
    private SharedPreferences sp_config;
    PagerSlidingTabStrip tabs;
    TextView tagtitle;

    public FunActivity1()
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
        sp_config = null;
        isfbshow = false;
        handler = new Handler() {

            final FunActivity1 this$0;

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
                this$0 = FunActivity1.this;
                super();
            }
        };
        app = new BroadcastReceiver() {

            final FunActivity1 this$0;

            public void onReceive(Context context, Intent intent)
            {
                try
                {
                    db = new FinalDBChen(FunActivity1.this, getDatabasePath("download2.db").getAbsolutePath());
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
                this$0 = FunActivity1.this;
                super();
            }
        };
    }

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(adulttopgift);
    }

    private void init()
    {
        mAnimImageView = (ImageView)findViewById(0x7f070073);
        mAnimation = AnimationUtils.loadAnimation(this, 0x7f040007);
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final FunActivity1 this$0;

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
                this$0 = FunActivity1.this;
                super();
            }
        });
        listtitle = (TextView)findViewById(0x7f070099);
        listtitle.setText("Funny");
        adulttopsearch = (LImageButton)findViewById(0x7f070102);
        adulttopgift = (ImageView)findViewById(0x7f07006a);
        apptodown = (LImageButton)findViewById(0x7f070104);
        badgedownimg = new BadgeView(getApplicationContext(), apptodown);
        apptodown.setOnClickListener(new android.view.View.OnClickListener() {

            final FunActivity1 this$0;

            public void onClick(View view)
            {
                startActivity(new Intent(FunActivity1.this, com/aio/downloader/activity/DownloadAppManager));
            }

            
            {
                this$0 = FunActivity1.this;
                super();
            }
        });
        adulttopsearch.setOnClickListener(new android.view.View.OnClickListener() {

            final FunActivity1 this$0;

            public void onClick(View view)
            {
                startActivity(new Intent(FunActivity1.this, com/aio/downloader/activity/AppRecommendKeywordsActivity));
            }

            
            {
                this$0 = FunActivity1.this;
                super();
            }
        });
        adulttopgift.setOnClickListener(new android.view.View.OnClickListener() {

            final FunActivity1 this$0;

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

                        final _cls6 this$1;

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
                this$1 = _cls6.this;
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

                        final _cls6 this$1;

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
                this$1 = _cls6.this;
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

                        final _cls6 this$1;

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
                this$1 = _cls6.this;
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

                        final _cls6 this$1;

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
                this$1 = _cls6.this;
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
                this$0 = FunActivity1.this;
                super();
            }
        });
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
        switch (view.getId())
        {
        default:
            return;

        case 2131165437: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03004b);
        init();
        appfan = (LImageButton)findViewById(0x7f0700fd);
        tabs = (PagerSlidingTabStrip)findViewById(0x7f0701f9);
        pager = (ViewPager)findViewById(0x7f0701fa);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        int i = (int)TypedValue.applyDimension(1, 4F, getResources().getDisplayMetrics());
        pager.setPageMargin(i);
        i = getIntent().getIntExtra("current", 0);
        pager.setCurrentItem(i);
        tabs.setBackgroundColor(getResources().getColor(0x7f080033));
        appfan.setOnClickListener(this);
        appbanner = (LinearLayout)findViewById(0x7f070070);
        sp_config = getSharedPreferences("banner_type", 0);
        pubTools = new publicTools(this);
        banner_type_name = sp_config.getString("banner_type", "admob");
        if (banner_type_name.equals("admob"))
        {
            adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/5842010949");
            appbanner.addView(adView);
            adView.loadAd(new AdRequest());
        }
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        bundle = new IntentFilter();
        bundle.addAction("app");
        registerReceiver(app, bundle);
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return super.onKeyDown(i, keyevent);
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
            db = new FinalDBChen(this, getDatabasePath("download2.db").getAbsolutePath());
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

            final FunActivity1 this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 30000;
                handler.sendMessage(message);
            }

            
            {
                this$0 = FunActivity1.this;
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
