// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.tender.a;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.common.TGTOrderLevelPromotion;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.g;
import com.target.mothership.services.apigee.c.b.v;
import com.target.mothership.services.apigee.c.b.w;
import com.target.mothership.services.apigee.c.b.z;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            d, am, TGTExpressOrderReview, t, 
//            f, e, TGTPromoCode

class s
    implements aa
{

    s()
    {
    }

    private List a(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        d d1 = new d();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            z z1 = (z)list.next();
            if (z1.i().c() == a.TARGET_GIFT_CARD)
            {
                arraylist.add(d1.a(z1));
            }
        } while (true);
        return arraylist;
    }

    private List b(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        am am1 = new am();
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(am1.a((w)list.next()))) { }
        return arraylist;
    }

    public ExpressOrderReview a(v v1)
    {
        TGTExpressOrderReview tgtexpressorderreview = new TGTExpressOrderReview();
        Object obj;
        if (v1.Q() != null)
        {
            obj = new BigDecimal(v1.Q());
        } else
        {
            obj = null;
        }
        tgtexpressorderreview.a(((BigDecimal) (obj)));
        tgtexpressorderreview.q(v1.P());
        obj = (new t()).a(v1.O());
        tgtexpressorderreview.a((new f()).a(((z) (obj))));
        tgtexpressorderreview.a((new e()).a(v1.O()));
        tgtexpressorderreview.c(a(v1.O()));
        tgtexpressorderreview.d(b(v1.N()));
        obj = new ArrayList();
        if (v1.r() != null)
        {
            TGTOrderLevelPromotion tgtorderlevelpromotion;
            for (Iterator iterator = v1.r().iterator(); iterator.hasNext(); ((List) (obj)).add(tgtorderlevelpromotion))
            {
                g g1 = (g)iterator.next();
                tgtorderlevelpromotion = new TGTOrderLevelPromotion();
                tgtorderlevelpromotion.a(g1.a());
                tgtorderlevelpromotion.a(g1.b());
            }

        }
        tgtexpressorderreview.a(((List) (obj)));
        obj = new ArrayList();
        if (v1.U() != null)
        {
            TGTPromoCode tgtpromocode;
            for (Iterator iterator1 = v1.U().iterator(); iterator1.hasNext(); ((List) (obj)).add(tgtpromocode))
            {
                com.target.mothership.services.apigee.c.b.aa aa1 = (com.target.mothership.services.apigee.c.b.aa)iterator1.next();
                tgtpromocode = new TGTPromoCode();
                tgtpromocode.b(aa1.b());
                tgtpromocode.a(aa1.a());
            }

        }
        tgtexpressorderreview.e(((List) (obj)));
        tgtexpressorderreview.o(v1.y());
        tgtexpressorderreview.r(v1.R());
        tgtexpressorderreview.a(v1.s());
        tgtexpressorderreview.b(v1.t());
        tgtexpressorderreview.c(v1.u());
        tgtexpressorderreview.d(v1.v());
        tgtexpressorderreview.e(v1.w());
        tgtexpressorderreview.f(v1.x());
        tgtexpressorderreview.g(v1.e());
        tgtexpressorderreview.h(v1.f());
        tgtexpressorderreview.i(v1.g());
        tgtexpressorderreview.j(v1.z());
        tgtexpressorderreview.k(v1.A());
        tgtexpressorderreview.l(v1.B());
        tgtexpressorderreview.m(v1.C());
        tgtexpressorderreview.s(v1.a());
        tgtexpressorderreview.t(v1.b());
        tgtexpressorderreview.u(v1.c());
        tgtexpressorderreview.v(v1.d());
        tgtexpressorderreview.g(v1.e());
        tgtexpressorderreview.h(v1.f());
        tgtexpressorderreview.i(v1.g());
        tgtexpressorderreview.w(v1.h());
        tgtexpressorderreview.x(v1.i());
        tgtexpressorderreview.y(v1.j());
        tgtexpressorderreview.z(v1.k());
        tgtexpressorderreview.d(o.g(v1.l()));
        tgtexpressorderreview.A(v1.l());
        tgtexpressorderreview.F(v1.E());
        tgtexpressorderreview.G(v1.F());
        tgtexpressorderreview.B(v1.G());
        tgtexpressorderreview.C(v1.H());
        tgtexpressorderreview.D(v1.m());
        tgtexpressorderreview.E(v1.n());
        tgtexpressorderreview.H(v1.o());
        tgtexpressorderreview.I(v1.p());
        tgtexpressorderreview.J(v1.q());
        tgtexpressorderreview.e(v1.S());
        tgtexpressorderreview.f(v1.T());
        return tgtexpressorderreview;
    }

    public volatile Object a(Object obj)
    {
        return a((v)obj);
    }
}
