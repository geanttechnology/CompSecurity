// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.aio.downloader.adapter.Home_app_Listview_Adapter;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.refresh.PullableListView_load;
import com.aio.downloader.utils.DisplayUtil;
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
import java.util.Locale;

public class AppFeaturedFragment extends Fragment
    implements com.aio.downloader.refresh.PullableListView_load.OnLoadListener, OnDismissCallback, ContentValue, AdListener
{
    class Mya1 extends AsyncTask
    {

        final AppFeaturedFragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=app&page=")).append(page).toString());
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
            this$0 = AppFeaturedFragment.this;
            super();
        }
    }

    class Mya3 extends AsyncTask
    {

        final AppFeaturedFragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl("http://welaf.com/fun/list.php?tab=random&page=1");
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
                ShowResult1(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya3()
        {
            this$0 = AppFeaturedFragment.this;
            super();
        }
    }


    private AdView adView;
    private Home_app_Listview_Adapter adapter;
    private Bitmap bitmap;
    private LinearLayout facebookbanner;
    private int h;
    private BroadcastReceiver hideapp1;
    private ImageView imginmobibanner;
    private LinearLayout inmobbanner;
    private boolean isfa;
    private boolean isshow;
    private ArrayList list;
    private PullableListView_load listView;
    ArrayList list_fun;
    private NativeAd nativeAd;
    private int next;
    private int page;
    private ProgressWheel progressWheel;
    private BroadcastReceiver showapp1;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
    private int w;

    public AppFeaturedFragment()
    {
        showapp1 = new BroadcastReceiver() {

            final AppFeaturedFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = AppFeaturedFragment.this;
                super();
            }
        };
        hideapp1 = new BroadcastReceiver() {

            final AppFeaturedFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
            }

            
            {
                this$0 = AppFeaturedFragment.this;
                super();
            }
        };
        list = new ArrayList();
        progressWheel = null;
        page = 1;
        next = 1;
        list_fun = new ArrayList();
        isfa = false;
        isshow = false;
    }

    private void ApppopulistViewbottom()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)listView.getLayoutParams();
        layoutparams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50F));
        listView.setLayoutParams(layoutparams);
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parsefeatured(s));
        adapter = new Home_app_Listview_Adapter(getActivity(), list, "appfeatured", list_fun);
        if (page == 1)
        {
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void ShowResult1(String s)
    {
        list_fun.addAll(Myutils.fun_appList(s));
    }

    private void facebookad()
    {
        Object obj = View.inflate(getActivity(), 0x7f03003e, null);
        listView.addHeaderView(((View) (obj)), null, false);
        obj = (ImageView)((View) (obj)).findViewById(0x7f0701a6);
        NativeAd.downloadAndDisplayImage(nativeAd.getAdCoverImage(), ((ImageView) (obj)));
        nativeAd.registerViewForInteraction(((View) (obj)));
    }

    private void facebookbanner()
    {
        View view = View.inflate(getActivity(), 0x7f03003d, null);
        facebookbanner = (LinearLayout)view.findViewById(0x7f0701a5);
        listView.addHeaderView(view, null, false);
        try
        {
            adView = new AdView(getActivity(), "340186902832477_408407326010434", AdSize.RECTANGLE_HEIGHT_250);
            facebookbanner.addView(adView);
            adView.setAdListener(new AdListener() {

                final AppFeaturedFragment this$0;

                public void onAdClicked(Ad ad)
                {
                }

                public void onAdLoaded(Ad ad)
                {
                }

                public void onError(Ad ad, AdError aderror)
                {
                    Log.e("rtrtr", (new StringBuilder()).append(aderror).toString());
                }

            
            {
                this$0 = AppFeaturedFragment.this;
                super();
            }
            });
            adView.loadAd();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void init(View view)
    {
        progressWheel = (ProgressWheel)view.findViewById(0x7f070072);
        listView = (PullableListView_load)view.findViewById(0x7f07006f);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        (new Mya3()).execute(new Void[0]);
        (new Mya1()).execute(new Void[0]);
    }

    private void inmobibanner()
    {
        View view = View.inflate(getActivity(), 0x7f03005a, null);
        if (getResources().getConfiguration().locale.getCountry().equals("US") || getResources().getConfiguration().locale.getCountry().equals("ID"))
        {
            listView.addHeaderView(view, null, false);
            inmobbanner = (LinearLayout)view.findViewById(0x7f070247);
            imginmobibanner = (ImageView)view.findViewById(0x7f070248);
        }
    }

    public int getHeight(int i, int j)
    {
        return (getActivity().getResources().getDisplayMetrics().widthPixels * j) / i;
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

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030013, null, false);
        init(layoutinflater);
        viewgroup = new IntentFilter();
        viewgroup.addAction("showappfeatured");
        getActivity().registerReceiver(showapp1, viewgroup);
        viewgroup = new IntentFilter();
        viewgroup.addAction("hideappfeatured");
        getActivity().registerReceiver(hideapp1, viewgroup);
        nativeAd = new NativeAd(getActivity(), "340186902832477_388101491374351");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
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
            next = ((DownloadMovieItem)((ArrayList)list.get(list.size() - 1)).get(0)).getHas_next_page();
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
        MobclickAgent.onPause(getActivity());
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }




}
