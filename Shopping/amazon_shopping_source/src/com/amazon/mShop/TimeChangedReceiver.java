// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.amazon.mShop.control.cart.CartController;

public class TimeChangedReceiver extends BroadcastReceiver
{

    public static final IntentFilter INTENT_FILTER = new IntentFilter("android.intent.action.TIME_SET");

    public TimeChangedReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        context = CartController.getInstance();
        if (context.hasTimedCartItem() && !context.cartIsLoading())
        {
            context.loadCart(null);
        }
    }

}
