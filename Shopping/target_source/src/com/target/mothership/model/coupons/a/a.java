// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.util.o;

public class a
{

    private com.target.mothership.model.coupons.interfaces.a.a mError;

    public a(String s)
    {
        mError = null;
        if (o.g(s))
        {
            return;
        } else
        {
            s = com.target.mothership.model.coupons.interfaces.a.a.COUPON_ERR_INSTANCE_KEY;
            com.target.mothership.model.coupons.interfaces.a.a a1 = new com.target.mothership.model.coupons.interfaces.a.a();
            a1.a(s);
            a1.a(null);
            mError = a1;
            return;
        }
    }

    public boolean a()
    {
        return mError != null;
    }

    public com.target.mothership.model.coupons.interfaces.a.a b()
    {
        return mError;
    }
}
