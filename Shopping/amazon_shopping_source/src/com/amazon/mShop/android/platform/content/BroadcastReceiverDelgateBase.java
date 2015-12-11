// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class BroadcastReceiverDelgateBase
{

    protected final BroadcastReceiver mReceiverProxy;

    public BroadcastReceiverDelgateBase(BroadcastReceiver broadcastreceiver)
    {
        mReceiverProxy = broadcastreceiver;
    }

    public BroadcastReceiver getProxy()
    {
        return mReceiverProxy;
    }

    public abstract void onReceive_impl(Context context, Intent intent);
}
