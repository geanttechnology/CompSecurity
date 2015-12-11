// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.ignition.support.http;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.github.ignition.support.http:
//            IgnitedHttp

public class ConnectionChangedBroadcastReceiver extends BroadcastReceiver
{

    private IgnitedHttp http;

    public void onReceive(Context context, Intent intent)
    {
        http.updateProxySettings(context);
    }
}
