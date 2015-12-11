// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.d;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.i;
import android.support.v4.app.o;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Space;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.NewsFeedEventFactory;
import com.shazam.android.k.b.d;
import com.shazam.android.widget.feed.f;
import com.shazam.android.widget.feed.j;
import com.shazam.android.widget.feed.l;
import com.shazam.b.e.a;
import com.shazam.g.e;
import com.shazam.model.advert.Ad;
import com.shazam.model.advert.AdType;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.analytics.event.DefinedEventParameterKey;
import com.shazam.model.availability.GooglePlayAvailability;
import com.shazam.model.news.ChartFeedCard;
import com.shazam.model.news.FeedCard;
import com.shazam.model.news.FeedCardType;
import com.shazam.model.news.SponsoredFeedCard;
import com.shazam.o.b;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSettings;
import com.shazam.server.response.config.QuizFallbackAmpSetting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.shazam.android.a.d:
//            e, d, f, a

public final class com.shazam.android.a.d.c extends com.shazam.android.a.d.e
{
    private final class a
        implements android.view.ViewTreeObserver.OnPreDrawListener
    {

        final com.shazam.android.a.d.c a;
        private final View b;

        public final boolean onPreDraw()
        {
            b.getViewTreeObserver().removeOnPreDrawListener(this);
            a.h = b.getWidth();
            a.d();
            return false;
        }

        public a(View view)
        {
            a = com.shazam.android.a.d.c.this;
            super();
            b = view;
        }
    }

    private final class b
        implements com.shazam.android.advert.g.c
    {

        final com.shazam.android.a.d.c a;
        private final FeedCard c;

        private void a(Ad ad, int i1)
        {
            int j1 = com.shazam.android.a.d.c.a(a, c.id);
            if (com.shazam.android.a.d.c.e(j1))
            {
                com.shazam.android.a.d.c c1 = a;
                com.shazam.model.news.AdFeedCard.Builder builder = com.shazam.model.news.AdFeedCard.Builder.a();
                builder.sponsorshipText = a.c.getString(i1);
                builder.ad = ad;
                builder.id = c.id;
                ad = builder.b();
                c1.e.set(j1, ad);
                a.h(j1);
            }
        }

        public final void a(Ad ad)
        {
            a(ad, 0x7f090129);
        }

        public final void b(Ad ad)
        {
            if (a.g.a.a().getSettings().getQuizFallback().isEnabled())
            {
                ad = com.shazam.model.advert.Ad.Builder.a();
                ad.adType = AdType.FALLBACK_QUIZ;
                a(ad.b(), 0x7f090115);
            } else
            {
                if (a.d.a())
                {
                    a(ad, 0x7f090112);
                    return;
                }
                int i1 = com.shazam.android.a.d.c.a(a, c.id);
                if (com.shazam.android.a.d.c.e(i1))
                {
                    ad = a;
                    ((com.shazam.android.a.d.c) (ad)).e.remove(i1);
                    ad.g(i1);
                    return;
                }
            }
        }

        public b(FeedCard feedcard)
        {
            a = com.shazam.android.a.d.c.this;
            super();
            c = feedcard;
        }
    }

    private final class c
        implements com.shazam.g.f
    {

        final com.shazam.android.a.d.c a;
        private final ChartFeedCard b;

        public final void onDataFailedToLoad()
        {
            (new StringBuilder("Failed to load data for chart card: ")).append(b);
        }

        public final void onDataFetched(Object obj)
        {
            obj = (List)obj;
            int i1 = com.shazam.android.a.d.c.a(a, ((FeedCard) (b)).id);
            if (com.shazam.android.a.d.c.e(i1))
            {
                com.shazam.model.news.ChartFeedCard.Builder builder = com.shazam.model.news.ChartFeedCard.Builder.a(b);
                builder.tracks = ((List) (obj));
                obj = builder.b();
                a.e.set(i1, obj);
                a.h(i1);
            }
        }

        public c(ChartFeedCard chartfeedcard)
        {
            a = com.shazam.android.a.d.c.this;
            super();
            b = chartfeedcard;
        }
    }

