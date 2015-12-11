// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.Map;

public final class qu
    implements cqs
{

    private final qs a;
    private final Context b;
    private final coh c;

    public qu(qs qs1, Context context, coh coh1)
    {
        a = (qs)b.a(qs1);
        b = (Context)b.a(context);
        c = (coh)b.a(coh1);
    }

    public final void a(Map map, cra cra1)
    {
        if (!a.e(b) || !c.g())
        {
            b.b(a.t(cra1.j_()));
        }
        cpl cpl1 = cra1.j();
        cra1 = cpl1;
        if (cpl1 == null)
        {
            cra1 = a.b().b;
        }
        if (cra1.b())
        {
            map.put("X-Goog-PageId", cra1.d());
        }
    }
}
