// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.d;

import com.google.a.a.e;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.view.BitmapImageView;

public class d
{

    public static final int MODE_PRODUCT = 2;
    public static final int MODE_PRODUCT_ID = 3;
    public static final int MODE_REGISTRY = 1;
    private BitmapImageView mBitmapImageView;
    private String mImageUrl;
    private int mNavigationMode;
    private PageItemHierarchy mPageItemHierarchy;
    private ProductDetails mProductDetails;
    private ProductIdentifier mProductIdentifier;
    private RegistryDetails mRegistryDetails;
    private RegistryProductDetails mRegistryProductDetails;
    private Store mStore;

    public d(ProductIdentifier productidentifier, String s)
    {
        mProductIdentifier = productidentifier;
        mImageUrl = s;
        mNavigationMode = 3;
    }

    public d(ProductDetails productdetails)
    {
        mProductDetails = productdetails;
        mNavigationMode = 2;
    }

    public d(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails)
    {
        mRegistryDetails = registrydetails;
        mRegistryProductDetails = registryproductdetails;
        mNavigationMode = 1;
    }

    public e a()
    {
        return com.google.a.a.e.c(mProductIdentifier);
    }

    public void a(Store store)
    {
        mStore = store;
    }

    public void a(PageItemHierarchy pageitemhierarchy)
    {
        mPageItemHierarchy = pageitemhierarchy;
    }

    public void a(BitmapImageView bitmapimageview)
    {
        mBitmapImageView = bitmapimageview;
    }

    public e b()
    {
        return com.google.a.a.e.c(mProductDetails);
    }

    public e c()
    {
        return com.google.a.a.e.c(mRegistryProductDetails);
    }

    public e d()
    {
        return com.google.a.a.e.c(mRegistryDetails);
    }

    public e e()
    {
        return com.google.a.a.e.c(mStore);
    }

    public e f()
    {
        return com.google.a.a.e.c(mBitmapImageView);
    }

    public e g()
    {
        return com.google.a.a.e.c(mImageUrl);
    }

    public e h()
    {
        return com.google.a.a.e.c(mPageItemHierarchy);
    }

    public int i()
    {
        return mNavigationMode;
    }
}
