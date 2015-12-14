// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.receipt;

import junit.framework.Assert;

// Referenced classes of package com.aviary.android.feather.receipt:
//            Receipt

public static class mIsFree
{

    private final boolean mIsFree;
    private boolean mIsNewPurchase;
    private String mOrderId;
    private String mPrice;
    private String mProductId;
    private long mPurchaseTime;
    private String mToken;

    public Receipt build()
        throws AssertionError
    {
        Receipt receipt = new Receipt(mProductId, mPurchaseTime);
        receipt.isNewPurchase = mIsNewPurchase;
        if (mIsFree)
        {
            receipt.isFree = true;
        } else
        {
            receipt.isFree = false;
            if (mIsNewPurchase)
            {
                Assert.assertNotNull("orderId cannot be null", mOrderId);
                Assert.assertNotNull("token cannot be null", mToken);
                Assert.assertNotNull("price cannot be null", mPrice);
                receipt.orderId = mOrderId;
                receipt.purchaseToken = mToken;
                receipt.price = mPrice;
                return receipt;
            }
        }
        return receipt;
    }

    public mPrice isNewPurchase(boolean flag)
    {
        mIsNewPurchase = flag;
        return this;
    }

    public mIsNewPurchase withOrderId(String s)
    {
        mOrderId = s;
        return this;
    }

    public mOrderId withPrice(String s)
    {
        mPrice = s;
        return this;
    }

    public mPrice withProductId(String s)
    {
        mProductId = s;
        return this;
    }

    public mProductId withPurchaseTime(long l)
    {
        mPurchaseTime = l;
        return this;
    }

    public mPurchaseTime withToken(String s)
    {
        mToken = s;
        return this;
    }

    public (boolean flag)
    {
        mIsFree = flag;
    }
}
