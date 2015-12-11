// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.aiv;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.web.MShopWebActivity;
import com.amazon.mobile.mash.constants.WebConstants;

public class AIVGatewayActivity extends MShopWebActivity
{

    public AIVGatewayActivity()
    {
    }

    protected void onResume()
    {
        super.onResume();
        getGNODrawer().focusOn("mshop:aiv");
    }

    protected void processSavedInstanceAndInitWebview(Bundle bundle)
    {
        bundle = getIntent();
        if (TextUtils.isEmpty(bundle.getStringExtra(WebConstants.getWebViewUrlKey())))
        {
            bundle.putExtra(WebConstants.getWebViewUrlKey(), ActivityUtils.getAIVGatewayUrl(this));
        }
        super.processSavedInstanceAndInitWebview(null);
    }
}
