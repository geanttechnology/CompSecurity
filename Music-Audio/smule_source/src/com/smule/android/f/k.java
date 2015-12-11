// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import java.util.Collection;

// Referenced classes of package com.smule.android.f:
//            j

public class k
{

    private boolean a;
    private boolean b;
    private long c;
    public String e;
    public Collection f;
    public Runnable g;
    protected k h;

    public k()
    {
        a = false;
        b = false;
        c = 0L;
        h = this;
    }

    static long a(k k1, long l)
    {
        k1.c = l;
        return l;
    }

    static boolean a(k k1)
    {
        return k1.a;
    }

    static boolean a(k k1, boolean flag)
    {
        k1.b = flag;
        return flag;
    }

    static boolean b(k k1)
    {
        return k1.b;
    }

    static boolean b(k k1, boolean flag)
    {
        k1.a = flag;
        return flag;
    }

    static long c(k k1)
    {
        return k1.c;
    }

    public void a(j j1)
    {
        if (g != null)
        {
            g.run();
        }
        j1.b(h);
    }
}
