// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.o;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.a.j;
import com.target.mothership.model.d;
import com.target.mothership.services.apigee.c.b.f;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            m

public class l extends b
{

    public l(d d)
    {
        super(d);
    }

    protected CartDetails a(f f1)
    {
        return (new m()).a(f1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((f)obj);
    }

    protected j b(x x)
    {
        return (new o()).a(x);
    }
}
