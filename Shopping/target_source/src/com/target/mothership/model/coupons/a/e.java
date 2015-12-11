// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.model.coupons.interfaces.a.c;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.List;

public class e
{

    private c mError;

    public e(String s)
    {
        mError = null;
        if (o.g(s))
        {
            return;
        } else
        {
            s = com.target.mothership.model.coupons.interfaces.a.c.a.COUPON_ERR_INSTANCE_KEY;
            c c1 = new c();
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(s);
            c1.a(s);
            c1.a(arraylist);
            c1.a(null);
            mError = c1;
            return;
        }
    }

    public boolean a()
    {
        return mError != null;
    }

    public c b()
    {
        return mError;
    }
}
