// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import java.util.concurrent.TimeUnit;

// Referenced classes of package c:
//            t

public final class j extends t
{

    public t a;

    public j(t t1)
    {
        if (t1 == null)
        {
            throw new IllegalArgumentException("delegate == null");
        } else
        {
            a = t1;
            return;
        }
    }

    public final boolean A_()
    {
        return a.A_();
    }

    public final t B_()
    {
        return a.B_();
    }

    public final t a(long l)
    {
        return a.a(l);
    }

    public final t a(long l, TimeUnit timeunit)
    {
        return a.a(l, timeunit);
    }

    public final long c()
    {
        return a.c();
    }

    public final t d()
    {
        return a.d();
    }

    public final void f()
    {
        a.f();
    }

    public final long z_()
    {
        return a.z_();
    }
}
