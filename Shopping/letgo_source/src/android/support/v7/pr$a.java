// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            pr, ve, vw

private class d
    implements Runnable
{

    final pr a;
    private final ve b;
    private final vw c;
    private final Runnable d;

    public void run()
    {
        if (b.g())
        {
            b.c("canceled-at-delivery");
        } else
        {
            if (c.a())
            {
                b.a(c.a);
            } else
            {
                b.b(c.c);
            }
            if (c.d)
            {
                b.b("intermediate-response");
            } else
            {
                b.c("done");
            }
            if (d != null)
            {
                d.run();
                return;
            }
        }
    }

    public (pr pr1, ve ve1, vw vw1, Runnable runnable)
    {
        a = pr1;
        super();
        b = ve1;
        c = vw1;
        d = runnable;
    }
}
