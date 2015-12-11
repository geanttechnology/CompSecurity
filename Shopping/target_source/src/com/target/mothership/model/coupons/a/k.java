// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;

import com.target.mothership.services.x;
import com.target.mothership.services.z;
import com.target.mothership.util.o;

public class k
{

    private static final String NO_ACCESS_KEY_ERROR = "Missing access key for completed sign up";
    private x mError;

    public k(String s)
    {
        mError = null;
        if (o.g(s))
        {
            return;
        } else
        {
            mError = x.a("Missing access key for completed sign up").b("").a(z.EMPTY_RESPONSE).a();
            return;
        }
    }

    public boolean a()
    {
        return mError != null;
    }

    public x b()
    {
        return mError;
    }
}
