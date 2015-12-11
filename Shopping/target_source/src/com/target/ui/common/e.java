// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import com.target.mothership.common.product.a;
import com.target.mothership.common.product.c;
import com.target.mothership.common.product.i;
import com.target.mothership.model.product.interfaces.ProductLimitedAvailability;
import com.target.mothership.model.registries.interfaces.RegistryDetails;

public class e
{

    private String mAisleLocation;
    private a mCalloutType;
    private c mChannelAvailabilityCode;
    private com.target.ui.view.DepartmentBadgeView.a mDepartment;
    private ProductLimitedAvailability mLimitedAvailableQuantity;
    private i mOnlineInventoryStatus;
    private RegistryDetails mRegistryDetails;
    private i mStoreInventoryStatus;
    private String mStoreName;

    public e()
    {
        mCalloutType = a.UNKNOWN;
        mStoreInventoryStatus = i.UNKNOWN;
        mOnlineInventoryStatus = i.UNKNOWN;
    }

    public a a()
    {
        return mCalloutType;
    }

    public void a(a a1)
    {
        mCalloutType = a1;
    }

    public void a(c c1)
    {
        mChannelAvailabilityCode = c1;
    }

    public void a(i j)
    {
        mStoreInventoryStatus = j;
    }

    public void a(ProductLimitedAvailability productlimitedavailability)
    {
        mLimitedAvailableQuantity = productlimitedavailability;
    }

    public void a(RegistryDetails registrydetails)
    {
        mRegistryDetails = registrydetails;
    }

    public void a(com.target.ui.view.DepartmentBadgeView.a a1)
    {
        mDepartment = a1;
    }

    public void a(String s)
    {
        mStoreName = s;
    }

    public com.google.a.a.e b()
    {
        return com.google.a.a.e.c(mDepartment);
    }

    public void b(i j)
    {
        mOnlineInventoryStatus = j;
    }

    public void b(String s)
    {
        mAisleLocation = s;
    }

    public com.google.a.a.e c()
    {
        return com.google.a.a.e.c(mStoreName);
    }

    public com.google.a.a.e d()
    {
        return com.google.a.a.e.c(mAisleLocation);
    }

    public com.google.a.a.e e()
    {
        return com.google.a.a.e.c(mRegistryDetails);
    }

    public i f()
    {
        return mStoreInventoryStatus;
    }

    public i g()
    {
        return mOnlineInventoryStatus;
    }

    public com.google.a.a.e h()
    {
        return com.google.a.a.e.c(mLimitedAvailableQuantity);
    }

    public c i()
    {
        return mChannelAvailabilityCode;
    }
}
