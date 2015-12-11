// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.coupons.a.c;
import com.target.mothership.model.coupons.a.l;
import com.target.mothership.model.d;
import com.target.mothership.services.x;
import com.target.mothership.util.o;

public class a extends b
{

    private String mAppAccessKey;
    private com.target.mothership.model.common.a.c mErrorCode;

    public a(String s, d d)
    {
        super(d);
        mAppAccessKey = s;
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.b.a.b.a)obj);
    }

    protected Void a(com.target.mothership.services.b.a.b.a a1)
    {
        if (o.g(mAppAccessKey))
        {
            com.target.mothership.cache.b.getInstance().updateAppAccessKey(mAppAccessKey);
        }
        return null;
    }

    protected com.target.mothership.model.coupons.interfaces.a.a b(x x)
    {
        return (new com.target.mothership.model.coupons.a.b()).a(x);
    }

    protected boolean b(com.target.mothership.services.b.a.b.a a1)
    {
        String s1 = "";
        String s2 = "";
        Object obj = s2;
        String s = s1;
        if (a1 != null)
        {
            obj = s2;
            s = s1;
            if (a1.a())
            {
                s = a1.b();
                obj = a1.c();
            }
        }
        a1 = new l(s);
        obj = new c(((String) (obj)));
        if (((c) (obj)).a())
        {
            mErrorCode = ((c) (obj)).b();
            return false;
        }
        if (a1.a())
        {
            mErrorCode = a1.b();
            return false;
        } else
        {
            return true;
        }
    }

    protected com.target.mothership.model.coupons.interfaces.a.a c(com.target.mothership.services.b.a.b.a a1)
    {
        return (new com.target.mothership.model.coupons.a.b()).a(mErrorCode);
    }

    protected volatile Object c(Object obj)
    {
        return c((com.target.mothership.services.b.a.b.a)obj);
    }

    protected boolean e(Object obj)
    {
        return b((com.target.mothership.services.b.a.b.a)obj);
    }
}
