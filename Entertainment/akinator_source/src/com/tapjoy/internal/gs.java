// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.tapjoy.internal:
//            bo, bt, bu, aa, 
//            gg, gq

public final class gs
{

    public static String a(gt.a a1)
    {
        bo bo1 = (new bo()).c();
        if (a1.e())
        {
            bo1.a("pkg_ver").b(a1.f());
        }
        if (a1.g())
        {
            bo1.a("pkg_rev").a(a1.h());
        }
        if (a1.i())
        {
            bo1.a("data_ver").b(a1.j());
        }
        if (a1.k())
        {
            bo1.a("installer").b(a1.l());
        }
        if (a1.m())
        {
            bo1.a("store").b(a1.n());
        }
        return bo1.d().toString();
    }

    private static String a(gt.c c, boolean flag, boolean flag1, boolean flag2)
    {
        bo bo1;
        bo1 = (new bo()).c().a("type").b(a(c.f())).a("name").b(c.h());
        bo1.a("time");
        Object obj;
        gt.p p;
        if (c.k())
        {
            bo1.a(c.j());
            bo1.a("systime").a(c.l());
        } else
        if (aa.c() && c.m() && c.o() && gg.a.equals(c.n()))
        {
            bo1.a(aa.a(c.p()));
            bo1.a("systime").a(c.j());
        } else
        {
            bo1.a(c.j());
        }
        if (c.q())
        {
            bo1.a("duration").a(c.r());
        }
        if (!flag && c.s())
        {
            bo1.a("info").a(new bt(a(c.t())));
        }
        if (!flag1 && c.u())
        {
            bo1.a("app").a(new bt(a(c.v())));
        }
        if (!flag2 && c.w())
        {
            bo1.a("user").a(new bt(a(c.x(), c)));
        }
        if (c.A())
        {
            bo1.a("event_seq").a(c.B());
        }
        if (c.C())
        {
            bo bo2 = bo1.a("event_prev");
            gt.f f = c.D();
            bo bo4 = (new bo()).c().a("type").b(a(f.f())).a("name").b(f.h());
            if (f.i())
            {
                bo4.a("category").b(f.j());
            }
            bo2.a(new bt(bo4.d().toString()));
        }
        if (c.E())
        {
            bo bo3 = bo1.a("purchase");
            gt.r r = c.F();
            bo bo5 = (new bo()).c().a("product_id").b(r.f());
            if (r.g())
            {
                bo5.a("product_quantity").a(r.h());
            }
            if (r.i())
            {
                bo5.a("product_price").a(r.j());
            }
            if (r.k())
            {
                bo5.a("product_price_currency").b(r.l());
            }
            if (r.A())
            {
                bo5.a("currency_price").b(r.B());
            }
            if (r.m())
            {
                bo5.a("product_type").b(r.n());
            }
            if (r.o())
            {
                bo5.a("product_title").b(r.p());
            }
            if (r.q())
            {
                bo5.a("product_description").b(r.r());
            }
            if (r.s())
            {
                bo5.a("transaction_id").b(r.t());
            }
            if (r.u())
            {
                bo5.a("transaction_state").a(r.v());
            }
            if (r.w())
            {
                bo5.a("transaction_date").a(r.x());
            }
            if (r.y())
            {
                bo5.a("campaign_id").b(r.z());
            }
            if (r.C())
            {
                bo5.a("receipt").b(r.D());
            }
            if (r.E())
            {
                bo5.a("signature").b(r.F());
            }
            bo3.a(new bt(bo5.d().toString()));
        }
        if (c.G())
        {
            bo1.a("exception").b(c.H());
        }
        if (!c.K()) goto _L2; else goto _L1
_L1:
        obj = new LinkedHashMap();
        if (c.I())
        {
            bu.b(c.J()).a(((Map) (obj)));
        }
        p = c.L();
        if (p.e())
        {
            ((Map) (obj)).put("fq7_change", p.f());
        }
        if (p.g())
        {
            ((Map) (obj)).put("fq30_change", p.h());
        }
        if (p.i())
        {
            ((Map) (obj)).put("push_id", p.j());
        }
        bo1.a("meta").a(((Map) (obj)));
_L4:
        if (c.M())
        {
            bo1.a("category").b(c.N());
        }
        if (c.O())
        {
            bo1.a("p1").b(c.P());
        }
        if (c.Q())
        {
            bo1.a("p2").b(c.R());
        }
        if (c.T() <= 0)
        {
            break MISSING_BLOCK_LABEL_1135;
        }
        bo1.a("values").c();
        for (c = c.S().iterator(); c.hasNext(); bo1.a(((gt.j) (obj)).f()).a(((gt.j) (obj)).h()))
        {
            obj = (gt.j)c.next();
        }

        break; /* Loop/switch isn't completed */
_L2:
        try
        {
            if (c.I())
            {
                bo1.a("meta").a(new bt(c.J()));
            }
        }
        catch (IOException ioexception) { }
        if (true) goto _L4; else goto _L3
_L3:
        bo1.d();
        return bo1.d().toString();
    }

