// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class blh
    implements Runnable
{

    private blf a;

    public blh(blf blf1)
    {
        a = blf1;
        super();
    }

    public final void run()
    {
        bjc bjc1;
        amv amv1;
        for (bjc1 = blf.a(a).d(); bjc1.hasNext(); blf.a(a, amv1))
        {
            amv1 = (amv)bjc1.next();
        }

        bjc1.a();
    }
}
