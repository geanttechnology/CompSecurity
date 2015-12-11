// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a;

import c.s;
import java.io.Closeable;

// Referenced classes of package com.g.b.a:
//            b, k

public final class ng
    implements Closeable
{

    public final String a;
    public final long b;
    public final s c[];
    public final b d;
    private final long e[];

    public final void close()
    {
        s as[] = c;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            k.a(as[i]);
        }

    }

    private ng(b b1, String s, long l, s as[], long al[])
    {
        d = b1;
        super();
        a = s;
        b = l;
        c = as;
        e = al;
    }

    ng(b b1, String s, long l, s as[], long al[], byte byte0)
    {
        this(b1, s, l, as, al);
    }
}
