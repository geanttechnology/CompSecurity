// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.aio.downloader.views.LImageButton;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.unstall:
//            MyAppAdapter, Info

public class MyAppActivity extends Activity
    implements AdListener
{

    AdView adView;
    private MyAppAdapter adapter;
    LinearLayout adviewscanner;
    private LImageButton header_left_uninstall;
    private List infos;
    private boolean isfa;
    private boolean isshow;
    private ListView lv_uninstall;
    private NativeAd nativeAd;
    private TextView tv_title_uninstall;

    public MyAppActivity()
    {
        infos = new ArrayList();
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

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAd == null || nativeAd != ad)
        {
            return;
        }
        nativeAd.unregisterView();
        try
        {
            facebookad();
        }
        // Misplaced declaration of an exception variable
        catch (Ad ad) { }
        isfa = true;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b6);
        adviewscanner = (LinearLayout)findViewById(0x7f0703dd);
        adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/5842010949");
        adviewscanner.addView(adView);
        adView.loadAd(new AdRequest());
        nativeAd = new NativeAd(getApplicationContext(), "340186902832477_388101491374351");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        lv_uninstall = (ListView)findViewById(0x7f0703da);
        tv_title_uninstall = (TextView)findViewById(0x7f070182);
        tv_title_uninstall.setText("My apps");
        header_left_uninstall = (LImageButton)findViewById(0x7f0703d9);
        header_left_uninstall.setOnClickListener(new android.view.View.OnClickListener() {

            final MyAppActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = MyAppActivity.this;
                super();
            }
        });
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        PackageManager packagemanager;
        List list;
        int i;
        infos.clear();
        packagemanager = getPackageManager();
        list = packagemanager.getInstalledApplications(8192);
        i = 0;
_L3:
        if (i < list.size()) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        if (i >= infos.size())
        {
            adapter = new MyAppAdapter(this, infos);
            lv_uninstall.setAdapter(adapter);
            MobclickAgent.onResume(this);
            super.onResume();
            return;
        }
        break MISSING_BLOCK_LABEL_294;
_L2:
        ApplicationInfo applicationinfo = (ApplicationInfo)list.get(i);
        if ((((ApplicationInfo)list.get(i)).flags & 1) == 0)
        {
            Info info = new Info();
            info.setName(packagemanager.getApplicationLabel((ApplicationInfo)list.get(i)).toString());
            info.setIcon(((ApplicationInfo)list.get(i)).loadIcon(packagemanager));
            info.setPackagename(((ApplicationInfo)list.get(i)).packageName);
            if (!((ApplicationInfo)list.get(i)).packageName.equals("com.aio.downloader") && !((ApplicationInfo)list.get(i)).packageName.equals("com.evzapp.cleanmaster"))
            {
                infos.add(info);
            }
            System.out.println((new StringBuilder(String.valueOf(((ApplicationInfo)list.get(i)).sourceDir))).append("============").toString());
        }
        i++;
          goto _L3
        System.out.println(((Info)infos.get(i)).getPackagename());
        i++;
          goto _L4
    }
}
