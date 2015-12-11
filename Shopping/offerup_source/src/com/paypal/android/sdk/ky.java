// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

// Referenced classes of package com.paypal.android.sdk:
//            lj, kz, ks, kq, 
//            lf, lg, lk

public final class ky
    implements lj
{

    private final ks a;
    private final Inflater b;
    private int c;
    private boolean d;

    ky(ks ks1, Inflater inflater)
    {
        if (ks1 == null)
        {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null)
        {
            throw new IllegalArgumentException("inflater == null");
        } else
        {
            a = ks1;
            b = inflater;
            return;
        }
    }

    public ky(lj lj1, Inflater inflater)
    {
        this(kz.a(lj1), inflater);
    }

    private void c()
    {
        if (c == 0)
        {
            return;
        } else
        {
            int i = c - b.getRemaining();
            c = c - i;
            a.f(i);
            return;
        }
    }

    public final long a(kq kq1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (d)
        {
            throw new IllegalStateException("closed");
        }
        if (l == 0L)
        {
            return 0L;
        }
_L2:
        boolean flag = b();
        lf lf1;
        int i;
        try
        {
            lf1 = kq1.e(1);
            i = b.inflate(lf1.a, lf1.c, 2048 - lf1.c);
        }
        // Misplaced declaration of an exception variable
        catch (kq kq1)
        {
            throw new IOException(kq1);
        }
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        lf1.c = lf1.c + i;
        kq1.b = kq1.b + (long)i;
        return (long)i;
        if (b.finished() || b.needsDictionary())
        {
            c();
            if (lf1.b == lf1.c)
            {
                kq1.a = lf1.a();
                lg.a(lf1);
            }
            break MISSING_BLOCK_LABEL_209;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        throw new EOFException("source exhausted prematurely");
        return -1L;
    }

    public final lk a()
    {
        return a.a();
    }

    public final boolean b()
    {
        if (!b.needsInput())
        {
            return false;
        }
        c();
        if (b.getRemaining() != 0)
        {
            throw new IllegalStateException("?");
        }
        if (a.c())
        {
            return true;
        } else
        {
            lf lf1 = a.b().a;
            c = lf1.c - lf1.b;
            b.setInput(lf1.a, lf1.b, c);
            return false;
        }
    }

    public final void close()
    {
        if (d)
        {
            return;
        } else
        {
            b.end();
            d = true;
            a.close();
            return;
        }
    }
}