    public static String a(gt.d d)
    {
        Object obj = null;
        bo bo1 = (new bo()).a();
        Iterator iterator = d.e().iterator();
        gt.a a1 = null;
        gt.l l = null;
        d = obj;
        while (iterator.hasNext()) 
        {
            gt.c c = (gt.c)iterator.next();
            boolean flag;
            boolean flag1;
            boolean flag2;
            if (l == null || c.s() && !l.equals(c.t()))
            {
                l = c.t();
                flag = false;
            } else
            {
                flag = true;
            }
            if (a1 == null || c.u() && !a1.equals(c.v()))
            {
                a1 = c.v();
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            if (d == null || c.w() && !d.equals(c.x()))
            {
                d = c.x();
                flag2 = false;
            } else
            {
                flag2 = true;
            }
            bo1.a(new bt(a(c, flag, flag1, flag2)));
        }
        return bo1.b().toString();
    }

    private static String a(gt.i i)
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[gt.i.values().length];
                try
                {
                    a[gt.i.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[gt.i.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[gt.i.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[i.ordinal()])
        {
        default:
            throw new RuntimeException();

        case 1: // '\001'
            return "app";

        case 2: // '\002'
            return "campaign";

        case 3: // '\003'
            return "custom";
        }
    }

    public static String a(gt.l l)
    {
        bo bo1 = (new bo()).c().a("sdk").b(l.F()).a("os_name").b(l.n()).a("os_ver").b(l.p()).a("device_id").b(l.h()).a("device_maker").b(l.j()).a("device_model").b(l.l()).a("pkg_id").b(l.B()).a("pkg_sign").b(l.D()).a("display_d").a(l.r()).a("display_w").a(l.t()).a("display_h").a(l.v()).a("locale").b(l.x()).a("timezone").b(l.z());
        if (l.e())
        {
            bo1.a("mac").b(l.f());
        }
        if (l.G())
        {
            bo1.a("country_sim").b(l.H());
        }
        if (l.I())
        {
            bo1.a("country_net").b(l.J());
        }
        if (l.K())
        {
            bo1.a("imei").b(l.L());
        }
        return bo1.d().toString();
    }

    public static String a(gt.x x)
    {
        return a(x, null);
    }

    private static String a(gt.x x, gt.c c)
    {
        bo bo1 = (new bo()).c();
        if (x.e())
        {
            bo1.a("installed").a(x.f());
        }
        if (x.g())
        {
            bo1.a("referrer").b(x.h());
        }
        if (x.G())
        {
            bo1.a("idfa").b(x.H());
            if (x.I() && x.J())
            {
                bo1.a("idfa_optout").a(1L);
            }
        } else
        if (c != null && c.m() && gg.a.equals(c.n()))
        {
            c = gq.b();
            if (c != null)
            {
                bo1.a("idfa").b(c);
                if (gq.c())
                {
                    bo1.a("idfa_optout").a(1L);
                }
            }
        }
        if (x.i())
        {
            bo1.a("fq7").a(Math.max(x.j(), 1));
        }
        if (x.k())
        {
            bo1.a("fq30").a(Math.max(x.l(), 1));
        }
        if (x.n() > 0)
        {
            c = new ArrayList(x.n());
            for (Iterator iterator = x.m().iterator(); iterator.hasNext();)
            {
                gt.t t = (gt.t)iterator.next();
                if (t.i())
                {
                    c.add(t.f());
                }
            }

            if (!c.isEmpty())
            {
                bo1.a("push").a();
                for (c = c.iterator(); c.hasNext(); bo1.b((String)c.next())) { }
                bo1.b();
            }
        }
        bo1.a("session").c();
        if (x.o())
        {
            bo1.a("total_count").a(x.p());
        }
        if (x.q())
        {
            bo1.a("total_length").a(x.r());
        }
        if (x.s())
        {
            bo1.a("last_at").a(x.t());
        }
        if (x.u())
        {
            bo1.a("last_length").a(x.v());
        }
        bo1.d();
        bo1.a("purchase").c();
        if (x.w())
        {
            bo1.a("currency").b(x.x());
        }
        if (x.y())
        {
            bo1.a("total_count").a(x.z());
        }
        if (x.A())
        {
            bo1.a("total_price").a(x.B());
        }
        if (x.C())
        {
            bo1.a("last_at").a(x.D());
        }
        if (x.E())
        {
            bo1.a("last_price").a(x.F());
        }
        bo1.d();
        if (x.K())
        {
            bo1.a("user_id").b(x.L());
        }
        if (x.M())
        {
            bo1.a("user_level").a(x.N());
        }
        if (x.O())
        {
            bo1.a("friend_count").a(x.P());
        }
        if (x.Q())
        {
            bo1.a("uv1").b(x.R());
        }
        if (x.S())
        {
            bo1.a("uv2").b(x.T());
        }
        if (x.U())
        {
            bo1.a("uv3").b(x.V());
        }
        if (x.W())
        {
            bo1.a("uv4").b(x.X());
        }
        if (x.Y())
        {
            bo1.a("uv5").b(x.Z());
        }
        if (x.ab())
        {
            bo1.a("push_optout").a(1L);
        }
        return bo1.d().toString();
    }
}
