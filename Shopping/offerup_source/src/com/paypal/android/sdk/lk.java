// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            ll

public class lk
{

    public static final lk a = new ll();
    private boolean b;
    private long c;
    private long d;

    public lk()
    {
    }

    public lk a(long l)
    {
        b = true;
        c = l;
        return this;
    }

    public lk a(long l, TimeUnit timeunit)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("timeout < 0: ")).append(l).toString());
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        } else
        {
            d = timeunit.toNanos(l);
            return this;
        }
    }

    public long b_()
    {
        return d;
    }

    public boolean c_()
    {
        return b;
    }

    public long d_()
    {
        if (!b)
        {
            throw new IllegalStateException("No deadline");
        } else
        {
            return c;
        }
    }

    public lk e()
    {
        d = 0L;
        return this;
    }

    public lk f()
    {
        b = false;
        return this;
    }

    public void g()
    {
        if (Thread.interrupted())
        {
            throw new InterruptedIOException("thread interrupted");
        }
        if (b && c - System.nanoTime() <= 0L)
        {
            throw new InterruptedIOException("deadline reached");
        } else
        {
            return;
        }
    }

}
