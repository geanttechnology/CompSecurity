// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bf
{

    private final ao a;
    private final ag b;
    private final int c = 60000;
    private long d;
    private int e;

    public bf(ao ao1, ag ag1, int i)
    {
        a = ao1;
        b = ag1;
        d = -1L;
        e = 0;
    }

    public final void a(String s, Throwable throwable)
    {
        long l = System.currentTimeMillis();
        if (l > d + (long)c)
        {
            s = b.a(s, throwable, e);
            if (s != null)
            {
                a.b(s);
                e = 0;
                d = l;
            }
            return;
        } else
        {
            e = e + 1;
            return;
        }
    }
}
