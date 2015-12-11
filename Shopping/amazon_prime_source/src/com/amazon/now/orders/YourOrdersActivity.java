// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.orders;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.now.mash.NavManager;
import com.amazon.now.util.AppUtils;
import com.amazon.now.web.NowWebFragment;
import com.amazon.now.web.WebActivity;

public class YourOrdersActivity extends WebActivity
{

    public YourOrdersActivity()
    {
    }

    public static void startActivity(Context context)
    {
        startActivity(context, false);
    }

    public static void startActivity(Context context, boolean flag)
    {
        Intent intent = new Intent(context, com/amazon/now/orders/YourOrdersActivity);
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
        builder.appendPath("yourOrders");
        return builder.build().toString();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        mWebFragment.loadUrl(getLaunchUrl());
    }
}
