// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class pi
    implements cmz
{

    public long a;
    private long b;
    private int c;
    private ph d;

    pi(ph ph1)
    {
        d = ph1;
        super();
    }

    public final void a(int i, long l, long l1)
    {
        b = b + l;
        c = c + i;
        a = l1;
        ph.a(d, false);
    }

    final void a(String s, String s1)
    {
        if (b > 0L)
        {
            pp pp1 = ph.b(d);
            long l = b;
            String s2 = ph.a(d, c);
            pp1.a(s, (new StringBuilder(String.valueOf(s1).length() + 22 + String.valueOf(s2).length())).append(s1).append(":").append(l).append(":").append(s2).toString());
            b = 0L;
            c = 0;
        }
    }
}
