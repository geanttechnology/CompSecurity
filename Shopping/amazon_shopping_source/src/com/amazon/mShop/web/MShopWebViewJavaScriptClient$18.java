// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mobile.mash.nav.MASHNavDelegate;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.category
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$category;

    public void run()
    {
        String s = "http://page?app-action=push-notification-settings";
        if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$category))
        {
            s = (new StringBuilder()).append("http://page?app-action=push-notification-settings").append("&category=").append(val$category).toString();
        }
        MShopWebViewJavaScriptClient.access$500(MShopWebViewJavaScriptClient.this).navigate(s, MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this));
    }

    ()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$category = String.this;
        super();
    }
}
