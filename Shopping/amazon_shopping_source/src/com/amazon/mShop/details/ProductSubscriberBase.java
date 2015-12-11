// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import com.amazon.mShop.control.item.ProductSubscriber;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;

public class ProductSubscriberBase
    implements ProductSubscriber
{

    private Context context;

    public ProductSubscriberBase()
    {
    }

    public Context getContext()
    {
        return context;
    }

    public void onBrowserAvailableCountChanged()
    {
    }

    public void onCancelled()
    {
    }

    public void onDealBlockUpdated()
    {
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        if (getContext() != null)
        {
            UIUtils.alert(getContext(), exception);
        }
    }

    public void onImageChanged()
    {
    }

    public void onPriceBlockUpdated()
    {
    }

    public void onProductUpdated()
    {
    }

    public void onServiceCallComplete()
    {
    }

    public void onSimilarItemsGalleryUpdated()
    {
    }
}
