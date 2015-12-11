// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.util.Log;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewContainer, MShopWebView

class this._cls0
    implements Runnable
{

    final MShopWebViewContainer this$0;

    public void run()
    {
        if (MShopWebViewContainer.access$000(MShopWebViewContainer.this) != null && !MShopWebViewContainer.access$000(MShopWebViewContainer.this).isDestroyed())
        {
            if (MShopWebViewContainer.access$100())
            {
                Log.w("MShopWebViewContainer", "spinner removed by watchdog timer");
            }
            hideSpinner();
        }
    }

    ()
    {
        this$0 = MShopWebViewContainer.this;
        super();
    }
}
