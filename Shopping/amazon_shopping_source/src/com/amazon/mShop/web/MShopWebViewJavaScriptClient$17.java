// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient, MShopWebView

class this._cls0
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;

    public void run()
    {
        if (MShopWebViewJavaScriptClient.access$200(MShopWebViewJavaScriptClient.this).canGoBack())
        {
            MShopWebViewJavaScriptClient.access$200(MShopWebViewJavaScriptClient.this).goBack();
            return;
        } else
        {
            ((AmazonActivity)MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this)).popView();
            return;
        }
    }

    ()
    {
        this$0 = MShopWebViewJavaScriptClient.this;
        super();
    }
}
