// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.productsV3.response;

import java.util.List;

public class com.target.mothership.services.apigee.productsV3.response.a
{
    public class a
    {

        private String mMultichannelOption;
        final com.target.mothership.services.apigee.productsV3.response.a this$0;

        public String a()
        {
            return mMultichannelOption;
        }
    }

    public class b
    {

        private String mProductId;
        private List mStores;
        final com.target.mothership.services.apigee.productsV3.response.a this$0;

        public List a()
        {
            return mStores;
        }
    }

    public class c
    {

        private String mAvailabilityStatus;
        private double mDistance;
        private List mMultichannelOptions;
        private int mOnHandQuantity;
        private int mSaleableQuantity;
        private String mStoreAddress;
        private String mStoreId;
        private String mStoreMainPhone;
        private String mStoreName;
        private int mThresholdQuantity;
        final com.target.mothership.services.apigee.productsV3.response.a this$0;

        public String a()
        {
            return mStoreId;
        }

        public String b()
        {
            return mAvailabilityStatus;
        }

        public int c()
        {
            return mSaleableQuantity;
        }

        public List d()
        {
            return mMultichannelOptions;
        }
    }


    private List mProducts;

    public com.target.mothership.services.apigee.productsV3.response.a()
    {
    }

    public List a()
    {
        return mProducts;
    }
}
