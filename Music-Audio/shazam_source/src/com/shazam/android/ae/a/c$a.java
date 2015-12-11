// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae.a;

import com.shazam.android.ae.h;
import com.shazam.android.ae.i;
import com.shazam.android.ae.l;
import com.shazam.android.ae.n;
import com.shazam.android.ae.p;
import com.shazam.android.ae.r;
import com.shazam.android.ae.s;
import com.shazam.b.a.a;
import com.shazam.i.i.c;
import java.util.EnumMap;

// Referenced classes of package com.shazam.android.ae.a:
//            c

private final class <init>
    implements a.a.a.a.ject
{

    final com.shazam.android.ae.a.c a;

    public final void a(a.a.a.a.a a1)
    {
        Object obj = (com.shazam.android.j.q.a)com.shazam.android.ae.a.c.a(a).a(a1);
        obj = new h(c.a(), ((com.shazam.android.j.q.a) (obj)), new r());
        EnumMap enummap = new EnumMap(com/shazam/android/ae/n);
        enummap.put(n.a, l.a);
        enummap.put(n.b, l.a);
        enummap.put(n.c, l.a);
        enummap.put(n.d, l.a);
        enummap.put(n.e, new i(((h) (obj)), com.shazam.i.o.a.d()));
        obj = new s(enummap);
        a1 = a1.a;
        ((p) (obj)).a(n.e, "SHAZAM_ON_WEAR", a1.getMessage(), a1);
    }

    private (com.shazam.android.ae.a.c c1)
    {
        a = c1;
        super();
    }

    a(com.shazam.android.ae.a.c c1, byte byte0)
    {
        this(c1);
    }
}
