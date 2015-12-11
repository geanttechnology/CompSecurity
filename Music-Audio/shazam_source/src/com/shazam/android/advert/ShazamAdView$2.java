// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;

import com.shazam.android.advert.i.a;
import com.shazam.model.advert.AdvertSiteIdKey;
import java.util.Map;

// Referenced classes of package com.shazam.android.advert:
//            ShazamAdView

final class c
    implements Runnable
{

    final String a;
    final AdvertSiteIdKey b;
    final Map c;
    final ShazamAdView d;

    public final void run()
    {
        ShazamAdView.b(d);
        ShazamAdView.c(d).a(a, b, c);
    }

    (ShazamAdView shazamadview, String s, AdvertSiteIdKey advertsiteidkey, Map map)
    {
        d = shazamadview;
        a = s;
        b = advertsiteidkey;
        c = map;
        super();
    }
}
