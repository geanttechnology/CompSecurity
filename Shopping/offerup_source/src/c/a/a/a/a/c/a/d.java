// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c.a;


// Referenced classes of package c.a.a.a.a.c.a:
//            a, c

public final class d
{

    private final int a;
    private final a b;
    private final c c;

    private d(int i, a a1, c c1)
    {
        a = i;
        b = a1;
        c = c1;
    }

    public d(a a1, c c1)
    {
        this(0, a1, c1);
    }

    public final long a()
    {
        return b.getDelayMillis(a);
    }

    public final d b()
    {
        return new d(a + 1, b, c);
    }

    public final d c()
    {
        return new d(b, c);
    }
}
