// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.e;

import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.advert.l;
import com.shazam.android.advert.m;

// Referenced classes of package com.shazam.android.advert.e:
//            g, f

public final class a
    implements g
{

    private static final ShazamAdView b = null;
    private final String c;
    private final l d;

    public a(String s, l l1)
    {
        c = s;
        d = l1;
    }

    public final void a(int i)
    {
        l l1 = d;
        ShazamAdView shazamadview = b;
        m m1 = m.b;
        com.shazam.android.advert.a a1 = new com.shazam.android.advert.a();
        a1.a = i;
        l1.a(shazamadview, m1, a1.a(), c);
    }

    public final void a(f f)
    {
        d.a(b, m.b, c);
    }

}
