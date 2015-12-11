// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;


// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient, MShopWebViewContainer

class val.isEnabled
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final int val$id;
    final boolean val$isEnabled;

    public void run()
    {
        MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).setBottomButtonEnabled(val$id, val$isEnabled);
    }

    _cls9()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$id = i;
        val$isEnabled = Z.this;
        super();
    }
}
