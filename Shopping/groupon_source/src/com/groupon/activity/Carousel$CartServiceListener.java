// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.service.DefaultShoppingCartServiceListenerImpl;

// Referenced classes of package com.groupon.activity:
//            Carousel

private class <init> extends DefaultShoppingCartServiceListenerImpl
{

    final Carousel this$0;

    public void onSuccess(ShoppingCartResponse shoppingcartresponse)
    {
        Carousel.access$2400(Carousel.this, getSupportActionBar());
    }

    private se()
    {
        this$0 = Carousel.this;
        super();
    }

    enerImpl(enerImpl enerimpl)
    {
        this();
    }
}
