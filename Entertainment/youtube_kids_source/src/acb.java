// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class acb
{

    public btu a;
    public String b;
    public dre c;
    private bhx d;

    public acb(blu blu)
    {
        b.a(blu);
    }

    private void handleSequencerStageEvent(csy csy1)
    {
        if (!csy1.a.a(new cts[] {
    cts.d, cts.e
}))
        {
            d = null;
            a = null;
            b = null;
        } else
        {
            if (csy1.b != null)
            {
                a = csy1.b.d();
                bxb.a(csy1.b.a);
                b = csy1.b.c();
            }
            if (csy1.c != null)
            {
                c = csy1.c.d;
                return;
            }
        }
    }

    public final void handleVideoStageEvent(ctd ctd)
    {
    }
}
