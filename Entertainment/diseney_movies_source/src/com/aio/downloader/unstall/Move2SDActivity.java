// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.unstall;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
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
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.unstall:
//            Move2SDAdapter, Info

public class Move2SDActivity extends Activity
    implements AdListener
{

    AdView adView;
    private Move2SDAdapter adapter;
    LinearLayout adviewscanner;
    private LImageButton header_left_uninstall;
    private List infos;
    private boolean isfa;
    private boolean isshow;
    private ListView lv_uninstall;
    private NativeAd nativeAd;
    private TextView tv_title_uninstall;

    public Move2SDActivity()
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
        PackageManager packagemanager;
        List list;
        int i;
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
        tv_title_uninstall.setText("Move2SD");
        header_left_uninstall = (LImageButton)findViewById(0x7f0703d9);
        header_left_uninstall.setOnClickListener(new android.view.View.OnClickListener() {

            final Move2SDActivity this$0;

            public void onClick(View view)
            {
                finish();
            }

            
            {
                this$0 = Move2SDActivity.this;
                super();
            }
        });
        packagemanager = getPackageManager();
        list = packagemanager.getInstalledApplications(8192);
        bundle = null;
        i = 0;
_L5:
        if (i < list.size()) goto _L2; else goto _L1
_L1:
        Log.e("qqq", (new StringBuilder("infos.size()=")).append(infos.size()).toString());
        i = 0;
_L7:
        if (i >= infos.size())
        {
            adapter = new Move2SDAdapter(this, infos);
            bundle = new SwingBottomInAnimationAdapter(adapter);
            bundle.setListView(lv_uninstall);
            lv_uninstall.setAdapter(bundle);
            return;
        }
        break MISSING_BLOCK_LABEL_586;
_L2:
        Object obj;
        obj = (ApplicationInfo)list.get(i);
        obj = bundle;
        if ((((ApplicationInfo)list.get(i)).flags & 1) != 0) goto _L4; else goto _L3
_L3:
        Info info;
        info = new Info();
        info.setName(packagemanager.getApplicationLabel((ApplicationInfo)list.get(i)).toString());
        info.setIcon(((ApplicationInfo)list.get(i)).loadIcon(packagemanager));
        info.setPackagename(((ApplicationInfo)list.get(i)).packageName);
        obj = packagemanager.getApplicationInfo(((ApplicationInfo)list.get(i)).packageName, 0);
        bundle = ((Bundle) (obj));
_L6:
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        if ((((ApplicationInfo) (bundle)).flags & 0x40000) != 0)
        {
            Log.e("qqq", (new StringBuilder("infos.size()=")).append(infos.size()).toString());
        } else
        if (!((ApplicationInfo)list.get(i)).packageName.equals("com.aio.downloader") && !((ApplicationInfo)list.get(i)).packageName.equals("com.evzapp.cleanmaster"))
        {
            infos.add(info);
        }
        System.out.println((new StringBuilder(String.valueOf(((ApplicationInfo)list.get(i)).sourceDir))).append("============").toString());
        obj = bundle;
_L4:
        i++;
        bundle = ((Bundle) (obj));
          goto _L5
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L6
        System.out.println(((Info)infos.get(i)).getPackagename());
        i++;
          goto _L7
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
        MobclickAgent.onResume(this);
        super.onResume();
    }
}
