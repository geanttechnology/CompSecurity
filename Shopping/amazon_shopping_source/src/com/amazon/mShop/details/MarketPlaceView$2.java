// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceView

class val.amazonActivity
    implements android.view.er
{

    final MarketPlaceView this$0;
    final AmazonActivity val$amazonActivity;

    public void onClick(View view)
    {
        view = val$amazonActivity.getString(com.amazon.mShop.android.lib._safe_buying_guarantee_url);
        String s = val$amazonActivity.getString(com.amazon.mShop.android.lib._safe_buying_guarantee);
        val$amazonActivity.pushView(new AmazonBrandedWebView(val$amazonActivity, view, s));
    }

    ()
    {
        this$0 = final_marketplaceview;
        val$amazonActivity = AmazonActivity.this;
        super();
    }
}
