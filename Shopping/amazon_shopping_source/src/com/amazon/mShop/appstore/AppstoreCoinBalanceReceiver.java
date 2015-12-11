// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.appstore;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.gno.GNOItemAdapter;

public class AppstoreCoinBalanceReceiver extends BroadcastReceiver
{

    private final String COINS_BALANCE = "coinValue";

    public AppstoreCoinBalanceReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getStringExtra("coinValue");
        GNODrawer.getGNOItemAdapter().setAppstoreCoinsCount(context);
    }
}
