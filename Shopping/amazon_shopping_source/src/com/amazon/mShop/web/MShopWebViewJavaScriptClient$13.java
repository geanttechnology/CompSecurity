// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.wishlist.AddToWishlistAction;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.asin
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$asin;

    public void run()
    {
        (new AddToWishlistAction(true)).addItem((AmazonActivity)MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this), val$asin);
        RefMarkerObserver.logRefMarker("dp_buy_wl");
    }

    ()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$asin = String.this;
        super();
    }
}
