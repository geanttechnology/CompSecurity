// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.OrderDetails;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.j.b.f;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            n

public class h extends b
{

    private final aa mSuccessTransformer = new aa() {

        final h this$0;

        public OrderDetails a(f f1)
        {
            if (f1 == null || f1.a() == null)
            {
                return null;
            } else
            {
                return (new n()).a(f1.a());
            }
        }

        public volatile Object a(Object obj)
        {
            return a((f)obj);
        }

            
            {
                this$0 = h.this;
                super();
            }
    };

    public h(d d)
    {
        super(d);
    }

    protected OrderDetails a(f f1)
    {
        return (OrderDetails)mSuccessTransformer.a(f1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((f)obj);
    }

    protected com.target.mothership.model.guest.interfaces.a.h b(x x)
    {
        return (new com.target.mothership.model.guest.a.h()).a(x);
    }
}
