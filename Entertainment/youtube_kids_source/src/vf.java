// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class vf
    implements vn
{

    private static boolean c;
    private final bcl a;
    private ezd b;

    vf(vg vg1)
    {
        if (!c && vg1 == null)
        {
            throw new AssertionError();
        } else
        {
            a = vg1.a;
            b = bcm.a(a);
            return;
        }
    }

    public static vn a()
    {
        vg vg1 = new vg();
        if (vg1.a == null)
        {
            vg1.a = new bcl();
        }
        return new vf(vg1);
    }

    public final bck b()
    {
        return (bck)b.a();
    }

    static 
    {
        boolean flag;
        if (!vf.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
    }
}
