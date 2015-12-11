// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.now.mash.NavManager;
import com.amazon.now.util.AppUtils;

// Referenced classes of package com.amazon.now.web:
//            WebActivity, NowWebFragment

public class ShopPastPurchaseActivity extends WebActivity
{

    public ShopPastPurchaseActivity()
    {
    }

    public static void startActivity(Context context)
    {
        startActivity(context, false);
    }

    public static void startActivity(Context context, boolean flag)
    {
        Intent intent = new Intent(context, com/amazon/now/web/ShopPastPurchaseActivity);
        intent.addFlags(0x20000);
        if (flag)
        {
            NavManager.modifyIntentForNewStack(intent);
        }
        context.startActivity(intent);
    }

    protected String getLaunchUrl()
    {
        android.net.Uri.Builder builder = Uri.parse(AppUtils.getServiceUrl(this)).buildUpon();
        builder.appendPath("shop-past-purchases");
        return builder.build().toString();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mWebFragment.loadUrl(getLaunchUrl());
    }
}
