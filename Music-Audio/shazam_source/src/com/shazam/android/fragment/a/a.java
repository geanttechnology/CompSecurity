// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.a;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import at.markushi.ui.RevealColorView;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.advert.n;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.k.e.g;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;
import com.shazam.android.p.c;
import com.shazam.android.p.m;
import com.shazam.android.util.f;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.android.widget.button.follow.FollowButton;
import com.shazam.android.widget.feed.FeedRecyclerView;
import com.shazam.android.widget.h.b;
import com.shazam.android.widget.image.UrlCachingImageView;
import com.shazam.android.widget.text.ArtistNameTextView;
import com.shazam.android.widget.text.ExpandableCustomFontTextView;
import com.shazam.k.d;
import com.shazam.k.o;
import com.shazam.model.Factory;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.news.Feed;
import java.util.Map;

// Referenced classes of package com.shazam.android.fragment.a:
//            b

public final class a extends BaseFragment
    implements android.support.v7.c.c.c, com.shazam.android.advert.h.a, n, b, com.shazam.p.h.a
{

    public final d a = com.shazam.i.l.a.a();
    private com.shazam.android.fragment.a.b aA;
    private boolean aB;
    public ShazamAdView aj;
    public Map ak;
    private com.shazam.android.a.d.b al;
    private final com.shazam.android.widget.d.a am = com.shazam.i.b.ay.b.a.a();
    private final Factory an = new com.shazam.android.v.i.a();
    private final com.shazam.android.v.h.a ao = com.shazam.i.b.v.a.b();
    private final Handler ap = com.shazam.i.b.z.a.a();
    private final EventAnalytics aq = com.shazam.i.b.g.b.a.a();
    private final t ar = new p();
    private final m as = new c();
    private final boolean at;
    private View au;
    private FeedRecyclerView av;
    private boolean aw;
    private View ax;
    private boolean ay;
    private RevealColorView az;
    public com.shazam.l.l.a b;
    public com.shazam.android.a.d.c c;
    public TextView d;
    public ArtistNameTextView e;
    public ExpandableCustomFontTextView f;
    public UrlCachingImageView g;
    public FollowButton h;
    public View i;

    public a()
    {
        at = as.d();
    }

    public static a a(String s)
    {
        a a1 = new a();
        Bundle bundle = new Bundle();
        bundle.putString("artistId", s);
        a1.setArguments(bundle);
        return a1;
    }

    static ExpandableCustomFontTextView a(a a1)
    {
        return a1.f;
    }

    public static String a(String s, String s1)
    {
        String s2 = s;
        if (com.shazam.b.e.a.c(s))
        {
            s2 = s;
            if (com.shazam.b.e.a.c(s1))
            {
                s2 = (new StringBuilder()).append(s).append("\n\n").toString();
            }
        }
        return s2.concat(s1);
    }

    static EventAnalytics b(a a1)
    {
        return a1.aq;
    }

    static com.shazam.android.fragment.a.b c(a a1)
    {
        return a1.aA;
    }

    static Handler d(a a1)
    {
        return a1.ap;
    }

    static View e(a a1)
    {
        return a1.i;
    }

    static View f(a a1)
    {
        return a1.au;
    }

    private String k()
    {
        return getArguments().getString("artistId");
    }

    private void l()
    {
        av.setVisibility(0);
        au.setVisibility(8);
        m();
    }

    private void m()
    {
        aw = false;
        ax.setVisibility(8);
    }

    public final Map a()
    {
        return ak;
    }

    public final void a(android.support.v7.c.c c1)
    {
        int i1 = com.shazam.android.util.f.a(c1, 0x7f0f007f);
        (new com.shazam.android.activities.a(g, az)).a(i1, aB);
    }

    public final void a(Feed feed)
    {
    }

    public final void a(boolean flag)
    {
        ay = flag;
    }

    public final void b(Feed feed)
    {
        l();
        f.setExpandedWithoutAnimation(false);
        f.setClickable(true);
        c.a(feed.a());
    /* block-local class not found */
    class a {}

    /* block-local class not found */
    class c {}

        av.setOnScrollListener(new com.shazam.android.ad.d.b(new android.support.v7.widget.RecyclerView.l[] {
            new com.shazam.android.widget.h.c(this), new c((byte)0), new a((byte)0)
        }));
    }

    public final void c(Feed feed)
    {
        c.c(feed.a());
        m();
    }

    public final boolean c()
    {
        return ay;
    }

    public final boolean d()
    {
        return aw;
    }

    public final void e()
    {
        ax.setVisibility(0);
        aw = true;
        b.e();
    }

    public final AdvertSiteIdKey f()
    {
        return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.ARTIST);
    }

    public final void g()
    {
        l();
        if (c.g())
        {
            am.a();
            am.a(getActivity(), 0x7f0900ba, com.shazam.android.widget.d.b.c());
        }
    }

    public final void h()
    {
        au.setVisibility(8);
        f.setExpanded(true);
        f.setClickable(false);
        av.setOnScrollListener(null);
    }

    public final void i()
    {
        m();
        am.a();
        am.a(getActivity(), 0x7f0900ba, com.shazam.android.widget.d.b.c());
        ax.setVisibility(8);
    }

    public final void j()
    {
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        aA = (com.shazam.android.fragment.a.b)getActivity();
    }

    public final void onCreate(Bundle bundle)
    {
        boolean flag1 = true;
        super.onCreate(bundle);
        al = com.shazam.i.b.c.a.a(ar.j(k()));
        boolean flag;
        if (bundle == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!at || !flag)
        {
            flag1 = false;
        }
        aB = flag1;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030040, viewgroup, false));
    }

    public final void onDestroy()
    {
        super.onDestroy();
        b.d();
        c.f();
    }

    public final void onStop()
    {
        super.onStop();
        am.a();
        c.e();
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        au = view.findViewById(0x7f11013e);
        av = (FeedRecyclerView)view.findViewById(0x7f11013f);
        ax = view.findViewById(0x7f110140);
        aj = (ShazamAdView)view.findViewById(0x7f110004);
        i = LayoutInflater.from(getActivity()).inflate(0x7f03007d, null, false);
        e = (ArtistNameTextView)i.findViewById(0x7f1101e1);
        f = (ExpandableCustomFontTextView)i.findViewById(0x7f1101e4);
        g = (UrlCachingImageView)i.findViewById(0x7f1101e0);
        az = (RevealColorView)i.findViewById(0x7f1101de);
        h = (FollowButton)i.findViewById(0x7f1101e3);
        d = (TextView)i.findViewById(0x7f1101e2);
        c = al.a(getActivity());
        av.setAdapter(c);
        av.setOnScrollListener(new com.shazam.android.widget.h.c(this));
        b = ao.a(this, getActivity(), 204, 205, (g)an.create(k()), o.a);
    }

    // Unreferenced inner class com/shazam/android/fragment/a/a$b
    /* block-local class not found */
    class b {}


    // Unreferenced inner class com/shazam/android/fragment/a/a$d
    /* block-local class not found */
    class d {}

}
