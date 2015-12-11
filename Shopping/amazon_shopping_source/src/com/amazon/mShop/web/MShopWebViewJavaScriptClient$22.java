// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;


// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.callbackId
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$callbackId;

    public void run()
    {
        Hcallback.execFailCallback(MShopWebViewJavaScriptClient.access$200(MShopWebViewJavaScriptClient.this), val$callbackId, 1003);
    }

    Hcallback()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$callbackId = String.this;
        super();
    }
}
