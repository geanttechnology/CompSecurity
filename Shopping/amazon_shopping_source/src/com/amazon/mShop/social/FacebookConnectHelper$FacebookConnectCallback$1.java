// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.social;

import com.amazon.mShop.web.MShopWebView;

// Referenced classes of package com.amazon.mShop.social:
//            FacebookConnectHelper

class val.callbackUrl
    implements Runnable
{

    final val.callbackUrl this$1;
    final String val$callbackUrl;

    public void run()
    {
        cess._mth100(this._cls1.this).loadUrl(val$callbackUrl);
    }

    ()
    {
        this$1 = final_;
        val$callbackUrl = String.this;
        super();
    }
}
