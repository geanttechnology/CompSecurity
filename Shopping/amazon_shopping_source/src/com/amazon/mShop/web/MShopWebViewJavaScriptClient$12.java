// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.mash.OfferListingView;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.asin
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$asin;

    public void run()
    {
        OfferListingView.show((AmazonActivity)MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this), val$asin, null, null);
    }

    ()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$asin = String.this;
        super();
    }
}
