// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.a.a.b;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.h;
import com.target.mothership.services.aa;
import com.target.mothership.services.b.a.b.d;
import com.target.mothership.services.b.a.b.f;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.coupons.handler:
//            d, TGTAvailableCouponOffer

public class g extends com.target.mothership.model.coupons.handler.d
{

    private static final String TAG = com/target/mothership/model/coupons/handler/g.getSimpleName();
    private static final String TRUE = "true";
    private final aa mOfferTransformer = new aa() {

        final g this$0;

        public AvailableCouponOffer a(d d1)
        {
            TGTAvailableCouponOffer tgtavailablecouponoffer = new TGTAvailableCouponOffer();
            g.this.a(tgtavailablecouponoffer, d1);
            boolean flag = "true".equals(d1.a());
            d1 = d1.b();
            tgtavailablecouponoffer.a(flag);
            tgtavailablecouponoffer.a(d1);
            return tgtavailablecouponoffer;
        }

        public volatile Object a(Object obj)
        {
            return a((d)obj);
        }

            
            {
                this$0 = g.this;
                super();
            }
    };
    private final aa mResponseTransformer = new aa() {

        final g this$0;

        public volatile Object a(Object obj)
        {
            return a((f)obj);
        }

        public List a(f f1)
        {
            ArrayList arraylist = new ArrayList();
            if (f1 == null)
            {
                return arraylist;
            }
            for (f1 = f1.a().iterator(); f1.hasNext();)
            {
                d d1 = (d)f1.next();
                if (d1.b() == null)
                {
                    com.target.a.a.b.a(com.target.mothership.model.coupons.handler.g.b(), "Available coupon missing accessor");
                } else
                {
                    arraylist.add(g.a(g.this).a(d1));
                }
            }

            return arraylist;
        }

            
            {
                this$0 = g.this;
                super();
            }
    };

    public g(h h)
    {
        super(h);
    }

    static aa a(g g1)
    {
        return g1.mOfferTransformer;
    }

    static String b()
    {
        return TAG;
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((f)obj);
    }

    protected List a(f f1)
    {
        return (List)mResponseTransformer.a(f1);
    }

    protected x b(x x)
    {
        return x;
    }

}
