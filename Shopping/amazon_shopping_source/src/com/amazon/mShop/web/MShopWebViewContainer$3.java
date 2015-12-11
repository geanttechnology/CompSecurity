// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.view.View;
import com.amazon.mShop.home.web.MShopWebGatewayActivity;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewContainer

class this._cls0
    implements android.view.ainer._cls3
{

    final MShopWebViewContainer this$0;

    public void onClick(View view)
    {
        ActivityUtils.startHomeActivity(view.getContext());
        if (getContext() instanceof MShopWebGatewayActivity)
        {
            MShopWebViewContainer.access$302(MShopWebViewContainer.this, false);
            MShopWebViewContainer.access$200(MShopWebViewContainer.this);
        }
    }

    vity()
    {
        this$0 = MShopWebViewContainer.this;
        super();
    }
}
