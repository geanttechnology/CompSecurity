// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bcm
    implements ezd
{

    private static boolean b;
    private final bcl a;

    private bcm(bcl bcl)
    {
        if (!b && bcl == null)
        {
            throw new AssertionError();
        } else
        {
            a = bcl;
            return;
        }
    }

    public static ezd a(bcl bcl)
    {
        return new bcm(bcl);
    }

    public final Object a()
    {
        bcl bcl = a;
        return new bck();
    }

    static 
    {
        boolean flag;
        if (!bcm.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }
}
