// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.c.d;

// Referenced classes of package e.d.a:
//            k, n, m

public final class j
    implements d
{

    private boolean a;
    private int b;

    private j(boolean flag, int i)
    {
        a = flag;
        b = i;
    }

    j(boolean flag, int i, byte byte0)
    {
        this(flag, 0x7fffffff);
    }

    public static j a(boolean flag)
    {
        return k.a;
    }

    public final Object a(Object obj)
    {
        obj = (e.j)obj;
        n n1 = new n(((e.j) (obj)), a, b);
        m m1 = new m(n1);
        n1.a = m1;
        ((e.j) (obj)).a(n1);
        ((e.j) (obj)).a(m1);
        return n1;
    }
}
