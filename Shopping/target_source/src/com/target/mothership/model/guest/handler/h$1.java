// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import com.target.mothership.model.guest.interfaces.OrderDetails;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.j.b.f;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            h, n

class this._cls0
    implements aa
{

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

    rderDetails()
    {
        this$0 = h.this;
        super();
    }
}
