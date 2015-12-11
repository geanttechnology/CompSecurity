// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class pk
    implements clx, pq
{

    private long a;
    private long b;
    private long c;
    private long d;

    pk()
    {
    }

    public final int a()
    {
        return a == 0L ? 0 : 40;
    }

    public final void a(bnf bnf1)
    {
        if (a != 0L)
        {
            long l = a;
            long l1 = b;
            long l2 = c;
            long l3 = d;
            bnf1.a("be_info", (new StringBuilder(99)).append("nr:").append(l).append(",nrw:").append(l1).append(",nrww:").append(l2).append(",nrb:").append(l3).toString(), ",:");
            a = 0L;
            b = 0L;
            c = 0L;
            d = 0L;
        }
    }

    public final void a(boolean flag, boolean flag1, boolean flag2)
    {
        a = a + 1L;
        if (flag)
        {
            b = b + 1L;
        }
        if (flag1)
        {
            c = c + 1L;
        }
        if (flag2)
        {
            d = d + 1L;
        }
    }
}
