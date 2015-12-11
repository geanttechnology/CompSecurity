// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.aio.downloader.unstall.BackupAdapter;
import com.aio.downloader.unstall.Info;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.stericson.RootTools.RootTools;
import com.umeng.analytics.MobclickAgent;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BackupAvailableFragment extends Fragment
    implements AdListener
{

    AdView adView;
    private BackupAdapter adapter;
    LinearLayout adviewscanner;
    private List infos;
    private ListView lv_uninstall;
    private NativeAd nativeAd;

    public BackupAvailableFragment()
    {
        infos = new ArrayList();
    }

    private void facebookad()
    {
        Object obj = View.inflate(getActivity(), 0x7f03003e, null);
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
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Ad ad)
        {
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        PackageManager packagemanager;
        List list;
        int i;
        bundle = layoutinflater.inflate(0x7f0300b6, null, false);
        adviewscanner = (LinearLayout)bundle.findViewById(0x7f0703dd);
        adView = new AdView(getActivity(), AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/5842010949");
        adviewscanner.addView(adView);
        adView.loadAd(new AdRequest());
        nativeAd = new NativeAd(getActivity(), "340186902832477_388101491374351");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        ((LinearLayout)bundle.findViewById(0x7f0703d8)).setVisibility(8);
        lv_uninstall = (ListView)bundle.findViewById(0x7f0703da);
        layoutinflater = (LinearLayout)bundle.findViewById(0x7f0703dc);
        if (RootTools.isRootAvailable())
        {
            lv_uninstall.setVisibility(0);
            layoutinflater.setVisibility(8);
        } else
        {
            lv_uninstall.setVisibility(8);
            layoutinflater.setVisibility(0);
        }
        packagemanager = getActivity().getPackageManager();
        list = packagemanager.getInstalledApplications(8192);
        layoutinflater = null;
        i = 0;
_L5:
        if (i < list.size()) goto _L2; else goto _L1
_L1:
        Log.e("qqq", (new StringBuilder("infos.size()=")).append(infos.size()).toString());
        i = 0;
_L7:
        if (i >= infos.size())
        {
            adapter = new BackupAdapter(getActivity(), infos);
            layoutinflater = new SwingBottomInAnimationAdapter(adapter);
            layoutinflater.setListView(lv_uninstall);
            lv_uninstall.setAdapter(layoutinflater);
            return bundle;
        }
        break MISSING_BLOCK_LABEL_610;
_L2:
        viewgroup = (ApplicationInfo)list.get(i);
        viewgroup = layoutinflater;
        if ((((ApplicationInfo)list.get(i)).flags & 1) != 0) goto _L4; else goto _L3
_L3:
        Info info;
        info = new Info();
        info.setName(packagemanager.getApplicationLabel((ApplicationInfo)list.get(i)).toString());
        info.setIcon(((ApplicationInfo)list.get(i)).loadIcon(packagemanager));
        info.setPackagename(((ApplicationInfo)list.get(i)).packageName);
        viewgroup = packagemanager.getApplicationInfo(((ApplicationInfo)list.get(i)).packageName, 0);
        layoutinflater = viewgroup;
_L6:
        if ((((ApplicationInfo) (layoutinflater)).flags & 0x40000) != 0)
        {
            Log.e("qqq", (new StringBuilder("infos.size()=")).append(infos.size()).toString());
        } else
        if (!((ApplicationInfo)list.get(i)).packageName.equals("com.aio.downloader") && !((ApplicationInfo)list.get(i)).packageName.equals("com.evzapp.cleanmaster"))
        {
            infos.add(info);
        }
        System.out.println((new StringBuilder(String.valueOf(((ApplicationInfo)list.get(i)).sourceDir))).append("============").toString());
        viewgroup = layoutinflater;
_L4:
        i++;
        layoutinflater = viewgroup;
          goto _L5
        viewgroup;
        viewgroup.printStackTrace();
          goto _L6
        System.out.println(((Info)infos.get(i)).getPackagename());
        i++;
          goto _L7
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }
}
