// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.b;

import com.target.mothership.common.a.g;
import com.target.mothership.common.a.j;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.Store;

public class a
{

    private final boolean mIsAgeRestrictionAcknowledged;
    private g mPickUpItemType;
    private final ProductDetails mProductDetails;
    private final int mQuantity;
    private RegistryId mRegistryId;
    private j mRegistryType;
    private Store mStore;

    public a(ProductDetails productdetails, int i, Store store, g g1, j j, RegistryId registryid, boolean flag)
    {
        mProductDetails = productdetails;
        mQuantity = i;
        mStore = store;
        mPickUpItemType = g1;
        mRegistryType = j;
        mRegistryId = registryid;
        mIsAgeRestrictionAcknowledged = flag;
    }

    public a(ProductDetails productdetails, int i, Store store, g g1, boolean flag)
    {
        mProductDetails = productdetails;
        mQuantity = i;
        mStore = store;
        mIsAgeRestrictionAcknowledged = flag;
        mPickUpItemType = g1;
    }

    public a(ProductDetails productdetails, int i, boolean flag)
    {
        mProductDetails = productdetails;
        mQuantity = i;
        mIsAgeRestrictionAcknowledged = flag;
    }

    public ProductDetails a()
    {
        return mProductDetails;
    }

    public int b()
    {
        return mQuantity;
    }

    public Store c()
    {
        return mStore;
    }

    public boolean d()
    {
        return mIsAgeRestrictionAcknowledged;
    }

    public j e()
    {
        return mRegistryType;
    }

    public RegistryId f()
    {
        return mRegistryId;
    }

    public g g()
    {
        return mPickUpItemType;
    }
}
