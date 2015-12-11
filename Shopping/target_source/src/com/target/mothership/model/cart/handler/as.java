// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.r;
import com.target.mothership.model.cart.interfaces.CartUsableShippingInfo;
import com.target.mothership.model.cart.interfaces.a.m;
import com.target.mothership.model.d;
import com.target.mothership.services.apigee.c.b.al;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            at

public class as extends b
{

    public as(d d)
    {
        super(d);
    }

    protected CartUsableShippingInfo a(al al1)
    {
        return (new at()).a(al1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((al)obj);
    }

    protected m b(x x)
    {
        return (new r()).a(x);
    }
}
