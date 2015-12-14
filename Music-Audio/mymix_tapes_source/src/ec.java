// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ec extends dv
    implements bj.j
{

    private cq a;

    public ec(String s, cq cq1, byte byte0)
    {
        super(s);
        if (byte0 == 1)
        {
            super.a((byte)6);
        } else
        if (byte0 == 2)
        {
            super.a((byte)7);
        } else
        {
            super.a((byte)8);
        }
        a = cq1;
    }

    protected final byte[] a()
    {
        return a.b();
    }
}
