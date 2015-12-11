// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public final class pg
{

    private final Context a;
    private final bmi b;
    private final asa c;
    private final asa d;
    private final cxe e;

    public pg(Context context, bmi bmi1, asa asa1, asa asa2, cxe cxe1)
    {
        a = (Context)b.a(context);
        b = (bmi)b.a(bmi1);
        c = (asa)b.a(asa1);
        d = (asa)b.a(asa2);
        e = (cxe)b.a(cxe1);
    }

    public final pf a(String s)
    {
        s = new pf(a, b, c, d, e, s);
        ((pf) (s)).d.a(s);
        ((pf) (s)).e.a(s);
        return s;
    }
}
