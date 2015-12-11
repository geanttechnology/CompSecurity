// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.mraid.controller.Network;

public class NetworkBroadcastReceiver extends BroadcastReceiver
{

    private Network a;

    public NetworkBroadcastReceiver(Network network)
    {
        a = network;
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
            a.onConnectionChanged();
        }
    }
}
