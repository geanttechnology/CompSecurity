// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets.handler;

import com.target.mothership.model.coupon_wallets.a.c;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.e.b.a;
import com.target.mothership.services.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.coupon_wallets.handler:
//            c

public class b extends com.target.mothership.model.b
{

    private aa mTransformer;

    public b(d d)
    {
        super(d);
        mTransformer = new aa() {

            final b this$0;

            public volatile Object a(Object obj)
            {
                return a((a)obj);
            }

            public List a(a a1)
            {
                ArrayList arraylist = new ArrayList();
                if (a1 == null)
                {
                    return arraylist;
                }
                Object obj = a1.a();
                if (obj == null)
                {
                    return arraylist;
                }
                a1 = new com.target.mothership.model.coupon_wallets.handler.c();
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(a1.a((com.target.mothership.services.apigee.e.b.c)((Iterator) (obj)).next()))) { }
                return arraylist;
            }

            
            {
                this$0 = b.this;
                super();
            }
        };
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((a)obj);
    }

    protected List a(a a1)
    {
        return (List)mTransformer.a(a1);
    }

    protected com.target.mothership.model.coupon_wallets.interfaces.a.b b(x x)
    {
        return (new c()).a(x);
    }
}
