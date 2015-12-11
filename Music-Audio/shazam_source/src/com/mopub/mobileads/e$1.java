// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.c.b;
import com.mopub.common.c.a;
import com.mopub.d.s;
import java.util.TreeMap;

// Referenced classes of package com.mopub.mobileads:
//            e, c

final class a
    implements com.mopub.c.
{

    final e a;

    public final void a(b b1)
    {
        e e1 = a;
        e1.h = 1;
        e1.e = b1;
        String s;
        int i;
        if (e1.e.i == null)
        {
            i = e1.p;
        } else
        {
            i = e1.e.i.intValue();
        }
        e1.p = i;
        e1.r = e1.e.j;
        e1.b();
        b1 = e1.e;
        com.mopub.common.c.a.c("Performing custom event.");
        s = b1.m;
        if (s != null)
        {
            b1 = new <init>(e1, s, new TreeMap(b1.n));
        } else
        {
            com.mopub.common.c.a.c("Failed to create custom event.");
            b1 = null;
        }
        if (b1 != null)
        {
            b1.a();
        }
        e1.d();
    }

    public final void a(s s)
    {
        a.a(s);
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
