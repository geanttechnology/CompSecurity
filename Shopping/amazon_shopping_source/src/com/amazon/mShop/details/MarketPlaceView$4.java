// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;


// Referenced classes of package com.amazon.mShop.details:
//            ProductSubscriberBase, MarketPlaceView

class ase extends ProductSubscriberBase
{

    final MarketPlaceView this$0;

    public void onProductUpdated()
    {
        update();
    }

    ase()
    {
        this$0 = MarketPlaceView.this;
        super();
    }
}
