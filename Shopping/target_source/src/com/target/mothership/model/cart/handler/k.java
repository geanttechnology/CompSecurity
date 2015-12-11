// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.i;
import com.target.mothership.model.cart.interfaces.a.g;
import com.target.mothership.model.d;
import com.target.mothership.services.apigee.c.b.ae;
import com.target.mothership.services.x;

public class k extends b
{

    public k(d d)
    {
        super(d);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((ae)obj);
    }

    protected String a(ae ae1)
    {
        return ae1.a();
    }

    protected g b(x x)
    {
        return (new i()).a(x);
    }
}
