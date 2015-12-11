// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.search;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.shazam.android.a.f;
import com.shazam.android.activities.deeplink.b;
import com.shazam.android.ae.m;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.SearchEventFactory;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.analytics.session.page.SearchPage;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.k.f.j;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.widget.AnimatorViewFlipper;
import com.shazam.i.b.ay.a.a;
import com.shazam.i.d.d;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.search.SearchSection;
import com.shazam.p.p.g;
import com.shazam.p.p.h;
import com.shazam.p.p.i;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends BaseAppCompatActivity
    implements SessionConfigurable, g, i
{
    private final class a
        implements Runnable
    {

        final SearchActivity a;

        public final void run()
        {
            com.shazam.android.activities.search.SearchActivity.d(a).a(SearchActivity.c(a));
        }

        private a()
        {
            a = SearchActivity.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    private final com.shazam.android.widget.c.f a = com.shazam.i.b.ay.a.a.b();
    private final t b = new p();
    private final EventAnalytics c = com.shazam.i.b.g.b.a.a();
    private final j d = new j();
    private final com.shazam.android.activities.deeplink.a e = new b();
    private f f;
    private com.shazam.android.a.g.a g;
    private AnimatorViewFlipper h;
    private String i;
    private com.shazam.l.o.a j;
    private com.shazam.android.k.f.i k;
    private final Map l = new HashMap() {

        final SearchActivity a;

            
            {
                a = SearchActivity.this;
                super();
                put(SearchSection.TOP_RESULT, Integer.valueOf(0x7f090109));
                put(SearchSection.SONGS, Integer.valueOf(0x7f090108));
                put(SearchSection.ARTISTS, Integer.valueOf(0x7f090101));
                put(SearchSection.RECENT_SEARCHES, Integer.valueOf(0x7f090107));
            }
    };
    private SearchView m;

    public SearchActivity()
    {
    }

    static String a(SearchActivity searchactivity, String s)
    {
        searchactivity.i = s;
        return s;
    }

    static void a(SearchActivity searchactivity)
    {
        searchactivity.m.post(searchactivity. new Runnable() {

            final SearchActivity a;

            public final void run()
            {
                com.shazam.android.activities.search.SearchActivity.b(a).clearFocus();
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        });
    }

    static SearchView b(SearchActivity searchactivity)
    {
        return searchactivity.m;
    }

    static String c(SearchActivity searchactivity)
    {
        return searchactivity.i;
    }

    static com.shazam.l.o.a d(SearchActivity searchactivity)
    {
        return searchactivity.j;
    }

    private boolean f()
    {
        return e.a(new Uri[] {
            getIntent().getData()
        });
    }

    public final void a()
    {
        h.setDisplayedChildById(0x7f110104);
    }

    public final void a(h h1)
    {
        int k1 = 0;
        h.setDisplayedChildById(0x7f110101);
        List list = h1.a;
        List list1 = h1.b;
        com.shazam.android.a.f.a aa[] = new com.shazam.android.a.f.a[list.size()];
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            int l1 = ((Integer)l.get(list.get(i1))).intValue();
            aa[i1] = new com.shazam.android.a.f.a(((Integer)list1.get(i1)).intValue(), getResources().getString(l1));
        }

        f f1 = f;
        f1.d.clear();
        Arrays.sort(aa, new com.shazam.android.a.f._cls2(f1));
        int i2 = aa.length;
        boolean flag = false;
        int j1 = k1;
        k1 = ((flag) ? 1 : 0);
        for (; j1 < i2; j1++)
        {
            com.shazam.android.a.f.a a1 = aa[j1];
            a1.b = a1.a + k1;
            f1.d.append(a1.b, a1);
            k1++;
        }

        ((android.support.v7.widget.RecyclerView.a) (f1)).a.a();
        g.a(h1.c);
        g.d = new com.shazam.android.a.g.b(list1, list);
    }

    public final void a(com.shazam.p.p.j j1, String s)
    {
        c.logEvent(SearchEventFactory.moreResultsClicked(j1));
        try
        {
            String s1 = URLEncoder.encode(s, "UTF-8");
            a.a(this, b.a(i, j1, s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.shazam.p.p.j j1)
        {
            com.shazam.android.ae.m.a(this, (new StringBuilder("Could not view more results with url: ")).append(s).toString(), j1);
        }
    }

    public final void b()
    {
        f f1 = f;
        f1.d.clear();
        ((android.support.v7.widget.RecyclerView.a) (f1)).a.a();
        g.a(null);
    }

    public final void c()
    {
        b();
        h.setDisplayedChildById(0x7f110105);
    }

    public void configureWith(Page page)
    {
        SearchPage searchpage = (SearchPage)page;
        if (f())
        {
            page = ScreenOrigin.DEEPLINK.value;
        } else
        {
            page = k.a().a(DefinedEventParameterKey.SCREEN_ORIGIN);
        }
        searchpage.setScreenOrigin(page);
        page = getIntent().getData();
        if (page != null)
        {
            page = page.getQueryParameter("campaign");
        } else
        {
            page = null;
        }
        searchpage.setCampaignId(page);
    }

    public final void d()
    {
        b();
        h.setDisplayedChildById(0x7f110106);
        c.logEvent(SearchEventFactory.noResultsEvent());
    }

    public final void e()
    {
        h.setDisplayedChildById(0x7f1100d9);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002b);
        setupToolbar(getToolbar());
        setDisplayShowTitle(false);
        k = com.shazam.android.k.f.j.a(getIntent());
        h = (AnimatorViewFlipper)findViewById(0x7f110100);
        m = (SearchView)findViewById(0x7f1100ff);
        m.setQueryHint(getResources().getString(0x7f090102));
        m.setIconifiedByDefault(false);
        m.setIconified(false);
        bundle = m.findViewById(0x7f1100a6);
        ((ViewGroup)bundle.getParent()).removeView(bundle);
        m.setOnQueryTextListener(new android.support.v7.widget.SearchView.c() {

            final Handler a = new Handler();
            final a b;
            final SearchActivity c;

            public final boolean a()
            {
                a.removeCallbacks(b);
                b.run();
                com.shazam.android.activities.search.SearchActivity.b(c).clearFocus();
                return true;
            }

            public final boolean a(String s)
            {
                com.shazam.android.activities.search.SearchActivity.a(c, s);
                a.removeCallbacks(b);
                a.postDelayed(b, 200L);
                return true;
            }

            
            {
                c = SearchActivity.this;
                super();
                b = c. new a((byte)0);
            }
        });
        bundle = (RecyclerView)findViewById(0x7f110102);
        bundle.setAdapter(f);
        g = new com.shazam.android.a.g.a(this);
        f = new f(this, g);
        bundle.setAdapter(f);
        bundle.setLayoutManager(new LinearLayoutManager());
        android.support.v7.widget.RecyclerView.l l1 = new android.support.v7.widget.RecyclerView.l() {

            final SearchActivity a;

            public final void a(RecyclerView recyclerview, int i1)
            {
                super.a(recyclerview, i1);
                if (i1 == 1)
                {
                    com.shazam.android.activities.search.SearchActivity.a(a);
                }
            }

            public final void a(RecyclerView recyclerview, int i1, int j1)
            {
                super.a(recyclerview, i1, j1);
            }

            
            {
                a = SearchActivity.this;
                super();
            }
        };
        if (((RecyclerView) (bundle)).p == null)
        {
            bundle.p = new ArrayList();
        }
        ((RecyclerView) (bundle)).p.add(l1);
        j = new com.shazam.l.o.a(this, new com.shazam.android.k.b.f(getSupportLoaderManager(), 10034, this, com.shazam.android.k.d.a(new com.shazam.android.k.e.g.b(com.shazam.i.c.b.a()), com.shazam.i.d.d.P()), com.shazam.android.k.b.i.b), new com.shazam.android.k.b.d(getSupportLoaderManager(), 10035, this, new com.shazam.android.k.e.g.a(com.shazam.i.b.ah.f.d.a(this)), com.shazam.android.k.b.i.b), com.shazam.i.b.n.b.U());
        j.a(null);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            if (f())
            {
                com.shazam.android.activities.b.a.a(this, false);
                finish();
            } else
            {
                onBackPressed();
            }
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onStart()
    {
        super.onStart();
        ((android.support.v7.widget.RecyclerView.a) (g)).a.a();
    }
}
