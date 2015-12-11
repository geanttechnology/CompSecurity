// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bwy
{

    private final bwz a[];

    public transient bwy(bwz abwz[])
    {
        a = (bwz[])b.a(abwz);
    }

    public final bww a(dyz dyz, String s, long l, long l1, boolean flag)
    {
        dyz = new bww(dyz, s, l, l1, flag);
        s = a;
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            dyz = s[i].a(dyz);
        }

        return dyz;
    }
}
