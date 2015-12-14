// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.picsart.studio.view.SlidingTabLayout;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.picsart.profile.adapter.ap;
import com.socialin.android.picsart.profile.fragment.be;
import com.socialin.android.picsart.profile.fragment.bf;
import com.socialin.android.picsart.profile.fragment.bg;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            l

public class SearchActivity extends BaseActivity
{

    public String a;
    private int b;
    private boolean c;
    private Handler d;
    private String e;
    private int f;
    private int g;
    private ap h;
    private SearchView i;
    private ViewPager j;
    private boolean k;

    public SearchActivity()
    {
        b = 0;
        c = true;
        d = new Handler();
        a = "";
        f = 1;
        g = 2;
        k = true;
    }

    static int a(SearchActivity searchactivity, int i1)
    {
        searchactivity.b = i1;
        return i1;
    }

    static ap a(SearchActivity searchactivity)
    {
        return searchactivity.h;
    }

    private static String a(int i1, long l1)
    {
        return (new StringBuilder("android:switcher:")).append(i1).append(":").append(l1).toString();
    }

    static String a(SearchActivity searchactivity, String s)
    {
        searchactivity.a = s;
        return s;
    }

    static void a(SearchActivity searchactivity, MenuItem menuitem, String s)
    {
        menuitem = searchactivity. new Runnable(s, menuitem) {

            private String a;
            private MenuItem b;
            private SearchActivity c;

            public final void run()
            {
                SearchActivity.a(c, a);
                for (int i1 = 0; i1 < SearchActivity.a(c).getCount(); i1++)
                {
                    ((l)SearchActivity.a(c).getItem(i1)).a(true);
                }

                if (!TextUtils.isEmpty(SearchActivity.c(c)))
                {
                    c.a();
                } else
                if (SearchActivity.c(c) != null && "".equals(SearchActivity.c(c)) && MenuItemCompat.isActionViewExpanded(b))
                {
                    ((l)SearchActivity.a(c).getItem(SearchActivity.b(c))).k_();
                    return;
                }
            }

            
            {
                c = SearchActivity.this;
                a = s;
                b = menuitem;
                super();
            }
        };
        searchactivity.d.removeCallbacksAndMessages(null);
        searchactivity.d.postDelayed(menuitem, 200L);
    }

    static int b(SearchActivity searchactivity)
    {
        return searchactivity.b;
    }

