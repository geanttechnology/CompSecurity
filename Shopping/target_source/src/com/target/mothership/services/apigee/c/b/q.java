// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import java.util.List;

public class q
{
    public static class a
    {

        private String mDefaultAddressId;
        private String mDefaultFullfillmentType;
        private String mDefaultShipModeCode;
        private List mEligibleShippingModes;

        public String a()
        {
            return mDefaultAddressId;
        }

        public String b()
        {
            return mDefaultFullfillmentType;
        }

        public String c()
        {
            return mDefaultShipModeCode;
        }

        public List d()
        {
            return mEligibleShippingModes;
        }

        public a()
        {
        }
    }


    private List mOrderItemList;

    public q()
    {
    }

    public List a()
    {
        return mOrderItemList;
    }
}
