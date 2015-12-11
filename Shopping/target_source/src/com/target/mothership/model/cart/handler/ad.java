// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.mothership.model.common.PickUpPersonDetails;
import com.target.mothership.model.common.TGTOrderLevelPromotion;
import com.target.mothership.model.common.TGTPickUpPersonDetails;
import com.target.mothership.model.common.c;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.g;
import com.target.mothership.services.apigee.c.b.l;
import com.target.mothership.services.apigee.c.b.m;
import com.target.mothership.services.apigee.c.b.n;
import com.target.mothership.services.apigee.d.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTCartPhoneNumber, c, TGTOrderCompletionPaymentDetails, TGTOrderCompletionShipmentDetails, 
//            TGTCartGuestAddress, o, TGTOrderCompletionDetails, TGTPromoCode

class ad
    implements aa
{

    ad()
    {
    }

    private PickUpPersonDetails a(n n1)
    {
        TGTPickUpPersonDetails tgtpickuppersondetails = new TGTPickUpPersonDetails();
        tgtpickuppersondetails.a(n1.a());
        tgtpickuppersondetails.b(n1.b());
        TGTCartPhoneNumber tgtcartphonenumber = new TGTCartPhoneNumber();
        tgtcartphonenumber.a(n1.c());
        tgtcartphonenumber.a(c.Other);
        tgtpickuppersondetails.a(tgtcartphonenumber);
        return tgtpickuppersondetails;
    }

    private List a(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        com.target.mothership.model.cart.handler.c c1 = new com.target.mothership.model.cart.handler.c();
        ArrayList arraylist = new ArrayList();
        TGTOrderCompletionPaymentDetails tgtordercompletionpaymentdetails;
        for (list = list.iterator(); list.hasNext(); arraylist.add(tgtordercompletionpaymentdetails))
        {
            m m1 = (m)list.next();
            tgtordercompletionpaymentdetails = new TGTOrderCompletionPaymentDetails();
            if (m1.b() != null)
            {
                com.target.mothership.services.apigee.c.b.m.a a1 = m1.b();
                tgtordercompletionpaymentdetails.a(a1.a());
                tgtordercompletionpaymentdetails.a(a1.b());
            }
            if (m1.a() != null)
            {
                tgtordercompletionpaymentdetails.a(c1.a(m1.a()));
            }
        }

        return arraylist;
    }

    private List b(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        com.target.mothership.model.cart.handler.c c1 = new com.target.mothership.model.cart.handler.c();
        ArrayList arraylist = new ArrayList();
        TGTOrderCompletionShipmentDetails tgtordercompletionshipmentdetails;
        for (list = list.iterator(); list.hasNext(); arraylist.add(tgtordercompletionshipmentdetails))
        {
            n n1 = (n)list.next();
            tgtordercompletionshipmentdetails = new TGTOrderCompletionShipmentDetails();
            tgtordercompletionshipmentdetails.a(c(n1.e()));
            tgtordercompletionshipmentdetails.a(a(n1));
            if (n1.f() != null)
            {
                TGTCartGuestAddress tgtcartguestaddress = c1.a(n1.f());
                TGTCartPhoneNumber tgtcartphonenumber = new TGTCartPhoneNumber();
                tgtcartphonenumber.a(n1.d());
                tgtcartphonenumber.a(c.Other);
                tgtcartguestaddress.a(tgtcartphonenumber);
                tgtordercompletionshipmentdetails.a(tgtcartguestaddress);
            }
        }

        return arraylist;
    }

    private List c(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        o o1 = new o();
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(o1.a((b)list.next()))) { }
        return arraylist;
    }

    public OrderCompletionDetails a(l l1)
    {
        TGTOrderCompletionDetails tgtordercompletiondetails = new TGTOrderCompletionDetails();
        tgtordercompletiondetails.a(l1.I());
        tgtordercompletiondetails.c(a(l1.J()));
        tgtordercompletiondetails.d(b(l1.K()));
        ArrayList arraylist = new ArrayList();
        if (l1.r() != null)
        {
            TGTOrderLevelPromotion tgtorderlevelpromotion;
            for (Iterator iterator = l1.r().iterator(); iterator.hasNext(); arraylist.add(tgtorderlevelpromotion))
            {
                g g1 = (g)iterator.next();
                tgtorderlevelpromotion = new TGTOrderLevelPromotion();
                tgtorderlevelpromotion.a(g1.a());
                tgtorderlevelpromotion.a(g1.b());
            }

        }
        tgtordercompletiondetails.a(arraylist);
        arraylist = new ArrayList();
        if (l1.U() != null)
        {
            TGTPromoCode tgtpromocode;
            for (Iterator iterator1 = l1.U().iterator(); iterator1.hasNext(); arraylist.add(tgtpromocode))
            {
                com.target.mothership.services.apigee.c.b.aa aa1 = (com.target.mothership.services.apigee.c.b.aa)iterator1.next();
                tgtpromocode = new TGTPromoCode();
                tgtpromocode.b(aa1.b());
                tgtpromocode.a(aa1.a());
            }

        }
        tgtordercompletiondetails.e(arraylist);
        tgtordercompletiondetails.o(l1.y());
        tgtordercompletiondetails.r(l1.R());
        tgtordercompletiondetails.a(l1.s());
        tgtordercompletiondetails.b(l1.t());
        tgtordercompletiondetails.c(l1.u());
        tgtordercompletiondetails.d(l1.v());
        tgtordercompletiondetails.e(l1.w());
        tgtordercompletiondetails.f(l1.x());
        tgtordercompletiondetails.g(l1.e());
        tgtordercompletiondetails.h(l1.f());
        tgtordercompletiondetails.i(l1.g());
        tgtordercompletiondetails.j(l1.z());
        tgtordercompletiondetails.k(l1.A());
        tgtordercompletiondetails.l(l1.B());
        tgtordercompletiondetails.m(l1.C());
        tgtordercompletiondetails.s(l1.a());
        tgtordercompletiondetails.t(l1.b());
        tgtordercompletiondetails.u(l1.c());
        tgtordercompletiondetails.v(l1.d());
        tgtordercompletiondetails.g(l1.e());
        tgtordercompletiondetails.h(l1.f());
        tgtordercompletiondetails.i(l1.g());
        tgtordercompletiondetails.w(l1.h());
        tgtordercompletiondetails.x(l1.i());
        tgtordercompletiondetails.y(l1.j());
        tgtordercompletiondetails.z(l1.k());
        tgtordercompletiondetails.A(l1.l());
        tgtordercompletiondetails.F(l1.E());
        tgtordercompletiondetails.G(l1.F());
        tgtordercompletiondetails.B(l1.G());
        tgtordercompletiondetails.C(l1.H());
        tgtordercompletiondetails.D(l1.m());
        tgtordercompletiondetails.E(l1.n());
        tgtordercompletiondetails.e(l1.S());
        tgtordercompletiondetails.f(l1.T());
        tgtordercompletiondetails.H(l1.o());
        tgtordercompletiondetails.I(l1.p());
        tgtordercompletiondetails.J(l1.q());
        return tgtordercompletiondetails;
    }

    public volatile Object a(Object obj)
    {
        return a((l)obj);
    }
}
