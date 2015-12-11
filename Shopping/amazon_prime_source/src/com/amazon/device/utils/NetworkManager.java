// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.device.utils:
//            NetworkBroadcastReceiver, NetworkListener

public class NetworkManager
{

    private static final List TYPE_WAN_LIST = Arrays.asList(new Integer[] {
        Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(6)
    });
    private static NetworkManager sNetworkManager;
    private final ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private final NetworkBroadcastReceiver mNetworkBroadcastReceiver;
    private final PowerManager mPowerManager;
    private final WifiManager mWifiManager;

    private NetworkManager(Context context)
    {
        mContext = context;
        mConnectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        mWifiManager = (WifiManager)context.getSystemService("wifi");
        mPowerManager = (PowerManager)context.getSystemService("power");
        mNetworkBroadcastReceiver = new NetworkBroadcastReceiver(mContext);
    }

    public static NetworkManager instance(Context context)
    {
        com/amazon/device/utils/NetworkManager;
        JVM INSTR monitorenter ;
        if (sNetworkManager == null)
        {
            sNetworkManager = new NetworkManager(context);
        }
        context = sNetworkManager;
        com/amazon/device/utils/NetworkManager;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private boolean isConnectedToType(NetworkInfo networkinfo, Integer integer)
    {
        return networkinfo != null && networkinfo.isConnected() && integer.intValue() == networkinfo.getType();
    }

    public static void reset()
    {
        com/amazon/device/utils/NetworkManager;
        JVM INSTR monitorenter ;
        sNetworkManager = null;
        com/amazon/device/utils/NetworkManager;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void acquireWakeLock(android.os.PowerManager.WakeLock wakelock)
    {
        if (wakelock != null)
        {
            wakelock.acquire();
        }
    }

    public void acquireWakeLock(android.os.PowerManager.WakeLock wakelock, long l)
    {
        if (wakelock != null && l > 0L)
        {
            wakelock.acquire(l);
            return;
        } else
        {
            acquireWakeLock(wakelock);
            return;
        }
    }

    public void acquireWifiLock(android.net.wifi.WifiManager.WifiLock wifilock)
    {
        if (wifilock != null)
        {
            wifilock.acquire();
        }
    }

    public android.os.PowerManager.WakeLock createWakeLock(String s)
    {
        if (mPowerManager != null)
        {
            return mPowerManager.newWakeLock(1, s);
        } else
        {
            return null;
        }
    }

    public android.net.wifi.WifiManager.WifiLock createWifiLock(String s)
    {
        if (mWifiManager != null)
        {
            return mWifiManager.createWifiLock(3, s);
        } else
        {
            return null;
        }
    }

    public boolean isConnected()
    {
        NetworkInfo networkinfo = mConnectivityManager.getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }

    public boolean isEthernetConnected()
    {
        return isConnectedToType(mConnectivityManager.getActiveNetworkInfo(), Integer.valueOf(9));
    }

    public boolean isWanConnected()
    {
        NetworkInfo networkinfo = mConnectivityManager.getActiveNetworkInfo();
        for (Iterator iterator = TYPE_WAN_LIST.iterator(); iterator.hasNext();)
        {
            if (isConnectedToType(networkinfo, (Integer)iterator.next()))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isWifiConnected()
    {
        return isConnectedToType(mConnectivityManager.getActiveNetworkInfo(), Integer.valueOf(1));
    }

    public void registerNetworkListener(NetworkListener networklistener)
    {
        mNetworkBroadcastReceiver.registerNetworkListener(networklistener);
    }

    public void releaseWakeLock(android.os.PowerManager.WakeLock wakelock)
    {
        if (wakelock != null && wakelock.isHeld())
        {
            wakelock.release();
        }
    }

    public void releaseWifiLock(android.net.wifi.WifiManager.WifiLock wifilock)
    {
        if (wifilock != null && wifilock.isHeld())
        {
            wifilock.release();
        }
    }

    public void unregisterNetworkListener(NetworkListener networklistener)
    {
        mNetworkBroadcastReceiver.unregisterNetworkListener(networklistener);
    }

}
