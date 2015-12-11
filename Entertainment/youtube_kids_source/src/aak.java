// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executor;

final class aak extends bmr
{

    private aaa a;

    aak(aaa aaa1, Executor executor)
    {
        a = aaa1;
        super(executor);
    }

    public final Object a()
    {
        bnr bnr1 = new bnr();
        bmi bmi = a.c.b();
        bdp bdp1 = new bdp(a.i());
        b.a(bnr1);
        b.a(bmi);
        b.a(bdp1);
        bnr1.a(a.k("/VMAP"), new bew());
        bnr1.a(a.k("/VMAP/AdBreak"), new bex());
        bnr1.a(a.k("/VMAP/AdBreak/TrackingEvents/Tracking"), new bey());
        bnr1.a(a.k("/VMAP/AdBreak/Extensions/Extension").concat("/yt:BreakTime"), new bez());
        bnr1.a(a.k("/VMAP/Extensions/Extension").concat("/TrackingDecoration"), new bfa());
        bnr1.a(a.k("/VMAP/Extensions/Extension").concat("/TrackingMacro"), new bfb());
        bdx.a(a.k("/VMAP/AdBreak/AdSource/VASTData"), bmi, bnr1, new bfc(), bdp1);
        return bnr1.a();
    }
}
