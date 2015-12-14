// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            DFPAdUtility

class f extends BroadcastReceiver
{

    final DFPAdUtility a;

    public f(DFPAdUtility dfpadutility)
    {
        a = dfpadutility;
        super();
    }

    public void onReceive(Context context, Intent intent)
    {
        context = ((Context) (Globals.n().getSystemService("connectivity")));
        if (context instanceof ConnectivityManager)
        {
            context = ((ConnectivityManager)context).getActiveNetworkInfo();
            if (context != null && context.isConnected())
            {
                e.c(new Object[] {
                    "NetworkStateReceiver, Network is connected, call loadAd"
                });
                a.a(false);
                return;
            } else
            {
                e.c(new Object[] {
                    "NetworkStateReceiver, Network isn't connected"
                });
                return;
            }
        } else
        {
            e.c(new Object[] {
                "NetworkStateReceiver, Unknown status of network. Do nothing."
            });
            return;
        }
    }
}
