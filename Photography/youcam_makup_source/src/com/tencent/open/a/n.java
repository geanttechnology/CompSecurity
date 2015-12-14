// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;


// Referenced classes of package com.tencent.open.a:
//            c, m, e

public abstract class n
{

    private volatile int a;
    private volatile boolean b;
    private m c;

    public n()
    {
        this(c.a, true, m.a);
    }

    public n(int i, boolean flag, m m1)
    {
        a = c.a;
        b = true;
        c = m.a;
        a(i);
        a(flag);
        a(m1);
    }

    public void a(int i)
    {
        a = i;
    }

    protected abstract void a(int i, Thread thread, long l, String s, String s1, Throwable throwable);

    public void a(m m1)
    {
        c = m1;
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public void b(int i, Thread thread, long l, String s, String s1, Throwable throwable)
    {
        if (d() && com.tencent.open.a.e.a(a, i))
        {
            a(i, thread, l, s, s1, throwable);
        }
    }

    public boolean d()
    {
        return b;
    }

    public m e()
    {
        return c;
    }
}
