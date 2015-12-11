// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.a;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.common.TGTOrderLevelPromotion;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.f;
import com.target.mothership.services.apigee.c.b.g;
import com.target.mothership.services.apigee.c.b.k;
import com.target.mothership.services.apigee.d.b;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTCartDetails, o

class m
    implements aa
{

    public static final long NULL_LONG = -1L;

    m()
    {
    }

    private List a(List list)
    {
        if (list.size() == 1)
        {
            return list;
        } else
        {
            Collections.sort(list, new Comparator() {

                final m this$0;

                public int a(CartProduct cartproduct, CartProduct cartproduct1)
                {
                    long l1 = -1L;
                    long l;
                    long l2;
                    try
                    {
                        l = Long.parseLong(cartproduct.a());
                    }
                    // Misplaced declaration of an exception variable
                    catch (CartProduct cartproduct)
                    {
                        l = -1L;
                    }
                    l2 = Long.parseLong(cartproduct1.a());
                    l1 = l2;
_L2:
                    return l1 >= l ? 1 : -1;
                    cartproduct;
                    if (true) goto _L2; else goto _L1
_L1:
                }

                public int compare(Object obj, Object obj1)
                {
                    return a((CartProduct)obj, (CartProduct)obj1);
                }

            
            {
                this$0 = m.this;
                super();
            }
            });
            return list;
        }
    }

    public CartDetails a(f f1)
    {
        TGTCartDetails tgtcartdetails = new TGTCartDetails();
        if (f1 == null || f1.b().isEmpty())
        {
            tgtcartdetails.b(Collections.emptyList());
            tgtcartdetails.a(null);
            tgtcartdetails.b(null);
            tgtcartdetails.a(Collections.emptyList());
            return tgtcartdetails;
        }
        ArrayList arraylist = new ArrayList();
        com.target.mothership.model.cart.handler.o o1 = new com.target.mothership.model.cart.handler.o();
        for (Iterator iterator2 = f1.b().iterator(); iterator2.hasNext(); arraylist.add(o1.a((b)iterator2.next()))) { }
        tgtcartdetails.a(a(((List) (arraylist))));
        f1 = f1.a();
        arraylist = new ArrayList();
        if (f1.q() != null)
        {
            Iterator iterator = f1.q().iterator();
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
        tgtcartdetails.c(arraylist);
        arraylist = new ArrayList();
        if (f1.p() != null)
        {
            TGTOrderLevelPromotion tgtorderlevelpromotion;
            for (Iterator iterator1 = f1.p().iterator(); iterator1.hasNext(); arraylist.add(tgtorderlevelpromotion))
            {
                g g1 = (g)iterator1.next();
                tgtorderlevelpromotion = new TGTOrderLevelPromotion();
                tgtorderlevelpromotion.a(g1.a());
                tgtorderlevelpromotion.a(g1.b());
            }

        }
        tgtcartdetails.b(arraylist);
        tgtcartdetails.b(f1.f());
        tgtcartdetails.a(f1.c());
        tgtcartdetails.c(f1.a());
        tgtcartdetails.d(f1.b());
        tgtcartdetails.e(f1.d());
        tgtcartdetails.f(f1.e());
        return tgtcartdetails;
    }

    public volatile Object a(Object obj)
    {
        return a((f)obj);
    }
}
