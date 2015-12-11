// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.d;

import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.registries.interfaces.RegistryDetails;
import com.target.mothership.model.registries.interfaces.RegistryProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.view.BitmapImageView;

public interface b
{

    public abstract void a(ProductIdentifier productidentifier, Store store);

    public abstract void a(ProductIdentifier productidentifier, String s, BitmapImageView bitmapimageview, Store store);

    public abstract void a(ProductDetails productdetails, Store store, PageItemHierarchy pageitemhierarchy);

    public abstract void a(ProductDetails productdetails, String s, BitmapImageView bitmapimageview, Store store, PageItemHierarchy pageitemhierarchy);

    public abstract void a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, Store store);

    public abstract void a(RegistryProductDetails registryproductdetails, RegistryDetails registrydetails, String s, BitmapImageView bitmapimageview, Store store);

    public abstract void b(ProductDetails productdetails, Store store, PageItemHierarchy pageitemhierarchy);

    public abstract void b(ProductDetails productdetails, String s, BitmapImageView bitmapimageview, Store store, PageItemHierarchy pageitemhierarchy);
}
