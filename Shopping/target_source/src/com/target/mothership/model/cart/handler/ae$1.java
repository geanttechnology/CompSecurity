// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.tender.a;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.common.TGTOrderLevelPromotion;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.g;
import com.target.mothership.services.apigee.c.b.v;
import com.target.mothership.services.apigee.c.b.w;
import com.target.mothership.services.apigee.c.b.z;
import com.target.mothership.util.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            ae, d, am, TGTOrderReview, 
//            t, f, e, TGTPromoCode

class this._cls0
    implements aa
{

    final ae this$0;

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
            if (z1.i().() == a.TARGET_GIFT_CARD)
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

    public OrderReview a(v v1)
    {
        TGTOrderReview tgtorderreview = new TGTOrderReview();
        tgtorderreview.q(v1.P());
        Object obj;
        if (v1.Q() != null)
        {
            obj = new BigDecimal(v1.Q());
        } else
        {
            obj = c.ZERO;
        }
        tgtorderreview.a(((BigDecimal) (obj)));
        obj = (new t()).a(v1.O());
        tgtorderreview.a((new f()).a(((z) (obj))));
        tgtorderreview.a((new e()).a(v1.O()));
        tgtorderreview.c(a(v1.O()));
        tgtorderreview.d(b(v1.N()));
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
        tgtorderreview.a(((List) (obj)));
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
        tgtorderreview.e(((List) (obj)));
        tgtorderreview.o(v1.y());
        tgtorderreview.r(v1.R());
        tgtorderreview.a(v1.s());
        tgtorderreview.b(v1.t());
        tgtorderreview.c(v1.u());
        tgtorderreview.d(v1.v());
        tgtorderreview.e(v1.w());
        tgtorderreview.f(v1.x());
        tgtorderreview.g(v1.e());
        tgtorderreview.h(v1.f());
        tgtorderreview.i(v1.g());
        tgtorderreview.j(v1.z());
        tgtorderreview.k(v1.A());
        tgtorderreview.l(v1.B());
        tgtorderreview.m(v1.C());
        tgtorderreview.s(v1.a());
        tgtorderreview.t(v1.b());
        tgtorderreview.u(v1.c());
        tgtorderreview.v(v1.d());
        tgtorderreview.g(v1.e());
        tgtorderreview.h(v1.f());
        tgtorderreview.i(v1.g());
        tgtorderreview.w(v1.h());
        tgtorderreview.x(v1.i());
        tgtorderreview.y(v1.j());
        tgtorderreview.z(v1.k());
        tgtorderreview.A(v1.l());
        tgtorderreview.F(v1.E());
        tgtorderreview.G(v1.F());
        tgtorderreview.B(v1.G());
        tgtorderreview.C(v1.H());
        tgtorderreview.D(v1.m());
        tgtorderreview.E(v1.n());
        tgtorderreview.H(v1.o());
        tgtorderreview.I(v1.p());
        tgtorderreview.J(v1.q());
        tgtorderreview.e(v1.S());
        tgtorderreview.f(v1.T());
        return tgtorderreview;
    }

    public volatile Object a(Object obj)
    {
        return a((v)obj);
    }

    derReview()
    {
        this$0 = ae.this;
        super();
    }
}
