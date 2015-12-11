// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.a.b;

import java.util.List;

public class com.target.mothership.services.apigee.a.b.a
{
    public class a
    {

        private String mAvailabilityStatus;
        private int mAvailableToPromiseQuantity;
        private int mAvailableToReleaseQuantity;
        private int mDemandSum;
        private String mDistance;
        private String mFormattedStoreAddress;
        private int mHardDemandSum;
        private String mLocationDemandEvents;
        private String mLocationId;
        private String mLocationSupplyEvents;
        private String mLocationType;
        private List mMultichannelOptions;
        private int mOnHandQuantity;
        private int mPickUpWalkInReserve;
        private int mShipWalkInReserve;
        private int mSoftDemandSum;
        private String mStoreAddress;
        private String mStoreMainPhoneNumber;
        private String mStoreName;
        private int mSupplyDemandSum;
        private int mThresholdQuantity;
        private int mTransferDemandSum;
        final com.target.mothership.services.apigee.a.b.a this$0;

        public String a()
        {
            return mLocationId;
        }

        public String b()
        {
            return mAvailabilityStatus;
        }

        public int c()
        {
            return mAvailableToPromiseQuantity;
        }

        public List d()
        {
            return mMultichannelOptions;
        }
    }

    public class b
    {

        private boolean mIsLimitedQuantityProduct;
        private boolean mIsObgbEnabled;
        private int mLimitedQuantityHigher;
        private int mLimitedQuantityLower;
        private List mLocations;
        private int mPreOrderDemandSum;
        private String mProductId;
        private int mSubscriptionDemandSum;
        final com.target.mothership.services.apigee.a.b.a this$0;

        public List a()
        {
            return mLocations;
        }
    }


    private List mProducts;

    public com.target.mothership.services.apigee.a.b.a()
    {
    }

    public List a()
    {
        return mProducts;
    }
}
