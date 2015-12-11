// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.search;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import com.shazam.android.a.g.a;
import com.shazam.android.a.g.d;
import com.shazam.android.ae.m;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.analytics.session.page.SearchMoreResultsPage;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.k.b.f;
import com.shazam.android.k.b.i;
import com.shazam.android.widget.AnimatorViewFlipper;
import com.shazam.android.widget.h.b;
import com.shazam.android.widget.h.c;
import com.shazam.model.search.SearchResultList;
import com.shazam.model.search.SearchSection;
import com.shazam.p.p.j;
import com.shazam.p.p.k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class SearchMoreResultsActivity extends BaseAppCompatActivity
    implements SessionConfigurable, b, k
{

    private com.shazam.l.o.b a;
    private AnimatorViewFlipper b;
    private a c;
    private j d;
    private View e;

    public SearchMoreResultsActivity()
    {
    }

    public final void a()
    {
        e.setVisibility(8);
        b.setDisplayedChildById(0x7f110104);
    }

    public final void a(SearchResultList searchresultlist)
    {
        a(false);
        if (b.getDisplayedChild() != 0x7f110101)
        {
            b.setDisplayedChildById(0x7f110101);
        }
        a a1 = c;
        searchresultlist = searchresultlist.results;
        a1.c.addAll(searchresultlist);
        ((android.support.v7.widget.RecyclerView.a) (a1)).a.a();
    }

    public final void a(boolean flag)
    {
        int l;
        if (flag)
        {
            l = 0;
        } else
        {
            l = 8;
        }
        if (l != e.getVisibility())
        {
            e.setVisibility(l);
        }
    }

    public final void b()
    {
        a(false);
        b.setDisplayedChildById(0x7f110106);
    }

    public final boolean c()
    {
        return false;
    }

    public void configureWith(Page page)
    {
        ((SearchMoreResultsPage)page).setSearchResultType(d.d);
    }

    public final boolean d()
    {
        return false;
    }

    public final void e()
    {
        a(true);
        com.shazam.l.o.b b1 = a;
        b1.c = false;
        b1.a(b1.b, false);
    }

    public final void f()
    {
        b.setDisplayedChildById(0x7f1100d9);
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        Object obj1;
        obj = null;
        super.onCreate(bundle);
        setContentView(0x7f03002b);
        d = j.a(getIntent().getData().getQueryParameter("section"));
        obj1 = getIntent().getData().getQueryParameter("query");
        bundle = "";
        if (d == null) goto _L2; else goto _L1
_L1:
        bundle = "";
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[j.values().length];
                try
                {
                    a[j.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[j.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.shazam.android.activities.search._cls1.a[d.ordinal()];
        JVM INSTR tableswitch 1 2: default 92
    //                   1 390
    //                   2 404;
           goto _L3 _L4 _L5
_L3:
        bundle = (new StringBuilder(" ")).append(getResources().getString(0x7f090090)).append(" ").append(bundle).toString();
_L2:
        a a1;
        setTitle((new StringBuilder("\"")).append(((String) (obj1))).append("\"").append(bundle).toString());
        findViewById(0x7f1100ff).setVisibility(8);
        b = (AnimatorViewFlipper)findViewById(0x7f110100);
        e = findViewById(0x7f110103);
        obj1 = (RecyclerView)findViewById(0x7f110102);
        c = new a(null);
        a1 = c;
        com.shazam.android.activities.search._cls1.a[d.ordinal()];
        JVM INSTR tableswitch 1 2: default 252
    //                   1 418
    //                   2 425;
           goto _L6 _L7 _L8
_L6:
        bundle = obj;
        break; /* Loop/switch isn't completed */
_L4:
        bundle = getResources().getString(0x7f090101);
        continue; /* Loop/switch isn't completed */
_L5:
        bundle = getResources().getString(0x7f090108);
        continue; /* Loop/switch isn't completed */
_L7:
        bundle = SearchSection.ARTISTS;
          goto _L9
_L8:
        bundle = SearchSection.SONGS;
_L9:
        a1.d = new d(bundle);
        ((RecyclerView) (obj1)).setAdapter(c);
        ((RecyclerView) (obj1)).setLayoutManager(new LinearLayoutManager());
        ((RecyclerView) (obj1)).setOnScrollListener(new c(this));
        a = new com.shazam.l.o.b(this, new f(getSupportLoaderManager(), 31478, this, com.shazam.android.k.d.a(new com.shazam.android.k.e.g.b(com.shazam.i.c.b.a()), com.shazam.i.d.d.O()), i.b));
        bundle = getIntent().getData().getQueryParameter("page_url");
        try
        {
            if (com.shazam.b.e.a.c(bundle))
            {
                String s = URLDecoder.decode(bundle, "UTF-8");
                com.shazam.l.o.b b1 = a;
                b1.c = true;
                b1.a(s, true);
            }
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            m.a(this, (new StringBuilder("Could not view more results with url: ")).append(bundle).toString(), unsupportedencodingexception);
        }
        return;
        if (true) goto _L3; else goto _L10
_L10:
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }
}
