// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.zip.Deflater;

// Referenced classes of package com.paypal.android.sdk:
//            lh, kz, kr, kq, 
//            lf, lg, lm, lk

public final class ku
    implements lh
{

    private final kr a;
    private final Deflater b;
    private boolean c;

    private ku(kr kr1, Deflater deflater)
    {
        if (kr1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = kr1;
            b = deflater;
            return;
        }
    }

    public ku(lh lh1, Deflater deflater)
    {
        this(kz.a(lh1), deflater);
    }

    private void a(boolean flag)
    {
        kq kq1 = a.b();
        lf lf1;
label0:
        do
        {
            do
            {
                lf1 = kq1.e(1);
                int i;
                if (flag)
                {
                    i = b.deflate(lf1.a, lf1.c, 2048 - lf1.c, 2);
                } else
                {
                    i = b.deflate(lf1.a, lf1.c, 2048 - lf1.c);
                }
                if (i <= 0)
                {
                    continue label0;
                }
                lf1.c = lf1.c + i;
                kq1.b = kq1.b + (long)i;
                a.o();
            } while (true);
        } while (!b.needsInput());
        if (lf1.b == lf1.c)
        {
            kq1.a = lf1.a();
            lg.a(lf1);
        }
    }

    public final lk a()
    {
        return a.a();
    }

    public final void a_(kq kq1, long l)
    {
        lm.a(kq1.b, 0L, l);
        int i;
        for (; l > 0L; l -= i)
        {
            lf lf1 = kq1.a;
            i = (int)Math.min(l, lf1.c - lf1.b);
            b.setInput(lf1.a, lf1.b, i);
            a(false);
            kq1.b = kq1.b - (long)i;
            lf1.b = lf1.b + i;
            if (lf1.b == lf1.c)
            {
                kq1.a = lf1.a();
                lg.a(lf1);
            }
        }

    }

    public final void close()
    {
        if (!c) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Throwable throwable;
        Throwable throwable1;
        throwable1 = null;
        try
        {
            b.finish();
            a(false);
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable1) { }
        b.end();
        throwable = throwable1;
_L3:
        a.close();
        throwable1 = throwable;
_L4:
        c = true;
        if (throwable1 != null)
        {
            lm.a(throwable1);
            return;
        }
          goto _L1
        throwable;
        if (throwable1 != null)
        {
            throwable = throwable1;
        }
          goto _L3
        Throwable throwable2;
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
          goto _L4
    }

    public final void flush()
    {
        a(true);
        a.flush();
    }

    public final String toString()
    {
        return (new StringBuilder("DeflaterSink(")).append(a).append(")").toString();
    }
}
