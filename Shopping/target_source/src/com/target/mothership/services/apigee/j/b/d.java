// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.j.b;

import com.target.mothership.services.apigee.c.b.i;
import java.util.List;

public class d extends i
{

    private String mHasStorePickup;
    private String mIsCancellable;
    private String mIsEligibleToChangeStorePickupInfo;
    private String mIsReorderable;
    private String mIsReturnable;
    private String mIsStorePickUpExtendPossible;
    private String mOrderId;
    private String mOrderPlacedDate;
    private String mOrderStatus;
    private List mPaymentInstructionList;
    private List mShipmentList;
    private String mTrackEmail;

    public d()
    {
    }

    public String I()
    {
        return mHasStorePickup;
    }

    public String J()
    {
        return mIsCancellable;
    }

    public String K()
    {
        return mIsEligibleToChangeStorePickupInfo;
    }

    public String L()
    {
        return mIsStorePickUpExtendPossible;
    }

    public String M()
    {
        return mIsReorderable;
    }

    public String N()
    {
        return mIsReturnable;
    }

    public String O()
    {
        return mOrderStatus;
    }

    public String P()
    {
        return mOrderPlacedDate;
    }

    public List Q()
    {
        return mPaymentInstructionList;
    }

    public List R()
    {
        return mShipmentList;
    }

    public String y()
    {
        return mOrderId;
    }
}
