// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public final class ajk
    implements rh
{

    private final Context a;
    private final bmi b;
    private final bje c;
    private final amd d;
    private final ctw e;
    private final chq f;

    public ajk(Context context, bmi bmi1, bje bje1, amd amd1, ctw ctw1, chq chq1)
    {
        a = (Context)b.a(context);
        b = (bmi)b.a(bmi1);
        c = (bje)b.a(bje1);
        d = (amd)b.a(amd1);
        e = (ctw)b.a(ctw1);
        f = (chq)b.a(chq1);
    }

    public final rg a()
    {
        return new ajh(a, b, c, d, e, f);
    }
}
