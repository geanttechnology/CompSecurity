// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.photos.device.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.thor.app.BroadcastReceiverUtility;

public class ConnectivityReceiver extends BroadcastReceiver
{

    public ConnectivityReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        BroadcastReceiverUtility.toggleBroadcastReceiver(context.getApplicationContext(), com/amazon/photos/device/receivers/ConnectivityReceiver, false);
    }
}
