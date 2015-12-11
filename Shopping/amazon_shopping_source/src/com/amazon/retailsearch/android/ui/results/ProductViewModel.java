// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.searchapp.retailsearch.model.Product;

public class ProductViewModel
{

    private final Product product;
    private final ImageRequestFactory productImageFactory;
    private final ResourceProvider resourceProvider;

    public ProductViewModel(Product product1, ImageRequestFactory imagerequestfactory, ResourceProvider resourceprovider)
    {
        product = product1;
        productImageFactory = imagerequestfactory;
        resourceProvider = resourceprovider;
    }

    public Product getProduct()
    {
        return product;
    }

    public ImageRequestFactory getProductImageFactory()
    {
        return productImageFactory;
    }

    public ResourceProvider getResourceProvider()
    {
        return resourceProvider;
    }
}
