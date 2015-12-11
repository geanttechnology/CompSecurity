// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class t
{

    public static final t b = new t() {

        public final t a(long l)
        {
            return this;
        }

        public final t a(long l, TimeUnit timeunit)
        {
            return this;
        }

        public final void f()
        {
        }

    };
    private boolean a;
    private long c;
    private long d;

    public t()
    {
    }

    public boolean A_()
    {
        return a;
    }

    public t B_()
    {
        a = false;
        return this;
    }

    public t a(long l)
    {
        a = true;
        c = l;
        return this;
    }

    public t a(long l, TimeUnit timeunit)
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

    public long c()
    {
        if (!a)
        {
            throw new IllegalStateException("No deadline");
        } else
        {
            return c;
        }
    }

    public t d()
    {
        d = 0L;
        return this;
    }

    public void f()
    {
        if (Thread.interrupted())
        {
            throw new InterruptedIOException("thread interrupted");
        }
        if (a && c - System.nanoTime() <= 0L)
        {
            throw new InterruptedIOException("deadline reached");
        } else
        {
            return;
        }
    }

    public long z_()
    {
        return d;
    }

}
