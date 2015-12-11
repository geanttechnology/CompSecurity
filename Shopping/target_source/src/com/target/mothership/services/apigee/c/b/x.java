// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import java.util.List;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            i

public class x extends i
{

    private List mAppliedPromoCodes;
    private String mCustomerOrderNumber;
    private String mIsFreeShippingStr;
    private String mIsRedCardShippingAppliedStr;

    public x()
    {
    }

    public String R()
    {
        return mCustomerOrderNumber;
    }

    public boolean S()
    {
        return Boolean.parseBoolean(mIsFreeShippingStr);
    }

    public boolean T()
    {
        return Boolean.parseBoolean(mIsRedCardShippingAppliedStr);
    }

    public List U()
    {
        return mAppliedPromoCodes;
    }
}
