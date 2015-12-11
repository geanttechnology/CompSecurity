// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.common.a.c;
import com.target.mothership.model.coupons.a.g;
import com.target.mothership.model.coupons.a.l;
import com.target.mothership.model.d;
import com.target.mothership.services.x;

public class j extends b
{

    private c mErrorCode;

    public j(d d)
    {
        super(d);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.b.a.b.j)obj);
    }

    protected String a(com.target.mothership.services.b.a.b.j j1)
    {
        return j1.c();
    }

    protected com.target.mothership.model.coupons.interfaces.a.b b(x x)
    {
        return (new g()).a(x);
    }

    protected boolean b(com.target.mothership.services.b.a.b.j j1)
    {
        String s1 = "";
        String s = s1;
        if (j1 != null)
        {
            s = s1;
            if (j1.a())
            {
                s = j1.b();
            }
        }
        j1 = new l(s);
        if (j1.a())
        {
            mErrorCode = j1.b();
            return false;
        } else
        {
            return true;
        }
    }

    protected com.target.mothership.model.coupons.interfaces.a.b c(com.target.mothership.services.b.a.b.j j1)
    {
        return (new g()).a(mErrorCode);
    }

    protected volatile Object c(Object obj)
    {
        return c((com.target.mothership.services.b.a.b.j)obj);
    }

    protected boolean e(Object obj)
    {
        return b((com.target.mothership.services.b.a.b.j)obj);
    }
}
