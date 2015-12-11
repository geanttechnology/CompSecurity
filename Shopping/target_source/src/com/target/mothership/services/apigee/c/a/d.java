// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;


// Referenced classes of package com.target.mothership.services.apigee.c.a:
//            ac

public class d extends ac
{

    private static final String FALSE = "false";
    private static final String TRUE = "true";

    public d(String s, boolean flag)
    {
        mPromoCode = s;
        if (flag)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        mCouponPromotion = s;
        mTaskType = "A";
    }
}
