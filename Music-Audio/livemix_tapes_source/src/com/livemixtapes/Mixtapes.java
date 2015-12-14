// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.livemixtapes.adapter.ViewPagerAdapter;
import com.livemixtapes.adapter.ViewPagerCustomDuration;
import com.livemixtapes.database.DBHelper;
import com.livemixtapes.library.JSONParser;
import com.livemixtapes.utils.Utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            MixtapesActivity, Mixtape, App, LazyAdapterMixtapes, 
//            ImageLoader, AsyncHttp, User, PullToRefreshListView, 
//            console, JsonToMap, Utils

public class Mixtapes extends Fragment
{
    private class JSONParse extends AsyncTask
    {

        ProgressDialog pd;
        final Mixtapes this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            as = new JSONParser();
            long l = System.currentTimeMillis() / 1000L;
            if (current_scope.equals("all_mixtapes"))
            {
                Mixtapes.url = (new StringBuilder("https://api.livemixtapes.com/api/mixtape/all?page=")).append(curPage).toString();
            } else
            if (current_scope.equals("week_mixtapes"))
            {
                Mixtapes.url = (new StringBuilder("https://api.livemixtapes.com/api/mixtape/thisweek?page=")).append(curPage).toString();
            } else
            if (current_scope.equals("day_mixtapes"))
            {
                Mixtapes.url = (new StringBuilder("https://api.livemixtapes.com/api/mixtape/today?page=")).append(curPage).toString();
            } else
            if (current_scope.equals("unreleased_mixtapes"))
            {
                Mixtapes.url = (new StringBuilder("https://api.livemixtapes.com/api/mixtape/unreleased?page=")).append(curPage).toString();
            }
            as = as.getJSONFromUrl(Mixtapes.url, activity);
            if (as != null)
            {
                try
                {
                    updateJSONDatatoSQlite((ArrayList)JsonToMap.convert(as).get("mixtapes"), JsonToMap.convert(as).get("screen").toString());
                }
                catch (Exception exception)
                {
                    return as;
                }
            }
            return as;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((JSONObject)obj);
        }

        protected void onPostExecute(JSONObject jsonobject)
        {
            activity.hideProgressBar();
            if (listView.isRefreshing())
            {
                listView.onRefreshComplete();
            }
            dataloading = Boolean.valueOf(false);
            footerView.setVisibility(8);
            if (jsonobject != null)
            {
                Object obj = JsonToMap.convert(jsonobject);
                String s = ((HashMap) (obj)).get("total_mixtape_count").toString();
                curPage = Integer.parseInt(((HashMap) (obj)).get("page").toString());
                mixtapeCount.setText((new StringBuilder(String.valueOf(Utils.formatWithCommas(s)))).append(" Total Mixtapes").toString());
                activity.dbHelper = DBHelper.sharedInstance(activity);
                if (curPage == 0)
                {
                    mixtapelist.clear();
                }
                mixtapelist.addAll((ArrayList)JsonToMap.convert(jsonobject).get("mixtapes"));
                obj = Mixtapes.this;
                obj.curPage = ((Mixtapes) (obj)).curPage + 1;
                jsonobject = (ArrayList)JsonToMap.convert(jsonobject).get("top_mixtapes");
                if (curPage == 1 && jsonobject.size() > 0)
                {
                    viewPager.setVisibility(0);
                    dotsLayout.setVisibility(0);
                    setFlipperContent(jsonobject);
                }
                adapter.notifyDataSetChanged();
                jsonobject = Integer.toString(mixtapelist.size());
                if (current_scope.equals("week_mixtapes"))
                {
                    weekSwitch.setText((new StringBuilder(String.valueOf(jsonobject))).append(" This Week").toString());
                    return;
                }
                if (current_scope.equals("day_mixtapes"))
                {
                    todaySwitch.setText((new StringBuilder(String.valueOf(jsonobject))).append(" Today").toString());
                    return;
                }
                if (current_scope.equals("unreleased_mixtapes"))
                {
                    unreleasedSwitch.setText((new StringBuilder(String.valueOf(jsonobject))).append(" Unreleased").toString());
                    return;
                }
            }
        }

