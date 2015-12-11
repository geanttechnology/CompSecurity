// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.f;


// Referenced classes of package com.gimbal.internal.proximity.core.f:
//            e

public abstract class g
    implements e
{

    public e a;
    public e b;
    private long c;
    private Class d;

    public g(Class class1, long l, e e1, e e2)
    {
        c = l;
        a = e1;
        b = e2;
        d = class1;
    }

    public final Object a(String s, Class class1)
    {
label0:
        {
            class1 = (Long)b.a(s, java/lang/Long);
            if (class1 != null)
            {
                Long long1 = Long.valueOf(System.currentTimeMillis());
                boolean flag;
                if (c < 1L || class1 == null || long1 == null)
                {
                    flag = false;
                } else
                if (long1.longValue() > class1.longValue() && (long)((int)(long1.longValue() - class1.longValue()) / 1000) >= c)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            b.a(s);
            a.a(s);
            return null;
        }
        return a.a(s, d);
    }

    public final void a()
    {
        a.a();
        b.a();
    }

    public final void a(String s)
    {
        a.a(s);
        b.a(s);
    }

    public final void a(String s, Object obj)
    {
        a.a(s, obj);
        b.a(s, Long.valueOf(System.currentTimeMillis()));
    }

    public final int b()
    {
        return a.b();
    }
}
