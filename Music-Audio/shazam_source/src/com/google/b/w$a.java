// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;

import com.google.b.b.a;

// Referenced classes of package com.google.b:
//            y, w, t, k, 
//            f, x

private static final class <init>
    implements y
{

    private final com.google.b.c.a a;
    private final boolean b;
    private final Class c;
    private final t d;
    private final k e;

    public final x a(f f, com.google.b.c.a a1)
    {
        boolean flag;
        if (a != null)
        {
            if (a.equals(a1) || b && a.b == a1.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = c.isAssignableFrom(a1.a);
        }
        if (flag)
        {
            return new w(d, e, f, a1, this, (byte)0);
        } else
        {
            return null;
        }
    }

    private (Object obj, com.google.b.c.a a1, boolean flag)
    {
        t t1;
        boolean flag1;
        if (obj instanceof t)
        {
            t1 = (t)obj;
        } else
        {
            t1 = null;
        }
        d = t1;
        if (obj instanceof k)
        {
            obj = (k)obj;
        } else
        {
            obj = null;
        }
        e = ((k) (obj));
        if (d != null || e != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        com.google.b.b.a.a(flag1);
        a = a1;
        b = flag;
        c = null;
    }

    c(Object obj, com.google.b.c.a a1, boolean flag, byte byte0)
    {
        this(obj, a1, flag);
    }
}
