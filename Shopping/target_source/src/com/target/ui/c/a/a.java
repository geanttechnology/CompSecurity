// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.a;

import com.google.a.a.e;
import com.target.mothership.common.a.g;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.helper.product.b;
import com.target.ui.model.product.ProductVariationModel;

public class a
{

    private boolean mHasAcceptedAgeRestriction;
    private b mItemType;
    private ProductDetails mParentProductDetails;
    private g mPickUpItemType;
    private ProductDetails mProductDetails;
    private ProductVariationModel mProductVariationModel;
    private final RegistryDetails mRegistryDetails;
    private Store mStore;

    public a(ProductDetails productdetails, RegistryDetails registrydetails, b b1, ProductVariationModel productvariationmodel, ProductDetails productdetails1)
    {
        mHasAcceptedAgeRestriction = false;
        mProductDetails = productdetails;
        mItemType = b1;
        mProductVariationModel = productvariationmodel;
        mParentProductDetails = productdetails1;
        mRegistryDetails = registrydetails;
    }

    public a(ProductDetails productdetails, b b1, ProductVariationModel productvariationmodel, ProductDetails productdetails1)
    {
        mHasAcceptedAgeRestriction = false;
        mProductDetails = productdetails;
        mItemType = b1;
        mProductVariationModel = productvariationmodel;
        mParentProductDetails = productdetails1;
        mRegistryDetails = null;
    }

    public void a(g g1)
    {
        mPickUpItemType = g1;
    }

    public void a(ProductDetails productdetails)
    {
        mProductDetails = productdetails;
    }

    public void a(Store store)
    {
        mStore = store;
    }

    public void a(ProductVariationModel productvariationmodel)
    {
        mProductVariationModel = productvariationmodel;
    }

    public void a(boolean flag)
    {
        mHasAcceptedAgeRestriction = flag;
    }

    public boolean a()
    {
        return mHasAcceptedAgeRestriction;
    }

    public boolean b()
    {
        return mRegistryDetails != null;
    }

    public b c()
    {
        return mItemType;
    }

    public e d()
    {
        return com.google.a.a.e.c(mParentProductDetails);
    }

    public ProductDetails e()
    {
        return mProductDetails;
    }

    public ProductVariationModel f()
    {
        return mProductVariationModel;
    }

    public e g()
    {
        return com.google.a.a.e.c(mStore);
    }

    public e h()
    {
        return com.google.a.a.e.c(mPickUpItemType);
    }

    public e i()
    {
        return com.google.a.a.e.c(mRegistryDetails);
    }
}
