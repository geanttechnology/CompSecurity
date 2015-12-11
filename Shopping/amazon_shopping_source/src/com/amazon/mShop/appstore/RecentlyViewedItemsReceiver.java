// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.appstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.mShop.util.ActivityUtils;

public class RecentlyViewedItemsReceiver extends BroadcastReceiver
{

    private final String ASIN_EXTRA = "asin";

    public RecentlyViewedItemsReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        intent = intent.getStringExtra("asin");
        if (intent != null)
        {
            ActivityUtils.logViewHistory(context, intent);
        }
    }
}
