// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;


// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient, MShopWebViewContainer

class val.callbackId
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$callbackId;
    final int val$id;

    public void run()
    {
        MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).setBottomButtonOnTouch(val$id, val$callbackId);
    }

    ()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$id = i;
        val$callbackId = String.this;
        super();
    }
}
