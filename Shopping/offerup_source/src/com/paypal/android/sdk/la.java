// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.OutputStream;

// Referenced classes of package com.paypal.android.sdk:
//            lh, kq, lm, lk, 
//            lf, lg

final class la
    implements lh
{

    private lk a;
    private OutputStream b;

    la(lk lk1, OutputStream outputstream)
    {
        a = lk1;
        b = outputstream;
        super();
    }

    public final lk a()
    {
        return a;
    }

    public final void a_(kq kq1, long l)
    {
        lm.a(kq1.b, 0L, l);
        do
        {
            if (l <= 0L)
            {
                break;
            }
            a.g();
            lf lf1 = kq1.a;
            int i = (int)Math.min(l, lf1.c - lf1.b);
            b.write(lf1.a, lf1.b, i);
            lf1.b = lf1.b + i;
            long l1 = l - (long)i;
            kq1.b = kq1.b - (long)i;
            l = l1;
            if (lf1.b == lf1.c)
            {
                kq1.a = lf1.a();
                lg.a(lf1);
                l = l1;
            }
        } while (true);
    }

    public final void close()
    {
        b.close();
    }

    public final void flush()
    {
        b.flush();
    }

    public final String toString()
    {
        return (new StringBuilder("sink(")).append(b).append(")").toString();
    }
}
