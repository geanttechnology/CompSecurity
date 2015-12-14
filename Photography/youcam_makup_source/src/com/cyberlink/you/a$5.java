// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.cyberlink.you.utility.ULogUtility;
import java.util.Locale;

// Referenced classes of package com.cyberlink.you:
//            a

class astReceiver extends BroadcastReceiver
{

    final a a;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        break MISSING_BLOCK_LABEL_5;
        if (context != null && context.equals("android.net.wifi.supplicant.STATE_CHANGE"))
        {
            intent = (SupplicantState)intent.getParcelableExtra("newState");
            if (intent != null)
            {
                context = intent.toString();
                if (intent == SupplicantState.COMPLETED && com.cyberlink.you.a.e(a) != null)
                {
                    Object obj = com.cyberlink.you.a.e(a).getConnectionInfo();
                    if (obj != null)
                    {
                        intent = ((WifiInfo) (obj)).getSSID();
                        obj = ((WifiInfo) (obj)).getBSSID();
                        if (intent != null && obj != null)
                        {
                            context = (new StringBuilder()).append(context).append(" ").append(intent).append(" ").append(((String) (obj)).toUpperCase(Locale.US)).toString();
                        }
                    }
                }
                ULogUtility.a(context, "WiFi");
                return;
            }
        }
        return;
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
