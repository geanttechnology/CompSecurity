// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.net:
//            NetworkDisconnectedException

public class NetInfo
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static final Object sNetworkConnectionMonitor = new Object();
    private static NetworkInfo sNetworkInfo;

    public NetInfo()
    {
    }

    private static void collectNetworkInfoCosting()
    {
        AmazonActivity amazonactivity = AmazonActivity.getTopMostBaseActivity();
        if (amazonactivity != null)
        {
            if (DEBUG)
            {
                Log.e(com/amazon/mShop/net/NetInfo.getSimpleName(), "Network collection network type changed");
            }
            amazonactivity.logTimeWhenNetworkTypeChanged();
        }
    }

    public static NetworkInfo getActiveNetworkInfo()
    {
        Object obj = sNetworkConnectionMonitor;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        if (sNetworkInfo != null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        obj1 = AndroidPlatform.getInstance().getApplicationContext();
        setActiveNetworkInfo(((ConnectivityManager)((Context) (obj1)).getSystemService("connectivity")).getActiveNetworkInfo());
_L2:
        obj1 = sNetworkInfo;
        return ((NetworkInfo) (obj1));
        Object obj2;
        obj2;
        if (!DEBUG) goto _L2; else goto _L1
_L1:
        Log.d("Amazon", ((SecurityException) (obj2)).toString());
          goto _L2
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
    }

    public static final String getCurrentCarrierName()
    {
        String s = "unknown";
        boolean flag = false;
        Object obj1 = AndroidPlatform.getInstance().getApplicationContext();
        Object obj = getActiveNetworkInfo();
        if (obj != null && ((NetworkInfo) (obj)).isConnected())
        {
            boolean flag1 = true;
            flag = flag1;
            if (1 == ((NetworkInfo) (obj)).getType())
            {
                s = "Wifi";
                flag = flag1;
            }
        } else
        {
            Log.d("Amazon", (new StringBuilder()).append("getActiveNetworkInfo: ").append(obj).toString());
        }
        if (flag)
        {
            obj = s;
            if ("unknown".equals(s))
            {
                obj1 = ((TelephonyManager)((Context) (obj1)).getSystemService("phone")).getNetworkOperatorName();
                obj = s;
                if (!Util.isEmpty(((String) (obj1))))
                {
                    obj = obj1;
                }
            }
            return ((String) (obj));
        } else
        {
            return "none";
        }
    }

    public static String getNetworkType()
    {
        String s = "none";
        NetworkInfo networkinfo = getActiveNetworkInfo();
        String s2 = s;
        if (networkinfo != null)
        {
            if (!networkinfo.isConnected())
            {
                s2 = s;
            } else
            {
                int i = networkinfo.getType();
                String s1;
                if (1 == i)
                {
                    s1 = "Wifi";
                } else
                if (i == 0)
                {
                    s1 = networkinfo.getSubtypeName();
                } else
                {
                    s1 = "unknown";
                }
                s2 = s1;
                if (Util.isEmpty(s1))
                {
                    s2 = "unknown";
                }
                s1 = s2;
                if (s2.contains("+"))
                {
                    s1 = s2.replaceAll("\\+", "PLUS");
                }
                s2 = s1;
                if (DEBUG)
                {
                    Log.i(com/amazon/mShop/net/NetInfo.getSimpleName(), (new StringBuilder()).append("Network collection get the network type is ").append(s1).toString());
                    return s1;
                }
            }
        }
        return s2;
    }

    public static boolean hasNetworkConnection()
    {
        NetworkInfo networkinfo = getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }

    private static void setActiveNetworkInfo(NetworkInfo networkinfo)
    {
        Object obj = sNetworkConnectionMonitor;
        obj;
        JVM INSTR monitorenter ;
        sNetworkInfo = networkinfo;
        if (DEBUG)
        {
            Log.d("Amazon", (new StringBuilder()).append("NetworkInfo Changed").append(networkinfo).toString());
        }
        if (networkinfo == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (networkinfo.isConnected())
        {
            sNetworkConnectionMonitor.notifyAll();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        networkinfo;
        obj;
        JVM INSTR monitorexit ;
        throw networkinfo;
    }

    public static void waitForNetworkConnectivity()
        throws NetworkDisconnectedException
    {
        NetworkInfo networkinfo = getActiveNetworkInfo();
        if (networkinfo == null || networkinfo.getState() == android.net.NetworkInfo.State.DISCONNECTED)
        {
            throw new NetworkDisconnectedException();
        }
        Object obj = sNetworkConnectionMonitor;
        obj;
        JVM INSTR monitorenter ;
        if (hasNetworkConnection()) goto _L2; else goto _L1
_L1:
        if (DEBUG)
        {
            Log.v("Amazon", "waitForNetworkConnectivity START");
        }
        sNetworkConnectionMonitor.wait(10000L);
_L4:
        if (DEBUG)
        {
            Log.v("Amazon", "waitForNetworkConnectivity END");
        }
_L2:
        return;
        Object obj1;
        obj1;
        if (!DEBUG) goto _L4; else goto _L3
_L3:
        ((InterruptedException) (obj1)).printStackTrace();
        Log.e("Amazon", ((InterruptedException) (obj1)).toString());
          goto _L4
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    static 
    {
        BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            public void onReceive(Context context, Intent intent)
            {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()))
                {
                    NetInfo.setActiveNetworkInfo(((ConnectivityManager)AndroidPlatform.getInstance().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo());
                    NetInfo.collectNetworkInfoCosting();
                }
            }

        };
        IntentFilter intentfilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        AndroidPlatform.getInstance().getApplicationContext().registerReceiver(broadcastreceiver, intentfilter);
    }


}
