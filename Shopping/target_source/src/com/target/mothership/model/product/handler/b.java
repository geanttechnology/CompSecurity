// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.ProductAvailability;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.productsV3.response.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            c, TGTProductAvailability, f, TGTProductAvailabilityStore

public class b extends f
{

    private final aa mTransformer = new aa() {

        final b this$0;

        public ProductAvailability a(a a1)
        {
            TGTProductAvailability tgtproductavailability = new TGTProductAvailability();
            if (!a1.a().isEmpty())
            {
                Object obj = (com.target.mothership.services.apigee.productsV3.response.a.b)a1.a().get(0);
                a1 = new com.target.mothership.model.product.handler.f();
                c c1 = new c();
                ArrayList arraylist = new ArrayList();
                TGTProductAvailabilityStore tgtproductavailabilitystore;
                for (obj = ((com.target.mothership.services.apigee.productsV3.response.a.b) (obj)).a().iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(tgtproductavailabilitystore))
                {
                    com.target.mothership.services.apigee.productsV3.response.a.c c2 = (com.target.mothership.services.apigee.productsV3.response.a.c)((Iterator) (obj)).next();
                    tgtproductavailabilitystore = new TGTProductAvailabilityStore();
                    tgtproductavailabilitystore.a(new StoreIdentifier(c2.a()));
                    tgtproductavailabilitystore.a(c2.c());
                    tgtproductavailabilitystore.a(a1.a(c2.b()));
                    tgtproductavailabilitystore.a(com.target.mothership.model.product.handler.b.a(b.this, c1, c2.d()));
                }

                tgtproductavailability.a(arraylist);
            }
            return tgtproductavailability;
        }

        public volatile Object a(Object obj)
        {
            return a((a)obj);
        }

            
            {
                this$0 = b.this;
                super();
            }
    };

    public b(h h)
    {
        super(h);
    }

    static List a(b b1, c c1, List list)
    {
        return b1.a(c1, list);
    }

    private List a(c c1, List list)
    {
        if (list == null || list.isEmpty())
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(c1.a(((com.target.mothership.services.apigee.productsV3.response.a.a)list.next()).a()))) { }
        return arraylist;
    }

    protected ProductAvailability a(a a1)
    {
        return (ProductAvailability)mTransformer.a(a1);
    }

    protected volatile Object a(Object obj)
    {
        return a((a)obj);
    }
}
