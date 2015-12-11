// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.ProductAvailability;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.a.b.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            j, TGTProductAvailability, k, TGTProductAvailabilityStore

public class i extends f
{

    private final aa mTransformer = new aa() {

        final i this$0;

        public ProductAvailability a(a a1)
        {
            TGTProductAvailability tgtproductavailability = new TGTProductAvailability();
            if (!a1.a().isEmpty())
            {
                Object obj = (com.target.mothership.services.apigee.a.b.a.b)a1.a().get(0);
                a1 = new k();
                j j1 = new j();
                ArrayList arraylist = new ArrayList();
                TGTProductAvailabilityStore tgtproductavailabilitystore;
                for (obj = ((com.target.mothership.services.apigee.a.b.a.b) (obj)).a().iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(tgtproductavailabilitystore))
                {
                    com.target.mothership.services.apigee.a.b.a.a a2 = (com.target.mothership.services.apigee.a.b.a.a)((Iterator) (obj)).next();
                    tgtproductavailabilitystore = new TGTProductAvailabilityStore();
                    tgtproductavailabilitystore.a(new StoreIdentifier(a2.a()));
                    tgtproductavailabilitystore.a(a1.a(a2.b()));
                    tgtproductavailabilitystore.a(a2.c());
                    tgtproductavailabilitystore.a(com.target.mothership.model.product.handler.i.a(i.this, j1, a2.d()));
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
                this$0 = i.this;
                super();
            }
    };

    public i(h h)
    {
        super(h);
    }

    static List a(i k, j j1, List list)
    {
        return k.a(j1, list);
    }

    private List a(j j1, List list)
    {
        if (list == null || list.isEmpty())
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(j1.a((String)list.next()))) { }
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
