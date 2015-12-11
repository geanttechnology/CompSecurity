// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.handler;

import com.target.mothership.model.common.a.c;
import com.target.mothership.model.coupons.a.g;
import com.target.mothership.model.coupons.a.l;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.d;
import com.target.mothership.services.x;

public class b extends com.target.mothership.model.b
{

    private CompletedSignUp mCompletedSignUp;
    private c mErrorCode;

    public b(CompletedSignUp completedsignup, d d)
    {
        super(d);
        mCompletedSignUp = completedsignup;
    }

    protected CompletedSignUp a(com.target.mothership.services.b.a.b.b b1)
    {
        return mCompletedSignUp;
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.b.a.b.b)obj);
    }

    protected com.target.mothership.model.coupons.interfaces.a.b b(x x)
    {
        return (new g()).a(x);
    }

    protected boolean b(com.target.mothership.services.b.a.b.b b1)
    {
        String s1 = "";
        String s = s1;
        if (b1 != null)
        {
            s = s1;
            if (b1.a())
            {
                s = b1.b();
            }
        }
        b1 = new l(s);
        if (b1.a())
        {
            mErrorCode = b1.b();
            return false;
        } else
        {
            return true;
        }
    }

    protected com.target.mothership.model.coupons.interfaces.a.b c(com.target.mothership.services.b.a.b.b b1)
    {
        return (new g()).a(mErrorCode);
    }

    protected volatile Object c(Object obj)
    {
        return c((com.target.mothership.services.b.a.b.b)obj);
    }

    protected boolean e(Object obj)
    {
        return b((com.target.mothership.services.b.a.b.b)obj);
    }
}
