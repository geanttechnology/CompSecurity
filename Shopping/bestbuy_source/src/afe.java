// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class afe extends ada
{

    final afd b;
    private final int c;
    private final String d[];

    public afe(afd afd, aig aig1, int i, String as[])
    {
        b = afd;
        super(afd, aig1);
        c = aia.a(i);
        d = as;
    }

    protected void a()
    {
    }

    protected void a(aig aig1)
    {
        if (aig1 != null)
        {
            aig1.a(c, d);
        }
    }

    protected void a(Object obj)
    {
        a((aig)obj);
    }
}
