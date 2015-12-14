// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.utility.ULogUtility;

// Referenced classes of package com.cyberlink.you:
//            a

class astReceiver extends BroadcastReceiver
{

    final a a;

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getExtras() != null)
        {
            context = a;
            boolean flag;
            if (!intent.getBooleanExtra("noConnectivity", false))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            com.cyberlink.you.a.b(context, flag);
            flag = intent.getBooleanExtra("ForceReconnect", false);
            Log.i("ConnectionManager", (new StringBuilder()).append("Connectivity: ").append(com.cyberlink.you.a.b(a)).toString());
            if (!com.cyberlink.you.a.c(a))
            {
                Log.v("ConnectionManager", "!isHeld() do nothing");
            } else
            if (com.cyberlink.you.a.d(a) != null)
            {
                NetworkInfo networkinfo = com.cyberlink.you.a.d(a).getActiveNetworkInfo();
                intent = "";
                context = "";
                if (networkinfo != null)
                {
                    intent = networkinfo.getTypeName();
                    if (intent.equals("WIFI"))
                    {
                        context = com.cyberlink.you.a.e(a).getConnectionInfo().getSSID();
                    } else
                    {
                        context = networkinfo.getSubtypeName();
                    }
                }
                if (com.cyberlink.you.a.b(a))
                {
                    Log.i("ConnectionManager", (new StringBuilder()).append("Type: ").append(intent).toString());
                    Log.i("ConnectionManager", (new StringBuilder()).append("SubType: ").append(context).toString());
                }
                ULogUtility.a((new StringBuilder()).append("Connectivity: ").append(com.cyberlink.you.a.b(a)).toString(), "XMPP Connection");
                if (com.cyberlink.you.a.h())
                {
                    com.cyberlink.you.a.a(false);
                    com.cyberlink.you.a.c(a, com.cyberlink.you.a.b(a));
                    com.cyberlink.you.a.a(a, intent);
                    com.cyberlink.you.a.b(a, context);
                    return;
                }
                if (Boolean.valueOf(flag).booleanValue() || com.cyberlink.you.a.b(a) != com.cyberlink.you.a.f(a) || !intent.equals(com.cyberlink.you.a.g(a)) || !context.equals(com.cyberlink.you.a.h(a)))
                {
                    Log.d("ConnectionManager", "Need Reconnect/Disconnect");
                    ULogUtility.a("Need Reconnect/Disconnect", "XMPP Connection");
                    (new Thread() {

                        final a._cls2 a;

                        public void run()
                        {
                            n.a().e();
                            if (com.cyberlink.you.a.b(a.a))
                            {
                                l.d();
                                com.cyberlink.you.a.d(a.a, false);
                            }
                        }

            
            {
                a = a._cls2.this;
                super();
            }
                    }).start();
                } else
                {
                    Log.i("ConnectionManager", "Don't Need Reconnect");
                }
                com.cyberlink.you.a.c(a, com.cyberlink.you.a.b(a));
                com.cyberlink.you.a.a(a, intent);
                com.cyberlink.you.a.b(a, context);
                return;
            }
        }
    }

    >(a a1)
    {
        a = a1;
        super();
    }
}
