// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.i.b;

import java.util.List;

public class b
{
    public static class a
    {

        private String mDescription;
        private String mOrderItemId;
        private String mOrderItemStatus;
        private String mPartNumber;
        private String mQuantity;

        public String a()
        {
            return mQuantity;
        }

        public String b()
        {
            return mDescription;
        }

        public String c()
        {
            return mPartNumber;
        }

        public String d()
        {
            return mOrderItemId;
        }

        public String e()
        {
            return mOrderItemStatus;
        }

        public a()
        {
        }
    }


    private String mHasStorePickup;
    private String mIsCancellable;
    private String mIsEligibleToChangeStorePickupInfo;
    private String mIsReorderable;
    private String mIsReturnable;
    private String mIsStorePickUpExtendPossible;
    private String mOrderId;
    private List mOrderItems;
    private String mOrderPlacedDate;
    private String mOrderStatus;

    public b()
    {
    }

    public String a()
    {
        return mOrderId;
    }

    public String b()
    {
        return mHasStorePickup;
    }

    public String c()
    {
        return mIsCancellable;
    }

    public String d()
    {
        return mIsEligibleToChangeStorePickupInfo;
    }

    public String e()
    {
        return mIsStorePickUpExtendPossible;
    }

    public String f()
    {
        return mIsReorderable;
    }

    public String g()
    {
        return mIsReturnable;
    }

    public String h()
    {
        return mOrderStatus;
    }

    public String i()
    {
        return mOrderPlacedDate;
    }

    public List j()
    {
        return mOrderItems;
    }
}
