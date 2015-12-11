// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import java.util.ArrayList;
import java.util.List;

public class o
{
    public static class a
    {

        private String mShipModeCharge;
        private String mShipModeCode;
        private String mShipModeCurrency;
        private String mShipModeId;

        public String a()
        {
            return mShipModeCode;
        }

        public String b()
        {
            return mShipModeId;
        }

        public String c()
        {
            return mShipModeCharge;
        }

        public String d()
        {
            return mShipModeCurrency;
        }

        public a()
        {
        }
    }


    private String mFullfillmentTypeString;
    private List mShippingModes;

    public o()
    {
        mShippingModes = new ArrayList();
    }

    public String a()
    {
        return mFullfillmentTypeString;
    }

    public List b()
    {
        return mShippingModes;
    }
}
