// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;


// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewContainer, MShopWebView

class val.script
    implements Runnable
{

    final MShopWebViewContainer this$0;
    final String val$script;

    public void run()
    {
        if (MShopWebViewContainer.access$000(MShopWebViewContainer.this) != null && !MShopWebViewContainer.access$000(MShopWebViewContainer.this).isDestroyed())
        {
            MShopWebViewContainer.access$000(MShopWebViewContainer.this).loadUrl((new StringBuilder()).append("javascript:").append(val$script).toString());
        }
    }

    ()
    {
        this$0 = final_mshopwebviewcontainer;
        val$script = String.this;
        super();
    }
}
