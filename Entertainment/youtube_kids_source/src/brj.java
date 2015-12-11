// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class brj
{

    public final String a;
    public final byte b[];
    private final int c;

    public brj(drj drj1)
    {
        this(drj1.a, drj1.b, 2, 0, null);
    }

    public brj(dvu dvu1)
    {
        this(dvu1.a, dvu1.b, 3, 0, null);
    }

    public brj(String s)
    {
        this(s, bqd.a);
    }

    private brj(String s, byte abyte0[])
    {
        this(s, abyte0, 1, 0, null);
    }

    private brj(String s, byte abyte0[], int i, int j, a a1)
    {
        a = b.a(s);
        b = (byte[])b.a(abyte0);
        c = i;
    }

    public final boolean a(int i)
    {
        return c == i;
    }
}
