// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.InputStream;

// Referenced classes of package com.paypal.android.sdk:
//            lj, lk, kq, lf

final class lb
    implements lj
{

    private lk a;
    private InputStream b;

    lb(lk lk1, InputStream inputstream)
    {
        a = lk1;
        b = inputstream;
        super();
    }

    public final long a(kq kq1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (l == 0L)
        {
            return 0L;
        }
        a.g();
        lf lf1 = kq1.e(1);
        int i = (int)Math.min(l, 2048 - lf1.c);
        i = b.read(lf1.a, lf1.c, i);
        if (i == -1)
        {
            return -1L;
        } else
        {
            lf1.c = lf1.c + i;
            kq1.b = kq1.b + (long)i;
            return (long)i;
        }
    }

    public final lk a()
    {
        return a;
    }

    public final void close()
    {
        b.close();
    }

    public final String toString()
    {
        return (new StringBuilder("source(")).append(b).append(")").toString();
    }
}
