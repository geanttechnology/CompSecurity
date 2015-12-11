// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            lk

public final class kw extends lk
{

    private lk b;

    public kw(lk lk1)
    {
        if (lk1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            b = lk1;
            return;
        }
    }

    public final kw a(lk lk1)
    {
        if (lk1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            b = lk1;
            return this;
        }
    }

    public final lk a()
    {
        return b;
    }

    public final lk a(long l)
    {
        return b.a(l);
    }

    public final lk a(long l, TimeUnit timeunit)
    {
        return b.a(l, timeunit);
    }

    public final long b_()
    {
        return b.b_();
    }

    public final boolean c_()
    {
        return b.c_();
    }

    public final long d_()
    {
        return b.d_();
    }

    public final lk e()
    {
        return b.e();
    }

    public final lk f()
    {
        return b.f();
    }

    public final void g()
    {
        b.g();
    }
}
