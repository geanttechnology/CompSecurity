// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.cyberlink.you.a;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;

// Referenced classes of package com.cyberlink.you.gcm:
//            GcmRegService

public class NetworkReceiver extends BroadcastReceiver
{

    private ConnectivityManager a;
    private String b;
    private String c;

    public NetworkReceiver()
    {
        b = "";
        c = "";
        a = (ConnectivityManager)g.I().getApplicationContext().getSystemService("connectivity");
    }

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = false;
        if (intent != null)
        {
            String s = intent.getAction();
            Log.i("NetworkReceiver", (new StringBuilder()).append("onReceive: ").append(s).toString());
            ULogUtility.b((new StringBuilder()).append("onReceive: ").append(s).toString(), "NetworkReceiver");
            if (s.equals("android.net.conn.CONNECTIVITY_CHANGE"))
            {
                com.cyberlink.you.a.a().c();
                if (!intent.getBooleanExtra("noConnectivity", false))
                {
                    flag = true;
                }
                Boolean boolean1 = Boolean.valueOf(flag);
                NetworkInfo networkinfo = a.getActiveNetworkInfo();
                String s1 = "";
                intent = "";
                if (networkinfo != null)
                {
                    s1 = networkinfo.getTypeName();
                    intent = networkinfo.getSubtypeName();
                }
                Log.i("NetworkReceiver", (new StringBuilder()).append("Connected: ").append(boolean1).toString());
                Log.i("NetworkReceiver", (new StringBuilder()).append("Type: ").append(s1).toString());
                Log.i("NetworkReceiver", (new StringBuilder()).append("SubType: ").append(intent).toString());
                ULogUtility.b((new StringBuilder()).append("Connected: ").append(boolean1).append("\n").append("Type: ").append(s1).append("\n").append("SubType: ").append(intent).toString(), "NetworkReceiver");
                if (boolean1.booleanValue())
                {
                    if (!s1.equals(b) || !intent.equals(c))
                    {
                        context.startService(new Intent(context, com/cyberlink/you/gcm/GcmRegService));
                    } else
                    {
                        Log.d("NetworkReceiver", "Duplicate CONNECTIVITY_ACTION ignore");
                        ULogUtility.b("Duplicate CONNECTIVITY_ACTION ignore", "NetworkReceiver");
                    }
                }
                b = s1;
                c = intent;
                return;
            }
        }
    }
}
