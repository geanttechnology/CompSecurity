// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;


// Referenced classes of package com.amazon.mShop.web:
//            MShopWebActivity, MShopWebViewContainer

class er
    implements Runnable
{

    final MShopWebActivity this$0;
    final MShopWebViewContainer val$container;

    public void run()
    {
        if (MShopWebActivity.access$100(MShopWebActivity.this))
        {
            MShopWebActivity.access$200(MShopWebActivity.this);
            MShopWebActivity.access$102(MShopWebActivity.this, false);
            if (val$container != null)
            {
                val$container.setShouldDelayTransition(false);
            }
        }
    }

    er()
    {
        this$0 = final_mshopwebactivity;
        val$container = MShopWebViewContainer.this;
        super();
    }
}
