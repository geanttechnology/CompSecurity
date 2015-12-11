// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.target.mothership.common.a.c;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            v

public class r extends v
{

    private String mExpressCheckoutEligibilityFlag;
    private String mIsCvvRequired;
    private String mIsTcPinRequired;
    private String mReason;
    private String mReasonCode;

    public r()
    {
    }

    public boolean I()
    {
        return Boolean.parseBoolean(mExpressCheckoutEligibilityFlag);
    }

    public String J()
    {
        return mReason;
    }

    public c K()
    {
        return c.a(mReasonCode);
    }

    public boolean L()
    {
        return Boolean.parseBoolean(mIsCvvRequired);
    }

    public boolean M()
    {
        return Boolean.parseBoolean(mIsTcPinRequired);
    }
}
