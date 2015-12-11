// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class pl
    implements asx, pq
{

    long a;
    private final long b;
    private final long c;
    private final long d;
    private boolean e;
    private long f;

    pl(long l, long l1, long l2)
    {
        f = -1L;
        b = l;
        c = l1;
        d = l2;
    }

    private boolean b()
    {
        return !e && b != -1L && c != -1L && f != -1L;
    }

    public final int a()
    {
        return !b() ? 0 : 59;
    }

    public final void a(long l, long l1)
    {
        f = l;
        a = a + l1;
    }

    public final void a(bnf bnf1)
    {
        if (b())
        {
            long l = f;
            long l1 = d;
            long l2 = f;
            long l3 = c;
            long l4 = b;
            long l5 = b;
            bnf1.a("cache_info", (new StringBuilder(83)).append(l).append(":").append(l1 - l2).append(":").append(l3 - l4).append(":").append(l5).toString(), ",:");
            e = true;
        }
    }
}
