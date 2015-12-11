// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.aio.downloader.adapter.UndateAdapter;
import com.aio.downloader.model.AppInfo;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.Updatesize;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateActivity extends Activity
    implements android.view.View.OnClickListener, AdListener
{
    class Mya6 extends AsyncTask
    {

        final UpdateActivity this$0;
        private String url1;

        private void ShowResult7(String s)
        {
            progress_wheel.setVisibility(8);
            list_update.addAll(Myutils.parseupdata(s));
            if (Myutils.status == 1)
            {
                Log.e("update", (new StringBuilder(String.valueOf(list_update.size()))).toString());
                s = new UndateAdapter(getApplicationContext(), list_update);
                lv_uninstall.setAdapter(s);
                return;
            } else
            {
                ll_downnull.setVisibility(0);
                iv_ioio.setImageResource(0x7f040006);
                animationDrawable = (AnimationDrawable)iv_ioio.getDrawable();
                animationDrawable.start();
                return;
            }
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            Log.e("update", (new StringBuilder(String.valueOf(upJsonStr))).append("===").toString());
            return upJsonStr;
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
                Log.e("update", (new StringBuilder("result=")).append(s).toString());
                ShowResult7(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel.setVisibility(0);
        }

        Mya6()
        {
            this$0 = UpdateActivity.this;
            super();
        }
    }


    AdView adView;
    private LinearLayout adviewscanner;
    private AnimationDrawable animationDrawable;
    private Handler appHandler;
    private String dEVICE_ID;
    private boolean isfa;
    private boolean isshow;
    private ImageView iv_ioio;
    private JSONArray jsonArray;
    ArrayList list_update;
    private LinearLayout ll_downnull;
    private ListView lv_uninstall;
    public List mListInfo;
    private NativeAd nativeAd;
    private NativeAd nativeAdgift;
    private ProgressWheel progress_wheel;
    private TextView tv_title_uninstall;
    private String upJsonStr;
    private int updatesize;

    public UpdateActivity()
    {
        mListInfo = new ArrayList();
        list_update = new ArrayList();
        appHandler = new Handler() {

            final UpdateActivity this$0;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 1001 1001: default 24
            //                           1001 30;
                   goto _L1 _L2
_L1:
                super.handleMessage(message);
                return;
_L2:
                (new Mya6()).execute(new Void[0]);
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = UpdateActivity.this;
                super();
            }
        };
        isfa = false;
        isshow = false;
    }

    private void facebookad()
    {
        Object obj = View.inflate(getApplicationContext(), 0x7f03003e, null);
        lv_uninstall.addHeaderView(((View) (obj)), null, false);
        obj = (ImageView)((View) (obj)).findViewById(0x7f0701a6);
        NativeAd.downloadAndDisplayImage(nativeAd.getAdCoverImage(), ((ImageView) (obj)));
        nativeAd.registerViewForInteraction(((View) (obj)));
    }

    private void getNewApps()
    {
        (new Thread(new Runnable() {

            final UpdateActivity this$0;

            public void run()
            {
                String s = Uri.encode(Build.MODEL);
                Object obj = new HashMap();
                try
                {
                    ((HashMap) (obj)).put("content", jsonArray.toString());
                    ((HashMap) (obj)).put("ucode", dEVICE_ID);
                    ((HashMap) (obj)).put("os_version", android.os.Build.VERSION.RELEASE);
                    ((HashMap) (obj)).put("source", "aio");
                    ((HashMap) (obj)).put("device", s);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                upJsonStr = Myutils.doHttpPost("http://android.downloadatoz.com/_201409/market/app_version_check.php", ((HashMap) (obj)));
                Log.e("update", (new StringBuilder(String.valueOf(upJsonStr))).toString());
                obj = new Message();
                obj.obj = upJsonStr;
                obj.what = 1001;
                appHandler.sendMessage(((Message) (obj)));
            }

            
            {
                this$0 = UpdateActivity.this;
                super();
            }
        })).start();
    }

    private void init()
    {
        findViewById(0x7f0703d9).setOnClickListener(this);
        tv_title_uninstall = (TextView)findViewById(0x7f070182);
        lv_uninstall = (ListView)findViewById(0x7f0703da);
        adviewscanner = (LinearLayout)findViewById(0x7f0703dd);
        progress_wheel = (ProgressWheel)findViewById(0x7f070072);
        progress_wheel.setVisibility(0);
        tv_title_uninstall.setText("Update");
        ll_downnull = (LinearLayout)findViewById(0x7f07018b);
        iv_ioio = (ImageView)findViewById(0x7f07018d);
    }

    public void getAllAppInfo()
    {
        PackageManager packagemanager = getPackageManager();
        List list = packagemanager.getInstalledPackages(0);
        jsonArray = new JSONArray();
        new Build();
        new HashMap();
        int i = 0;
        do
        {
            if (i >= list.size())
            {
                Log.e("update", (new StringBuilder(String.valueOf(mListInfo.size()))).toString());
                Log.e("update", (new StringBuilder("jsonArray=")).append(jsonArray).toString());
                return;
            }
            JSONObject jsonobject = new JSONObject();
            AppInfo appinfo = new AppInfo();
            PackageInfo packageinfo = (PackageInfo)list.get(i);
            ApplicationInfo applicationinfo = packageinfo.applicationInfo;
            if ((applicationinfo.flags & 1) <= 0)
            {
                String s = packagemanager.getApplicationLabel(applicationinfo).toString();
                String s1 = packageinfo.packageName;
                String s2 = packageinfo.versionName;
                Log.i("appname", (new StringBuilder()).append(packagemanager.getApplicationLabel(applicationinfo)).append(packageinfo.packageName).toString());
                appinfo.setAppname(s);
                appinfo.setP_name(s1);
                appinfo.setAvatar(packagemanager.getApplicationIcon(applicationinfo));
                appinfo.setVersion(s2);
                mListInfo.add(appinfo);
                try
                {
                    jsonobject.put("title", s);
                    jsonobject.put("url_id", s1);
                    jsonobject.put("version", s2);
                    jsonobject.put("install_time", System.currentTimeMillis() / 1000L);
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
                jsonArray.put(jsonobject);
            }
            i++;
        } while (true);
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAdgift != ad) goto _L2; else goto _L1
_L1:
        if (nativeAdgift != null && nativeAdgift == ad) goto _L4; else goto _L3
_L3:
        return;
_L4:
        nativeAdgift.unregisterView();
        nativeAdgift.registerViewForInteraction(ll_downnull);
        return;
_L2:
        if (nativeAd == ad && nativeAd != null && nativeAd == ad)
        {
            nativeAd.unregisterView();
            try
            {
                facebookad();
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

        case 2131166169: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b6);
        init();
        adviewscanner = (LinearLayout)findViewById(0x7f0703dd);
        adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/5842010949");
        adviewscanner.addView(adView);
        adView.loadAd(new AdRequest());
        nativeAd = new NativeAd(getApplicationContext(), "340186902832477_388101491374351");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        updatesize = Updatesize.getUpdatesize().list_update.size();
        if (updatesize > 0)
        {
            if (Myutils.status == 1)
            {
                Log.e("update", (new StringBuilder(String.valueOf(list_update.size()))).toString());
                progress_wheel.setVisibility(8);
                bundle = new UndateAdapter(getApplicationContext(), Updatesize.getUpdatesize().list_update);
                lv_uninstall.setAdapter(bundle);
            } else
            {
                ll_downnull.setVisibility(0);
                iv_ioio.setImageResource(0x7f040006);
                animationDrawable = (AnimationDrawable)iv_ioio.getDrawable();
                animationDrawable.start();
            }
        } else
        {
            progress_wheel.setVisibility(8);
            ll_downnull.setVisibility(0);
            iv_ioio.setImageResource(0x7f040006);
            animationDrawable = (AnimationDrawable)iv_ioio.getDrawable();
            animationDrawable.start();
        }
        nativeAdgift = new NativeAd(getApplicationContext(), "340186902832477_436045659913267");
        nativeAdgift.setAdListener(this);
        nativeAdgift.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
    }

    public void onError(Ad ad, AdError aderror)
    {
    }











}
