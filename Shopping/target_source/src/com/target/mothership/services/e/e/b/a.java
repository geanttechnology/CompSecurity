// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.b;

import java.math.BigDecimal;
import java.util.List;

public class com.target.mothership.services.e.e.b.a
{
    public class a
    {

        private String mDpci;
        private Double mPrice;
        final com.target.mothership.services.e.e.b.a this$0;

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


    private List mPrices;

    public com.target.mothership.services.e.e.b.a()
    {
    }

    public List a()
    {
        return mPrices;
    }
}
