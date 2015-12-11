// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.home;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shazam.android.ad.b.b;
import com.shazam.android.aq.a;
import com.shazam.android.ay.a.q;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.fragment.TaggingDialogFragment;
import com.shazam.android.fragment.c;
import com.shazam.android.fragment.h;
import com.shazam.android.fragment.news.NewsFeedFragment;
import com.shazam.android.fragment.news.l;
import com.shazam.android.widget.feed.FeedRecyclerView;
import com.shazam.android.widget.tagging.i;
import com.shazam.i.b.ar.a.e;

// Referenced classes of package com.shazam.android.fragment.home:
//            SimpleTaggingFragment

public class HomeFragment extends BaseFragment
    implements a, h, l, com.shazam.android.widget.tagging.h, i
{

    private final q a = com.shazam.i.b.ar.a.e.a();
    private boolean b;
    private boolean d;
    private com.shazam.android.widget.tagging.a e;

    public HomeFragment()
    {
        b = false;
        e = com.shazam.android.widget.tagging.a.a;
    }

    private Fragment a(String s)
    {
label0:
        {
            Fragment fragment = getChildFragmentManager().a(s);
            if (fragment != null)
            {
                s = fragment;
                if (fragment.isInLayout())
                {
                    break label0;
                }
            }
            s = null;
        }
        return s;
    }

    private void a(int i1)
    {
        Object obj = h();
        if (obj != null)
        {
            obj = ((SimpleTaggingFragment) (obj)).getView();
            if (obj != null)
            {
                ((View) (obj)).setVisibility(i1);
            }
        }
    }

    private static void a(b b1)
    {
        if (b1 != null)
        {
            b1.onSelected();
        }
    }

    private NewsFeedFragment g()
    {
        return (NewsFeedFragment)a("TAG_FRAGMENT_NEWS_FEED");
    }

    private SimpleTaggingFragment h()
    {
        return (SimpleTaggingFragment)a("TAGGING_FRAGMENT_SIMPLE");
    }

    private boolean i()
    {
        return isAdded() && getResources().getConfiguration().orientation == 2;
    }

    private void j()
    {
        e.a();
    }

    private void k()
    {
        e.b();
    }

    public final void a(com.shazam.android.widget.tagging.a a1)
    {
        e = a1;
        a1.a(this);
    }

    public final void f()
    {
        NewsFeedFragment newsfeedfragment = g();
        if (newsfeedfragment != null)
        {
            newsfeedfragment.a.b();
        }
    }

    public String getAgofViewKey()
    {
        return "ShazamAndroidHome";
    }

    public final void n_()
    {
        android.support.v4.app.i i1 = getActivity();
        if (i1 != null)
        {
            i1.dispatchKeyEvent(new KeyEvent(0, 4));
            i1.dispatchKeyEvent(new KeyEvent(1, 4));
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        boolean flag;
        if (getResources().getConfiguration().orientation == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030049, viewgroup, false);
    }

    public void onSelected()
    {
        boolean flag;
        flag = true;
        super.onSelected();
        d = true;
        if (a.c()) goto _L2; else goto _L1
_L1:
        if (!b && !i()) goto _L4; else goto _L3
_L3:
        j();
_L2:
        a(g());
        a(h());
        return;
_L4:
        if (getFragmentManager().a(TaggingDialogFragment.aj) == null)
        {
            flag = false;
        }
        if (!flag)
        {
            k();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onStart()
    {
        super.onStart();
        if (!a.c() && i())
        {
            j();
        }
    }

    public void onUnselected()
    {
        super.onUnselected();
        d = false;
        NewsFeedFragment newsfeedfragment = g();
        if (newsfeedfragment != null)
        {
            newsfeedfragment.onUnselected();
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (d)
        {
            if (flag && !b && !i())
            {
                k();
            }
            g().onWindowFocusChanged(flag);
        }
    }

    public final void r_()
    {
        b = true;
        j();
        a(8);
    }

    public final void s_()
    {
        b = false;
        if (!i())
        {
            k();
            a(0);
        }
    }
}
