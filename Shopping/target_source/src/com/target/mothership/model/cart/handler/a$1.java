// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.j;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.cart.interfaces.AddToCart;
import com.target.mothership.model.common.TGTOrderProductImage;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.a;
import com.target.mothership.services.apigee.c.b.t;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            a, TGTAddToCart, TGTAddToCartProduct, TGTCartRegistryDetails

class this._cls0
    implements aa
{

    final com.target.mothership.model.cart.handler.a this$0;

    public AddToCart a(a a1)
    {
        TGTAddToCart tgtaddtocart = new TGTAddToCart();
        tgtaddtocart.a(a1.a());
        Object obj;
        int i;
        if (a1.b() != null)
        {
            i = Double.valueOf(a1.b()).intValue();
        } else
        {
            i = 0;
        }
        tgtaddtocart.a(i);
        if (a1.c() != null)
        {
            obj = new BigDecimal(a1.c());
        } else
        {
            obj = BigDecimal.ZERO;
        }
        tgtaddtocart.a(((BigDecimal) (obj)));
        obj = new ArrayList();
        if (a1.d() != null)
        {
            TGTAddToCartProduct tgtaddtocartproduct;
            for (a1 = a1.d().iterator(); a1.hasNext(); ((List) (obj)).add(tgtaddtocartproduct))
            {
                com.target.mothership.services.apigee.c.b.dToCart dtocart = (com.target.mothership.services.apigee.c.b.dToCart.a)a1.next();
                tgtaddtocartproduct = new TGTAddToCartProduct();
                tgtaddtocartproduct.a(dtocart.f());
                tgtaddtocartproduct.a(dtocart.h());
                tgtaddtocartproduct.a(dtocart.a());
                tgtaddtocartproduct.a(false);
                ArrayList arraylist = new ArrayList();
                if (dtocart.b() != null)
                {
                    TGTOrderProductImage tgtorderproductimage = new TGTOrderProductImage();
                    for (Iterator iterator = dtocart.b().iterator(); iterator.hasNext(); arraylist.add(tgtorderproductimage))
                    {
                        t t1 = (t)iterator.next();
                        tgtorderproductimage.a(t1.a());
                        tgtorderproductimage.b(t1.b());
                    }

                }
                tgtaddtocartproduct.a(arraylist);
                tgtaddtocartproduct.b(false);
                tgtaddtocartproduct.a(dtocart.j());
                tgtaddtocartproduct.a(dtocart.d());
                tgtaddtocartproduct.b(dtocart.g());
                tgtaddtocartproduct.c(dtocart.i());
                tgtaddtocartproduct.l(dtocart.e());
                tgtaddtocartproduct.a(dtocart.c());
                if (dtocart.l() != null)
                {
                    tgtaddtocartproduct.a(new StoreIdentifier(dtocart.l()));
                }
                tgtaddtocartproduct.a(dtocart.k());
                if (o.g(dtocart.n()))
                {
                    TGTCartRegistryDetails tgtcartregistrydetails = new TGTCartRegistryDetails();
                    tgtcartregistrydetails.a(new RegistryId(dtocart.n()));
                    tgtcartregistrydetails.a(dtocart.m());
                    tgtcartregistrydetails.a(j.a(dtocart.o()));
                    tgtaddtocartproduct.a(tgtcartregistrydetails);
                }
            }

        }
        tgtaddtocart.a(((List) (obj)));
        return tgtaddtocart;
    }

    public volatile Object a(Object obj)
    {
        return a((a)obj);
    }

    ddToCart()
    {
        this$0 = com.target.mothership.model.cart.handler.a.this;
        super();
    }
}
