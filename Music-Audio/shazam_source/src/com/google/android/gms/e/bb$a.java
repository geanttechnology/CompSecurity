// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.ii;

// Referenced classes of package com.google.android.gms.e:
//            bb, u, aj

final class a
    implements a
{

    final bb a;

    public final void a(u u1)
    {
        bb.a(a, u1.a);
    }

    public final void b(u u1)
    {
        bb.a(a, u1.a);
        (new StringBuilder("Permanent failure dispatching hitId: ")).append(u1.a);
        aj.d();
    }

    public final void c(u u1)
    {
        long l = u1.b;
        if (l == 0L)
        {
            bb.a(a, u1.a, bb.a(a).a());
        } else
        if (l + 0xdbba00L < bb.a(a).a())
        {
            bb.a(a, u1.a);
            (new StringBuilder("Giving up on failed hitId: ")).append(u1.a);
            aj.d();
            return;
        }
    }

    (bb bb1)
    {
        a = bb1;
        super();
    }
}
