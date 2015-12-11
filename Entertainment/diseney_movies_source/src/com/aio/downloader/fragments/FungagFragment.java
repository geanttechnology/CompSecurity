// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.aio.downloader.adapter.FunAllAdapter;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.refresh.PullableListView_load;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.NativeAd;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

public class FungagFragment extends Fragment
    implements OnDismissCallback, ContentValue, AdListener, com.aio.downloader.refresh.PullableListView_load.OnLoadListener
{
    class Mya1 extends AsyncTask
    {

        private FunAllAdapter funlistviewadapter;
        final FungagFragment this$0;

        private void ShowResult(String s)
        {
            list.addAll(Myutils.funList(s));
            if (page == 1)
            {
                funlistviewadapter = new FunAllAdapter(getActivity(), list, nativeAd, fd_errer);
                swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(funlistviewadapter);
                swingBottomInAnimationAdapter.setListView(lv_fun_adult);
                lv_fun_adult.setAdapter(swingBottomInAnimationAdapter);
            }
            lv_fun_adult.setHasMoreData(true);
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl((new StringBuilder("http://welaf.com/fun/list.php?cat=gag&page=")).append(page).toString());
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            Log.e("www", (new StringBuilder("result=")).append(s).toString());
            if (s == null)
            {
                return;
            } else
            {
                ShowResult(s);
                progress_wheel_fun.setVisibility(8);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_wheel_fun.setVisibility(0);
        }

        Mya1()
        {
            this$0 = FungagFragment.this;
            super();
        }
    }


    private AdView adView;
    private boolean fd_errer;
    private ArrayList list;
    private PullableListView_load lv_fun_adult;
    private NativeAd nativeAd;
    private int next;
    private int page;
    private ProgressWheel progress_wheel_fun;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

    public FungagFragment()
    {
        list = new ArrayList();
        page = 1;
        next = 1;
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        fd_errer = true;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030048, null, false);
        lv_fun_adult = (PullableListView_load)layoutinflater.findViewById(0x7f0701f1);
        progress_wheel_fun = (ProgressWheel)layoutinflater.findViewById(0x7f0701f2);
        adView = new AdView(getActivity(), "340186902832477_411793852338448", AdSize.RECTANGLE_HEIGHT_250);
        nativeAd = new NativeAd(getActivity(), "340186902832477_411793852338448");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        lv_fun_adult.setOnLoadListener(this);
        lv_fun_adult.setHasMoreData(false);
        (new Mya1()).execute(new Void[0]);
        return layoutinflater;
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    public void onLoad(PullableListView_load pullablelistview_load)
    {
        Log.e("www", "onLoad");
        if (list.size() > 0)
        {
            next = ((FunModel)list.get(list.size() - 1)).getHas_next_page();
        }
        if (next == 1)
        {
            page = page + 1;
            (new Mya1()).execute(new Void[0]);
            return;
        } else
        {
            lv_fun_adult.setHasMoreData(false);
            return;
        }
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
