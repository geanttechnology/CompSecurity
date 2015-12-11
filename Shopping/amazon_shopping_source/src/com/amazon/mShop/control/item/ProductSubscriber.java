// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.control.GenericSubscriber;

public interface ProductSubscriber
    extends GenericSubscriber
{

    public abstract void onBrowserAvailableCountChanged();

    public abstract void onCancelled();

    public abstract void onDealBlockUpdated();

    public abstract void onImageChanged();

    public abstract void onPriceBlockUpdated();

    public abstract void onProductUpdated();

    public abstract void onServiceCallComplete();

    public abstract void onSimilarItemsGalleryUpdated();
}
