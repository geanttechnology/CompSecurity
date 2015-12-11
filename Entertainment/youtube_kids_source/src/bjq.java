// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bjq
    implements bjt
{

    private static boolean c;
    private final bcl a;
    private ezd b;

    public bjq(bjr bjr1)
    {
        if (!c && bjr1 == null)
        {
            throw new AssertionError();
        } else
        {
            bjs bjs = bjr1.a;
            a = bjr1.b;
            b = bcm.a(a);
            return;
        }
    }

    public static bjr a()
    {
        return new bjr();
    }

    public final bck b()
    {
        return (bck)b.a();
    }

    static 
    {
        boolean flag;
        if (!bjq.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
    }
}
