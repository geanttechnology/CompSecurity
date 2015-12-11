// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ain
{

    private ail a;

    ain(ail ail1)
    {
        a = ail1;
        super();
    }

    public final void onMdxScreenAvailabilityChangedEvent(amg amg1)
    {
        if (!amg1.a)
        {
            Object obj = a;
            obj = amg1.b;
        }
        a.b();
        chq chq1 = a.j;
        if (amg1.a)
        {
            amg1 = "added";
        } else
        {
            amg1 = "removed";
        }
        chq1.a("Publishing entire routes on screen %s: %s", new Object[] {
            amg1, ((ii) (a)).g
        });
    }
}
