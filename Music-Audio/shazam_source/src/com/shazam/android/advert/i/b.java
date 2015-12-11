// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.i;

import android.content.Context;
import android.util.Pair;
import com.amazon.device.ads.w;
import com.appnexus.opensdk.ap;
import com.appnexus.opensdk.b.j;
import com.appnexus.opensdk.e;
import com.appnexus.opensdk.f;
import com.appnexus.opensdk.k;
import com.appnexus.opensdk.o;
import com.appnexus.opensdk.r;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.advert.c.a;
import com.shazam.android.advert.l;
import com.shazam.android.advert.m;
import com.shazam.android.util.g;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.configuration.location.LocationConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.android.advert.i:
//            a

public final class b extends o
    implements com.shazam.android.advert.i.a
{

    private static final com.shazam.android.advert.a u = null;
    private final f v = new f() {

        final b a;

        public final void a()
        {
            b.c(a).a(com.shazam.android.advert.i.b.a(a), m.a, com.shazam.android.advert.i.b.k(), b.b(a));
        }

        public final void a(k k1)
        {
            b.c(a).a(com.shazam.android.advert.i.b.a(a), m.a, b.b(a));
            k1.setVisibility(0);
        }

        public final void b()
        {
            l l1 = b.c(a);
            com.shazam.android.advert.i.b.a(a);
            l1.b();
        }

        public final void c()
        {
            l l1 = b.c(a);
            com.shazam.android.advert.i.b.a(a);
            l1.c();
        }

        public final void d()
        {
            b.c(a).b(com.shazam.android.advert.i.b.a(a), m.a, b.b(a));
        }

            
            {
                a = b.this;
                super();
            }
    };
    private l w;
    private final com.shazam.android.advert.c.b x;
    private final LocationConfiguration y;
    private String z;

    public b(Context context, com.shazam.android.advert.c.b b1, LocationConfiguration locationconfiguration)
    {
        super(g.a(context));
        w = l.b;
        x = b1;
        y = locationconfiguration;
        com.amazon.device.ads.w.a("5947594e4d534a56494152344a524944");
        j.a().s = 3;
        setLoadsInBackground(false);
        setShowLoadingIndicator(false);
        setOverrideMaxSize(true);
        setShouldServePSAs(false);
        setAutoRefreshInterval(0);
        setShouldReloadOnResume(false);
    }

    static ShazamAdView a(b b1)
    {
        return b1.getShazamAdView();
    }

    static String b(b b1)
    {
        return b1.z;
    }

    static l c(b b1)
    {
        return b1.w;
    }

    private ShazamAdView getShazamAdView()
    {
        return (ShazamAdView)getParent();
    }

    static com.shazam.android.advert.a k()
    {
        return u;
    }

    public final void a(String s, AdvertSiteIdKey advertsiteidkey, Map map)
    {
        z = s;
        advertsiteidkey = x.a(advertsiteidkey);
        int i = ((a) (advertsiteidkey)).a;
        int i1 = ((a) (advertsiteidkey)).b;
        com.appnexus.opensdk.b.b.b(com.appnexus.opensdk.b.b.b, com.appnexus.opensdk.b.b.a(com.appnexus.opensdk.an.d.set_max_size, i, i1));
        advertsiteidkey = super.j;
        advertsiteidkey.n = i;
        advertsiteidkey.o = i1;
        boolean flag = y.a();
        j.a().q = flag;
        super.j.l.clear();
        advertsiteidkey = map.entrySet().iterator();
        do
        {
            if (!advertsiteidkey.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)advertsiteidkey.next();
            map = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
            ap ap1 = super.j;
            if (!com.appnexus.opensdk.b.k.a(map) && obj != null)
            {
                ap1.l.add(new Pair(map, obj));
            }
        } while (true);
        setPlacementID(s);
        if (a() && super.a != null)
        {
            super.a.a();
            s = super.a;
            s.b = -1L;
            s.c = -1L;
            super.a.b();
            super.g = true;
        }
        w.a();
    }

    public final void b()
    {
        if (super.r != null)
        {
            super.r.onPause();
        }
    }

    public final void d()
    {
        w = l.b;
        setAdListener(null);
    }

    public final void h_()
    {
        if (super.r != null)
        {
            super.r.onResume();
        }
    }

    public final void i_()
    {
        k_();
        if (super.r != null)
        {
            super.r.f();
            super.r = null;
        }
    }

    public final void setListener(l l1)
    {
        w = l1;
        setAdListener(v);
    }

}
