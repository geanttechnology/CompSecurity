// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.e;

import com.facebook.ads.a;
import com.facebook.ads.b;
import com.facebook.ads.c;
import com.facebook.ads.k;

// Referenced classes of package com.shazam.android.advert.e:
//            d, g, e, f

public final class i
    implements c, d
{

    private final String a;
    private final k b;
    private g c;
    private e d;

    public i(String s, k k1)
    {
        c = com.shazam.android.advert.e.g.a;
        d = com.shazam.android.advert.e.e.a;
        a = s;
        b = k1;
    }

    public final void a()
    {
        b.a();
    }

    public final void a(a a1)
    {
        a1 = c;
        f.a a2 = new f.a();
        a2.c = a;
        a2.b = this;
        a2.a = b;
        a1.a(new f(a2, (byte)0));
    }

    public final void a(a a1, b b1)
    {
        c.a(b1.g);
    }

    public final void a(e e1)
    {
        d = e1;
        b.a = this;
    }

    public final void a(g g1)
    {
        c = g1;
        b.a = this;
    }

    public final String b()
    {
        return a;
    }

    public final void b(a a1)
    {
        d.a();
    }
}
