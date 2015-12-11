// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.a;

import com.target.mothership.common.a.j;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.services.k;

public class a extends k
{

    private static final String REGISTRY_CATEGORY = "BTC";
    private static final String YES = "Y";
    private String mAgePrevRestriction;
    private String mDeliveryType;
    private String mEspCheck;
    private String mEsrbRequired;
    private String mIsGiftCard;
    private String mMinAge;
    private String mOrderItemId;
    private String mPickUpItemType;
    private String mPickupStoreId;
    private String mProductId;
    private String mQuantity;
    private String mRegistryCategory;
    private String mRegistryId;
    private String mRegistryType;
    private String mWarrantyProductId;

    public a(CatEntryId catentryid, int i)
    {
        mProductId = catentryid.b();
        mQuantity = String.valueOf(i);
    }

    public void a(int i, int l)
    {
        if (i == 0 || l == 0)
        {
            throw new IllegalArgumentException("minAge and agePrevRestriction should be set");
        } else
        {
            mEsrbRequired = "Y";
            mMinAge = String.valueOf(i);
            mAgePrevRestriction = String.valueOf(l);
            return;
        }
    }

    public void a(j j1, String s)
    {
        mRegistryType = j1.toString();
        mRegistryId = s;
        mRegistryCategory = "BTC";
    }

    public void a(String s)
    {
        mPickupStoreId = s;
    }

    public void b(String s)
    {
        mPickUpItemType = s;
    }
}
