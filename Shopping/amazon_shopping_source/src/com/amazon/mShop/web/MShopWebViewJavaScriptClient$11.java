// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mShop.util.UIUtils;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.milliSeconds
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final int val$milliSeconds;

    public void run()
    {
        UIUtils.vibrate(MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this), val$milliSeconds);
    }

    ()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$milliSeconds = I.this;
        super();
    }
}
