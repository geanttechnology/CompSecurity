// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.Context;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.url
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$imageURL;
    final String val$messageHTML;
    final String val$messagePlain;
    final String val$messagePlain140;
    final String val$messagePlain160;
    final String val$subject;
    final String val$url;

    public void run()
    {
        MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this).startActivity(MShopWebViewJavaScriptClient.access$300(MShopWebViewJavaScriptClient.this, val$messagePlain160, val$messagePlain140, val$messageHTML, val$messagePlain, val$subject, val$imageURL, val$url));
    }

    _cls9()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$messagePlain160 = s;
        val$messagePlain140 = s1;
        val$messageHTML = s2;
        val$messagePlain = s3;
        val$subject = s4;
        val$imageURL = s5;
        val$url = String.this;
        super();
    }
}
