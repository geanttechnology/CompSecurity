// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Locale;

public final class cnw
    implements mj
{

    private final mj a;
    private final coe b;

    public cnw(mj mj1, coe coe1)
    {
        a = (mj)b.a(mj1);
        b = (coe)b.a(coe1);
    }

    public final void a(mp mp1)
    {
        if (b.a() && mp1.a != null)
        {
            mb mb1 = mp1.a;
            bmo.d(String.format(Locale.US, "Full response from error: %s", new Object[] {
                new String(mb1.b)
            }));
        }
        a.a(mp1);
    }
}
