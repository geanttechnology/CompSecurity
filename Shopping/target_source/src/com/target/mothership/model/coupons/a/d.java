// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.model.coupons.interfaces.a.b;
import com.target.mothership.util.o;

public class d
{

    private b mError;

    public d(String s)
    {
        mError = null;
        if (o.g(s))
        {
            return;
        } else
        {
            s = com.target.mothership.model.coupons.interfaces.a.b.a.COUPON_ERR_INSTANCE_KEY;
            b b1 = new b();
            b1.a(s);
            b1.a(null);
            mError = b1;
            return;
        }
    }

    public boolean a()
    {
        return mError != null;
    }

    public b b()
    {
        return mError;
    }
}
