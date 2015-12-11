// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.f;


// Referenced classes of package com.gimbal.internal.proximity.core.f:
//            e, f

public final class c
    implements e
{

    private int a;
    private f b;

    public c(String s)
    {
        a = 0;
        b = new f(s);
    }

    public c(String s, int i)
    {
        a = i;
        b = new f(s);
    }

    public final Object a(String s, Class class1)
    {
        return b.a(s, class1);
    }

    public final void a()
    {
        b.a();
    }

    public final void a(String s)
    {
        b.a(s);
    }

    public final void a(String s, Object obj)
    {
        f f1 = b;
        int i = a;
        if (i > 0 && f1 != null && f1.b() >= i)
        {
            f1.a();
        }
        b = (f)f1;
        b.a(s, obj);
    }

    public final int b()
    {
        return b.b();
    }
}
