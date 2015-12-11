// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.ac;
import com.target.mothership.model.cart.interfaces.UpdatedFulfillment;
import com.target.mothership.model.cart.interfaces.a.w;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.ag;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTUpdatedFulfillment, TGTUpdatedFulfillmentOrderItem

public class ao extends b
{

    private final aa mTransformer = new aa() {

        final ao this$0;

        public UpdatedFulfillment a(ag ag1)
        {
            TGTUpdatedFulfillment tgtupdatedfulfillment = new TGTUpdatedFulfillment();
            com.target.mothership.model.common.b b1 = new com.target.mothership.model.common.b();
            ArrayList arraylist = new ArrayList();
            TGTUpdatedFulfillmentOrderItem tgtupdatedfulfillmentorderitem;
            for (ag1 = ag1.a().iterator(); ag1.hasNext(); arraylist.add(tgtupdatedfulfillmentorderitem))
            {
                com.target.mothership.services.apigee.c.b.ag.a a1 = (com.target.mothership.services.apigee.c.b.ag.a)ag1.next();
                tgtupdatedfulfillmentorderitem = new TGTUpdatedFulfillmentOrderItem();
                tgtupdatedfulfillmentorderitem.a(b1.a(a1.a()));
                tgtupdatedfulfillmentorderitem.a(Integer.parseInt(a1.b()));
            }

            tgtupdatedfulfillment.a(arraylist);
            return tgtupdatedfulfillment;
        }

        public volatile Object a(Object obj)
        {
            return a((ag)obj);
        }

            
            {
                this$0 = ao.this;
                super();
            }
    };

    public ao(d d)
    {
        super(d);
    }

    protected UpdatedFulfillment a(ag ag1)
    {
        return (UpdatedFulfillment)mTransformer.a(ag1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((ag)obj);
    }

    protected w b(x x)
    {
        return (new ac()).a(x);
    }
}
