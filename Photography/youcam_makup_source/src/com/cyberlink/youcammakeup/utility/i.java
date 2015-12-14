// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cyberlink.youcammakeup.Globals;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            h

class i extends BroadcastReceiver
{

    private static String a = "NetworkStateReceiver";

    public i()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        context = ((Context) (Globals.d().getSystemService("connectivity")));
        if (context instanceof ConnectivityManager)
        {
            context = ((ConnectivityManager)context).getActiveNetworkInfo();
            if (context != null && context.isConnected())
            {
                m.c(a, "NetworkStateReceiver, Network is connected, call loadAd");
                h.b();
                return;
            } else
            {
                m.c(a, "NetworkStateReceiver, Network isn't connected");
                return;
            }
        } else
        {
            m.c(a, "NetworkStateReceiver, Unknown status of network. Do nothing.");
            return;
        }
    }

}
