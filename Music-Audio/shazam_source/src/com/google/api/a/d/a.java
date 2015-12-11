// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.e;
import com.google.api.a.g.m;
import java.nio.charset.Charset;

// Referenced classes of package com.google.api.a.d:
//            i, o

public abstract class a
    implements i
{

    o a;
    private long b;

    protected a(o o1)
    {
        b = -1L;
        a = o1;
    }

    public a(String s)
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = new o(s);
        }
        this(((o) (s)));
    }

    public static long a(i j)
    {
        if (!j.d())
        {
            return -1L;
        } else
        {
            return m.a(j);
        }
    }

    public final long a()
    {
        if (b == -1L)
        {
            b = a(((i) (this)));
        }
        return b;
    }

    public final Charset b()
    {
        if (a == null || a.b() == null)
        {
            return e.a;
        } else
        {
            return a.b();
        }
    }

    public final String c()
    {
        if (a == null)
        {
            return null;
        } else
        {
            return a.a();
        }
    }

    public boolean d()
    {
        return true;
    }
}
