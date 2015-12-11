// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.web;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import com.shazam.android.ad.f;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.ErrorEventFactory;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.analytics.session.page.WebPage;
import com.shazam.android.k.b.a.a;
import com.shazam.android.k.f.ab;
import com.shazam.android.k.f.r;
import com.shazam.android.l.j.c;
import com.shazam.android.persistence.r.b;
import com.shazam.android.v.e.j;
import com.shazam.android.web.bridge.h;
import com.shazam.i.b.o.c.d;
import com.shazam.model.Factory;
import com.shazam.model.Tag;
import com.shazam.model.Track;
import com.shazam.model.TrackLayoutType;
import com.shazam.model.analytics.ScreenOrigin;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.fragment.web:
//            WebFragment, b, a

public class TrackWebFragment extends WebFragment
    implements SessionConfigurable, a
{

    private com.shazam.android.k.b.a.c aj;
    private WebPage ak;
    private Tag al;
    private boolean am;
    private final EventAnalytics b;
    private final Factory c;
    private final com.shazam.b.a.a d;
    private final b e;
    private final ab f;
    private String g;
    private String h;
    private String i;

    public TrackWebFragment()
    {
        this(com.shazam.i.b.ax.a.a(), ((com.shazam.android.activities.a.d) (new f())), com.shazam.i.b.g.b.a.a(), ((Factory) (new j())), ((com.shazam.b.a.a) (new c())));
    }

    private TrackWebFragment(com.shazam.android.web.f f1, com.shazam.android.activities.a.d d1, EventAnalytics eventanalytics, Factory factory, com.shazam.b.a.a a1)
    {
        super(f1, d1);
        e = com.shazam.i.b.ah.f.f.a(com.shazam.i.b.c.a());
        f = com.shazam.i.b.o.c.d.a();
        b = eventanalytics;
        c = factory;
        d = a1;
    }

    public static WebFragment a(String s, String s1, boolean flag, Uri uri, String s2, String s3, String s4, String s5, 
            String s6, String s7)
    {
        TrackWebFragment trackwebfragment = new TrackWebFragment();
        s = com.shazam.android.fragment.web.WebFragment.a(s, s1, flag, false, s5, s7, s6);
        s.putParcelable("tagUri", uri);
        s.putString("trackId", s2);
        s.putString("beaconKey", s3);
        s.putString("campaign", s4);
        trackwebfragment.setArguments(s);
        return trackwebfragment;
    }

    private Uri m()
    {
        return (Uri)getArguments().getParcelable("tagUri");
    }

    private boolean n()
    {
        return al != null && al.track != null && al.track.trackLayoutType == TrackLayoutType.LOCAL_WEB;
    }

    public final void a(WebPage webpage)
    {
        super.a(webpage);
        r r1 = r.a((Uri)getArguments().getParcelable("tagUri"));
        ak = webpage;
        ak.populateFromShazamUri(r1);
        ak.setBeaconKey(h);
        ak.setCampaign(i);
        ak.setTrackId(g);
        if (n())
        {
            webpage.setPageName("barcodewebview");
        }
    }

    public final void a(Tag tag)
    {
        al = tag;
        Object obj = m();
        com.shazam.model.details.UriIdentifiedTag.Builder builder = com.shazam.model.details.UriIdentifiedTag.Builder.a();
        builder.tag = tag;
        builder.uri = ((Uri) (obj));
        tag = builder.b();
        tag = (com.shazam.android.ag.c)d.a(tag);
        if (ak != null && n())
        {
            ak.setPageName("barcodewebview");
        }
        obj = k();
        if (obj != null)
        {
            for (Iterator iterator = ((com.shazam.android.fragment.web.b) (obj)).a(com/shazam/android/web/bridge/h).iterator(); iterator.hasNext(); ((h)iterator.next()).receiveTagInfo(tag)) { }
            if (((com.shazam.android.ag.c) (tag)).h == null)
            {
                tag = ScreenOrigin.MISCELLANEOUS_WEB_VIEW;
            } else
            {
                tag = ((com.shazam.android.ag.c) (tag)).h;
            }
            b(tag, ((com.shazam.android.fragment.web.b) (obj)));
        }
    }

    protected final void a(ScreenOrigin screenorigin, com.shazam.android.fragment.web.b b1)
    {
    }

    public final void a(String s, com.shazam.android.web.bridge.d.a a1)
    {
        super.a(s, a1);
        if (!am && n())
        {
            am = true;
            e.a(al.track.id, s);
            f.a();
        }
    }

    public void configureWith(Page page)
    {
        a((WebPage)page);
    }

    public final void e()
    {
        super.e();
        b.logEvent(ErrorEventFactory.mediaUnitLoadFailureErrorEvent(g, h, i));
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        activity = m();
        Object obj = com.shazam.android.fragment.web.a.a(activity);
        getChildFragmentManager().a().a(((android.support.v4.app.Fragment) (obj)), "InvisibleTagDetailsFragment").a();
        g = getArguments().getString("trackId");
        h = getArguments().getString("beaconKey");
        i = getArguments().getString("campaign");
        obj = c;
        com.shazam.android.k.b.a.b.a a1 = new com.shazam.android.k.b.a.b.a();
        a1.a = getActivity();
        a1.b = activity;
        aj = (com.shazam.android.k.b.a.c)((Factory) (obj)).create(a1.a());
        aj.a = this;
    }

    public void onResume()
    {
        super.onResume();
        aj.a(getLoaderManager());
    }
}
