// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.t;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.a.o;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.r;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            s, TGTExpressOrderReview

public class ac extends b
{

    private final aa mTransformer = new aa() {

        final ac this$0;

        public TGTExpressOrderReview a(r r1)
        {
            TGTExpressOrderReview tgtexpressorderreview = (TGTExpressOrderReview)(new s()).a(r1);
            tgtexpressorderreview.a(r1.I());
            tgtexpressorderreview.a(r1.K());
            tgtexpressorderreview.p(r1.J());
            tgtexpressorderreview.b(r1.L());
            tgtexpressorderreview.c(r1.M());
            return tgtexpressorderreview;
        }

        public volatile Object a(Object obj)
        {
            return a((r)obj);
        }

            
            {
                this$0 = ac.this;
                super();
            }
    };

    public ac(d d)
    {
        super(d);
    }

    protected ExpressOrderReview a(r r1)
    {
        return (ExpressOrderReview)mTransformer.a(r1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((r)obj);
    }

    protected o b(x x)
    {
        return (new t()).a(x);
    }
}
