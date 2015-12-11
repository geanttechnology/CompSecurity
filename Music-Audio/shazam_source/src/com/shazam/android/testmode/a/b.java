// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.testmode.a;

import com.shazam.android.advert.d.d;
import com.shazam.android.p.i;
import com.shazam.b.e.a;
import com.shazam.server.response.config.Provider;
import java.util.Map;

// Referenced classes of package com.shazam.android.testmode.a:
//            e

public final class b
    implements e
{

    private final i a;
    private final String b;

    public b(i j, String s)
    {
        a = j;
        b = s;
    }

    public final Provider a()
    {
        Map map;
        if (com.shazam.b.e.a.c(b))
        {
            map = d.a(b);
        } else
        if (a.b)
        {
            map = d.a("1943168");
            map.put("promo", "1943170");
            map.put("tagresult", "1943164");
        } else
        {
            map = d.a("1943164");
            map.put("sponsorship", "1943175");
            map.put("nomatchlarge", "1943174");
            map.put("promo", "1943170");
            map.put("tagit", "1943165");
        }
        return com.shazam.server.response.config.Provider.Builder.provider().withName("appnexus").withSites(map).build();
    }
}
