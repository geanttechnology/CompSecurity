// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mShop.cart.web.WebCartActivity;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient, MShopWebViewNotification, NativeAppNotification

class val.cartCount
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final int val$cartCount;

    public void run()
    {
        MShopWebViewNotification.notifyCartCountChanged(val$cartCount);
        if (!(MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this) instanceof WebCartActivity))
        {
            NativeAppNotification.notifyNativeCartChanged(val$cartCount);
        }
    }

    _cls9()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$cartCount = I.this;
        super();
    }
}
