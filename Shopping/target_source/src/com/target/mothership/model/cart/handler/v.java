// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.p;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTFreeShippingPromotion

public class v extends f
{

    private final aa mTransformer = new aa() {

        final v this$0;

        public FreeShippingPromotion a(p p1)
        {
            TGTFreeShippingPromotion tgtfreeshippingpromotion = new TGTFreeShippingPromotion();
            tgtfreeshippingpromotion.a(p1.b());
            tgtfreeshippingpromotion.a(p1.a());
            return tgtfreeshippingpromotion;
        }

        public volatile Object a(Object obj)
        {
            return a((p)obj);
        }

            
            {
                this$0 = v.this;
                super();
            }
    };

    public v(h h)
    {
        super(h);
    }

    protected FreeShippingPromotion a(p p1)
    {
        return (FreeShippingPromotion)mTransformer.a(p1);
    }

    public Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((p)obj);
    }

    public x b(x x)
    {
        return x;
    }
}
