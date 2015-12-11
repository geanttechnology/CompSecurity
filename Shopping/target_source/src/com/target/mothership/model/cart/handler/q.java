// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.a;
import com.target.mothership.model.cart.interfaces.CartSummary;
import com.target.mothership.model.common.TGTOrderLevelPromotion;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.g;
import com.target.mothership.services.apigee.c.b.k;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTCartSummary

class q
    implements aa
{

    q()
    {
    }

    public CartSummary a(k k1)
    {
        TGTCartSummary tgtcartsummary = new TGTCartSummary();
        if (k1 == null)
        {
            tgtcartsummary.n(null);
            tgtcartsummary.a(null);
            tgtcartsummary.b(null);
            tgtcartsummary.c(null);
            tgtcartsummary.d(null);
            tgtcartsummary.e(null);
            tgtcartsummary.o(null);
            tgtcartsummary.a(null);
            tgtcartsummary.f(null);
            tgtcartsummary.g(null);
            tgtcartsummary.h(null);
            tgtcartsummary.i(null);
            tgtcartsummary.j(null);
            tgtcartsummary.k(null);
            tgtcartsummary.l(null);
            tgtcartsummary.b(Collections.emptyList());
            return tgtcartsummary;
        }
        tgtcartsummary.n(k1.f());
        ArrayList arraylist = new ArrayList();
        if (k1.q() != null)
        {
            Iterator iterator = k1.q().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.target.mothership.services.apigee.c.b.k.a a1 = (com.target.mothership.services.apigee.c.b.k.a)iterator.next();
                if (o.g(a1.a()))
                {
                    arraylist.add(com.target.mothership.common.a.a.a(a1.a()));
                }
            } while (true);
        }
        tgtcartsummary.b(arraylist);
        arraylist = new ArrayList();
        if (k1.p() != null)
        {
            TGTOrderLevelPromotion tgtorderlevelpromotion;
            for (Iterator iterator1 = k1.p().iterator(); iterator1.hasNext(); arraylist.add(tgtorderlevelpromotion))
            {
                g g1 = (g)iterator1.next();
                tgtorderlevelpromotion = new TGTOrderLevelPromotion();
                tgtorderlevelpromotion.a(g1.a());
                tgtorderlevelpromotion.a(g1.b());
            }

        }
        tgtcartsummary.a(arraylist);
        tgtcartsummary.o(k1.c());
        tgtcartsummary.a(k1.a());
        tgtcartsummary.b(k1.b());
        tgtcartsummary.c(k1.g());
        tgtcartsummary.d(k1.h());
        tgtcartsummary.e(k1.i());
        tgtcartsummary.f(k1.j());
        tgtcartsummary.g(k1.k());
        tgtcartsummary.h(k1.l());
        tgtcartsummary.i(k1.m());
        tgtcartsummary.j(k1.n());
        tgtcartsummary.k(k1.o());
        tgtcartsummary.l(k1.d());
        tgtcartsummary.m(k1.e());
        return tgtcartsummary;
    }

    public volatile Object a(Object obj)
    {
        return a((k)obj);
    }
}
