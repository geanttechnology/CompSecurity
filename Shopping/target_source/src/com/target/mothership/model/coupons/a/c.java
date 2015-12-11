// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons.a;


// Referenced classes of package com.target.mothership.model.coupons.a:
//            i

public class c
{

    private com.target.mothership.model.common.a.c mErrorCode;

    public c(String s)
    {
        mErrorCode = null;
        s = com.target.mothership.model.coupons.handler.c.a(s);
        if (s == com.target.mothership.model.coupons.handler.c.SUCCESS || s == com.target.mothership.model.coupons.handler.c.PARTIAL_SUCCESS)
        {
            mErrorCode = null;
            return;
        } else
        {
            mErrorCode = i.a(s);
            return;
        }
    }

    public boolean a()
    {
        return mErrorCode != null;
    }

    public com.target.mothership.model.common.a.c b()
    {
        return mErrorCode;
    }
}
