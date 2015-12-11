// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.aa;
import com.target.mothership.model.cart.interfaces.a.v;
import com.target.mothership.model.d;
import com.target.mothership.services.apigee.c.b.ab;
import com.target.mothership.services.x;

public class ak extends b
{

    public ak(d d)
    {
        super(d);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((ab)obj);
    }

    protected String a(ab ab1)
    {
        return ab1.a();
    }

    protected v b(x x)
    {
        return (new aa()).a(x);
    }
}