        protected void onPreExecute()
        {
            dataloading = Boolean.valueOf(true);
            super.onPreExecute();
            if (mixtapelist.size() == 0)
            {
                activity.showProgressBar("Loading...");
            }
        }

        private JSONParse()
        {
            this$0 = Mixtapes.this;
            super();
        }

        JSONParse(JSONParse jsonparse)
        {
            this();
        }
    }

    class LoadDownloadData extends AsyncTask
    {

        ProgressDialog pd;
        final Mixtapes this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            return (new JSONParser()).getJSONFromUrl((new StringBuilder("https://api.livemixtapes.com/api/mixtape/")).append(as[0]).toString(), activity);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((JSONObject)obj);
        }

        protected void onPostExecute(JSONObject jsonobject)
        {
            super.onPostExecute(jsonobject);
            pd.dismiss();
            if (jsonobject != null)
            {
                jsonobject = (HashMap)JsonToMap.convert(jsonobject).get("mixtape");
                loadMixtapeFragment(jsonobject, 0);
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(activity);
            pd.setMessage("Loading..");
            pd.show();
        }

        LoadDownloadData()
        {
            this$0 = Mixtapes.this;
            super();
        }
    }


    private static final int DAY = 0x5265c00;
    private static final int HOUR = 0x36ee80;
    private static final int MINUTE = 60000;
    private static final int SECOND = 1000;
    private static long unixTime;
    private static String url = "https://api.livemixtapes.com/api/mixtape/all";
    Button Btngetdata;
    JSONParse JSONTask;
    ImageView actionBarImage;
    MixtapesActivity activity;
    LazyAdapterMixtapes adapter;
    TextView allSwitch;
    private int curPage;
    private String current_scope;
    private Boolean dataloading;
    private long dayValue;
    Object displayObject;
    ArrayList dots;
    LinearLayout dotsLayout;
    ImageView featuredImage;
    private String featured_tape;
    View footerView;
    GridView grid;
    private long hourValue;
    ImageLoader imageLoader;
    private int lastPosition;
    ImageView layoutSwitchImage;
    PullToRefreshListView listView;
    private long minuteValue;
    TextView mixtapeCount;
    ArrayList mixtapelist;
    JSONArray mixtapes;
    Boolean noData;
    int pageCount;
    ViewPagerAdapter pagerAdapter;
    private int positionCount;
    View rootView;
    JSONObject sObj;
    private long secondValue;
    JSONArray sourcelist;
    private long tempDay;
    private long tempHour;
    private long tempMinute;
    private long tempSecond;
    Timer timer;
    TextView todaySwitch;
    TextView unreleasedSwitch;
    ViewPagerCustomDuration viewPager;
    TextView weekSwitch;

    public Mixtapes()
    {
        mixtapelist = new ArrayList();
        dataloading = Boolean.valueOf(false);
        lastPosition = -1;
        curPage = 0;
        positionCount = 0;
        current_scope = "all_mixtapes";
        dayValue = 0L;
        hourValue = 0L;
        minuteValue = 0L;
        secondValue = 0L;
        tempDay = 0L;
        tempHour = 0L;
        tempMinute = 0L;
        tempSecond = 0L;
        mixtapes = null;
        sourcelist = null;
        sObj = null;
        footerView = null;
        JSONTask = null;
        noData = Boolean.valueOf(true);
        pageCount = 0;
    }

    private void loadMixtapeFragment(HashMap hashmap, int i)
    {
        FragmentTransaction fragmenttransaction = activity.getAnimatedFragmentTransaction();
        Mixtape mixtape = new Mixtape();
        Bundle bundle = new Bundle();
        bundle.putSerializable("mixtapeData", hashmap);
        bundle.putInt("init_action", i);
        mixtape.setArguments(bundle);
        fragmenttransaction.replace(0x7f0800cc, mixtape, "MIXTAPE").addToBackStack(null);
        fragmenttransaction.commit();
    }

    private void setFlipperContent(final ArrayList data)
    {
        if (!isAdded())
        {
            return;
        }
        viewPager.setVisibility(0);
        if (pagerAdapter != null)
        {
            pagerAdapter.cancelTimers();
        }
        pagerAdapter = new ViewPagerAdapter(activity, data);
        pagerAdapter.setCallbacks(new com.livemixtapes.adapter.ViewPagerAdapter.PagerCallbacks() {

            final Mixtapes this$0;
            private final ArrayList val$data;

            public void onShowMixtape(int i, int j)
            {
                HashMap hashmap = (HashMap)data.get(i);
                loadMixtapeFragment(hashmap, j);
            }

            
            {
                this$0 = Mixtapes.this;
                data = arraylist;
                super();
            }
        });
        viewPager.setAdapter(pagerAdapter);
        addDots(data.size());
        if (timer != null)
        {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {

            final Mixtapes this$0;
            private final ArrayList val$data;

            public void run()
            {
                activity.runOnUiThread(data. new Runnable() {

                    final _cls14 this$1;
                    private final ArrayList val$data;

                    public void run()
                    {
                        if (pageCount <= data.size())
                        {
                            viewPager.setCurrentItem(pageCount, true);
                            Mixtapes mixtapes1 = _fld0;
                            mixtapes1.pageCount = mixtapes1.pageCount + 1;
                            return;
                        } else
                        {
                            pageCount = 0;
                            viewPager.setCurrentItem(pageCount, true);
                            return;
                        }
                    }

            
            {
                this$1 = final__pcls14;
                data = ArrayList.this;
                super();
            }
                });
            }


            
            {
                this$0 = Mixtapes.this;
                data = arraylist;
                super();
            }
        }, 500L, 3000L);
    }

    private void switchMixtapeView(String s)
    {
        int j;
        int k;
        int l;
        try
        {
            mixtapelist.clear();
            curPage = 0;
            int i = getResources().getColor(0x7f0b001d);
            l = getResources().getColor(0x106000b);
            weekSwitch.setBackgroundResource(0x7f0200ef);
            todaySwitch.setBackgroundResource(0x7f0200ef);
            allSwitch.setBackgroundResource(0x7f0200ed);
            unreleasedSwitch.setBackgroundResource(0x7f0200f1);
            weekSwitch.setTextColor(i);
            todaySwitch.setTextColor(i);
            allSwitch.setTextColor(i);
            unreleasedSwitch.setTextColor(i);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        k = 1;
        unixTime = System.currentTimeMillis() / 1000L;
        if (!s.equals("week")) goto _L2; else goto _L1
_L1:
        weekSwitch.setBackgroundResource(0x7f0200f0);
        weekSwitch.setTextColor(l);
        current_scope = "week_mixtapes";
        if (App.lastUpdateWeek != 0L && unixTime - App.lastUpdateWeek <= 60L) goto _L4; else goto _L3
_L3:
        App.lastUpdateWeek = unixTime;
        j = k;
_L16:
        k = (int)Utility.dpToPixel(getActivity(), 0.0F);
        l = (int)Utility.dpToPixel(getActivity(), 4F);
        allSwitch.setPadding(k, l, k, l);
        weekSwitch.setPadding(k, l, k, l);
        todaySwitch.setPadding(k, l, k, l);
        unreleasedSwitch.setPadding(k, l, k, l);
        mixtapelist.clear();
        mixtapelist.addAll(activity.dbHelper.getAllMixtapeData(current_scope));
        adapter.notifyDataSetChanged();
        if (j != true) goto _L6; else goto _L5
_L5:
        try
        {
            JSONTask.cancel(true);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        JSONTask = new JSONParse(null);
        JSONTask.execute(new String[0]);
        return;
_L2:
        if (!s.equals("day")) goto _L8; else goto _L7
_L7:
        todaySwitch.setBackgroundResource(0x7f0200f0);
        todaySwitch.setTextColor(l);
        current_scope = "day_mixtapes";
        if (App.lastUpdateToday != 0L && unixTime - App.lastUpdateToday <= 60L) goto _L10; else goto _L9
_L9:
        App.lastUpdateToday = unixTime;
        j = k;
        continue; /* Loop/switch isn't completed */
_L8:
        if (!s.equals("unreleased")) goto _L12; else goto _L11
_L11:
        unreleasedSwitch.setBackgroundResource(0x7f0200f2);
        unreleasedSwitch.setTextColor(l);
        current_scope = "unreleased_mixtapes";
        if (App.lastUpdateUnreleased != 0L && unixTime - App.lastUpdateUnreleased <= 60L) goto _L14; else goto _L13
_L13:
        App.lastUpdateUnreleased = unixTime;
        j = k;
        continue; /* Loop/switch isn't completed */
_L12:
        j = k;
        if (!s.equals("all"))
        {
            continue; /* Loop/switch isn't completed */
        }
        allSwitch.setBackgroundResource(0x7f0200ee);
        allSwitch.setTextColor(l);
        current_scope = "all_mixtapes";
        if (App.lastUpdateAll != 0L && unixTime - App.lastUpdateAll <= 60L)
        {
            break MISSING_BLOCK_LABEL_544;
        }
        App.lastUpdateAll = unixTime;
        j = k;
        continue; /* Loop/switch isn't completed */
        j = 0;
        continue; /* Loop/switch isn't completed */
_L6:
        return;
_L4:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L10:
        j = 0;
        continue; /* Loop/switch isn't completed */
_L14:
        j = 0;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public void addDots(final int count)
    {
        dotsLayout.setVisibility(0);
        dotsLayout.removeAllViews();
        dots = new ArrayList();
        int i = 0;
        do
        {
            if (i >= count)
            {
                viewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

                    final Mixtapes this$0;
                    private final int val$count;

                    public void onPageScrollStateChanged(int j)
                    {
                    }

                    public void onPageScrolled(int j, float f, int k)
                    {
                    }

                    public void onPageSelected(int j)
                    {
                        selectDot(count, j);
                    }

            
            {
                this$0 = Mixtapes.this;
                count = i;
                super();
            }
                });
                return;
            }
            ImageView imageview = new ImageView(activity);
            imageview.setImageDrawable(getResources().getDrawable(0x7f02006c));
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -1);
            dotsLayout.addView(imageview, layoutparams);
            dots.add(imageview);
            i++;
        } while (true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (rootView != null) goto _L2; else goto _L1
_L1:
        rootView = layoutinflater.inflate(0x7f030029, viewgroup, false);
        activity = (MixtapesActivity)getActivity();
        viewPager = (ViewPagerCustomDuration)rootView.findViewById(0x7f0800c7);
        viewPager.setScrollDurationFactor(3D);
        viewPager.setOffscreenPageLimit(3);
        dotsLayout = (LinearLayout)rootView.findViewById(0x7f0800c8);
        imageLoader = new ImageLoader(getActivity().getApplicationContext());
        actionBarImage = (ImageView)rootView.findViewById(0x7f08005f);
        featuredImage = (ImageView)rootView.findViewById(0x7f080078);
        layoutSwitchImage = (ImageView)rootView.findViewById(0x7f0800c6);
        allSwitch = (TextView)rootView.findViewById(0x7f0800c1);
        weekSwitch = (TextView)rootView.findViewById(0x7f0800c2);
        todaySwitch = (TextView)rootView.findViewById(0x7f0800c3);
        unreleasedSwitch = (TextView)rootView.findViewById(0x7f0800c4);
        weekSwitch.setText((new StringBuilder(String.valueOf(activity.week_mixtapes))).append(" This Week").toString());
        todaySwitch.setText((new StringBuilder(String.valueOf(activity.day_mixtapes))).append(" Today").toString());
        unreleasedSwitch.setText((new StringBuilder(String.valueOf(activity.unreleased_mixtapes))).append(" Unreleased").toString());
        mixtapeCount = (TextView)rootView.findViewById(0x7f0800c5);
        Btngetdata = (Button)rootView.findViewById(0x7f0800ca);
        Btngetdata.setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtapes this$0;

            public void onClick(View view)
            {
                JSONTask = new JSONParse(null);
                JSONTask.execute(new String[0]);
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        (new AsyncHttp()).get((new StringBuilder("https://api.livemixtapes.com/api/page_counts?auth=")).append(User.getAuth()).toString(), new AsyncHttp.AsyncHttpCallback() {

            final Mixtapes this$0;

            protected void always()
            {
            }

            protected void exception(Exception exception1)
            {
                console.log(new Object[] {
                    exception1
                });
            }

            protected void success(String s, String s1, int i)
            {
                console.log(new Object[] {
                    s
                });
                try
                {
                    s = new JSONObject(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return;
                }
                try
                {
                    weekSwitch.setText((new StringBuilder(String.valueOf(s.get("week").toString()))).append(" This Week").toString());
                    todaySwitch.setText((new StringBuilder(String.valueOf(s.get("today").toString()))).append(" Today").toString());
                    unreleasedSwitch.setText((new StringBuilder(String.valueOf(s.get("unreleased").toString()))).append(" Unreleased").toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return;
                }
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        layoutSwitchImage.setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtapes this$0;

            public void onClick(View view)
            {
                if (App.viewStyle.equals("grid"))
                {
                    grid.setVisibility(8);
                    listView.setVisibility(0);
                    adapter.notifyDataSetChanged();
                    App.viewStyle = "list";
                    layoutSwitchImage.setImageResource(0x7f02008c);
                } else
                if (App.viewStyle.equals("list"))
                {
                    listView.setVisibility(8);
                    grid.setVisibility(0);
                    adapter.notifyDataSetChanged();
                    App.viewStyle = "grid";
                    layoutSwitchImage.setImageResource(0x7f02008b);
                    return;
                }
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        weekSwitch.setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtapes this$0;

            public void onClick(View view)
            {
                switchMixtapeView("week");
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        todaySwitch.setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtapes this$0;

            public void onClick(View view)
            {
                switchMixtapeView("day");
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        unreleasedSwitch.setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtapes this$0;

            public void onClick(View view)
            {
                switchMixtapeView("unreleased");
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        allSwitch.setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtapes this$0;

            public void onClick(View view)
            {
                switchMixtapeView("all");
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        Btngetdata.setVisibility(8);
        listView = (PullToRefreshListView)rootView.findViewById(0x7f0800c9);
        grid = (GridView)rootView.findViewById(0x7f0800cb);
        mixtapelist.addAll(activity.dbHelper.getAllMixtapeData(current_scope));
        if (mixtapelist.size() > 0)
        {
            noData = Boolean.valueOf(false);
        }
        adapter = new LazyAdapterMixtapes(getActivity(), mixtapelist);
        listView.setBackgroundColor(-1);
        listView.setAdapter(adapter);
        grid.setBackgroundColor(-1);
        grid.setAdapter(adapter);
        if (!App.viewStyle.equals("list")) goto _L4; else goto _L3
_L3:
        grid.setVisibility(8);
        displayObject = listView;
_L6:
        JSONTask = new JSONParse(null);
        unixTime = System.currentTimeMillis() / 1000L;
        App.lastUpdateAll = unixTime;
        JSONTask.execute(new String[0]);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Mixtapes this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (HashMap)mixtapelist.get(i);
                loadMixtapeFragment(adapterview, 0);
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        footerView = ((LayoutInflater)activity.getSystemService("layout_inflater")).inflate(0x7f030022, null, false);
        listView.addFooterView(footerView);
        footerView.setVisibility(8);
        listView.setOnBottomReachedListener(new PullToRefreshListView.OnBottomReachedListener() {

            final Mixtapes this$0;

            public void onBottomReached()
            {
                if (mixtapelist.size() > 10 && !dataloading.booleanValue())
                {
                    Mixtapes mixtapes1 = Mixtapes.this;
                    mixtapes1.lastPosition = mixtapes1.lastPosition + 10;
                    positionCount = 0;
                    Log.v("hserp", (new StringBuilder("GRABBING: ")).append(Mixtapes.url).toString());
                    footerView.setVisibility(0);
                    Btngetdata.performClick();
                }
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        listView.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {

            final Mixtapes this$0;

            public void onRefresh()
            {
                mixtapelist.clear();
                curPage = 0;
                lastPosition = -1;
                positionCount = 0;
                listView.setRefreshing();
                try
                {
                    JSONTask = new JSONParse(null);
                    JSONTask.execute(new String[0]);
                    return;
                }
                catch (Exception exception)
                {
                    JSONTask.cancel(true);
                }
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        grid.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Mixtapes this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (HashMap)mixtapelist.get(i);
                loadMixtapeFragment(adapterview, 0);
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        grid.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final Mixtapes this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
                if (i + j >= k && mixtapelist.size() > 10 && !dataloading.booleanValue())
                {
                    abslistview = Mixtapes.this;
                    abslistview.lastPosition = ((Mixtapes) (abslistview)).lastPosition + 10;
                    positionCount = 0;
                    Log.v("hserp", (new StringBuilder("GRABBING: ")).append(Mixtapes.url).toString());
                    footerView.setVisibility(0);
                    Btngetdata.performClick();
                }
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
            }

            
            {
                this$0 = Mixtapes.this;
                super();
            }
        });
        layoutinflater = activity.getIntent().getStringExtra("mixtapeId");
        if (layoutinflater != null && layoutinflater.length() > 0)
        {
            (new LoadDownloadData()).execute(new String[] {
                layoutinflater
            });
        }
_L2:
        return rootView;
_L4:
        if (App.viewStyle.equals("grid"))
        {
            listView.setVisibility(8);
            displayObject = grid;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (pagerAdapter != null)
        {
            pagerAdapter.cancelTimers();
        }
        if (timer != null)
        {
            timer.cancel();
            timer = null;
        }
    }

    public void selectDot(int i, int j)
    {
        Resources resources = getResources();
        int k = 0;
        do
        {
            if (k >= i)
            {
                return;
            }
            android.graphics.drawable.Drawable drawable;
            int l;
            if (k == j)
            {
                l = 0x7f02006b;
            } else
            {
                l = 0x7f02006c;
            }
            drawable = resources.getDrawable(l);
            ((ImageView)dots.get(k)).setImageDrawable(drawable);
            k++;
        } while (true);
    }

    void updateJSONDatatoSQlite(ArrayList arraylist, String s)
    {
        String s1;
        console.log(new Object[] {
            (new StringBuilder("WHICH SCREEN: ")).append(s).toString()
        });
        s1 = "";
        if (s.equals("thisweek"))
        {
            s1 = "week_mixtapes";
        } else
        if (s.equals("today"))
        {
            s1 = "day_mixtapes";
        } else
        if (s.equals("unreleased"))
        {
            s1 = "unreleased_mixtapes";
        } else
        if (s.equals("all"))
        {
            s1 = "all_mixtapes";
        }
        console.log(new Object[] {
            (new StringBuilder("WRITE SCOPE: ")).append(s1).toString()
        });
        activity.dbHelper = DBHelper.sharedInstance(activity);
        if (curPage != 0 || arraylist.size() <= 0) goto _L2; else goto _L1
_L1:
        activity.dbHelper.clearMixtapeTable(s1);
        arraylist = arraylist.iterator();
_L5:
        if (arraylist.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        s = (HashMap)arraylist.next();
        activity.dbHelper.insertMixtape(s1, s.get("id").toString(), s.get("title").toString(), s.get("artist").toString(), s.get("thumbnail").toString(), s.get("DJ").toString(), s.get("views").toString(), s.get("cover").toString(), s.get("score").toString(), s.get("sharetext").toString(), s.get("date").toString(), s.get("featured").toString());
        Iterator iterator = ((ArrayList)s.get("tracks")).iterator();
        while (iterator.hasNext()) 
        {
            HashMap hashmap = (HashMap)iterator.next();
            activity.dbHelper.insertTrack(s.get("id").toString(), (String)hashmap.get("track_id"), (String)hashmap.get("track_title"), (String)hashmap.get("track_duration"), (String)hashmap.get("download_url"), (String)hashmap.get("track_sharetext"));
        }
        if (true) goto _L5; else goto _L4
_L4:
    }














}
