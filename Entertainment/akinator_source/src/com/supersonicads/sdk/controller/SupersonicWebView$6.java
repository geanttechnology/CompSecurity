// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class this._cls0 extends BroadcastReceiver
{

    final SupersonicWebView this$0;

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = false;
        boolean flag1 = false;
        context = (ConnectivityManager)context.getSystemService("connectivity");
        intent = context.getNetworkInfo(1);
        if (intent != null)
        {
            flag = intent.isConnected();
        }
        context = context.getNetworkInfo(0);
        if (context != null)
        {
            flag1 = context.isConnected();
        }
        if (SupersonicWebView.access$1600(SupersonicWebView.this) == com.supersonicads.sdk.data.tate.Ready)
        {
            deviceStatusChanged(flag, flag1);
        }
    }

    ()
    {
        this$0 = SupersonicWebView.this;
        super();
    }
}
