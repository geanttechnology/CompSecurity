// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.c;
import com.target.mothership.model.b;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.af;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            s, TGTExpressOrderReview

public class an extends b
{

    private final aa mTransformer = new aa() {

        final an this$0;

        public TGTExpressOrderReview a(af af1)
        {
            TGTExpressOrderReview tgtexpressorderreview = (TGTExpressOrderReview)(new s()).a(af1);
            tgtexpressorderreview.a(Boolean.parseBoolean(af1.I()));
            tgtexpressorderreview.a(c.a(af1.K()));
            tgtexpressorderreview.p(af1.J());
            tgtexpressorderreview.b(Boolean.parseBoolean(af1.L()));
            tgtexpressorderreview.c(Boolean.parseBoolean(af1.M()));
            return tgtexpressorderreview;
        }

        public volatile Object a(Object obj)
        {
            return a((af)obj);
        }

            
            {
                this$0 = an.this;
                super();
            }
    };

    public an(d d)
    {
        super(d);
    }

    protected ExpressOrderReview a(af af1)
    {
        return (ExpressOrderReview)mTransformer.a(af1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((af)obj);
    }

    protected com.target.mothership.model.cart.interfaces.a.b b(x x)
    {
        return (new com.target.mothership.model.cart.a.b()).a(x);
    }
}
