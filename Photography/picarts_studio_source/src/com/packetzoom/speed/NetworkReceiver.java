// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import java.util.TimeZone;

// Referenced classes of package com.packetzoom.speed:
//            PacketZoomClient, e, Session

public class NetworkReceiver extends BroadcastReceiver
{

    private static final String a_java_lang_String_static_fld = com/packetzoom/speed/NetworkReceiver.getName();
    private int a_int_fld;

    public NetworkReceiver()
    {
        a_int_fld = 8;
    }

    public void onReceive(Context context, Intent intent)
    {
_L2:
        NumberFormatException numberformatexception;
        do
        {
            return;
        } while (isInitialStickyBroadcast() || PacketZoomClient.a == null || !PacketZoomClient.a.isInitOk() || a_int_fld == i);
        e.a(a_java_lang_String_static_fld, (new StringBuilder("network type changed to: ")).append(i).append(" from:").append(a_int_fld).toString());
        PacketZoomClient.a.b();
        a_int_fld = i;
        return;
        Object obj = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        intent = PacketZoomClient.a(context).edit();
        int i;
        if (obj != null && ((NetworkInfo) (obj)).isConnected())
        {
            i = ((NetworkInfo) (obj)).getType();
            intent.putLong("network_type", i);
            intent.putLong("network_subtype", ((NetworkInfo) (obj)).getSubtype());
            intent.putString("timezone", TimeZone.getDefault().getID());
            e.a(a_java_lang_String_static_fld, (new StringBuilder("onReceive networkType:")).append(((NetworkInfo) (obj)).getType()).append(" subtype:").append(((NetworkInfo) (obj)).getSubtype()).toString());
            Object obj1 = (TelephonyManager)context.getSystemService("phone");
            obj = ((TelephonyManager) (obj1)).getNetworkOperatorName();
            context = ((TelephonyManager) (obj1)).getNetworkOperator();
            obj1 = ((TelephonyManager) (obj1)).getNetworkCountryIso();
            if (obj != null && context != null && context.length() > 3)
            {
                e.a(a_java_lang_String_static_fld, (new StringBuilder("onReceive networkOperator:")).append(((String) (obj))).toString());
                try
                {
                    int j = Integer.parseInt(context.substring(0, 3));
                    int k = Integer.parseInt(context.substring(3));
                    StringBuilder stringbuilder = new StringBuilder();
                    stringbuilder.append(((String) (obj1)));
                    stringbuilder.append('-');
                    stringbuilder.append(j);
                    stringbuilder.append('-');
                    stringbuilder.append(k);
                    stringbuilder.append('-');
                    stringbuilder.append(((String) (obj)));
                    intent.putString("carrier_info", stringbuilder.toString());
                }
                // Misplaced declaration of an exception variable
                catch (NumberFormatException numberformatexception)
                {
                    e.a(a_java_lang_String_static_fld, (new StringBuilder("onReceive unable to parse:")).append(context).toString());
                }
            }
            intent.commit();
            break MISSING_BLOCK_LABEL_292;
        }
        intent.putLong("network_type", -1L);
        if (PacketZoomClient.a != null && PacketZoomClient.a.isInitOk())
        {
            e.a(a_java_lang_String_static_fld, "onReceive didLostConnectivity");
            PacketZoomClient.a.didLostConnectivity();
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

}
