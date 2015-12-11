// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            s

static final class a
{

    double a;

    private double b()
    {
        double d = (double)System.currentTimeMillis() / 1000D;
        d = a - d;
        if (d <= 0.0D)
        {
            return 0.0D;
        } else
        {
            return d;
        }
    }

    final void a(double d)
    {
        a = (double)System.currentTimeMillis() / 1000D + d;
    }

    final boolean a()
    {
        return b() == 0.0D;
    }

    public final String toString()
    {
        return s.a(b());
    }

    (double d)
    {
        a = System.currentTimeMillis();
        a(d);
    }
}
