// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;

public final class ade
    implements bxw
{

    final Activity a;
    final act b;
    private final boq c;
    private final dxa d;

    public ade(Activity activity, boq boq1, act act1, dxa dxa1, Object obj)
    {
        a = (Activity)b.a(activity);
        c = (boq)b.a(boq1);
        b = (act)b.a(act1);
        d = (dxa)b.a(dxa1);
    }

    public final void a()
    {
        Object obj = c;
        obj = new bxl(((boq) (obj)).b, ((boq) (obj)).c.b());
        ((bxl) (obj)).a(d.b);
        obj.a = d.d.a;
        boq boq1 = c;
        adf adf1 = new adf(this);
        boq1.e.a(((bxi) (obj)), adf1);
    }
}
