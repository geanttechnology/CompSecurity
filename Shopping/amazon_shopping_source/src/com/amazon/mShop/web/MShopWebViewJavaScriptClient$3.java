// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.Context;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.subject
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$messagePlain;
    final String val$subject;

    public void run()
    {
        MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this).startActivity(MShopWebViewJavaScriptClient.access$300(MShopWebViewJavaScriptClient.this, null, null, null, val$messagePlain, val$subject, null, null));
    }

    _cls9()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$messagePlain = s;
        val$subject = String.this;
        super();
    }
}
