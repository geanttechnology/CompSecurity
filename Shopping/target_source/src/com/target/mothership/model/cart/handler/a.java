// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.j;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.b;
import com.target.mothership.model.cart.interfaces.AddToCart;
import com.target.mothership.model.common.TGTOrderProductImage;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.t;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTAddToCart, TGTAddToCartProduct, TGTCartRegistryDetails

public class a extends b
{

    private final int QUANTITY_NULL = 0;
    private final aa mTransformer = new aa() {

        final a this$0;

        public AddToCart a(com.target.mothership.services.apigee.c.b.a a1)
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
                    com.target.mothership.services.apigee.c.b.b b1 = (com.target.mothership.services.apigee.c.b.b)a1.next();
                    tgtaddtocartproduct = new TGTAddToCartProduct();
                    tgtaddtocartproduct.a(b1.f());
                    tgtaddtocartproduct.a(b1.h());
                    tgtaddtocartproduct.a(b1.a());
                    tgtaddtocartproduct.a(false);
                    ArrayList arraylist = new ArrayList();
                    if (b1.b() != null)
                    {
                        TGTOrderProductImage tgtorderproductimage = new TGTOrderProductImage();
                        for (Iterator iterator = b1.b().iterator(); iterator.hasNext(); arraylist.add(tgtorderproductimage))
                        {
                            t t1 = (t)iterator.next();
                            tgtorderproductimage.a(t1.a());
                            tgtorderproductimage.b(t1.b());
                        }

                    }
                    tgtaddtocartproduct.a(arraylist);
                    tgtaddtocartproduct.b(false);
                    tgtaddtocartproduct.a(b1.j());
                    tgtaddtocartproduct.a(b1.d());
                    tgtaddtocartproduct.b(b1.g());
                    tgtaddtocartproduct.c(b1.i());
                    tgtaddtocartproduct.l(b1.e());
                    tgtaddtocartproduct.a(b1.c());
                    if (b1.l() != null)
                    {
                        tgtaddtocartproduct.a(new StoreIdentifier(b1.l()));
                    }
                    tgtaddtocartproduct.a(b1.k());
                    if (o.g(b1.n()))
                    {
                        TGTCartRegistryDetails tgtcartregistrydetails = new TGTCartRegistryDetails();
                        tgtcartregistrydetails.a(new RegistryId(b1.n()));
                        tgtcartregistrydetails.a(b1.m());
                        tgtcartregistrydetails.a(j.a(b1.o()));
                        tgtaddtocartproduct.a(tgtcartregistrydetails);
                    }
                }

            }
            tgtaddtocart.a(((List) (obj)));
            return tgtaddtocart;
        }

        public volatile Object a(Object obj)
        {
            return a((com.target.mothership.services.apigee.c.b.a)obj);
        }

            
            {
                this$0 = a.this;
                super();
            }
    };

    public a(d d)
    {
        super(d);
    }

    protected AddToCart a(com.target.mothership.services.apigee.c.b.a a1)
    {
        return (AddToCart)mTransformer.a(a1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.apigee.c.b.a)obj);
    }

    protected com.target.mothership.model.cart.interfaces.a.b b(x x)
    {
        return (new com.target.mothership.model.cart.a.b()).a(x);
    }
}
