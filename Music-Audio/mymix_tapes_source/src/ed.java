// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ed extends dv
    implements bj.j
{

    private cq a;
    private cx b;
    private int c;

    public ed(String s, dm dm1, cq cq1, cx cx)
    {
        super(s, (byte)127);
        a = cq1;
        b = cx;
        c = dm1.c();
        cq1.b("audio_id", c);
    }

    protected final int a()
    {
        return c;
    }

    protected final byte[] d()
    {
        return a.b();
    }

    protected final cx e()
    {
        return b;
    }
}
