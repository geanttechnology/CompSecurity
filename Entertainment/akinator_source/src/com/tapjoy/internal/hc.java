// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            hb, bu, gw, gi, 
//            gj, bt, gs, gk, 
//            gd

public final class hc extends hb
{
    public static final class a
    {

        public gk a;
        public final List b;

        public a(gk gk1, List list)
        {
            a = gk1;
            b = list;
        }
    }


    public final String c;
    public boolean d;
    private final gd e;
    private final gt.l f;
    private final gt.a g;
    private final gt.x h;
    private Context i;

    public hc(gd gd, gt.l l, gt.a a1, gt.x x, String s, Context context)
    {
        e = gd;
        f = l;
        g = a1;
        h = x;
        c = s;
        d = false;
        i = context;
    }

    protected final Object a(bu bu1)
    {
        bu1.i();
        List list = null;
        gw gw1 = null;
        while (bu1.k()) 
        {
            String s = bu1.m();
            if ("interstitial".equals(s))
            {
                gw1 = (gw)bu1.b(gw.n);
            } else
            if ("enabled_placements".equals(s))
            {
                list = bu1.d();
            } else
            {
                bu1.t();
            }
        }
        bu1.j();
        if (gw1 != null && (gw1.a() || gw1.b()))
        {
            return new a(new gi(e, c, gw1, i), list);
        } else
        {
            return new a(new gj(), list);
        }
    }

    public final String c()
    {
        return "placement";
    }

    public final Map e()
    {
        Map map = super.e();
        map.put("info", new bt(gs.a(f)));
        map.put("app", new bt(gs.a(g)));
        map.put("user", new bt(gs.a(h)));
        map.put("placement", c);
        return map;
    }

    protected final Object f()
    {
        a a1 = (a)super.f();
        if (!(a1.a instanceof gj))
        {
            a1.a.a();
            if (!a1.a.b())
            {
                String s = c;
                a1.a = new gj();
            }
        }
        return a1;
    }
}
