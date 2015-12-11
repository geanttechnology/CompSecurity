// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash;

import com.amazon.mShop.details.ProductSubscriberBase;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.mash:
//            OfferListingView

class rBase extends ProductSubscriberBase
{

    final OfferListingView this$0;

    public void onError(Exception exception, ServiceCall servicecall)
    {
        OfferListingView.access$200(OfferListingView.this, exception, servicecall);
    }

    public void onProductUpdated()
    {
        OfferListingView.access$100(OfferListingView.this);
    }

    ceCall()
    {
        this$0 = OfferListingView.this;
        super();
    }
}
