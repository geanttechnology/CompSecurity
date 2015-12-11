// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.m;
import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.mothership.model.cart.interfaces.a.h;
import com.target.mothership.model.d;
import com.target.mothership.services.apigee.c.b.l;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            ad

public class r extends b
{

    public r(d d)
    {
        super(d);
    }

    protected OrderCompletionDetails a(l l1)
    {
        return (new ad()).a(l1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((l)obj);
    }

    protected h b(x x)
    {
        return (new m()).a(x);
    }
}
