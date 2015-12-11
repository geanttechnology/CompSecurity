// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.sql.Timestamp;

// Referenced classes of package com.tapjoy.internal:
//            cm, gd, gf, s, 
//            u, ch

final class a
    implements cm
{

    final String a;
    final gd b;

    public final void a(ch ch)
    {
    }

    public final void a(ch ch, Object obj)
    {
        ch = gf.a(gd.a(b));
        obj = a;
        Object obj1 = ((s) (ch)).b;
        obj1 = ((s) (ch)).a;
        long l;
        if (0L != 0L)
        {
            l = System.currentTimeMillis() + 0L;
        } else
        {
            l = 0L;
        }
        if (!((String) (obj)).equals(((s) (ch)).b.b(((s) (ch)).a)))
        {
            return;
        }
        ((s) (ch)).b.b(((s) (ch)).a, true);
        if (l != 0L)
        {
            new Timestamp(l);
        }
        ((s) (ch)).b.a(((s) (ch)).a, l);
    }

    (gd gd1, String s1)
    {
        b = gd1;
        a = s1;
        super();
    }
}
