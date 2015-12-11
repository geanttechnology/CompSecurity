// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            hb, bt, gs

public final class hd extends hb
{

    public final gt.d.a c = gt.d.f();
    private gt.i d;

    public hd()
    {
        d = null;
    }

    public final boolean a(gt.c c1)
    {
        if (d == null)
        {
            d = c1.f();
        } else
        if (c1.f() != d)
        {
            return false;
        }
        c.a(c1);
        return true;
    }

    public final String c()
    {
        return "api/v1/cevs";
    }

    public final Map e()
    {
        Map map = super.e();
        map.put("events", new bt(gs.a(c.e())));
        return map;
    }
}
