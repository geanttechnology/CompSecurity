// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            hb, bt, gs

public final class he extends hb
{

    private final gt.l c;
    private final gt.a d;
    private final gt.x e;
    private final String f;

    private he(gt.l l, gt.a a, gt.x x, String s)
    {
        c = l;
        d = a;
        e = x;
        f = s;
    }

    public he(gt.n n, String s)
    {
        this(n.f(), n.h(), n.j(), s);
    }

    public final String c()
    {
        return "api/v1/tokens";
    }

    public final Map e()
    {
        Map map = super.e();
        map.put("info", new bt(gs.a(c)));
        map.put("app", new bt(gs.a(d)));
        map.put("user", new bt(gs.a(e)));
        String s = f;
        boolean flag;
        if (s == null || s.length() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            map.put("push_token", f);
        }
        return map;
    }
}