    private final class d
        implements android.view.View.OnClickListener
    {

        final com.shazam.android.a.d.c a;
        private final com.shazam.android.widget.c.a b = com.shazam.i.b.ay.a.a.c();
        private final EventAnalyticsFromView c = com.shazam.i.b.g.b.a.b();
        private final int d;
        private final FeedCard e;

        public final void onClick(View view)
        {
            Object obj;
            FeedCard feedcard;
            com.shazam.android.k.f.i i1;
            obj = e;
            int j1 = d;
            c.logEvent(view, NewsFeedEventFactory.createEventForTappingCard(((FeedCard) (obj)), j1));
            feedcard = e;
            obj = new com.shazam.android.k.f.i.a();
            obj.a = com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.SCREEN_ORIGIN, ScreenOrigin.HOME.value).a(DefinedEventParameterKey.EVENT_ID, feedcard.id).a(DefinedEventParameterKey.ORIGIN, ScreenOrigin.HOME.value).b();
            i1 = ((com.shazam.android.k.f.i.a) (obj)).a();
            static final class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[FeedCardType.values().length];
                    try
                    {
                        a[FeedCardType.TAG.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[FeedCardType.TRACK.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[FeedCardType.ARTIST_POST.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (com.shazam.android.a.d._cls1.a[feedcard.a().ordinal()])
            {
            default:
                obj = null;
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
                break MISSING_BLOCK_LABEL_170;
            }
_L1:
            if (obj == null)
            {
                b.a(view.getContext(), feedcard.c(), i1);
            } else
            {
                b.a(((View) (obj)), feedcard.c(), i1);
            }
            if (view instanceof com.shazam.android.a.d.a)
            {
                ((com.shazam.android.a.d.a)view).e();
            }
            return;
            obj = view.findViewById(0x7f110023);
              goto _L1
        }

        public d(int i1, FeedCard feedcard)
        {
            a = com.shazam.android.a.d.c.this;
            super();
            d = i1;
            e = feedcard;
        }
    }


    final Resources c;
    final GooglePlayAvailability d;
    public final List e = new ArrayList();
    public final List f = new ArrayList();
    final com.shazam.android.j.s.a g;
    int h;
    private final l k;
    private final com.shazam.android.advert.g.b l;
    private final o m;
    private final Set n = new HashSet();
    private boolean o;

    public com.shazam.android.a.d.c(i i1, l l1, com.shazam.android.advert.g.b b1, GooglePlayAvailability googleplayavailability, Handler handler, com.shazam.android.j.s.a a1)
    {
        super(handler);
        k = l1;
        l = b1;
        d = googleplayavailability;
        c = i1.getResources();
        m = i1.getSupportLoaderManager();
        g = a1;
    }

    static int a(com.shazam.android.a.d.c c1, String s)
    {
        for (int i1 = 0; i1 < c1.e.size(); i1++)
        {
            String s1 = ((FeedCard)c1.e.get(i1)).id;
            if (s1 != null && s1.equals(s))
            {
                return i1;
            }
        }

        return -1;
    }

    static boolean e(int i1)
    {
        return i1 != -1;
    }

    private void h()
    {
        super.a.a();
        f();
        d();
    }

    protected final android.support.v7.widget.RecyclerView.u a(ViewGroup viewgroup)
    {
        View view;
        if (!f.isEmpty())
        {
            view = (View)f.get(0);
        } else
        {
            view = null;
        }
        if (view != null)
        {
            viewgroup = new com.shazam.android.a.d.d(view);
            viewgroup.a(false);
            return viewgroup;
        } else
        {
            return new com.shazam.android.a.d.d(new Space(viewgroup.getContext()));
        }
    }

    protected final void a(android.support.v7.widget.RecyclerView.u u)
    {
        android.support.v7.widget.StaggeredGridLayoutManager.b b1 = new android.support.v7.widget.StaggeredGridLayoutManager.b(-1);
        b1.f = true;
        u.a.setLayoutParams(b1);
    }

    public final void a(List list)
    {
        e.clear();
        e.addAll(list);
        o = false;
        h();
    }

    public final int b()
    {
        return f.size();
    }

    protected final android.support.v7.widget.RecyclerView.u b(ViewGroup viewgroup, int i1)
    {
        FeedCardType feedcardtype = FeedCardType.from(i1);
        viewgroup = k.a(viewgroup.getContext(), feedcardtype);
        if (!o)
        {
            o = true;
            viewgroup.getViewTreeObserver().addOnPreDrawListener(new a(viewgroup));
        }
        viewgroup = new com.shazam.android.a.d.d(viewgroup);
        viewgroup.a(feedcardtype.isRecyclable());
        return viewgroup;
    }

    public final void b(List list)
    {
        f.clear();
        f.addAll(list);
        h();
    }

    public final int c()
    {
        return e.size();
    }

    protected final void c(android.support.v7.widget.RecyclerView.u u, int i1)
    {
        Object obj = (FeedCard)e.get(i1);
        if (!(u.a instanceof com.shazam.android.a.d.f))
        {
            u.a.setOnClickListener(new d(i1, ((FeedCard) (obj))));
        }
        View view = u.a;
        if (view instanceof j)
        {
            ((j)view).a(((FeedCard) (obj)), i1, c());
            if (obj instanceof ChartFeedCard)
            {
                u = (ChartFeedCard)obj;
                obj = (f)view;
                if (com.shazam.b.e.a.c(((ChartFeedCard) (u)).url) && com.shazam.o.b.a(((ChartFeedCard) (u)).tracks))
                {
                    obj = new com.shazam.android.k.b.d(m, com.shazam.i.b.o.a.a.a().a(Uri.parse(((ChartFeedCard) (u)).url)), ((f) (obj)).getContext(), com.shazam.android.k.c.a(new com.shazam.android.k.e.a.a(com.shazam.i.c.b.a(), ((ChartFeedCard) (u)).url), com.shazam.i.d.c.a(((f) (obj)).getNumberOfTracks())), com.shazam.android.k.b.i.a);
                    ((e) (obj)).a(new c(u));
                    ((e) (obj)).a();
                    n.add(obj);
                }
            }
        }
    }

    public final void c(List list)
    {
        int i1 = e.size();
        e.addAll(list);
        a(i1, list.size());
    }

    protected final int d(int i1)
    {
        return ((FeedCard)e.get(i1)).a().getIntegerId();
    }

    final void d()
    {
        if (h > 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj = e.iterator();
        FeedCard feedcard;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            feedcard = (FeedCard)((Iterator) (obj)).next();
        } while (!(feedcard instanceof SponsoredFeedCard));
        obj = ((SponsoredFeedCard)feedcard).siteKey;
        int i1 = h;
        if (com.shazam.b.e.a.c(((String) (obj))))
        {
            com.shazam.model.advert.AdvertSiteIdKey.Builder builder = com.shazam.model.advert.AdvertSiteIdKey.Builder.a();
            builder.siteIdKey = ((String) (obj));
            obj = builder.b();
            l.a(((com.shazam.model.advert.AdvertSiteIdKey) (obj)), i1, new b(feedcard));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void e()
    {
        for (Iterator iterator = n.iterator(); iterator.hasNext(); ((e)iterator.next()).b()) { }
    }

    public final void f()
    {
        l.a();
    }

    public final boolean g()
    {
        return e.isEmpty();
    }
}
