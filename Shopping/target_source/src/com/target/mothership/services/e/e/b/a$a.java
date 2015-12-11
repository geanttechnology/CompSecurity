// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b;

import java.math.BigDecimal;

// Referenced classes of package com.target.mothership.services.e.e.b:
//            a

public class 
{

    private String mDpci;
    private Double mPrice;
    final a this$0;

    public String a()
    {
        return mDpci;
    }

    public BigDecimal b()
    {
        if (mPrice != null)
        {
            return new BigDecimal(mPrice.doubleValue());
        } else
        {
            return null;
        }
    }
}
