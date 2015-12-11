// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.news;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.i;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.support.v4.widget.l;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.o;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import com.shazam.android.analytics.AnalyticsInfoProvider;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.fragment.RetryFragment;
import com.shazam.android.fragment.e;
import com.shazam.android.k.e.g;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.widget.feed.FeedRecyclerView;
import com.shazam.android.widget.feed.NewsFeedScrollHint;
import com.shazam.android.widget.feed.j;
import com.shazam.android.widget.feed.y;
import com.shazam.android.widget.h.b;
import com.shazam.android.widget.slidingtabs.a;
import com.shazam.i.b.c;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.news.Feed;
import com.shazam.model.news.FeedCard;
import com.shazam.model.news.FeedCardType;
import com.shazam.model.news.WhatsNewFeedCard;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.fragment.news:
//            l, i, e, m, 
//            g

public class NewsFeedFragment extends BaseFragment
    implements android.support.v4.widget.l.a, AnalyticsInfoProvider, e, com.shazam.android.fragment.news.l, b, a, com.shazam.p.h.a
{

    public FeedRecyclerView a;
    private final BroadcastReceiver aj = new c((byte)0);
    private final com.shazam.android.fragment.news.m ak = new com.shazam.android.fragment.news.i(com.shazam.i.b.ap.a.c(), com.shazam.i.b.ap.a.a(), com.shazam.i.b.ap.a.b());
    private final com.shazam.android.v.h.a al = com.shazam.i.b.v.a.b();
    private final com.shazam.k.o am = com.shazam.i.b.ah.f.b.a();
    private final a an = new a((byte)0);
    private ProgressBar ao;
    private l ap;
    private com.shazam.l.l.a aq;
    private View ar;
    private com.shazam.android.fragment.news.e as;
    private NewsFeedScrollHint at;
    private com.shazam.android.a.d.c au;
    private com.shazam.android.fragment.news.l av;
    private boolean aw;
    private View ax;
    private boolean ay;
    boolean b;
    private final com.shazam.android.b.a d = com.shazam.i.b.h.a.a();
    private final com.shazam.android.a.d.b e = com.shazam.i.b.c.a.a((new p()).d());
    private final com.shazam.android.widget.d.a f = com.shazam.i.b.ay.b.a.a();
    private final android.support.v4.a.e g = android.support.v4.a.e.a(com.shazam.i.b.c.a());
    private final g h = new g(com.shazam.i.c.b.a(), com.shazam.i.b.n.b.g().a());
    private final BroadcastReceiver i = new b((byte)0);

    public NewsFeedFragment()
    {
    /* block-local class not found */
    class b {}

    /* block-local class not found */
    class c {}

    /* block-local class not found */
    class a {}

        av = com.shazam.android.fragment.news.l.c;
    }

    static com.shazam.android.a.d.c a(NewsFeedFragment newsfeedfragment)
    {
        return newsfeedfragment.au;
    }

    static void a(NewsFeedFragment newsfeedfragment, boolean flag)
    {
        newsfeedfragment.b(flag);
    }

    static com.shazam.l.l.a b(NewsFeedFragment newsfeedfragment)
    {
        return newsfeedfragment.aq;
    }

    private void b(boolean flag)
    {
        com.shazam.android.a.d.c c1 = au;
        c1.b(0, c1.e.size());
        c1.e.clear();
        ap.setRefreshing(true);
        ao.setVisibility(0);
        if (flag)
        {
            aq.c();
        }
    }

    static boolean c(NewsFeedFragment newsfeedfragment)
    {
        return newsfeedfragment.ay;
    }

    private void d(Feed feed)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        feed = feed.a();
        for (Iterator iterator = feed.iterator(); iterator.hasNext();)
        {
            FeedCard feedcard = (FeedCard)iterator.next();
            if (FeedCardType.WHATS_NEW == feedcard.a())
            {
                int i1 = feed.size();
                View view = com.shazam.i.b.ay.f.a.a((new p()).d()).a(getActivity(), FeedCardType.WHATS_NEW);
                ((y)view).a((WhatsNewFeedCard)feedcard, 0, i1);
                arraylist1.add(view);
            } else
            {
                arraylist.add(feedcard);
            }
        }

        au.b(arraylist1);
        au.a(arraylist);
    }

    private void n()
    {
        android.support.v4.app.Fragment fragment = getChildFragmentManager().a("RetryFragment");
        if (fragment != null)
        {
            getChildFragmentManager().a().a(fragment).b();
        }
    }

    private void o()
    {
        a.setVisibility(0);
        ao.setVisibility(8);
        p();
        q();
    }

    private void p()
    {
        ap.setRefreshing(false);
    }

    private void q()
    {
        b = false;
        ar.setVisibility(8);
    }

    public final void a()
    {
        aq.c();
    }

    public final void a(int i1)
    {
        if (a.getScrollState() == 0 && !f())
        {
            FeedRecyclerView feedrecyclerview = a;
            if (((RecyclerView) (feedrecyclerview)).e == null)
            {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else
            {
                ((RecyclerView) (feedrecyclerview)).e.a(feedrecyclerview);
            }
            an.a = true;
        }
    }

    public final void a(Feed feed)
    {
        if (au.g())
        {
            com.shazam.android.fragment.news.e e1 = as;
            e1.e = false;
            if (e1.b.a())
            {
                e1.a.getViewTreeObserver().addOnPreDrawListener(new e.a(e1, (byte)0));
            }
        }
        d(feed);
        at.a(feed.scrollHint);
        o();
    }

    public final void a(boolean flag)
    {
        aw = flag;
    }

    public final void b(Feed feed)
    {
        o();
        d(feed);
        at.a(feed.scrollHint);
    }

    public final void c(Feed feed)
    {
        au.c(feed.a());
        p();
        q();
    }

    public final boolean c()
    {
        return aw;
    }

    public final boolean d()
    {
        return b;
    }

    public final void e()
    {
        if (ap.a)
        {
            return;
        } else
        {
            b = true;
            aq.e();
            return;
        }
    }

    public final boolean f()
    {
label0:
        {
            boolean flag = false;
            int i1;
            if (a.getAdapter().a() == 0 && a.getChildCount() == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 == 0)
            {
                i1 = a.getFirstVisiblePosition();
                View view = a.getChildAt(i1);
                if (view != null && i1 < ((StaggeredGridLayoutManager) (a.getFeedLayoutManager())).a && view.getTop() >= a.getPaddingTop())
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
                if (i1 == 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public final void g()
    {
        o();
        if (au.g())
        {
            f.a();
            f.a(getActivity(), 0x7f0900ba, com.shazam.android.widget.d.b.c());
            getChildFragmentManager().a().b(0x7f11017c, RetryFragment.a("newsfeednetworkerror"), "RetryFragment").b();
            m();
        }
    }

    public AnalyticsInfo getAnalyticsInfo()
    {
        return com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.SCREEN_NAME, "home").a(DefinedEventParameterKey.SCREEN_ORIGIN, ScreenOrigin.HOME.value).b();
    }

    public final void h()
    {
        ao.setVisibility(8);
        ax.setVisibility(0);
        p();
    }

    public final void i()
    {
        q();
        f.a();
        f.a(getActivity(), 0x7f0900ba, com.shazam.android.widget.d.b.c());
        ar.setVisibility(8);
    }

    public final void j()
    {
        getActivity().sendBroadcast(new Intent("com.shazam.android.action.NEWS_FEED_CACHE_UPDATED"));
        p();
    }

    protected final boolean k()
    {
        boolean flag1 = false;
        o o1 = a.getFeedLayoutManager();
        int ai[] = o1.b(new int[((StaggeredGridLayoutManager) (o1)).a]);
        int j1 = ai.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (ai[i1] != a.getAdapter().a() - 1)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    protected final void l()
    {
        ap.setEnabled(true);
    }

    protected final void m()
    {
        ap.setEnabled(false);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getParentFragment() instanceof com.shazam.android.fragment.news.l)
        {
            av = (com.shazam.android.fragment.news.l)getParentFragment();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ak.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030051, viewgroup, false);
        ao = (ProgressBar)layoutinflater.findViewById(0x7f110177);
        a = (FeedRecyclerView)layoutinflater.findViewById(0x7f110178);
        ap = (l)layoutinflater.findViewById(0x7f110176);
        ar = layoutinflater.findViewById(0x7f110179);
        at = (NewsFeedScrollHint)layoutinflater.findViewById(0x7f11017a);
        ax = layoutinflater.findViewById(0x7f110259);
        au = e.a(getActivity());
        as = new com.shazam.android.fragment.news.e(a, d);
        a.setAdapter(au);
        ap.setOnRefreshListener(this);
        viewgroup = new com.shazam.android.aw.a.b.a(new android.support.v7.widget.RecyclerView.l[] {
            new com.shazam.android.widget.h.c(this), new com.shazam.android.fragment.news.g(ar, as, at, av, ap, a, this), an
        });
        a.setOnScrollListener(viewgroup);
        ap.setColorSchemeResources(new int[] {
            0x7f0f004e, 0x7f0f004f, 0x7f0f0050, 0x7f0f0051
        });
        aq = al.a(this, getActivity(), 104, 105, h, am);
        aq.a();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        aq.d();
    }

    public void onDetach()
    {
        super.onDetach();
        av = com.shazam.android.fragment.news.l.c;
    }

    public void onPause()
    {
        super.onPause();
        g.a(i);
        g.a(aj);
    }

    public void onResume()
    {
        super.onResume();
        g.a(i, new IntentFilter("com.shazam.android.action.news.REMOVE_CARD"));
        g.a(aj, new IntentFilter("com.shazam.android.action.RELOAD_NEWS_FEED"));
    }

    public void onSelected()
    {
        super.onSelected();
        ay = true;
        FeedRecyclerView feedrecyclerview = a;
        for (int i1 = 0; i1 < feedrecyclerview.getChildCount(); i1++)
        {
            if (feedrecyclerview.getChildAt(i1) instanceof j)
            {
                ((j)feedrecyclerview.getChildAt(i1)).h();
            }
        }

        if (au.g())
        {
            aq.b();
            aq.c();
        } else
        if (ak.b())
        {
            ak.a();
            b(true);
            return;
        }
    }

    public void onStart()
    {
        super.onStart();
        com.shazam.android.k.f.b.a a1 = com.shazam.android.k.f.b.a.l;
        if (getActivity() instanceof com.shazam.android.activities.a.c)
        {
            ((com.shazam.android.activities.a.c)getActivity()).a(a1, this);
        }
    }

    public void onStop()
    {
        super.onStop();
        com.shazam.android.k.f.b.a a1 = com.shazam.android.k.f.b.a.l;
        if (getActivity() instanceof com.shazam.android.activities.a.c)
        {
            ((com.shazam.android.activities.a.c)getActivity()).b(a1, this);
        }
        f.a();
        au.e();
    }

    public void onUnselected()
    {
        super.onUnselected();
        ay = false;
        FeedRecyclerView feedrecyclerview = a;
        for (int i1 = 0; i1 < feedrecyclerview.getChildCount(); i1++)
        {
            if (feedrecyclerview.getChildAt(i1) instanceof j)
            {
                ((j)feedrecyclerview.getChildAt(i1)).i();
            }
        }

        n();
        au.f();
    }

    public final void r_()
    {
        av.r_();
    }

    public final void s_()
    {
        av.s_();
    }

    public final void t_()
    {
        n();
        aq.c();
        l();
        ap.setRefreshing(true);
        ao.setVisibility(0);
    }
}