    private void b()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        if (inputmethodmanager.isAcceptingText() && getWindow().getCurrentFocus() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
            i.clearFocus();
        }
    }

    static String c(SearchActivity searchactivity)
    {
        return searchactivity.a;
    }

    static void d(SearchActivity searchactivity)
    {
        searchactivity.b();
    }

    static SearchView e(SearchActivity searchactivity)
    {
        return searchactivity.i;
    }

    static boolean f(SearchActivity searchactivity)
    {
        searchactivity.k = false;
        return false;
    }

    public final void a()
    {
        AnalyticUtils analyticutils;
        String s1;
        analyticutils = AnalyticUtils.getInstance(this);
        s1 = e;
        b;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 91
    //                   1 97
    //                   2 103;
           goto _L1 _L2 _L3 _L4
_L1:
        String s = null;
_L6:
        analyticutils.track((new com.socialin.android.apiv3.events.EventsFactory.SearchEvent(s1, s, a)).setOnKeyboardClose(k));
        ((l)h.getItem(b)).j_();
        k = true;
        return;
_L2:
        s = "users";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "tags";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "images";
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1 || motionevent.getAction() == 2)
        {
            b();
        }
        return super.dispatchTouchEvent(motionevent);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        supportRequestWindowFeature(5);
        setContentView(0x7f03012e);
        if (bundle != null)
        {
            b = bundle.getInt("selected_tab");
            a = bundle.getString("searchText");
        }
        c = getIntent().getBooleanExtra("showPhotosTabInSearch", true);
        j = (ViewPager)findViewById(0x7f10064d);
        j.setVisibility(0);
        SlidingTabLayout slidingtablayout = (SlidingTabLayout)findViewById(0x7f10064c);
        if (c)
        {
            slidingtablayout.setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

                private SearchActivity a;

                public final void onPageSelected(int i1)
                {
                    super.onPageSelected(i1);
                    SearchActivity.a(a, i1);
                    if (SearchActivity.a(a) != null && ((l)SearchActivity.a(a).getItem(SearchActivity.b(a))).d() && !TextUtils.isEmpty(SearchActivity.c(a)))
                    {
                        ((l)SearchActivity.a(a).getItem(SearchActivity.b(a))).a(false);
                        a.a();
                    }
                }

            
            {
                a = SearchActivity.this;
                super();
            }
            });
        } else
        {
            slidingtablayout.setVisibility(8);
        }
        if (h == null)
        {
            h = new ap(getFragmentManager());
            FragmentManager fragmentmanager = getFragmentManager();
            be be1 = (be)fragmentmanager.findFragmentByTag(a(j.getId(), 0L));
            bundle = be1;
            if (be1 == null)
            {
                bundle = new be();
            }
            h.a(bundle, getString(0x7f08057b), 0x7f10009c);
            if (c)
            {
                Object obj = (bg)fragmentmanager.findFragmentByTag(a(j.getId(), f));
                bundle = ((Bundle) (obj));
                if (obj == null)
                {
                    bundle = new bg();
                }
                h.a(bundle, getString(0x7f08057a), 0x7f100098);
                obj = (bf)fragmentmanager.findFragmentByTag(a(j.getId(), g));
                bundle = ((Bundle) (obj));
                if (obj == null)
                {
                    bundle = new bf();
                }
                h.a(bundle, getString(0x7f0802df), 0x7f10007d);
            }
            j.setAdapter(h);
        }
        slidingtablayout.setViewPager(j);
        j.setCurrentItem(b);
        bundle = getSupportActionBar();
        if (bundle != null)
        {
            bundle.setDisplayHomeAsUpEnabled(true);
            bundle.setTitle(0x7f080343);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110007, menu);
        Object obj = menu.findItem(0x7f100ae8);
        i = (SearchView)MenuItemCompat.getActionView(((MenuItem) (obj)));
        ((MenuItem) (obj)).expandActionView();
        i.setQueryHint(getString(0x7f080343));
        if (!Utils.a(a))
        {
            i.setQuery(a, false);
        }
        i.requestFocus();
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        if (!inputmethodmanager.isAcceptingText())
        {
            getWindow().setSoftInputMode(5);
            inputmethodmanager.showSoftInput(i, 0);
        }
        ((ImageView)i.findViewById(0x7f100111)).setOnClickListener(new android.view.View.OnClickListener() {

            private SearchActivity a;

            public final void onClick(View view)
            {
                SearchActivity.d(a);
                SearchActivity.e(a).setQuery("", false);
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        });
        i.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener(((MenuItem) (obj))) {

            private MenuItem a;
            private SearchActivity b;

            public final boolean onQueryTextChange(String s1)
            {
                SearchActivity.f(b);
                SearchActivity.a(b, a, s1);
                return false;
            }

            public final boolean onQueryTextSubmit(String s1)
            {
                SearchActivity.e(b).clearFocus();
                return false;
            }

            
            {
                b = SearchActivity.this;
                a = menuitem;
                super();
            }
        });
        obj = getIntent();
        if (obj != null)
        {
            if ("android.intent.action.SEARCH".equals(((Intent) (obj)).getAction()))
            {
                String s = ((Intent) (obj)).getStringExtra("query");
                i.setQuery(s, false);
            }
            if (((Intent) (obj)).getExtras().containsKey("source"))
            {
                e = ((Intent) (obj)).getExtras().getString("source");
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        i.setOnQueryTextListener(null);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        getWindow().setSoftInputMode(3);
        if (i != null)
        {
            i.clearFocus();
        }
        b();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("selected_tab", b);
        if (!Utils.a(a))
        {
            bundle.putString("searchText", a);
        }
        super.onSaveInstanceState(bundle);
    }
}
